package swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SwingToolbarDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingToolbarDemo(){
      prepareGUI();
   }
   public static void main(String[] args)throws Exception {
		System.setProperty("sun.java2d.uiScale", "2.5");
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
		}
      SwingToolbarDemo swingControlDemo = new SwingToolbarDemo();      
      swingControlDemo.showTableDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(500,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showTableDemo(){
      headerLabel.setText("Control in action: JToolbar"); 
      JToolBar toolBar = new JToolBar("Toolbar");
      
      JButton buttonA = new JButton("Alpha");
      JButton buttonB = new JButton("Beta");
      JButton buttonC = new JButton("Gamma");
      toolBar.add(buttonA);
      toolBar.add(buttonB);
      toolBar.add(buttonC);     

      controlPanel.add(toolBar);
      mainFrame.setVisible(true);     
   } 
}