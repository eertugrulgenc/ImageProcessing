package pack1;

import java.awt.Color;
import java.awt.Graphics;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.JPanel;

public class TabSix extends JPanel{
	private int Gx1 =0,Gx2=0,Gy1=0,Gy2=0;
	private int width;
	private int height;
	private int[][] pixels;
	private int[][] pixels2;
	public TabSix(int Gx1, int Gx2, int Gy1, int Gy2) {
	
		this.Gx1 = Gx1;
		this.Gx2 = Gx2;
		this.Gy1 = Gy1;
		this.Gy2 = Gy2;
	}
	public void paintComponent(Graphics g) {
		
		
		
		int x1 = Math.min(Gx1, Gx2);
        int x2 = Math.max(Gx1, Gx2);
        int y1 = Math.min(Gy1, Gy2);
        int y2 = Math.max(Gy1, Gy2);
      
        int x = x2 - x1;
        int y = y2 - y1;
		pixels2 = new int[y*2][x*2];
		super.paintComponent(g);
		
		islemler();
		int i = 0;
		for(int row = Gy1; row<Gy2; row++) {
			int j=0;
			for(int col=Gx1; col<Gx2; col++) {
				pixels2[2*i][2*j] = pixels[row][col];
				pixels2[2*i+1][2*j] = pixels[row][col];
				pixels2[2*i][2*j+1] = pixels[row][col];
				pixels2[2*i+1][2*j+1] = pixels[row][col];
				j++;
			}
			i++;
		}
		for(int row=0; row<y*2; row++) {
			for(int col=0; col<x*2; col++) {
				g.setColor(new Color(pixels2[row][col],
						pixels2[row][col],
						pixels2[row][col]));
				g.fillRect(col,row,1,1);
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
