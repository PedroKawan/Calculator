package me.pedrokaua.calculator.vision.components;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class KeyboardCalculator extends JPanel{
	private static final long serialVersionUID = 1L;

	List<ButtonCalculator> buttons = new ArrayList<>();
	
	private final Color COLOR_DARK = Color.DARK_GRAY;
	private final Color COLOR_DARK_GRAY = new Color(40, 40, 40);
 	private final Color COLOR_DARK_BLUE = new Color(50, 50, 50);
	
	
	public KeyboardCalculator() {
		this.setLayout(new GridLayout(5, 4));
		this.setBackground(new Color(30, 30, 30));
		addButtons();
	}

	private void addButtons() {
		this.add(new ButtonCalculator("🔙", COLOR_DARK));
		this.add(new ButtonCalculator("CE", COLOR_DARK));
		this.add(new ButtonCalculator("C", COLOR_DARK));
		this.add(new ButtonCalculator("/", COLOR_DARK_GRAY));
		
		this.add(new ButtonCalculator("7", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("8", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("9", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("*", COLOR_DARK_GRAY));
		
		this.add(new ButtonCalculator("4", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("5", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("6", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("-", COLOR_DARK_GRAY));
		
		this.add(new ButtonCalculator("1", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("2", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("3", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("+", COLOR_DARK_GRAY));
		
		this.add(new ButtonCalculator("+/-", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("0", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator(",", COLOR_DARK_BLUE));
		this.add(new ButtonCalculator("=",new Color(30, 30, 50)));
	}
	
}
