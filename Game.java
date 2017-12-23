import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	int xBall, yBall, velXBall = 2, velYBall = 2;
	int yRight = 175, velYRight = 0;
	int yLeft = 175, velYLeft = 0;
	Timer timer = new Timer(5, this);
	Font font = new Font("ariel", Font.BOLD, 75);
	Font fontScore = new Font("ariel", Font.BOLD, 25);
	int leftScore = 0, rightScore = 0;
	
	public Game() {
		timer.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1000, 500);
		
		g.setColor(Color.BLACK);
		g.fillOval(xBall, yBall, 25, 25);
		
		g.setColor(Color.RED);
		g.fillRect(980, yRight, 10, 100);
		
		g.setColor(Color.blue);
		g.fillRect(5, yLeft, 10, 100);
		
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Score", 390, 60);
		
		g.setFont(fontScore);
		g.setColor(Color.blue);
		g.drawString(Integer.toString(leftScore), 470, 95);
		g.setColor(Color.RED);
		g.drawString(Integer.toString(rightScore), 510, 95);
		
		g.setColor(Color.WHITE);
		g.fillRect(495, 75, 5, 20);
	}
	public void actionPerformed(ActionEvent e) {
		if(xBall > 960 && yBall > yRight - 30 && yBall < yRight + 120) {
			velXBall = -velXBall;
		}
		if(xBall < 5 && yBall > yLeft - 30 && yBall < yLeft + 120) {
			velXBall = -velXBall;
		}
		if(yBall < 0 || yBall > 440) {
			velYBall = -velYBall;
		}
		if(yRight < 0) {
			yRight = 0;
		}
		if(yRight > 375) {
			yRight = 375;
		}
		if(yLeft < 0) {
			yLeft = 0;
		}
		if(yLeft > 375) {
			yLeft = 375;
		}
		if(xBall > 1000) {
			leftScore++;
			xBall = 0;
			yBall = 0;
		}
		if(xBall < -50) {
			rightScore++;
			xBall = 0;
			yBall = 0;
			velXBall = 2;
			velYBall = 2;
		}
		repaint();
		xBall += velXBall;
		yBall += velYBall;
		yRight += velYRight;
		yLeft += velYLeft;
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			velYRight = -2;
		}
		if(code == KeyEvent.VK_DOWN) {
			velYRight = 2;
		}
		if(code == KeyEvent.VK_W) {
			velYLeft = -2;
		}
		if(code == KeyEvent.VK_S) {
			velYLeft= 2;
		}
	}
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			velYRight = 0;
		}
		if(code == KeyEvent.VK_DOWN) {
			velYRight = 0;
		}
		if(code == KeyEvent.VK_W) {
			velYLeft = 0;
		}
		if(code == KeyEvent.VK_S) {
			velYLeft = 0;
		}
	}
}
