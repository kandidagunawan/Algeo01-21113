import java.util.Scanner;
import complexOperation.*;
import simpleOperation.*;

//import simpleOperation.simpleOperation;

public class Main {
	public static void main(String[] args) {
//		System.out.println("Hello world Dida!");
	
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Masukkan jumlah baris matrix: ");
//		int rows = scanner.nextInt();
//		System.out.println("Masukkan jumlah kolom matrix: ");
//		int cols = scanner.nextInt();
//		double[][] m = new double[rows][cols];
//
//		System.out.println("Masukkan elemen matrix: ");
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				m[i][j] = scanner.nextInt();
//			}
//		}
		simpleOperation simple = new simpleOperation();
		regresiLinier regresi = new regresiLinier();
//		double [][] matrixGauss = new double[rows][cols];
//		double [][] matrixJordan = new double[rows][cols];
//		double [][] matrixInverse = new double[rows][cols];
//		matrixGauss = simple.gauss(m);
//		System.out.println("Matrix hasil gauss: \n");
//		simple.printMatrix(matrixGauss);
//		System.out.println("Matrix hasil gauss jordan: \n");
//		simple.printMatrix(matrixJordan);
//		matrixInverse = simple.inversGaussJordan(m);
//		double determinan = simple.determinanOBE(m);
//		System.out.println(determinan);
//		double[][]X = new double[16][16];
//		int[][]pasanganxy = new int[16][2];
//		int x = -1;
//		int y = -1;
//		int countx = 0;
//		int county = 0;
//		for(int i = 0; i < 16; i++) {
//			for(int j = 0; j < 2; j++) {
//				if(j == 0) {
//					pasanganxy[i][j] = x;
//					x++;
//					if(x > 2) {
//						x = -1;
//					}	
//				}
//				else {
//					pasanganxy[i][j] = y;
//					county++;
//					if(county == 4) {
//						y++;
//						county = 0;
//					}
//				}
//			}
//
//		}
//		
//		
//		int [][]pasanganij = new int[16][2];
//		int x1 = 0;
//		int y1 = 0;
//		int county1 = 0;
//		for(int i = 0; i < 16; i++) {
//			for(int j = 0; j < 2; j++) {
//				if(j == 0) {
//					pasanganij[i][j] = x1;
//					x1++;
//					if(x1 > 3) {
//						x1 = 0;
//					}
//				}
//				else {
//					pasanganij[i][j] = y1;
//					county1++;
//					if(county1 == 4) {
//						y1++;
//						county1 = 0;
//					}
//				}
//			}
//		}
//
//		for(int i = 0; i < 16; i++) {
//			for(int j = 0; j < 16; j++) {
//				X[i][j] = Math.pow(pasanganxy[i][0], pasanganij[j][0]) * Math.pow(pasanganxy[i][1], pasanganij[j][1]);
//				
//			}
//		}
////		for(int k = 0; k < 16; k++) {
////			for(int l = 0; l < 16; l++) {
////				X[k][l] = Math.pow(k, l);
////			}
////		}
//		
//		for(int i = 0; i < 16; i++) {
//			for(int j = 0; j < 16; j++) {
//				System.out.print(X[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		double[][] test = new double[20][4];
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 4; j++) {
				test[i][j] = scanner.nextDouble();
			}
		}
		simple.printMatrix(regresi.matrixPersamaan(test));
//		

	}

}
