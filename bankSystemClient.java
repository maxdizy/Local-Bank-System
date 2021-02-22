/*Max Dizy
Feburary, 16th 2021
ICS4U
Mr. Hofstatter
bankSystemClient
JAVA bank system for a emplyee to create, edit and remove banking records as well as manipulate user accounts*/

import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.lang.Math;

public class bankSystemClient implements ActionListener{

  //initilize JFrame
  public static JFrame frame = new JFrame("Dizy Bank");
  public static JPanel panel = new JPanel();

  //shared global variables
  private static String task;
  private static String name;
  private static String ID;
  private static Double balance = 0.0;
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

  //change global variables
  private static JLabel nameLbl;
  private static JTextField nameText = new JTextField(12);
  private static JLabel customerIDLbl;
  private static JTextField customerIDText = new JTextField(12);
  private static JLabel changeLbl;
  private static JTextField changeText = new JTextField(12);
  private static JButton changeBut;
  private static JLabel nameSuccess;
  private static JLabel IDSuccess;
  private static JLabel changeSuccess;
  private static JLabel errorLbl;
  private static JLabel balanceLbl;
  private static JLabel startBalanceLbl;
  private static JTextField startBalanceText = new JTextField(12);
  private static JLabel balanceSuccess;
  private static JLabel confirmLbl;
  private static JButton confirmBut;
  private static boolean confirm = false;
  private static boolean changeApproved = true;
  private static String change;
  private static String startBalance;
  private static Double changeNum;
  private static JButton nextPageBut;
  private static int page = 1;

  //welcome page
  public static void welcomePage(){
    //set layout to null
    panel.setLayout(null);
    //read file
    readFile();

    //reset variables
    page = 1;

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
    taskSuccess.setBounds(450, 125, 400, 25);
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
    changeLbl = new JLabel("How much would you like to deposit?    $");
    changeLbl.setBounds(50, 300, 250, 25);
    panel.add(changeLbl);
    changeText.setBounds(290, 300, 150, 25);
    panel.add(changeText);

    //deposit button
    changeBut = new JButton("complete");
    changeBut.setBounds(800, 425, 100, 25);
    changeBut.addActionListener(new bankSystemClient());
    panel.add(changeBut);

    //nameSuccess
    nameSuccess = new JLabel("");
    nameSuccess.setBounds(175, 225, 300, 25);
    panel.add(nameSuccess);

    //IDSuccess
    IDSuccess = new JLabel("");
    IDSuccess.setBounds(650, 225, 300, 25);
    panel.add(IDSuccess);

    //deposit success
    changeSuccess = new JLabel("");
    changeSuccess.setBounds(290, 325, 300, 25);
    panel.add(changeSuccess);

    //error label
    errorLbl = new JLabel("");
    errorLbl.setBounds(250, 400, 500, 25);
    panel.add(errorLbl);

    //repack frame
    frame.pack();
    frame.setSize(992, 558);
  }

  //withdraw
  public static void withdraw(){
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
    changeLbl = new JLabel("How much would you like to Withdraw?    $");
    changeLbl.setBounds(50, 300, 250, 25);
    panel.add(changeLbl);
    changeText.setBounds(310, 300, 150, 25);
    panel.add(changeText);

    //deposit button
    changeBut = new JButton("complete");
    changeBut.setBounds(800, 425, 100, 25);
    changeBut.addActionListener(new bankSystemClient());
    panel.add(changeBut);

    //nameSuccess
    nameSuccess = new JLabel("");
    nameSuccess.setBounds(175, 225, 300, 25);
    panel.add(nameSuccess);

    //IDSuccess
    IDSuccess = new JLabel("");
    IDSuccess.setBounds(650, 225, 300, 25);
    panel.add(IDSuccess);

    //deposit success
    changeSuccess = new JLabel("");
    changeSuccess.setBounds(290, 325, 300, 25);
    panel.add(changeSuccess);

    //error label
    errorLbl = new JLabel("");
    errorLbl.setBounds(250, 400, 500, 25);
    panel.add(errorLbl);

    //repack frame
    frame.pack();
    frame.setSize(992, 558);
  }

  //check
  public static void check(){
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

    //deposit button
    changeBut = new JButton("complete");
    changeBut.setBounds(800, 425, 100, 25);
    changeBut.addActionListener(new bankSystemClient());
    panel.add(changeBut);

    //nameSuccess
    nameSuccess = new JLabel("");
    nameSuccess.setBounds(175, 225, 300, 25);
    panel.add(nameSuccess);

    //IDSuccess
    IDSuccess = new JLabel("");
    IDSuccess.setBounds(650, 225, 300, 25);
    panel.add(IDSuccess);

    //balance label
    balanceLbl = new JLabel("");
    balanceLbl.setBounds(350, 300, 500, 25);
    panel.add(balanceLbl);

    //error label
    errorLbl = new JLabel("");
    errorLbl.setBounds(250, 400, 500, 25);
    panel.add(errorLbl);

    //repack frame
    frame.pack();
    frame.setSize(992, 558);
  }

  //create
  public static void create(){
    continueBut.setVisible(false);

    //name label
    nameLbl = new JLabel("Customer Name: ");
    nameLbl.setBounds(50, 200, 125, 25);
    panel.add(nameLbl);
    nameText.setBounds(175, 200, 200, 25);
    panel.add(nameText);

    //starting balance
    startBalanceLbl = new JLabel("Starting Balance: ");
    startBalanceLbl.setBounds(550, 200, 200, 25);
    panel.add(startBalanceLbl);
    startBalanceText.setBounds(675, 200, 200, 25);
    panel.add(startBalanceText);

    //complete button
    changeBut = new JButton("complete");
    changeBut.setBounds(800, 425, 100, 25);
    changeBut.addActionListener(new bankSystemClient());
    panel.add(changeBut);

    //nameSuccess
    nameSuccess = new JLabel("");
    nameSuccess.setBounds(175, 225, 300, 25);
    panel.add(nameSuccess);

    //starting balance success
    balanceSuccess = new JLabel("");
    balanceSuccess.setBounds(675, 225, 300, 25);
    panel.add(balanceSuccess);

    //repack frame
    frame.pack();
    frame.setSize(992, 558);
  }

  //remove
  public static void remove(){
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

    //complete button
    changeBut = new JButton("complete");
    changeBut.setBounds(800, 425, 100, 25);
    changeBut.addActionListener(new bankSystemClient());
    panel.add(changeBut);

    //nameSuccess
    nameSuccess = new JLabel("");
    nameSuccess.setBounds(175, 225, 300, 25);
    panel.add(nameSuccess);

    //IDSuccess
    IDSuccess = new JLabel("");
    IDSuccess.setBounds(650, 225, 300, 25);
    panel.add(IDSuccess);

    //error label
    errorLbl = new JLabel("");
    errorLbl.setBounds(250, 400, 500, 25);
    panel.add(errorLbl);

    //repack frame
    frame.pack();
    frame.setSize(992, 558);
  }

  //confirmation screen
  public static void confirmation(String task, String name, String change){
    changeBut.setVisible(false);

    String string = " continue?";
    if (task.equals("d")){
      string = "deposit $" + change + " from " + name + "'s account?";
    }

    if (task.equals("w")){
      string = "withdraw $" + change + " from " + name + "'s account?";
    }

    if (task.equals("create")){
      string = "create an account for " + name + "?";
    }

    if (task.equals("remove")){
      string = "remove " + name + "'s account?";
    }

    //name label
    confirmLbl = new JLabel("are you sure you would like to " + string);
    confirmLbl.setBounds(275, 450, 500, 25);
    panel.add(confirmLbl);

    //confirm button
    confirmBut = new JButton("confirm");
    confirmBut.setBounds(800, 425, 100, 25);
    confirmBut.addActionListener(new bankSystemClient());
    panel.add(confirmBut);

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
      task = taskText.getText().toLowerCase();

      //create array list of possible entries and check
      List <String> possible = Arrays.asList("d", "w", "c", "r", "create", "remove");
      if (verification.inPossibleStringEntries(task, possible)){
        taskSuccess.setText("success.");
        if (task.equals("d")){
          deposit();
        }
        if (task.equals("w")){
          withdraw();
        }
        if (task.equals("c")){
          check();
        }
        if (task.equals("r")){
          report(page);
        }
        if (task.equals("create")){
          create();
        }
        if (task.equals("remove")){
          remove();
        }
      }
      else{
        taskSuccess.setText("Invalid input, Please try again from the options above.");
      }
    }

    //complete button
    if (e.getSource() == changeBut){
      //check if approved value and set changeNum to 0
      changeApproved = true;
      changeNum = 0.0;

      //check name
      if (task.equals("d") || task.equals("w") || task.equals("c") || task.equals("create") || task.equals("remove")){
        name = nameText.getText().toLowerCase();
        if (verification.checkName(name)){
          name = nameText.getText().toLowerCase();
          nameSuccess.setText("success.");
        }
        else{
          nameSuccess.setText("Invalid input, Please only enter letters.");
          changeApproved = false;
        }
      }
      //check ID
      if (task.equals("d") || task.equals("w") || task.equals("c") || task.equals("remove")){
        errorLbl.setText("");
        ID = customerIDText.getText().toLowerCase();
        if (verification.checkInt(ID)){
          ID = customerIDText.getText().toLowerCase();
          IDSuccess.setText("success.");
        }
        else{
          IDSuccess.setText("Invalid input, Please only enter numbers.");
          changeApproved = false;
        }
      }
      //check change
      if (task.equals("d") || task.equals("w")){
        change = changeText.getText().toLowerCase();
        if (verification.checkDouble(change)){
          change = changeText.getText().toLowerCase();
          changeNum = Double.parseDouble(change);
          changeSuccess.setText("success.");
        }
        else{
          changeSuccess.setText("Invalid input, Please only enter numbers.");
          changeApproved = false;
        }
      }

      //check starting balance
      if (task.equals("create")){
        startBalance = startBalanceText.getText().toLowerCase();
        if (verification.checkDouble(startBalance)){
          balance = Double.parseDouble(startBalance);
          balanceSuccess.setText("success.");
        }
        else{
          balanceSuccess.setText("Invalid input, Please only enter numbers.");
          changeApproved = false;
        }
      }

      //check inputs
      if (changeApproved){
        if (!task.equals("create")){
          if(verify(name, ID)){
            if (task.equals("c")){
              checkBalance(name);
            }
            else{
              confirmation(task, name, change);
            }
          }
        else{
          errorLbl.setText("Sorry this account does not exist. Please Check Spelling or Create Account");
        }
      }
        if (task.equals("create")){
          confirmation(task, name, change);
        }
      }
    }

    //confirmation button
    if (e.getSource() == confirmBut){
      if (task.equals("d")){
        changeTo(name, ID, changeNum);
      }
      if (task.equals("w")){
        changeNum = changeNum * -1;
        changeTo(name, ID, changeNum);
      }
      if (task.equals("create")){
        newAccount(name, balance);
      }
      if (task.equals("remove")){
        removeAccount(name);
      }
      quit();
    }

    //next page button
    if (e.getSource() == nextPageBut){
      if (page < (int)Math.ceil((double)names.size() / 5)){
        page++;
        report(page);
      }
      else{
        errorLbl.setText("there are no more pages available");
      }
    }
  }

  public static boolean verify(String name, String ID){
    readFile();
    if((verification.inPossibleStringEntries(name, names)) && (verification.inPossibleStringEntries(ID, IDs))){
      if (names.indexOf(name) == IDs.indexOf(ID)){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      errorLbl.setText("Sorry this account does not exist. Please Check Spelling or Create Account");
      return false;
    }
  }

  public static void changeTo(String name, String ID, Double deposit){
    readFile();
    int index = names.indexOf(name);
    String changable = info.get(index);
    String[] parts = changable.split("/");
    parts[2] = String.valueOf(Double.parseDouble(parts[2]) + deposit);
    String changed = String.join("/",parts[0], parts[1], parts[2]);
    info.set(index, changed);
    updateFile();
  }

  public static void checkBalance(String name){
    readFile();
    //balance label
    balanceLbl.setText(name + "'s account has a balance of $" + balances.get(names.indexOf(name)));
  }

  public static void report(int page){
    panel.removeAll();

    //next page button
    nextPageBut = new JButton("next page");
    nextPageBut.setBounds(800, 425, 100, 25);
    nextPageBut.addActionListener(new bankSystemClient());
    panel.add(nextPageBut);

    //return button
    returnBut = new JButton("return");
    returnBut.setBounds(50, 425, 100, 25);
    returnBut.addActionListener(new bankSystemClient());
    panel.add(returnBut);

    //error label
    errorLbl = new JLabel("");
    errorLbl.setBounds(325, 400, 500, 25);
    panel.add(errorLbl);

    try{
      //create labels
      JLabel user1 = new JLabel("name: " + names.get((page*5)-5) + "      //      ID: " + IDs.get((page*5)-5) + "     //      balance: " + balances.get((page*5)-5));
      user1.setBounds(325, 200, 500, 25);
      panel.add(user1);
      JLabel user2 = new JLabel("name: " + names.get((page*5)-4) + "      //      ID: " + IDs.get((page*5)-4) + "     //      balance: " + balances.get((page*5)-4));
      user2.setBounds(325, 225, 500, 25);
      panel.add(user2);
      JLabel user3 = new JLabel("name: " + names.get((page*5)-3) + "      //      ID: " + IDs.get((page*5)-3) + "     //      balance: " + balances.get((page*5)-3));
      user3.setBounds(325, 250, 500, 25);
      panel.add(user3);
      JLabel user4 = new JLabel("name: " + names.get((page*5)-2) + "      //      ID: " + IDs.get((page*5)-2) + "     //      balance: " + balances.get((page*5)-2));
      user4.setBounds(325, 275, 500, 25);
      panel.add(user4);
      JLabel user5 = new JLabel("name: " + names.get((page*5)-1) + "      //      ID: " + IDs.get((page*5)-1) + "     //      balance: " + balances.get((page*5)-1));
      user5.setBounds(325, 300, 500, 25);
      panel.add(user5);
    }
    catch(Exception e){
      errorLbl.setText("no more accounts to display");
    }

    //repack frame
    frame.pack();
    frame.setSize(992, 558);
  }

  public static void newAccount(String name, Double balance){
    int IDint = names.size() + 1;
    String ID = String.valueOf(IDint);
    String balanceStr = String.valueOf(balance);
    info.add(name + "/" + ID + "/" + balanceStr);
    updateFile();
  }

  public static void removeAccount(String name){
    int remIndex = names.indexOf(name);
    info.remove(remIndex);
    updateFile();
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
    confirm = false;
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
