package top.vikingyang.loverspace.entity.common;

import top.vikingyang.loverspace.entity.common.enums.EveryDayImageStatusEnum;

import java.io.Serializable;
import java.util.Arrays;

/**
 * everyDayImage
 * @author viking
 */
public class EveryDayImage implements Serializable {
    private Long id;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * url
     */
    private String url;

    /**
     * copyright
     */
    private String copyright;

    /**
     * 状态
     */
    private EveryDayImageStatusEnum status;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 图片数据
     */
    private byte[] imageData;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public EveryDayImageStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EveryDayImageStatusEnum status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EveryDayImage other = (EveryDayImage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getCopyright() == null ? other.getCopyright() == null : this.getCopyright().equals(other.getCopyright()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getErrorMsg() == null ? other.getErrorMsg() == null : this.getErrorMsg().equals(other.getErrorMsg()))
            && (Arrays.equals(this.getImageData(), other.getImageData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getCopyright() == null) ? 0 : getCopyright().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        result = prime * result + (Arrays.hashCode(getImageData()));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", startDate=" + startDate +
                ", url=" + url +
                ", copyright=" + copyright +
                ", status=" + status +
                ", errorMsg=" + errorMsg +
                ", imageData=" + Arrays.toString(imageData) +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}