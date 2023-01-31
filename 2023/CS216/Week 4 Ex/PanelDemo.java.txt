// Delta College - CST 283 - Klingler  
// This application demonstrates panels and layout mangers

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelDemo extends JFrame 
{
   private JPanel panel1;
   private JPanel panel1a;
   private JPanel panel1b;
   
   private JPanel panel2;
   private JPanel panel2a;  

   private JPanel panel3;
   private JLabel label1, label2, label3;
 
   private JPanel panel4;
   JButton buttonSet[];
  
   // set up GUI
   public PanelDemo()
   {
      // tet content pane
      Container container = getContentPane();

      container.setLayout(new GridLayout( 2, 2 ));

      // Panel 1 - Upper left
      panel1 = new JPanel();
      panel1.setLayout( new GridLayout( 2,1 ));
      panel1a = new JPanel();
      panel1a.setBackground(Color.red);
      panel1b = new JPanel();
      panel1b.setBackground(Color.blue);
      panel1.add(panel1a);
      panel1.add(panel1b);
      container.add( panel1 );
      
      // Panel 2 - Upper right
      panel2 = new JPanel();
      panel2.setLayout( new BorderLayout( ));
      panel2.setBackground(Color.gray);
      
      panel2a = new JPanel();
      panel2a.setBackground(Color.green);
      panel2.add(panel2a, BorderLayout.EAST);
      container.add( panel2 );      
      
      // Panel 3 - Lower right
      panel3 = new JPanel();
      panel3.setLayout( new GridLayout( 3,1 ));
      
      label1 = new JLabel("One");
      label2 = new JLabel("Two"); 
      label3 = new JLabel("Three");      
      
      panel3.add(label1);
      panel3.add(label2);
      panel3.add(label3);
      
      container.add( panel3 );  
      
      // Panel 3 - Lower right
      panel4 = new JPanel();
      panel4.setLayout( new FlowLayout( ));
      panel4.setBackground(Color.yellow);
      
      buttonSet = new JButton[15];
      for (int i = 0; i < buttonSet.length; i++)
      {
          buttonSet[i] = new JButton(Integer.toString(i));
          panel4.add(buttonSet[i]);
      }
      
      container.add(panel4);

   } // end constructor PanelDemo

   public static void main( String args[] )
   {
      PanelDemo application = new PanelDemo();
      
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
      application.setSize( 600, 500 );
      application.setVisible( true );
      application.setTitle( "Panel Demo" );
   }

}

