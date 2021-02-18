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
  private static List<String> names = new ArrayList<String>();
  private static List<String> IDs = new ArrayList<String>();
  private static List<String> balances = new ArrayList<String>();
  private static ArrayList<String> info = new ArrayList<String>();

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
  private static JLabel errorLbl;

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
    nameLbl.setBounds(50, 200, 125, 25);
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
    depositLbl = new JLabel("How much would you like to deposit?    $");
    depositLbl.setBounds(50, 300, 250, 25);
    panel.add(depositLbl);
    depositText.setBounds(290, 300, 150, 25);
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
    depositSuccess.setBounds(290, 325, 300, 25);
    panel.add(depositSuccess);

    //error label
    errorLbl = new JLabel("");
    errorLbl.setBounds(250, 400, 500, 25);
    panel.add(errorLbl);

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
      if (verification.checkDouble(deposit)){
        deposit = depositText.getText().toLowerCase();
        depositNum = Double.parseDouble(deposit);
        depositSuccess.setText("success.");
      }
      else{
        depositSuccess.setText("Invalid input, Please only enter numbers.");
        depositApproved = false;
      }
      if (depositApproved){
        if(verify(name, ID)){
          depositTo(name, ID, depositNum);
        }
        else{
          errorLbl.setText("Sorry this account does not exist. Please Check Spelling or Create Account");
        }
      }
  }
  }

  public static boolean verify(String name, String ID){
    readFile();
    if((verification.inPossibleStringEntries(name, names)) && (verification.inPossibleStringEntries(ID, IDs))){
      return true;
    }
    else{
      errorLbl.setText("Sorry this account does not exist. Please Check Spelling or Create Account");
      return false;
    }
  }

  public static void depositTo(String name, String ID, Double deposit){
    readFile();
    int index = names.indexOf(name);
    String changable = info.get(index);
    String[] parts = changable.split("/");
    parts[2] = String.valueOf(Double.parseDouble(parts[2]) + deposit);
    String changed = String.join("/",parts[0], parts[1], parts[2]);
    info.set(index, changed);
    updateFile();
  }

  public static void newAccount(String name, String ID, Double balance){
    try{
      FileWriter writer = new FileWriter("notTheBankDatabase.txt", true);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      bufferedWriter.write(name + "/" + ID + "/" + balance);
      bufferedWriter.newLine();
      bufferedWriter.close();
    }
    catch(Exception e){
      System.out.println("Buffer Reader/Writer Issue... Report: " + e);
    }
  }

  public static void confirmation(String name, String ID, String task){
    System.out.println("confirm");
  }

  public static void readFile(){
    //clear info
    names.clear();
    IDs.clear();
    info.clear();

    //rewrite new info
    try{
      FileReader reader = new FileReader("notTheBankDatabase.txt");
      BufferedReader bufferedReader = new BufferedReader(reader);
      String line;

      while((line = bufferedReader.readLine()) != null){
        info.add(line);
        String[] parts = line.split("/");
        names.add(parts[0]);
        IDs.add(parts[1]);
        balances.add(parts[2]);
      }}
    catch(Exception e){
        System.out.print("Error reading file..." + e);
      }
    }

  public static void updateFile(){
    try{
      //clear file
      FileWriter writerDel = new FileWriter("notTheBankDatabase.txt");
      BufferedWriter bufferedWriterDel = new BufferedWriter(writerDel);
      bufferedWriterDel.write("");
      bufferedWriterDel.close();

      //rewrite new info
      FileWriter writer = new FileWriter("notTheBankDatabase.txt", true);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      for (String user : info){
        bufferedWriter.write(user);
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
    }
    catch(Exception e){
      System.out.println("Buffer Reader/Writer Issue... Report: " + e);
    }
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
