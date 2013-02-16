import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class TicToy extends JFrame implements KeyListener
{ 
     JButton jb[]=new JButton[16];
	 int n,j;
	 
	 
	
     TicToy()
	 {     
     	  int n[]=new int[15];
		  
	      setVisible(true);
		  setLocationRelativeTo(null);
		  setLayout(new GridLayout(4,4,4,4));
		  Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		  setSize(500,500);
		  setTitle("TicToy for Childrens of class 5th");
		  
		   n=Generate(n);
		  for(int i=0;i<15;i++)
		  { 
		     
		   
			
		    jb[i]=new JButton(""+n[i]+"");
		    add(jb[i]);
			  
			jb[i].addKeyListener(this);
	      }   
		      jb[15]=new JButton("");
		      add(jb[15]);
			  jb[15].addKeyListener(this);
		  
		  System.out.println(n);
	}
	public static void main(String []arr)
	 {
	    TicToy ob=new TicToy();
	 }
	 public int[] Generate(int n[])
	 {
	     for(int i=0;i<n.length;i++)
		 {
		      n[i]=i;
	     }
		 for (int i=0; i<n.length; i++) {
		 Random rm=new Random();
    int randomPosition = rm.nextInt(15);
    int temp = n[i];
    n[i] = n[randomPosition];
    n[randomPosition] = temp;
	         
        } 
	for(int i=0;i<n.length;i++)
       {   System.out.println(n[i]);}
		return n;
}	  
	public void keyTyped(KeyEvent e)
	{
	  int count=0;
	 
	     if(e.getKeyChar()==122)
		 {
	           for(int i=0;i<jb.length;i++)
			   {    
                         String s=jb[i].getText();
						 
					count++;	
			     if((s.equals("")))
				   {
				   
	                 j=count;
					
					    
					}
	                
						
	                } 
			try {	 jb[j-1].setText(jb[j-5].getText());	
	                   jb[j-5].setText("");
					   startBGMusic("BITE.wav");
					   
				}
                     catch(ArrayIndexOutOfBoundsException e2)
					   {
					                    startBGMusic("error.wav");                 
					        JOptionPane.showMessageDialog(null,"YOU Are Idiot NO Move Possible Here!!","Warning",JOptionPane.WARNING_MESSAGE); 
							
		                }				
		  
	 }
	 else if(e.getKeyChar()==119)
	 {
	          count=0;
	  
	     
		 
	           for(int i=0;i<jb.length;i++)
			   {    
                         String s=jb[i].getText();
					count++;	
			     if((s.equals("")))
				   {
				   
	                 j=count;
					
					    
					}
	                
						
	                }  
				try { jb[j-1].setText(jb[j+3].getText());	
	                   jb[j+3].setText("");
					   startBGMusic("BITE.wav");
					   
					    }
					   catch(ArrayIndexOutOfBoundsException e2)
					   
					   {
					                     startBGMusic("error.wav");
					        JOptionPane.showMessageDialog(null,"YOU Are Idiot NO Move Possible Here!!","Warning",JOptionPane.WARNING_MESSAGE); 
		                }
	        
	 }
	 else if(e.getKeyChar()==97)
	 {
	      count=0;
	  
	     
	           for(int i=0;i<jb.length;i++)
			   {    
                         String s=jb[i].getText();
					count++;	
			     if((s.equals("")))
				   {
				   
	                 j=count;
					
					    
					}
	                
						
	                }
					
					System.out.println(count);  System.out.println(j);
					 jb[j-1].setText(jb[j].getText());	
	                   jb[j].setText("");
					   startBGMusic("BITE.wav");
                  try{    
					
					    if(j==4 || j==8 ||  j==12 || j==16) 
                          throw new ArithmeticException();    
                    }
                     catch(ArithmeticException e1)
					 
               		{
					                            jb[j].setText(jb[j-1].getText());	
	                                                  jb[j-1].setText("");
													   startBGMusic("error.wav");
					               JOptionPane.showMessageDialog(null,"YOU Are Idiot NO Move Possible Here!!","Warning",JOptionPane.WARNING_MESSAGE); 
								 
                     }            					
                 					
				
		  }
		  else if(e.getKeyChar()==100)
	 {
	      count=0;
	  
	     
	           for(int i=0;i<jb.length;i++)
			   {    
                         String s=jb[i].getText();
					count++;	
			     if((s.equals("")))
				   {
				   
	                 j=count;
					
					    
					}
	                
						
	                } System.out.println(count);  System.out.println(j);  
				 jb[j-1].setText(jb[j-2].getText());	
	                   jb[j-2].setText("");
					   startBGMusic("BITE.wav");
					    try{    
					
					    if(j==1 || j==5 ||  j==9 || j==13) 
                          throw new ArithmeticException();    
                    }
                     catch(ArithmeticException e1)
					 
               		{
					                            jb[j-2].setText(jb[j-1].getText());	
	                                                  jb[j-1].setText("");
													  startBGMusic("error.wav");
					               JOptionPane.showMessageDialog(null,"YOU Are Idiot NO Move Possible Here!!","Warning",JOptionPane.WARNING_MESSAGE); 
								 
                     }            			
		  }
	}
     public void startBGMusic(String music) { 

try {
         // Open an audio input stream.
         URL url = this.getClass().getClassLoader().getResource(music);
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }	
	 public void keyReleased(KeyEvent e){}
public void keyPressed(KeyEvent e){}
   		 
}
