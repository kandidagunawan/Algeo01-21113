package simpleOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class inputFile {
	Scanner scanner = new Scanner(System.in);
	public double[][]inputDetInv(){
		double matrix[][] = null;
		String directory;
		System.out.println("Silahkan masukkan path dari file yang ingin diinputkan: ");
		directory = scanner.nextLine();
		File temp = new File(directory);
		Scanner file;
		Scanner matrixIn;
		try {
			file = new Scanner(temp);
			Scanner split = new Scanner(file.nextLine());
			int n = 0;
			int m = 1;
			while(split.hasNextDouble()) {
				n++;
				split.nextDouble();
				scanner.nextLine();
			}
			while(file.hasNextLine()) {
				m++;
			}
			matrixIn = new Scanner(temp);
			Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
			matrix = new double[m][n];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = splitMatrix.nextDouble();
					scanner.nextLine();
				}
				if(matrixIn.hasNextLine()) {
					splitMatrix = new Scanner(matrixIn.nextLine());

				}
						
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return matrix;
	}
	
	public double[][]inputInterpolasi(){
		double matrix[][] = null;
		
		return matrix;
	}
}
