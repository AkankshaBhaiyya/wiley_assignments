package com.Assignment;

public class Square implements Fillable,Drawable{
	private String drawingColor,fillingColor;
	private int size,thickness;
	Square(String drawingColor,int thickness,String fillingColor,int size)
	{
		this.drawingColor=drawingColor;
		this.thickness=thickness;
		this.fillingColor=fillingColor;
		this.size=size;
	}
	public void drawingColor()
	{
		System.out.println("Drawing Color : "+getDrawingColor());
	}
	public void thickness()
	{
		System.out.println("Thickness : "+getThickness());
	}
    public void size()
    {
    	System.out.println("Size : "+getSize());
    }
    public void fillingColor()
    {
    	System.out.println("filling Color : "+getFillingColor());
    }
	protected String getDrawingColor() {
		return drawingColor;
	}
	protected void setDrawingColor(String drawingColor) {
		this.drawingColor = drawingColor;
	}
	protected String getFillingColor() {
		return fillingColor;
	}
	protected void setFillingColor(String fillingColor) {
		this.fillingColor = fillingColor;
	}
	protected int getSize() {
		return size;
	}
	protected void setSize(int size) {
		this.size = size;
	}
	protected int getThickness() {
		return thickness;
	}
	protected void setThickness(int thickness) {
		this.thickness = thickness;
	}
}
