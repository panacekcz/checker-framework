package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.SubtypeOf;

@DefaultQualifierInHierarchy
@SubtypeOf({ReadOnly.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface RefMut {}
