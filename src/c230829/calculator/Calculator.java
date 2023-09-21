package c230829.calculator;

public class Calculator implements CalcInterface {
	public int calculate(char operator, int ...nums) {
		switch(operator) {
			case '+':
				return CalcInterface.super.add(nums);
			case '-':
				return CalcInterface.super.minus(nums);
			case '*':
				return CalcInterface.super.multiply(nums);
			case '/':
				return CalcInterface.super.divide(nums);
			case '%':
				return CalcInterface.super.remain(nums);
			
			default:
				return 0;
		}
	}
	
	public int calculate(String formula) {
		return 0;
	}
}
