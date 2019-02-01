import org.checkerframework.checker.refmut.qual.ReadOnly;
import org.checkerframework.checker.refmut.qual.RefMut;
import org.checkerframework.dataflow.qual.Pure;

public class Defaults {
	// A pure (or side effect free) method
	// - is read-only
	// - has by default read-only parameters
	@Pure CharSequence pure(CharSequence x) {
		return x;
	}
	@Pure @RefMut CharSequence pureRM(@RefMut CharSequence x) {
		return x;
	}
	CharSequence nonPure(CharSequence x) {
		return x;
	}
}