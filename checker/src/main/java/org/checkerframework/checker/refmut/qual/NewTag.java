package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.InheritedAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@InheritedAnnotation
public @interface NewTag {
    /** Name of the parameter */
    String value();
    /** Upper bound tags */
    String[] bounds() default {};
}
