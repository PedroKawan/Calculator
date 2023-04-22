package me.pedrokaua.calculator.vision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Screen extends JFrame{
	private static final long serialVersionUID = 1L;
			
	CalculatorScreen calculator;
	MenuBarScreen menuBar;
	
	public Screen() {
		creatingScreen();
		creatingMenuBar();
		creatingCalculator();
		
		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
			this.setVisible(true);
		});
	}


	private void creatingScreen() {
		this.setSize(350, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(30, 30, 30));
//		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
	}
	
	
	private void creatingCalculator() {
		calculator = new CalculatorScreen();
		this.add(calculator, BorderLayout.CENTER);
	}
	
	private void creatingMenuBar() {
		menuBar = new MenuBarScreen(this);
		menuBar.setPreferredSize(new Dimension(30,30));
		menuBar.setBackground(new Color(30, 30, 30));
		menuBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(menuBar, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new Screen();
	}
}
