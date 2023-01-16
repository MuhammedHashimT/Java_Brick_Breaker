package com.farrago.hashim;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;

public class MapGenerator {
	
	public int map[][];
	public int brickWidth;
	public int brickHieght;
	
	public MapGenerator (int row,int col) {
		map = new int[row][col];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = 1;	
			}
		}
		
		brickHieght = 150/row;
		brickWidth = 540/col;
		
		
		
		
	}
	
	public void drow(Graphics2D g) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.white);
					g.fillRect(j * brickWidth +80 , i * brickHieght +50, brickWidth, brickHieght); 
					
//					border
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth +80 , i * brickHieght +50, brickWidth, brickHieght); 
					
				}
			}
		}
	}
	
	public void setBrickValue(int value,int row,int col) {
		map[row][col] = value;
	}
}
