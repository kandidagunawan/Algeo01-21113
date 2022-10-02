package complexOperation;

public class regresiLinier {
	SPL spl = new SPL();
	public double[][] matrixPersamaan(double matrix[][]){
		int row = matrix.length;
		int col = matrix[0].length;
		int rowPersamaan = matrix[0].length;
		int colPersamaan = matrix[0].length + 1;
		double[][]persamaan = new double[rowPersamaan][colPersamaan];
		int sampel = matrix.length;
		
		for(int i = 0; i < rowPersamaan; i++) {
			for(int j = 0; j < colPersamaan; j++) {
				persamaan[i][j] = 0;
			}
		}
		persamaan[0][0] = sampel;
		for(int j = 1; j < colPersamaan; j++) {
			for(int k = 0; k < row; k++) {
				persamaan[0][j] += matrix[k][j-1];
			}
		}
		for(int i = 1; i < rowPersamaan; i++) {
			for(int j = 0; j < row; j++) {
				persamaan[i][0] += matrix[j][i-1];
			}
		}
		for(int i = 1; i < rowPersamaan; i++) {
			for(int j = 1; j < colPersamaan; j++) {
				for(int k = 0; k < row; k++) {
					persamaan[i][j] += (matrix[k][i-1] * matrix[k][j-1]);
				}
			}
		}
		return persamaan;
	}
	public double[][]koefisien(double matrix[][]){
		int rows = matrix.length;
		int cols = matrix[0].length;
		double result[][] = new double[rows][1];
		result = spl.SPLGaussJordan1(matrix);
		return result;
	}
	
	public String printRegresi(double koefisien[][], double inputTaksir[][]) {
		int rows = koefisien.length;
		String ans = "f(x) = ";
		for(int i = 0; i < rows; i++) {
			ans += koefisien[i][0];
			if(i > 0) {
				ans += ("x"+i);
			}
			if(i != (rows-1)) {
				ans += (" + ");
			}
		}
		ans += (",");
		double taksiran = 0;
		taksiran += koefisien[0][0];
		for(int i = 0; i < inputTaksir.length; i++) {
			taksiran += (koefisien[i+1][0])*inputTaksir[i][0];
		}
		ans += ("f(xk) = " + taksiran);
		ans += "\n";
		return ans;
	}
	
	
	
}
