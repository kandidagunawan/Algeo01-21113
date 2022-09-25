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
	
	public double [][]tukarBaris(double[][] matrix, int baris1, int baris2){
		double temp;
		for(int j = 0; j < matrix[0].length; j++) {
			temp = matrix[baris1][j];
			matrix[baris1][j] = matrix[baris2][j];
			matrix[baris2][j] = temp;
		}
		return matrix;
	}
	
	
	// CEK MATRIX
	
	
	// CEK apakah ada baris yang isinya nol semua
	public boolean isBarisNol(double[][]matrix) {
			boolean nol = true;
			for(int i = 0; i < matrix.length; i++) {
				nol = true;
				for(int j = 0; j < matrix[0].length; j++) {
					if(matrix[i][j] != 0) {
						nol = false;
						break;
					}
				}
			}
			return nol;
	}
	
	// CEK apakah ada kolom yang isinya nol semua
	public boolean isKolomNol(double[][]matrix) {
			boolean nol = true;
			for(int j = 0; j < matrix[0].length; j++) {
				nol = true;
				for(int i = 0; i < matrix.length; i++) {
					if(matrix[i][j] != 0) {
						nol = false;
						break;
					}
				}
			}
			return nol;
	}
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
		
		double result[][] = null;
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix1.length; j++) {
				result[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
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
		
		int rows = matrix.length;       
		int cols = matrix[0].length;
		double[][] result = null;
		double[] counter = null;
		
		for(int i = 0; i < rows; i++) {
			int j = 0;
			while(j < cols && matrix[i][j] == 0) { //hitung berapa banyak 0
				counter[i]++;
				j++;
			}
		}
		
		for (int i = 0; i < rows; i++) {  // 0 1 0  1  2 3  4  5 6
			if (counter[i] <= i) {
				continue;
			}
			else {
				for(int j = i+1; j < rows; j++) {
					if (counter[i] >= counter[j]) {
						tukarBaris(matrix, i, j); // counter[0] == 2 
					} else {
						continue;
					}
				}
			}
		}
		
		
		for (int i = 0; i < rows; i++) {
			int j = 0;
			int tempi = 0;
			
			while (j < i && tempi < i) {
				double temp1 = matrix[i][j];  //matrix[0][0]
				double temp2 = matrix[tempi][j];
				for(int j1 = 0; j1 < cols; j1++) {
					matrix[i][j] -= (temp1/temp2 * matrix[tempi][j]);
				}
				j++;
				tempi++;
			}
			double pembagi = matrix[i][i];
			if(pembagi != 0) {
				for(int k = 0; k < cols; k++) {
					matrix[i][k] /= pembagi;
				}
			}
		}
		

		return matrix;
	}
	public double[][]gaussJordan(double[][]matrix){
		matrix = gauss(matrix);
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 1) {
					for (int nBrs = 0; nBrs < row; nBrs++) {
						if(nBrs != i) {
							double temp1 = matrix[nBrs][j];
							for(int nKol = j; nKol < col; nKol++) {
								matrix[nBrs][nKol] -= (matrix[i][nKol] * temp1);
							}
						}
					}
				}
			}
		}
		return matrix;
	}
	
	
//	DETERMINAN MATRIX
	
	// Determinan matrix dengan reduksi baris OBE
	public double determinanOBE(double[][]matrix) {
		matrix = gauss(matrix);
		double det = 1.0;
		int row = matrix.length;
		int col = matrix.length;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++)
				det *= matrix[i][j];
		}
		
		return det;
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