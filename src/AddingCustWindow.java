
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class AddingCustWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddingCustWindow
     */
    Client cli = new Client();

    int idAktu;

    public AddingCustWindow() {
        initComponents();
        cli.fillKlienciAll(jTable1, "", 2);
        jTable2.setModel(new DefaultTableModel(null, new Object[]{"Lp.", "Strona czynności"}));
        cli.fillKlientDoAkt(jTable2, idAktu);
        // hideColumn(4);
    }

    private void hideColumn(int colIndex) {
        TableColumn col = jTable1.getColumnModel().getColumn(colIndex);
        col.setMaxWidth(0);
        col.setMinWidth(0);
        col.setPreferredWidth(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldNazwisko = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldImie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNazwa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPesel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldRegon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNrDok = new javax.swing.JTextField();
        jTextFieldUlica = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNrDomu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldNrLokalu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldKodPocztowy = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldMiejscowosc = new javax.swing.JTextField();
        jTextFieldKraj = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldNrKonta = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldNrRejestruSad = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldSwift = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldTelefon = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldFax = new javax.swing.JTextField();
        jTextFieldImie2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButtonAddClient = new javax.swing.JButton();
        jButtonAddClient1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1206, 800));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Baza klientów", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Imię i Nazwisko", "PESEL/NIP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Szukaj:");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton1.setText("Dodaj klienta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Usuń klienta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lp.", "Strona czynności"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dodawanie osoby", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        jTextFieldNazwisko.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Nazwisko");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Imię");

        jTextFieldImie.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldImie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldImieActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Nazwa");

        jTextFieldNazwa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("PESEL");

        jTextFieldPesel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldPesel.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("NIP");

        jTextFieldNip.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("REGON");

        jTextFieldRegon.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldRegon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRegonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Nr dokumentu tożsamości");

        jTextFieldNrDok.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTextFieldUlica.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Ulica");

        jTextFieldNrDomu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldNrDomu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNrDomuActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Nr domu");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Nr lokalu");

        jTextFieldNrLokalu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldNrLokalu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNrLokaluActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Kod");

        jTextFieldKodPocztowy.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldKodPocztowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKodPocztowyActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setText("Miejscowość");

        jTextFieldMiejscowosc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldMiejscowosc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMiejscowoscActionPerformed(evt);
            }
        });

        jTextFieldKraj.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldKraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKrajActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Kraj");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Numer konta");

        jTextFieldNrKonta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldNrKonta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNrKontaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setText("Bumer Rejestru Sądowego ");

        jTextFieldNrRejestruSad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldNrRejestruSad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNrRejestruSadActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setText("Numer SWIFT");

        jTextFieldSwift.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldSwift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSwiftActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setText("Mail");

        jTextFieldMail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMailActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Telefon");

        jTextFieldTelefon.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefonActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setText("Fax");

        jTextFieldFax.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldFax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFaxActionPerformed(evt);
            }
        });

        jTextFieldImie2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldImie2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldImie2ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setText("Drugie imię");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldUlica, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPesel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel10))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jTextFieldNip, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jTextFieldNrDomu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jTextFieldNrLokalu))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextFieldRegon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldNrDok, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jTextFieldKodPocztowy, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14)
                                                .addComponent(jTextFieldMiejscowosc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15)
                                                .addComponent(jTextFieldKraj, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel19)))))
                            .addContainerGap(453, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(477, 477, 477)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addGap(31, 31, 31)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldMail, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addComponent(jTextFieldTelefon))
                                    .addContainerGap(465, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jTextFieldFax, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNrKonta, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldSwift))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldNrRejestruSad, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldImie, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldImie2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldNazwa, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(224, 224, 224))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldImie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldImie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNazwa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRegon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNrDok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUlica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNrDomu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNrLokalu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldKodPocztowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMiejscowosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldKraj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldNrKonta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldNrRejestruSad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jTextFieldSwift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jTextFieldFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jButtonAddClient.setText("Zapisz w bazie");
        jButtonAddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddClientActionPerformed(evt);
            }
        });

        jButtonAddClient1.setText("Anuluj");
        jButtonAddClient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddClient1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddClient1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAddClient)
                .addGap(381, 381, 381))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddClient)
                    .addComponent(jButtonAddClient1))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNrDomuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNrDomuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNrDomuActionPerformed

    private void jTextFieldNrLokaluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNrLokaluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNrLokaluActionPerformed

    private void jTextFieldKodPocztowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldKodPocztowyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldKodPocztowyActionPerformed

    private void jTextFieldMiejscowoscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMiejscowoscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMiejscowoscActionPerformed

    private void jTextFieldKrajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldKrajActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldKrajActionPerformed

    private void jTextFieldNrKontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNrKontaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNrKontaActionPerformed

    private void jTextFieldNrRejestruSadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNrRejestruSadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNrRejestruSadActionPerformed

    private void jTextFieldSwiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSwiftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSwiftActionPerformed

    private void jTextFieldMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMailActionPerformed

    private void jTextFieldTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonActionPerformed

    private void jTextFieldFaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFaxActionPerformed

    private void jTextFieldImieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldImieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldImieActionPerformed

    private boolean verifyText() {
        if (jTextFieldImie.getText().equals("") && jTextFieldNazwisko.getText().equals("") && jTextFieldNazwa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Wypełnij Imię i nazwisko klienta, bądź nazwę firmy!");
            return false;
        } else if ((jTextFieldImie.getText().equals("") || jTextFieldNazwisko.getText().equals("")) && jTextFieldNazwa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Uzupełnij dane klienta");
            return false;
        } else {
            return true;
        }

    }

    private void jButtonAddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddClientActionPerformed
        //Po wciśnięciu buttona "dodaj klienta

        String nazwisko = jTextFieldNazwisko.getText();
        String imie1 = jTextFieldImie.getText();
        String imie2 = jTextFieldImie2.getText();
        String nazwa = jTextFieldNazwa.getText();
        // int pesel = Integer.parseInt(jTextFieldPesel.getText());
        //int pesel = Integer.valueOf(jTextFieldPesel.getText()); zamieniam na stringa 
        String pesel = jTextFieldPesel.getText();
        String nip = jTextFieldNip.getText();
        //int regon = Integer.parseInt(jTextFieldRegon.getText());
        String regon = jTextFieldRegon.getText();
        // String rodzaj_dok_toz = jComboBoxRodzDok.getSelectedItem().toString();
        String nr_dok_toz = jTextFieldNrDok.getText();
        String ulica = jTextFieldUlica.getText();
        //int nr_domu = Integer.parseInt(jTextFieldNrDomu.getText());
        String nr_domu = jTextFieldNrDomu.getText();
        //int nr_lokalu = Integer.parseInt(jTextFieldNrLokalu.getText());
        String nr_lokalu = jTextFieldNrLokalu.getText();
        String kod_pocztowy = jTextFieldKodPocztowy.getText();
        String miejscowosc = jTextFieldMiejscowosc.getText();
        String kraj = jTextFieldKraj.getText();
        String numer_konta = jTextFieldNrKonta.getText();
        //String numer_konta = Integer.parseInt(jTextFieldNrKonta.getText());
        String nr_rej_sadow = jTextFieldNrRejestruSad.getText();
        String nr_swift = jTextFieldSwift.getText();
        String mail = jTextFieldMail.getText();
        String telefon = jTextFieldTelefon.getText();
        String fax = jTextFieldFax.getText();
        //String rodzDok = jComboBoxRodzDok.getSelectedItem().toString();

        if (verifyText()) {
            Client Cli = new Client();
            Cli.insUpdDelClient('i', null, nazwisko, imie1, imie2, nazwa, pesel, nip, regon, null, nr_dok_toz, ulica, nr_domu, nr_lokalu, kod_pocztowy, miejscowosc, kraj, numer_konta, nr_rej_sadow, nr_swift, mail, telefon, fax);
            //Cli.insUpdDelClient('i', null, nazwisko, imie1, imie2);
            // TODO add your handling code here:
            jTable1.setModel(new DefaultTableModel(null, new Object[]{"Id.", "Imię i Nazwisko", "PESEL/NIP"}));

            cli.fillKlienciAll(jTable1, "", 2);
        }


    }//GEN-LAST:event_jButtonAddClientActionPerformed

    private void jTextFieldRegonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRegonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRegonActionPerformed

    private void jButtonAddClient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddClient1ActionPerformed
        // czyszczenie pól 
        jTextFieldNazwisko.setText("");
        jTextFieldImie.setText("");
        jTextFieldImie2.setText("");
        jTextFieldNazwa.setText("");
        jTextFieldPesel.setText("");
        jTextFieldNip.setText("");
        jTextFieldRegon.setText("");
        //jComboBoxRodzDok.setText("");
        jTextFieldNrDok.setText("");
        jTextFieldUlica.setText("");
        jTextFieldNrDomu.setText("");
        jTextFieldNrLokalu.setText("");
        jTextFieldKodPocztowy.setText("");
        jTextFieldMiejscowosc.setText("");
        jTextFieldKraj.setText("");
        jTextFieldNrKonta.setText("");
        jTextFieldNrRejestruSad.setText("");
        jTextFieldSwift.setText("");
        jTextFieldMail.setText("");
        jTextFieldTelefon.setText("");
        jTextFieldFax.setText("");
    }//GEN-LAST:event_jButtonAddClient1ActionPerformed

    private void jTextFieldImie2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldImie2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldImie2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        int rowIndex = jTable1.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//        
//        int idKlienta;
//        //idKlienta = Integer.valueOf(model.getValueAt(rowIndex,0));
//        idKlienta = (int) model.getValueAt(rowIndex,0);
//        

//
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//
//            Object[] row;
//
//            while (rs.next()) {
//                row = new Object[5];
//                row[0] = rs.getInt(1);
//                row[1] = rs.getString(2);
//                row[2] = rs.getString(3);
//                //row[1] = rs.getString(3);
//                //row[3] = rs.getString(7);
//
//                model.addRow(row);
        //      }
        // jTextFieldPesel.setText(idKlienta);
//        jTextFieldNazwisko.setText(model.getValueAt(rowIndex, 0).toString());
//        jTextFieldPesel.setText(model.getValueAt(rowIndex, 3).toString());
        //row[3] = rs.getString(7);
        /*
        String imie1 = jTextFieldImie.getText();
        String imie2 = jTextFieldImie2.getText();
        String nazwa = jTextFieldNazwa.getText();
        // int pesel = Integer.parseInt(jTextFieldPesel.getText());
        //int pesel = Integer.valueOf(jTextFieldPesel.getText()); zamieniam na stringa 
        String pesel = jTextFieldPesel.getText();
        String nip = jTextFieldNip.getText();
        //int regon = Integer.parseInt(jTextFieldRegon.getText());
        String regon = jTextFieldRegon.getText();
        String rodzaj_dok_toz = jComboBoxRodzDok.getSelectedItem().toString();
        String nr_dok_toz = jTextFieldNrDok.getText();
        String ulica = jTextFieldUlica.getText();
        //int nr_domu = Integer.parseInt(jTextFieldNrDomu.getText());
        String nr_domu = jTextFieldNrDomu.getText();
        //int nr_lokalu = Integer.parseInt(jTextFieldNrLokalu.getText());
        String nr_lokalu = jTextFieldNrLokalu.getText();
        String kod_pocztowy = jTextFieldKodPocztowy.getText();
        String miejscowosc = jTextFieldMiejscowosc.getText();
        String kraj = jTextFieldKraj.getText();
        String numer_konta = jTextFieldNrKonta.getText();
        //String numer_konta = Integer.parseInt(jTextFieldNrKonta.getText());
        String nr_rej_sadow = jTextFieldNrRejestruSad.getText();
        String nr_swift = jTextFieldSwift.getText();
        String mail = jTextFieldMail.getText();
        String telefon = jTextFieldTelefon.getText();
        String fax = jTextFieldFax.getText();*/
    }//GEN-LAST:event_jTable1MouseClicked

    //usuwanie klienta z aktu 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id_aktu = 0;
        int rowIndex = jTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int idKlienta;
//       idKlienta = (int) model.getValueAt(rowIndex, 0);

        //idKlienta = Integer.parseInt((String) model.getValueAt(rowIndex, 0)); 
        idKlienta = (int) model.getValueAt(rowIndex, 0);
        cli.deleteKlientDoAkt(idKlienta, idAktu);
        jTable2.setModel(new DefaultTableModel(null, new Object[]{"Lp.", "Strona czynności"}));
        cli.fillKlientDoAkt(jTable2, idAktu);
    }//GEN-LAST:event_jButton2ActionPerformed

    //dodawanie klienta do danego aktu 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowIndex = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int idKlienta;
        idKlienta = (int) model.getValueAt(rowIndex, 0);

        cli.insertKlientDoAkt(idKlienta, idAktu);
        jTable2.setModel(new DefaultTableModel(null, new Object[]{"Lp.", "Strona czynności"}));
        cli.fillKlientDoAkt(jTable2, idAktu);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //zamykanie okna
//        AddingRepWindow  arw = new AddingRepWindow();
//        arw. jTable20.setModel(new DefaultTableModel(null, new Object[]{"Id klienta", "Imię nazwisko nazwa", "PESEL/NIP", "Adres"}));
//        cli.fillKlientDoAkt(jTable20, idAktu);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // kiedy otwiera sie okno
        jTable2.setModel(new DefaultTableModel(null, new Object[]{"Lp.", "Strona czynności"}));
        cli.fillKlientDoAkt(jTable2, idAktu);

    }//GEN-LAST:event_formWindowOpened

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        jTable1.setModel(new DefaultTableModel(null, new Object[]{"Id.", "Imię i Nazwisko", "PESEL/NIP"}));
        cli.fillKlienciAll(jTable1, jTextField2.getText(), 2);

    }//GEN-LAST:event_jTextField2KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddingCustWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddingCustWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddingCustWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddingCustWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddingCustWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAddClient;
    private javax.swing.JButton jButtonAddClient1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldFax;
    private javax.swing.JTextField jTextFieldImie;
    private javax.swing.JTextField jTextFieldImie2;
    private javax.swing.JTextField jTextFieldKodPocztowy;
    private javax.swing.JTextField jTextFieldKraj;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldMiejscowosc;
    private javax.swing.JTextField jTextFieldNazwa;
    private javax.swing.JTextField jTextFieldNazwisko;
    private javax.swing.JTextField jTextFieldNip;
    private javax.swing.JTextField jTextFieldNrDok;
    private javax.swing.JTextField jTextFieldNrDomu;
    private javax.swing.JTextField jTextFieldNrKonta;
    private javax.swing.JTextField jTextFieldNrLokalu;
    private javax.swing.JTextField jTextFieldNrRejestruSad;
    private javax.swing.JTextField jTextFieldPesel;
    private javax.swing.JTextField jTextFieldRegon;
    private javax.swing.JTextField jTextFieldSwift;
    private javax.swing.JTextField jTextFieldTelefon;
    private javax.swing.JTextField jTextFieldUlica;
    // End of variables declaration//GEN-END:variables
}
