package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	Stack <String> words = new Stack <String>();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();
	public static void main(String[] args) {
		Hangman game = new Hangman();
		game.run();
	}
	int lives = 3;
	Random ran = new Random();
	String length;
	String letters;
	String hold;
	public void run() {
		String input = JOptionPane.showInputDialog("Enter a number between 1 and 266");
		int num = Integer.parseInt(input);
		frame.setVisible(true);
		frame.setSize(350, 500);
		frame.add(panel);
		panel.add(label);
		System.out.println("You chose: " + input);
		for (int i = 0; i < num; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			System.out.println(words.size());
		}
		hold = words.pop();
		System.out.println(hold);
		for (int i = 0; i < hold.length(); i++) {
			length += "_";
		}
		label.setText(length);
		frame.addKeyListener(this);
		frame.pack();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < hold.length(); i++) {
			if (e.getKeyChar() == hold.charAt(i)) {
				System.out.println("Got one!");
				letters = label.getText();
				letters = (letters.substring(0, i) + e.getKeyChar() + letters.substring(i+ 1));
				label.setText(letters);
			}
			if (e.getKeyChar() != hold.charAt(i)) {
				lives--;
				System.out.println("You lost a life! You have " + lives + " left...");
				if (lives == 0) {
					System.exit(0);
					System.out.println("You ran out of lives! Try again...");
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
