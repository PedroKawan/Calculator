package me.pedrokaua.calculator.vision.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import me.pedrokaua.calculator.model.Memory;
import me.pedrokaua.calculator.model.MemoryObserver;

public class DisplayCalculator extends JPanel implements MemoryObserver{
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	
	public DisplayCalculator() {
		Memory.getInstance().addObserver(this);
		
		this.setBackground(new Color(30, 30, 30));
		label = new JLabel(Memory.getInstance().getTextCurrent());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("curier", Font.BOLD, 40));
		
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 40));
		this.add(label);
	}

	@Override
	public void auteredValue(String newValue) {
		label.setText(newValue);
		toUpdate();
	}

	private void toUpdate() {
		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
			this.setVisible(true);
		});
	}
	
	

}
