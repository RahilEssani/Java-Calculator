
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.pow;


public class BtnHandler implements ActionListener {

    GUI refg;
    boolean isOpt=false; 
    String prev="0",prev2="",opt="",preOpt="";
    boolean second_num=false,first_num=false,equal=false,intSecond=false;
    public BtnHandler(GUI g)
    {
        refg=g;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = e.getActionCommand();
        if (btnText.equals("1") || btnText.equals("2")|| btnText.equals("3")|| 
            btnText.equals("4") || btnText.equals("5") || btnText.equals("6") 
            || btnText.equals("7") || btnText.equals("8") || btnText.equals("9") || btnText.equals("0"))
        {
           
           
            if("0".equals(refg.tfMain.getText()))
            {
                refg.tfMain.setText("");
            }
            if(equal==true)
            {
                refg.tfMain.setText("");
                equal = false;
            }
            if(isOpt)
            {  
              
              if(first_num==true)
              {
                refg.tfMain.setText("");
                if(refg.tfMain.getText().length()<9)
                {
                first_num=false;
                intSecond=true;
                second_num=true;
                refg.tfMain.setText(btnText);
                prev2 = refg.tfMain.getText();
                preOpt="";
                }
              }
              else
              {
                if(refg.tfMain.getText().length()<9)
                {
                    refg.tfMain.setText(refg.tfMain.getText()+btnText);
                    prev2 = refg.tfMain.getText();
                    second_num=true;
                    intSecond=true;
                    first_num=false; 
                    preOpt="";
                }
              } 
            }
              
            else
            {
                if(refg.tfMain.getText().length()<9)
                {
                refg.tfMain.setText(refg.tfMain.getText()+btnText);
                prev=refg.tfMain.getText();
                first_num=true;
                preOpt="";
                }
            }
           
        }
        else if(btnText.equals("+") || btnText.equals("-") || btnText.equals("×")
                || btnText.equals("÷")|| btnText.equals("x²"))
        {
            preOpt=btnText;
            if(btnText.equals("x²")&&isOpt==false)
            {
                    refg.tfSub.setText(prev+"²");
                    second_num=true;
                    opt=btnText;
                    isOpt=true;
                    intSecond=true;
                    equalCalculations(e);
            }
            else if(second_num==false)
                {
                refg.tfSub.setText(prev+btnText);
                isOpt=true;
                opt=btnText;
                first_num=true;
                prev2="";
                intSecond=false;
                }
            else if (second_num==true)
            {
                equalCalculations(e);
                refg.tfSub.setText(prev+btnText);
                second_num=false;
                opt=btnText;
                isOpt=true;
                intSecond=false;
            }
        }
        else if(btnText.equals("C"))
        {
            preOpt="";
            refg.tfMain.setText("0");
            refg.tfSub.setText("");
            isOpt=false;
            opt="";
            second_num=false;
            intSecond=false;
            prev="0";
            prev2="";
            equal=false;
            first_num=false;
            preOpt="";
       
        }
        
        //for decimal
        else if(btnText.equals("."))
        {
            if(!equal)
            {
                if(refg.tfMain.getText().contains(".")==false && isOpt==false)
                {
                    prev=refg.tfMain.getText()+".";
                    refg.tfMain.setText(prev);
                }
                else if(refg.tfMain.getText().contains(".")==false && second_num!=false )
                {
                    prev2=refg.tfMain.getText()+".";
                    refg.tfMain.setText(prev2);
                    intSecond=true;
                }
            }
        }
        else if(btnText.equals("="))
        {
            preOpt="=";
            equalCalculations(e);
        }
        else if(btnText.equals("↩"))
        {
            
            if(!"=".equals(preOpt)&&!"+".equals(preOpt)&&!"-".equals(preOpt)&&!"×".equals(preOpt) 
                    &&!"÷".equals(preOpt) &&!"x²".equals(preOpt))
            {
            if(!"0".equals(refg.tfMain.getText()) && !"".equals(refg.tfMain.getText()))
            {
                refg.tfMain.setText(refg.tfMain.getText().substring(0,refg.tfMain.getText().length()-1));
                if(first_num==true && second_num==false)
                {
                    prev=refg.tfMain.getText();
                }
                else if (first_num==false && second_num==true)
                {
                    prev2=refg.tfMain.getText();
                }
            }
            
            if("".equals(refg.tfMain.getText()) || "-".equals(refg.tfMain.getText()))
            {
                refg.tfMain.setText("0");
                if(first_num==true && second_num==false)
                {
                    prev=refg.tfMain.getText();
                }
                else if (first_num==false && second_num==true)
                {
                    prev2=refg.tfMain.getText();
                    
                }
            }
        }
            
        }
        else if(btnText.equals("±"))
        {
          double i = Double.parseDouble(refg.tfMain.getText());
          if(i!=0 && equal==false)
          {
            if(refg.tfMain.getText().contains("-"))
                {
                refg.tfMain.setText(refg.tfMain.getText().replace("-", ""));
                }
                else
                {
                refg.tfMain.setText("-"+refg.tfMain.getText());
                }
            if(first_num==true && second_num==false && isOpt==false)
            {
                prev=refg.tfMain.getText();
            }
            else if (first_num==true && second_num==false && isOpt==true)
            {
                prev2=refg.tfMain.getText();
                intSecond=true;
            }
            else if (first_num==false && second_num==true)
            {
                prev2=refg.tfMain.getText();
            }
        }
      }
    }
private void equalCalculations(ActionEvent e)
{
    if(intSecond==false)
    {
        prev2=prev;
        double i = Double.parseDouble(prev);
        if(i==0)
        {
            prev="0";
        }
        else
        {
        prev= Double.toString(i);
        }
        prev2=prev;
        intSecond=true;
        
    }
    if("+".equals(opt))
    {
       double i =  Double.parseDouble(prev)+Double.parseDouble(prev2);
       if("Infinity".equals(Double.toString(i)) || "NaN".equals(Double.toString(i)) )
       {
           refg.tfSub.setText(prev+" + "+prev2+" =");
            refg.tfMain.setText(Double.toString(i));
       }
       else
       {
       String tempStr =Double.toString(i);
       String [] splitStr= tempStr.split("\\.");
       if (prev.endsWith("."))
       {
           prev = prev.replace(".", "");
       }
       else if (prev2.endsWith("."))
       {
           prev2=prev2.replace(".", "");
       }
        if("0".equals(splitStr[1]))
        {
            refg.tfSub.setText(prev+" + "+prev2+" =");
            refg.tfMain.setText(splitStr[0]);
            prev=splitStr[0];
        }
        else
        {
            refg.tfSub.setText(prev+" + "+prev2+" =");
            refg.tfMain.setText(tempStr);
            prev=tempStr;
        }
       }
       isOpt=false;
       second_num=false;
       equal=true;

    }
    else if("-".equals(opt))
    {
       double i =  Double.parseDouble(prev)-Double.parseDouble(prev2);
       if("Infinity".equals(Double.toString(i)) || "NaN".equals(Double.toString(i)) )
       {
           refg.tfSub.setText(prev+" - "+prev2+" =");
            refg.tfMain.setText(Double.toString(i));
       }
       else
       {
       String tempStr =Double.toString(i);
       String [] splitStr= tempStr.split("\\.");
       if (prev.endsWith("."))
       {
           prev = prev.replace(".", "");
       }
       else if (prev2.endsWith("."))
       {
           prev2=prev2.replace(".", "");
       }
        if("0".equals(splitStr[1]))
        {
            refg.tfSub.setText(prev+" - "+prev2+" =");
            refg.tfMain.setText(splitStr[0]);
            prev=splitStr[0];
        }
        else
        {
            refg.tfSub.setText(prev+" - "+prev2+" =");
            refg.tfMain.setText(tempStr);
            prev=tempStr;
        }
      } 
       isOpt=false;
       second_num=false;
       equal=true;
    }
     else if("×".equals(opt))
    {

       double i =  Double.parseDouble(prev)*Double.parseDouble(prev2);
       if("Infinity".equals(Double.toString(i)) || "NaN".equals(Double.toString(i)) )
       {
           refg.tfSub.setText(prev+" × "+prev2+" =");
            refg.tfMain.setText(Double.toString(i));
       }
       else
       {
       String tempStr =Double.toString(i);
       String [] splitStr= tempStr.split("\\.");
       if (prev.endsWith("."))
       {
           prev = prev.replace(".", "");
       }
       else if (prev2.endsWith("."))
       {
           prev2=prev2.replace(".", "");
       }
        if("0".equals(splitStr[1]))
        {
            refg.tfSub.setText(prev+" × "+prev2+" =");
            refg.tfMain.setText(splitStr[0]);
            prev=splitStr[0];
        }
        else
        {
            refg.tfSub.setText(prev+" × "+prev2+" =");
            refg.tfMain.setText(tempStr);
            prev=tempStr;
        }
    }
       isOpt=false;
       second_num=false;
       equal=true;

    }
     else if("÷".equals(opt))
    {
       double i =  Double.parseDouble(prev)/Double.parseDouble(prev2);
       if("Infinity".equals(Double.toString(i)) || "NaN".equals(Double.toString(i)) )
       {
           refg.tfSub.setText(prev+" ÷ "+prev2+" =");
            refg.tfMain.setText(Double.toString(i));
       }
       else
       {
        String tempStr =Double.toString(i);
        String [] splitStr= tempStr.split("\\.");
        if (prev.endsWith("."))
       {
           prev = prev.replace(".", "");
       }
       else if (prev2.endsWith("."))
       {
           prev2=prev2.replace(".", "");
       }
            
            if("0".equals(splitStr[1]))
            {
                refg.tfSub.setText(prev+" ÷ "+prev2+" =");
                refg.tfMain.setText(splitStr[0]);
                prev=splitStr[0];
            }
            else
            {
                refg.tfSub.setText(prev+" ÷ "+prev2+" =");
                refg.tfMain.setText(tempStr);
                prev=tempStr;
            }
        }
       isOpt=false;
       second_num=false;
       equal=true;
    }
    else if("x²".equals(opt))
    {
        prev2="2";
       double i =   Math.pow(Double.parseDouble(prev), Double.parseDouble(prev2));
       if("Infinity".equals(Double.toString(i)) || "NaN".equals(Double.toString(i)) )
       {
           refg.tfSub.setText(prev+"²"+" =");
            refg.tfMain.setText(Double.toString(i));
       }
       else
       {
       String tempStr =Double.toString(i);
       String [] splitStr= tempStr.split("\\.");
       if (prev.endsWith("."))
       {
           prev = prev.replace(".", "");
       }
       else if (prev2.endsWith("."))
       {
           prev2=prev2.replace(".", "");
       }
            if("0".equals(splitStr[1]))
            {
                refg.tfSub.setText(prev+"²"+" =");
                refg.tfMain.setText(splitStr[0]);
                prev=splitStr[0];
            }
            else
            {
                refg.tfSub.setText(prev+"²"+ " =");
                refg.tfMain.setText(tempStr);
                prev=tempStr;
            }
       }               
       isOpt=false;
       second_num=false;
       equal=true;
    }
    else
    {
       
       if (prev.endsWith("."))
       {
           prev = prev.replace(".", "");
       }
       else if (prev2.endsWith("."))
       {
           prev2=prev2.replace(".", "");
       }
       refg.tfSub.setText(prev+" =");
       refg.tfMain.setText(prev);
       isOpt=false;
       second_num=false;
       equal=true;
    }
  }

}
    
        
  
