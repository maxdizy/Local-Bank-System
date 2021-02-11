/*Max Dizy
Feburary, 16th 2021
ICS4U
Mr. Hofstatter
bankSystemClient
JAVA bank system for a emplyee to create, edit and remove banking records as well as manipulate user accounts*/
//package textFiles;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class bankSystemClient implements ActionListener{

  //initilize JFrame
  public static JFrame frame = new JFrame("Dizy Bank");
  public static JPanel panel = new JPanel();

  //shared global variables
  private static String name;
  private static String ID;
  private static Double balance;

  //welcome global variables
  private static JLabel welcome;
  private static JLabel options;
  private static JLabel taskLbl;
  private static JTextField taskText = new JTextField(12);
  private static JButton continueBut;
  private static JLabel taskSuccess;
  private static JButton returnBut;

  //deposit global variables
  private static JLabel nameLbl;
  private static JTextField nameText = new JTextField(12);
  private static JLabel customerIDLbl;
  private static JTextField customerIDText = new JTextField(12);
  private static JLabel depositLbl;
  private static JTextField depositText = new JTextField(12);
  private static JButton depositBut;
  private static JLabel nameSuccess;
  private static JLabel IDSuccess;
  private static JLabel depositSuccess;

  //welcome page
  public static void welcomePage(){
    //set layout to null
    panel.setLayout(null);

    //welcome label
    welcome = new JLabel("Welcome to the Dizy Bank System");
    welcome.setBounds(400, 20, 400, 25);
    panel.add(welcome);

    //options label
    options = new JLabel("Deposit('d'), Withdraw('w'), Check Balance('c'), Report all Customer Accounts('r'), Create Account('create'), Remove Account('remove')");
    options.setBounds(100, 50, 982, 25);
    panel.add(options);

    //task select label
    taskLbl = new JLabel("Please Select a Task: ");
    taskLbl.setBounds(300, 100, 150, 25);
    panel.add(taskLbl);
    taskText.setBounds(450, 100, 150, 25);
    panel.add(taskText);

    //continue button
    continueBut = new JButton("continue");
    continueBut.setBounds(800, 175, 100, 25);
    continueBut.addActionListener(new bankSystemClient());
    panel.add(continueBut);

    //return button
    returnBut = new JButton("return");
    returnBut.setBounds(50, 425, 100, 25);
    returnBut.addActionListener(new bankSystemClient());
    panel.add(returnBut);

    //taskSuccess
    taskSuccess = new JLabel("");
    taskSuccess.setBounds(450, 125, 300, 25);
    panel.add(taskSuccess);

    //add welcome panel to frame
    frame.add(panel);
  }

  //deposit
  public static void deposit(){
    continueBut.setVisible(false);

    //name label
    nameLbl = new JLabel("Customer Name: ");
    nameLbl.setBounds(50, 200, 100, 25);
    panel.add(nameLbl);
    nameText.setBounds(175, 200, 200, 25);
    panel.add(nameText);

    //customer ID
    customerIDLbl = new JLabel("Customer ID: ");
    customerIDLbl.setBounds(550, 200, 100, 25);
    panel.add(customerIDLbl);
    customerIDText.setBounds(650, 200, 200, 25);
    panel.add(customerIDText);

    //how much to deposit
    depositLbl = new JLabel("How much would you like to deposit?      $");
    depositLbl.setBounds(50, 275, 250, 25);
    panel.add(depositLbl);
    depositText.setBounds(290, 275, 150, 25);
    panel.add(depositText);

    //deposit button
    depositBut = new JButton("complete");
    depositBut.setBounds(800, 425, 100, 25);
    depositBut.addActionListener(new bankSystemClient());
    panel.add(depositBut);

    //nameSuccess
    nameSuccess = new JLabel("");
    nameSuccess.setBounds(175, 225, 300, 25);
    panel.add(nameSuccess);

    //IDSuccess
    IDSuccess = new JLabel("");
    IDSuccess.setBounds(650, 225, 300, 25);
    panel.add(IDSuccess);

    //deposit success
    depositSuccess = new JLabel("");
    depositSuccess.setBounds(275, 300, 300, 25);
    panel.add(depositSuccess);

    //repack frame
    frame.pack();
    frame.setSize(992, 558);
  }

  public void actionPerformed(ActionEvent e){
    //return button
    if (e.getSource() == returnBut){
      quit();
    }

    //continue button
    if (e.getSource() == continueBut){
      //get inputted values
      String task = taskText.getText().toLowerCase();

      //create array list of possible entries and check
      List <String> possible = Arrays.asList("d", "w", "c", "r", "create", "remove");
      if (verification.inPossibleStringEntries(task, possible)){
        taskSuccess.setText("success.");
        deposit();
      }
      else{
        taskSuccess.setText("Invalid input, Please try again from the options above.");
      }
    }

    //deposite button
    if (e.getSource() == depositBut){
      //check if approved value
      boolean depositApproved = true;

      //unique variables
      name = nameText.getText().toLowerCase();
      ID = customerIDText.getText().toLowerCase();
      String deposit = depositText.getText().toLowerCase();
      Double depositNum = 0.0;

      //check name
      if (verification.checkName(name)){
        name = nameText.getText().toLowerCase();
        nameSuccess.setText("success.");
      }
      else{
        nameSuccess.setText("Invalid input, Please only enter letters.");
        depositApproved = false;
      }
      //check ID
      if (verification.checkName(ID)){
        ID = customerIDText.getText().toLowerCase();
        IDSuccess.setText("success.");
      }
      else{
        IDSuccess.setText("Invalid input, Customer ID incorrect.");
        depositApproved = false;
      }
      //check deposit
      if (verification.checkInt(deposit)){
        deposit = depositText.getText().toLowerCase();
        depositNum = Double.parseDouble(deposit);
        depositSuccess.setText("success.");
      }
      else{
        depositSuccess.setText("Invalid input, Please only enter numbers.");
        depositApproved = false;
      }
      if (depositApproved){
        balance = 100 + depositNum;
        recordInfo(name, ID, balance);
        confirmation();
      }
    }
  }

  public static void recordInfo(String name, String ID, Double balance){
    try{
      FileReader reader = new FileReader("notTheBankDatabase.txt");
      BufferedReader bufferedReader = new BufferedReader(reader);
      FileWriter writer = new FileWriter("notTheBankDatabase.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      bufferedWriter.write(name + "/" + ID + "/" + balance);
      bufferedWriter.newLine();

      bufferedWriter.close();
    }
    catch(Exception e){
      System.out.println("Buffer Reader/Writer Issue... Report: " + e);
    }
  }

  public static void confirmation(){
    System.out.println("confirm");
  }

  //quit to welcome screen
  public static void quit(){
    panel.removeAll();
    frame.pack();
    frame.setSize(992, 558);
    welcomePage();
  }

  public static void main(String[] args) {
    //initilize specs
      frame.setSize(992, 558);
      welcomePage();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
  }
}
