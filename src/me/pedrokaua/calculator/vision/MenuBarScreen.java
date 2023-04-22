package me.pedrokaua.calculator.vision;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

//MenuBar if Undecorated is active
public class MenuBarScreen extends JPanel{
	private static final long serialVersionUID = 1L;

	Screen screen;
	
	ImageIcon menuExitIcon
		= new ImageIcon(getClass().getResource("/me/pedrokaua/calculator/vision/imagens/exitIcon.png"));
	
	JButton exit;
	
	public MenuBarScreen(Screen screen) {
		this.screen = screen;
		creatingMenu();
		buttonListener();
	}

	// Exit window
	private void creatingMenu() {
		exit = new JButton();
		exit.setPreferredSize(new Dimension(20,20));
		exit.setBackground(new Color(30, 30, 30));
		exit.setIcon(menuExitIcon);
		exit.setBorder(new BevelBorder(BevelBorder.LOWERED,
				new Color(30, 30, 30), new Color(30, 30, 30)));
		this.add(exit);
	}
	
	private void buttonListener() {
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				screen.dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setBackground(new Color (90, 90, 90));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setBackground(new Color(30, 30, 30));
			}
			
		});
	}

}
