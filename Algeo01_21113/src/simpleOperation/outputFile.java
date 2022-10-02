package simpleOperation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class outputFile {
	private String nama;
	Scanner scanner = new Scanner(System.in);
	
	public void createFile() {
		try {
			System.out.println("Masukkan nama file");
			nama = scanner.nextLine();
			File matrix = new File(nama);
			while(!matrix.createNewFile()) {
				System.out.println("File already exists");
				System.out.println("Masukkan nama file");
				nama = scanner.nextLine();
				matrix = new File(nama);
			}
			System.out.println("File created: " + matrix.getName());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void detFile(double det) {
		try {
			createFile();
			FileWriter writer = new FileWriter(this.nama);
			writer.write(String.valueOf(det));
			writer.close();
			System.out.println("Nilai determinan telah dimasukkan dalam file");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void invFile(double [][]inverseMatrix) {
		try {
			createFile();
			FileWriter writer = new FileWriter(this.nama);
			for(int i = 0; i < inverseMatrix.length; i++) {
				for(int j = 0; j < inverseMatrix[0].length; j++) {
					writer.write(String.valueOf(inverseMatrix[i][j]));
					writer.write(" ");
				}
				writer.write("\n");
			}
			writer.close();
			System.out.println("Nilai matrix balikan telah dimasukkan dalam file");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void interpolateFile(String x) {
		try {
			createFile();
			FileWriter writer = new FileWriter(this.nama);
			writer.write(x);
			writer.close();
			System.out.println("Hasil interpolasi polinom telah dimasukkan ke dalam file");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void bicubicFile(String x) {
		try {
			createFile();
			FileWriter writer = new FileWriter(this.nama);
			writer.write(x);
			writer.close();
			System.out.println("Hasil interpolasi bicubic telah dimasukkan ke dalam file");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void SPLFile(String x) {
		try {
			createFile();
			FileWriter writer = new FileWriter(this.nama);
			writer.write(x);
			writer.close();
			System.out.println("Hasil SPL telah dimasukkan ke dalam file");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void regresiFile(String x) {
		try {
			createFile();
			FileWriter writer = new FileWriter(this.nama);
			writer.write(x);
			writer.close();
			System.out.println("Hasil regresi linier telah dimasukkan ke dalam file");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

