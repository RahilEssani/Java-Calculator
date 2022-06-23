
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class GUI {
    JFrame fr;
    JPanel panBtn,panTf;
    JButton [] btnArr;
    JTextField tfMain,tfSub;
    BtnHandler hnd;
    int j=6;
     public GUI()
     {
         initGUI();
     }
     private void initGUI()
     {
      fr = new JFrame("Calculator");
      fr.setLayout(new BorderLayout());

      hnd=new BtnHandler(this);
      panBtn = new JPanel();
      panTf = new JPanel();
     
      panBtn.setLayout(new GridLayout(5,4));
      panBtn.setBackground(new Color(30,35,38));
   
      panTf.setLayout(new GridLayout(2,1));
      panTf.setBackground(Color.DARK_GRAY);

      setFields();
      setButtons();
        
      fr.add(panTf,BorderLayout.NORTH);
      fr.add(panBtn,BorderLayout.CENTER);

      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fr.setBackground(Color.DARK_GRAY);
      fr.pack();
      fr.setLocationRelativeTo(null);
      fr.setVisible(true);
      fr.setResizable(false);
      fr.setSize(334, 500);  
    }
    
    private void setFields()    
    {
      tfSub= new JTextField(15);
      tfSub.setBorder(null);
      tfSub.setBackground(Color.white);
      tfSub.setHorizontalAlignment(JTextField.RIGHT);
      tfSub.setEditable(false);
      tfSub.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,15));
      panTf.add(tfSub);

      tfMain=new JTextField(15);
      tfMain.setBackground(Color.white);
      tfMain.setBorder(null);
      tfMain.setHorizontalAlignment(JTextField.RIGHT);
      tfMain.setText("0");
      tfMain.setEditable(false);
      tfMain.setPreferredSize(new Dimension(200,70));
      tfMain.setFont(new Font(Font.DIALOG,Font.PLAIN,25));
      panTf.add(tfMain);   
    } 
    private void setButtons()    
    {
      btnArr = new JButton[20];
      for (int i =0 ;i <20;i++)
      {
        btnArr[i]=new JButton();
        btnArr[i].setBorder(null);
        btnArr[i].setBackground(new Color(30,35,38));
        btnArr[i].setForeground(Color.white);
        btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,17));
        if(i>3 && i<=15)
        {
            if(i+1%4!=0)
            {    
                btnArr[i].setText(Integer.toString(++j));
                btnArr[i].setActionCommand(Integer.toString(j)); 
            }
            if (j==9)
            {
                j=2;
            }
            else if (j==6)
            {
                j=-1;
            }
        }
          switch (i) {
              case 0:
                  btnArr[i].setText("C");
                  btnArr[i].setActionCommand("C");
                  btnArr[i].setBackground(new Color(94,75,182));
                  btnArr[i].setForeground(Color.orange);
                  break;
              case 1:
                  btnArr[i].setText("↩");
                  btnArr[i].setActionCommand("↩");
                  btnArr[i].setBackground(new Color(94,75,182));
                  btnArr[i].setForeground(Color.orange);
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  break;
              case 2:
                  btnArr[i].setText("x²");
                  btnArr[i].setActionCommand("x²");
                  btnArr[i].setBackground(new Color(94,75,182));
                  btnArr[i].setForeground(Color.orange);
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  break;
              case 3:
                  btnArr[i].setText("÷");
                  btnArr[i].setActionCommand("÷");
                  btnArr[i].setBackground(new Color(94,75,182));
                  btnArr[i].setForeground(Color.orange);
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  break;
              case 7:
                  btnArr[i].setText("×");
                  btnArr[i].setActionCommand("×");
                  btnArr[i].setBackground(new Color(94,75,182));
                  btnArr[i].setForeground(Color.orange);
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  break;
              case 11:
                  btnArr[i].setText("-");
                  btnArr[i].setActionCommand("-");
                  btnArr[i].setBackground(new Color(94,75,182));
                  btnArr[i].setForeground(Color.orange);
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  break;
              case 15:
                  btnArr[i].setText("+");
                  btnArr[i].setActionCommand("+");
                  btnArr[i].setBackground(new Color(94,75,182));
                  btnArr[i].setForeground(Color.orange);
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  break;
              case 19:
                  btnArr[i].setText("=");
                  btnArr[i].setActionCommand("=");
                  btnArr[i].setBackground(Color.ORANGE);
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  break;
              case 18:
                  btnArr[i].setText(".");
                  btnArr[i].setActionCommand(".");
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                  btnArr[i].setForeground(Color.orange);
                  break;
              case 17:
                  btnArr[i].setText("0");
                  btnArr[i].setActionCommand("0");
                  break;
              case 16:
                  btnArr[i].setText("±");
                  btnArr[i].setActionCommand("±");
                  btnArr[i].setFont(new Font(Font.MONOSPACED,Font.TYPE1_FONT,20));
                 btnArr[i].setForeground(Color.orange);
                  break;
              default:
                  break;
          }
        panBtn.add(btnArr[i]);
        btnArr[i].addActionListener(hnd); 
      }
    }

}
