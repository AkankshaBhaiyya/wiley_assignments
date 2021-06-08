package com.Assignment.Exampl;

public class EggUnit {
  public EggUnit(int gross, int dozen, int remain) {
		super();
		this.gross = gross;
		this.dozen = dozen;
		this.remain = remain;
	}

private int gross,dozen,remain;

public int getGross() {
	
	return gross;
}

public void setGross(int gross) {
	this.gross = gross;
}

public int getDozen() {
	return dozen;
}

public void setDozen(int dozen) {
	this.dozen = dozen;
}

public int getRemain() {
	return remain;
}

public void setRemain(int remain) {
	this.remain = remain;
}
  
} 
