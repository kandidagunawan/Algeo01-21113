package menu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class frame extends JFrame implements ActionListener{
	JButton button, selectFile, sendMatrix, sendMatrixSize;
	JLabel labelInput;
	JTextField inputRows, inputCols;
	JPanel inputMatrix;
	JMenuBar menuBar;
	JMenu home, operation;
	JMenuItem spl, determinan, invers, interpolasiPolinom, interpolasiBicubic, regresi;
	
//	JTextArea  textArea;
	double matrix[][];
	int rows, cols;
	
	
	public frame(){
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
		
		
//		load = new JMenuItem("load");
//		home.add(load);
//		load.addActionListener(this);
		
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
		
		
		//textArea = new JTextArea(20, 30);
		//JScrollPane scroll = new JScrollPane(textArea);
		//textArea.setBounds(30,30, 20,30); 
		//this.add(textArea);

//		labelInput = new JLabel();

		//this.add(textArea);
//		this.add(labelInput);
		
		this.setVisible(true);


		
	}

	public static void input() {

	}
	public static void splMenu() {
		frame frame = new frame();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == spl) {
			JButton coba = new JButton("dida");
			this.add(coba);
			
		}
		else if(e.getSource() == determinan) {
			
		}
		else if(e.getSource() == invers) {
			
		}
		else if(e.getSource() == interpolasiPolinom) {
			
		}
		else if(e.getSource() == interpolasiBicubic) {
			
		}
		else if(e.getSource() == regresi) {
			
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
//			
			sendMatrix.setEnabled(false);
			
		}
		

	}

	private int parseInt(String text) {
		// TODO Auto-generated method stub
		return 0;
	}
}
