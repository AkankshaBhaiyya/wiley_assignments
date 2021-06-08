package com.Assignment;

public class InterfaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Square square=new Square("Black",5,"White",5);
        square.drawingColor();
        square.fillingColor();
        square.size();
        square.thickness();
        Circle circle=new Circle("Black",5,"White",5);
        circle.drawingColor();
        circle.fillingColor();
        circle.size();
        circle.thickness();
        Line line=new Line("Black",5,"White",5);
        line.drawingColor();
        line.fillingColor();
        line.size();
        line.thickness();
	}

}
