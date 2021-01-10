package top.vikingyang.lovinglambs.entity.common.enums;

public enum EveryDayImageStatusEnum {

    JSON_GET_ERROR("JSON请求获取失败"),
    JSON_GET_SUCCESS("JSON请求成功"),
    IMAGE_GET_ERROR("图片请求失败"),
    IMAGE_GET_SUCCESS("图片请求成功"),
    SUCCESS("成功");

    private final String name;

    EveryDayImageStatusEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
