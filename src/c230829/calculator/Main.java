package c230829.calculator;

public class Main {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println(calc.calculate('+',1,2,3,4,10));
		System.out.println(calc.calculate('-',10, 1 , 1));
		System.out.println(calc.calculate('*',10, 32, 1));
		System.out.println(calc.calculate('/', 7, 4));
		System.out.println(calc.calculate('%',35, 60));
	}

}
