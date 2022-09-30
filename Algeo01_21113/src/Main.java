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
		simpleOperation simple = new simpleOperation();
		outputFile out = new outputFile();
		Scanner scanner = new Scanner(System.in);
		double[][] d = new double[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				d[i][j] = scanner.nextDouble();
			}
		}
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
		out.invFile(d);
		
		
		
	}

}
