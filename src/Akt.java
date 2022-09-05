
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Akt {

    //do użycia jak wywołane zostanie dodaj nową czynność
    public int insDelAkt(char operation, Integer idAktu, int Typ_dokumentu) {
        Connection con = MyConnection.getConnection(); //dodanie connection z bazy 
        PreparedStatement ps;
        int idAkt = 0;
        //i insert 
        if (operation == 'i') {
            try {
                ps = con.prepareStatement("INSERT INTO akty( Typ_dokumentu ) VALUES (?)");
                ps.setInt(1, 3);
                ps.executeUpdate(); //wykonanie sql'a
                ps.clearBatch();
                ps = con.prepareStatement("SELECT max(Id_aktu) FROM `akty`");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    idAkt = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //d delete
        if (operation == 'd') {
            try {
                int reply = JOptionPane.showConfirmDialog(null, "Czy jesteś pewny, że chcesz usunąć wiersz?", "Uwaga", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    ps = con.prepareStatement("DELETE FROM `klient_do_akt` WHERE `akt_id` =  ?");
                    ps.setInt(1, idAktu);
                    ps.executeUpdate();
                    ps.clearBatch();
                    ps = con.prepareStatement("DELETE FROM `akty` WHERE `Id_aktu` = ?");
                    ps.setInt(1, idAktu);
                    ps.executeUpdate();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idAkt;
    }

    public void fillTypDokumentu(JTable table) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT Nazwa, Id FROM `typy_dokumentow` where Id !=3");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[2];
                row[0] = rs.getString(1);
                row[1] = rs.getInt(2);
                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String fillTypDokumentu(Integer idAktu) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        String typDokumentu = "";

        try {
            ps = con.prepareStatement("SELECT Nazwa FROM `typy_dokumentow` td join akty a on td.Id = a.Typ_dokumentu WHERE a.Id_aktu = ?");
            ps.setInt(1, idAktu);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                typDokumentu = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Akt.class.getName()).log(Level.SEVERE, null, ex);
            typDokumentu = "błąd";
        }

        return typDokumentu;
    }

    public void updateTypDoAkt(int typDok, int idAkt) {
        //update typ dokumentu
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("UPDATE `akty` SET `Typ_dokumentu`= ? WHERE `Id_aktu` = ?");
            ps.setInt(1, typDok);
            ps.setInt(2, idAkt);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTytulAktu(String tytul, int idAkt) {

        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("UPDATE `akty` SET `tytul`= ? WHERE `Id_aktu` = ?");
            ps.setString(1, tytul);
            ps.setInt(2, idAkt);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String fillTytulAktu(Integer idAktu) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        String tytulAktu = "";

        try {
            ps = con.prepareStatement("SELECT tytul FROM akty WHERE Id_aktu = ?");
            ps.setInt(1, idAktu);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tytulAktu = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Akt.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tytulAktu;
    }

    public void insertOplaty(int idAktu) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("INSERT INTO `oplaty`( `idAktu` ) VALUES ( ?)");
            ps.setInt(1, idAktu);
            int executeUpdate = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Akt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateOplaty(int idAktu, int ik1, int ik2, int ik3, int ik4, int is1, int is2, int is3, int is4, double ozs1, double ozs2, double ozs3, double ozs4, double netSum) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("UPDATE `oplaty` SET `ik1`= ?,`ik2`= ?,`ik3`= ?,`ik4`= ?,`is1`= ?,`is2`= ?,`is3`= ?,`is4`= ?,`ozs1`= ?,`ozs2`= ?,`ozs3`= ?,`ozs4`= ?,`netSum`=? WHERE idAktu = ?  ");
            ps.setInt (1, ik1);
            ps.setInt(2, ik2);
            ps.setInt(3, ik3);
            ps.setInt(4, ik4);
            ps.setInt(5, is1);
            ps.setInt(6, is2);//regon
            ps.setInt(7, is3);
            ps.setInt(8, is4);
            ps.setDouble(9, ozs1);
            ps.setDouble(10, ozs2);
            ps.setDouble(11, ozs3);
            ps.setDouble(12, ozs4);
            ps.setDouble(13, netSum);
            ps.setInt (14, idAktu);
            
            int executeUpdate = ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Akt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    


}
