CREATE TABLE animal (
id_animal INTEGER PRIMARY KEY AUTO_INCREMENT,
numero INTEGER UNIQUE KEY,
brinco INTEGER UNIQUE KEY,
raca VARCHAR(50),
sexo VARCHAR(10),
idade INTEGER,
peso DECIMAL(10),
lote INTEGER,
status VARCHAR(50) NOT NULL DEFAULT 'Normal'
);

CREATE TABLE pecuarista (
id_login INTEGER PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
login VARCHAR(25) UNIQUE KEY,
senha VARCHAR(25)
);

CREATE TABLE historico (
id_historico INTEGER PRIMARY KEY AUTO_INCREMENT,
id_animal INTEGER,
numero_pai INTEGER,
numero_mae INTEGER,
vacinado VARCHAR(10),
FOREIGN KEY(id_animal) REFERENCES animal (id_animal)
);

CREATE TABLE filhote (
id_filhote INTEGER PRIMARY KEY AUTO_INCREMENT,
id_animal INTEGER,
tatuagem INTEGER UNIQUE KEY,
sexo VARCHAR(25),
vacinado VARCHAR(10),
FOREIGN KEY(id_animal) REFERENCES animal (id_animal)
);

CREATE FULLTEXT INDEX nome_index ON conbov.pecuarista(nome);
CREATE INDEX lote_index ON conbov.animal(lote);

CREATE TRIGGER increment_insert BEFORE INSERT ON animal
  FOR EACH ROW
    SET NEW.id_animal = (SELECT MAX(id_animal) + 1 FROM animal);