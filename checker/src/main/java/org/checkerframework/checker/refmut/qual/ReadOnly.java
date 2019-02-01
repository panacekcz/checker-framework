package org.checkerframework.checker.refmut.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

/*
These annotations imply read-only methods:

org.checkerframework.dataflow.qual.Pure
org.checkerframework.dataflow.qual.SideEffectFree

Due to limitation of Checker Framework, the same annotation cannot be used
on both types and methods.
 */
@SubtypeOf({})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface ReadOnly {}
