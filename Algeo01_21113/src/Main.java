
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
		double [][] matrix = new double [rows][cols];
		
		System.out.println("Masukkan elemen matrix: ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		simpleOperation simple = new simpleOperation();
//		result = simple.transpose(matrix);
//		simple.printMatrix(result);
//		System.out.println(simple.isIdentity(matrix));
//		
		


	
		
	}
	
}
