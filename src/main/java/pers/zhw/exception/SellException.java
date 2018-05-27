package pers.zhw.exception;

import pers.zhw.enums.ResultEnum;

public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public SellException(ResultEnum resultEnum,String msg){
        super(msg);
        this.code = resultEnum.getCode();
    }
}
