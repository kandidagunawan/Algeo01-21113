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
		
		double result[][] = new double[matrix1.length][matrix1[0].length];
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
	
	public double[][]tukerNol(double[][]matrix){
		int i;
		int tempCount;
		int rows = matrix.length;       
		int cols = matrix[0].length;
		int []counter = new int[rows];
		for(i = 0; i < rows; i++) {
			int j = 0;
			while(j < cols && matrix[i][j] == 0) {
				counter[i]++;
				j++;
			}
		}
		
		//		TUKAR BARIS BERDASARKAN JUMLAH 0 DI TIAP BARIS (BUBBLE SORT)
		for(i = 0; i < rows-1; i++) {
			for(int j = 0; j < (rows-i-1); j++) {
				if(counter[j] > counter[j+1]) {
					tukarBaris(matrix, j, j+1);
					tempCount = counter[j+1];
					counter[j+1] = counter[j];
					counter[j] = tempCount;
				}
			}
		}
		
		return matrix;
	}
	
//	ELIMINASI GAUSS & GAUSS JORDAN
	public double[][]gauss(double[][]matrix){
		
		int rows = matrix.length;       
		int cols = matrix[0].length;
		int i;
		
		tukerNol(matrix);
		for (i = 0; i < matrix.length; i++) {
			int temp1 = i; //i= 0, tempi = 0
			int temp2 = i;
			boolean foundnotZero = false;
			
			for (int brs = i; brs < rows; brs++) {
				for (int kol = i; kol < cols; kol++) {
					if(matrix[brs][kol] != 0) {
						foundnotZero = true;    
						temp1 = brs;
						temp2 = kol;
						break;
					}
				}
				if (foundnotZero) {
					break;
				}
			}
			if(!foundnotZero) {
				break;
			}
			
			
			if (temp1 != i) { //switch switch heyyyyyy
				for (int j = 0; j < cols; j++) {
					tukarBaris(matrix, i, j);
				}
				temp1 = i;
		}
			double pembagi = matrix[temp1][temp2];
			for(int j = temp2; j< cols; j++) {
				matrix[i][j] /= pembagi;
			}
			
			for (int brs = i+1; brs < rows; brs++) {
				double c = matrix[brs][temp2];
				for(int kol = temp2; kol < cols; kol++) {
					matrix[brs][kol] -= matrix[temp1][kol] * c;
				}
			}	
		}
		
		tukerNol(matrix);
		return matrix;
	}
	public double[][]gaussJordan(double[][]matrix){
		matrix = gauss(matrix);
		int row = matrix.length;
		int col = matrix[0].length;
		
		int i= 0;
		int j = 0;
		while (i < row && j < col) {
			if (matrix[i][j] == 1) {
				for (int brs = 0; brs < row; brs++) {
					if (brs != i) {
						double c = matrix[brs][j];
						for (int kol = j; kol < col; kol++) {
							matrix[brs][kol] -= matrix[i][kol] * c;
						}
					}
				}
				i++;
			} else {
				j++;
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
				if (i == j) {
					det *= matrix[i][j];
				}
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