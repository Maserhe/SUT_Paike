package cn.day1.common.exception;

/**
 * Description:
 *
 * @author maserhe
 * @date 2022/3/8 9:10 上午
 **/
public class CustomException extends RuntimeException {

    public CustomException(String msg){
        super(msg);
    }

    public CustomException() {
        super();
    }
}