/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Matriculamodalidade;
import model.Modalidade;
import model.MPessoa;
import persistence.DAOCliente;
import persistence.DAOModalidade;
import table.ModeloTabelaCliente;
//import table.ModeloTabelaPagamentoDetalhes;
import view.VCliente;
import static view.VCliente.arrayModalidade;
import static view.VCliente.jTabCli;
import static view.VCliente.jTabCliente;
import static view.VCliente.jcCli_sexo;
import static view.VCliente.jcCli_status;
import static view.VCliente.jcModalidade;
import static view.VCliente.jdCli_dtNasc;
import static view.VCliente.jdCli_dtReg;
import static view.VCliente.jlFoto;
import static view.VCliente.jtCli_bi;
import static view.VCliente.jtCli_cod;
import static view.VCliente.jtCli_cp;
import static view.VCliente.jtCli_edu;
import static view.VCliente.jtCli_email;
import static view.VCliente.jtCli_locTrab;
import static view.VCliente.jtCli_morada;
import static view.VCliente.jtCli_nome;
import static view.VCliente.jtCli_prof;
import static view.VCliente.jtCli_telTrab;
import static view.VCliente.jtCli_telm;
import static view.VCliente.jtModalidadeCliente;
import static view.VCliente.jtaCli_obs;

public class ControllerCliente {
    MPessoa pesModel ;
    DAOCliente cliDao;
    Modalidade modalModel;
    Matriculamodalidade modMatModel;
    String codigoLinha = null;
    ModeloTabelaCliente modeloTabelaCliente;
   // ModeloTabelaPagamentoDetalhes modeloTabelaPagamentoDetalhes;

    DAOModalidade modalDao;
    int idModal = 0;
    int idPessoas = 0;
    private double valorModal = 0;
    private double total = 0.0;

    public ControllerCliente() {
        cliDao = new DAOCliente();
        modalModel = new Modalidade();
        modalDao = new DAOModalidade();
        modMatModel = new Matriculamodalidade();
        pesModel = new MPessoa();
    }

    public boolean manutencaoPessoa(String acao, int idFuncionario, int sexo, int estado, String encaEdu, String profissao,
            String localTrab, String telfTrab, String obs, byte[] foto, Date dtNasc, Date dtReg, int tipoPessoa,
            String nome, String morada, String email, String telemovel, String codBarra,
            String bi, String cp, String codigo) {
        if (!codigo.equals("")) {
            pesModel.setIdPessoa(Integer.parseInt(codigo));
        }
        pesModel.setIdFuncionario(idFuncionario);
        pesModel.setSexo(sexo);
        pesModel.setStatus(estado);
        pesModel.setEncaEdu(encaEdu);
        pesModel.setProfissao(profissao);
        pesModel.setLocalTrab(localTrab);
        pesModel.setTelfTrab(telfTrab);
        pesModel.setObs(obs);
        pesModel.setFoto(foto);
        pesModel.setDtNasc(dtNasc);
        pesModel.setDtreg(dtReg);
        pesModel.setTipoPessoa(tipoPessoa);
        pesModel.setNome(nome);
        pesModel.setMorada(morada);
        pesModel.setEmail(email);
        pesModel.setTelemovel(telemovel);
        pesModel.setCodBarra(codBarra);
        pesModel.setBi(bi);
        pesModel.setCp(cp);
        try {
            switch (acao) {
                case "inserir":
                    if (cliDao.incluir(pesModel)) {
                        //JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        cliDao.getTodosCliente();
                        preencherJTabelaCliente();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (cliDao.editar(pesModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        cliDao.getTodosCliente();
                        preencherJTabelaCliente();
                        jTabCli.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "alterarSemFoto":
                    if (cliDao.editarSemFoto(pesModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        cliDao.getTodosCliente();
                        preencherJTabelaCliente();
                        jTabCli.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "excluir":
                    String nomeCliente = "Apagar o cliente " + jtCli_nome.getText() + " ?";
                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeCliente, "Confirmacão Exclusão ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                        if (cliDao.excluir(pesModel)) {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
                            cliDao.getTodosCliente();
                            preencherJTabelaCliente();
                            jTabCli.setSelectedIndex(0);
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o registro!");
                        }
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int seletPessoaPorNomes(JComboBox cmbBoxCliente) {
        cliDao.executeSQLTodasPessoas(cmbBoxCliente.getSelectedItem().toString());
        if (cmbBoxCliente.getSelectedIndex() != 0) {
            try {
                cliDao.resultSet.next();
                idPessoas = Integer.parseInt(cliDao.resultSet.getString(1));
                return idPessoas;
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma pessoa");
        }
        return 0;

    }

    public void manutencaoPesquisaCombobox(String codigoLinha) throws IOException {

        try {
            cliDao.executeSQL(codigoLinha);
            cliDao.resultSet.next();
            jtCli_cod.setText(cliDao.resultSet.getString(1));
            jtCli_nome.setText(cliDao.resultSet.getString(2));
            jdCli_dtNasc.setDate(cliDao.resultSet.getDate(3));
            jcCli_sexo.setSelectedIndex(cliDao.resultSet.getInt(4));
            jtCli_bi.setText(cliDao.resultSet.getString(5));
            jtCli_email.setText(cliDao.resultSet.getString(7));
            jtCli_morada.setText(cliDao.resultSet.getString(8));
            jtCli_cp.setText(cliDao.resultSet.getString(9));
            jtCli_telm.setText(cliDao.resultSet.getString(10));
            jtCli_prof.setText(cliDao.resultSet.getString(12));
            jtCli_locTrab.setText(cliDao.resultSet.getString(13));
            jtCli_telTrab.setText(cliDao.resultSet.getString(14));
            jtCli_edu.setText(cliDao.resultSet.getString(15));
            jtaCli_obs.setText(cliDao.resultSet.getString(16));
            jcCli_status.setSelectedIndex(cliDao.resultSet.getInt(18));
            jdCli_dtReg.setDate(cliDao.resultSet.getDate(21));

            BufferedImage img = ImageIO.read(new ByteArrayInputStream(cliDao.resultSet.getBytes(19)));

            int type = img.getType();
            if (type == 0) {
                type = 5;
            } else {
                type = type;
            }  //se o tipo for 0, corrige para 5  

            //Converte o tamanho da imagem e mostra no jLabel  
            BufferedImage aux = new BufferedImage(130, 150, type);//cria um buffer auxiliar com o tamanho desejado    
            Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao    
            AffineTransform at = AffineTransform.getScaleInstance((double) 130 / img.getWidth(), (double) 150 / img.getHeight());//cria a transformacao    
            g.drawRenderedImage(img, at);//pinta e transforma a imagem real no auxiliar    
            jlFoto.setIcon(new ImageIcon(aux));

        } catch (SQLException erro) {
        }
    }

    public void pesquisaModalidade() {
        modalDao.executeSQLModalidadeNome(jcModalidade.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
        if (jcModalidade.getSelectedIndex() != 0) {
            try {
                modalDao.resultSet.next();
                model.addRow(new Object[]{modalDao.resultSet.getString(1), modalDao.resultSet.getString(3), modalDao.resultSet.getString(2)});
                idModal = Integer.parseInt(modalDao.resultSet.getString(1));
                total = total + Double.valueOf(modalDao.resultSet.getString(2));
                setValorModal((double) Double.valueOf(modalDao.resultSet.getString(2)));
                VCliente.jtCli_totalApagar.setText(String.valueOf(total));
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma modalidade");
        }
    }

    public void cancelaMatricula() {
        try {
            cliDao.executeSQLTodosMatriculaIgualZero();
            cliDao.resultSet.first();
            do {
                modMatModel.setMatricula(cliDao.resultSet.getInt("modMatricula"));
                cliDao.excluirMatriculaModalidade(modMatModel);
            } while (cliDao.resultSet.next());
            cliDao.excluirMatricula();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Cancelar matricula " + ex);
        }
    }

    public boolean seletPessoaPorNome(JComboBox cmbBoxCliente) {
        cliDao.executeSQLTodasPessoas(cmbBoxCliente.getSelectedItem().toString());
        if (cmbBoxCliente.getSelectedIndex() != 0) {
            try {
                cliDao.resultSet.next();
                idPessoas = Integer.parseInt(cliDao.resultSet.getString(1));
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma pessoa");
        }
        return false;

    }

    public void selectModalidade(String sql) {
        try {
            cliDao.pesquisar(jcModalidade, sql);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
        }
    }

    public void selectClienteToComo(JComboBox cmbBoxCliente) {
        try {
            cliDao.pesquisarClienteComo(cmbBoxCliente);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
        }
    }

    public void addEmailToComo(JComboBox cmbBoxEmail) {
       try {
          cliDao.pesquisarEmailComo(cmbBoxEmail);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
        }
    }

    public void manutencaoPesquisa() throws IOException {
        codigoLinha = (String) modeloTabelaCliente.getValueAt(jTabCliente.getSelectedRow(), 0);

        try {
            cliDao.executeSQL(codigoLinha);
            cliDao.resultSet.next();
            jtCli_cod.setText(cliDao.resultSet.getString(1));
            jtCli_nome.setText(cliDao.resultSet.getString(2));
            jdCli_dtNasc.setDate(cliDao.resultSet.getDate(3));
            jcCli_sexo.setSelectedIndex(cliDao.resultSet.getInt(4));
            jtCli_bi.setText(cliDao.resultSet.getString(5));
            jtCli_email.setText(cliDao.resultSet.getString(7));
            jtCli_morada.setText(cliDao.resultSet.getString(8));
            jtCli_cp.setText(cliDao.resultSet.getString(9));
            jtCli_telm.setText(cliDao.resultSet.getString(10));
            jtCli_prof.setText(cliDao.resultSet.getString(12));
            jtCli_locTrab.setText(cliDao.resultSet.getString(13));
            jtCli_telTrab.setText(cliDao.resultSet.getString(14));
            jtCli_edu.setText(cliDao.resultSet.getString(15));
            jtaCli_obs.setText(cliDao.resultSet.getString(16));
            jcCli_status.setSelectedIndex(cliDao.resultSet.getInt(18));
            jdCli_dtReg.setDate(cliDao.resultSet.getDate(21));

            preencherJTabelaModalidade(cliDao.resultSet.getString(1));

            BufferedImage img = ImageIO.read(new ByteArrayInputStream(cliDao.resultSet.getBytes(19)));

            int type = img.getType();
            if (type == 0) {
                type = 5;
            } else {
                type = type;
            }  //se o tipo for 0, corrige para 5  

            //Converte o tamanho da imagem e mostra no jLabel  
            BufferedImage aux = new BufferedImage(130, 150, type);//cria um buffer auxiliar com o tamanho desejado    
            Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao    
            AffineTransform at = AffineTransform.getScaleInstance((double) 130 / img.getWidth(), (double) 150 / img.getHeight());//cria a transformacao    
            g.drawRenderedImage(img, at);//pinta e transforma a imagem real no auxiliar    
            jlFoto.setIcon(new ImageIcon(aux));

        } catch (SQLException erro) {
        }
    }

    //Prencher tabela cliente modalidade (Matricula)
    public void preencherJTabelaModalidade(String Cliente) {
        modalDao.ClienteModalidade(Cliente);
        DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
        jtModalidadeCliente.removeColumn(jtModalidadeCliente.getColumnModel().getColumn(0));

        try {
            modalDao.resultSet.beforeFirst();
            while (modalDao.resultSet.next()) {
                model.addRow(new Object[]{modalDao.resultSet.getString(1), modalDao.resultSet.getString(3), modalDao.resultSet.getString(2)});
                idModal = Integer.parseInt(modalDao.resultSet.getString(1));
                total = total + Double.valueOf(modalDao.resultSet.getString(2));
                VCliente.jtCli_totalApagar.setText(String.valueOf(total));
                arrayModalidade.add(new Modalidade(idModal,  Double.valueOf(modalDao.resultSet.getString(2)), null));
            }
            int tamArray = arrayModalidade.size();
            String clauseWhere = "idModalidade <> " + arrayModalidade.get(0).getIdModalidade();
            for (int i = 1; i < tamArray; i++) {
                clauseWhere += " AND idModalidade <> " + arrayModalidade.get(i).getIdModalidade();
            }
            String sql = "select * from modalidade WHERE " + clauseWhere;
            System.out.println("" + sql);
            selectModalidade(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherJTabelaCliente() {
        cliDao.getTodosCliente();
        try {
            modeloTabelaCliente = new ModeloTabelaCliente(cliDao.resultSet);
            jTabCliente.setModel(modeloTabelaCliente);
            jTabCliente.removeColumn(jTabCliente.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela " + ex);
        }
    }

    public ResultSet getUltimoRegistro() {
        cliDao.getTodosCliente();
        return cliDao.getUtimoRegistro();
    }

    //Pesquisa de Cliente
    public void pesquisaCliente(String pesq, String acao) {
        try {
            switch (acao) {
                case "Matricula":
                    String sql = "select pagamento.data AS 'DataPagamento', pagamento.dataValidade AS 'DataValidade', pagamento.descricao AS 'TipoPagamento',\n"
                            + " matriculamodalidade.valorModalidade AS 'Valor', modalidade.nome AS 'Modalidade', if(pagamento.estado = 1, 'Activo','Inactivo' ) AS 'Estado'\n"
                            + "  from pagamento inner join matricula on pagamento.idControlPagamento = matricula.idMatricula \n"
                            + "inner join matriculamodalidade on matriculamodalidade.idMatricula = matricula.idMatricula \n"
                            + "inner join modalidade on matriculamodalidade.idModalidade = modalidade.idModalidade\n"
                            + "where pagamento.descricao = \"Matricula\" AND pagamento.idCliente = " + pesq + "";
                    cliDao.execute_sql(sql);
                    //modeloTabelaPagamentoDetalhes = new ModeloTabelaPagamentoDetalhes(cliDao.resultSet);
                   // jtPagamentoFilter.setModel(modeloTabelaPagamentoDetalhes);
                    break;

                /*case "Escolha...":
                    cliDao.execute_sql("SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo, if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto FROM pessoa where  tipoPessoa=0 AND nome LIKE '%" + pesq + "%'");
                    modeloTabelaCliente = new ModeloTabelaCliente(cliDao.resultSet);
                    jtPagamentoFilter.setModel(modeloTabelaCliente);
                    break;*/

                case "Codigo":
                    cliDao.execute_sql("SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo,"
                            + " if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto "
                            + "FROM pessoa WHERE  tipoPessoa=0 AND idPessoa LIKE '%" + pesq + "%'");
                    modeloTabelaCliente = new ModeloTabelaCliente(cliDao.resultSet);
                    jTabCliente.setModel(modeloTabelaCliente);
                    break;
                case "Nome":
                    cliDao.execute_sql("SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo,"
                            + " if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto "
                            + "FROM pessoa WHERE  tipoPessoa=0 AND nome LIKE '%" + pesq + "%'");
                    modeloTabelaCliente = new ModeloTabelaCliente(cliDao.resultSet);
                    jTabCliente.setModel(modeloTabelaCliente);
                    break;
                case "Pagamento":
                    cliDao.execute_sql("SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo,"
                            + " if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto "
                            + "FROM pessoa WHERE  tipoPessoa=0 AND nome LIKE '%" + pesq + "%'");
                    modeloTabelaCliente = new ModeloTabelaCliente(cliDao.resultSet);
                    jTabCliente.setModel(modeloTabelaCliente);
                    break;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
    }

    public void alterarEstado(int idCliente) {
       /* cliModel.setIdPessoa(idCliente);
        try {
            cliDao.editarEstado(cliModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro : " + ex.getMessage());
        }*/
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdModal() {
        return idModal;
    }

    public void setIdModal(int idModal) {
        this.idModal = idModal;
    }

    public int getIdPessoas() {
        return idPessoas;
    }

    public void setIdPessoas(int idPessoas) {
        this.idPessoas = idPessoas;
    }

    /**
     * @return the valorModal
     */
    public double getValorModal() {
        return valorModal;
    }

    /**
     * @param valorModal the valorModal to set
     */
    public void setValorModal(double valorModal) {
        this.valorModal = valorModal;
    }

}
