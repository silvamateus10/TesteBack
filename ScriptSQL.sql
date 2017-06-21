create database TesteBack;
use TesteBack;

create table tb_customer_account(
id_customer int  primary key,
cpf_cnpj int,
nm_customer varchar(100),
is_active boolean,
vl_total double);

