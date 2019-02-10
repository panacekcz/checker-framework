package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE})
@SubtypeOf({ReadOnly.class})
public @interface WithTag {
    // Name
    String value();
    // Bounds
    String[] bounds() default {};
}
