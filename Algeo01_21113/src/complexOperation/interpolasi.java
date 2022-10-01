package complexOperation;
import simpleOperation.*;
import java.math.*;

public class interpolasi {
	// input (x1,y1) (x2,y2)...
	// jadiin matriks dulu masukin x ke persamaan
	// cari gauss jordan
	//ketemu jawabannya, masukin yg dicari
	
	
	
	//Membuat persamaan polinomial
	public double[][] polinom(double[][]matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] matrixPolinom = new double[row][row+1];
		int i, j;
		
		for(i = 0; i < row; i++) {
			for(j = 0; j < (row+1); j++) {
				if (j == row) {
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
		double[][] solusiFungsi = new double[row][1];
		
		for(i = 0; i < row; i++) {
			solusiFungsi[i][0] = matrixPolinomOBE[i][row];
		}
		
		return solusiFungsi;
		
	}
	
	public String fungsiInterpolasi(double[][] solusiFungsi, double x) {
		
		double result = 0;
		for(int i = 0; i < solusiFungsi.length; i++) {
			result += solusiFungsi[i][0] * Math.pow(x, i);
		}
		
		String solusi = "";
		System.out.println(solusi);
		String finalSolusi = "";
		for(int i = 0; i < solusiFungsi.length; i++) {
			if(i == 0) {
				solusi = solusi + "f(x) = " + solusiFungsi[i][0];
			} else if(i == 1){
				solusi += "+" + solusiFungsi[i][0] + "x";
			}
			else if(i == solusiFungsi.length-1) {
				solusi = solusi + solusiFungsi[i][0] + "x" + "^" + i;
			}	
			else {
				solusi += "+" + solusiFungsi[i][0] + "x" +  "^" + i;
			}	
		}
		finalSolusi = solusi + ", f(" + x + ") = "+result;
		
		return finalSolusi;
	}
	

}
