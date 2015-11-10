import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Arr {

	public static void main(String[] args) {
		// TODO Автоматически созданная заглушка метода

	}

}





class CalcView1 extends JFrame{

private static final long serialVersionUID = 1L;

private CalcController calcController = null;

private JTextField  ditString;
private JButton  btn1;
private JButton  btn2;
private JButton  btn3;
private JButton  btn4;
private JButton  btn5;
private JButton  btn6;
private JButton  btn7;
private JButton  btn8;
private JButton  btn9;
private JButton  btn0;

private JButton  btnC;
private JButton  btnPlus;
private JButton  btnMinus;
private JButton  btnMul;
private JButton  btnDiv;
private JButton  btnNegative;
private JButton  btnPoint;
private JButton  btnEquals;

public CalcView1(String title)
{
super(title);

calcController = CalcController.getInstance();

this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setSize(250, 195);
this.setLayout(new FlowLayout()); 

ditString = new JTextField(20);
calcController.setTextComponent(ditString);

ditString.setHorizontalAlignment(JTextField.RIGHT);
btn1 = new JButton("1");  btn1.setActionCommand("1");
btn2 = new JButton("2");  btn2.setActionCommand("2");
btn3 = new JButton("3");  btn3.setActionCommand("3");
btnC = new JButton("C");
btnC.setPreferredSize(new Dimension(84, 26));
btn4 = new JButton("4");  btn4.setActionCommand("4");
btn5 = new JButton("5");  btn5.setActionCommand("5");
btn6 = new JButton("6");  btn6.setActionCommand("6");
btnPlus = new JButton("+");  btnPlus.setActionCommand("0");
btnMinus = new JButton("-"); btnMinus.setActionCommand("1");
btn7 = new JButton("7");  btn7.setActionCommand("7");
btn8 = new JButton("8");  btn8.setActionCommand("8");
btn9 = new JButton("9");  btn9.setActionCommand("9");
btnMul = new JButton("*");  btnMul.setActionCommand("2");
btnDiv = new JButton("/");  btnDiv.setActionCommand("3");
btn0 = new JButton("0");  btn0.setActionCommand("0");
btnPoint = new JButton(","); btnPoint.setActionCommand(".");
btnNegative = new JButton("/-/");
btnEquals = new JButton("=");
btnEquals.setPreferredSize(new Dimension(84, 26));

ActionListener numActionListener = new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.SetNumberText(e.getActionCommand());
 }
 };

btn1.addActionListener(numActionListener);

btn2.addActionListener(numActionListener);

btn3.addActionListener(numActionListener);

btn4.addActionListener(numActionListener);

btn5.addActionListener(numActionListener);

btn6.addActionListener(numActionListener);

btn7.addActionListener(numActionListener);

btn8.addActionListener(numActionListener);

btn9.addActionListener(numActionListener);

btn0.addActionListener(numActionListener);

btnC.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.ClearNumberText();
 }
 }
 );

btnNegative.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.SetNegativeSign();
 }
 }
 );

btnPlus.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.SetOperation(0);
 }
 }
 );

btnMinus.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.SetOperation(1);
 }
 }
 );

btnMul.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.SetOperation(2);
 }
 }
 );

btnDiv.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.SetOperation(3);
 }
 }
 );

btnPoint.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.SetNumberText(".");
 }
 }
 );

btnEquals.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e) {
  calcController.GetResult();
 }
 }
 );

this.add(ditString);
this.add(btn1);
this.add(btn2);
this.add(btn3);
this.add(btnC);
this.add(btn4);
this.add(btn5);
this.add(btn6);
this.add(btnPlus);
this.add(btnMinus);
this.add(btn7);
this.add(btn8);
this.add(btn9);
this.add(btnMul);
this.add(btnDiv);
this.add(btn0);
this.add(btnNegative);
this.add(btnPoint);
this.add(btnEquals);
}
}



class CalcModel {

private double firstNum = 0;

private double secondNumber = 0;

private int operationCode = 0;

private int errorCode = -1;

public void setFirstNum(double firstNum) {
this.firstNum = firstNum;
}

public void setSecondNumber(double secondNumber) {
this.secondNumber = secondNumber;
}

public void setOperationCode(int operationCode) {
this.operationCode = operationCode;
}

public int getErrorCode() {
return errorCode;
}

private double Summ()
{
errorCode = -1;
return firstNum + secondNumber;
}

private double Sub()
{
errorCode = -1;
return firstNum - secondNumber;
}

private double Mul()
{
errorCode = -1;
return firstNum * secondNumber;
}

private double Div()
{
if (this.secondNumber != 0)
{
 return firstNum / secondNumber;
}
else
{
 errorCode = 0;
 return 0;
}
}

public double GetResult()
{
double result = 0;
switch (this.operationCode) {
case 0:
 result = Summ();
 break;
case 1:
 result = Sub();
 break;
case 2:
 result = Mul();
 break;
case 3:
 result = Div();
 break; 
default:
 result = 0;
 break;
}

return result;
}
}



import javax.swing.JTextField;


class CalcController {

private JTextField  ditString = null;

private static CalcController instance = null;

private CalcModel  calcModel;

public static CalcController getInstance() {
if (instance==null) {
 instance = new CalcController();
}
return instance;
}

public void setTextComponent(JTextField textComponent) {
this.ditString = textComponent;
}

public CalcController()
{
calcModel = new CalcModel();
}

public void SetNumberText(String num)
{
String lastDit = this.ditString.getText();
if ((lastDit.equals("")) && (num.equals("."))){num = "";}
this.ditString.setText(lastDit+num);
}

public void ClearNumberText()
{
this.ditString.setText("");
}

public void SetNegativeSign()
{
String lastDit = this.ditString.getText();
this.ditString.setText("-"+lastDit);
}

public void SetOperation(int operationCode)
{
calcModel.setOperationCode(operationCode);
if (calcModel.getErrorCode() == -1)
calcModel.setFirstNum(Double.parseDouble(this.ditString.getText()));
this.ditString.setText("");
}

public void GetResult()
{
String resultString = "";
double result = 0;
calcModel.setSecondNumber(Double.parseDouble(this.ditString.getText()));
result = calcModel.GetResult();
if (calcModel.getErrorCode() == 0) resultString = "Попытка деления на ноль!";
else resultString = String.valueOf(result);
this.ditString.setText(resultString);
}
}
