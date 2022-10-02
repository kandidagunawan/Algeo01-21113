package complexOperation;
import simpleOperation.*;


public class SPL {
	private boolean uniqueSolutions;
	private boolean manySolutions;
	private boolean noSolution;
	simpleOperation simple = new simpleOperation();
	
	public boolean isNoSolution(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		double matrixOBE[][] = new double[rows][cols];
		matrixOBE = simple.gaussJordan(matrix);
		boolean noSolution = false;
		
		for(int i = 0; i < rows; i++) {
			int count0 = 0;
			for(int j = 0; j < cols; j++) {
				if(matrixOBE[i][j] == 0) {
					count0++;
				}
				if((j == (cols-1)) && (count0 == (cols-1))) {
					noSolution = true;
				}
			}

		}
		return noSolution;
	}
	
	public boolean isManySolution(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		if(cols > rows+1) {
			return true;
		}
		double matrixOBE[][] = new double[rows][cols];
		matrixOBE = simple.gauss(matrix);
		return simple.isBarisNol(matrixOBE);
	}
	
	public double[][] SPLGauss1(double [][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		double matrixOBE[][] = new double[rows][cols];
		matrixOBE = simple.gauss(matrix);

		double solusi[][] = new double[rows][1];
		for(int i = (rows-1); i >= 0; i--) {
			int j = (cols-2);
			double total = matrixOBE[i][cols-1];
			while(j >=  0 && matrixOBE[i][j] != 0) {
				if((j-1 == -1)|| (matrixOBE[i][j-1] == 0)) {
					solusi[i][0] = total / (matrixOBE[i][j]);
				}
				else {
					total -= (solusi[j][0] * matrixOBE[i][j]);
				}
				j--;
			}
		}
		return solusi;
	}
	
	
	public String[] SPLGauss2 (double[][]matrix) {
		String[] alphabet = {"a", "b", "c", "d", "e", "f", 
		        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", 
		        "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		
		double[][] matrixOBE = simple.OBEreduksi(matrix);
		int row = matrix.length;
		int col = matrix[0].length-1;
		
		int countRowZero = 0;
		int countRow =  0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrixOBE[i][j] == 0) {
					countRowZero += 1;
				}
			}
			if (countRowZero == col) {
				countRow += 1;
			}
		}
		
		int count = (col - row)+ countRow;
		
		int[][] tempIndex = new int[row][2];
		double[] tempSolusi = new double[col];
		
		for(int i = 0; i < col; i++) {
			tempSolusi[i] = -999;
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrixOBE[i][j] == 1) {
					tempIndex[i][0] = i;
					tempIndex[i][1] = j;
					break;
				}
			}
		}
		
		double tempD;
		for(int i = row-1; i >= 0; i--) {
			tempD = matrixOBE[i][col];
			for(int j = tempIndex[i][1]; j < col; j++) {
				if(tempSolusi[j] == -999) {
					tempD -= (0*matrixOBE[i][j]);
				} else {
					tempD -= (tempSolusi[j] * matrixOBE[i][j]);
				}
			}
			
			tempSolusi[tempIndex[i][1]] = tempD;
		}
		
		int countZero = 0;
		for(int i = 0; i < col; i++) {
			if(tempSolusi[i] == 0) {
				countZero += 1;
			}
		}
		
		boolean allZero = (countZero == col);
		String[] X = new String[col];
		if(!allZero) {
			for(int i = col-1; i >= 0; i--) {
				if(tempSolusi[i] == -999 && count > 0) {
					X[i] = alphabet[i];
					count -= 1;
				} else if (tempSolusi[i] == -999 && count <= 0) {
					X[i] = "";
				} else {
					X[i] = Double.toString(tempSolusi[i]) + " ";
				}
			}
			
		} else {
			for(int i = col-1; i >= 0; i--) {
				if(count > 0) {
					X[i] = alphabet[i];
					count -= 1;
				} else {
					X[i] = "";
				}
			}
		}
		
		String tempS;
		for(int i = 0; i < row; i++) {
			tempS = X[tempIndex[i][1]];
			for(int j = tempIndex[i][1]; j < col; j++) {
				if(tempSolusi[j] == -999 && matrixOBE[i][j] != 0 && tempIndex[i][1] != j)
					if(matrixOBE[i][j] == 1) {
						tempS += " -" + X[j] + " ";
					} else if (matrixOBE[i][j] == -1) {
						tempS += " +" + X[j] + " ";
					} else if(matrixOBE[i][j] > 0) {
						tempS += " -" + Double.toString(matrixOBE[i][j]) + "*" + X[j] + " ";
					} else {
						tempS += " +" + Double.toString((-1 * matrixOBE[i][j])) + "*" + X[j] + " ";
					}
				}
			X[tempIndex[i][1]] = tempS;
			}
		
		
		for(int i = 0; i < X.length; i++) {
			if(X[i] == "") {
				X[i] = "0.0";
			}
		}
		
		return X;

		
}
		
		
	public double[][] SPLGaussJordan1(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		double[][] matrixGaussJordan = new double[rows][cols];
		matrixGaussJordan = simple.gaussJordan(matrix);
		double[][]solusi = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			solusi[i][0] = matrixGaussJordan[i][cols-1];
		}
//		simple.printMatrix(solusi);
		return solusi;
	}
	
	public String[] SPLGaussJordan2 (double[][]matrix) {
		String[] alphabet = {"a", "b", "c", "d", "e", "f", 
		        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", 
		        "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		
		double[][] matrixOBE = simple.OBEreduksi(matrix);
		int row = matrix.length;
		int col = matrix[0].length-1;
		
		int countRowZero = 0;
		int countRow =  0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrixOBE[i][j] == 0) {
					countRowZero += 1;
				}
			}
			if (countRowZero == col) {
				countRow += 1;
			}
		}
		
		int count = (col - row)+ countRow;
		
		int[][] tempIndex = new int[row][2];
		double[] tempSolusi = new double[col];
		
		for(int i = 0; i < col; i++) {
			tempSolusi[i] = -999;
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrixOBE[i][j] == 1) {
					tempIndex[i][0] = i;
					tempIndex[i][1] = j;
					break;
				}
			}
		}
		
		double tempD;
		for(int i = row-1; i >= 0; i--) {
			tempD = matrixOBE[i][col];
			for(int j = tempIndex[i][1]; j < col; j++) {
				if(tempSolusi[j] == -999) {
					tempD -= (0*matrixOBE[i][j]);
				} else {
					tempD -= (tempSolusi[j] * matrixOBE[i][j]);
				}
			}
			
			tempSolusi[tempIndex[i][1]] = tempD;
		}
		
		int countZero = 0;
		for(int i = 0; i < col; i++) {
			if(tempSolusi[i] == 0) {
				countZero += 1;
			}
		}
		
		boolean allZero = (countZero == col);
		String[] X = new String[col];
		if(!allZero) {
			for(int i = col-1; i >= 0; i--) {
				if(tempSolusi[i] == -999 && count > 0) {
					X[i] = alphabet[i];
					count -= 1;
				} else if (tempSolusi[i] == -999 && count <= 0) {
					X[i] = "";
				} else {
					X[i] = Double.toString(tempSolusi[i]) + " ";
				}
			}
			
		} else {
			for(int i = col-1; i >= 0; i--) {
				if(count > 0) {
					X[i] = alphabet[i];
					count -= 1;
				} else {
					X[i] = "";
				}
			}
		}
		
		String tempS;
		for(int i = 0; i < row; i++) {
			tempS = X[tempIndex[i][1]];
			for(int j = tempIndex[i][1]; j < col; j++) {
				if(tempSolusi[j] == -999 && matrixOBE[i][j] != 0 && tempIndex[i][1] != j)
					if(matrixOBE[i][j] == 1) {
						tempS += " -" + X[j] + " ";
					} else if (matrixOBE[i][j] == -1) {
						tempS += " +" + X[j] + " ";
					} else if(matrixOBE[i][j] > 0) {
						tempS += " -" + Double.toString(matrixOBE[i][j]) + "*" + X[j] + " ";
					} else {
						tempS += " +" + Double.toString((-1 * matrixOBE[i][j])) + "*" + X[j] + " ";
					}
				}
			X[tempIndex[i][1]] = tempS;
			}
		
		
		for(int i = 0; i < X.length; i++) {
			if(X[i] == "") {
				X[i] = "0.0";
			}
		}
		
		return X;
	}

	public double[][] SPLMatrixBalikan(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		double [][]a = new double[rows][cols-1];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < (cols-1); j++) {
				a[i][j] = matrix[i][j];
			}
		}
		double [][]b = new double [rows][1];
		for(int i = 0; i < rows; i++) {
			b[i][0] = matrix[i][cols-1];
		}
		double[][]solusi = new double[rows][1];
		solusi = simple.perkalianDuaMatrix(simple.inversGaussJordan(a), b);
		return solusi;
	}
	
	public double[][] SPLCramer(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		double[][]solusi = new double[rows][1];
		double[][]temp = new double[rows][rows];
		double [][]x = new double[rows][rows];
//		double [][]y = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < rows; j++) {
				x[i][j] = matrix[i][j];
			}
		}

		double d = simple.determinanOBE(x);
		double var;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < rows; j++) {
				for(int k = 0; k < rows; k++) {
					if(k == i) {
						temp[j][k] = matrix[j][cols-1];
					}
					else {
						temp[j][k] = x[j][k];
					}
				}
			}
			var = simple.determinanOBE(temp);
			solusi[i][0] = var/d;
			
		}
		
		
		return solusi;

	}
	public void printSolusi1(double[][]solusi) {
		int rows = solusi.length;
		for(int i = 1; i <= rows; i++) {
			System.out.print("x"+ i + " = "+solusi[i-1][0]);
			if(i != rows) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
		
		
	
}