package com.wen.security.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author cxhc
 *  target  声明可以标注的位置
 */

//表示该注解可以放在方法或者字段上面
@Target({ElementType.METHOD,ElementType.FIELD})
//这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用
@Retention(RetentionPolicy.RUNTIME)
//之命校验的类
@Constraint(validatedBy=MyConstraintValidator.class)
public @interface MyConstraint {
	String message() default "{哈哈你错了}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
