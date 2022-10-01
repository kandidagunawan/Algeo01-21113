import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.BufferedReader;
import simpleOperation.*;

import simpleOperation.simpleOperation;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		simpleOperation simple = new simpleOperation();
		
		double matrix[][] = null;
		String directory;
		System.out.println("Silahkan masukkan path dari file yang ingin diinputkan: ");
		//  C:/Users/kandi/Downloads/mat.txt
		directory = scanner.nextLine();
		File temp = new File(directory);
		Scanner file;
		Scanner matrixIn;
		int n = 0, m = 0;
		try {
			file = new Scanner(temp);
			Scanner split = new Scanner(file.nextLine());
			n = 0;
			m = 1;
			while(split.hasNextDouble()) {
				n++;
				//System.out.println(n);
				split.nextDouble();
			}
			while(file.hasNextLine()) {
				m++;
				file.nextLine();
			}
			//System.out.println(m);
			matrixIn = new Scanner(temp);
			Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
			matrix = new double[m][n];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = splitMatrix.nextDouble();
				}
				if(matrixIn.hasNextLine()) {
					splitMatrix = new Scanner(matrixIn.nextLine());

				}
						
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
		
//		outputFile out = new outputFile();
		
		
//		double[][] d = new double[3][3];
//		for(int i = 0; i < 3; i++) {
//			for(int j = 0; j < 3; j++) {
//				d[i][j] = scanner.nextDouble();
//			}
//		}
//		System.out.println();
//		double[][]kofaktor = new double[3][3];
//		double[][]adjoin = new double[3][3];
//		kofaktor = simple.matrixKofaktor(d);
//		simple.printMatrix(kofaktor);
//		adjoin = simple.transpose(kofaktor);
//		simple.printMatrix(adjoin);
//		double determinan = simple.determinanOBE(d);
//		System.out.println(determinan);
//		
//		simple.printMatrix(simple.inversWithAdjoin(d));
//		out.invFile(d);

			
		
	

}
