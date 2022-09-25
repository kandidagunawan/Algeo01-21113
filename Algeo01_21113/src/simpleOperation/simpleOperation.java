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
		
		//PREKONDISI : matrix yang dimasukkan sudah dicek kalo emang ada matrix balikannya
		int rows = matrix.length;
		int cols = matrix[0].length;
		double [][]identitas = new double[rows][cols];
		int []counter = new int[rows];
//		ISI IDENTITAS
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(i == j) {
					identitas[i][j] = 1;
				}
				else {
					identitas[i][j] = 0;
				}
			}
		}
		//		HITUNG BANYAK 0 DI TIAP BARIS
		for(int i = 0; i < rows; i++) {
			int j = 0;
			while(j < cols && matrix[i][j] == 0) {
				counter[i]++;
				j++;
			}
		}
		
		//		TUKAR BARIS BERDASARKAN JUMLAH 0 DI TIAP BARIS
		for(int i = 0; i < rows; i++) {
			if(counter[i] <= i) {
				continue;
			}
			else {
				for(int j = i+1; j < rows; j++) {
					if(counter[i] >= counter[j]) {
						tukarBaris(matrix, i, j);
						tukarBaris(identitas, i, j);
					}
					else {
						continue;
					}
				}
			}
		}
		//		KURANGIN2
		//(GAUSS)
		for(int i = 0; i < rows; i++) {
			int j = 0;
			int tempi = 0;
			while(j < i && tempi < i) {
				double temp1 = matrix[i][j];
				double  temp2 = matrix[tempi][j];
				for(int j1= 0; j1 < cols; j1++) {
					matrix[i][j1] -= (temp1/temp2 * matrix[tempi][j1]);
					identitas[i][j1] -= (temp1/temp2 * identitas[tempi][j1]);
				}
				j++;
				tempi++;
			}
			double pembagi = matrix[i][i];
			if(pembagi != 0) {
				for(int k = 0; k < cols; k++) {
					matrix[i][k] /= pembagi;
					identitas[i][k] /= pembagi;
				}				
			}

		}
		
		for(int i = 0; i < rows; i++) {
			int j = i+1;
			int tempi = i+1;
			while(tempi < rows && j < cols) {
				double temp1 = matrix[i][j];
				double  temp2 = matrix[tempi][j];
				for(int j1= 0; j1 < cols; j1++) {
					matrix[i][j1] -= (temp1/temp2 * matrix[tempi][j1]);
					identitas[i][j1] -= (temp1/temp2 * identitas[tempi][j1]);
				}
				j++;
				tempi++;
			}
		}
		return identitas; 	
				
	
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
