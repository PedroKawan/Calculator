package me.pedrokaua.calculator.vision;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import me.pedrokaua.calculator.vision.components.DisplayCalculator;
import me.pedrokaua.calculator.vision.components.KeyboardCalculator;

//Calculator Screen
public class CalculatorScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	
	DisplayCalculator displayPanel;
	KeyboardCalculator keyboardPanel;

	public CalculatorScreen() {
		configurationLayout();
	}
	
	// add Keyboard and Display
	private void configurationLayout() {
		this.setLayout(new BorderLayout());
		
		displayPanel = new DisplayCalculator();
		displayPanel.setPreferredSize(new Dimension(350, 100));
		
		keyboardPanel = new KeyboardCalculator();
		
		this.add(displayPanel, BorderLayout.NORTH);
		this.add(keyboardPanel, BorderLayout.CENTER);
	}
}
