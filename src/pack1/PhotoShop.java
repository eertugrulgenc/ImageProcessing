package pack1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;



class PhotoShop extends JFrame{
	private TabOne tabOne;
	private TabTwo tabTwo;
	private TabThree tabThree;
	private TabFour tabFour;
	private TabFive tabFive;
	private TabSix tabSix;
	final int[] Gx = new int[2];
    final int[] Gy = new int[2];
	private static int[][] pixels;
	public int i = 0;
		PhotoShop(){
			JTabbedPane jtpes = new JTabbedPane();
			tabOne = new TabOne();
			jtpes.add("Original", tabOne);
			tabTwo = new TabTwo();
			jtpes.add("X Direction", tabTwo);
			tabThree = new TabThree();
			jtpes.add("Y Direction", tabThree);
			tabFour = new TabFour();
			jtpes.add("XY Direction", tabFour);
			tabFive = new TabFive();
			jtpes.add("Histogram", tabFive);
			
			
			JButton rstButton = new JButton("Reset");
			tabOne.add(rstButton);
			
			tabOne.addMouseListener(new MouseAdapter() {
				 public void mousePressed(MouseEvent e) {
					 if(i<2) {
						 if (e.getX() <= pixels[0].length && e.getY() <= pixels.length) {
							 	Gx[i] = e.getX();
		                        Gy[i] = e.getY();
		                        i++;	
		                    }
					 }
					 if(i==2) {
						 tabSix = new TabSix(Gx[0],Gx[1],Gy[0],Gy[1]);
						 jtpes.add("ZOOM",tabSix);
					 }
				 }
			});
			
			 rstButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                Gx[0] = 0;
		                Gx[1] = 0;
		                Gy[0] = 0;
		                Gy[1] = 0;
		                i = 0;
		             
		            }
		        });
			this.add(jtpes);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(700,600);
			this.setVisible(true);
			
		}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of picture");
		String pictureName = scan.next();
		TabOne tabOne = new TabOne();
		tabOne.ImageRead(pictureName);
		PhotoShop pht = new PhotoShop();
		mainOkuma();
		
	}
	public static void mainOkuma() {
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File("pictureName.txt"));
			int width = inFile.nextInt();
			int height = inFile.nextInt();
			
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
