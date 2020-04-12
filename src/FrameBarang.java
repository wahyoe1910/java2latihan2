
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joni
 */
public class FrameBarang extends javax.swing.JFrame {
    private Statement stat;
 private ResultSet rs;
 DefaultTableModel model;
 private final String judulKolom[]={"No.","Kode Barang","Nama Barang","Kategori","Satuan","Harga","Jumlah"};
 private String[][] dataBarang;
 String objKategori[]={"seragam sekolah","seragam kantor","sport","casual"};
 
 private void setModeltabel(){
 // membuat tampilan model tabel
 model = new DefaultTableModel(dataBarang,judulKolom);
 tblBarang.setModel(model);
 }
    private void view_data(){
    model.getDataVector().removeAllElements();
    try {
            int no=1;
            String sql = "select * from barang";
            koneksi objkoneksi=new koneksi();
            Connection con=objkoneksi.bukaKoneksi();
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
            model.addRow(new
            Object[]{no++,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
        }

                            } catch (Exception e) {
 }
 }
    
    /**
     * Creates new form FrameBarang
     */
    public FrameBarang() {
        initComponents();
        setModeltabel();
        awal();
        view_data();
        
       tblBarang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tblBarang.getSelectedRow();
                if(row!=-1){
                    String tKode =(tblBarang.getModel().getValueAt(row, 1).toString());
                    String tNama =(tblBarang.getModel().getValueAt(row, 2).toString());
                    String tKategori =(tblBarang.getModel().getValueAt(row, 3).toString());
                    String tSatuan =(tblBarang.getModel().getValueAt(row, 4).toString());
                    String tHarga =(tblBarang.getModel().getValueAt(row, 5).toString());
                    String tJumlah =(tblBarang.getModel().getValueAt(row, 6).toString());
                    
                    txtkode.setText(tKode);
                    txtnama.setText(tNama);
                    txtharga.setText(tHarga);
                    txtjumlah.setText(tJumlah);
                    btnUbah.setEnabled(true);
                    btnHapus.setEnabled(true);
                    btnSimpan.setEnabled(false);
                    
                    
                    cbkategori.setSelectedItem(tKategori);
                    switch (tSatuan) {
                        case "pcs":
                            rbpcs.setSelected(true);
                            break;
                        case "box":
                            rbbox.setSelected(true);
                            break;
                        default:
                            rbrim.setSelected(true);
                            break;
                    }
                }}
        }); 
                
                                          
        for (String object : objKategori){
            cbkategori.addItem(object);
    }
    }
            
               
               
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSatuan = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtkode = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        rbpcs = new javax.swing.JRadioButton();
        rbbox = new javax.swing.JRadioButton();
        rbrim = new javax.swing.JRadioButton();
        cbkategori = new javax.swing.JComboBox<>();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("FORM BARANG");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Kode Barang:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nama Barang:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Kategori:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Satuan:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Harga:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Jumlah:");

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });
        txtharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthargaKeyTyped(evt);
            }
        });

        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlahKeyTyped(evt);
            }
        });

        btnGroupSatuan.add(rbpcs);
        rbpcs.setText("pcs");
        rbpcs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbpcsActionPerformed(evt);
            }
        });

        btnGroupSatuan.add(rbbox);
        rbbox.setText("box");

        btnGroupSatuan.add(rbrim);
        rbrim.setText("rim");

        cbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Pilih Kategori---" }));
        cbkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkategoriActionPerformed(evt);
            }
        });

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBarang.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tblBarangComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tblBarangComponentRemoved(evt);
            }
        });
        tblBarang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblBarangAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tblBarang);

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbpcs)
                                        .addGap(10, 10, 10)
                                        .addComponent(rbbox)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbrim))
                                    .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbah)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbpcs)
                    .addComponent(rbbox)
                    .addComponent(rbrim))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        String satuan;
 if(rbpcs.isSelected()){
 satuan = "pcs";
 }else if(rbbox.isSelected()){
 satuan = "box";
 }else{
 satuan = "rim";
 }
 try{
 koneksi objkoneksi=new koneksi();
 Connection con=objkoneksi.bukaKoneksi();
 String sql="INSERT INTO barang VALUES('"+txtkode.getText()+"','"+txtnama.getText()+"','"+cbkategori.getSelectedItem()
 +"','"+satuan+"','"+txtharga.getText()+"','"+txtjumlah.getText()+"')";
 stat = con.createStatement();
 stat.execute(sql);

 JOptionPane.showMessageDialog(null, "Data Berhasil di Input");
 awal();
 view_data();

 txtkode.setText("");
 txtnama.setText("");
 txtharga.setText("");
 txtjumlah.setText("");
 cbkategori.setSelectedIndex(0);
 rbpcs.setSelected(false);
 rbbox.setSelected(false);
 rbrim.setSelected(false);
 txtkode.requestFocus();

 }
 catch (HeadlessException | SQLException e)
 {
 System.out.println("gagal="+e.getMessage());
 }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void rbpcsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbpcsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbpcsActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void cbkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkategoriActionPerformed

    private void txthargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyTyped
        // TODO add your handling code here:
        char cDigit = evt.getKeyChar();
 if(txtharga.getText().length()<10){
 if(!Character.isDigit(cDigit)){
 evt.consume();
 }
 }else{
 evt.consume();
 }
    }//GEN-LAST:event_txthargaKeyTyped

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void txtjumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyTyped
        // TODO add your handling code here:
        char cDigit = evt.getKeyChar();
 if(txtjumlah.getText().length()<5){
 if(!Character.isDigit(cDigit)){
 evt.consume();
 }
 }else{
 evt.consume();
 }
    }//GEN-LAST:event_txtjumlahKeyTyped

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        awal(); 
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tblBarangComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblBarangComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBarangComponentAdded

    private void tblBarangComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblBarangComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBarangComponentRemoved

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        if(cbkategori.getSelectedIndex()!=0){
 String satuan;
 if(rbpcs.isSelected()){
 satuan = "pcs";
 }else if(rbbox.isSelected()){
 satuan = "box";
 }else if(rbrim.isSelected()){
 satuan = "rim";
 }else{
 satuan = null;
 }
 try{koneksi objkoneksi=new koneksi();
 Connection con=objkoneksi.bukaKoneksi();
 String sql="UPDATE barang SET namabarang='"+txtnama.getText()+"',kategori='"+cbkategori.getSelectedItem()+"',"+ " satuan='"+satuan+"', harga='"+txtharga.getText()+"',jumlah='"+txtjumlah.getText()+"' where kodebarang='"+txtkode.getText()+"' ";
 stat = con.createStatement();
 stat.executeUpdate(sql);
 javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil diubah");  
    
 }

 catch (HeadlessException | SQLException e)
 {
 System.out.println("gagal="+e.getMessage());
 }
 }else{
 JOptionPane.showMessageDialog(null, "Pilih kategori barang","notifikasi",2);
  
 }
awal();    
 view_data();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblBarangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblBarangAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBarangAncestorAdded

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try{            
            koneksi objkoneksi=new koneksi();          
            Connection con=objkoneksi.bukaKoneksi();   
            String sql="DELETE from barang where kodebarang='"+txtkode.getText()+"' ";        
            stat = con.createStatement();            
            stat.executeUpdate(sql);                   
            JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");  
               
            awal(); 
              view_data();  
        }         
        catch (HeadlessException | SQLException e) {       
            System.out.println("gagal="+e.getMessage());       
        } 
         
            
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrameBarang().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.ButtonGroup btnGroupSatuan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbkategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbbox;
    private javax.swing.JRadioButton rbpcs;
    private javax.swing.JRadioButton rbrim;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables

    private void awal() {
          txtkode.setText("");
 txtnama.setText("");
 txtharga.setText("");
 txtjumlah.setText("");
 cbkategori.setSelectedIndex(0);
 rbpcs.setSelected(false);
 rbbox.setSelected(false);
 rbrim.setSelected(false);
 txtkode.requestFocus();
       //To change body of generated methods, choose Tools | Templates.
    }
}
