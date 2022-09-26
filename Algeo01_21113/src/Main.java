
import java.util.Scanner;
import simpleOperation.*;

import simpleOperation.simpleOperation;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world Dida!");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Masukkan jumlah baris matrix: ");
		int rows = scanner.nextInt();
		System.out.println("Masukkan jumlah kolom matrix: ");
		int cols = scanner.nextInt();
		double [][] m = new double [rows][cols];
		
		System.out.println("Masukkan elemen matrix: ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				m[i][j] = scanner.nextInt();
			}
		}
		simpleOperation simple = new simpleOperation();
		double [][] matrixGauss = new double[rows][cols];
//		double [][] matrixJordan = new double[rows][cols];
		double [][] matrixInverse = new double[rows][cols];
//		matrixGauss = simple.gauss(m);
//		System.out.println("Matrix hasil gauss: \n");
//		simple.printMatrix(matrixGauss);
//		System.out.println("Matrix hasil gauss jordan: \n");
//		simple.printMatrix(matrixJordan);
//		matrixInverse = simple.inversGaussJordan(m);
		System.out.println("Matrix hasil invers: ");
		simple.printMatrix(matrixInverse);
//		

	}
	

	
}
