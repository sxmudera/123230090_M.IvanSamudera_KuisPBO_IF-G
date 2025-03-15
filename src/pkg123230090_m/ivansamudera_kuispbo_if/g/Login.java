/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123230090_m.ivansamudera_kuispbo_if.g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Login extends JFrame implements ActionListener {
    private JTextField usnF;
    private JPasswordField pwF;
    private JButton loginBtn;
    
    public Login(){
        setTitle("Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //menghentikan program saat frame diclose
        setLayout(null);
        
        JLabel usnL = new JLabel("Username:");
        usnF = new JTextField();
        
        JLabel pwL = new JLabel("Password:");
        pwF = new JPasswordField();
        
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        
        usnL.setBounds(50, 30, 100, 25); // set bound mnop
        usnF.setBounds(160, 30, 140, 25);
        pwL.setBounds(50, 70, 100, 25);
        pwF.setBounds(160, 70, 140, 25);
        loginBtn.setBounds(160, 110, 140, 25);
        
        add(usnL);
        add(usnF);
        add(pwL);
        add(pwF);
        add(loginBtn);
        
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usn = usnF.getText();
        String pw = new String(pwF.getPassword());
        
        if(usn.equals("123230090") && pw.equals("ifkelasg")){
            JOptionPane.showMessageDialog(this, "Login Berhasil!");
            new Form();
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Username atau Password Salah!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
