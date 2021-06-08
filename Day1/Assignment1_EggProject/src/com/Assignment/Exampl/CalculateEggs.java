package com.Assignment.Exampl;

public class CalculateEggs {
	private int totalNumberOfEggs;
	private EggUnit totalNumberOfEggsInEggUnit;
	public void setTotalNumberOfEggs(int totalNumberOfEggs) {
		this.totalNumberOfEggs = totalNumberOfEggs;
	}
	
	

	public EggUnit getTotalNumberOfEggsInEggUnit() {
		int gross,dozen,remain,temp;
		gross = totalNumberOfEggs / 144;
		temp = totalNumberOfEggs % 144;
		dozen = temp / 12;
		remain= temp % 12;
		return new EggUnit(gross,dozen,remain);
	}

}
