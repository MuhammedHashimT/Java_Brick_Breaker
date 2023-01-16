package com.farrago.hashim;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main  implements ActionListener {
	
	JButton l1 ;
	JFrame jf ;
	JButton l2;
	JButton sevenB;
	JButton eightB;
	JButton nineB;
	JButton addB;
	public Main () {
		Gameplay gameplay = new Gameplay();
		
		jf = new JFrame();
		jf.setTitle("Game");
		jf.setBounds(20,20,698,598);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.add(gameplay);
		
//		sevenB = new JButton("1");
//		sevenB.setBounds(50,100,80,80);
//		sevenB.addActionListener(this);
//		jf.add(sevenB);
//		
//		eightB = new JButton("2");
//		eightB.setBounds(150,100,80,80);
//		eightB.addActionListener(this);
//		jf.add(eightB);
//		
//		nineB = new JButton("3");
//		nineB.setBounds(250,100,80,80);
//		nineB.addActionListener(this);
//		jf.add(nineB);
//		
//		addB = new JButton("4");
//		addB.setBounds(370,100,80,80);
//		addB.addActionListener(this);
//		jf.add(addB);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Main();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == sevenB) {
//			eightB.setBounds(0, 0, 0, 0);
//			nineB.setBounds(0, 0, 0, 0);
//			sevenB.setBounds(0, 0, 0, 0);
//			addB.setBounds(0, 0, 0, 0);
//			Gameplay g = new Gameplay(1);
//			Gameplay gamePlay = new Gameplay();
//			jf.add(gamePlay);
//			jf.repaint();
//			jf.revalidate();
//			
//			int delay =8;
//			Timer time = new Timer(delay ,this);
//			time.start();	
//		}else if(e.getSource() == eightB) {
//			eightB.setBounds(0, 0, 0, 0);
//			nineB.setBounds(0, 0, 0, 0);
//			sevenB.setBounds(0, 0, 0, 0);
//			addB.setBounds(0, 0, 0, 0);
//			Gameplay g = new Gameplay(2);
//			Gameplay gamePlay = new Gameplay();
//			jf.add(gamePlay);
//			jf.repaint();
//			jf.revalidate();
//			
//			int delay =8;
//			Timer time = new Timer(delay ,this);
//			time.start();	
//		}else if(e.getSource() == nineB) {
//			eightB.setBounds(0, 0, 0, 0);
//			nineB.setBounds(0, 0, 0, 0);
//			sevenB.setBounds(0, 0, 0, 0);
//			addB.setBounds(0, 0, 0, 0);
//			Gameplay g = new Gameplay(3);
//			Gameplay gamePlay = new Gameplay();
//			jf.add(gamePlay);
//			jf.repaint();
//			jf.revalidate();
//			
//			int delay =8;
//			Timer time = new Timer(delay ,this);
//			time.start();	
//		}else if(e.getSource() == addB) {
//			eightB.setBounds(0, 0, 0, 0);
//			nineB.setBounds(0, 0, 0, 0);
//			sevenB.setBounds(0, 0, 0, 0);
//			addB.setBounds(0, 0, 0, 0);
//			Gameplay g = new Gameplay(4);
//			Gameplay gamePlay = new Gameplay();
//			jf.add(gamePlay);
//			jf.repaint();
//			jf.revalidate();
//			
//			int delay =8;
//			Timer time = new Timer(delay ,this);
//			time.start();	
//		}
		
	}
	
	

}
