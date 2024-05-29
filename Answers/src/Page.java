import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page {
         JTextField passwordFeild=new JTextField();
         JLabel emptyPass=new JLabel("enter password");
         JLabel emptyUser_id=new JLabel("email field cant be empty");
         JLabel emptyUserName=new JLabel("Username field cant be empty");
         JLabel FullName=new JLabel("Enter full name");
         JLabel userName=new JLabel("Username:");
         JTextField userNameFeild=new JTextField();
        JFrame arian=new JFrame("");
        JButton login=new JButton("Login");
        JButton reset=new JButton("Reset");
        JButton register=new JButton("register");
        JTextField user_id=new JTextField();
        JLabel emailExample=new JLabel("example@gmail.com");
        JLabel passExample=new JLabel("example!!@##12345");
        JPasswordField user_pass=new JPasswordField();
        JLabel email=new JLabel("Email:");
        JLabel password=new JLabel("Password:");
        JLabel SuccessMassage=new JLabel("Login Successfully");
        loginPage arian1=new loginPage();
        Page(){
        }
    public class loginPage  implements ActionListener{
        JLabel Error2=new JLabel();
        JLabel Error=new JLabel();
                ImageIcon image=new ImageIcon("C:\\Users\\Dr Techno\\Pictures\\Screenshots\\Screenshot 2024-02-24 221405.png");
                Image Image=image.getImage();
        loginPage(){
            emptyPass.setVisible(false);
            passwordFeild.setVisible(false);
            user_pass.setVisible(true);
            Error2.setVisible(false);
            arian.setTitle("Welcome to login page");
            login.setText("Login");
            register.setText("registration page");
            pageAttribute arian4=new pageAttribute();
            login.addActionListener(this);
            reset.addActionListener(this);
            register.addActionListener(this);
            textValidation1 Error1=new textValidation1();
            pageConfirmation adding=new pageConfirmation();
        }
            void changingPage() throws InterruptedException {
                user_id.setText("");
                user_pass.setText("");
                arian1=new registrationPage();

            }
        public class pageAttribute {
            pageAttribute() {
                arian.getContentPane().setBackground(Color.CYAN);
                arian.setIconImage(Image);
                arian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                arian.setLocationRelativeTo(null);
                arian.setSize(400,400);
                rightAttribute(emptyPass);
                emptyPass.setBounds(105,165,95,20);
                rightAttribute(emptyUser_id);
                emptyUser_id.setBounds(105,110,130,25);
                emptyUser_id.setVisible(false);
                rightAttribute(emptyUserName);
                emptyUserName.setBounds(105,74,130,20);
                emptyUserName.setVisible(false);
                rightAttribute(FullName);
                FullName.setBounds(220,50,130,20);
                rightText(userNameFeild);
                userNameFeild.setBounds(105,50,110,20);
                rightAttribute(userName);
                userName.setBounds(40,50,70,20);
                email.setBounds(70,90,70,20);
                rightAttribute(email);
                emailExample.setBounds(220,90,130,20);
                rightAttribute(emailExample);
                password.setBounds(45,140,70,20);
                rightAttribute(password);
                user_id.setBounds(105,90,110,20);
                rightText(user_id);
                user_pass.setBounds(105,140,95,20);
                passExample.setBounds(205,140,110,20);
                rightAttribute(passExample);
                register.setBounds(210,205,140,20);
                register.setFocusable(false);
                login.setBounds(110,205,90,20);
                login.setFocusable(false);
                reset.setBounds(30,205,75,20);
                reset.setFocusable(false);
                SuccessMassage.setBounds(75,290,140,70);
                SuccessMassage.setVisible(false);
            }
        }
        public class pageConfirmation {
            pageConfirmation() {
                arian.add(Error2);
                arian.setLayout(null);
                arian.add(passwordFeild);
                arian.add(emptyUser_id);
                arian.add(FullName);
                arian.add(userNameFeild);
                arian.add(userName);
                arian.add(SuccessMassage);
                arian.add(reset);
                arian.add(login);
                arian.add(register);
                arian.add(passExample);
                arian.add(user_pass);
                arian.add(emailExample);
                arian.add(password);
                arian.add(user_id);
                arian.add(email);
                arian.add(emptyPass);
                arian.add(emptyUserName);
                arian.setVisible(true);
            }
        }
                 class textValidation1 {
                      String emailRegex="\\S+@gmail.com";
                      Pattern emailPattern=Pattern.compile(emailRegex);
                     textValidation1(){
                         rightAttribute(Error);
                         user_id.getDocument().addDocumentListener(new DocumentListener() {
                             @Override
                             public void insertUpdate(DocumentEvent e) {
                                 Error.setBounds(105,110,100,25);
                                 arian.add(Error);
                                 Matcher matcher=emailPattern.matcher(user_id.getText());
                                 if (!matcher.matches()&& !user_id.getText().isEmpty()) {
                                     Error.setText("Email not valid");
                                 }else if (matcher.matches()||user_id.getText().isEmpty()){
                                     Error.setText("");
                                 }
                             }
                             @Override
                             public void removeUpdate(DocumentEvent e) {
                                 Error.setBounds(105,110,100,25);
                                 arian.add(Error);
                                 Matcher matcher=emailPattern.matcher(user_id.getText());
                                 if (!matcher.matches()&& !user_id.getText().isEmpty()) {
                                     Error.setText("Email not valid");
                                 }else if (matcher.matches()||user_id.getText().isEmpty()){
                                     Error.setText("");
                                 }
                             }
                             @Override
                             public void changedUpdate(DocumentEvent e) {

                             }


                         });
                     }
                 }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==register){
                try {
                    changingPage();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (e.getSource()==reset) {
                user_id.setText("");
                user_pass.setText("");
            } else if (e.getSource()==login) {
                char[] passwordChars = user_pass.getPassword();
                String passwordString = new String(passwordChars);
                hashCoder code=new hashCoder();
                String y= code.hashString(passwordString);
                File checking=new File("C:/Users/Dr Techno/Desktop/registrationRepository.txt");
                if (checking.exists()){
                    try {
                        Scanner scan=new Scanner(checking);
                    while (scan.hasNextLine()){
                        String x=scan.nextLine();
                        ArrayList<String> xyz2=new ArrayList<>(List.of(x.substring(1,x.length()-1).split(", ")));
                        if (xyz2.get(0)==userNameFeild.getText()&&xyz2.get(1)==user_id.getText()&&xyz2.get(2)==y){
                SuccessMassage.setVisible(true);
                            break;
                        }
                    }
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }
    void rightText(JTextField x){
        x.setForeground(Color.BLUE);
        x.setSelectionColor(Color.BLUE);
        x.setSelectedTextColor(Color.YELLOW);
    }
    void rightAttribute(JLabel x){
        x.setOpaque(true);
        x.setBackground(Color.CYAN);
        x.setForeground(Color.red);
    }
    public class registrationPage extends loginPage{

            public class textValidation1 extends loginPage.textValidation1{
                textValidation1(){
                    rightAttribute(Error);
                    user_id.getDocument().addDocumentListener(new DocumentListener() {
                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            Error.setBounds(105,110,100,25);
                            arian.add(Error);
                            Matcher matcher=emailPattern.matcher(user_id.getText());
                            if (!matcher.matches()&& !user_id.getText().isEmpty()) {
                                Error.setText("Email not valid");
                            }else if (matcher.matches()||user_id.getText().isEmpty()){
                                Error.setText("");
                            }
                        }
                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            Error.setBounds(105,110,100,25);
                            arian.add(Error);
                            Matcher matcher=emailPattern.matcher(user_id.getText());
                            if (!matcher.matches()&& !user_id.getText().isEmpty()) {
                                Error.setText("Email not valid");
                            }else if (matcher.matches()||user_id.getText().isEmpty()){
                                Error.setText("");
                            }
                        }
                        @Override
                        public void changedUpdate(DocumentEvent e) {

                        }
                    });
                    passwordFeild.getDocument().addDocumentListener(new DocumentListener() {
                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            rightAttribute(Error2);
                            Error2.setBounds(105,165,130,20);
                            String xyz=passwordFeild.getText();
                            ArrayList<String> x=new ArrayList<>();
                            x.add("[.]{9}");
                            x.add("[.]+");
                            x.add("([a-z]&A[-Z]&[0-9])+");
                            x.add("([a-z]&[A-Z])+");
                            x.add("[a-zA-Z0-9]+");
                            for (int i = 0; i<5  ; i++){
                                Pattern pattern=Pattern.compile(x.get(i));
                                Matcher matcher=pattern.matcher(xyz);
                                if (matcher.matches()){
                                    switch (i){
                                        case 0:
                                            Error2.setText(" very strong password");
                                            Error2.setForeground(Color.GREEN);
                                            Error2.setVisible(true);
                                            break;
                                        case 1:
                                            Error2.setText("strong password");
                                            Error2.setForeground(Color.orange);
                                            Error2.setVisible(true);
                                            break;
                                        case 2:
                                            Error2.setText("medium security password");
                                            Error2.setForeground(Color.YELLOW);
                                            Error2.setVisible(true);
                                            break;
                                        case 3:
                                            Error2.setText("weak password");
                                            Error2.setForeground(Color.ORANGE);
                                            Error2.setVisible(true);
                                            Error2.setText("strong password");
                                            Error2.setForeground(Color.orange);
                                            Error2.setVisible(true);
                                            break;
                                        case 4:
                                            Error2.setText("very weak password");
                                            Error2.setVisible(true);
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            rightAttribute(Error2);
                            Error2.setBounds(105,165,130,20);
                            String xyz=passwordFeild.getText();
                            ArrayList<String> x=new ArrayList<>();
                            x.add("[.]{9}");
                            x.add("[.]+");
                            x.add("([a-z]&A[-Z]&[0-9])+");
                            x.add("([a-z]&[A-Z])+");
                            x.add("[a-zA-Z0-9]+");
                            for (int i = 0; i<5  ; i++){
                                Pattern pattern=Pattern.compile(x.get(i));
                                Matcher matcher=pattern.matcher(xyz);
                                if (matcher.matches()){
                                    switch (i){
                                        case 0:
                                            Error2.setText(" very strong password");
                                            Error2.setForeground(Color.GREEN);
                                            Error2.setVisible(true);
                                            break;
                                        case 1:
                                            Error2.setText("strong password");
                                            Error2.setForeground(Color.orange);
                                            Error2.setVisible(true);
                                            break;
                                        case 2:
                                            Error2.setText("medium security password");
                                            Error2.setForeground(Color.YELLOW);
                                            Error2.setVisible(true);
                                            break;
                                        case 3:
                                            Error2.setText("weak password");
                                            Error2.setForeground(Color.ORANGE);
                                            Error2.setVisible(true);
                                            Error2.setText("strong password");
                                            Error2.setForeground(Color.orange);
                                            Error2.setVisible(true);
                                            break;
                                        case 4:
                                            Error2.setText("very weak password");
                                            Error2.setVisible(true);
                                            break;
                                    }
                                    break;
                                }
                            }
                        }
                        @Override
                        public void changedUpdate(DocumentEvent e) {

                        }
                    });
                }
            }
        @Override
        void changingPage() {
            user_id.setText("");
            user_pass.setText("");
            loginPage arian1=new loginPage();
        }
        registrationPage() {
            passwordFeild.setVisible(true);
            user_pass.setVisible(false);
            arian.setTitle("Welcome to registration page");
            login.setText("Login page");
            register.setText("Register");
            registrationPage.pageAttribute arian5=new pageAttribute();
            login.addActionListener(this);
            reset.addActionListener(this);
            register.addActionListener(this);
            loginPage.textValidation1 Error1=new textValidation1();
            pageConfirmation adding=new pageConfirmation();
        }
          @Override
          public void actionPerformed(ActionEvent e) {
            if (e.getSource()==register){
                if (userNameFeild.getText().isEmpty()){
                   emptyUserName.setVisible(true);
                } else if (user_id.getText().isEmpty()) {
                    emptyUser_id.setVisible(true);
                } else if (passwordFeild.getText().isEmpty()) {
                    emptyPass.setVisible(true);
                } else if (Objects.equals(Error.getText(), "Email not valid")) {

                } else if (!Objects.equals(Error2.getText(), "very weak password")) {

                } else {
                    ArrayList<String> registeringPersonal = getStrings();
                    FileHandling fileRegister=new FileHandling(registeringPersonal);
                }
            } else if (e.getSource()==reset) {
                user_id.setText("");
                user_pass.setText("");
            } else if (e.getSource()==login) {
                user_id.setText("");
                user_pass.setText("");
                loginPage arian1=new loginPage();
            }
             }

        private ArrayList<String> getStrings() {
            String userName=userNameFeild.getText();
            String password= passwordFeild.getText();
            String x=user_id.getText();
            hashCoder code=new hashCoder();
            String y= code.hashString(password);
            ArrayList<String> registeringPersonal=new ArrayList<>();
            registeringPersonal.add(userName);
            registeringPersonal.add(x);
            registeringPersonal.add(y);
            return registeringPersonal;
        }

        class pageAttribute extends loginPage.pageAttribute{
            pageAttribute() {
               arian.getContentPane().setBackground(Color.CYAN);
               arian.setIconImage(Image);
               arian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               arian.setLocationRelativeTo(null);
               arian.setSize(400,400);
               rightText(passwordFeild);
               passwordFeild.setBounds(105,140,95,20);
               rightAttribute(emptyUser_id);
               emptyUser_id.setBounds(105,110,150,20);
               emptyUser_id.setVisible(false);
               rightAttribute(emptyUserName);
               emptyUserName.setBounds(105,74,160,20);
               emptyUserName.setVisible(false);
               rightAttribute(FullName);
               FullName.setBounds(220,50,130,20);
               rightText(userNameFeild);
               userNameFeild.setBounds(105,50,110,20);
               rightAttribute(userName);
               userName.setBounds(40,50,70,20);
               email.setBounds(70,90,70,20);
               rightAttribute(email);
               emailExample.setBounds(220,90,130,20);
               rightAttribute(emailExample);
               password.setBounds(45,140,70,20);
               rightAttribute(password);
               user_id.setBounds(105,90,110,20);
               rightText(user_id);
               user_pass.setBounds(105,140,95,20);
               passExample.setBounds(205,140,110,20);
               rightAttribute(passExample);
               register.setBounds(225,205,120,20);
               register.setFocusable(false);
               login.setBounds(110,205,110,20);
               login.setFocusable(false);
               reset.setBounds(30,205,75,20);
               reset.setFocusable(false);
               SuccessMassage.setBounds(75,250,140,70);
                  }
          }
    }
    public class stoppingTread extends Thread{
        private volatile boolean exit = false;

        public void run() {
            while (!exit) {
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        public void stopThread() {
            exit = true;
            this.interrupt(); // Interrupt if thread is blocked in sleep or wait
        }
    }
}
