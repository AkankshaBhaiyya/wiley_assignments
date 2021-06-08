package com.Assignment.Exampl;

public class EggMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         CalculateEggs calculateeggs = new CalculateEggs();
         calculateeggs.setTotalNumberOfEggs(1342);
         EggUnit eggunit=calculateeggs.getTotalNumberOfEggsInEggUnit();
         System.out.println("Gross : "+eggunit.getGross());
         System.out.println("Dozen : "+eggunit.getDozen());
         System.out.println("Remain : "+eggunit.getRemain());
         
	}

}
