package menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;



public class frame extends JFrame implements ActionListener{
	JButton button;
	JTextField textField;
	JMenuBar menuBar;
	JMenu home, operation;
	JMenuItem spl, determinan, invers, interpolasiPolinom, interpolasiBicubic, regresi;
	JButton selectFile;
	
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
		
		
		selectFile = new JButton("Select File");
		selectFile.addActionListener(this);
		this.add(selectFile);
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	
		
//		textField = new JTextField();
//		button = new JButton("Submit");
//		button.addActionListener(this);
//		textField.setPreferredSize(new Dimension(250, 40));
//		this.add(textField);
//		this.add(button);

		
	}

	public static void input() {

	}
	public static void splMenu() {
		frame frame = new frame();
		System.out.println("hai");
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

	}
}
