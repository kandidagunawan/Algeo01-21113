package complexOperation;
import simpleOperation.*;


public class SPL {
	private boolean uniqueSolutions;
	private boolean manySolutions;
	private boolean noSolution;
	simpleOperation simple = new simpleOperation();
	
	
	public String SPLGauss(double [][] matrix){
		String result = "";
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		double matrixOBE[][] = new double[rows][cols];
		matrixOBE = simple.gauss(matrix);
		manySolutions = simple.isBarisNol(matrixOBE);
		noSolution = true;
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
		uniqueSolutions = !(manySolutions || noSolution);
		if(uniqueSolutions) {
			double solusi[] = new double[rows];
			for(int i = (rows-1); i >= 0; i--) {
				int j = (cols-2);
				double total = matrixOBE[i][cols-1];
				while(j >=  0 && matrixOBE[i][j] != 0) {
					if(matrixOBE[i][j-1] == 0 || (j-1 == -1)) {
						solusi[i] = total / (matrixOBE[i][j]);
					}
					else {
						total += (solusi[j] * matrixOBE[i][j]);
					}
					j--;
				}
			}
			for(int i = 0; i < rows; i++) {
				if(i != (rows-1)) {
					result += ("x" + (i+1) + " = " + solusi[i]+ ", ");
				}
				else {
					result += ("x" + (i+1) + " = " + solusi[i]);
				}
			}
		}
		
		
		else if(noSolution) {
			result = "Tidak ada solusi SPL yang memenuhi \n";
		}
		else { //manySolutions
			
		}
		
		
		
		
		return result;
		
	}
}
