package c230908.functional;

@FunctionalInterface
public interface PrintTest {
	void print(String name);

	public default int test() {
		return 1;
	}
}