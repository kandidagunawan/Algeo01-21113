package complexOperation;
import simpleOperation.*;
import java.math.*;

public class interpolasi {
	// input (x1,y1) (x2,y2)...
	// jadiin matriks dulu masukin x ke persamaan
	// cari gauss jordan
	//ketemu jawabannya, masukin yg dicari
	
	
	
	//Membuat persamaan polinomial
	public double[] polinom(double[][]matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] matrixPolinom = new double[row][col];
		int i, j;
		
		for(i = 0; i < row; i++) {
			for(j = 0; j < col; j++) {
				if (j == col-1) {
					matrixPolinom[i][j] = matrix[i][1];
				} else if (j==0) {
					matrixPolinom[i][0] = 1.00;
				} else {
					matrixPolinom[i][j] = Math.pow(matrix[i][0], j);
				}
			}
		}
		
		simpleOperation simple = new simpleOperation();
		double matrixPolinomOBE[][] = simple.gaussJordan(matrixPolinom);
		
		double[] solusiFungsi = new double[row];
		
		for(i = 0; i < row; i++) {
			solusiFungsi[i] = matrixPolinomOBE[i][col-1];
		}
		
		return solusiFungsi;
		
	}
	
	public String fungsiInterpolasi(double[] solusiFungsi, double x) {
		
		double result = 0;
		for(int i = 0; i < solusiFungsi.length; i++) {
			result += solusiFungsi[i] * Math.pow(x, i);
		}
		
		String solusi = "";
		String finalSolusi = "";
		for(int i = 0; i < solusiFungsi.length; i++) {
			if(i == 0) {
				solusi += "f(x) = " + solusiFungsi[i] + "x" + i;
			} else if(i == solusiFungsi.length-1) {
				solusi += solusiFungsi[i] + "x" + i;
			} else {
				solusi += "+" + solusiFungsi[i] + "x" +i;
			}
			return solusi;		
		}
		finalSolusi = solusi + result;
		
		return finalSolusi;
	}
	

}
