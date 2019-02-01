package org.checkerframework.checker.refmut;

import com.sun.source.tree.MethodTree;
import javax.lang.model.element.AnnotationMirror;
import org.checkerframework.checker.refmut.qual.ReadOnly;
import org.checkerframework.checker.refmut.qual.RefMut;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.util.PurityUtils;
import org.checkerframework.framework.type.AnnotatedTypeMirror;
import org.checkerframework.framework.type.treeannotator.ListTreeAnnotator;
import org.checkerframework.framework.type.treeannotator.TreeAnnotator;
import org.checkerframework.framework.type.typeannotator.ListTypeAnnotator;
import org.checkerframework.framework.type.typeannotator.TypeAnnotator;
import org.checkerframework.javacutil.AnnotationBuilder;

public class RefmutAnnotatedTypeFactory extends BaseAnnotatedTypeFactory {

    public final AnnotationMirror REFMUT, READONLY;
    public final AnnotationMirror SIDEEFFECTFREE, PURE;

    private final boolean isDebug = true;

    public RefmutAnnotatedTypeFactory(BaseTypeChecker checker) {
        super(checker);
        REFMUT = AnnotationBuilder.fromClass(elements, RefMut.class);
        READONLY = AnnotationBuilder.fromClass(elements, ReadOnly.class);
        SIDEEFFECTFREE = AnnotationBuilder.fromClass(elements, SideEffectFree.class);
        PURE = AnnotationBuilder.fromClass(elements, Pure.class);

        this.postInit();
    }

    void debugPrint(String msg) {
        if (isDebug) System.out.println(msg);
    }

    void debugPrint(String fmt, Object... args) {
        if (isDebug) System.out.printf(fmt + "%n", args);
    }

    @Override
    public TypeAnnotator createTypeAnnotator() {
        return new ListTypeAnnotator(new RefmutTypeAnnotator(this), super.createTypeAnnotator());
    }

    protected class RefmutTypeAnnotator extends TypeAnnotator {
        public RefmutTypeAnnotator(RefmutAnnotatedTypeFactory atypeFactory) {
            super(atypeFactory);
        }
    }

    @Override
    public TreeAnnotator createTreeAnnotator() {
        return new ListTreeAnnotator(new RefmutTreeAnnotator(this), super.createTreeAnnotator());
    }

    protected class RefmutTreeAnnotator extends TreeAnnotator {

        public RefmutTreeAnnotator(RefmutAnnotatedTypeFactory factory) {
            super(factory);
        }

        @Override
        public Void visitMethod(MethodTree node, AnnotatedTypeMirror p) {
            if (PurityUtils.isSideEffectFree(atypeFactory, node)) {
                debugPrint("Making result and parameters of Side effect free method ReadOnly");

                AnnotatedTypeMirror.AnnotatedExecutableType methType =
                        (AnnotatedTypeMirror.AnnotatedExecutableType) p;

                AnnotatedTypeMirror result = methType.getReturnType();
                makeDefaultReadOnly(result);

                for (AnnotatedTypeMirror param : methType.getParameterTypes()) {
                    makeDefaultReadOnly(param);
                }
            }
            return super.visitMethod(node, p);
        }
    }

    private void makeDefaultReadOnly(AnnotatedTypeMirror atm) {
        AnnotationMirror existing = atm.getAnnotationInHierarchy(READONLY);
        if (existing == null) {
            atm.addAnnotation(READONLY);
        }
    }
}
