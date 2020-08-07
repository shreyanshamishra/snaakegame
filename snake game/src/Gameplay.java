import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.*;
import java.awt.ActiveEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;





public class Gameplay extends JPanel implements KeyListener,ActionListener
{
	
	
	private int[] snakexlength=new int[750];
	private int[] snakeylength=new int[750];
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	
	
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	
	
	private int lengthofsnake=3;
	private int moves=0;
	
	private Timer timer;
	private int delay=50;
	
	private ImageIcon snakeimage;
	
	
	
	private  ImageIcon titleImage;
	
	
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
		
	}
	public void paint(Graphics g)
	{   
		if(moves==0)
		{
			snakexlength[2]=50;
			snakexlength[1]=76;
			snakexlength[0]=100;
			
			snakeylength[2]=100;
			snakeylength[1]=100;
			snakeylength[0]=100;
			
			
			
			
		}
		g.setColor(Color.white);
		g.drawRect(24,10,851, 55);
		
		
		titleImage= new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
		
		
		
		rightmouth =new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		
		
		
		
		for(int a =0;a<lengthofsnake;a++)
		{
			if(a==0 && right)
			{
				
				rightmouth =new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && left)
			{
				
				leftmouth =new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && down)
			{
				
				downmouth =new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a==0 && up)
			{
				
				upmouth =new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a!=0)
			{
				snakeimage =new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
		}
		
		
		
		
		g.dispose();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		
		timer.start();
		if(right)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeylength[r+1]=snakeylength[r];
			}
			
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				if(r==0)
				{
					snakexlength[r]=snakexlength[r]+25;
					
				}
				else
				{
					snakexlength[r]=snakexlength[r-1];
				}
				if(snakexlength[r]>850)
				{
					snakexlength[r]=25;
				}
			}
			repaint();
		}
		
		if(left)
		{
			

			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeylength[r+1]=snakeylength[r];
			}
			
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				if(r==0)
				{
					snakexlength[r]=snakexlength[r]-25;
					
				}
				else
				{
					snakexlength[r]=snakexlength[r-1];
				}
				if(snakexlength[r]<25)
				{
					snakexlength[r]=850;
				}
			}
			repaint();
		}
		
		
		if(up)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakexlength[r+1]=snakexlength[r];
			}
			
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				if(r==0)
				{
					snakeylength[r]=snakeylength[r]-25;
					
				}
				else
				{
					snakeylength[r]=snakeylength[r-1];
				}
				if(snakeylength[r]<75)
				{
					snakeylength[r]=625;
				}
			}
			repaint();
		}
		
		
		
		
		if(down)
		{

			

			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakexlength[r+1]=snakexlength[r];
			}
			
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				if(r==0)
				{
					snakeylength[r]=snakeylength[r]-25;
					
				}
				else
				{
					snakeylength[r]=snakeylength[r-1];
				}
				if(snakeylength[r]>625)
				{
					snakeylength[r]=75;
				}
			}
			repaint();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			moves++;
			right =true;
			if(!left)
			{
				right =true;
			}
			else
			{
				right =false;
				left =true;
			}
			up=false;
			down=false;
		}
		
			
			if(e.getKeyCode() == KeyEvent.VK_A)
			{
				moves++;
				left =true;
				if(!right)
				{
					left =true;
				}
				else
				{
					left =false;
					right =true;
				}
				up=false;
				down=false;
				
			}
				
				if(e.getKeyCode() == KeyEvent.VK_W)
				{
					moves++;
					up =true;
					if(!down)
					{
						up =true;
					}
					else
					{
						up =false;
						down =true;
						
					}
			
			
			right=false;
			left=false;
			
		}
				
				if(e.getKeyCode() == KeyEvent.VK_S)
				{
					moves++;
					down =true;
					if(!up)
					{
						down =true;
					}
					else
					{
						down =false;
						up =true;
						
					}
			
			
			right=false;
			left=false;
			
		}
				
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	


