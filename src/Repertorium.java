
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
            
            ps = con.prepareStatement("SELECT a.Id_aktu, rep.nr_w_danym_roku, concat('') nr_aktu, concat(rep.nr_w_danym_roku, '/2022') nr_rep, '' as kli\n"
                    + ",rep.dlakogo Opis, '' kwota\n"
                    + "FROM `akty` a\n"
                    + "join repertorium1 rep on a.Id_aktu = rep.akt_id\n"
                    + "WHERE a.`nr_w_danym_roku` is not null and rep.dlakogo != 'Oryginal'\n"
                    + "UNION ALL\n"
                    + "SELECT a.Id_aktu, rep.nr_w_danym_roku, concat(a.nr_w_danym_roku, '/2022') nr_aktu, concat(rep.nr_w_danym_roku, '/2022') nr_rep, nvl(GROUP_CONCAT(k.klient),'') as kli\n"
                    + ",a.tytul  Opis, a.kwota kwota\n"
                    + "FROM `akty` a\n"
                    + "join repertorium1 rep on a.Id_aktu = rep.akt_id\n"
                    + "left join klient_do_akt kda on a.Id_aktu=kda.akt_id \n"
                    + "left join (SELECT id_klienci, concat(' ', imie1, ' ', nazwisko , nazwa) klient from klienci) k on kda.klient_id=k.id_klienci\n"
                    + "WHERE a.`nr_w_danym_roku` is not null and rep.dlakogo = 'Oryginal'\n"
                    + "order by nr_w_danym_roku;");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getString(3);
                row[1] = rs.getString(4);
                row[2] = rs.getString(5);
                row[3] = rs.getString(6);
                row[4] = rs.getString(7);

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

    public void dodajDoRep(int idAktu) {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            int maxAkt = 0;
            int maxRep = 0;
            int ik1 = 0, ik2 = 0, ik3 = 0, ik4 = 0;
            //wziecie maxa z aktu
            ps = con.prepareStatement("SELECT max(`nr_w_danym_roku`) FROM `akty`");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maxAkt = rs.getInt(1);
            }
            ps.clearBatch();

            //max z Repertorium
            ps = con.prepareStatement("SELECT max(`nr_w_danym_roku`) FROM `repertorium1`");
            rs = ps.executeQuery();
            while (rs.next()) {
                maxRep = rs.getInt(1);
            }
            ps.clearBatch();

            ps = con.prepareStatement("SELECT `ik1`,`ik2`,`ik3`,`ik4` FROM `oplaty` WHERE `idAktu`= ?");
            ps.setInt(1, idAktu);
            rs = ps.executeQuery();
            while (rs.next()) {
                ik1 = rs.getInt(1);
                ik2 = rs.getInt(2);
                ik3 = rs.getInt(3);
                ik4 = rs.getInt(4);
            }
            ps.clearBatch();

            //dodawanie numeru aktu w roku
            ps = con.prepareStatement("UPDATE `akty` SET `nr_w_danym_roku`= ? WHERE `Id_aktu` = ?");
            ps.setInt(1, maxAkt + 1);
            ps.setInt(2, idAktu);
            ps.executeUpdate();
            ps.clearBatch();

            //dodawanie wypisow do aktu
            ps = con.prepareStatement("INSERT INTO `repertorium1`(`akt_id`, `nr_w_danym_roku`, `dlakogo`) VALUES (?, ?, ?)");
            ps.setInt(1, idAktu);

            //      oryginal 
            maxRep = maxRep + 1;
            ps.setInt(2, maxRep);
            ps.setString(3, "Oryginal");
            ps.executeUpdate();

            //      dla stron
            for (int i = 0; i < ik1; i++) {
                maxRep = maxRep + 1;
                ps.setInt(2, maxRep);
                ps.setString(3, "Wypis dla stron czynności");
                ps.executeUpdate();
            }

            //      dla ksiąg wieczystych
            for (int i = 0; i < ik2; i++) {
                maxRep = maxRep + 1;
                ps.setInt(2, maxRep);
                ps.setString(3, "Wypis dla ksiąg wieczystych");
                ps.executeUpdate();
            }

            //      gmina
            for (int i = 0; i < ik3; i++) {
                maxRep = maxRep + 1;
                ps.setInt(2, maxRep);
                ps.setString(3, "Wypis dla gminy");
                ps.executeUpdate();
            }

            //      spoldzielnia mieszkaniowa
            for (int i = 0; i < ik4; i++) {
                maxRep = maxRep + 1;
                ps.setInt(2, maxRep);
                ps.setString(3, "Wypis dla spółdzielni mieszkaniowej");
                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Dodano akto do Repertorium");

            // ps.setInt(1, ik1);
            //int executeUpdate = ps.executeUpdate();
//            ps = con.prepareStatement("INSERT INTO akty( Typ_dokumentu ) VALUES (?)");
//                ps.setInt(1, 3);
//                ps.executeUpdate(); //wykonanie sql'a
//                ps.clearBatch();
//                ps = con.prepareStatement("SELECT max(Id_aktu) FROM `akty`");
//                ResultSet rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    idAkt = rs.getInt(1);
//                }
        } catch (SQLException ex) {
            Logger.getLogger(Akt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
