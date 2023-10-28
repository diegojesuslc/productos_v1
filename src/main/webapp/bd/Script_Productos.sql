create schema proyectopi;
use proyectopi;

create table categoria(
id_cat int primary key auto_increment not null,
nombre_cat varchar(100) not null,
desc_cat varchar(200) not null
);
create table productos(
id_prod int primary key auto_increment not null,
nombre_prod varchar(100) not null,
id_cat int not null,
des_prod varchar(200) not null,
imagen varchar(200) not null,
precio double not null,
calificacion double not null,
foreign key (id_cat) references categoria (id_Cat)
);

-- Insertar datos en la tabla "categoria"
INSERT INTO categoria (nombre_cat, desc_cat)
VALUES
    ('Antivirus', 'Software de seguridad para proteger tu computadora'),
    ('Diseño Gráfico', 'Herramientas de diseño para profesionales creativos'),
    ('Productividad', 'Software de oficina para aumentar la eficiencia laboral'),
    ('Desarrollo Web', 'Herramientas para crear aplicaciones web y sitios web'),
    ('Sistemas Operativos', 'Sistemas operativos para computadoras');

-- Insertar datos en la tabla "productos"
INSERT INTO productos (nombre_prod, id_cat, des_prod, imagen, precio, calificacion)
VALUES
    ('Microsoft Office 365', 3, 'Suite de productividad de Microsoft', 'office365.jpg', 99.99, 4.5),
    ('Adobe Photoshop', 2, 'Software de edición de imágenes', 'photoshop.jpg', 199.99, 4.8),
    ('Norton Antivirus', 1, 'Protección antivirus para tu computadora', 'norton.jpg', 49.99, 4.2),
    ('Sublime Text', 4, 'Editor de texto para programación', 'sublime.jpg', 79.99, 4.6),
    ('Windows 10', 5, 'Sistema operativo de Microsoft', 'windows10.jpg', 139.99, 4.7);
    INSERT INTO productos (id_prod,nombre_prod, id_cat, des_prod, imagen, precio, calificacion)
VALUES
    (5,'Windows 10', 5, 'Sistema operativo de Microsoft', 'windows10.jpg', 139.99, 4.7);

select * from categoria;
select * from productos;

--
-- Listar Productos
--
DELIMITER $$
CREATE PROCEDURE ListarProductos()
BEGIN
    SELECT
        p.id_prod,
        p.nombre_prod,
        c.nombre_cat AS categoria,
        p.des_prod,
        p.imagen,
        p.precio,
        p.calificacion
    FROM
        productos p
    JOIN
        categoria c ON p.id_cat = c.id_cat;
END $$
DELIMITER ;
--
call ListarProductos; 
--
-- Insertar producto
--
DELIMITER $$
CREATE PROCEDURE InsertarProducto(
    IN nombre_producto VARCHAR(100),
    IN id_categoria INT,
    IN descripcion VARCHAR(200),
    IN imagen VARCHAR(200),
    IN precio DOUBLE,
    IN calificacion DOUBLE
)
BEGIN
    INSERT INTO productos (nombre_prod, id_cat, des_prod, imagen, precio, calificacion)
    VALUES (nombre_producto, id_categoria, descripcion, imagen, precio, calificacion);
END $$
DELIMITER ;
--
call InsertarProducto(); 
--
-- Actualizar producto
--
DELIMITER $$
CREATE PROCEDURE ActualizarProducto(
    IN producto_id INT,
    IN nombre_producto VARCHAR(100),
    IN id_categoria INT,
    IN descripcion VARCHAR(200),
    IN imagen VARCHAR(200),
    IN precio DOUBLE,
    IN calificacion DOUBLE
)
BEGIN
    UPDATE productos
    SET nombre_prod = nombre_producto,
        id_cat = id_categoria,
        des_prod = descripcion,
        imagen = imagen,
        precio = precio,
        calificacion = calificacion
    WHERE id_prod = producto_id;
END $$
DELIMITER ;
--
CALL ActualizarProducto();
--
-- Eliminar Producto
--
DELIMITER $$
CREATE PROCEDURE EliminarProducto(
    IN producto_id INT
)
BEGIN
    DELETE FROM productos
    WHERE id_prod = producto_id;
END $$
DELIMITER ;
--
CALL EliminarProducto();
--
-- Buscar por ID
--
DELIMITER $$
CREATE PROCEDURE BuscarProductoPorID(
    IN producto_id INT
)
BEGIN
    SELECT
        id_prod,
        nombre_prod,
        id_cat,
        des_prod,
        imagen,
        precio,
        calificacion
    FROM
        productos
    WHERE
        id_prod = producto_id;
END $$
DELIMITER ;
--
CALL BuscarProductoPorID(1);
--
-- Buscar por Categoria
--
DELIMITER $$
CREATE PROCEDURE BuscarProductosPorCategoria(
    IN categoria_id INT
)
BEGIN
    SELECT
        id_prod,
        nombre_prod,
        id_cat,
        des_prod,
        imagen,
        precio,
        calificacion
    FROM
        productos
    WHERE
        id_cat = categoria_id;
END $$
DELIMITER ;
--
CALL BuscarProductosPorCategoria(1);
