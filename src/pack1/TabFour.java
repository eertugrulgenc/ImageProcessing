package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class TabFour extends JPanel{
	public int width;
	public int height;
	

	public int[][] gEdge;
	
	private int[][] pixels;
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		islemler();
		gEdge = new int[height][width];
		int [][] xdir = {{-1,0,1},{-2,0,2},{-1,0,1}};
		int [][] ydir = {{-1,-2,-1},{0,0,0},{1,2,1}};
		for(int row = 1; row<height-1; row++) {
			for(int col = 1; col<width-1; col++) {
				int	Gx = xdir[0][0]*pixels[row-1][col-1]+xdir[1][0]*pixels[row][col-1]+
						xdir[2][0]*pixels[row+1][col-1]+xdir[0][2]*pixels[row-1][col+1]+
						xdir[1][2]*pixels[row][col+1]+xdir[2][2]*pixels[row+1][col+1];
				
				int Gy = ydir[0][0]*pixels[row-1][col-1]+ydir[0][1]*pixels[row-1][col]+
						ydir[0][2]*pixels[row-1][col+1]+ydir[2][0]*pixels[row+1][col-1]+
						ydir[2][1]*pixels[row+1][col]+ydir[2][2]*pixels[row+1][col+1];
				
				int Magnitude = (int) Math.sqrt(Math.pow(Gx, 2) + Math.pow(Gy, 2));
				 
				 gEdge[row][col] = Magnitude;
			}
		}
		 
	       
	        for(int row = 1; row<height-1; row++) 
				for(int col = 1; col<width-1; col++) {
					if(gEdge[row][col]>=0 &&  gEdge[row][col]<256) {
					g.setColor(new Color( gEdge[row][col],
							 gEdge[row][col],
							 gEdge[row][col]));
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
