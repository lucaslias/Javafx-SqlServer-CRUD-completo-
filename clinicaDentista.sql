CREATE DATABASE ClinicaDentista 
GO
USE ClinicaDentista

CREATE TABLE operador(
usuario VARCHAR(50)    NOT NULL,
senha VARCHAR(50)NOT NULL,
PRIMARY KEY (usuario)
)

CREATE TABLE dentista(
id INT IDENTITY(1,1) NOT NULL,
cpf VARCHAR (25) unique,
nome VARCHAR(25) NOT NULL,
telefone VARCHAR(25) NOT NULL,
especialidade VARCHAR(30) NOT NULL
PRIMARY KEY (id)
)

CREATE TABLE cliente(
cpf VARCHAR(30) NOT NULL,
nome VARCHAR(30) NOT NULL,
telefone VARCHAR(30) NOT NULL,
enderecoRua VARCHAR(30) NOT NULL,
enderecoNum VARCHAR(30) NOT NULL,
enderecoComp VARCHAR(30),
PRIMARY KEY (cpf)
)

create table consulta(
id_consulta         int identity(1,1)        not null,
dataHora            datetime  null check(dataHora >= GETDATE()),
procedimento        varchar(150)            not null,
informações         varchar(150)            not null,
dentista_id         int                        not null,
cliente_cpf         varchar(30)                not null,
operador_usuario    varchar(50)                not null
primary key (id_consulta)
foreign key (dentista_id) references dentista(id),
foreign key (cliente_cpf) references cliente(cpf),
foreign key (operador_usuario) references operador(usuario),
)
CREATE UNIQUE INDEX idCons ON consulta(dentista_id asc, dataHora asc)

insert into operador(usuario,senha)
VALUES
('root', '12345')


select * from operador
select * from dentista
select * from cliente
select * from consulta










