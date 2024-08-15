package com.zab.springboot.common.verification;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义日期注解，校验日期
 *
 * @author zab
 * @date 2023/9/10 21:06
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MyConstraintValidator.class})
public @interface MyDateTime {

    int dateOrTime() default 3;

    String message() default "时间格式不正确";

    String format() default "yyyy-MM-dd HH:mm:ss";

    boolean isContainDetail() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
