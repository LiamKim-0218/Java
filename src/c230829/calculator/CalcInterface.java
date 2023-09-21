package c230829.calculator;

public interface CalcInterface extends AddInterface, MinusInterface,
									DivideInterface,MultiplyInterface,
									RemainInterface{
	public default int add(int ...nums) {
		int temp = 0;
		for(int num : nums) {
			temp = AddInterface.super.add(temp,num);
		}
		return temp;
	}

	public default int minus(int ...nums) {
		int temp = nums[0];
		for(int i = 1; i<nums.length; i++) {
			temp = MinusInterface.super.minus(temp,nums[i]);
		}
		return temp;
	}
	
	public default int multiply(int ...nums) {
		int temp = nums[0];
		for(int i = 1; i<nums.length; i++) {
			temp = MultiplyInterface.super.multiply(temp,nums[i]);
		}
		return temp;
	}

	public default int divide(int ...nums) {
		int temp = nums[0];
		for(int i = 1; i<nums.length; i++) {
			temp = DivideInterface.super.divide(temp,nums[i]);
		}
		return temp;
	}
	public default int remain(int ...nums) {
		int temp = nums[0];
		for(int i = 1; i<nums.length; i++) {
			temp = RemainInterface.super.remain(temp,nums[i]);
		}
		return temp;
	}


}
