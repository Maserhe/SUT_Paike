package cn.day1.common.exception;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/3/8 10:18 上午
 **/
public class CustomUnauthorizedException extends RuntimeException {

    public CustomUnauthorizedException(String msg){
        super(msg);
    }

    public CustomUnauthorizedException() {
        super();
    }
}
