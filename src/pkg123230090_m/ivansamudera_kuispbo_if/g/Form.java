/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123230090_m.ivansamudera_kuispbo_if.g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.text.DecimalFormat;

class Form extends JFrame implements ActionListener{
    private JTextField namaF, idF, malamF;
    private JComboBox kamarCB;
    private JCheckBox sarapan, kolam, spa;
    private JButton logoutBtn, pesanBtn;
    
    public Form(){
        setTitle("Reservasi Hotel");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel namaL = new JLabel("Nama:");
        namaF = new JTextField();
        
        JLabel idL = new JLabel("Identitas:");
        idF = new JTextField();
        
        JLabel malamL = new JLabel("Malam:");
        malamF = new JTextField();
        
        JLabel kamarL = new JLabel("Kamar:");
        String[] tipeKamar = {"Standard", "Deluxe", "Suite"};
        kamarCB = new JComboBox<>(tipeKamar);
        
        JLabel sarapanL = new JLabel("Sarapan");
        sarapan = new JCheckBox();
        
        JLabel kolamL = new JLabel("Sarapan");
        kolam = new JCheckBox();
        
        JLabel spaL = new JLabel("Sarapan");
        spa = new JCheckBox();
        
        
        logoutBtn = new JButton("Logout");
        pesanBtn = new JButton("Pesan");
        logoutBtn.addActionListener(this);
        pesanBtn.addActionListener(this);
        
        namaL.setBounds(30, 20, 120, 25);
        namaF.setBounds(150, 20, 200, 25);
        idL.setBounds(30, 50, 120, 25);
        idF.setBounds(150, 50, 200, 25);
        malamL.setBounds(30, 80, 120, 25);
        malamF.setBounds(150, 80, 200, 25);
        kamarL.setBounds(30, 110, 120, 25);
        kamarCB.setBounds(150, 110, 200, 25);
        logoutBtn.setBounds(40, 150, 130, 30);
        pesanBtn.setBounds(220, 150, 130, 30); 
        
        add(namaL);
        add(namaF);
        add(idL);
        add(idF);
        add(malamL);
        add(malamF);
        add(kamarL);
        add(kamarCB);
        add(logoutBtn);
        add(pesanBtn);
        add(sarapan);
        add(kolam);
        add(spa);
        
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutBtn) {
            confirmLogout();
        }else if (e.getSource() == pesanBtn){
            pesanForm();
        }
    }
    
    private void confirmLogout(){
        int confirm = JOptionPane.showConfirmDialog(this, "Mau Logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            new Login();
            dispose();
        }
}
    private void pesanForm(){
        String nama = namaF.getText();
        String id = idF.getText();
        String malamText = malamF.getText();
        String kamar = (String) kamarCB.getSelectedItem();
        boolean isSarapan = sarapan.isSelected();
        
        if (nama.isEmpty() || id.isEmpty()){ //error handling semua kolom harus diisi
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{ //error handling identitas dan jumlah malam harus berupa angla
            int malam = parseInt(malamText); //mengubah malam yang tadinya string menjadi int
            int hargaNginap = 0, hargaKamar = 0;
            if (kamar.equals("Standard")){
                hargaKamar = 300000;
                hargaNginap = 300000 * malam;
                dispose();
            }else if(kamar.equals("Deluxe")){
                 hargaKamar = 300000;
                 hargaNginap = 50000 * malam;
                 dispose();
            }else if(kamar.equals("Suite")){
                hargaKamar = 1500000;
                hargaNginap = 1500000 * malam;
                dispose();
            }

            String message = "Reservasi Berhasil!\n\n" + 
                             "Nama: " + nama + "\n" +
                             "Identitas: " + id + "\n" +
                             "Lama Menginap: " + malam + " malam" + "\n" +
                             "Jenis Kamar: " + kamar + "\n" + "\n" +
                             "Harga kamar: Rp" + hargaKamar + " x " + malam + " = Rp" + hargaNginap + "\n" + "Total Harga: Rp" + hargaNginap;
            JOptionPane.showMessageDialog(this, message, "Detail Reservasi", JOptionPane.INFORMATION_MESSAGE);   
           }catch (NumberFormatException e){
               JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
           }
}
    
}
