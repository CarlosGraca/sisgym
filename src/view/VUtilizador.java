package view;

import controller.ControllerUtilizador;
import persistence.DAOTipoUtilizador;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.table.DefaultTableModel;
import model.Item;
import model.Tipoutilizador;
import model.Utilizador;
import persistence.DAOUtilizador;
import security.SHAHashing;
import table.ModeloTabelaNivelAcesso;
import table.ModeloTabelaUtilizador;

/**
 *
 * @author Carlos
 */
public final class VUtilizador extends javax.swing.JInternalFrame {

    int janela = 0;
    Calendar calendar = Calendar.getInstance();//Variable de Objeto Calendar
    Utilizador obj;
    Tipoutilizador objTu;
    String acao = "";
    ControllerUtilizador utController;
    int status;
    SHAHashing cryptography;
    ModeloTabelaUtilizador modeloTabelaUtilizador;
    DAOUtilizador dao;
    ModeloTabelaNivelAcesso modeloTabelaMenu;

    public VUtilizador() {
        initComponents();

        jbNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNovo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbGuardar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCancelar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEditar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbApagar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbApagar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbApagar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbImprimir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        Date ds = new Date();
        jdcUt_dt_registro.setDate(ds);
        dao = new DAOUtilizador();
     
        //jtUtilizador.setAutoCreateRowSorter(true);
        
        jtUt_cod.setVisible(false);
        jLabel6.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbNovo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbApagar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jTabUt = new javax.swing.JTabbedPane();
        jpEqui_listar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtUtilizador = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePermissoes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTreeUtilizador = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jBConceder = new javax.swing.JButton();
        jBRetirar = new javax.swing.JButton();
        jpEqui_dados = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtUt_cod = new javax.swing.JTextField();
        jcbUt_nome = new javax.swing.JComboBox();
        jtUt_login = new javax.swing.JTextField();
        jpUt_senha = new javax.swing.JPasswordField();
        jdcUt_dt_registro = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbUt_tipo = new javax.swing.JComboBox();
        jcbUt_status = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Utilizadores do Sistema");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Opções");

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Add.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.setEnabled(false);
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

        jbApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Remove.png"))); // NOI18N
        jbApagar.setText("Apagar");
        jbApagar.setEnabled(false);
        jbApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApagarActionPerformed(evt);
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

        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Print.png"))); // NOI18N
        jbImprimir.setText("Imprimir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbApagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbImprimir)
                .addContainerGap())
        );

        jTabUt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabUt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabUtMouseClicked(evt);
            }
        });

        jtUtilizador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtUtilizador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUtilizadorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtUtilizador);

        jTablePermissoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablePermissoes);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("SGG");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Registar");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Clientes");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Funcionários");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Equipamentos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Modalidades");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Produtos");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Movimentos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Emissão Cartão");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Venda");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Processar Pagamento");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Emissão Fatura/ Recibo");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Presença");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Enviar Email");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Relátorios");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Clientes");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Funcionários");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Equipamentos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Manutenção");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Modalidades");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Recebimento");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Produto");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Venda");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R LOG");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("R Presença");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Auxilíares");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Log");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Copia Segurança");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Parâmetros");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Usuários do Sistema");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sistema");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Configurações de Email");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTreeUtilizador.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane3.setViewportView(jTreeUtilizador);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBConceder.setText("Conceder");
        jBConceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConcederActionPerformed(evt);
            }
        });

        jBRetirar.setText("Retirar");
        jBRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRetirarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jBConceder)
                .addGap(56, 56, 56)
                .addComponent(jBRetirar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConceder)
                    .addComponent(jBRetirar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpEqui_listarLayout = new javax.swing.GroupLayout(jpEqui_listar);
        jpEqui_listar.setLayout(jpEqui_listarLayout);
        jpEqui_listarLayout.setHorizontalGroup(
            jpEqui_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEqui_listarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEqui_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpEqui_listarLayout.setVerticalGroup(
            jpEqui_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEqui_listarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEqui_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(jpEqui_listarLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabUt.addTab("Lista de Utilizadores", jpEqui_listar);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de Utilizadores"));

        jLabel2.setText("Nome");

        jLabel6.setText("Código");

        jLabel8.setText("Login");

        jLabel11.setText("Senha");

        jtUt_cod.setEditable(false);

        jcbUt_nome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolher...", "Carlos Graça", "Ailton Fortes" }));
        jcbUt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUt_nomeActionPerformed(evt);
            }
        });

        jpUt_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpUt_senhaActionPerformed(evt);
            }
        });
        jpUt_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpUt_senhaKeyTyped(evt);
            }
        });

        jdcUt_dt_registro.setEnabled(false);

        jLabel3.setText("Data registro");

        jLabel4.setText("Perfil");

        jcbUt_status.setText("Utilizador Activo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtUt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbUt_status)
                    .addComponent(jpUt_senha)
                    .addComponent(jcbUt_tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbUt_nome, 0, 280, Short.MAX_VALUE)
                    .addComponent(jtUt_login)
                    .addComponent(jdcUt_dt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtUt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbUt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtUt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jpUt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcUt_dt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbUt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbUt_status)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jpEqui_dadosLayout = new javax.swing.GroupLayout(jpEqui_dados);
        jpEqui_dados.setLayout(jpEqui_dadosLayout);
        jpEqui_dadosLayout.setHorizontalGroup(
            jpEqui_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEqui_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpEqui_dadosLayout.setVerticalGroup(
            jpEqui_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEqui_dadosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabUt.addTab("Utilizadores", jpEqui_dados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabUt)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabUt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        inicio();
        selectTipoUtilizadores();
        utController = new ControllerUtilizador();
        cryptography = new SHAHashing();
        utController.selectFuncComobox();
        utController.preencherJTableUtilizadores();
        utController.preencherJTableMenu();
        utController.preencherJTableMenu2(-1);
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        janela = 0;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        jTabUt.setSelectedComponent(jpEqui_dados);
        ativarDesativaBotoes(true);
        ativarDesativarUtilizador(true);
        limparClienteCampos();
        jbNovo.setEnabled(false);//
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        String pass = cryptography.EncryptDescrypte(jpUt_senha.getText());
        Item selected_item = (Item) jcbUt_nome.getSelectedItem();
        if (jcbUt_status.isSelected()) {
            status = 1;
        } else {
            status = 0;
        }
        if (validarCampos()) {
            if (jtUt_cod.getText().equals("")) {                     
                utController.manutencaoUtilizador("inserir", jtUt_cod.getText(), jtUt_login.getText(), pass, status, new java.sql.Date(jdcUt_dt_registro.getDate().getTime()), new java.sql.Date(jdcUt_dt_registro.getDate().getTime()), selected_item.getId(), jcbUt_tipo.getSelectedIndex());
                ativarDesativarUtilizador(false);
                limparClienteCampos();
                ativarDesativaBotoes(true);
                desativaAtivaBotao2(true);

            } else {
                utController.manutencaoUtilizador("alterar", jtUt_cod.getText(), jtUt_login.getText(), pass, status, new java.sql.Date(jdcUt_dt_registro.getDate().getTime()), new java.sql.Date(jdcUt_dt_registro.getDate().getTime()), selected_item.getId(), jcbUt_tipo.getSelectedIndex());
                ativarDesativaBotoes(true);
                desativaAtivaBotao2(true);
            }
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        ativarDesativaBotoes(true);
        jbNovo.setEnabled(false);
        ativarDesativarUtilizador(true);
        desativaAtivaBotao2(false);
        jbCancelar.setEnabled(false);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limparClienteCampos();
        ativarDesativarUtilizador(false);
        ativarDesativaBotoes(false);
        desativaAtivaBotao2(false);
        jTabUt.setSelectedComponent(jpEqui_listar);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jTabUtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabUtMouseClicked

    }//GEN-LAST:event_jTabUtMouseClicked

    private void jpUt_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpUt_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpUt_senhaActionPerformed

    private void jtUtilizadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUtilizadorMouseClicked
        if (evt.getClickCount() == 2) {
            limparClienteCampos();
            jTabUt.setSelectedIndex(1);
            ativarDesativaBotoes(false);
            ativarDesativarUtilizador(false);
            utController.manutencaoPesquisa();
            jbCancelar.setEnabled(true);
        }
        if (evt.getClickCount() == 1) {
            try {
                dao.getTodosUtilizadores();
                modeloTabelaUtilizador = new ModeloTabelaUtilizador(dao.resultSet);                
                String i = (String) modeloTabelaUtilizador.getValueAt(jtUtilizador.getSelectedRow(), 0);
               // JOptionPane.showMessageDialog(this, i);
                int index = Integer.parseInt(i);
                //if (utController.checkUserAcessAdmin(index)) {
                    //DefaultTableModel model = (DefaultTableModel) jTablePermissoes.getModel();
                   // model.setRowCount(0);
                //    clearTable(jTablePermissoes);
               // } else {
                    utController.preencherJTableMenu2(index);
               // }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jtUtilizadorMouseClicked

    private void jbApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApagarActionPerformed
        Item selected_item = (Item) jcbUt_nome.getSelectedItem();
        utController.manutencaoUtilizador("excluir", jtUt_cod.getText(), jtUt_login.getText(), jpUt_senha.getText(), status, new java.sql.Date(jdcUt_dt_registro.getDate().getTime()), new java.sql.Date(jdcUt_dt_registro.getDate().getTime()), selected_item.getId(), jcbUt_tipo.getSelectedIndex());
        limparClienteCampos();
        ativarDesativaBotoes(false);
        ativarDesativarUtilizador(false);
        desativaAtivaBotao2(false);
    }//GEN-LAST:event_jbApagarActionPerformed

    private void jpUt_senhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpUt_senhaKeyTyped

    }//GEN-LAST:event_jpUt_senhaKeyTyped

    private void jBConcederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConcederActionPerformed
        try {
            if ((jTreeUtilizador.isSelectionEmpty()) || (jtUtilizador.getSelectedRow() == -1)) {
            } else {
                if ((jTreeUtilizador.getLastSelectedPathComponent().toString().equalsIgnoreCase("SGG"))
                        || (jTreeUtilizador.getLastSelectedPathComponent().toString().equalsIgnoreCase("Registar"))
                        || (jTreeUtilizador.getLastSelectedPathComponent().toString().equalsIgnoreCase("Movimentos"))
                        || (jTreeUtilizador.getLastSelectedPathComponent().toString().equalsIgnoreCase("Relátorios"))
                        || (jTreeUtilizador.getLastSelectedPathComponent().toString().equalsIgnoreCase("Auxilíares"))
                        || (jTreeUtilizador.getLastSelectedPathComponent().toString().equalsIgnoreCase("Parâmetros"))) {
                } else {
                    dao.getTodosUtilizadores();
                    modeloTabelaUtilizador = new ModeloTabelaUtilizador(dao.resultSet);
                    String i = (String) modeloTabelaUtilizador.getValueAt(jtUtilizador.getSelectedRow(), 0);
                    int index = Integer.parseInt(i);
                    if (utController.checkUserAcessAdmin(index)) {
                        JOptionPane.showMessageDialog(this, "Este utilizador é um Administrador tem todas as permissões");

                    } else {
                        utController.manutencaoMenu("inserir", 1, index, jTreeUtilizador.getLastSelectedPathComponent().toString());
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VUtilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBConcederActionPerformed
   public static void clearTable(final JTable table) {
        for (int i = 0; i < table.getRowCount(); i++){
           for(int j = 0; j < table.getColumnCount(); j++) {
               table.setValueAt("", i, j);
           }
        }
   }
    private void jBRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRetirarActionPerformed
        try {
            if (jTablePermissoes.getSelectedRow() == -1) {
            } else {
                dao.getTodosMenu2();
                modeloTabelaMenu = new ModeloTabelaNivelAcesso(dao.resultSet);
                String i = (String) modeloTabelaMenu.getValueAt(jTablePermissoes.getSelectedRow(), 0);
                int index = Integer.parseInt(i);
                utController.manutencaoMenu("excluir", index, Principal.id, "");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jBRetirarActionPerformed

    private void jcbUt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbUt_nomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConceder;
    private javax.swing.JButton jBRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTabbedPane jTabUt;
    public static javax.swing.JTable jTablePermissoes;
    private javax.swing.JTree jTreeUtilizador;
    private javax.swing.JButton jbApagar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbNovo;
    public static javax.swing.JComboBox jcbUt_nome;
    public static javax.swing.JCheckBox jcbUt_status;
    public static javax.swing.JComboBox jcbUt_tipo;
    public static com.toedter.calendar.JDateChooser jdcUt_dt_registro;
    private javax.swing.JPanel jpEqui_dados;
    private javax.swing.JPanel jpEqui_listar;
    public static javax.swing.JPasswordField jpUt_senha;
    public static javax.swing.JTextField jtUt_cod;
    public static javax.swing.JTextField jtUt_login;
    public static javax.swing.JTable jtUtilizador;
    // End of variables declaration//GEN-END:variables
     public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void limparClienteCampos() {
        jtUt_cod.setText("");
    }

    public void ativarDesativarUtilizador(boolean habilitar) {
        jcbUt_nome.setEnabled(habilitar);
        jtUt_login.setEditable(habilitar);
        jpUt_senha.setEditable(habilitar);
        jcbUt_tipo.setEnabled(habilitar);
        jcbUt_status.setEnabled(habilitar);
    }

    public void ativarDesativaBotoes(boolean habilitar) {
        jbGuardar.setEnabled(habilitar);
        jbCancelar.setEnabled(habilitar);
        jbNovo.setEnabled(habilitar);
        jbEditar.setEnabled(!habilitar);
        jbApagar.setEnabled(!habilitar);
        jbImprimir.setEnabled(!habilitar);
    }

    private boolean validarCampos() {
        if (jtUt_login.getText().equals("") || jcbUt_nome.getSelectedIndex() == 0 || jpUt_senha.getText().equals("") || jcbUt_tipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatório! Preencha os vazios", "Validação de Campos.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void inicio() {
        Date inicio = calendar.getTime();
        //Indicamos ano estamos -100 de actual
        calendar.add(Calendar.YEAR, -100);
        //Guardamos a configuracao  em um DATE
        Date fechaAnterior = calendar.getTime();
        //Indicamos ano estamos +200 de actual
        calendar.add(Calendar.YEAR, 200);
        //Guardamos a configuracao  em um DATE
        Date fechaPosterior = calendar.getTime();

        SpinnerModel horaModel = new SpinnerDateModel(inicio, fechaAnterior, fechaPosterior, Calendar.HOUR);
        //Indicamos o model para cada Spinner e o formato de hora.
    }

    public void selectTipoUtilizadores() {
        DAOTipoUtilizador DAO = new DAOTipoUtilizador();

        try {
            objTu = DAO.pesquisar(jcbUt_tipo);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro : " + erro.getMessage());
        }
    }

    public void desativaAtivaBotao2(boolean habilitar) {
        jbNovo.setEnabled(!habilitar);
        jbEditar.setEnabled(habilitar);
        jbApagar.setEnabled(habilitar);
    }

}
