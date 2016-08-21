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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Pessoa;
import persistence.DAOFuncionario;
import table.ModeloTabelaFuncionario;
import static view.VFuncionario.jlFoto;
import static view.VFuncionario.jTabFun;
import static view.VFuncionario.jcFun_sexo;
import static view.VFuncionario.jcFun_status;
import static view.VFuncionario.jdFun_dtNasc;
import static view.VFuncionario.jdFun_dtReg;
import static view.VFuncionario.jtFun_bi;
import static view.VFuncionario.jtFun_cod;
import static view.VFuncionario.jtFun_cp;
import static view.VFuncionario.jtFun_email;
import static view.VFuncionario.jtFun_morada;
import static view.VFuncionario.jtFun_nome;
import static view.VFuncionario.jtFun_telm;
import static view.VFuncionario.jtFuncionario;

public class ControllerFuncionario {

    Pessoa funcModel;
    DAOFuncionario funcDao;
    String codigoLinha;
    ModeloTabelaFuncionario modeloTabelaFuncionario;

    public ControllerFuncionario() {
        funcModel = new Pessoa();
        funcDao = new DAOFuncionario();
        funcDao.getTodosFuncionario();
    }

    public boolean manutencaoPessoaFuncinario(String acao, String codigo, String nome, int sexo, String bi, String email, String morada, String cp, String telemovel, String codBarra, int estado, byte[] foto, Date dtNasc, Date dtReg, int tipoPessoa) {
        if (!codigo.equals("")) {
            funcModel.setIdPessoa(Integer.parseInt(codigo));
        }
        funcModel.setNome(nome);
        funcModel.setMorada(morada);
        funcModel.setEmail(email);
        funcModel.setTelemovel(telemovel);
        funcModel.setCodBarra(codBarra);
        funcModel.setBi(bi);
        funcModel.setCp(cp);
        funcModel.setSexo(sexo);
        funcModel.setStatus(estado);
        funcModel.setFoto(foto);
        funcModel.setDtNasc(dtNasc);
        funcModel.setDtreg(dtReg);
        funcModel.setTipoPessoa(tipoPessoa);

        try {
            switch (acao) {
                case "inserir":
                    if (funcDao.incluir(funcModel)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        funcDao.getTodosFuncionario();
                        preencherJTabelaFuncinario();
                        jTabFun.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (funcDao.editar(funcModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        funcDao.getTodosFuncionario();
                        preencherJTabelaFuncinario();
                        jTabFun.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "alterarSemFoto":
                    if (funcDao.editarSemFoto(funcModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        funcDao.getTodosFuncionario();
                        preencherJTabelaFuncinario();
                        jTabFun.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "excluir":
                    String nomeFunc = "Apagar o funcinário " + jtFun_nome.getText() + " ?";
                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeFunc, "Confirmacão Exclusão ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                        if (funcDao.excluir(funcModel)) {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
                            funcDao.getTodosFuncionario();
                            preencherJTabelaFuncinario();
                            jTabFun.setSelectedIndex(0);
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");

                        }
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public void selectModalidade() {
//        try {
//            modalModel = cliDao.pesquisar(jcModalidade);
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
//        }
//    }
//
//
//    public void selectClienteToComo2() {
//        try {
//            cliModel = cliDao.pesquisarClienteComo(jcbPag_nome);
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
//        }
//    }
//
    public void manutencaoPesquisa() throws IOException {
        codigoLinha = (String) modeloTabelaFuncionario.getValueAt(jtFuncionario.getSelectedRow(), 0);

        try {
            funcDao.executeSQL(codigoLinha);
            funcDao.resultSet.next();
            jtFun_cod.setText(funcDao.resultSet.getString(1));
            jtFun_nome.setText(funcDao.resultSet.getString(2));
            jdFun_dtNasc.setDate(funcDao.resultSet.getDate(3));
            jcFun_sexo.setSelectedIndex(funcDao.resultSet.getInt(4));
            jtFun_bi.setText(funcDao.resultSet.getString(5));
            jtFun_email.setText(funcDao.resultSet.getString(7));
            jtFun_morada.setText(funcDao.resultSet.getString(8));
            jtFun_cp.setText(funcDao.resultSet.getString(9));
            jtFun_telm.setText(funcDao.resultSet.getString(10));
            jcFun_status.setSelectedIndex(funcDao.resultSet.getInt(18));
            jdFun_dtReg.setDate(funcDao.resultSet.getDate(21));
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(funcDao.resultSet.getBytes(19)));

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

    public void preencherJTabelaFuncinario() {
        funcDao.getTodosFuncionario();
        try {
            modeloTabelaFuncionario = new ModeloTabelaFuncionario(funcDao.resultSet);
            jtFuncionario.setModel(modeloTabelaFuncionario);
            jtFuncionario.removeColumn(jtFuncionario.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela " + ex);
        }
    }
//
//    public void pesquisaCliente() {
//        JOptionPane.showMessageDialog(null, jcPesquisar.getSelectedItem().toString());
//        String campo = String.valueOf(jcPesquisar.getSelectedItem());
//        String pesquisa = String.valueOf(jtPesquisar.getText());
//        if (((pesquisa.length() != 0) && campo.equals("Codigo")) || campo.equals("Nome")) {
//            cliDao.pesquisaPersonalizadoClientes((String) pesquisa, campo);
//            preencherJTabelaCliente();
//        }
//    }

    public static boolean isEmailValid(String email) {
        if ((email == null) || (email.trim().length() == 0)) {
            return false;
        }

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Pesquisa de Funcionário
    public void pesquisaFuncionario(String acao, String pesq) {
        try {
            switch (acao) {
                case "Codigo":
                    funcDao.pesquisarFuncionario("SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo, if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto FROM pessoa WHERE tipoPessoa = 1 AND idPessoa LIKE '%" + pesq + "%'");
                    break;
                case "Nome":
                    funcDao.pesquisarFuncionario("SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo, if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto FROM pessoa WHERE tipoPessoa = 1 AND nome LIKE '%" + pesq + "%'");
                    break;
            }
            modeloTabelaFuncionario = new ModeloTabelaFuncionario(funcDao.resultSet);
            jtFuncionario.setModel(modeloTabelaFuncionario);
            jtFuncionario.removeColumn(jtFuncionario.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
    }
}
