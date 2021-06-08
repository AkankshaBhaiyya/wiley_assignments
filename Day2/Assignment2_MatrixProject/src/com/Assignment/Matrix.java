package com.Assignment;

public class Matrix {
	int[][] mat;
	Matrix(int rows,int cols)
	{
		mat=new int[rows][cols];
	}
	public int[][] getMat() {
		return mat;
	}
	public void setMat(){
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				mat[i][j]=i+1;
			}
		}
	}
	
  
}
