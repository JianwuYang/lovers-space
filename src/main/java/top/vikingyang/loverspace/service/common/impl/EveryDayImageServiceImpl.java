package top.vikingyang.loverspace.service.common.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import liquibase.pro.packaged.E;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import top.vikingyang.loverspace.entity.common.EveryDayImage;
import top.vikingyang.loverspace.entity.common.enums.EveryDayImageStatusEnum;
import top.vikingyang.loverspace.mapper.common.EveryDayImageMapper;
import top.vikingyang.loverspace.service.common.EveryDayImageService;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;

import static top.vikingyang.loverspace.entity.common.CommonConstant.EVERY_DAY_IMAGE_PREFIX;

@Service
public class EveryDayImageServiceImpl implements EveryDayImageService {

    private final EveryDayImageMapper everyDayImageMapper;

    private final RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(EveryDayImageService.class);

    @Autowired
    public EveryDayImageServiceImpl(EveryDayImageMapper everyDayImageMapper, RestTemplate restTemplate){
        this.everyDayImageMapper = everyDayImageMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return everyDayImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EveryDayImage record) {
        return everyDayImageMapper.insert(record);
    }

    @Override
    public int insertSelective(EveryDayImage record) {
        return everyDayImageMapper.insertSelective(record);
    }

    @Override
    public EveryDayImage selectByPrimaryKey(Long id) {
        return everyDayImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EveryDayImage record) {
        return everyDayImageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(EveryDayImage record) {
        return everyDayImageMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(EveryDayImage record) {
        return everyDayImageMapper.updateByPrimaryKey(record);
    }


    /**
     * 每日图片JSON获取
     * @return 数据
     */
    public EveryDayImage getEveryDayImageJSON(){
        JSONObject result = null;
        EveryDayImage image = new EveryDayImage();
        try{
            result = restTemplate.getForObject("https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1", JSONObject.class);
            if(result == null){
                throw new Exception("image get result null error!");
            }
            if(!result.containsKey("images")){
                throw new Exception("No images response!");
            }
            JSONArray temp = result.getJSONArray("images");
            JSONObject imagesData = temp.getJSONObject(0);
            image.setUrl(imagesData.getString("url"));
            image.setStartDate(imagesData.getString("startdate"));
            image.setCopyright(imagesData.getString("copyright"));
            image.setStatus(EveryDayImageStatusEnum.JSON_GET_SUCCESS);
        }
        catch (Exception e){
            image.setErrorMsg(e.getMessage());
            image.setStatus(EveryDayImageStatusEnum.JSON_GET_ERROR);
            logger.error("image get error", e);
        }
        this.insertSelective(image);
        return image;
    }

    /**
     * 每日图片数据获取
     * @param image 数据
     */
    public EveryDayImage getEveryDayImageData(EveryDayImage image){
        try{
            if(!StringUtils.isEmpty(image.getUrl())){
                ResponseEntity<Resource> result = restTemplate.getForEntity(EVERY_DAY_IMAGE_PREFIX + image.getUrl(), Resource.class);
                if (result.getStatusCode().equals(HttpStatus.OK)) {
                    InputStream is = Objects.requireNonNull(result.getBody()).getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int num = is.read(buffer);
                    while (num != -1) {
                        baos.write(buffer, 0, num);
                        num = is.read(buffer);
                    }
                    baos.flush();
                    image.setImageData(baos.toByteArray());
                }
                else{
                    throw new Exception("HTTP Error: " + result.getStatusCode());
                }
            }
        }
        catch (Exception e){
            image.setStatus(EveryDayImageStatusEnum.IMAGE_GET_ERROR);
            image.setErrorMsg(e.getMessage());
            logger.error("Image get Error:", e);
        }
        this.updateByPrimaryKeySelective(image);
        return image;
    }
}
