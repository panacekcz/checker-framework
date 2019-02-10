package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.InheritedAnnotation;
import org.checkerframework.framework.qual.SubtypeOf;

@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({ReadOnly.class})
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@InheritedAnnotation
public @interface Tag {
    /** Name of the associated tag parameter */
    String value();
}
