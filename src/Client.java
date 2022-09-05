
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public void insUpdDelClient(char operation, Integer idKlienci, String nazwisko, String imie1, String imie2, String nazwa, String pesel,
            String nip, String regon, String rodzajDokToz, String nrDokToz, String ulica, String nrDomu, String nrLokalu, String kodPocztowy,
            String miejscowosc, String kraj, String nrKonta, String nrRejSadow, String nrSwift, String mail, String telefon, String fax) {
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
                ps.setString(5, pesel);
                ps.setString(6, nip);
                ps.setString(7, regon);//regon
                ps.setString(8, rodzajDokToz);
                ps.setString(9, nrDokToz);
                ps.setString(10, ulica);
                ps.setString(11, nrDomu);
                ps.setString(12, nrLokalu);
                ps.setString(13, kodPocztowy);
                ps.setString(14, miejscowosc);
                ps.setString(15, kraj);
                ps.setString(16, nrKonta);//nrKonta
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

    public void fillKlienciAll(JTable table, String valueToSearch, Integer miejsce) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        if (miejsce == 1) {
            try {
                ps = con.prepareStatement("SELECT `id_klienci`, concat(`imie1`, ' ', `nazwisko`, `nazwa`) as nazwa, concat(`pesel`, ' ', `nip`) peselnip, concat(`miejscowosc`, ', ',`ulica`, ' ', `nr_domu`, '/',`nr_lokalu`) as miejscowosc FROM `klienci` WHERE CONCAT(`id_klienci`, ' ', `imie1`, ' ', `nazwisko`, `nazwa`, ' ', `pesel`, ' ', `nip`, ' ', `miejscowosc`, ', ',`ulica`, ' ', `nr_domu`, '/',`nr_lokalu`) like ?");
                ps.setString(1, "%" + valueToSearch + "%");
                ResultSet rs = ps.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                Object[] row;

                while (rs.next()) {
                    row = new Object[5];
                    row[0] = rs.getInt(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    row[3] = rs.getString(4);
                    model.addRow(row);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (miejsce == 2) {
            try {
                ps = con.prepareStatement("SELECT `id_klienci`, concat(`imie1`, ' ', `nazwisko`, `nazwa`) as nazwa, concat(`pesel`, ' ', `nip`) peselnip, concat(`miejscowosc`, ', ',`ulica`, ' ', `nr_domu`, '/',`nr_lokalu`) as miejscowosc FROM `klienci` WHERE CONCAT(`id_klienci`, ' ', `imie1`, ' ', `nazwisko`, `nazwa`, ' ', `pesel`, ' ', `nip`, ' ', `miejscowosc`, ', ',`ulica`, ' ', `nr_domu`, '/',`nr_lokalu`) like ?");
                ps.setString(1, "%" + valueToSearch + "%");
                ResultSet rs = ps.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                Object[] row;

                while (rs.next()) {
                    row = new Object[5];
                    row[0] = rs.getInt(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    //row[3] = rs.getString(4);
                    model.addRow(row);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public void fillKlient(int idKlienta) {
//        Connection con = MyConnection.getConnection();
//        PreparedStatement ps;
//
//        try {
//            ps = con.prepareStatement("SELECT * FROM `klienci` where idKlienta");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    public void fillKlientDoAkt(JTable table, int idAktu) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            //ps = con.prepareStatement("SELECT k.id_klienci, CASE WHEN k.nazwisko is not null THEN concat (k.imie1, ' ', k.nazwisko) WHEN k.nazwa is not null THEN k.nazwa ELSE null END FROM `klient_do_akt` kda join klienci k on kda.klient_id = k.id_klienci where kda.akt_id = ?");
            ps = con.prepareStatement("SELECT `id_klienci`, concat(`imie1`, ' ', `nazwisko`, `nazwa`) as nazwa, concat(`pesel`, ' ', `nip`) peselnip, concat(`miejscowosc`, ', ',`ulica`, ' ', `nr_domu`, '/',`nr_lokalu`) as miejscowosc FROM `klient_do_akt` kda left join `klienci` k on kda.klient_id=k.id_klienci WHERE kda.akt_id = ? "); //
            ps.setInt(1, idAktu);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertKlientDoAkt(int klient, int idAktu) {
        //dodanie klienta do aktu
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("INSERT INTO `klient_do_akt`( `klient_id`, `akt_id`) VALUES ( ?, ? )");
            ps.setInt(1, klient);
            ps.setInt(2, idAktu);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddingCustWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteKlientDoAkt(int klient, int idAktu) {
        //usuniecie klienta z aktu
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("DELETE FROM `klient_do_akt` WHERE `klient_id`= ? and `akt_id`= ?;");
            ps.setInt(1, klient);
            ps.setInt(2, idAktu);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
