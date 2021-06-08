package com.Assignment;

public class MatrixMain {
	public static void main(String args[])
	{
		Matrix matrix1=new Matrix(2,2);
		Matrix matrix2=new Matrix(2,2);
		matrix1.setMat();
		matrix2.setMat();
		Matrix res=Matrix.add(matrix1, matrix2);
		for(int i=0;i<res.getRows();i++)
		{
			for(int j=0;j<res.getCols();j++)
			{
				System.out.print(res.getElement(i,j)+" ");
			}
			System.out.println();
		}
	}

}
