package org.checkerframework.checker.index.indexof;

import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.framework.source.SuppressWarningsKeys;

/**
 * An internal checker that assists the Index Checker in typing the results of calls to the JDK's
 * {@link java.lang.String#indexOf(String) String.indexOf} and {@link
 * java.lang.String#lastIndexOf(String) String.lastIndexOf} routines.
 *
 * @checker_framework.manual #index-checker Index Checker
 */
@SuppressWarningsKeys({"index", "indexof"})
public class IndexOfChecker extends BaseTypeChecker {}