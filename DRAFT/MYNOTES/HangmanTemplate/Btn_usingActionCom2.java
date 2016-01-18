import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Btn_usingActionCom2 extends JFrame implements ActionListener {
   private int row=3, col=3;
   private JButton btn[] = new JButton[26];       // number of buttons - can be changed
   private String turn="o";
   private Container c;
   private JLabel spacer1 = new JLabel("                                                 ");
   private JLabel spacer2 = new JLabel("                                                 ");
   private ImageIcon hm1 = new ImageIcon("hangman.gif");
   private ImageIcon hm2 = new ImageIcon("h2.jpg");
   private JLabel spacer3 = new JLabel(hm1);
   private JPanel btnPanel = new JPanel();
   private JPanel extraPanel = new JPanel();
   private JPanel extraPanel2 = new JPanel();
    private JPanel extraPanel3 = new JPanel();
   private JPanel southPanel = new JPanel();
   private JLabel lblLetter = new JLabel("                                           ");
   private JLabel lblDash = new JLabel("_ _ _ _ _ _ _ _ _ _ _ _");
   private JButton btn_yes = new JButton("Yes");     //can change aaaa   label on action buttons
   private JButton btn_no = new JButton("No");      //can change bbbb   label on action buttons
   private JButton btn_exit = new JButton("Exit");          //label on action buttons
   Font f = new Font("Helvetica", Font.BOLD, 12);
   int cnt=0;
   String listLetters="  ";
   public Btn_usingActionCom2()   {
      super( "Button Example" );

      btnPanel.setLayout(new FlowLayout());
	  extraPanel.setLayout(new GridLayout(2,13));
	  extraPanel2.setLayout(new GridLayout(3,1));
	  southPanel.setLayout(new GridLayout(1,3));

      c = getContentPane();
      c.setLayout( new BorderLayout() );

      // create and add buttons
      for (int i = 0; i < 26; i++ ) {
	      btn[i]= new JButton(""+(char)(97+i));
          btn[i].setFont(f); 
          btn[i].addActionListener( this );
          extraPanel.add(  btn[i]);
		
      }
	  btnPanel.add(extraPanel);
	  btnPanel.add( extraPanel2);
	  extraPanel2.add(  spacer1);
	  extraPanel2.add(  lblLetter);
	  extraPanel3.setLayout(new FlowLayout());
	   extraPanel2.add(extraPanel3);
	   extraPanel3.add(  lblDash);
	  btn_yes.addActionListener( this );
	  southPanel.add(btn_yes);
	  btn_no.addActionListener( this );
	  southPanel.add(btn_no);
	  btn_exit.addActionListener( this );
	  southPanel.add(btn_exit);
	  c.add(spacer3, BorderLayout.NORTH );
	  c.add( southPanel, BorderLayout.SOUTH );
	  c.add( btnPanel, BorderLayout.CENTER  );
	   c.add( spacer1, BorderLayout.EAST  ); 
	  c.add( spacer2, BorderLayout.WEST  ); 
      setSize( 950, 400 );                          //size of the window, can be changed
      setVisible(true);
   }

   public void actionPerformed( ActionEvent e ){ 
        JButton b = (JButton)e.getSource();
        String act = b.getActionCommand();
		if (act.equals("Yes")){
		    JOptionPane.showMessageDialog( null, "You clicked on button Yes.......", "Button click", JOptionPane.INFORMATION_MESSAGE );
		}
		else if (act.equals("No")){
			JOptionPane.showMessageDialog( null, "You clicked on button no.......", "Also button click", JOptionPane.INFORMATION_MESSAGE );
		}
		else if (act.equals("Exit")){
			JOptionPane.showMessageDialog( null, "Bye", "Also button click", JOptionPane.INFORMATION_MESSAGE );
		    System.exit(0);
		}
		else {
		    String letter = b.getText();
			System.out.println(letter);
			b.setEnabled(false);
			cnt++;
			if (cnt>3)
			    cnt=cnt%3+1;
  		    spacer3.setIcon(new ImageIcon("h"+cnt+".jpg"));
			if (cnt>3)cnt=cnt%3+1;
			listLetters=listLetters+"     " + letter;
		    lblLetter.setText(listLetters);
		    

			
		}		   
    }// end actionPerformed
         


   public static void main( String args[] ) {
      Btn_usingActionCom2 app = new Btn_usingActionCom2();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   } 
}

