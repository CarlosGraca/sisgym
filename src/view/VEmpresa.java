/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import persistence.DAOEmpresa;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Empresa;


/**
 *
 * @author Carlos
 */
public final class VEmpresa extends javax.swing.JInternalFrame {

    int janela = 0;
    Empresa obj;
    String acao = "";
    private String localFoto = null;

    /**
     * Creates new form Ve
     */
    public VEmpresa() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtEmp_nif = new javax.swing.JTextField();
        jtEmp_telf = new javax.swing.JTextField();
        jtEmp_nome = new javax.swing.JTextField();
        jtEmp_local = new javax.swing.JTextField();
        jtEmp_email = new javax.swing.JTextField();
        jtEmp_cp = new javax.swing.JTextField();
        jtEmp_telm = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEmp_procurar = new javax.swing.JButton();
        jlEmp_Foto = new javax.swing.JLabel();
        jlVerificarNif = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Definições de Sistema");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        panel1.setColorPrimario(new java.awt.Color(153, 153, 153));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nome:");

        jLabel2.setText("NIF:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("C.P.:");

        jLabel5.setText("Localização");

        jLabel6.setText("Telemovel:");

        jLabel9.setText("Email:");

        jtEmp_nif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEmp_nifKeyTyped(evt);
            }
        });

        jtEmp_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmp_localActionPerformed(evt);
            }
        });

        jtEmp_cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmp_cpActionPerformed(evt);
            }
        });

        jtEmp_telm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmp_telmActionPerformed(evt);
            }
        });

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Modify.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Close.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbEmp_procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Upload.png"))); // NOI18N
        jbEmp_procurar.setText("Procurar");
        jbEmp_procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmp_procurarActionPerformed(evt);
            }
        });

        jlEmp_Foto.setBackground(new java.awt.Color(255, 255, 255));
        jlEmp_Foto.setToolTipText("Duplo click para carregar o logótipo");
        jlEmp_Foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlVerificarNif.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlVerificarNif.setForeground(new java.awt.Color(204, 0, 0));
        jlVerificarNif.setText("Apenas numero");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtEmp_nome)
                        .addComponent(jtEmp_email)
                        .addComponent(jtEmp_telf)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtEmp_telm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(jtEmp_nif, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtEmp_cp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlVerificarNif)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jtEmp_local))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jbEmp_procurar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jlEmp_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtEmp_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtEmp_nif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlVerificarNif))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtEmp_telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtEmp_telm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtEmp_local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtEmp_cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtEmp_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlEmp_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbEditar)
                    .addComponent(jbCancelar)
                    .addComponent(jbEmp_procurar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtEmp_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmp_localActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmp_localActionPerformed

    private void jtEmp_cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmp_cpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmp_cpActionPerformed

    private void jtEmp_telmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmp_telmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmp_telmActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        janela = 0;
        validar(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            if (validarCampos()) {
                if (PreencherObjeto()) {
                    DAOEmpresa DAO = new DAOEmpresa();
                    if (acao.equals("Editar")) {
                        if (DAO.editar(obj)) {
                            JOptionPane.showMessageDialog(this, "Registo Editado com sucesso");
                            desativarAtivarCampos(false);
                            ativarDesativaBotao(false);
                            validar(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Não foi possivel editar o registro!");
                        }

                    } else {
                        if (DAO.incluir(obj)) {
                            JOptionPane.showMessageDialog(this, "Registo salvo com sucesso");
                            desativarAtivarCampos(false);
                            ativarDesativaBotao(false);
                            validar(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Não foi possivel inserir o registro!");
                        }
                    }
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro : " + erro.getMessage());
        }

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        acao = "Editar";
        desativarAtivarCampos(true);
        ativarDesativaBotao(true);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        desativarAtivarCampos(false);
        ativarDesativaBotao(false);
        validar(true);
        selectDadosEmpresa();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEmp_procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmp_procurarActionPerformed
        carregaFoto();
    }//GEN-LAST:event_jbEmp_procurarActionPerformed

    private void jtEmp_nifKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmp_nifKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            validar(false);
        }
    }//GEN-LAST:event_jtEmp_nifKeyTyped

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        selectDadosEmpresa();
        validar(true);
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEmp_procurar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JLabel jlEmp_Foto;
    private javax.swing.JLabel jlVerificarNif;
    private javax.swing.JTextField jtEmp_cp;
    private javax.swing.JTextField jtEmp_email;
    private javax.swing.JTextField jtEmp_local;
    private javax.swing.JTextField jtEmp_nif;
    private javax.swing.JTextField jtEmp_nome;
    private javax.swing.JTextField jtEmp_telf;
    private javax.swing.JTextField jtEmp_telm;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void carregaFoto() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar logótipo");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG, JPG, GIF, and BMP Images", "PNG", "jpg", "gif", "bmp");
        fileChooser.setFileFilter(filter);

        // int a = fileChooser.showOpenDialog(null);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();//arquivo
            BufferedImage imagem = null;
            try {
                imagem = ImageIO.read(arquivo); //carrega a imagem real num buffer
            } catch (IOException ex) {
                Logger.getLogger(VCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            BufferedImage aux = new BufferedImage(150, 120, imagem.getType());//cria um buffer auxiliar com o tamanho desejado
            Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao
            AffineTransform at = AffineTransform.getScaleInstance((double) 150 / imagem.getWidth(), (double) 120 / imagem.getHeight());//cria a transformacao
            g.drawRenderedImage(imagem, at);//pinta e transforma a imagem real no auxiliar
            jlEmp_Foto.setIcon(new ImageIcon(aux));//seta no jlabel

            //LB_Foto.setIcon(new ImageIcon(fileChooser.getSelectedFile().getPath()));
            localFoto = fileChooser.getSelectedFile().getPath();
            //jbCli_limpar.setEnabled(true);
        }
    }

    public void selectDadosEmpresa() {
        DAOEmpresa DAO = new DAOEmpresa();
        try {
            obj = DAO.pesquisar();

            if (obj == null) {
                //JOptionPane.showMessageDialog(this, "Registro não encontrado !");
            } else {
                jtEmp_nome.setText(obj.getNome());
                jtEmp_nif.setText(String.valueOf(obj.getNif()));
                jtEmp_telf.setText(obj.getTelefone());
                jtEmp_telm.setText(obj.getTelemovel());
                jtEmp_cp.setText(String.valueOf(obj.getCp()));
                jtEmp_email.setText(obj.getEmail());
                jtEmp_local.setText(obj.getLocalizacao());

                BufferedImage img = ImageIO.read(new ByteArrayInputStream(obj.getLogo()));

                int type = img.getType();
                if (type == 0) {
                    type = 5;
                } else {
                    type = type;
                }  //se o tipo for 0, corrige para 5  

                //Converte o tamanho da imagem e mostra no jLabel  
                BufferedImage aux = new BufferedImage(150, 120, type);//cria um buffer auxiliar com o tamanho desejado    
                Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao    
                AffineTransform at = AffineTransform.getScaleInstance((double) 150 / img.getWidth(), (double) 120 / img.getHeight());//cria a transformacao    
                g.drawRenderedImage(img, at);//pinta e transforma a imagem real no auxiliar    
                jlEmp_Foto.setIcon(new ImageIcon(aux));

                desativarAtivarCampos(false);
                ativarDesativaBotao(false);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro : " + erro.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(VEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desativarAtivarCampos(Boolean habilitar) {
        jtEmp_nome.setEditable(habilitar);
        jtEmp_nif.setEditable(habilitar);
        jtEmp_telf.setEditable(habilitar);
        jtEmp_telm.setEditable(habilitar);
        jtEmp_cp.setEditable(habilitar);
        jtEmp_email.setEditable(habilitar);
        jtEmp_local.setEditable(habilitar);
        //jlEmp_Foto.setEnabled(habilitar);
    }

    private boolean PreencherObjeto() throws Exception {
        byte[] bytes;
        try (ByteArrayOutputStream bytesImg = new ByteArrayOutputStream()) {
            BufferedImage imagemBuffer = ImageIO.read(new File(localFoto));
            ImageIO.write((BufferedImage) imagemBuffer, "jpg", bytesImg);
            bytesImg.flush();
            bytes = bytesImg.toByteArray();
        }

        obj = new Empresa();
        obj.setNome(jtEmp_nome.getText());
        int nif = Integer.parseInt(jtEmp_nif.getText());
        obj.setNif(nif);
        obj.setTelefone(jtEmp_telf.getText());
        obj.setTelemovel(jtEmp_telm.getText());
        int cp = Integer.parseInt(jtEmp_cp.getText());
        obj.setCp(cp);
        obj.setEmail(jtEmp_email.getText());
        obj.setLocalizacao(jtEmp_local.getText());
        obj.setLogo(bytes);
        return true;
    }

    public void ativarDesativaBotao(Boolean habilitar) {
        jbGuardar.setEnabled(habilitar);
        jbEditar.setEnabled(!habilitar);
        jbCancelar.setEnabled(habilitar);
        jbEmp_procurar.setEnabled(habilitar);
    }

    private void validar(Boolean valid) {
        jlVerificarNif.setVisible(!valid);
    }

    private boolean validarCampos() {
        if (jtEmp_nome.getText().equals("") || jtEmp_nif.getText().equals("") || jtEmp_cp.equals("")
                || jtEmp_email.getText().equals("") || jtEmp_local.getText().equals("") || jtEmp_telf.getText().equals("")
                || jtEmp_telm.getText().equals("")/* || jlEmp_Foto.getText().equals("")*/) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatório! Preencha os vazios", "Validação de Campos.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}