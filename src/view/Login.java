package view;

import controller.ControllerLog;
import controller.ControllerUtilizador;
import java.awt.Toolkit;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import persistence.Conexao;
import security.SHAHashing;
import static view.Principal.jlDiasVecimento;

public final class Login extends javax.swing.JFrame {
    
    public static Conexao con = new Conexao();
    ControllerUtilizador usuarioController;
    ControllerLog logController;
    SHAHashing encDes;
    public static String hora = null;
    Date data;
    long dt;
Splash p;
    public Login() {
        initComponents();
        URL url = this.getClass().getResource("/imagem/logo.png");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        getRootPane().setDefaultButton(jbOk);

        usuarioController = new ControllerUtilizador();
        logController = new ControllerLog();
        encDes = new SHAHashing();
        data = new Date();

        geraHora();
         p= new Splash();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtPassword = new org.edisoncor.gui.passwordField.PasswordFieldRoundBackground();
        jtLogin = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        jbCancelar = new javax.swing.JButton();
        jbOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar o Sistema ");
        setUndecorated(true);
        setResizable(false);

        panel1.setColorPrimario(new java.awt.Color(255, 0, 0));
        panel1.setColorSecundario(new java.awt.Color(0, 0, 204));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Iniciar Sessão");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logo.png"))); // NOI18N

        jtPassword.setDescripcion("password");
        jtPassword.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jtLogin.setDescripcion("login");
        jtLogin.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setBorderPainted(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/login.png"))); // NOI18N
        jbOk.setText("Entrar");
        jbOk.setBorderPainted(false);
        jbOk.setFocusCycleRoot(true);
        jbOk.setMaximumSize(new java.awt.Dimension(80, 25));
        jbOk.setMinimumSize(new java.awt.Dimension(80, 25));
        jbOk.setPreferredSize(new java.awt.Dimension(80, 25));
        jbOk.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jbOkComponentHidden(evt);
            }
        });
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });
        jbOk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbOkKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Login Manager.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Copyright © 2015 - SGG");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Powered by mcsolution");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jbOk, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelar))
                    .addComponent(jtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        String pass = encDes.EncryptDescrypte(jtPassword.getText());
        /* if ((jtLogin.getText().equals("teste")) && (jtPassword.getText().equals("mcsgym"))) {
         VJDialogConexao obj = new VJDialogConexao(this, true);
         dispose();
         obj.setVisible(true);
         } else {*/
        if (usuarioController.verificaUtilizador(jtLogin.getText(), pass)) {
            //setProgressBarVisibility(true);
            new Thread() {
                @Override
                public void run() {
                    logController.manutencaoLog("inserir", Principal.id, hora, "Log In", new java.sql.Date(data.getTime()));
                    long dias = calculaDataVecimento();
                    if (dias == 0) {
                        JOptionPane.showMessageDialog(null, "Data Validade do sistema terminou! Entre em contacto com o desenvolvedor");
                        System.exit(0);
                    } else {
                        new Principal().setVisible(true);
                        Principal.jtUtilizador.setText(jtLogin.getText());
                        jlDiasVecimento.setText("" + dt + " Dias");
                        dispose();
                        p.dispose();
                    }
                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    //setOpacity(0.85f);
                    p.setVisible(true);
                }
            }.start();  
        } else {
            limparCampos();
            jtLogin.requestFocus();
        }
        //}
    }//GEN-LAST:event_jbOkActionPerformed

    public String geraHora() {
        int s, m, h;
        Calendar calendario = Calendar.getInstance();
        s = calendario.get(Calendar.SECOND);
        m = calendario.get(Calendar.MINUTE);
        h = calendario.get(Calendar.HOUR_OF_DAY);
        hora = h + ":" + m + ":" + s;
        return hora;
    }

    public long calculaDataVecimento() {
        try {
            String DataFinal = logController.getDataEntradaSistema();
            String txtData = alterarData(DataFinal);
            long totalDiasValidade = Long.parseLong(logController.diaValidadeSistema());
            Calendar calendarDataNasc = Calendar.getInstance();
            Calendar calendarDataFinal = Calendar.getInstance();
            DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT);
            long diaMilisegundos = 1000 * 60 * 60 * 24;
            Date dataNasc = formatoData.parse(txtData);
            Date dataFinal = new Date();
            calendarDataNasc.setTime(dataNasc);
            calendarDataFinal.setTime(dataFinal);
            long dataInicial = calendarDataNasc.getTimeInMillis();
            long dataFim = calendarDataFinal.getTimeInMillis();
            long anos = (dataFim - dataInicial) / (diaMilisegundos * 365);
            long dias = (dataFim - dataInicial) / (diaMilisegundos);
            dt = totalDiasValidade - dias;
            return dt;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return 0;
    }
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbOkComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jbOkComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jbOkComponentHidden

    private void jbOkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbOkKeyPressed

    }//GEN-LAST:event_jbOkKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbOk;
    public org.edisoncor.gui.textField.TextFieldRoundBackground jtLogin;
    public org.edisoncor.gui.passwordField.PasswordFieldRoundBackground jtPassword;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        jtLogin.setText("");
        jtPassword.setText("");
    }

    public String alterarData(String data) {
        String dia, mes, ano;
        dia = data.substring(8, data.length());
        mes = data.substring(5, 7);
        ano = data.substring(0, 4);

        String dataFinal = "" + dia + "-" + mes + "-" + ano;
        return dataFinal;
    }
}
