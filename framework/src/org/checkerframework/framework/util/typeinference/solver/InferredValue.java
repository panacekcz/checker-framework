package org.checkerframework.framework.util.typeinference.solver;

import org.checkerframework.framework.type.AnnotatedTypeMirror;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.type.TypeVariable;
import java.util.*;
import java.util.Map.Entry;

/**
 * When one of the constraint solvers infers that a the target has a given type/target in ALL qualifier hierarchies
 * or that given an additional set of annotations that we know the target must hold we have covered all hierarchies
 * then it creates an InferredValue to represent this inference.
 *
 * There are subclasses to represent two cases:
 *   a) The target was inferred to be an AnnotatedTypeMirror
 *   b) The target was inferred to be equal to another target
 */
public class InferredValue {
    /**
     * Indicates that a corresponding target was inferred to be the field "type" in all hierarchies.
     */
    public static class InferredType extends InferredValue {
        public final AnnotatedTypeMirror type;

        public InferredType(final AnnotatedTypeMirror type) {
            this.type = type;
        }
    }

    /**
     * Indicates that a corresponding target was inferred to be the field "target" in the hierarchies
     * not overridden by additionalAnnotations
     */
    public static class InferredTarget extends InferredValue {
        public final TypeVariable target;
        //if true, this result came from an equality constraint, otherwise it came from the LUB/GLB operations
        //used when inferring from type arguments and assignment contexts.
        public final Set<AnnotationMirror> additionalAnnotations;

        public InferredTarget(final TypeVariable target,
                              final Collection<? extends AnnotationMirror> additionalAnnotations) {
            this.target = target;
            this.additionalAnnotations = new HashSet<>(additionalAnnotations);
        }
    }
}
