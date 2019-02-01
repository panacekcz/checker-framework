package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE})
public @interface WithTag {
    // Name
    String value();
    // Bounds
    String[] bounds() default {};
}
