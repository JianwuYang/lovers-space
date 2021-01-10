package top.vikingyang.lovinglambs.entity.admin;

public enum AuthorityEnum {

    ADMIN("管理员"),
    GENERAL("普通用户");

    private final String name;

    private AuthorityEnum(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
