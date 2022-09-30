package complexOperation;;
import java.math.*;

public class interpolasi {
	// input (x1,y1) (x2,y2)...
	// jadiin matriks dulu masukin x ke persamaan
	// cari gauss jordan
	//ketemu jawabannya, masukin yg dicari
	
	
	
	//Membuat persamaan polinomial
	public double polinom(double[][]matrix, double x) {
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
		
		double[] solusi;
		solusi = new double[row];
		
		for(i = 0; i < row; i++) {
			solusi[i] = matrixPolinomOBE[i][col-1];
		}
		
		double ans = 0;
		for(i = 0; i < row; i++) {
			ans += solusi[i] * Math.pow(x, i);
		}
		return ans;
	}
	
	public String fungsiInterpolasi(double[] ans) {
		
		String solusi = "";
		String finalSolusi = "";
		for(int i = 0; i < ans.length; i++) {
			if(i == 0) {
				solusi += "f(x) = " + ans[i] + "x" + i;
			} else if(i == ans.length-1) {
				solusi += ans[i] + "x" + i;
			} else {
				solusi += "+" + ans[i] + "x" +i;
			}
			return solusi;		
		}
		finalSolusi = solusi;
		
		return finalSolusi;
	}
	

}
