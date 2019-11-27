package cn.pengitong.sunshine.client.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: chen peng
 * @create: 2019-11-11
 *
 * @description:
 **/
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exception(Exception ex) {

        return this.getClass().getSimpleName() + ":" + ex.getMessage();
    }
}
