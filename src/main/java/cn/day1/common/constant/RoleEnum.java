package cn.day1.common.constant;

/**
 * Description:
 *  身份枚举
 * @author maserhe
 * @date 2022/3/8 10:58 上午
 **/
public enum RoleEnum {

    ADMIN(0 ),
    TEACHER(1 ),
    STUDENT(2);



    private int type;

    RoleEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
