package cn.day1.common.constant;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/5/22 16:09
 **/
public enum StateEnum {

    NORAMAL(0 ),
    DISABLE(1 ),
    FAULT(2);



    private int type;

    StateEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
