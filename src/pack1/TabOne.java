package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TabOne extends JPanel{
	private int width;
	
	private int height;
	private int[][] pixels;
	
	private FileWriter writer = null;
	private BufferedImage img = null;
	public int dondurWidth() {
		return width;
	}
	public int dondurHeight() {
		return height;
	}
	
	public int[][] Pixels() {
		return pixels;
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		islemler();
		
		for(int row=0; row<height; row++)
			for(int col=0; col<width; col++) {
				g.setColor(new Color((pixels[row][col]),
							(pixels[row][col]),
							(pixels[row][col])));
				g.fillRect(col,row, 1, 1);
			}
		
	}
	
	public void ImageRead(String pictureName) {
		
		try {
			File file = new File(pictureName);
			writer = new FileWriter("pictureName.txt");
			img = ImageIO.read(file);
			width = img.getWidth();
			height = img.getHeight();
			writer.write(width+" "+height+" ");
			writer.write("\n");
			
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					Color color = new Color(img.getRGB(j, i));
		//	writer.write(color.getRed()+ " "+ color.getGreen()+ " "+color.getBlue()+" ");
			int pixel = color.getRed() + color.getGreen() + color.getBlue();
			pixel = pixel/3;
			writer.write(pixel+" ");
				}
				writer.write("\n");
			}
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
