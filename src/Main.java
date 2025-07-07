import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    //VARIABLE
    double num1;
    double num2;
    double result;
    char operator;

    //TEXT FIELD
    JTextField tf=new JTextField();

    //NUMBER BUTTONS
    JButton[] numberButtons=new JButton[10];

    //FUNCTION BUTTONS
    JButton[] functionButtons=new JButton[9];

    JButton addButton=new JButton("+");
    JButton subButton=new JButton("-");
    JButton divButton=new JButton("/");
    JButton mulButton=new JButton("*");
    JButton equButton=new JButton("=");
    JButton clrButton=new JButton("Clear");
    JButton delButton=new JButton("Delete");
    JButton negativeButton=new JButton("(-)");
    JButton decButton=new JButton(".");

    //PANEL
    JPanel panel=new JPanel();

    //CONSTRUCTOR
    Main()
    {
        //TEXT FIELD
        tf.setBounds(50,0,350,50);
        tf.setEditable(false);
        tf.setBackground(Color.white);
        tf.setBorder(BorderFactory.createLineBorder(Color.black,3));

        //FUNCTION BUTTONS
        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=equButton;
        functionButtons[5]=decButton;
        functionButtons[6]=negativeButton;
        functionButtons[7]=delButton;
        functionButtons[8]=clrButton;

        for(int i=0;i<9;i++) {
            functionButtons[i].setFocusable(false);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setBackground(new Color(0xB2F2BB));
            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }

        negativeButton.setBounds(50,400,120,50);
        negativeButton.setBackground(new Color(0xFFD8B1));
        delButton.setBounds(170,400,120,50);
        delButton.setBackground(new Color(0xFFD8B1));
        clrButton.setBounds(290,400,110,50);
        clrButton.setBackground(new Color(0xFFD8B1));



        //NUMBER BUTTONS
        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(0xAEDFF7));
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }

        //PANEL
        panel.setBounds(50,50,350,350);
        panel.setBackground(Color.pink);
        panel.setLayout(new GridLayout(4,4,1,1));

        panel.add(numberButtons[0]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(functionButtons[0]);

        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(functionButtons[1]);

        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(functionButtons[2]);

        panel.add(numberButtons[9]);
        panel.add(functionButtons[3]);
        panel.add(functionButtons[4]);
        panel.add(functionButtons[5]);

        //FRAME
        this.add(functionButtons[6]);
        this.add(functionButtons[7]);
        this.add(functionButtons[8]);
        this.add(panel);
        this.add(tf);
        this.setTitle("CALCULATOR");
        this.getContentPane().setBackground(Color.pink);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(450,500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //NUMBER BUTTONS ACTIONS
        for(int i=0;i<10;i++) {
           if(e.getSource()==numberButtons[i])
               tf.setText(tf.getText()+String.valueOf(i));
        }

        //FUNCTION BUTTONS ACTIONS
        //ADDITION
        if(e.getSource()==addButton)
        {
            num1=Double.parseDouble(tf.getText());
            operator='+';
            tf.setText("");
        }
        //SUBTRACTION
        if(e.getSource()==subButton)
        {
            num1=Double.parseDouble(tf.getText());
            operator='-';
            tf.setText("");
        }
        //MULTIPLICATION
        if(e.getSource()==mulButton)
        {
            num1=Double.parseDouble(tf.getText());
            operator='*';
            tf.setText("");
        }
        //DIVISION
        if(e.getSource()==divButton)
        {
            num1=Double.parseDouble(tf.getText());
            operator='/';
            tf.setText("");
        }
        //DECIMAL POINT
        if(e.getSource()==decButton)
        {
            if(!tf.getText().contains(".")) {
                tf.setText(tf.getText() + ".");
                num1 = Double.parseDouble(tf.getText());
            }
        }
        //NEGATIVE
        if(e.getSource()==negativeButton)
        {
            double temp=Double.parseDouble(tf.getText());
            temp*=-1;
            tf.setText(String.valueOf(temp));
            num1=temp;
        }
        //DELETE
        if(e.getSource()==delButton)
        {
              tf.setText("");
        }
        //CLEAR
        if(e.getSource()==clrButton)
        {
         String str=tf.getText();
         str=str.substring(0,str.length()-1);
         tf.setText(str);
         num1=Double.parseDouble(str);
        }
        //EQUAL TO
        if(e.getSource()==equButton)
        {
            num2=Double.parseDouble(tf.getText());

            switch(operator)
            {
                case '+':result=num1+num2;
                break;
                case '-':result=num1-num2;
                break;
                case '*':result=num1*num2;
                break;
                case '/':
                    if(num2==0)
                    {
                        tf.setText("ERROR");

                        return;
                    }
                    else {
                        result = num1 / num2;
                    }
                break;
            }
            tf.setText(String.valueOf(result));
            num1=result;
        }


    }
}