package complexOperation;

public class regresiLinier {
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
	
}
