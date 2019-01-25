package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

/*
These annotations imply read-only methods:

org.checkerframework.dataflow.qual.Pure
org.checkerframework.dataflow.qual.SideEffectFree
 */

@SubtypeOf({RefMut.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER, ElementType.METHOD})
public @interface ReadOnly {}
