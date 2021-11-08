package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class TabFive extends JPanel{
	private int width;
	private int height;
	
	private int[][] pixels;
	private int totalmagnitude=0;
	
	private int flag1=0,flag2=0,flag3=0,flag4=0,flag5=0,flag6=0,flag7=0,flag8=0,flag9=0;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		islemler();
		
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
				if(Gx==0) {
					Gx=-1;
				}
				
				int	orientation = (int) Math.toDegrees(Math.atan(-Gy/Gx));
				if(orientation!=0) {
					orientation = orientation+90;
					if(orientation<20 && orientation>0) {
						flag1+=Magnitude;
					}
					if(orientation<40 && orientation>=20) {
						flag2+=Magnitude;
					}
					if(orientation<60 && orientation>=40) {
						flag3+=Magnitude;
					}
					if(orientation<80 && orientation>=60) {
						flag4+=Magnitude;
					}
					if(orientation<100 && orientation>=80) {
						flag5+=Magnitude;
					}
					if(orientation<120 && orientation>=100) {
						flag6+=Magnitude;
					}
					if(orientation<140 && orientation>=120) {
						flag7+=Magnitude;
					}
					if(orientation<160 && orientation>=140) {
						flag8+=Magnitude;
					}
					if(orientation<180 && orientation>=160) {
						flag9+=Magnitude;
					}
				}
				 g.setColor(Color.BLACK);
                 g.drawLine(5, 250, 640, 250);
                 int z=5;
              
             
                 while(z<640) {
                	  g.setColor(Color.GREEN);
                      g.drawLine(z, 250, z, 200);
                      
                  
                      z=z+10;
                 }
                 
        
                
			}
		}
		   totalmagnitude = flag1+flag2+flag3+flag4+flag5+flag6+flag7+flag8+flag9;
		   
		   g.setColor(Color.BLACK);
		   g.drawLine(65, 250, 65, 	 (flag1*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(125, 250, 125, (flag2*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(185, 250, 185, (flag3*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(245, 250, 245, (flag4*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(305, 250, 305, (flag5*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(365, 250, 365, (flag6*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(425, 250, 425, (flag7*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(485, 250, 485, (flag8*100/totalmagnitude));
		   g.setColor(Color.BLACK);
		   g.drawLine(545, 250, 545, (flag9*100/totalmagnitude));
		/*
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);
		System.out.println(flag4);
		System.out.println(flag5);
		System.out.println(flag6);
		System.out.println(flag7);
		System.out.println(flag8);
		System.out.println(flag9);
	*/

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

