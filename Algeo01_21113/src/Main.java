import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
			outputFile outputFile = new outputFile();
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
//					C:/Users/kandi/Downloads/spl.txt
					matrix = inputFile.inputDetInv();
				}
				System.out.println("Silahkan pilih metode penyelesaian SPL: ");
				System.out.println("1. Metode eliminasi Gauss");
				System.out.println("2. Metode eliminasi Gauss-Jordan");
				System.out.println("3. Metode matriks balikan");
				System.out.println("4. Kaidah cramer");
				int metodeSPL = scanner.nextInt();
				scanner.nextLine();
				String ans = "";
				if(metodeSPL == 1) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)) {
						for(int i = 0; i < spl.SPLGauss1(matrix).length; i++) {
							ans += ("x"+(i+1)+" = "+spl.SPLGauss1(matrix)[i][0]);
							System.out.print("x"+(i+1)+" = "+spl.SPLGauss1(matrix)[i][0]);
							if(i < spl.SPLGauss1(matrix).length-1) {
								System.out.print(", ");
								ans += (", ");
							}
							System.out.println();
							ans += "\n";
						}

						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1 : yes/ 0 : no)");
						int saveFile = scanner.nextInt();
//						System.out.println(saveFile);
						if(saveFile == 1) {
							outputFile.SPLFile(ans);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
						
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tidak memiliki solusi");
					}
					else if(spl.isManySolution(matrix)) {
//						
						String[]output = spl.SPLGauss2(matrix);
						String out= "";
						for(int i = 0; i < output.length; i++) {
							System.out.print("x"+i+ " = "+output[i]);
							out += "x"+i+ " = "+output[i];
							if(i != (output.length -1)) {
								System.out.print(",");
								out += ",";
							}
							
						}
						System.out.println();
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
						int saveFile = scanner.nextInt();
						if(saveFile == 1) {
							outputFile.SPLFile(out);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tidak memiliki solusi");
					}
					
				}
				else if(metodeSPL == 2) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)) {
						for(int i = 0; i < spl.SPLGaussJordan1(matrix).length; i++) {
							ans += ("x"+(i+1)+" = "+spl.SPLGaussJordan1(matrix)[i][0]);
							System.out.print("x"+(i+1)+" = "+spl.SPLGaussJordan1(matrix)[i][0]);
							if(i < spl.SPLGaussJordan1(matrix).length-1) {
								System.out.print(", ");
								ans += (", ");
							}
							System.out.println();
							ans += "\n";
						}
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1 : yes / 0 : no)");
						int saveFile = scanner.nextInt();
//						System.out.println(saveFile);
						while(saveFile != 1 || saveFile != 0) {
							System.out.println("Jawaban anda tidak sesuai format!");
							System.out.println("Apakah anda ingin mendapatkan file hasil output? (y/n)");
							saveFile = scanner.nextInt();
						}
						if(saveFile == 1) {
							outputFile.SPLFile(ans);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tersebut tidak memiliki solusi");
						
					}
					else if(spl.isManySolution(matrix)) {
						String[]output = spl.SPLGaussJordan2(matrix);
						String out= "";
						for(int i = 0; i < output.length; i++) {
							System.out.print("x"+i+ " = "+output[i]);
							out += "x"+i+ " = "+output[i];
							if(i != (output.length -1)) {
								System.out.print(",");
								out += ",";
							}
							
						}
						System.out.println();
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
						int saveFile = scanner.nextInt();
						if(saveFile == 1) {
							outputFile.SPLFile(out);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
				}
				else if(metodeSPL == 3) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)){
						for(int i = 0; i < spl.SPLMatrixBalikan(matrix).length; i++) {
							ans += ("x"+(i+1)+" = "+spl.SPLMatrixBalikan(matrix)[i][0]);
							System.out.print("x"+(i+1)+" = "+spl.SPLMatrixBalikan(matrix)[i][0]);
							if(i < spl.SPLMatrixBalikan(matrix).length-1) {
								System.out.print(", ");
								ans += (", ");
							}
							System.out.println();
							ans += "\n";
						}				
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
						int saveFile = scanner.nextInt();
//						System.out.println(saveFile);
						while(saveFile != 1 && saveFile != 0) {
							System.out.println("Jawaban anda tidak sesuai format!");
							System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
							saveFile = scanner.nextInt();
						}
						if(saveFile == 1) {
							outputFile.SPLFile(ans);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tidak memiliki solusi");
					}
					else if(spl.isManySolution(matrix)){
						System.out.println("SPL tidak bisa diselesaikan dengan matrix balikan");
					}

				}
				else if(metodeSPL == 4) {
					if(!spl.isManySolution(matrix) && !spl.isNoSolution(matrix)){
						for(int i = 0; i < spl.SPLCramer(matrix).length; i++) {
							ans += ("x"+(i+1)+" = "+spl.SPLCramer(matrix)[i][0]);
							System.out.print("x"+(i+1)+" = "+spl.SPLCramer(matrix)[i][0]);
							if(i < spl.SPLCramer(matrix).length-1) {
								System.out.print(", ");
								ans += (", ");
							}
							System.out.println();
							ans += "\n";
						}
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1 : yes/ 0 : no)");
						int saveFile = scanner.nextInt();
//						System.out.println(saveFile);
						while(saveFile != 1 && saveFile != 0) {
							System.out.println("Jawaban anda tidak sesuai format!");
							System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
							saveFile = scanner.nextInt();
						}
						if(saveFile == 1) {
							outputFile.SPLFile(ans);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
					else if(spl.isNoSolution(matrix)) {
						System.out.println("SPL tidak memiliki solusi");
					}
					else if(spl.isManySolution(matrix)){
						System.out.println("SPL tidak bisa diselesaikan dengan metode cramer");
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
					//matrix = new double[inputFile.inputDetInv().length][inputFile.inputDetInv()[0].length];
					matrix = inputFile.inputDetInv();
				}
				System.out.println("Pilih cara menentukan determinan: ");
				System.out.println("1. Metode Gauss Jordan");
				System.out.println("2. Metode Kofaktor");
				int metodeMatrix = scanner.nextInt();
				if(simple.isSquare(matrix)) {
					if(metodeMatrix == 1) {
						double ans = simple.determinanOBE(matrix);
						System.out.println("Nilai determinan matrix : " + ans);
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1 : yes/ 0 : no)");
						int saveFile = scanner.nextInt();
//						System.out.println(saveFile);
						while(saveFile != 1 && saveFile != 0) {
							System.out.println("Jawaban anda tidak sesuai format!");
							System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
							saveFile = scanner.nextInt();
						}
						if(saveFile == 1) {
							outputFile.detFile(ans);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
					else if(metodeMatrix == 2) {
						double ans = simple.determinanKofaktor(matrix);
						System.out.println("Nilai determinan matrix : " + ans);
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1 : yes/ 0 : no)");
						int saveFile = scanner.nextInt();
//						System.out.println(saveFile);
						while(saveFile != 1 && saveFile != 0) {
							System.out.println("Jawaban anda tidak sesuai format!");
							System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
							saveFile = scanner.nextInt();
						}
						if(saveFile == 1) {
							outputFile.detFile(ans);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
					else {
						System.out.println("Anda memilih pilihan yang salah");
					}
				}
				else {
					System.out.println("Matrix tidak punya determinan!");
				}
				
				
			}
			else if(choice == 3) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				int inputType = scanner.nextInt();
				int n = 0;
				scanner.nextLine();
				double matrix[][] = null;
				if(inputType == 1) {
					System.out.println("Silahkan masukkan orde matrix: ");
					n = scanner.nextInt();
					System.out.println("Silahkan masukkan matrix anda: ");
					matrix= new double[n][n];
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							matrix[i][j] = scanner.nextDouble();
						}
					}
				}
//				C:/Users/kandi/Downloads/inverse.txt
				else if(inputType == 2) {
					matrix = inputFile.inputDetInv();
				}

				System.out.println("Pilih cara menentukan invers: ");
				System.out.println("1. Invers dengan Gauss Jordan");
				System.out.println("2. Invers dengan matrix adjoin");
				// INI JANGAN LUPA DIBUAT KONDISI KALO MATRIX GABISA DIINVERSIN
				int metodeMatrix = scanner.nextInt();
				if(simple.isSquare(matrix) && simple.determinanOBE(matrix) != 0) {
					if(metodeMatrix == 1) {
						double[][]ans = new double[n][n];
						ans = simple.inversGaussJordan(matrix);
						simple.printMatrix(ans);
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
						int saveFile = scanner.nextInt();
						if(saveFile == 1) {
							outputFile.invFile(ans);
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
						
					}
					else if(metodeMatrix == 2) {
						simple.printMatrix(simple.inversWithAdjoin(matrix));
						System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
						int saveFile = scanner.nextInt();
						if(saveFile == 1) {
							outputFile.invFile(simple.inversWithAdjoin(matrix));
						}
						else {
							System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
						}
					}
				}

				else {
					System.out.println("Matrix tidak mempunyai invers!");
				}
			}
			else if(choice == 4) {
				System.out.println("Pilih cara input data: ");
				System.out.println("1. Input dari keyboard");
				System.out.println("2. Input dari file");
				double matrix[][] = null;
				double x = 0;
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
						}
					}
					System.out.println("Silahkan masukkan x yang ingin dicari nilai y nya : ");
					x = scanner.nextDouble();
					scanner.nextLine();
				}
				else if(inputType == 2){
					String directory;
					System.out.println("Silahkan masukkan path dari file yang ingin diinputkan: ");
					directory = scanner.nextLine();
					File temp = new File(directory);
					Scanner file;
					Scanner matrixIn;
					int n = 0, m = 0;
					try {
						file = new Scanner(temp);
						Scanner split = new Scanner(file.nextLine());

						m = 1;
						while(file.hasNextLine()) {
							m++;
							file.nextLine();
						}
						matrixIn = new Scanner(temp);
						Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
						matrix = new double[m-1][2];
						for(int i = 0; i < m-1; i++) {
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
//				C:/Users/kandi/Downloads/interpolasi.txt
				interpolasi interpolasi = new interpolasi();
				String ans = interpolasi.fungsiInterpolasi((interpolasi.polinom(matrix)), x);
				System.out.println(ans);
				System.out.println("Apakah anda ingin mendapatkan file hasil output? (1/0)");
				int saveFile = scanner.nextInt();
				if(saveFile == 1) {
					outputFile.interpolateFile(ans);
				}
				else {
					System.out.println("Kamu memilih untuk tidak menyimpan hasil output ke dalam file!");
				}
	

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
//				C:/Users/kandi/Downloads/bicubic.txt
				else if(inputType == 2) {
					String directory;
					System.out.println("Silahkan masukkan path dari file yang ingin diinputkan: ");
					directory = scanner.nextLine();
					File temp = new File(directory);
					Scanner file;
					Scanner matrixIn;
					try {
						matrixIn = new Scanner(temp);
						Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
						matrix = new double[4][4];
						for(int i = 0; i < 4; i++) {
							for(int j = 0; j < 4; j++) {
								matrix[i][j] = splitMatrix.nextDouble();
							}
							if(matrixIn.hasNextLine()) {
								splitMatrix = new Scanner(matrixIn.nextLine());

						}
						}
						if(splitMatrix.hasNextDouble()) {
							x = splitMatrix.nextDouble();
							y = splitMatrix.nextDouble();
						}

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// MASUKIN RUMUS BICUBIC
				bicubic bicubic = new bicubic();
				X = bicubic.buildX();
				double result = bicubic.hasilInterpolasi(x, y, bicubic.koefisien(matrix, X), X);
				System.out.println("f("+x+","+y+") = "+result);
				String ans = "f("+x+","+y+") = "+result;
				System.out.println("Apakah kamu akan menyimpan jawaban dalam bentuk file?(1/0)");
				int saveFile = scanner.nextInt();
				if(saveFile == 1) {
					outputFile.bicubicFile(ans);
				}
				else {	// saveFile tdk
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
					System.out.println("Silahkan masukkan semua data xk dan y yang diketahui: ");
					for(int i = 0; i < m; i++) {
						for(int j  = 0; j < n+1; j++) {
							matrix[i][j] = scanner.nextDouble();
						}
					}
					inputTaksir = new double[n][1];
					for(int i = 0; i < n; i++) {
						inputTaksir[i][0] = scanner.nextDouble();
					}
				}
//				C:/Users/kandi/Downloads/regresi.txt
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
						m = 1;
						n = 0;
						while(split.hasNextDouble()) {
							n++;
							split.nextDouble();
						}
						while(file.hasNextLine()) {
							m++;
							file.nextLine();
						}
						matrixIn = new Scanner(temp);
						Scanner splitMatrix = new Scanner(matrixIn.nextLine());			
						matrix = new double[m-1][n];
						for(int i = 0; i < (m-1); i++) {
							for(int j = 0; j < n; j++) {
								matrix[i][j] = splitMatrix.nextDouble();
							}
							if(matrixIn.hasNextLine()) {
								splitMatrix = new Scanner(matrixIn.nextLine());

							}
						}
						int i = 0;
						inputTaksir = new double[n-1][1];
						while(splitMatrix.hasNextDouble()) {
							inputTaksir[i][0] = splitMatrix.nextDouble();
						}

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}	
				}
				regresiLinier regresi = new regresiLinier();
				koefisien = new double[m][1];
				koefisien = regresi.koefisien(regresi.matrixPersamaan(matrix));
				String ans = regresi.printRegresi(koefisien, inputTaksir);
				System.out.println(ans);
				System.out.println("Apakah kamu akan menyimpan jawaban dalam bentuk file?(1/0)");
				int saveFile = scanner.nextInt();
				if(saveFile == 1) {
					outputFile.regresiFile(ans);
				}
				else {	// saveFile tdk
					System.out.println("Anda memilih untuk tidak menyimpan jawaban dalam bentuk file");
				}
				
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
