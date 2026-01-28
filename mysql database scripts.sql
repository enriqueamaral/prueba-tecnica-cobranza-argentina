create database inventario;

create table productos (
	id int auto_increment primary key,
    sku varchar(50) not null unique,
    nombre varchar(150) not null,
    precio decimal(10,2) not null check (precio >= 0),
    cantidad int not null check (cantidad >= 0)
);

insert into productos (sku, nombre, precio, cantidad)
values (11, 'Producto prueba 01', 100, 5);
insert into productos (sku, nombre, precio, cantidad)
values (20, 'Producto prueba 02', 200, 6);
insert into productos (sku, nombre, precio, cantidad)
values (30, 'Producto prueba 03', 300, 7);
insert into productos (sku, nombre, precio, cantidad)
values (40, 'Producto prueba 04', 400, 8);
insert into productos (sku, nombre, precio, cantidad)
values (50, 'Producto prueba 05', 500, 9);
insert into productos (sku, nombre, precio, cantidad)
values (60, 'Producto prueba 06', 600, 10);

create table users (
	id int auto_increment primary key,
    user_name varchar(50) not null unique,
    user_password varchar(15) not null
);

create table roles (
	id int auto_increment primary key,
	roles varchar(15) not null
);