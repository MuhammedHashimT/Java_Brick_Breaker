package com.farrago.hashim;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener , ActionListener{
	
	private boolean play = false;
	private int score = 0;
	
	
	private Timer time;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int gameLevel = 1;
	private int totalBricks = (gameLevel*3) * (gameLevel*4);
	
	private int ballX = 120;
	private int ballY = 350;
	
	private int ballXDir = -1;
	private int ballYDir = -2;
	
	private MapGenerator map;
	
	public Gameplay(int gameLevel) {
		this.gameLevel = gameLevel;
		totalBricks = (this.gameLevel*3) * (this.gameLevel*4);
	}
	
	
	
	public Gameplay() {
		map = new MapGenerator(gameLevel*3 , gameLevel*4);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time = new Timer(delay,this);
		time.start();
	}
	
	public void paint(Graphics g) {
//		backgrounds
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 698, 592);
		
//		drawing bricks
		map.drow((Graphics2D) g);
		
//		score
		g.setColor(Color.white);
		g.setFont(new Font("sans-serif",Font.BOLD,25));
		g.drawString(""+score, 590, 30);
		
//		Win Game
		if(totalBricks <= 0) {
			play = false;
			ballXDir = 0;
			ballYDir = 0;
			g.setColor(Color.green);
			g.setFont(new Font("sans-serif" , Font.BOLD,30));
			g.drawString("You Won!", 120, 300);
			
			g.setFont(new Font("serif" , Font.ITALIC , 25));
			g.drawString("Press Enter to Restart ", 130, 340);
			
		}
		
//		Game over
		if(ballY > 570) {
			play = false;
			ballXDir = 0;
			ballYDir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("sans-serif" , Font.BOLD,20));
			g.drawString("Game over your score: "+score, 120, 300);
			
			g.setFont(new Font("serif" , Font.ITALIC ,25));
			g.drawString("Press Enter to Restart ", 130, 330);
			
		}
//		borders
		g.setColor(Color.red);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
//		the peddels
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
//		the ball
		g.setColor(Color.blue);
		g.fillOval(ballX, ballY, 20, 20);
		
//		g.dispose();
	}
			

	@Override
	public void actionPerformed(ActionEvent e) {
		
		time.start();
		if(play) {
			if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(playerX,550,100,8))) {
				ballYDir = - ballYDir;
			}
			
		LOOP : 
			for (int i = 0; i < map.map.length; i++) {
				for (int j = 0; j < map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
						int brickX = j * map.brickWidth +80 ;
						int brickY = i * map.brickHieght + 50;
						int brickWidth = map.brickWidth;
						int brickHieght = map.brickHieght;
						
						Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHieght);
						Rectangle ballRect = new Rectangle(ballX,ballY,20,20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							map.setBrickValue(0, i, j);
							--totalBricks;
							score += 5;
							
							if(ballX + 19 <= brickRect.x || ballY + 1 >= brickRect.width + brickRect.x) {
								ballXDir = - ballXDir;
							}else {
								ballYDir = -ballYDir;
							}
							break LOOP;
						}
					}
				}
			}
			ballX += ballXDir;
			ballY += ballYDir;
			if(ballX <0) {
				ballXDir = - ballXDir;
			}if(ballY < 0) {
				ballYDir = - ballYDir;
			}if(ballX > 670) {
				ballXDir = -ballXDir;
			}if(ballY > 670) {
				ballYDir = -ballYDir;
			}
		}
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX > 600) {
				playerX = 600;
			}else {
				playerX = moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			}else {
				playerX = moveLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
				score = 0;
				totalBricks = 32;
				playerX = 310;
				ballX = 120;
				ballY = 350;
			    ballXDir = -1;
				ballYDir = -2;
				
				map = new MapGenerator(4, 8);
				repaint();
			}
		}
		
	}
	
//	to move right
	public int moveRight() {
		play = true;
		return playerX + 20;
	}
	
//	to move left
	public int moveLeft() {
		play = true;
		return playerX - 20;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
