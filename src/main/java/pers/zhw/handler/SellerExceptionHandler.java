package pers.zhw.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.zhw.VO.ResultVO;
import pers.zhw.config.ProjectUrlConfig;
import pers.zhw.exception.SellException;
import pers.zhw.exception.SellerAuthorizeException;
import pers.zhw.utils.ResultVOUtil;

@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/login");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
