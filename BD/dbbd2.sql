
CREATE SCHEMA IF NOT EXISTS dbbd2;

-- -----------------------------------------------------
-- Table `dbbd2`.`tbgerente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tbgerente (
  ger_codigo INT NOT NULL UNIQUE,
  ger_nome VARCHAR(50) NOT NULL,
  ger_cpf BIGINT NOT NULL UNIQUE,
  ger_tel BIGINT NULL DEFAULT NULL,
  ger_senha VARCHAR(15) NOT NULL,
  ger_email VARCHAR(50) NOT NULL,
  PRIMARY KEY (ger_codigo));

-- -----------------------------------------------------
-- Table `dbbd2`.`tbproduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tbproduto (
  prod_codigo INT NOT NULL UNIQUE,
  prod_nome VARCHAR(50) NOT NULL,
  prod_descricao VARCHAR(300) NULL DEFAULT NULL,
  prod_preco DECIMAL(10,2) NOT NULL,
  prod_marca VARCHAR(20) NOT NULL,
  prod_categoria VARCHAR(20) NOT NULL,
  prod_modelo VARCHAR(20) NOT NULL,
  ger_codigo INT NOT NULL,
  prod_caddate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  prod_fornecedor VARCHAR(50) NOT NULL,
  PRIMARY KEY (prod_codigo),
  CONSTRAINT tbproduto_ibfk_1
    FOREIGN KEY (ger_codigo)
    REFERENCES tbgerente (ger_codigo));

-- -----------------------------------------------------
-- Table `dbbd2`.`tbestoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tbestoque(
  est_quantidadeprod INT NOT NULL,
  ger_codigo INT NOT NULL,
  est_codigo SERIAL,
  prod_codigo INT NOT NULL,
  est_alteracaodate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (est_codigo),
  CONSTRAINT tbestoque_ibfk_2
    FOREIGN KEY (ger_codigo)
    REFERENCES tbgerente (ger_codigo),
  CONSTRAINT tbestoque_ibfk_3
    FOREIGN KEY (prod_codigo)
    REFERENCES tbproduto (prod_codigo));

-- -----------------------------------------------------
-- Table `dbbd2`.`tbrelatorioestoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tbrelatorioestoque (
  idRelEst SERIAL,
  prod_caddate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  prod_codigo INT NOT NULL,
  prod_nome VARCHAR(50) NOT NULL,
  est_quantidadeprod INT NOT NULL,
  est_codigo INT NOT NULL,
  ger_codigo INT NOT NULL,
  ger_nome VARCHAR(50) NOT NULL,
  PRIMARY KEY (idRelEst),
  CONSTRAINT fk_relatorioEst_1
    FOREIGN KEY (prod_codigo)
    REFERENCES tbproduto (prod_codigo),
  CONSTRAINT fk_relatorioEst_2
    FOREIGN KEY (est_codigo)
    REFERENCES tbestoque (est_codigo),
  CONSTRAINT fk_relatorioEst_3
    FOREIGN KEY (ger_codigo)
    REFERENCES tbgerente (ger_codigo));

-- -----------------------------------------------------
-- Table `dbbd2`.`tbrelatorioprod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tbrelatorioprod (
  idRel SERIAL,
  prod_codigo INT NOT NULL,
  prod_nome VARCHAR(50) NOT NULL,
  prod_descricao VARCHAR(300) NOT NULL,
  prod_preco DECIMAL(10,2) NOT NULL,
  prod_marca VARCHAR(20) NOT NULL,
  prod_categoria VARCHAR(20) NOT NULL,
  prod_modelo VARCHAR(20) NOT NULL,
  ger_codigo INT NOT NULL,
  ger_nome VARCHAR(50) NOT NULL,
  prod_caddate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  prod_fornecedor VARCHAR(50) NOT NULL,
  PRIMARY KEY (idRel),
  CONSTRAINT fk_relatorio_1
    FOREIGN KEY (ger_codigo)
    REFERENCES tbgerente (ger_codigo),
  CONSTRAINT fk_relatorio_2
    FOREIGN KEY (prod_codigo)
    REFERENCES tbproduto (prod_codigo));
	

CREATE FUNCTION after_INSERTorUPDATEtbprod() RETURNS TRIGGER AS $$
BEGIN
	insert into tbrelatorioprod (prod_codigo,prod_nome,prod_descricao,prod_preco,prod_marca,
    prod_categoria,prod_modelo,prod_fornecedor,ger_codigo,ger_nome) values (new.prod_codigo,
    new.prod_nome,new.prod_descricao,new.prod_preco,new.prod_marca,new.prod_categoria,new.prod_modelo,
    new.prod_fornecedor,new.ger_codigo,(select tbgerente.ger_nome from tbgerente 
    where tbgerente.ger_codigo = new.ger_codigo));
END;
$$ language 'plpgsql';

CREATE TRIGGER after_INSERTorUPDATEtbprod AFTER INSERT OR UPDATE
ON tbproduto FOR EACH ROW EXECUTE PROCEDURE after_INSERTorUPDATEtbprod();


CREATE FUNCTION before_DELETEtbprod() RETURNS TRIGGER AS $$
BEGIN
	insert into tbrelatorioprod (prod_codigo,prod_nome,prod_descricao,prod_preco,prod_marca,
    prod_categoria,prod_modelo,prod_fornecedor,ger_codigo,ger_nome) values (OLD.prod_codigo,
    OLD.prod_nome,OLD.prod_descricao,OLD.prod_preco,OLD.prod_marca,OLD.prod_categoria,OLD.prod_modelo,
    OLD.prod_fornecedor,OLD.ger_codigo,(select tbgerente.ger_nome from tbgerente
    where tbgerente.ger_codigo = OLD.ger_codigo));
END;
$$ language 'plpgsql';

CREATE TRIGGER before_DELETEtbprod BEFORE DELETE
ON tbproduto FOR EACH ROW EXECUTE PROCEDURE before_DELETEtbprod();


CREATE FUNCTION after_UPDATEtbest() RETURNS TRIGGER AS $$
BEGIN
	insert into tbrelatorioestoque (prod_codigo,prod_nome,est_quantidadeprod,est_codigo,
    ger_codigo,ger_nome) values (new.prod_codigo,(select tbproduto.prod_nome 
    from tbproduto where tbproduto.prod_codigo = new.prod_codigo)
    ,new.est_quantidadeprod,new.est_codigo,new.ger_codigo,(select tbgerente.ger_nome from tbgerente 
    where tbgerente.ger_codigo = new.ger_codigo));
END;
$$ language 'plpgsql';

CREATE TRIGGER after_UPDATEtbest AFTER UPDATE
ON tbestoque FOR EACH ROW EXECUTE PROCEDURE after_UPDATEtbest();