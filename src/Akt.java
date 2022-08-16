
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
            ps = con.prepareStatement("SELECT Nazwa, Id FROM `typy_dokumentow`");
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

    public void updateTypDoAkt(int typDok, int idAkt) {
        //usuniecie klienta z aktu
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

}
