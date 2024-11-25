package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


// see also: https://www.tutorialspoint.com/swingexamples
public class SwingTextFieldDemo implements PropertyChangeListener {

   private static JFormattedTextField principleTextField;
   private static JFormattedTextField rateTextField;
   private static JFormattedTextField yearsTextField;
   private static JFormattedTextField amountTextField;
   public static void main(String[] args) throws Exception {
		System.setProperty("sun.java2d.uiScale", "2.5");
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
		}
      SwingTextFieldDemo tester = new SwingTextFieldDemo();
      createWindow(tester);
   }

   private static void createWindow(SwingTextFieldDemo tester) {
      JFrame frame = new JFrame("Swing Tester");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createUI(frame, tester);
      frame.setSize(560, 200);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   private static void createUI(final JFrame frame, SwingTextFieldDemo tester) {
      JPanel panel = new JPanel();
      LayoutManager layout = new GridLayout(6,2);
      panel.setLayout(layout); 
      panel.setSize(300, 200);
      panel.setBorder(BorderFactory.createTitledBorder("Formats"));

      NumberFormat principleFormat = NumberFormat.getNumberInstance();
      principleTextField = new JFormattedTextField(principleFormat);
      principleTextField.setName("Principle");
      principleTextField.setColumns(10);
      JLabel principleLabel = new JLabel("Principle:");
      principleLabel.setLabelFor(principleTextField);
      principleTextField.setValue(new Double(100000));
      principleTextField.addPropertyChangeListener("value", tester);

      NumberFormat rateFormat = NumberFormat.getPercentInstance();
      rateFormat.setMinimumFractionDigits(2);
      rateTextField = new JFormattedTextField(rateFormat);
      rateTextField.setName("Rate");
      rateTextField.setColumns(10);
      JLabel rateLabel = new JLabel("Interest Rate:");
      rateLabel.setLabelFor(rateTextField);
      rateTextField.setValue(new Double(0.1));
      rateTextField.addPropertyChangeListener("value", tester);
      yearsTextField = new JFormattedTextField();
      yearsTextField.setName("Years");
      yearsTextField.setColumns(10);
      JLabel yearLabel = new JLabel("Year(s):");
      yearLabel.setLabelFor(yearsTextField);
      yearsTextField.setValue(new Double(1));
      yearsTextField.addPropertyChangeListener("value", tester);

      NumberFormat amountFormat = NumberFormat.getCurrencyInstance();
      amountTextField = new JFormattedTextField(amountFormat);
      amountTextField.setName("Amount");
      amountTextField.setColumns(10);
      amountTextField.setEditable(false);
      JLabel amountLabel = new JLabel("Amount:");
      amountLabel.setLabelFor(amountTextField);
      amountTextField.setValue(new Double(110000));
  
      DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
      JFormattedTextField today = new JFormattedTextField(dateFormat);
      today.setName("Today");
      today.setColumns(10);
      today.setEditable(false);
      JLabel todayLabel = new JLabel("Date:");
      todayLabel.setLabelFor(today);
      today.setValue(new Date());

      panel.add(principleLabel);
      panel.add(principleTextField); 
      panel.add(rateLabel);
      panel.add(rateTextField);
      panel.add(yearLabel);
      panel.add(yearsTextField);
      panel.add(amountLabel);
      panel.add(amountTextField); 
      panel.add(todayLabel);
      panel.add(today); 
      JPanel mainPanel = new JPanel(); 
      mainPanel.add(panel);

      frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
   } 

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      double amount, rate, years, principle;

      principle = ((Number)principleTextField.getValue()).doubleValue();
      rate = ((Number)rateTextField.getValue()).doubleValue() * 100;
      years = ((Number)yearsTextField.getValue()).doubleValue();
   
      amount = principle + principle * rate * years / 100;
      amountTextField.setValue(new Double(amount));
   } 
}
