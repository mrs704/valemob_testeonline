CREATE TABLE tb_customer (
id_customer integer(20) PRIMARY KEY,
nm_customer varchar(35),
cpf_cnpj numeric
);

CREATE TABLE dm_address_type (
cd_address_type char(1) PRIMARY KEY,
ds_address_type varchar(15)
);

CREATE TABLE tb_customer_address (
id_customer_fk integer(20),
cd_address_type_fk char(1),
street varchar(40),
lot integer(10),
reference varchar(20),
zip_cod varchar(10)
foreign key (id_customer_fk) references tb_customer (id_customer),
foreign key (cd_address_type_fk) references dm_address_type (cd_address_type)
);

INSERT INTO tb_customer_address(id_customer_fk, cd_address_type_fk, street, lot, reference, zip_cod)
						VALUES(88877766655, 'c', 'Rua das Flores', 1,'',01234567);

INSERT INTO tb_customer(cpf_cnpj)
					values(12345678);

delete from tb_customer where cpf_cnpj = 12345678;