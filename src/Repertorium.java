
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Repertorium {
    
    public void fillRepertorium1(JTable table, String valueToSearch)
    {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `osoby` WHERE CONCAT(`Imie`, `Nazwisko`, `wiek`) LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            
            ResultSet rs = ps.executeQuery(); 
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object [3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                //row[3] = rs.getInt(3);
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repertorium.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    
   
}
