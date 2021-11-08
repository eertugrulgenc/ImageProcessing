package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class TabThree extends JPanel{
	private int width;
	private int height;
	public int[][] gy_dir;
	private int[][] pixels;

	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		islemler();
		gy_dir = new int[height][width];
		int [][] ydir = {{-1,-2,-1},{0,0,0},{1,2,1}};
		
		for(int row = 1; row<height-1; row++) {
			for(int col = 1; col<width-1; col++) {
		
				int Gy = ydir[0][0]*pixels[row-1][col-1]+ydir[0][1]*pixels[row-1][col]+
						ydir[0][2]*pixels[row-1][col+1]+ydir[2][0]*pixels[row+1][col-1]+
						ydir[2][1]*pixels[row+1][col]+ydir[2][2]*pixels[row+1][col+1];
			
				 if(Gy<0) {
						Gy=-Gy;
					}
				 if(Gy>255){
						Gy = (int) Math.sqrt(Gy*Gy);
					}
				 gy_dir[row][col] = Gy;
			
		}
			
	}
		for(int row = 1; row<height-1; row++) 
			for(int col = 1; col<width-1; col++) {
				if(gy_dir[row][col]>=0 &&  gy_dir[row][col]<256) {
				g.setColor(new Color( gy_dir[row][col],
						 gy_dir[row][col],
						 gy_dir[row][col]));
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
