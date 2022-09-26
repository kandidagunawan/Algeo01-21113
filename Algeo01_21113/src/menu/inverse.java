package menu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class inverse extends JFrame implements ActionListener{
	JButton button, selectFile, sendMatrix, sendMatrixSize;
	JLabel labelInput, welcome;
	JTextField inputRows, inputCols;
	JPanel inputMatrix;
	JMenuBar menuBar;
	JMenu home, operation;
	JMenuItem spl, determinan, invers, interpolasiPolinom, interpolasiBicubic, regresi;
	
//	JTextArea  textArea;
	double matrix[][];
	int rows, cols;
	
	public inverse(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		
		home = new JMenu("Home");
		operation = new JMenu("Operation");
		
		spl = new JMenuItem("SPL");
		determinan = new JMenuItem("Determinan Matrix");
		invers = new JMenuItem("Matrix Invers");
		interpolasiPolinom = new JMenuItem("Interpolasi Polinom");
		interpolasiBicubic = new JMenuItem("Interpolasi Bicubic");
		regresi = new JMenuItem("Regresi Linier Berganda");
		
		
		home.addActionListener(this);
		operation.addActionListener(this);
		
		spl.addActionListener(this);
		determinan.addActionListener(this);
		invers.addActionListener(this);
		interpolasiPolinom.addActionListener(this);
		interpolasiBicubic.addActionListener(this);
		regresi.addActionListener(this);
		
		menuBar.add(home);
		menuBar.add(operation);
		operation.add(spl);
		operation.add(determinan);
		operation.add(invers);
		operation.add(interpolasiPolinom);
		operation.add(interpolasiBicubic);
		operation.add(regresi);
		
		
		// select file from dir
		selectFile = new JButton("Select File");
		selectFile.addActionListener(this);
		this.add(selectFile);
		this.setJMenuBar(menuBar);
		
		
		// send matrix 
		inputRows = new JTextField();
		inputRows.setPreferredSize(new Dimension(50, 30));
		inputRows.addActionListener(this);
		this.add(inputRows);
		
		inputCols = new JTextField();
		inputCols.setPreferredSize(new Dimension(50, 30));
		inputCols.addActionListener(null);
		this.add(inputCols);
		
		sendMatrixSize = new JButton("Submit");
		sendMatrixSize.addActionListener(this);
		this.add(sendMatrixSize);
		
		
		this.setVisible(true);

	}


	public static void splMenu() {
		inverse frame = new inverse();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == spl) {
			inverse frame = new inverse();
		}
		else if(e.getSource() == determinan) {
			determinan determinan = new determinan();
		}
		else if(e.getSource() == invers) {
			inverse frame = new inverse();
		}
		else if(e.getSource() == interpolasiPolinom) {
			inverse frame = new inverse();
		}
		else if(e.getSource() == interpolasiBicubic) {
			inverse frame = new inverse();
		}
		else if(e.getSource() == regresi) {
			inverse frame = new inverse();
		}
		else if(e.getSource() == selectFile) {
			JFileChooser fileChooser = new JFileChooser();
			int response = fileChooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					FileReader reader = new FileReader(file);
					int data = reader.read();
					while(data != -1) {
						System.out.print((char)data);
						data = reader.read();
					}
					reader.close();
				}
				catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}
				catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
		else if(e.getSource() == sendMatrixSize) {
			rows = Integer.parseInt(inputRows.getText());
			cols = Integer.parseInt(inputCols.getText());
			matrix = new double[rows][cols];
			inputMatrix = new JPanel();
			JLabel input = new JLabel("Masukkan matrix: ");
			inputMatrix.setLayout(new GridLayout(rows, cols));
			this.add(input);
			this.add(inputMatrix);
			for(int i = 0; i < (rows*cols); i++) {
				inputMatrix.add(new JTextField(3));
			}
			sendMatrix = new JButton("Send Matrix");
			sendMatrix.addActionListener(this);
			this.add(sendMatrix);

		}
		else if(e.getSource() == sendMatrix) {
				for(int i = 0; i < rows; i++) {
					for(int j = 0; j < cols; j++) {
						matrix[i][j] = (Double.parseDouble(((JTextField)inputMatrix.getComponent(i*cols + j)).getText()));	
					}
				}

			sendMatrix.setEnabled(false);
			
		}
		
	}


}
