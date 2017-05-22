/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zainal
 */
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class datamahasiswa extends javax.swing.JFrame {
    private Connection con = koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;
    private Object cn;

    /**
     * Creates new form datamahasiswa
     */
    public datamahasiswa() {
        initComponents();
    }
       private DefaultTableModel model;
    public void InitTable(){//inisiasi tabel atau membuat tabel secara manual
    model = new DefaultTableModel();
    model.addColumn("Nim");//membuat kolom ID di instance class model
    model.addColumn("Nama");//membuat kolom JUDUL di instance class model
    model.addColumn("Jenis Kelamin");//membuat kolom PENULIS di instance class model
    model.addColumn("Alamat");//membuat kolom HARGA di instance class model
    model.addColumn("No Hp");//membuat kolom HARGA di instance class model
    jTable1.setModel(model);
    }
    private void TampilData(){//fungsi menampilkan data
        try{
            String sql = "SELECT * FROM mahasiswa";//mendeklarasikan variabel sql dengan query untuk menampilkan semua data pada tabel buku
            stt = con.createStatement();//pembuatan statement
            rss = stt.executeQuery(sql);//eksekusi query
            while(rss.next()){
                Object[] o = new Object[5];//membuat nama object yaitu o dengan 4 array
                o[0] = rss.getString("nim");// objek data pada larik ke-0 yaitu mengambil nilai dari stt berupa id
                o[1] = rss.getString("nama");// objek data pada larik ke-1 yaitu mengambil nilai dari stt berupa judul
                o[2] = rss.getString("jenis_kelamin");// objek data pada larik ke-2 yaitu mengambil nilai dari stt berupa penulis
                o[3] = rss.getString("Alamat");// objek data pada larik ke-3 yaitu mengambil nilai dari stt berupa harga
                o[4] = rss.getString("no_hp");// objek data pada larik ke-3 yaitu mengambil nilai dari stt berupa harga
                model.addRow(o);//menambah baris pada model sesuai nilai dari parameternya yaitu o
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void TambahData(String nim, String nama, String jenis_kelamin , String Alamat, String no_hp ){//fungsi untuk menambah data
     try{
         String sql = "INSERT INTO mahasiswa VALUES('"+nim+"','"+nama+"','"+jenis_kelamin+"','"+Alamat+"','"+no_hp+"')";//mendeklarasikan variabel sql dengan query untuk menginsert data judul, penulis, harga
         stt = con.createStatement();//pembuatan statement
         stt.executeUpdate(sql);//eksekusi query
     }   
     catch(SQLException e){
         System.out.println(e.getMessage());
     }
    }
    public boolean UbahData(String nim, String nama, String jenis_kelamin , String Alamat, String no_hp){//fungsi untuk mengupdate data
        try{
            String sql ="UPDATE mahasiswa set nim ='"+nim+"', nama='"+nama+"', jenis_kelamin='"+jenis_kelamin+"',Alamat='"+Alamat+"',no_hp='"+no_hp+"' WHERE nim="+nim+";";//mendeklarasikan variabel sql dengan query untuk mengupdate data judul, penulis, harga berdasarkan id sesuai data tersebut
            stt = con.createStatement();//pembuatan statements
            stt.executeUpdate(sql);//eksekusi query
            return true;//mengembalikan nilai true(benar)      
        }
        
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;//mengembalikan nilai false(salah)
        }
    }
    public boolean HapusData(String nim){//fungsi untuk hapus data
        try{
            String sql = "DELETE FROM mahasiswa where nim="+nim+";";//mendeklarasikan variabel sql dengan query untuk menghapus data sesuai kondisi
            stt = con.createStatement();//pembuatan statements
            stt.executeUpdate(sql);//eksekusi query
            return true;//mengembalikan nilai true(benar)
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;//mengembalikan nilai false(salah)
        }
    }
    private void PencarianData(String by, String cari){//fungsi untuk mencari data yang telah ada 
        try{
            String sql ="SELECT * FROM mahasiswa where "+by+" LIKE'%"+cari+"%';";//mendeklarasikan variabel sql dengan query untuk mencari data berdasarkan variabel by dan yang mengandung setiap huruf dari variabel cari
            stt = con.createStatement();//pembuatan statements
            rss = stt.executeQuery(sql);//eksekusi query
            while(rss.next()){//perulangan untuk menampilkan data
                Object[] data = new Object[4];//membuat objek baru yaitu data dengan jumlah array 4
                data[0] = rss.getString("nim");// objek data pada larik ke-0 yaitu mengambil nilai dari stt berupa id
                data[1] = rss.getString("nama");// objek data pada larik ke-1 yaitu mengambil nilai dari stt berupa judul
                data[2] = rss.getString("jenis_kelamin");// objek data pada larik ke-2 yaitu mengambil nilai dari stt berupa penulis
                data[3] = rss.getString("Alamat");// objek data pada larik ke-3 yaitu mengambil nilai dari stt berupa harga
                data[3] = rss.getString("no_hp");// objek data pada larik ke-3 yaitu mengambil nilai dari stt berupa harga
                model.addRow(data);//menambah baris pada model sesuai nilai dari parameternya yaitu data
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        Nim = new javax.swing.JLabel();
        Alamat = new javax.swing.JLabel();
        No_Hp = new javax.swing.JLabel();
        NIM = new javax.swing.JTextField();
        NAMA = new javax.swing.JTextField();
        ALAMAT = new javax.swing.JTextField();
        jk = new javax.swing.JLabel();
        no = new javax.swing.JTextField();
        laki = new javax.swing.JRadioButton();
        cewe = new javax.swing.JRadioButton();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        Cari = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 18)); // NOI18N
        jLabel1.setText("DATA MAHASISWA");

        Nama.setText("Nama");

        Nim.setText("Nim");

        Alamat.setText("Alamat");

        No_Hp.setText("No Hp/Tlp");

        jk.setText("Jenis Kelamin");

        buttonGroup1.add(laki);
        laki.setText("Laki-Laki");

        buttonGroup1.add(cewe);
        cewe.setText("Perempuan");

        tambah.setText("Simpan");
        tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahMouseExited(evt);
            }
        });
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        tambah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tambahKeyPressed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ubahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ubahMouseExited(evt);
            }
        });
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hapusMouseExited(evt);
            }
        });
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Search");

        Cari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                CariCaretUpdate(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nim", "nama", "jenis_kelamin", "Alamat", "no_hp" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel2.setText("by");

        logout.setText("Keluar");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(No_Hp)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logout)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tambah)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Nama)
                                                .addComponent(jk)
                                                .addComponent(Nim))
                                            .addGap(42, 42, 42))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(Alamat)
                                            .addGap(72, 72, 72)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cewe)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(NAMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                            .addComponent(ALAMAT, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(no, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(laki, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ubah)
                                            .addComponent(NIM, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGap(83, 83, 83))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapus)
                        .addGap(136, 136, 136))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nama)
                    .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nim)
                    .addComponent(NIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jk))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(laki)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cewe)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Alamat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ALAMAT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(No_Hp)
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(ubah)
                    .addComponent(hapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        String nim = NIM.getText();//mendeklarasikan judul sesuai dengan texfield Judul
        String nama = NAMA.getText();//mendeklarasikan penulis sesuai dengan combobox combopenulis
        String jenis_kelamin = null;
        if(laki.isSelected()){
            jenis_kelamin = "Laki-laki";
        }
        else if(cewe.isSelected()){
        jenis_kelamin = "perempuan";
    }
        String Alamat = ALAMAT.getText();
        String no_hp = no.getText();
//         if(ValidasiData(judul,penulis)){ //penyeleksian kondisi yang diambil dari fungsi validasi dengan parameter judul dan penulis
//                JOptionPane.showMessageDialog(this, "Data sudah ada");
//            }
//         else{
        TambahData(nim, nama, jenis_kelamin, Alamat, no_hp);//menjalankan fugsi TambahData
        InitTable();//menampilkan ulang model dari table buku
        TampilData();//untuk menampilkan ulang fungsi TampilData
        JOptionPane.showMessageDialog(this,"data berhasil ditambahkan");
//         }
    }//GEN-LAST:event_tambahActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try{
        int baris =jTable1.getSelectedRow();//mendeklarasikan variabel baris sesuai dat yang dipilih di table
        String nim = jTable1.getValueAt(baris, 0).toString();//mendeklarasikan variabel id yang bernilai dari baris ke-0 dari tabel yang di konversi ke string
        if(HapusData(nim))//kondisi jika menjalankan fungsi HapusData dengan parameter id
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Hapus");
        else
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Hapus");
        InitTable();//menjalankan fungsi InitTable
        TampilData();//menalankan fungsi TampilData
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"table belum dipilih","kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        try{
            int baris = jTable1.getSelectedRow();//mendekarasikan variabel baris sesuai data yang dipilih di tabel
        
        String nim = jTable1.getValueAt(baris, 0).toString();//mendeklarasikan variabel id yang bernilai dari baris ke-0 dari tabel yang dikonversi ke string
        String nama = NAMA.getText();//mendeklarasikan judul sesuai dengan textfield Judul
        String jenis_kelamin = null;
        if(laki.isSelected()){
            jenis_kelamin = "Laki_laki";
        }
        else if(cewe.isSelected()){
            jenis_kelamin = "perempuan";
        }
        String Alamat = ALAMAT.getText();//mendeklarasikan harga sesuai dengan textfield Harga
        String no_hp = no.getText();//mendeklarasikan harga sesuai dengan textfield Harga
           
                UbahData(nim, nama, jenis_kelamin, Alamat, no_hp);//menjalankan fungsi UbahData 
                InitTable();//menjalankan fungsi InitTable
                TampilData();//menjalankan fungsi TampilData
                JOptionPane.showMessageDialog(null, "Data Berhasil DI Ubah");
           }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"table belum dipilih","kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1ComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
//        IdB.setText(jTable2.getValueAt(baris, 0).toString());
        NIM.setText(jTable1.getValueAt(baris, 0).toString());//mengeset nilai di textfield Judul sesuai nilai dari baris ke-1 dari jTable2 yang dijadikan ke tipe data String
        NAMA.setText(jTable1.getValueAt(baris, 1).toString());//mengeset nilai di textfield Judul sesuai nilai dari baris ke-1 dari jTable2 yang dijadikan ke tipe data String
//        jk.setSelectedItem(jTable1.getValueAt(baris, 2).toString());//mengeset nilai di combobox Penulis sesuai nilai dari baris ke-2 dari jTable2 yang dijadikan ke tipe data String
        ALAMAT.setText(jTable1.getValueAt(baris, 3).toString());
        no.setText(jTable1.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void CariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_CariCaretUpdate
        // TODO add your handling code here:
        InitTable();
        if(Cari.getText().length()==0){//kondisi jika texfield Cari kosong
            TampilData();//akan langsung menjalankan fungsi TampilData
        }
        else{
            PencarianData(combo.getSelectedItem().toString(),Cari.getText());//menjalan fungsi PencarianData nilai dari combo yang diadikan string dan nilai dari textfield Cari
        }
    }//GEN-LAST:event_CariCaretUpdate

    private void tambahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tambahKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tambahKeyPressed

    private void tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahMouseEntered
        // TODO add your handling code here:
        tambah.setBackground(Color.GREEN);
    }//GEN-LAST:event_tambahMouseEntered

    private void tambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahMouseExited
        // TODO add your handling code here:
        tambah.setBackground(Color.white);
    }//GEN-LAST:event_tambahMouseExited

    private void ubahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubahMouseEntered
        // TODO add your handling code here:
        ubah.setBackground(Color.GREEN);
    }//GEN-LAST:event_ubahMouseEntered

    private void ubahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubahMouseExited
        // TODO add your handling code here:
        ubah.setBackground(Color.white);
    }//GEN-LAST:event_ubahMouseExited

    private void hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseEntered
        // TODO add your handling code here:
        hapus.setBackground(Color.GREEN);
    }//GEN-LAST:event_hapusMouseEntered

    private void hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseExited
        // TODO add your handling code here:
        hapus.setBackground(Color.white);
    }//GEN-LAST:event_hapusMouseExited

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
            dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        logout.setBackground(Color.green);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        // TODO add your handling code here:
        logout.setBackground(Color.white);
    }//GEN-LAST:event_logoutMouseExited

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
            java.util.logging.Logger.getLogger(datamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datamahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ALAMAT;
    private javax.swing.JLabel Alamat;
    private javax.swing.JTextField Cari;
    private javax.swing.JTextField NAMA;
    private javax.swing.JTextField NIM;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel Nim;
    private javax.swing.JLabel No_Hp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cewe;
    private javax.swing.JComboBox combo;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jk;
    private javax.swing.JRadioButton laki;
    private javax.swing.JButton logout;
    private javax.swing.JTextField no;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
