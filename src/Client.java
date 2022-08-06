
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dawid
 */
public class Client {

    public void insUpdDelClient(char operation, Integer idKlienci, String nazwisko, String imie1, String imie2, String nazwa, Integer pesel,
            String nip, Integer regon, String rodzajDokToz, String nrDokToz, String ulica, Integer nrDomu, Integer nrLokalu, String kodPocztowy,
            String miejscowosc, String kraj, Integer nrKonta, String nrRejSadow, String nrSwift, String mail, String telefon, String fax) {
        Connection con = MyConnection.getConnection(); //dodanie cconnection z bazy 
        PreparedStatement ps; //idkn

        //i insert 
        if (operation == 'i') {
            try {
                ps = con.prepareStatement("INSERT INTO klienci( nazwisko, imie1, imie2, nazwa, pesel, nip, regon, rodzaj_dok_toz, nr_dok_toz, ulica, nr_domu, nr_lokalu, kod_pocztowy, miejscowosc, kraj, numer_konta, nr_rej_sadow, nr_swift, mail, telefon, fax) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //wpisac query 
                //ps = con.prepareStatement("INSERT INTO klienci( nazwisko, imie1, imie2) VALUES (?,?,?)"); //wpisac query 
                
                ps.setString(1, nazwisko);
                ps.setString(2, imie1);
                ps.setString(3, imie2);
                ps.setString(4, nazwa);
                ps.setInt(5, pesel);
                ps.setString(6, nip);
                ps.setInt(7, regon);//regon
                ps.setString(8, rodzajDokToz);
                ps.setString(9,nrDokToz);
                ps.setString(10, ulica);
                ps.setInt (11, nrDomu);
                ps.setInt(12, nrLokalu);
                ps.setString(13, kodPocztowy);
                ps.setString(14, miejscowosc);
                ps.setString(15, kraj);
                ps.setInt(16, nrKonta);//nrKonta
                ps.setString(17, nrRejSadow);
                ps.setString(18, nrSwift);
                ps.setString(19, mail);
                ps.setString(20, telefon);
                ps.setString(21, fax);
                

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Dodano nowego klienta do bazy");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }



}
