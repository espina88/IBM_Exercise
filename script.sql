CREATE DATABASE IF NOT EXISTS ibm;
use ibm;
CREATE TABLE IF NOT EXISTS proveedores (id_proveedor int NOT NULL,nombre varchar(45),fecha_alta date,id_cliente int,PRIMARY KEY(id_proveedor));
INSERT INTO proveedores (id_proveedor,nombre,fecha_alta,id_cliente) 
VALUES(1,'Coca-cola','2021-03-02',5),
(2,'Pepsi','2022-01-02',5),
(3,'Redbull','2020-03-02',6);
