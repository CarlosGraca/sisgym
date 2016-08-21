package persistence;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.MConexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import static view.VJDialogConexao.jTextFieldBaseDados;
import static view.VJDialogConexao.jTextFieldDriver;
import static view.VJDialogConexao.jTextFieldDrivermanager;
import static view.VJDialogConexao.jTextFieldMsg;
import static view.VJDialogConexao.jTextFieldNomeBanco;
import static view.VJDialogConexao.jTextFieldPassword;

public final class Conexao {
    private static Connection conexao;
    public static String passConexion;
    public static String nameConexion;
    public static String driverConexion;
    public static String driverManagerConexion;
    public static String baseDadosConexion;
    public static String msgConexion;

    public Conexao() {
        dadosConexionXML();
        try {
            Class.forName(driverConexion);
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro.getMessage(), "Conexão", 3);
        }
        try {
            conexao = DriverManager.getConnection(driverManagerConexion + "/" + baseDadosConexion, nameConexion, passConexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: Conexão falhada " + ex.getMessage(), "Conexão", 3);
        }
        if (conexao != null) {
            System.out.println(msgConexion);
        } else {
            System.exit(0);
//            VJDialogConexao obj = new VJDialogConexao(null, true);
//            obj.setVisible(true);
        }
    }

    public Connection getConexao() {
        return conexao;
    }
    
    public ResultSet ejecutarSQLSelect(String sql)
    {
       ResultSet resultado;
       try {
          PreparedStatement ps = conexao.prepareStatement(sql);
          resultado = ps.executeQuery();
          return resultado;
       } catch (SQLException ex) {
          System.err.println("Error "+ex);
          return null;
       }
    }

    public void dadosConexionXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            try {
                InputStream caminho = getClass().getResourceAsStream("configXML.xml");
                // String caminho = "configXML.xml";
                Document doc = builder.parse(caminho);
                NodeList nodeList = doc.getElementsByTagName("conexao");
                int tammanhoLista = nodeList.getLength();
                for (int i = 0; i < tammanhoLista; i++) {
                    Node noConexao = nodeList.item(i);
                    if (noConexao.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) noConexao;
                        String id = element.getAttribute("id");
                        // System.out.println("ID: " + id);
                        NodeList list = element.getChildNodes();
                        int tam = list.getLength();
                        for (int j = 0; j < tam; j++) {
                            Node node = list.item(j);
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                Element e = (Element) node;
                                switch (e.getTagName()) {
                                    case "password":
                                        passConexion = e.getTextContent();
                                        break;
                                    case "nameConexao":
                                        nameConexion = e.getTextContent();
                                        break;
                                    case "driver":
                                        driverConexion = e.getTextContent();
                                        break;
                                    case "driverManager":
                                        driverManagerConexion = e.getTextContent();
                                        break;
                                    case "baseDados":
                                        baseDadosConexion = e.getTextContent();
                                        break;
                                    case "mensagem":
                                        msgConexion = e.getTextContent();
                                        break;
                                }
                            }
                        }
                    }
                }
            } catch (IOException | SAXException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro não encontrou ficheiro: " + ex.getMessage());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherCampos() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream caminho = getClass().getResourceAsStream("configXML.xml");
            Document document = builder.parse(caminho);

            // Get root element
            Node conexion = document.getFirstChild();
            Node con = document.getElementsByTagName("conexao").item(0);
            // loop conexao child node
            NodeList lista = con.getChildNodes();
            for (int i = 0; i < lista.getLength(); i++) {
                Node node = lista.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    switch (e.getTagName()) {
                        case "password":
                            jTextFieldPassword.setText(e.getTextContent());
                            break;
                        case "nameConexao":
                            jTextFieldNomeBanco.setText(e.getTextContent());
                            break;
                        case "driver":
                            jTextFieldDriver.setText(e.getTextContent());
                            break;
                        case "driverManager":
                            jTextFieldDrivermanager.setText(e.getTextContent());
                            break;
                        case "baseDados":
                            jTextFieldBaseDados.setText(e.getTextContent());
                            break;
                        case "mensagem":
                            jTextFieldMsg.setText(e.getTextContent());
                            break;
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ModifyXMLFile(MConexao obj) throws TransformerConfigurationException, TransformerException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream caminho = getClass().getResourceAsStream("configXML.xml");
            Document document = builder.parse(caminho);

            // Get root element
            Node conexion = document.getFirstChild();
            Node con = document.getElementsByTagName("conexao").item(0);
            // loop conexao child node
            NodeList lista = con.getChildNodes();
            for (int i = 0; i < lista.getLength(); i++) {
                Node node = lista.item(i);

                // get elemento password, e update  value
                if ("password".equals(node.getNodeName())) {
                    node.setTextContent(obj.getPass());
                }
                // get elemento nameConexao, e update  value
                if ("nameConexao".equals(node.getNodeName())) {
                    node.setTextContent(obj.getNomeBanco());
                }
                // get elemento driver, e update  value
                if ("driver".equals(node.getNodeName())) {
                    node.setTextContent(obj.getDriver());
                }
                // get elemento driverManager, e update  value
                if ("driverManager".equals(node.getNodeName())) {
                    node.setTextContent(obj.getDriverManager());
                }
                // get elemento basedados, e update  value
                if ("baseDados".equals(node.getNodeName())) {
                    node.setTextContent(obj.getBaseDados());
                }
                // get elemento mensagem, e update  value
                if ("mensagem".equals(node.getNodeName())) {
                    node.setTextContent(obj.getMensagem());
                }
            }
            // write o content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            OutputStream output = null;
            String cam = PastaCorrente();
            // output = new FileOutputStream(cam + "persistence/configXML.xml");
            //output = new FileOutputStream(cam + "persistence/configXML.xml");
            File file = new File(cam + "persistence/configXML.xml");
            JOptionPane.showMessageDialog(null, cam +"SGG/build/classes/persistence/configXML.xml");
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

            System.out.println("Done: " + output);
            return true;
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(null, "Erro na instancia do  documento builder : " + ex.getMessage());
        } catch (SAXException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro com o caminho do XML : " + ex.getMessage());
        }
        return false;
    }

    public String pastaJar() {
        try {
            CodeSource codeSource = Conexao.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();
            return jarDir;
        } catch (URISyntaxException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String pastaTeste() {
        try {
            String path = Conexao.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = URLDecoder.decode(path, "UTF-8");
            return decodedPath;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String PastaCorrente() {
        String c = null;
        try {
            c = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            c = c.substring(1, c.lastIndexOf('/') + 1);
            //System.out.println(c);  
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return c;
    }

//    public void conexionPassUser() {
//        FileInputStream stream = null;
//        try {
//            stream = new FileInputStream("C:\\xampp\\security\\mysqlrootpasswd.txt");
//            InputStreamReader reader = new InputStreamReader(stream);
//            BufferedReader br = new BufferedReader(reader);
//            String linha = br.readLine();
//            while (linha != null) {
//                nameConexion = linha.substring(linha.indexOf('=') + 1, linha.lastIndexOf('='));
//                passConexion = linha.substring(linha.indexOf('|') + 1, linha.length());
//                linha = br.readLine();
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                stream.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    public void EjecutarReporte(InputStream URL) {
        try {
            JasperReport Jas_Rep = JasperCompileManager.compileReport(URL);
            JasperPrint Jas_Prin = JasperFillManager.fillReport(Jas_Rep, null, this.getConexao());
            JasperViewer jv = new JasperViewer(Jas_Prin, false);
            //JasperViewer.viewReport(Jas_Prin);
            jv.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Não encontrou nenhum relatorio: " + e.getMessage());
        }
    }

    public void EjecutarReporteStream(InputStream url) {
        try {
            JasperReport Jas_Rep = JasperCompileManager.compileReport(url);
            JasperPrint Jas_Prin = JasperFillManager.fillReport(Jas_Rep, null, this.getConexao());
            JasperViewer jv = new JasperViewer(Jas_Prin, false);
            // JasperViewer.viewReport(Jas_Prin);
            jv.setVisible(true);
            //JasperExportManager.exportReportToPdf(Jas_Prin); 
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Não encontrou nenhum relatorio: " + e.getMessage());
        }
    }

    public void EjectuarReporteFiltro(int idPessoa, String pFiltro, InputStream URL) {
        try {
            HashMap filtro = new HashMap();
            filtro.put(pFiltro, idPessoa);

            JasperReport Jas_Rep = JasperCompileManager.compileReport(URL);
            JasperPrint Jas_Prin = JasperFillManager.fillReport(Jas_Rep, filtro, this.getConexao());
            JasperViewer jv = new JasperViewer(Jas_Prin, false);
            jv.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Não encontrou nenhum relatorio: " + e.getMessage());
        }
    }

    public void EjectuarReporteFiltroData(String dtInicio, String dtFim, String pFiltro, String pFiltro2, InputStream URL) {
        try {
            HashMap filtro = new HashMap();
            filtro.put(pFiltro, dtInicio);
            filtro.put(pFiltro2, dtFim);

            JasperReport Jas_Rep = JasperCompileManager.compileReport(URL);
            JasperPrint Jas_Prin = JasperFillManager.fillReport(Jas_Rep, filtro, this.getConexao());
            JasperViewer jv = new JasperViewer(Jas_Prin, false);
            jv.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Não encontrou nenhum relatorio: " + e.getMessage());
        }
    }

    public void EjectuarReporteFiltroString(String idPessoa, String pFiltro, InputStream URL) {
        try {
            HashMap filtro = new HashMap();
            filtro.put(pFiltro, idPessoa);

            JasperReport Jas_Rep = JasperCompileManager.compileReport(URL);
            JasperPrint Jas_Prin = JasperFillManager.fillReport(Jas_Rep, filtro, this.getConexao());
            JasperViewer jv = new JasperViewer(Jas_Prin, false);
            jv.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Não encontrou nenhum relatorio: " + e.getMessage());
        }
    }
}
