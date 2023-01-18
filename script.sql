CREATE TABLE IF NOT EXISTS proveedores (id_proveedor int NOT NULL,nombre varchar(45),fecha_alta date,id_cliente int,PRIMARY KEY(id_proveedor));
INSERT INTO proveedores (id_proveedor,nombre,fecha_alta,id_cliente) 
VALUES(1,'Coca-cola','dd/mm/yyyy',5),
(2,'Pepsi','dd/mm/yyyy',5),
(3,'Redbull','dd/mm/yyyy',6);