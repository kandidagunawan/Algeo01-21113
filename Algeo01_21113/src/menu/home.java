package menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class home extends JFrame implements ActionListener{
	JLabel welcome;
	JMenuBar menuBar;
	JMenu home, operation;
	JMenuItem spl, determinan, invers, interpolasiPolinom, interpolasiBicubic, regresi;
	public home() {
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
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
		
		welcome = new JLabel("Hello, Welcome to Matrix Program!\n");
		this.add(welcome);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == spl) {
			home home = new home();
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
		else if(e.getSource() == home) {
			home home = new home();
		}
		
	}
}
