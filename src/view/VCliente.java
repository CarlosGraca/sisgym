package view;

import controller.ControllerCliente;
import controller.ControllerMatricula;
import controller.ControllerMatriculaModalidade;
import controller.ControllerPagamento;
import controller.ControllerRecibo;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Modalidade;
import org.opencv.core.Core;
import persistence.Conexao;

public class VCliente extends javax.swing.JInternalFrame {

    int janela = 0;
    ControllerCliente controllerCliente;
    ControllerMatricula controllerMatricula;
    ControllerPagamento controllerPagamento;
    ControllerMatriculaModalidade controllerMatriculaModalidade;
    ControllerRecibo controllerRecibo;
    VPagamentos obj;
    public static String localFoto = null;
    byte[] bytes = null;
    String acao = null;
    String ultimoRegistro = null;
    String ultimoMatricula = null;
    int idCliente = 0;
    int idModal;
    public double total;
    String codigoBarra;
    String ultimoRegistroPagamento = null;
    String codPagamento = null;
    String ultimoCodPagamento = null;
    String sql = null;
    VTirar_Foto obj2;
    JFileChooser fileChooser;
    int idMatricula = 0;
    Double valorModal;
    int flag = 0;
    Conexao con = Login.con;
    public static ArrayList<Modalidade> arrayModalidade;
    Modalidade mod;

    public VCliente() {
        arrayModalidade = new ArrayList<>();
        mod = new Modalidade();

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
        jdCli_dtReg.setDate(ds);

        jTabCliente.setAutoCreateRowSorter(true);
        getRootPane().setDefaultButton(jBPesquisar);

        controllerPagamento = new ControllerPagamento();
        controllerCliente = new ControllerCliente();
        controllerMatricula = new ControllerMatricula();
        controllerMatriculaModalidade = new ControllerMatriculaModalidade();
        jtCli_cod.setVisible(false);
        jLabel31.setVisible(false);
        jcCliente.setVisible(false);
        jLabel2.setVisible(false);
        jtPag_cod.setVisible(false);
        
       // jcCli_status.setSelectedItem("Ativo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbNovo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbApagar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jTabCli = new javax.swing.JTabbedPane();
        jpCli_listar = new javax.swing.JPanel();
        jtPesquisar = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabCliente = new javax.swing.JTable();
        jpCli_dados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpCli_dado = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jtCli_totalApagar = new javax.swing.JTextField();
        jcModalidade = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtModalidadeCliente = new javax.swing.JTable();
        jbAdd = new javax.swing.JButton();
        jtRemover = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtCli_prof = new javax.swing.JTextField();
        jtCli_locTrab = new javax.swing.JTextField();
        jtCli_telTrab = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jtCli_edu = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtaCli_obs = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jcCli_sexo = new javax.swing.JComboBox();
        jcCli_status = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jpCli_foto = new javax.swing.JPanel();
        jlFoto = new javax.swing.JLabel();
        jtCli_cod = new javax.swing.JTextField();
        jtCli_nome = new javax.swing.JTextField();
        jtCli_bi = new javax.swing.JTextField();
        jtCli_telm = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jtCli_cp = new javax.swing.JTextField();
        jtCli_morada = new javax.swing.JTextField();
        jtCli_email = new javax.swing.JTextField();
        jbCli_procurar = new javax.swing.JButton();
        jbCli_limpar = new javax.swing.JButton();
        jb_tirar_foto = new javax.swing.JButton();
        jdCli_dtNasc = new com.toedter.calendar.JDateChooser();
        jdCli_dtReg = new com.toedter.calendar.JDateChooser();
        jcCliente = new javax.swing.JComboBox();
        jpCli_Pagamento = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPag_obs = new javax.swing.JTextArea();
        jtPag_valor = new javax.swing.JTextField();
        jcbPag_tipoPag = new javax.swing.JComboBox();
        jcbPag_desc = new javax.swing.JComboBox();
        jtPag_cod = new javax.swing.JTextField();
        jtClientePagamento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbPag_mes = new javax.swing.JComboBox();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manutenção de cliente");
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
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

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
                .addGap(5, 5, 5))
        );

        jTabCli.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabCliMouseClicked(evt);
            }
        });

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.setMaximumSize(new java.awt.Dimension(79, 25));
        jBPesquisar.setMinimumSize(new java.awt.Dimension(79, 25));
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jTabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Tel", "Morada", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabCliente);
        if (jTabCliente.getColumnModel().getColumnCount() > 0) {
            jTabCliente.getColumnModel().getColumn(0).setMinWidth(40);
            jTabCliente.getColumnModel().getColumn(0).setMaxWidth(40);
            jTabCliente.getColumnModel().getColumn(2).setMinWidth(80);
            jTabCliente.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabCliente.getColumnModel().getColumn(4).setMinWidth(60);
            jTabCliente.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jpCli_listarLayout = new javax.swing.GroupLayout(jpCli_listar);
        jpCli_listar.setLayout(jpCli_listarLayout);
        jpCli_listarLayout.setHorizontalGroup(
            jpCli_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_listarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCli_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(jpCli_listarLayout.createSequentialGroup()
                        .addComponent(jtPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCli_listarLayout.setVerticalGroup(
            jpCli_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_listarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpCli_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabCli.addTab("Lista de Clientes", jpCli_listar);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Informaçoes modalidade"));

        jLabel24.setText("Total a Pagar");

        jtCli_totalApagar.setEditable(false);

        jcModalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione pelo menos uma modalidade", "karaté/Defesa Pessoal", "Ginástica Tae-Bo", "Tae-Bo", "Treino Cardio" }));

        jtModalidadeCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço"
            }
        ));
        jScrollPane6.setViewportView(jtModalidadeCliente);

        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Add.png"))); // NOI18N
        jbAdd.setToolTipText("Click para adicionar uma nova modalidade a este cliente");
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jtRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Remove.png"))); // NOI18N
        jtRemover.setToolTipText("Selcione uma modalidade na tabela e click aqui para remove-lo deste cliente");
        jtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtCli_totalApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcModalidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jtCli_totalApagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Outras informaçoes"));

        jLabel20.setText("Profissao");

        jLabel21.setText("Local Trab.");
        jLabel21.setToolTipText("Local de Trabalho");

        jLabel22.setText("Tel. Trab.");
        jLabel22.setToolTipText("Telefone de Trabalho");

        jtCli_prof.setEditable(false);

        jtCli_locTrab.setEditable(false);

        jtCli_telTrab.setEditable(false);
        jtCli_telTrab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCli_telTrabKeyTyped(evt);
            }
        });

        jLabel25.setText("Enc. Edu");
        jLabel25.setToolTipText("Encarregado de Educação");

        jtCli_edu.setEditable(false);

        jLabel26.setText("Observaçao");

        jtaCli_obs.setEditable(false);
        jtaCli_obs.setColumns(20);
        jtaCli_obs.setRows(5);
        jtaCli_obs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtaCli_obsMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtaCli_obs);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCli_telTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCli_edu)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCli_locTrab))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCli_prof)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jtCli_prof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jtCli_locTrab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jtCli_telTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jtCli_edu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação"));

        jLabel27.setText("Nome");

        jLabel28.setText("BI");
        jLabel28.setToolTipText("Bilhete de Identidade");

        jLabel29.setText("Morada");

        jLabel30.setText("Data Reg");
        jLabel30.setToolTipText("Data de registo");

        jLabel31.setText("Codigo");

        jLabel32.setText("Email");

        jLabel33.setText("Data Nasc");
        jLabel33.setToolTipText("Data de Nascimento");

        jLabel34.setText("Telemovel");

        jcCli_sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Masculino", "Feminino" }));
        jcCli_sexo.setEnabled(false);

        jcCli_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inativo", "Ativo" }));
        jcCli_status.setEnabled(false);

        jLabel35.setText("C.P.");
        jLabel35.setToolTipText("Código Postal");

        jpCli_foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlFoto.setBackground(new java.awt.Color(255, 255, 255));
        jlFoto.setForeground(new java.awt.Color(102, 102, 102));
        jlFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fotoCliente.png"))); // NOI18N
        jlFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpCli_fotoLayout = new javax.swing.GroupLayout(jpCli_foto);
        jpCli_foto.setLayout(jpCli_fotoLayout);
        jpCli_fotoLayout.setHorizontalGroup(
            jpCli_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCli_fotoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jpCli_fotoLayout.setVerticalGroup(
            jpCli_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_fotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtCli_cod.setEditable(false);
        jtCli_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCli_codKeyTyped(evt);
            }
        });

        jtCli_nome.setEditable(false);

        jtCli_bi.setEditable(false);
        jtCli_bi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCli_biActionPerformed(evt);
            }
        });
        jtCli_bi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCli_biKeyTyped(evt);
            }
        });

        jtCli_telm.setEditable(false);
        jtCli_telm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCli_telmActionPerformed(evt);
            }
        });
        jtCli_telm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCli_telmKeyTyped(evt);
            }
        });

        jLabel36.setText("Sexo");

        jLabel37.setText("Estado");

        jtCli_cp.setEditable(false);

        jtCli_morada.setEditable(false);
        jtCli_morada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCli_moradaActionPerformed(evt);
            }
        });

        jtCli_email.setEditable(false);

        jbCli_procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Upload.png"))); // NOI18N
        jbCli_procurar.setText("Procurar");
        jbCli_procurar.setEnabled(false);
        jbCli_procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCli_procurarActionPerformed(evt);
            }
        });

        jbCli_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/clean.png"))); // NOI18N
        jbCli_limpar.setText("Limpar");
        jbCli_limpar.setEnabled(false);
        jbCli_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCli_limparActionPerformed(evt);
            }
        });

        jb_tirar_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/camera.png"))); // NOI18N
        jb_tirar_foto.setText("Tirar");
        jb_tirar_foto.setEnabled(false);
        jb_tirar_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_tirar_fotoActionPerformed(evt);
            }
        });

        jcCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcClienteItemStateChanged(evt);
            }
        });
        jcCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcClienteMouseClicked(evt);
            }
        });
        jcCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtCli_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtCli_nome)
                    .addComponent(jtCli_morada)
                    .addComponent(jtCli_email)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcCli_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtCli_telm, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(jtCli_cp)
                                    .addComponent(jtCli_bi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcCli_sexo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdCli_dtNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(jdCli_dtReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jpCli_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_tirar_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCli_procurar)
                    .addComponent(jbCli_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jbCli_procurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_tirar_foto)
                        .addGap(11, 11, 11)
                        .addComponent(jbCli_limpar))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(jtCli_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel27)
                                            .addComponent(jtCli_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel28)
                                                    .addComponent(jtCli_bi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel34)
                                                    .addComponent(jtCli_telm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jdCli_dtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jcCli_sexo)
                                            .addComponent(jLabel36))))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel35)
                                        .addComponent(jtCli_cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30))
                                    .addComponent(jdCli_dtReg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(jtCli_morada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(jtCli_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jpCli_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jcCli_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpCli_dadoLayout = new javax.swing.GroupLayout(jpCli_dado);
        jpCli_dado.setLayout(jpCli_dadoLayout);
        jpCli_dadoLayout.setHorizontalGroup(
            jpCli_dadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_dadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCli_dadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpCli_dadoLayout.setVerticalGroup(
            jpCli_dadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCli_dadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jScrollPane3.setViewportView(jpCli_dado);

        javax.swing.GroupLayout jpCli_dadosLayout = new javax.swing.GroupLayout(jpCli_dados);
        jpCli_dados.setLayout(jpCli_dadosLayout);
        jpCli_dadosLayout.setHorizontalGroup(
            jpCli_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_dadosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpCli_dadosLayout.setVerticalGroup(
            jpCli_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_dadosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabCli.addTab("Dados Cliente", jpCli_dados);

        jpCli_Pagamento.setEnabled(false);

        jLabel2.setText("Código");

        jLabel3.setText("Cliente");

        jLabel4.setText("Descrição");

        jLabel5.setText("Valor");

        jLabel7.setText("Tipo Pagamento");

        jLabel8.setText("Observação");

        jtPag_obs.setColumns(20);
        jtPag_obs.setRows(5);
        jScrollPane2.setViewportView(jtPag_obs);

        jtPag_valor.setEditable(false);
        jtPag_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPag_valorKeyTyped(evt);
            }
        });

        jcbPag_tipoPag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "DINHEIRO", "CHEQUE", "VINTi4" }));

        jcbPag_desc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Matricula", "Mensalidade", "Dia", "Semanal", "Consumo", "", "" }));
        jcbPag_desc.setSelectedIndex(1);
        jcbPag_desc.setEnabled(false);

        jtPag_cod.setEditable(false);

        jtClientePagamento.setEnabled(false);

        jLabel9.setText("Mês");

        jcbPag_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Septembro", "Outubro", "Novembro", "Decembro" }));

        javax.swing.GroupLayout jpCli_PagamentoLayout = new javax.swing.GroupLayout(jpCli_Pagamento);
        jpCli_Pagamento.setLayout(jpCli_PagamentoLayout);
        jpCli_PagamentoLayout.setHorizontalGroup(
            jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_PagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCli_PagamentoLayout.createSequentialGroup()
                        .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9))
                        .addGap(21, 21, 21)
                        .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbPag_mes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbPag_tipoPag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbPag_desc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpCli_PagamentoLayout.createSequentialGroup()
                                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtPag_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtPag_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 495, Short.MAX_VALUE))
                            .addComponent(jtClientePagamento))))
                .addContainerGap())
        );
        jpCli_PagamentoLayout.setVerticalGroup(
            jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCli_PagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtPag_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtClientePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbPag_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtPag_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbPag_tipoPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jpCli_PagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbPag_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabCli.addTab("Efetuar Pagamento", jpCli_Pagamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabCli))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabCli)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       
        jTabCli.setEnabledAt(2, false);
        jTabCli.setEnabledAt(1, false);
        controllerCliente.preencherJTabelaCliente();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        ativarDesativaBotoes(true);
        jbNovo.setEnabled(false);
        ativarDesativarClienteCampos(true);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (idCliente != 0) {
            int sair = JOptionPane.showConfirmDialog(null, "Cancelando o pagamento. Deseja prosseguir?", "Cancelar Pagamento", JOptionPane.YES_NO_OPTION);
            if (sair == 0) {
                DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
                model.setRowCount(0);
                janela = 0;
                dispose();
            }
        } else {
            DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
            model.setRowCount(0);
            janela = 0;
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        jTabCli.setEnabledAt(1, true);
        jTabCli.setSelectedComponent(jpCli_dados);
        ativarDesativaBotoes(true);
        ativarDesativarClienteCampos(true);
        limparClienteCampos();
        jbNovo.setEnabled(false);
        controllerCliente.selectClienteToComo(jcCliente);
        flag = 0;
        jcCli_status.setSelectedIndex(1);
        controllerCliente.selectModalidade("SELECT * FROM modalidade order by idModalidade");
        DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (jpCli_dados.isShowing()) {
            if (!jtCli_cod.getText().equals("")) {
                if (localFoto == null) {
                    controllerCliente.manutencaoPessoa("alterarSemFoto", Principal.id, jcCli_sexo.getSelectedIndex(),
                            jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
                            jtCli_locTrab.getText(), jtCli_telTrab.getText(),
                            jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
                            new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(), jtCli_email.getText(),
                            jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
                            jtCli_cod.getText());
                    limparClienteCampos();
                    ativarDesativaBotoes(false);
                    ativarDesativarClienteCampos(false);
                    destivaAtivaBotao2(false);
                } else {
                    controllerCliente.manutencaoPessoa("alterar", Principal.id, jcCli_sexo.getSelectedIndex(),
                            jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
                            jtCli_locTrab.getText(), jtCli_telTrab.getText(),
                            jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
                            new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(), jtCli_email.getText(),
                            jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
                            jtCli_cod.getText());
                    limparClienteCampos();
                    ativarDesativaBotoes(false);
                    ativarDesativarClienteCampos(false);
                    destivaAtivaBotao2(false);
                }
            } else {
                if (validarCampos()) {
                    try { 
                        codigoBarra = geraCodigoBarra();
                         
                        try (ByteArrayOutputStream bytesImg = new ByteArrayOutputStream()) {
                            BufferedImage imagemBuffer = ImageIO.read(new File(localFoto));
                            ImageIO.write((BufferedImage) imagemBuffer, "jpg", bytesImg);
                            bytesImg.flush();
                            bytes = bytesImg.toByteArray();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(this, "Erro" + ex.getMessage());
                        }            
                        System.out.println("" + codigoBarra);
                        System.out.println("bytes foto:: "+Arrays.toString(bytes));
                        controllerCliente.manutencaoPessoa("inserir", Principal.id, jcCli_sexo.getSelectedIndex(),
                                jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
                                jtCli_locTrab.getText(), jtCli_telTrab.getText(),
                                jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
                                new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(),
                                jtCli_email.getText(),
                                jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
                                jtCli_cod.getText());
                        
                        ultimoRegistro = controllerCliente.getUltimoRegistro().getString("idPessoa");
                        idCliente = Integer.parseInt(ultimoRegistro);

                        if (controllerMatricula.manutencaoMatricula("matricular", idMatricula, idCliente, new java.sql.Date(jdCli_dtReg.getDate().getTime()), Principal.id, 0.0)) {
                            ultimoMatricula = controllerMatricula.getUltimoRegistroMatricula().getString("idMatricula");
                            idMatricula = Integer.parseInt(ultimoMatricula);

                            int tag = 0;
                            for (int i = 0; i < arrayModalidade.size(); i++) {
                                if (controllerMatriculaModalidade.manutencaoMatriculaModalidade("matriculaModalidade", idMatricula, arrayModalidade.get(i).getIdModalidade(), arrayModalidade.get(i).getValor())) {
                                    tag = 1;
                                }
                            }
                            if (tag == 1) {
                                matricular();
                            }
                        }

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Erro ao pegar ultimo cliente" + ex.getMessage());
                    }

                    //                    matricular();
////                    jtPag_valor.setText("" + controllerCliente.getTotal());
////                    jtClientePagamento.setText("" + jtCli_nome.getText());
////
////                    ativarDesativarClienteCampos(false);
////                    jTabCli.setEnabledAt(2, true);
////                    jTabCli.setSelectedIndex(2);
////                    controllerMatricula.manutencaoMatricula("alterarMatricula", idMatricula, idCliente, null, idCliente, Double.parseDouble(jtCli_totalApagar.getText()));
////                    // idCliente = 0;
////                    limparClienteCampos();
                }
            }
//
        } else if (jpCli_Pagamento.isShowing()) {
            if (jcbPag_tipoPag.getSelectedIndex() != 0) {
                Date dataVencimento = calculaDataVencimento();
                codPagamento = codPagamento();
                //JOptionPane.showMessageDialog(null, "idCliente: " + idCliente + " idMatricula: " + idMatricula);
                if (controllerPagamento.manutencaoPagamento("inserir", jtPag_cod.getText(), idCliente, idMatricula, 
                        Principal.id, jcbPag_tipoPag.getSelectedItem().toString(), 
                        new java.sql.Date(jdCli_dtReg.getDate().getTime()), 
                        new java.sql.Date(dataVencimento.getTime()), jtPag_obs.getText(), 
                        jcbPag_desc.getSelectedItem().toString(), codPagamento, true,jcbPag_mes.getSelectedIndex())) {
                    emitirRecibo();
                    emitirCartao();
                    jTabCli.setEnabledAt(2, false);
                    jTabCli.setSelectedIndex(0);
                    ativarDesativaBotoes(false);
                    destivaAtivaBotao2(false);
                    controllerCliente.alterarEstado(idCliente);
                    controllerCliente.preencherJTabelaCliente();
                    idCliente = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um metodo de pagamento");
            }
//
        }
//

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limparClienteCampos();
        ativarDesativaBotoes(false);
        ativarDesativarClienteCampos(false);
        destivaAtivaBotao2(false);
        jTabCli.setEnabledAt(1, false);
        jTabCli.setSelectedComponent(jpCli_listar);
        controllerCliente.setTotal(0.0);
        jtCli_totalApagar.setText(String.valueOf(0.0));
        DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
        model.setRowCount(0);

    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApagarActionPerformed
        controllerCliente.manutencaoPessoa("excluir", Principal.id, jcCli_sexo.getSelectedIndex(),
                jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
                jtCli_locTrab.getText(), jtCli_telTrab.getText(),
                jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
                new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(), jtCli_email.getText(),
                jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
                jtCli_cod.getText());
        limparClienteCampos();
        ativarDesativaBotoes(false);
        ativarDesativarClienteCampos(false);
        destivaAtivaBotao2(false);
    }//GEN-LAST:event_jbApagarActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        if (jpCli_dados.isVisible()) {
            String nomeCliente = "Imprimir a detallhes e historico do " + jtCli_nome.getText() + " ?";
            int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeCliente, "Confirmacão Impressao ", JOptionPane.YES_OPTION);
            if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                InputStream caminho = getClass().getResourceAsStream("/relatorios/RClienteHistorico.jrxml");
                con.EjectuarReporteFiltro(Integer.parseInt(jtCli_cod.getText()), "pIdCliente", caminho);
            }
        } else {
            String nomeCliente = "Imprimir a lista de todos os clientes do ginásio ";
            int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeCliente, "Confirmacão Inpressao ", JOptionPane.YES_OPTION);
            if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                InputStream caminho = getClass().getResourceAsStream("/relatorios/RClientes.jrxml");
                con.EjecutarReporteStream(caminho);
            }
        }
    }//GEN-LAST:event_jbImprimirActionPerformed

    public void jTb() {
        ativarDesativaBotoes(true);
        ativarDesativarClienteCampos(true);
        jbNovo.setEnabled(false);
    }

    private void jTabCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabCliMouseClicked
        if (jTabCli.getSelectedIndex() == 1) {
            jTb();
        }
    }//GEN-LAST:event_jTabCliMouseClicked

    private void jb_tirar_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_tirar_fotoActionPerformed
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new VTirar_Foto(null, true).setVisible(true);
    }//GEN-LAST:event_jb_tirar_fotoActionPerformed

    private void jbCli_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCli_limparActionPerformed
        jlFoto.setIcon(new ImageIcon(getClass().getResource("/imagem/fotoCliente.png")));
        jbCli_limpar.setEnabled(false);
    }//GEN-LAST:event_jbCli_limparActionPerformed

    private void jbCli_procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCli_procurarActionPerformed
        carregaFoto();
    }//GEN-LAST:event_jbCli_procurarActionPerformed

    private void jtCli_moradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCli_moradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCli_moradaActionPerformed

    private void jtCli_telmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCli_telmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCli_telmActionPerformed

    private void jtCli_biActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCli_biActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCli_biActionPerformed

    private void jlFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlFotoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlFotoMouseClicked

    private void jtaCli_obsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtaCli_obsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtaCli_obsMouseClicked

    private void jtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtRemoverActionPerformed
        DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
        if (jtModalidadeCliente.getSelectedRow() == -1) {
            if (jtModalidadeCliente.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Tabela esta vazia");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma modalidade na sua tabela");
            }
        } else {

            String precoTabela = (String) model.getValueAt(jtModalidadeCliente.getSelectedRow(), 2);

            double preco = Double.parseDouble(precoTabela);

            total = controllerCliente.getTotal();
            total = total - preco;
            controllerCliente.setTotal(total);
            jtCli_totalApagar.setText(String.valueOf(total));

            String cod = "" + model.getValueAt(jtModalidadeCliente.getSelectedRow(), 0);

            int id = Integer.parseInt(cod);

            for (int i = 0; i < arrayModalidade.size(); i++) {
                if (arrayModalidade.get(i).getIdModalidade() == id) {
                    arrayModalidade.remove(i);
                    break;
                }
            }

            String clauseWhere = "";
            if (!arrayModalidade.isEmpty()) {
                for (int i = 0; i < arrayModalidade.size(); i++) {
                    if (arrayModalidade.size() == (i + 1)) {
                        clauseWhere += " idModalidade <> " + arrayModalidade.get(i).getIdModalidade();
                    } else {
                        clauseWhere += "idModalidade <> " + arrayModalidade.get(i).getIdModalidade() + " AND ";
                    }
                }
                sql = "select * from modalidade WHERE " + clauseWhere;
                System.out.println("" + sql);
                controllerCliente.selectModalidade(sql);
                model.removeRow(jtModalidadeCliente.getSelectedRow());
            } else {
                controllerCliente.selectModalidade("SELECT * FROM modalidade order by idModalidade");
                model.removeRow(jtModalidadeCliente.getSelectedRow());
            }
        }

    }//GEN-LAST:event_jtRemoverActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
//        if (localFoto != null) {
//            try (ByteArrayOutputStream bytesImg = new ByteArrayOutputStream()) {
//                BufferedImage imagemBuffer = ImageIO.read(new File(localFoto));
//                ImageIO.write((BufferedImage) imagemBuffer, "jpg", bytesImg);
//                bytesImg.flush();
//                bytes = bytesImg.toByteArray();
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(this, "Erro" + ex.getMessage());
//            }
//        }
//        if (validarCampos()) {
//            if (localFoto == null && jtCli_cod.getText().equals("")) {
//                JOptionPane.showMessageDialog(this, "Obrigatório carregar foto", "Carregar foto", JOptionPane.ERROR_MESSAGE);
//            } else {
        if (jcModalidade.getSelectedIndex() != 0) {
//                    if (idCliente == 0) {
//                        try {
//                            codigoBarra = geraCodigoBarra();
//                            /* System.out.println(Principal.id + " " + jtCli_cod.getText() + " " + jtCli_nome.getText() + " "
//                             + jcCli_sexo.getSelectedIndex() + " " + jtCli_bi.getText() + " " + jtCli_email.getText() + " "
//                             + jtCli_morada.getText() + " " + jtCli_cp.getText() + " " + jtCli_telm.getText() + " " + codigoBarra + " "
//                             + jcCli_status.getSelectedIndex() + " " + jtCli_prof.getText() + " " + jtCli_edu.getText() + " "
//                             + jtCli_locTrab.getText() + " " + jtCli_telTrab.getText() + " "
//                             + jtaCli_obs.getText() + " " + bytes + " " + new java.sql.Date(jdCli_dtNasc.getDate().getTime()) + " "
//                             + new java.sql.Date(jdCli_dtReg.getDate().getTime()) + " " + 0);
//                             */
//                            controllerCliente.manutencaoPessoa("inserir", Principal.id, jcCli_sexo.getSelectedIndex(),
//                                    jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
//                                    jtCli_locTrab.getText(), jtCli_telTrab.getText(),
//                                    jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
//                                    new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(), jtCli_email.getText(),
//                                    jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
//                                    jtCli_cod.getText());
//
//                            ultimoRegistro = controllerCliente.getUltimoRegistro().getString("idPessoa");
//                            idCliente = Integer.parseInt(ultimoRegistro);
//
//                            //JOptionPane.showMessageDialog(null, idModal);
//                            if (controllerMatricula.manutencaoMatricula("matricular", idMatricula, idCliente, new java.sql.Date(jdCli_dtReg.getDate().getTime()), Principal.id, 0.0)) {
//                                ultimoMatricula = controllerMatricula.getUltimoRegistroMatricula().getString("idMatricula");
//                                idMatricula = Integer.parseInt(ultimoMatricula);
//                                //JOptionPane.showMessageDialog(null,"Matricula: "+idMatricula);
//
            controllerCliente.pesquisaModalidade();
            idModal = controllerCliente.getIdModal();
            valorModal = controllerCliente.getValorModal();
            arrayModalidade.add(new Modalidade(idModal, valorModal, null));
            int tamArray = arrayModalidade.size();
            String clauseWhere = "idModalidade <> " + arrayModalidade.get(0).getIdModalidade();
            for (int i = 1; i < tamArray; i++) {
                clauseWhere += " AND idModalidade <> " + arrayModalidade.get(i).getIdModalidade();

            }
            sql = "select * from modalidade WHERE " + clauseWhere;
            System.out.println("" + sql);
            controllerCliente.selectModalidade(sql);
//                                }
//                            }
//                        } catch (SQLException ex) {
//                            JOptionPane.showMessageDialog(this, "Erro selecionar ultimo registro clinete" + ex.getMessage());
//                        }
//
//                    } else {
//                        if (jtCli_cod.getText().equals("")) {
//                            controllerCliente.pesquisaModalidade();
//                            idModal = controllerCliente.getIdModal();
//                            valorModal = controllerCliente.getValorModal();
//                            if (controllerMatriculaModalidade.manutencaoMatriculaModalidade("matriculaModalidade", idMatricula, idModal, valorModal)) {
//                                sql = "select * from modalidade WHERE idModalidade NOT IN (select idModalidade from matriculaModalidade WHERE idMatricula = " + idMatricula + ")";
//                                controllerCliente.selectModalidade(sql);
//                            }
//                        } else { //Adicionar modalidade para um cliente selecionado no comobox
//                            if (idMatricula == 0) {
//                                if (controllerMatricula.manutencaoMatricula("matricular", idMatricula, idCliente, new java.sql.Date(jdCli_dtReg.getDate().getTime()), Principal.id, 0.0)) {
//                                    try {
//                                        ultimoMatricula = controllerMatricula.getUltimoRegistroMatricula().getString("idMatricula");
//                                    } catch (SQLException ex) {
//                                        JOptionPane.showMessageDialog(null, "Erro ao selcionar codigo dessa matricula: " + ex.getMessage());
//                                    }
//                                    idMatricula = Integer.parseInt(ultimoMatricula);
//                                    //JOptionPane.showMessageDialog(null,"Matricula: "+idMatricula);
//
//                                    controllerCliente.pesquisaModalidade();
//                                    idModal = controllerCliente.getIdModal();
//                                    valorModal = controllerCliente.getValorModal();
//                                    if (controllerMatriculaModalidade.manutencaoMatriculaModalidade("matriculaModalidade", idMatricula, idModal, valorModal)) {
//                                        sql = "select * from modalidade WHERE idModalidade NOT IN (select idModalidade from matriculaModalidade WHERE idMatricula = " + idMatricula + ")";
//                                        controllerCliente.selectModalidade(sql);
//                                    }
//                                }
//                            } else { //Adicionar mais modalidade
//                                controllerCliente.pesquisaModalidade();
//                                idModal = controllerCliente.getIdModal();
//                                valorModal = controllerCliente.getValorModal();
//                                if (controllerMatriculaModalidade.manutencaoMatriculaModalidade("matriculaModalidade", idMatricula, idModal, valorModal)) {
//                                    sql = "select * from modalidade WHERE idModalidade NOT IN (select idModalidade from matriculaModalidade WHERE idMatricula = " + idMatricula + ")";
//                                    controllerCliente.selectModalidade(sql);
//                                }
//                            }
//                        }
//                    }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma modalidade");
        }
//            }
//
//        }

    }//GEN-LAST:event_jbAddActionPerformed

    private void jTabClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabClienteMouseClicked
        DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
        model.setRowCount(0);

        if (evt.getClickCount() == 2) {
            try {
                limparClienteCampos();
                jTabCli.setEnabledAt(1, true);
                jTabCli.setSelectedIndex(1);
                ativarDesativaBotoes(false);
                ativarDesativarClienteCampos(false);
                controllerCliente.manutencaoPesquisa();
                jbCancelar.setEnabled(true);

            } catch (IOException ex) {
                Logger.getLogger(VCliente.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTabClienteMouseClicked

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        controllerCliente.pesquisaCliente(jtPesquisar.getText(), "Nome");
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jcClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcClienteActionPerformed

    }//GEN-LAST:event_jcClienteActionPerformed

    private void jcClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcClienteItemStateChanged

    }//GEN-LAST:event_jcClienteItemStateChanged

    private void jcClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcClienteMouseClicked
        if (jcCliente.getSelectedIndex() == 0) {
        } else {
            idCliente = controllerCliente.seletPessoaPorNomes(jcCliente);
            if (idCliente != 0) {
                try {
                    controllerCliente.manutencaoPesquisaCombobox(String.valueOf(idCliente));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao carregar dados desse cliente: " + ex.getMessage());
                }
            }
            //JOptionPane.showMessageDialog(this, "Valeu " + jcCliente.getSelectedItem().toString() +" "+idCliente);
        }
    }//GEN-LAST:event_jcClienteMouseClicked

    public void checkTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }
    private void jtCli_biKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCli_biKeyTyped
        checkTyped(evt);
    }//GEN-LAST:event_jtCli_biKeyTyped

    private void jtCli_telmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCli_telmKeyTyped
        checkTyped(evt);
    }//GEN-LAST:event_jtCli_telmKeyTyped

    private void jtCli_codKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCli_codKeyTyped
        checkTyped(evt);
    }//GEN-LAST:event_jtCli_codKeyTyped

    private void jtCli_telTrabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCli_telTrabKeyTyped
        checkTyped(evt);
    }//GEN-LAST:event_jtCli_telTrabKeyTyped

    private void jtPag_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPag_valorKeyTyped
        checkTyped(evt);
    }//GEN-LAST:event_jtPag_valorKeyTyped
    public String geraCodigoBarra() {
        int cod;
        try {
            ultimoRegistro = controllerCliente.getUltimoRegistro().getString("idPessoa");
            idCliente = Integer.parseInt(ultimoRegistro);
            cod = idCliente + 1;
            codigoBarra = getData(cod);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error: Ao gerar codBarra: " + ex.getMessage());
            codigoBarra = getData(1);
        }
        return codigoBarra;
    }

    public String getData(int cod) {
        int ano, dia, mes;
        Calendar calendario = Calendar.getInstance();
        ano = calendario.get(Calendar.YEAR);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        mes = mes + 1;
        SimpleDateFormat formataData = new SimpleDateFormat("ddMMyyyy");
        String data = formataData.format(jdCli_dtNasc.getDate());
        codigoBarra = cod + "" + dia + "" + mes + "" + ano + "" + data;
        return codigoBarra;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTabbedPane jTabCli;
    public static javax.swing.JTable jTabCliente;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbApagar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCli_limpar;
    private javax.swing.JButton jbCli_procurar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jb_tirar_foto;
    public static javax.swing.JComboBox jcCli_sexo;
    public static javax.swing.JComboBox jcCli_status;
    public static javax.swing.JComboBox jcCliente;
    public static javax.swing.JComboBox jcModalidade;
    private javax.swing.JComboBox jcbPag_desc;
    private javax.swing.JComboBox jcbPag_mes;
    private javax.swing.JComboBox jcbPag_tipoPag;
    public static com.toedter.calendar.JDateChooser jdCli_dtNasc;
    public static com.toedter.calendar.JDateChooser jdCli_dtReg;
    public static javax.swing.JLabel jlFoto;
    private javax.swing.JPanel jpCli_Pagamento;
    private javax.swing.JPanel jpCli_dado;
    private javax.swing.JPanel jpCli_dados;
    private javax.swing.JPanel jpCli_foto;
    private javax.swing.JPanel jpCli_listar;
    public static javax.swing.JTextField jtCli_bi;
    public static javax.swing.JTextField jtCli_cod;
    public static javax.swing.JTextField jtCli_cp;
    public static javax.swing.JTextField jtCli_edu;
    public static javax.swing.JTextField jtCli_email;
    public static javax.swing.JTextField jtCli_locTrab;
    public static javax.swing.JTextField jtCli_morada;
    public static javax.swing.JTextField jtCli_nome;
    public static javax.swing.JTextField jtCli_prof;
    public static javax.swing.JTextField jtCli_telTrab;
    public static javax.swing.JTextField jtCli_telm;
    public static javax.swing.JTextField jtCli_totalApagar;
    private javax.swing.JTextField jtClientePagamento;
    public static javax.swing.JTable jtModalidadeCliente;
    private javax.swing.JTextField jtPag_cod;
    private javax.swing.JTextArea jtPag_obs;
    public static javax.swing.JTextField jtPag_valor;
    public static javax.swing.JTextField jtPesquisar;
    private javax.swing.JButton jtRemover;
    public static javax.swing.JTextArea jtaCli_obs;
    // End of variables declaration//GEN-END:variables
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void limparClienteCampos() {
        jtCli_totalApagar.setText("");
        jtCli_cod.setText("");
        jtCli_bi.setText("");
        jtCli_cp.setText("");
        jtCli_nome.setText("");
        jtCli_morada.setText("");
        jtCli_telm.setText("");
        jtCli_edu.setText("");
        jtCli_email.setText("");
        jtCli_locTrab.setText("");
        jtCli_telTrab.setText("");
        jtCli_prof.setText("");
        jtaCli_obs.setText("");
        jdCli_dtNasc.setDate(null);
        jcCli_sexo.setSelectedIndex(0);
        jcCli_status.setSelectedIndex(0);
        jbCli_limparActionPerformed(null);
        jcbPag_tipoPag.setSelectedIndex(0);
        jcbPag_mes.setSelectedIndex(0);
        jtPag_obs.setText("");
        jtPag_valor.setText("");

    }

    public void destivaAtivaBotao2(boolean habilitar) {
        jbNovo.setEnabled(!habilitar);
        jbEditar.setEnabled(habilitar);
        jbApagar.setEnabled(habilitar);
        jbCancelar.setEnabled(habilitar);
    }

    public void ativarDesativarClienteCampos(boolean habilitar) {
        jtCli_bi.setEditable(habilitar);
        jtCli_cp.setEditable(habilitar);
        jtCli_nome.setEditable(habilitar);
        jtCli_morada.setEditable(habilitar);
        jtCli_telm.setEditable(habilitar);
        jtCli_edu.setEditable(habilitar);
        jtCli_email.setEditable(habilitar);
        jtCli_locTrab.setEditable(habilitar);
        jtCli_telTrab.setEditable(habilitar);
        jtCli_prof.setEditable(habilitar);
        jtaCli_obs.setEditable(habilitar);
        jcCli_sexo.setEnabled(habilitar);
        jcCli_status.setEnabled(habilitar);
        jdCli_dtNasc.setEnabled(habilitar);
        jbCli_procurar.setEnabled(habilitar);
        jb_tirar_foto.setEnabled(habilitar);
        jbAdd.setEnabled(habilitar);
        jtRemover.setEnabled(habilitar);
        jcModalidade.setEnabled(habilitar);
        jtModalidadeCliente.setEnabled(habilitar);
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
        if (jtCli_nome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nome é obrigatório !");
            jtCli_nome.requestFocus();
            return false;
        }
        if (jtCli_telm.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Telefone é obrigatório !");
            jtCli_telm.requestFocus();
            return false;
        }
        if (jtCli_morada.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Morada é obrigatório !");
            jtCli_morada.requestFocus();
            return false;
        }
        if (jdCli_dtNasc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Data nascimento é obrigatório !");
            jdCli_dtNasc.requestFocus();
            return false;
        }
        if (jcCli_sexo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Sexo é obrigatório !");
            jcCli_sexo.requestFocus();
            return false;
        }
        if ((jtCli_email.getText() != null) && (jtCli_email.getText().trim().length() != 0)) {
            String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
            Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(jtCli_email.getText());
            boolean valid = matcher.matches();
            if (!valid) {
                JOptionPane.showMessageDialog(this, "Formato email invalido");
                return false;
            }
        }
        if (localFoto == null) {            
            JOptionPane.showMessageDialog(this,"Não carregaste nenhuma foto",
                    "Fotografia do Cliente", 
                     JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (jtModalidadeCliente.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma modalidade");
            return false;
        }
        return true;

    }

    public void carregaFoto() {
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar foto");

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
                Logger.getLogger(VCliente.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

            BufferedImage aux = new BufferedImage(130, 150, imagem.getType());//cria um buffer auxiliar com o tamanho desejado
            Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao
            AffineTransform at = AffineTransform.getScaleInstance((double) 130 / imagem.getWidth(), (double) 150 / imagem.getHeight());//cria a transformacao
            g.drawRenderedImage(imagem, at);//pinta e transforma a imagem real no auxiliar
            jlFoto.setIcon(new ImageIcon(aux));//seta no jlabel

//            LB_Foto.setIcon(new ImageIcon(fileChooser.getSelectedFile().getPath()));
            localFoto = fileChooser.getSelectedFile().getPath();
           // JOptionPane.showMessageDialog(this, localFoto);
            System.out.println("caminho foto"+localFoto);
            //jbCli_limpar.setEnabled(true);
        }
    }

    public void convertImage(File arquivo, String image) {
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(arquivo); //carrega a imagem real num buffer
            // JOptionPane.showMessageDialog(this, arquivo);
        } catch (IOException ex) {
            Logger.getLogger(VCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        BufferedImage aux = new BufferedImage(130, 150, imagem.getType());//cria um buffer auxiliar com o tamanho desejado
        Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao
        AffineTransform at = AffineTransform.getScaleInstance((double) 130 / imagem.getWidth(), (double) 150 / imagem.getHeight());//cria a transformacao
        g.drawRenderedImage(imagem, at);//pinta e transforma a imagem real no auxiliar
        jlFoto.setIcon(new ImageIcon(aux));//seta no jlabel

        localFoto = image;
        JOptionPane.showMessageDialog(this, image);
    }

    public void guardar() {

        if (localFoto != null) {
            try (ByteArrayOutputStream bytesImg = new ByteArrayOutputStream()) {
                BufferedImage imagemBuffer = ImageIO.read(new File(localFoto));
                ImageIO.write((BufferedImage) imagemBuffer, "jpg", bytesImg);
                bytesImg.flush();
                bytes = bytesImg.toByteArray();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro" + ex.getMessage());
            }
        }
        if (jtCli_cod.getText().equals("")) {
            if (validarCampos()) {
                if (localFoto == null) {
                    JOptionPane.showMessageDialog(this, "Obrigatório carregar foto", "Carregar foto", JOptionPane.ERROR_MESSAGE);
                } else {
                    controllerCliente.manutencaoPessoa("inserir", Principal.id, jcCli_sexo.getSelectedIndex(),
                            jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
                            jtCli_locTrab.getText(), jtCli_telTrab.getText(),
                            jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
                            new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(), jtCli_email.getText(),
                            jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
                            jtCli_cod.getText());
                    limparClienteCampos();
                    ativarDesativaBotoes(false);
                    ativarDesativarClienteCampos(false);
                    destivaAtivaBotao2(false);
                }

            }
        } else {
            if (localFoto == null) {
                controllerCliente.manutencaoPessoa("alterarSemFoto", Principal.id, jcCli_sexo.getSelectedIndex(),
                        jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
                        jtCli_locTrab.getText(), jtCli_telTrab.getText(),
                        jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
                        new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(), jtCli_email.getText(),
                        jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
                        jtCli_cod.getText());
                limparClienteCampos();
                ativarDesativaBotoes(false);
                ativarDesativarClienteCampos(false);
                destivaAtivaBotao2(false);
            } else {
                controllerCliente.manutencaoPessoa("alterar", Principal.id, jcCli_sexo.getSelectedIndex(),
                        jcCli_status.getSelectedIndex(), jtCli_edu.getText(), jtCli_prof.getText(),
                        jtCli_locTrab.getText(), jtCli_telTrab.getText(),
                        jtaCli_obs.getText(), bytes, new java.sql.Date(jdCli_dtNasc.getDate().getTime()),
                        new java.sql.Date(jdCli_dtReg.getDate().getTime()), 0, jtCli_nome.getText(), jtCli_morada.getText(), jtCli_email.getText(),
                        jtCli_telm.getText(), codigoBarra, jtCli_bi.getText(), jtCli_cp.getText(),
                        jtCli_cod.getText());
                limparClienteCampos();
                ativarDesativaBotoes(false);
                ativarDesativarClienteCampos(false);
                destivaAtivaBotao2(false);
            }
        }
    }

    public String codPagamento() {
        int ano;
        Calendar dtAnoPagamento = Calendar.getInstance();
        ano = dtAnoPagamento.get(Calendar.YEAR);
        try {
            ultimoCodPagamento = controllerPagamento.getUltimoRegistro().getString("idPagamento");
            int idPagamento = Integer.parseInt(ultimoCodPagamento);
            idPagamento = idPagamento + 1;
            codPagamento = idPagamento + "/" + ano;
        } catch (SQLException ex) {
            codPagamento = 1 + "/" + ano;
            //JOptionPane.showMessageDialog(null, "Error: no gerar codigo pagamento " + ex.getMessage());
        }
        return codPagamento;
    }

    public void emitirRecibo() {
        try {
            controllerRecibo = new ControllerRecibo();
            ultimoRegistroPagamento = controllerPagamento.getUltimoRegistro().getString("codPagamento");
            String idPag = (ultimoRegistroPagamento);
            String text = "Imprimir este recibo de pagamento ";
            int opcaoEscolhida = JOptionPane.showConfirmDialog(null, text, "Confirmacão Inpressao ", JOptionPane.YES_OPTION);

            if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                InputStream caminho = getClass().getResourceAsStream("/relatorios/RRecibo.jrxml");
                con.EjectuarReporteFiltroString(idPag, "idPag", caminho);
                controllerRecibo.manutencaoRecibo("inserir", "Recibo", idPag, "Recibo de Pagamento da mensalidade", "Emitida", true, idCliente, Principal.id);
            } else {
                controllerRecibo.manutencaoRecibo("inserir", "Recibo", idPag, "Recibo de Pagamento da mensalidade", "Pendente", false, idCliente, Principal.id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: no imprimir recibo: " + ex.getMessage());
        }
    }

    public void emitirCartao() {
        try {
            int idPessoa = (idCliente);
            String nomeCliente = "Imprimir cartao do cliente " + jtClientePagamento.getText() + " ?";
            int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeCliente, "Confirmacão Inpressao ", JOptionPane.YES_OPTION);

            if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                dispose();
                janela = 0;
                InputStream caminho = getClass().getResourceAsStream("/relatorios/RCartao.jrxml");
                con.EjectuarReporteFiltro(idPessoa, "pIdCliente", caminho);
            }
        } catch (Exception e) {

        }
    }

    public boolean bissexto(int ano) {
        int aa = 0;
        if ((aa % 400 == 0) || (aa % 4 == 0) && (aa % 100) != 0) {
            return (true);
        } else {
            return (false);
        }
    }

    public Date calculaDataVencimento() {
        boolean bool;
        Calendar dtVencimento = Calendar.getInstance();
        if ((Calendar.MONTH == Calendar.JANUARY) || (Calendar.MONTH == Calendar.MARCH) || (Calendar.MONTH == Calendar.MAY) || (Calendar.MONTH == Calendar.JULY) || (Calendar.MONTH == Calendar.AUGUST) || (Calendar.MONTH == Calendar.OCTOBER) || (Calendar.MONTH == Calendar.DECEMBER)) {
            dtVencimento.add(Calendar.DAY_OF_YEAR, 31);
        } else if ((Calendar.MONTH == Calendar.APRIL) || (Calendar.MONTH == Calendar.JUNE) || (Calendar.MONTH == Calendar.SEPTEMBER) || (Calendar.MONTH == Calendar.NOVEMBER)) {
            dtVencimento.add(Calendar.DAY_OF_YEAR, 30);
        } else if (Calendar.MONTH == Calendar.FEBRUARY) {
            int ano = dtVencimento.get(Calendar.YEAR);
            bool = bissexto(ano);
            if (bool == true) {
                dtVencimento.add(Calendar.DAY_OF_YEAR, 29);
            } else {
                dtVencimento.add(Calendar.DAY_OF_YEAR, 28);
            }
        }
        Date vencimento = dtVencimento.getTime();
        return vencimento;
    }

    public void matricular() {
        jtPag_valor.setText("" + controllerCliente.getTotal());
        jtClientePagamento.setText("" + jtCli_nome.getText());

        ativarDesativarClienteCampos(false);
        jTabCli.setEnabledAt(2, true);
        jTabCli.setSelectedIndex(2);
        controllerMatricula.manutencaoMatricula("alterarMatricula", idMatricula, idCliente, null, idCliente, Double.parseDouble(jtCli_totalApagar.getText()));
        limparClienteCampos();

    }
}
