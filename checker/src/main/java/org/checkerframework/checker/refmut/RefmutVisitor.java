package org.checkerframework.checker.refmut;

import com.sun.source.tree.Tree;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeVisitor;
import org.checkerframework.framework.type.AnnotatedTypeMirror.AnnotatedDeclaredType;

public class RefmutVisitor extends BaseTypeVisitor<RefmutAnnotatedTypeFactory> {

    public RefmutVisitor(BaseTypeChecker checker) {
        super(checker);
    }

    @Override
    public boolean isValidUse(
            AnnotatedDeclaredType declarationType, AnnotatedDeclaredType useType, Tree tree) {
        // Need to skip the default check.
        // Because RefMut is the default qualifier, it would assume that
        // all classes are declared RefMut and therefore all uses of such classes
        // must also be RefMut.
        return true;
    }
}
