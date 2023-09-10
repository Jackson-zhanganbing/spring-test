package com.zab.springboot.exception;

import com.zab.springboot.common.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * 全局异常拦截
 *
 * @author zab
 * @date 2021-12-03 23:45
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseVo<String> handleException(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("url {}, msg {}", request.getRequestURL(), e.getMessage());

        ResponseVo<String> responseVo = new ResponseVo<>();
        responseVo.setCode("500").setData(request.getRequestURL()+"    --->    "+e.getMessage()).setMessage("系统异常");
        return responseVo;
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseVo<String> handleException(MethodArgumentNotValidException e) {

        ResponseVo<String> responseVo = new ResponseVo<>();
        responseVo.setCode("500").setData(e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)).toString()).setMessage("系统异常");
        return responseVo;
    }
}
