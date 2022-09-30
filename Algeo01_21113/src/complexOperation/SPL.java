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
		matrixOBE = simple.gauss(matrix);
		boolean noSolution = true;
		for(int j = 0; j < cols; j++) {
			if(j == (cols-1)) {
				if(matrixOBE[rows-1][j] == 0) {
					noSolution = false;
				}
			}
			else {
				if(matrixOBE[rows-1][cols] != 0) {
					noSolution = false;
					break;
				}
			}

		}
		return noSolution;
	}
	
	public boolean isManySolution(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
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
				if(matrixOBE[i][j-1] == 0 || (j-1 == -1)) {
					solusi[i][0] = total / (matrixOBE[i][j]);
				}
				else {
					total += (solusi[j][0] * matrixOBE[i][j]);
				}
				j--;
			}
		}
		return solusi;
	}
	
	public String SPLGauss2 (double[][]matrix) {
		String result = "";
		
		return result;
	}
		
		
	public double[][] SPLGaussJordan1(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		double[][] matrixGaussJordan = new double[rows][cols];
		double[][]solusi = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			solusi[i][0] = matrixGaussJordan[i][i];
		}
		
		return solusi;
	}
	
	public String SPLGaussJordan2 (double[][]matrix) {
		String result = "";
		
		return result;
	}

	public double[][] SPLMatrixBalikan(double[][]matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		double [][]a = new double[rows][cols-1];
		double [][]b = new double [rows][1];
		double[][]solusi = new double[rows][1];
		solusi = simple.perkalianDuaMatrix(simple.inversWithAdjoin(a), b);
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
		
		
	
}
