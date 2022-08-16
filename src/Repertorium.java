
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Repertorium {

    public void fillRepertorium1(JTable table, String valueToSearch) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        //wypełnianie tabeli informacjami z bazy danych
        try {
            //ps = con.prepareStatement("SELECT * FROM `akty` WHERE `nr_w_danym_roku` IS NOT NULL");
            //ps.setString(1, "%"+valueToSearch+"%");
            ps = con.prepareStatement("SELECT id_aktu, nvl(GROUP_CONCAT(k.klient),'') as Strony , td.Nazwa FROM `akty` a left join klient_do_akt kda on a.Id_aktu=kda.akt_id left join (SELECT id_klienci, concat(' ', imie1, ' ', nazwisko , nazwa) klient from klienci) k on kda.klient_id=k.id_klienci left join typy_dokumentow as td on a.Typ_dokumentu = td.Id where a.nr_w_danym_roku is null group by (id_aktu)");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);//dodane 15.08

            Object[] row;

            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repertorium.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fillRepertorium2(JTable table, String valueToSearch) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            //ps = con.prepareStatement("SELECT * FROM `repertorium` WHERE CONCAT (`num_rep_fin`) LIKE ?");
            ps = con.prepareStatement("SELECT * FROM `akty` WHERE `nr_w_danym_roku` IS NOT NULL");
            //ps.setString(1, "%"+valueToSearch+"%"); //bez sensu dodatawanie "%" do szukanych znaków 

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getString(3);
                row[1] = rs.getString(5);
                row[2] = rs.getString(6);
                row[3] = rs.getString(7);
                row[4] = rs.getString(8);

                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Repertorium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int ileKlientow(int idAktu) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        int Ile;

        try {
            ps = con.prepareStatement("SELECT count(*) FROM `klient_do_akt` WHERE `akt_id` = ?");
            ps.setInt(1, idAktu);
            ResultSet rs = ps.executeQuery();

            rs.next();
            Ile = rs.getInt(1);
            

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return Ile;
    }
}
