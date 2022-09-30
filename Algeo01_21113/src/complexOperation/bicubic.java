package complexOperation;
import simpleOperation.*;
import java.lang.Math;

public class bicubic {
	int [][]pasanganij;
	simpleOperation simple = new simpleOperation();
	public double[][] buildX() {
		double[][]X = new double[16][16];
	
		int[][]pasanganxy = new int[16][2];
		int x = -1;
		int y = -1;
		int countx = 0;
		int county = 0;
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 2; j++) {
				if(j == 0) {
					pasanganxy[i][j] = x;
					x++;
					if(x > 2) {
						x = -1;
					}	
				}
				else {
					pasanganxy[i][j] = y;
					county++;
					if(county == 4) {
						y++;
						county = 0;
					}
				}
			}

		}
		
		pasanganij = new int[16][2];
		int x1 = 0;
		int y1 = 0;
		int county1 = 0;
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 2; j++) {
				if(j == 0) {
					pasanganij[i][j] = x1;
					x1++;
					if(x1 > 3) {
						x1 = 0;
					}
				}
				else {
					pasanganij[i][j] = y1;
					county1++;
					if(county1 == 4) {
						y1++;
						county1 = 0;
					}
				}
			}
		}

		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				X[i][j] = Math.pow(pasanganxy[i][0], pasanganij[j][0]) * Math.pow(pasanganxy[i][1], pasanganij[j][1]);
				
			}
		}
		return X;
	}
	
	public double[][]koefisien(double matrixInput[][]){
		double[][]nilaiKoefisien = new double[16][1];
		double [][]x = new double[16][16];
		x = buildX();
		simple.perkalianDuaMatrix(simple.inversGaussJordan(x), matrixInput);
		return nilaiKoefisien;
	}
	
	public double hasilInterpolasi(double x, double y, double matrixInput[][]) {
		double result = 0;
		double [][]nilaiKoefisien = new double[16][1];
		nilaiKoefisien = koefisien(matrixInput);
		for(int i = 0; i < 16; i++) {
			result += ((nilaiKoefisien[0][i])*Math.pow(x, pasanganij[i][0])*Math.pow(y, pasanganij[i][1]));
		}
		
		return result;
	}
	
	
}
