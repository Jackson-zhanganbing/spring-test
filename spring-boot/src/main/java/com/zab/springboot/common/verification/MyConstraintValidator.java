package com.zab.springboot.common.verification;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义校验
 *
 * @author zab
 * @date 2023/9/10 20:34
 */
@Component
@Data
public class MyConstraintValidator implements ConstraintValidator<MyDateTime, String> {

    private int dataOrTime;

    private String message;
    private String formatPattern;
    private boolean containDetail;

    @Override
    public void initialize(MyDateTime constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().length() == 0) {
            /* 值不能为空 */
            return false;
        } else {
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern(formatPattern);
                if (dataOrTime == 1) {
                    /* 表示为日期 */
                    LocalDate date = LocalDate.parse(value, format);
                } else if (dataOrTime == 2) {
                    /* 表示为时间 */
                    LocalTime time = LocalTime.parse(value, format);
                } else {
                    /* 表示为日期和时间 */
                    LocalDateTime dateTime = LocalDateTime.parse(value, format);
                }
            } catch (IllegalArgumentException e) {
                if (containDetail) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(message + " : " + e.getMessage()).addConstraintViolation();
                    return false;
                }
            } catch (Exception e) {
                if (containDetail) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(message + " : " + e.getMessage()).addConstraintViolation();
                    return false;
                }
            }
        }
        return true;
    }
}
