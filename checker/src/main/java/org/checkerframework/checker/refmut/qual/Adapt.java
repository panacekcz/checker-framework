package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@SubtypeOf({ReadOnly.class})
@Target({ElementType.TYPE_USE})
public @interface Adapt {
    String[] value();
}
