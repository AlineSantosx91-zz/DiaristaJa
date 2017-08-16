CREATE TABLE User (
	Id INT AUTO_INCREMENT NOT NULL,
	UUID VARCHAR(255),
	Created TIMESTAMP,
	Active BOOLEAN,
	Email VARCHAR(255) NOT NULL UNIQUE,
	Password VARCHAR(255),
	DDD_1 VARCHAR(2),
	Numero_1 VARCHAR(9),
	DDD_2 VARCHAR(2),
	Numero_2 VARCHAR(9),
	Last_Login TIMESTAMP,
	Modified TIMESTAMP,
	Token VARCHAR(255),
	Endereco_Id INT,

	PRIMARY KEY (Id)
);

CREATE TABLE Diarista (
	Id INT AUTO_INCREMENT NOT NULL,
	Nome VARCHAR(255),
	Documento VARCHAR(255) NOT NULL UNIQUE,
	Data_Nascimento TIMESTAMP,
	Valor_Minimo_Diaria FLOAT,
	Valor_Maximo_Diaria FLOAT,
	PRIMARY KEY (Documento)
--	FOREIGN KEY (Id) REFERENCES User(Id)

);

CREATE TABLE Endereco (
	Id INT AUTO_INCREMENT NOT NULL,
	UUID VARCHAR(255),
	Created TIMESTAMP,
	Active BOOLEAN,
	Endereco VARCHAR(255),
	Referencia VARCHAR(255),
	Numero VARCHAR(255),
	Cidade VARCHAR(255),
	Estado VARCHAR(255),
	Cep VARCHAR(255),
	Latitude VARCHAR(255),
	Longitude VARCHAR(255),
	User_Id INT,
	PRIMARY KEY (Id)
);

CREATE TABLE Diaria (
	Id INT AUTO_INCREMENT NOT NULL,
	UUID VARCHAR(255),
	Created TIMESTAMP,
	Active BOOLEAN,
	Data_Diaria TIMESTAMP,
	Endereco_Id INT,
	Valor FLOAT,
	Documento_Cliente VARCHAR(255),
	Documento_Diarista VARCHAR(255),
	Status VARCHAR(255),
	PRIMARY KEY (Id)
);

CREATE TABLE Restricao (
	Id INT AUTO_INCREMENT NOT NULL,
	UUID VARCHAR(255),
	Created TIMESTAMP,
	Active BOOLEAN,
	Nome VARCHAR(255),
	PRIMARY KEY (Id)
);

CREATE TABLE Diarista_Restricao(
 	Id_Diarista INT,
 	Id_Restricao INT
);


insert 
    into
        Endereco
        (active, created, uuid, cep, cidade, endereco, estado, latitude, longitude, numero, referencia) 
    values
        (true, '2017-05-21', '0001', '05051000', 'São Paulo', 'R. Tito', 'São Paulo', '-23.5280038', '-46.6939981', '54', 1);

insert 
    into
        user
        (active, created, uuid, ddd_1, ddd_2, email, endereco_id, last_login, modified, numero_1, numero_2, password, token) 
    values
        (true, '2017-05-21', '0001', '11', null, 'edilmasilvasouza@gmail.com', 1, null, null, '955554444', null, '123', null);
        
insert 
    into
        diarista
        (data_nascimento, documento, nome, valor_maximo_diaria, valor_minimo_diaria) 
    values
        ('1991-11-20', '0001', 'Edilma Silva Souza', '300', '150');
        
UPDATE endereco
	SET user_id = 1
		WHERE id = 1;
    
--SEPARACAO
    
insert 
    into
        Endereco
        (active, created, uuid, cep, cidade, endereco, estado, latitude, longitude, numero, referencia) 
    values
        (true, '2017-05-21', '0002', '03381050', 'São Paulo', 'Travessa Itaperum', 'São Paulo', '-23.60063', '-46.557312', '1414', 2);

insert 
    into
        user
        (active, created, uuid, ddd_1, ddd_2, email, endereco_id, last_login, modified, numero_1, numero_2, password, token) 
    values
        (true, '2017-05-21', '0002', '11', null, 'GiovannaAzevedoPinto@dayrep.com', 2, null, null, '94236448', null, '1215', null);
        
insert 
    into
        diarista
        (data_nascimento, documento, nome, valor_maximo_diaria, valor_minimo_diaria) 
    values
        ('1996-10-30', '0002', 'Giovanna Azevedo Pinto', '200', '120');
        
UPDATE endereco
	SET user_id = 2
		WHERE id = 2;
        
--SEPARACAO
    
insert 
    into
        Endereco
        (active, created, uuid, cep, cidade, endereco, estado, latitude, longitude, numero, referencia) 
    values
        (true, '2017-05-21', '0003', '05409-120', 'São Paulo', 'Viaduto Doutor João Tranchesi', 'São Paulo', '-23.584358', '-46.594635', '1923', 3);

insert 
    into
        user
        (active, created, uuid, ddd_1, ddd_2, email, endereco_id, last_login, modified, numero_1, numero_2, password, token) 
    values
        (true, '2017-05-21', '0003', '11', null, 'RebecaSantosSouza@teleworm.us', 3, null, null, '7727-6842', null, '5654', null);
        
insert 
    into
        diarista
        (data_nascimento, documento, nome, valor_maximo_diaria, valor_minimo_diaria) 
    values
        ('1939-02-04', '0003', 'Rebeca Silva Ferreira', '50', '80');
        
UPDATE endereco
	SET user_id = 3
		WHERE id = 3;
		
		
 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0001', 'Passar roupa');
        

 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0002', 'Lavar roupa');		
        
        
 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0003', 'Passear com animais');

 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0004', 'Cuidar de crianças');

 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0005', 'Cozinhar');
        
 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0006', 'Limpar vidros');
        
        
 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0007', 'Lavar louça');

 
 insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0008', 'Lavar carro');
        
  insert 
    into
        restricao
		(active, created, uuid, nome)  
    values
        (true, '2017-05-21', '0009', 'Compras de supermercado');
        
insert 
    into
        diarista_restricao
        (id_diarista, id_restricao) 
    values
        (1, 1);
        
        
insert 
    into
        diarista_restricao
        (id_diarista, id_restricao) 
    values
        (1, 4);     
        
        
insert 
    into
        diarista_restricao
        (id_diarista, id_restricao) 
    values
        (3, 4); 
        
        
insert 
    into
        diarista_restricao
        (id_diarista, id_restricao) 
    values
        (3, 1); 

