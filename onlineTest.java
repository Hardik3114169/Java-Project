import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class OnlineTest extends JFrame implements ActionListener
{
JLabel label;
JRadioButton rb[]=new JRadioButton[5];
JButton bt1,bt2;
ButtonGroup gb;
int marks=0,question=0,x=1,y=1,now=0;
int m[]=new int[10];	
OnlineTest(String s)
{
super(s);
label=new JLabel();
add(label);
gb=new ButtonGroup();
for(int i=0;i<5;i++)
{
rb[i]=new JRadioButton();	
add(rb[i]);
gb.add(rb[i]);
}
bt1=new JButton("Next");
bt2=new JButton("Bookmark");
bt1.addActionListener(this);
bt2.addActionListener(this);
add(bt1);add(bt2);
set();
label.setBounds(30,40,450,20);
rb[0].setBounds(50,80,100,20);
rb[1].setBounds(50,110,100,20);
rb[2].setBounds(50,140,100,20);
rb[3].setBounds(50,170,100,20);
bt1.setBounds(100,240,100,30);
bt2.setBounds(270,240,100,30);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
setLocation(250,100);
setVisible(true);
setSize(600,350);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bt1)
{
if(check())
marks=marks+1;
question++;
set();	
if(question==9)
{
bt1.setEnabled(false);
bt2.setText("Result");
}
}
if(e.getActionCommand().equals("Bookmark"))
{
JButton bookMark=new JButton("Bookmark"+x);
bookMark.setBounds(480,20+30*x,100,30);
add(bookMark);
bookMark.addActionListener(this);
m[x]=question;
x++;
question++;
set();	
if(question==9)
bt2.setText("Result");
setVisible(false);
setVisible(true);
}
for(int i=0,y=1;i<x;i++,y++)
{
if(e.getActionCommand().equals("Bookmark"+y))
{
if(check())
marks=marks+1;
now=question;
question=m[y];
set();
((JButton)e.getSource()).setEnabled(false);
question=now;
}
}
if(e.getActionCommand().equals("Result"))
{
if(check())
marks=marks+1;
question++;
JOptionPane.showMessageDialog(this,"correct ans="+marks);
System.exit(0);
}
}
void set()
{
rb[4].setSelected(true);
if(question==0)
{
label.setText("Que1: Which one among these is not a datatype");
rb[0].setText("int");rb[1].setText("Float");rb[2].setText("boolean");rb[3].setText("char");	
}
if(question==1)
{
label.setText("Que2: Which class is available to all the class automatically");
rb[0].setText("Swing");rb[1].setText("Applet");rb[2].setText("Object");rb[3].setText("ActionEvent");
}
if(question==2)
{
label.setText("Que3: Which package is directly available to our class without importing it");
rb[0].setText("swing");rb[1].setText("applet");rb[2].setText("net");rb[3].setText("lang");
}
if(question==3)
{
label.setText("Que4: String class is defined in which package");
rb[0].setText("lang");rb[1].setText("Swing");rb[2].setText("Applet");rb[3].setText("awt");
}
if(question==4)
{
label.setText("Que5: Which institute is best for java coaching");
rb[0].setText("Utek");rb[1].setText("Aptech");rb[2].setText("SSS IT");rb[3].setText("jtek");
}
if(question==5)
{
label.setText("Que6: Which one among these is not a keyword");
rb[0].setText("class");rb[1].setText("int");rb[2].setText("get");rb[3].setText("if");
}
if(question==6)
{
label.setText("Que7: Which one among these is not a class ");
rb[0].setText("Swing");rb[1].setText("Actionperformed");rb[2].setText("ActionEvent");rb[3].setText("Button");
}
if(question==7)
{
label.setText("Que8: which one among these is not a function of Object class");
rb[0].setText("toString");rb[1].setText("finalize");rb[2].setText("equals");rb[3].setText("getDocumentBase");		
}
if(question==8)
{
label.setText("Que9: which function is not present in Applet class");
rb[0].setText("init");rb[1].setText("main");rb[2].setText("start");rb[3].setText("destroy");
}
if(question==9)
{
label.setText("Que10: Which one among these is not a valid component");
rb[0].setText("JButton");rb[1].setText("JList");rb[2].setText("JButtonGroup");rb[3].setText("JTextArea");
}
label.setBounds(30,40,450,20);
for(int i=0,j=0;i<=90;i+=30,j++)
rb[j].setBounds(50,80+i,200,20);
}
boolean check()
{
if(question==0)
return(rb[1].isSelected());
if(question==1)
return(rb[2].isSelected());
if(question==2)
return(rb[3].isSelected());
if(question==3)
return(rb[0].isSelected());
if(question==4)
return(rb[2].isSelected());
if(question==5)
return(rb[2].isSelected());
if(question==6)
return(rb[1].isSelected());
if(question==7)
return(rb[3].isSelected());
if(question==8)
return(rb[1].isSelected());
if(question==9)
return(rb[2].isSelected());
return false;
}
public static void main(String s[])
{
new OnlineTest("Online Test Of Java");
}
}