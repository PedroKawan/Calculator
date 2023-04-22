package me.pedrokaua.calculator.vision.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import me.pedrokaua.calculator.model.Memory;

// Calculator Button
public class ButtonCalculator extends JButton {
	private static final long serialVersionUID = 1L;

	String text;
	Color color;
	
	public ButtonCalculator(String text, Color color) {
		this.text = text;
		this.color = color;
		configButton();
		configEvent();
	}

	private void configButton() {
		this.setText(text);
		this.setOpaque(true);
		this.setBackground(color);
		this.setForeground(Color.WHITE);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED,
				new Color(30, 30, 30), new Color(30, 30, 30)));
		this.setFont(new Font("curier", Font.BOLD, 20));
	}
	
	//Send the button's text to Memory.
	private void configEvent() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ButtonCalculator button = (ButtonCalculator) e.getSource();
				Memory.getInstance().processCommands(button.getText());
			}
		});
	}
}
