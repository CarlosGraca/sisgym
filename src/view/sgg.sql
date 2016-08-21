-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 12-Dez-2015 às 17:43
-- Versão do servidor: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sgg`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acessogym`
--

CREATE TABLE IF NOT EXISTS `acessogym` (
`idAcessoGym` int(11) NOT NULL,
  `horaEntrada` varchar(10) COLLATE utf8_bin NOT NULL,
  `horaSaida` time DEFAULT NULL,
  `idCliente` int(255) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `acessosistema`
--

CREATE TABLE IF NOT EXISTS `acessosistema` (
`idAcessoSis` int(11) NOT NULL,
  `login` int(11) NOT NULL DEFAULT '0',
  `data` date DEFAULT '0000-00-00',
  `hora` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `acao` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `conexao`
--

CREATE TABLE IF NOT EXISTS `conexao` (
`Id` int(11) NOT NULL,
  `driver` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `driverManager` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `baseDados` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mensagem` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `conexao`
--

INSERT INTO `conexao` (`Id`, `driver`, `driverManager`, `baseDados`, `mensagem`) VALUES
(1, 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306', 'sgg', 'Hello');

-- --------------------------------------------------------

--
-- Estrutura da tabela `diasemana`
--

CREATE TABLE IF NOT EXISTS `diasemana` (
`idSemana` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `diasemana`
--

INSERT INTO `diasemana` (`idSemana`, `nome`, `estado`) VALUES
(1, 'Segunda-Feira', '1'),
(2, 'Terça-Feira', '1'),
(3, 'Quarta-Feira', '1'),
(4, 'Quinta-Feira', '1'),
(5, 'Sexta-Feira', '1'),
(6, 'Sábado', '1'),
(7, 'Domingo', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
`idEmpresa` int(11) NOT NULL,
  `nome` varchar(100) COLLATE utf8_bin NOT NULL,
  `localizacao` text COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `telefone` varchar(50) COLLATE utf8_bin NOT NULL,
  `nif` int(20) NOT NULL,
  `cp` int(11) NOT NULL,
  `telemovel` varchar(50) COLLATE utf8_bin NOT NULL,
  `logo` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipamento`
--

CREATE TABLE IF NOT EXISTS `equipamento` (
`idEquipamento` int(11) NOT NULL,
  `nome` varchar(100) COLLATE utf8_bin NOT NULL,
  `marca` varchar(100) COLLATE utf8_bin NOT NULL,
  `codEquipamento` varchar(11) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `equipamento`
--

INSERT INTO `equipamento` (`idEquipamento`, `nome`, `marca`, `codEquipamento`) VALUES
(1, 'voador', 'f', 'f');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcao`
--

CREATE TABLE IF NOT EXISTS `funcao` (
`idFuncao` int(11) NOT NULL,
  `designacao` varchar(255) COLLATE utf8_bin NOT NULL,
  `salario` int(11) NOT NULL,
  `fun_entrada` date NOT NULL,
  `fun_saida` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
`idHorario` int(11) NOT NULL,
  `idModalidade` int(11) NOT NULL,
  `diaSemana` int(11) NOT NULL,
  `horaInicio` time NOT NULL DEFAULT '00:00:00',
  `horaFim` time NOT NULL DEFAULT '00:00:00'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `horario`
--

INSERT INTO `horario` (`idHorario`, `idModalidade`, `diaSemana`, `horaInicio`, `horaFim`) VALUES
(1, 1, 1, '10:18:00', '20:18:00'),
(2, 1, 2, '10:18:00', '20:18:00'),
(3, 1, 4, '23:29:02', '23:29:02'),
(4, 1, 2, '17:58:25', '17:58:25'),
(5, 2, 6, '07:58:00', '17:58:25'),
(6, 2, 3, '18:01:38', '18:01:38');

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_venda_produto`
--

CREATE TABLE IF NOT EXISTS `item_venda_produto` (
  `quantidade_produto` int(11) NOT NULL DEFAULT '0',
  `Id_venda` int(11) DEFAULT NULL,
  `Id_produto` int(11) NOT NULL DEFAULT '0',
`id` int(11) NOT NULL,
  `valorItem` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `licenca`
--

CREATE TABLE IF NOT EXISTS `licenca` (
`idLicenca` int(11) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `codigo` varchar(255) COLLATE utf8_bin NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  `mac` varchar(255) COLLATE utf8_bin NOT NULL,
  `diaVenc` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `licenca`
--

INSERT INTO `licenca` (`idLicenca`, `dataInicio`, `dataFim`, `codigo`, `idEmpresa`, `mac`, `diaVenc`) VALUES
(2, '2015-09-26', '2015-10-25', '', 1, '', 365);

-- --------------------------------------------------------

--
-- Estrutura da tabela `manutencao`
--

CREATE TABLE IF NOT EXISTS `manutencao` (
`idManutencao` int(11) NOT NULL,
  `idEquipamento` int(11) NOT NULL,
  `data` date NOT NULL,
  `obs` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `matricula`
--

CREATE TABLE IF NOT EXISTS `matricula` (
`idMatricula` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `mat_data` date NOT NULL DEFAULT '0000-00-00',
  `valorTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `matriculamodalidade`
--

CREATE TABLE IF NOT EXISTS `matriculamodalidade` (
`idMatriculaModalidade` int(11) NOT NULL,
  `idMatricula` int(11) NOT NULL,
  `idModalidade` int(11) NOT NULL,
  `valorModalidade` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `modalidade`
--

CREATE TABLE IF NOT EXISTS `modalidade` (
`idModalidade` int(11) NOT NULL,
  `valor` double NOT NULL,
  `nome` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `modalidade`
--

INSERT INTO `modalidade` (`idModalidade`, `valor`, `nome`) VALUES
(1, 2000, 'Karate'),
(2, 1500, 'Ginastica');

-- --------------------------------------------------------

--
-- Estrutura da tabela `nivel_acesso`
--

CREATE TABLE IF NOT EXISTS `nivel_acesso` (
`id` int(11) NOT NULL,
  `ni_Cod_Utilizador` int(11) NOT NULL,
  `ni_menu` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `nivel_acesso`
--

INSERT INTO `nivel_acesso` (`id`, `ni_Cod_Utilizador`, `ni_menu`) VALUES
(1, 7, 'Usuários do Sistema'),
(2, 7, 'Modalidades'),
(3, 7, 'Log'),
(4, 11, 'Processar Pagamento');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
`idPagamento` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `tipo` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `data` date NOT NULL,
  `codPagamento` varchar(50) COLLATE utf8_bin NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dataValidade` date NOT NULL,
  `obs` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `descricao` varchar(255) COLLATE utf8_bin NOT NULL,
  `idControlPagamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `param_iva`
--

CREATE TABLE IF NOT EXISTS `param_iva` (
`Id` int(11) NOT NULL,
  `valor_iva` double DEFAULT NULL,
  `iva` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `param_iva`
--

INSERT INTO `param_iva` (`Id`, `valor_iva`, `iva`) VALUES
(4, 15, 0.15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
`idPessoa` int(11) NOT NULL,
  `nome` varchar(100) COLLATE utf8_bin NOT NULL,
  `dtNasc` date DEFAULT NULL,
  `sexo` int(1) NOT NULL,
  `bi` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `nif` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `morada` text COLLATE utf8_bin NOT NULL,
  `cp` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `telemovel` varchar(50) COLLATE utf8_bin NOT NULL,
  `telfCasa` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `profissao` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `localTrab` text COLLATE utf8_bin,
  `telfTrab` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `encaEdu` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `obs` text COLLATE utf8_bin,
  `codBarra` varchar(255) COLLATE utf8_bin NOT NULL,
  `status` int(1) NOT NULL,
  `foto` longblob,
  `funcao` int(11) DEFAULT NULL,
  `dtreg` date DEFAULT NULL,
  `tipoPessoa` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
`idProduto` int(11) NOT NULL,
  `nome` varchar(100) COLLATE utf8_bin NOT NULL,
  `preco` float NOT NULL,
  `quantidade` int(11) NOT NULL,
  `data` date NOT NULL,
  `cod_Barra` varchar(255) COLLATE utf8_bin NOT NULL,
  `Cod_Func` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `recibos`
--

CREATE TABLE IF NOT EXISTS `recibos` (
`idRecibo` int(11) NOT NULL,
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `documento` varchar(500) NOT NULL,
  `numDoc` varchar(20) NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `situacao` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servidor_email`
--

CREATE TABLE IF NOT EXISTS `servidor_email` (
`ser_idServidor` int(11) NOT NULL,
  `ser_smtp` varchar(255) COLLATE utf8_bin NOT NULL,
  `ser_porta` int(11) NOT NULL,
  `ser_email` varchar(255) COLLATE utf8_bin NOT NULL,
  `ser_senha` varchar(100) COLLATE utf8_bin NOT NULL,
  `ser_assinatura` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `servidor_email`
--

INSERT INTO `servidor_email` (`ser_idServidor`, `ser_smtp`, `ser_porta`, `ser_email`, `ser_senha`, `ser_assinatura`) VALUES
(2, 'smtp.gmail.com', 465, 'cg121322@us.edu.cv', '@AdtnC2015', 'cscs');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoutilizador`
--

CREATE TABLE IF NOT EXISTS `tipoutilizador` (
`idTipoutilizador` int(11) NOT NULL,
  `designacao` varchar(100) COLLATE utf8_bin NOT NULL,
  `permissao` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tipoutilizador`
--

INSERT INTO `tipoutilizador` (`idTipoutilizador`, `designacao`, `permissao`) VALUES
(1, 'Administrador', 'Todas'),
(2, 'Comun', 'nenhum');

-- --------------------------------------------------------

--
-- Estrutura da tabela `utilizador`
--

CREATE TABLE IF NOT EXISTS `utilizador` (
`ut_IdUtilizador` int(11) NOT NULL,
  `ut_login` varchar(255) COLLATE utf8_bin NOT NULL,
  `ut_senha` varchar(255) COLLATE utf8_bin NOT NULL,
  `ut_nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `ut_dtReg` date NOT NULL,
  `ut_dtUltimaVisita` date NOT NULL,
  `ut_tipoUtilizador` int(11) DEFAULT NULL,
  `ut_status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `utilizador`
--

INSERT INTO `utilizador` (`ut_IdUtilizador`, `ut_login`, `ut_senha`, `ut_nome`, `ut_dtReg`, `ut_dtUltimaVisita`, `ut_tipoUtilizador`, `ut_status`) VALUES
(10, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Escolha...', '2015-09-25', '2015-11-30', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
`ven_id` int(11) NOT NULL,
  `ven_data` date DEFAULT NULL,
  `pes_nome` int(11) DEFAULT NULL,
  `ven_valor` float NOT NULL,
  `codFunc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acessogym`
--
ALTER TABLE `acessogym`
 ADD PRIMARY KEY (`idAcessoGym`);

--
-- Indexes for table `acessosistema`
--
ALTER TABLE `acessosistema`
 ADD PRIMARY KEY (`idAcessoSis`), ADD KEY `login` (`login`);

--
-- Indexes for table `conexao`
--
ALTER TABLE `conexao`
 ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `diasemana`
--
ALTER TABLE `diasemana`
 ADD PRIMARY KEY (`idSemana`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
 ADD PRIMARY KEY (`idEmpresa`);

--
-- Indexes for table `equipamento`
--
ALTER TABLE `equipamento`
 ADD PRIMARY KEY (`idEquipamento`);

--
-- Indexes for table `funcao`
--
ALTER TABLE `funcao`
 ADD PRIMARY KEY (`idFuncao`);

--
-- Indexes for table `horario`
--
ALTER TABLE `horario`
 ADD PRIMARY KEY (`idHorario`), ADD KEY `idModalidade` (`idModalidade`,`diaSemana`), ADD KEY `diaSemana` (`diaSemana`);

--
-- Indexes for table `item_venda_produto`
--
ALTER TABLE `item_venda_produto`
 ADD PRIMARY KEY (`id`), ADD KEY `Id_venda` (`Id_venda`,`Id_produto`), ADD KEY `Id_produto` (`Id_produto`);

--
-- Indexes for table `licenca`
--
ALTER TABLE `licenca`
 ADD PRIMARY KEY (`idLicenca`), ADD KEY `idEmpresa` (`idEmpresa`);

--
-- Indexes for table `manutencao`
--
ALTER TABLE `manutencao`
 ADD PRIMARY KEY (`idManutencao`), ADD KEY `idEquipamento` (`idEquipamento`);

--
-- Indexes for table `matricula`
--
ALTER TABLE `matricula`
 ADD PRIMARY KEY (`idMatricula`), ADD KEY `idCliente` (`idCliente`,`idFuncionario`), ADD KEY `idFuncionario` (`idFuncionario`);

--
-- Indexes for table `matriculamodalidade`
--
ALTER TABLE `matriculamodalidade`
 ADD PRIMARY KEY (`idMatriculaModalidade`), ADD KEY `idMatricula` (`idMatricula`,`idModalidade`), ADD KEY `idModalidade` (`idModalidade`);

--
-- Indexes for table `modalidade`
--
ALTER TABLE `modalidade`
 ADD PRIMARY KEY (`idModalidade`);

--
-- Indexes for table `nivel_acesso`
--
ALTER TABLE `nivel_acesso`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pagamento`
--
ALTER TABLE `pagamento`
 ADD PRIMARY KEY (`idPagamento`), ADD KEY `idFuncionario` (`idFuncionario`,`idCliente`,`tipo`), ADD KEY `idCliente` (`idCliente`);

--
-- Indexes for table `param_iva`
--
ALTER TABLE `param_iva`
 ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
 ADD PRIMARY KEY (`idPessoa`), ADD KEY `funcao` (`funcao`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
 ADD PRIMARY KEY (`idProduto`);

--
-- Indexes for table `recibos`
--
ALTER TABLE `recibos`
 ADD PRIMARY KEY (`idRecibo`), ADD KEY `idCliente` (`idCliente`), ADD KEY `idUser` (`idUser`);

--
-- Indexes for table `servidor_email`
--
ALTER TABLE `servidor_email`
 ADD PRIMARY KEY (`ser_idServidor`);

--
-- Indexes for table `tipoutilizador`
--
ALTER TABLE `tipoutilizador`
 ADD PRIMARY KEY (`idTipoutilizador`);

--
-- Indexes for table `utilizador`
--
ALTER TABLE `utilizador`
 ADD PRIMARY KEY (`ut_IdUtilizador`), ADD KEY `ut_tipoUtilzador` (`ut_tipoUtilizador`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
 ADD PRIMARY KEY (`ven_id`), ADD KEY `pes_nome` (`pes_nome`), ADD KEY `codFunc` (`codFunc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acessogym`
--
ALTER TABLE `acessogym`
MODIFY `idAcessoGym` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `acessosistema`
--
ALTER TABLE `acessosistema`
MODIFY `idAcessoSis` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `conexao`
--
ALTER TABLE `conexao`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `diasemana`
--
ALTER TABLE `diasemana`
MODIFY `idSemana` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `empresa`
MODIFY `idEmpresa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `equipamento`
--
ALTER TABLE `equipamento`
MODIFY `idEquipamento` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `funcao`
--
ALTER TABLE `funcao`
MODIFY `idFuncao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `horario`
--
ALTER TABLE `horario`
MODIFY `idHorario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `item_venda_produto`
--
ALTER TABLE `item_venda_produto`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `licenca`
--
ALTER TABLE `licenca`
MODIFY `idLicenca` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `manutencao`
--
ALTER TABLE `manutencao`
MODIFY `idManutencao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `matricula`
--
ALTER TABLE `matricula`
MODIFY `idMatricula` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `matriculamodalidade`
--
ALTER TABLE `matriculamodalidade`
MODIFY `idMatriculaModalidade` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `modalidade`
--
ALTER TABLE `modalidade`
MODIFY `idModalidade` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `nivel_acesso`
--
ALTER TABLE `nivel_acesso`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `pagamento`
--
ALTER TABLE `pagamento`
MODIFY `idPagamento` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `param_iva`
--
ALTER TABLE `param_iva`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
MODIFY `idPessoa` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `recibos`
--
ALTER TABLE `recibos`
MODIFY `idRecibo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `servidor_email`
--
ALTER TABLE `servidor_email`
MODIFY `ser_idServidor` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tipoutilizador`
--
ALTER TABLE `tipoutilizador`
MODIFY `idTipoutilizador` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `utilizador`
--
ALTER TABLE `utilizador`
MODIFY `ut_IdUtilizador` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
MODIFY `ven_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `horario`
--
ALTER TABLE `horario`
ADD CONSTRAINT `horario_ibfk_2` FOREIGN KEY (`idModalidade`) REFERENCES `modalidade` (`idModalidade`),
ADD CONSTRAINT `horario_ibfk_3` FOREIGN KEY (`diaSemana`) REFERENCES `diasemana` (`idSemana`);

--
-- Limitadores para a tabela `item_venda_produto`
--
ALTER TABLE `item_venda_produto`
ADD CONSTRAINT `item_venda_produto_ibfk_1` FOREIGN KEY (`Id_venda`) REFERENCES `venda` (`ven_id`),
ADD CONSTRAINT `item_venda_produto_ibfk_2` FOREIGN KEY (`Id_produto`) REFERENCES `produto` (`idProduto`);

--
-- Limitadores para a tabela `manutencao`
--
ALTER TABLE `manutencao`
ADD CONSTRAINT `manutencao_ibfk_1` FOREIGN KEY (`idEquipamento`) REFERENCES `equipamento` (`idEquipamento`);

--
-- Limitadores para a tabela `matricula`
--
ALTER TABLE `matricula`
ADD CONSTRAINT `matricula_ibfk_4` FOREIGN KEY (`idCliente`) REFERENCES `pessoa` (`idPessoa`),
ADD CONSTRAINT `matricula_ibfk_5` FOREIGN KEY (`idFuncionario`) REFERENCES `utilizador` (`ut_IdUtilizador`);

--
-- Limitadores para a tabela `matriculamodalidade`
--
ALTER TABLE `matriculamodalidade`
ADD CONSTRAINT `matriculamodalidade_ibfk_1` FOREIGN KEY (`idMatricula`) REFERENCES `matricula` (`idMatricula`),
ADD CONSTRAINT `matriculamodalidade_ibfk_2` FOREIGN KEY (`idModalidade`) REFERENCES `modalidade` (`idModalidade`);

--
-- Limitadores para a tabela `pagamento`
--
ALTER TABLE `pagamento`
ADD CONSTRAINT `pagamento_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `pessoa` (`idPessoa`),
ADD CONSTRAINT `pagamento_ibfk_3` FOREIGN KEY (`idFuncionario`) REFERENCES `utilizador` (`ut_IdUtilizador`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
ADD CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`funcao`) REFERENCES `funcao` (`idFuncao`);

--
-- Limitadores para a tabela `utilizador`
--
ALTER TABLE `utilizador`
ADD CONSTRAINT `utilizador_ibfk_1` FOREIGN KEY (`ut_tipoUtilizador`) REFERENCES `tipoutilizador` (`idTipoutilizador`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`pes_nome`) REFERENCES `pessoa` (`idPessoa`),
ADD CONSTRAINT `venda_ibfk_3` FOREIGN KEY (`codFunc`) REFERENCES `utilizador` (`ut_IdUtilizador`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
