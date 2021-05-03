package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	Stack<String> back = new Stack<String>();
	JFrame frame;
	JPanel panel;
	JLabel label;
	public static void main(String[] args) {
		_02_TextUndoRedo mane = new _02_TextUndoRedo();
		mane.method();
	}
	public void method() {
		frame = new JFrame();
		panel= new JPanel();
		label= new JLabel();
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.setSize(500, 500);
		frame.add(panel);
		panel.add(label);
		label.setText("");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (label.getText().length() > 0) {
				back.add(label.getText().charAt(label.getText().length() - 1) + "");
				label.setText(label.getText().substring(0, label.getText().length() - 1));
			}
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!back.isEmpty()) {
				label.setText(label.getText() + back.pop());
			}
		}else {
			label.setText(label.getText() + e.getKeyChar());
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
