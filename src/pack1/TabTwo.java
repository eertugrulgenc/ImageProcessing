package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class TabTwo extends JPanel{
	private int width;
	public int[][] gx_dir;
	private int height;
	private int[][] pixels;
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		islemler();
		gx_dir = new int[height][width];
		int [][] xdir = {{-1,0,1},{-2,0,2},{-1,0,1}};
		
		for(int row = 1; row<height-1; row++) {
			for(int col = 1; col<width-1; col++) {
				
			int	Gx = xdir[0][0]*pixels[row-1][col-1]+xdir[1][0]*pixels[row][col-1]+
						xdir[2][0]*pixels[row+1][col-1]+xdir[0][2]*pixels[row-1][col+1]+
						xdir[1][2]*pixels[row][col+1]+xdir[2][2]*pixels[row+1][col+1];
			
			
			 if(Gx<0) {
				Gx=-Gx;
			}
			if(Gx>255){
				Gx = (int) Math.sqrt(Gx*Gx);
			}
			gx_dir[row][col] = Gx;
			
		}
	}
		for(int row = 1; row<height-1; row++) 
			for(int col = 1; col<width-1; col++) {
				if(gx_dir[row][col]>=0 &&  gx_dir[row][col]<256) {
				g.setColor(new Color( gx_dir[row][col],
						 gx_dir[row][col],
						 gx_dir[row][col]));
	g.fillRect(col, row, 1, 1);
				}
			}
	
	}

	void islemler() {
		
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File("pictureName.txt"));
			 width = inFile.nextInt();
			 height = inFile.nextInt();
			
			pixels = new int[height][width];
			for(int row = 0; row<height; row++) {
				for(int col = 0; col<width; col++) {
					
						pixels[row][col]=inFile.nextInt();
				
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
