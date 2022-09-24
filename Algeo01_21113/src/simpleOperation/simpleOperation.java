package simpleOperation;

public class simpleOperation {
	
	public void printMatrix(double [][]matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	// CEK MATRIX
	public boolean isIdentity(double [][] matrix) {
		if(isSquare(matrix)) {
			int n = matrix.length;
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix.length; j++) {
					if(i==j) {
						if(matrix[i][j] != 1) {
							return false;
						}
					}
					else {
						if(matrix[i][j] != 0) {
							return false;
						}
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean isSquare(double [][] matrix) {
		return true; // ini gw isi true supaya ga error aj di eclipsenya, nanti realisasi sendiri y
	}
	
	
	// OPERASI SEDERHANA PADA MATRIX
	public double[][]plusMinMatrix(double[][]matrix1, double[][]matrix2){
		double[][]result = null;
		return result;
	}
	public double[][] perkalianDuaMatrix(double[][]matrix1, double[][]matrix2){
		double[][]result = null;
		return result;
	}
	public double [][] perkalianMatrixConst(double[][]matrix, double d){
		double[][] result = null;
		return result;
	}
	
	public double[][]transpose(double[][]matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;	
		double [][] result = new double [cols][rows];

		for (int i = 0; i < cols; i++) {
			for(int j = 0; j < rows; j++) {
				result[i][j] = matrix[j][i];
			}
		}
		return result;
	}
	
	public double[][]matrixKofaktor(double[][]matrix){
		double [][] result = null;
		return result;
	}
	
//	ELIMINASI GAUSS & GAUSS JORDAN
	public double[][]gauss(double[][]matrix){
		double[][] result = null;
		return result;
	}
	public double[][]gaussJordan(double[][]matrix){
		double[][]result = null;
		return result;
	}
	
	
//	DETERMINAN MATRIX
	
	// Determinan matrix dengan reduksi baris OBE
	public double determinanOBE(double[][]matrix) {
		double result = 0;
		return result;
	}
	
	//Determinan matrix dengan ekspansi kofaktor
	public double determinanKofaktor(double[][]matrix) {
		double result = 0;
		return result;
	}
	
// INVERS MATRIX
	
	//	Matrix invers dengan gauss jordan
	public double[][]inversGaussJordan(double[][]matrix){
		double [][]result = null;
		return result;
	}
	
	//	Matrix invers dengan adjoin
	public double[][]inversWithAdjoin(double[][]matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		double[][]kofaktor = new double[rows][cols];
		double [][]adjoin = new double[cols][rows];
		double[][]invers = new double[cols][rows];
		double determinan = determinanOBE(matrix);
		kofaktor = matrixKofaktor(matrix);
		adjoin = transpose(kofaktor);
		invers = perkalianMatrixConst(adjoin, (1/determinan));
		return invers;
		
	}

	


	
	
	
	
	
}
