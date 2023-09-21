package c230829.calculator;

public interface RemainInterface {
		default int remain(int num1, int num2) {
			return num1 % num2;
		}
}
