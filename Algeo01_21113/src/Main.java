import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.BufferedReader;
import simpleOperation.*;
import complexOperation.*;

//import simpleOperation.simpleOperation;

public class Main {

	public static void main(String[] args) {
		simpleOperation simple = new simpleOperation();
		SPL spl = new SPL();
		Scanner scanner = new Scanner(System.in);

		boolean running = true;
		while(running) {
			inputFile inputFile = new inputFile();
			System.out.println("MENU");
			System.out.println("1. Sistem Persamaan Linier");
			System.out.println("2. Determinan");
			System.out.println("3. Matriks balikan");
			System.out.println("4. Interpolasi Polinom");
			System.out.println("5. Interpolasi Bicubic");
			System.out.println("6. Regresi linier berganda");
			System.out.println("7. Keluar");
			System.out.println("Silahkan pilih menu: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			System.out.println();
			if(choice == 1) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				double matrix[][] = null;
				int inputType = scanner.nextInt();
				scanner.nextLine();
				if(inputType == 1) {
					System.out.println("Masukkan banyak persamaan yang akan diinputkan (m): ");
					int m = scanner.nextInt();
					//scanner.nextLine();
					System.out.println("Masukkan banyak variabel yang dipakai(n): ");
					int n = scanner.nextInt();
					//scanner.nextLine();
					System.out.println("Silahkan masukkan persamaan SPL : ");
//					C:/Users/kandi/Downloads/mat.txt
					matrix = new double[m][n+1];
					for(int i = 0; i < m; i++) {
						for(int j = 0; j < n+1; j++) {
							matrix[i][j] = scanner.nextDouble();
//							scanner.nextLine();
						}
					}
				}
				else if(inputType == 2){
//					C:/Users/kandi/Downloads/mat.txt
					matrix = inputFile.inputDetInv();
					
				}
				System.out.println("Silahkan pilih metode penyelesaian SPL: ");
				System.out.println("1. Metode eliminasi Gauss");
				System.out.println("2. Metode eliminasi Gauss-Jordan");
				System.out.println("3. Metode matriks balikan");
				System.out.println("4. Kaidah cramer");
				int metodeSPL = scanner.nextInt();
				if(metodeSPL == 1) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)) {
						simple.printMatrix(spl.SPLGauss1(matrix));
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
					}
					else if(spl.isManySolution(matrix)) {
//						NANTI DILENGKAPI
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tidak memiliki solusi");
					}
					
				}
				else if(metodeSPL == 2) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)) {
						spl.printSolusi1(spl.SPLGaussJordan1(matrix));
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tersebut tidak memiliki solusi");
						
					}
					else if(spl.isManySolution(matrix)) {
						/////// AYO INI DIKERJAAA!!!
						System.out.println("Solusinya ada banyak!");
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
					}
				}
				else if(metodeSPL == 3) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)){
						spl.printSolusi1(spl.SPLMatrixBalikan(matrix));
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
					}
					else if(spl.isManySolution(matrix)){
						System.out.println("SPL tidak bisa diselesaikan dengan matrix balikan");
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tidak memiliki solusi");
					}
				}
				else if(metodeSPL == 4) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)){
						spl.printSolusi1(spl.SPLCramer(matrix));
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
					}
					else if(spl.isManySolution(matrix)){
						System.out.println("SPL tidak bisa diselesaikan dengan metode cramer");
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tidak memiliki solusi");
					}
				}
				
			}
			else if(choice == 2) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				int inputType = scanner.nextInt();
				scanner.nextLine();
				double matrix[][] = null;
				if(inputType == 1) {
					System.out.println("Silahkan masukkan orde matrix: ");
					int n = scanner.nextInt();
					System.out.println("Silahkan masukkan matrix anda: ");
					matrix = new double[n][n];
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							matrix[i][j] = scanner.nextDouble();
						}
					}
				}
				else if(inputType == 2) {
//					C:/Users/kandi/Downloads/mat.txt
//					matrix = inputFile.inputDetInv();
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
				}
				System.out.println("Pilih cara menentukan determinan: ");
				System.out.println("1. Metode Gauss Jordan");
				System.out.println("2. Metode Kofaktor");
				int metodeMatrix = scanner.nextInt();
				if(metodeMatrix == 1) {
					System.out.println("Nilai determinan matrix : " + simple.determinanOBE(matrix));
					System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
				}
				else if(metodeMatrix == 2) {
					System.out.println("Nilai determinan matrix : " + simple.determinanKofaktor(matrix));
					System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
				}
				else {
					System.out.println("Anda memilih pilihan yang salah");
				}

				
			}
			else if(choice == 3) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				int inputType = scanner.nextInt();
				scanner.nextLine();
				double matrix[][] = null;
				if(inputType == 1) {
					System.out.println("Silahkan masukkan orde matrix: ");
					int n = scanner.nextInt();
					System.out.println("Silahkan masukkan matrix anda: ");
					matrix= new double[n][n];
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							matrix[i][j] = scanner.nextDouble();
						}
					}
				}
//				C:/Users/kandi/Downloads/invers.txt
				else if(inputType == 2) {
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
						while(split.hasNextDouble()) {
							n++;
							split.nextDouble();
						}
						matrixIn = new Scanner(temp);
						Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
						matrix = new double[n][n];
						for(int i = 0; i < n; i++) {
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
				}

				System.out.println("Pilih cara menentukan invers: ");
				System.out.println("1. Invers dengan Gauss Jordan");
				System.out.println("2. Invers dengan matrix adjoin");
				// INI JANGAN LUPA DIBUAT KONDISI KALO MATRIX GABISA DIINVERSIN
				int metodeMatrix = scanner.nextInt();
				if(metodeMatrix == 1) {
					simple.printMatrix(simple.inversGaussJordan(matrix));
					System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
				}
				else if(metodeMatrix == 2) {
					simple.printMatrix(simple.inversWithAdjoin(matrix));
					System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
				}
				else {
					System.out.println("Anda memilih pilihan yang salah");
				}
			}
			else if(choice == 4) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				double matrix[][] = null;
				double x;
				int inputType = scanner.nextInt();
				scanner.nextLine();
				
				if(inputType == 1) {
					System.out.println("Silahkan masukkan banyak titik yang ingin diinterpolasi : ");
					int n = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Silahkan masukkan titik-titik yang diketahui:");
					matrix = new double[n][2];
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < 2; j++) {
							matrix[i][j] = scanner.nextDouble();
							scanner.nextLine();
						}
					}
					System.out.println("Silahkan masukkan x yang ingin dicari nilai y nya : ");
					x = scanner.nextDouble();
					scanner.nextLine();
				}
				else {
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
						while(split.hasNextDouble()) {
							n++;
							split.nextDouble();
						}
						matrixIn = new Scanner(temp);
						Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
						matrix = new double[n][2];
						for(int i = 0; i < n-1; i++) {
							for(int j = 0; j < 2; j++) {
								matrix[i][j] = splitMatrix.nextDouble();
							}
							if(matrixIn.hasNextLine()) {
								splitMatrix = new Scanner(matrixIn.nextLine());
							}			
						}
						x = splitMatrix.nextDouble();

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				interpolasi interpolasi = new interpolasi();
	

				// INI MASUKIN AJ FUNGSI INTERPOLASINYA BUAT NYARI LALLAA
			}
			else if(choice == 5) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				double matrix[][] = null;
				double X[][] = new double[16][16];
				double x = 0, y = 0;
				int inputType = scanner.nextInt();
				scanner.nextLine();
				if(inputType == 1) {
					matrix = new double[4][4];
					System.out.println("Silahkan masukkan matrix 4x4: ");
					for(int i = 0; i < 4; i++) {
						for(int j = 0; j < 4; j++) {
							matrix[i][j] = scanner.nextDouble();
						}
					}
					System.out.println("Silahkkan masukkan titik yang ingin dicari nilainya: ");
					x = scanner.nextDouble();
					y = scanner.nextDouble();
				}
				else if(inputType == 2) {
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
						while(split.hasNextDouble()) {
							n++;
							split.nextDouble();
						}
						matrixIn = new Scanner(temp);
						Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
						matrix = new double[n][n];
						for(int i = 0; i < n; i++) {
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
				}

				// MASUKIN RUMUS BICUBIC
				bicubic bicubic = new bicubic();
				X = bicubic.buildX();
				double result = bicubic.hasilInterpolasi(x, y, matrix, X);
				System.out.println("f("+x+","+y+") = "+result);
				System.out.println("Apakah kamu akan menyimpan jawaban dalam bentuk file?(y/n)");
				String fileNot = scanner.nextLine();
				while(fileNot != "y" || fileNot != "n") {
					System.out.println("Jawaban anda tidak sesuai format!");
					System.out.println("Apakah kamu akan menyimpan jawaban dalam bentuk file?(y/n)");
					fileNot = scanner.nextLine();
				}
				if(fileNot == "y") {
					
				}
				else {	// fileNot == "n"
					System.out.println("Anda memilih untuk tidak menyimpan jawaban dalam bentu file");
				}
				
				
				
			}
			else if(choice == 6) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				double matrix[][] = null;
				int n = 0, m = 0;
				double koefisien[][] = null;
				double inputTaksir[][] = null;
				int inputType = scanner.nextInt();
				scanner.nextLine();
				if(inputType == 1) {
					System.out.println("Silahkan masukkan jumlah peubah x (n): ");
					n = scanner.nextInt();
					System.out.println("Silahkan masukkan jumlah sample (m)");
					m = scanner.nextInt();
					matrix = new double[m][n+1];
					for(int i = 0; i < m; i++) {
						for(int j  = 0; j < n+1; j++) {
							matrix[i][j] = scanner.nextDouble();
							scanner.nextLine();
						}
					}
					inputTaksir = new double[n][1];
					for(int i = 0; i < n; i++) {
						inputTaksir[i][0] = scanner.nextDouble();
						scanner.nextLine();
					}
				}
				else if(inputType == 2) {
					
				}
				regresiLinier regresi = new regresiLinier();
				koefisien = new double[m][1];
				koefisien = regresi.koefisien(matrix);
				regresi.printRegresi(koefisien, inputTaksir);
				

				
			}
			else if(choice == 7) {
				running = false;
				System.out.println("Sampai jumpa lagi");
			}
			else {
				System.out.println("Menu yang anda pilih tidak ada");
			}
		}




	}

}
