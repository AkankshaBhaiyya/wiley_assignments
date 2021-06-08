package com.Assignment;

public class Matrix {
	private int rows,cols,mat[][];
	public Matrix(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		mat=new int[rows][cols];
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public int[][] getMat() {
		return mat;
	}
	public void setMat() {
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				mat[i][j]=i+j;
			}
		}
	}
	public int getElement(int r,int c)
	{
		return mat[r][c];
	}
	public void setElement(int r,int c,int ele)
	{
		mat[r][c]=ele;
	}
    public static Matrix add(Matrix matrix1,Matrix matrix2)
    {
    	Matrix result=null;
    	if((matrix1.getRows()== matrix2.getRows()) && (matrix1.getCols()== matrix2.getCols()))
    	{
    		result=new Matrix(matrix1.getRows(),matrix1.getCols());
    		for(int i=0;i<matrix1.getRows();i++){
    			for(int j=0;j<matrix1.getCols();j++)
    			{
    				int sum=matrix1.getElement(i, j) + matrix2.getElement(i,j);
    				result.setElement(i,j,sum);
    			}
    		}
    	}
    	return result;
    }
	
	

}
