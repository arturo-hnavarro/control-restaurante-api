INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('arturo', '123456', 1, 'Arturo', 'Hernandez Navarro', 'hernandezn.arturo@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('turo', '123456', 1, 'José', 'Hernandez Navarro', 'turo.arturo@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('keneth', 'abcd', 1, 'Keneth', 'Blandon Ramirez', 'kblandon_91@hotmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('sotico', 'sotico', 1, 'Alejando', 'Sotico', 'sotico@hotmail.com');


INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (nombre) VALUES ('ROLE_COCINERO');
INSERT INTO `roles` (nombre) VALUES ('ROLE_CAJERO');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3,3);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (4,4);

INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Harina de garbanzo', 200); --1
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Agua', 2000); --2
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Aceite de oliva virgen extra', 200); --3
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Sal', 200);--4
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Pimienta negra', 200);--5
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Ajo granulado', 220);--6
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Oregano', 200);--7
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Queso', 200);--8
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Jamón', 200);--9
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Tomillo', 200);--10
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Pepperoni', 200);--11
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Carne de res.', 1200);--12
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Carne de cerdo.', 200);--13
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Chile dulce.', 20);--14
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Hondos.', 2250);--15
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Cebolla.', 2250);--16


INSERT INTO `tipo_platos` (nombre, descripcion) VALUES ('Libre de gluten','Deliciosos platillos libres de gluten.');
INSERT INTO `tipo_platos` (nombre, descripcion) VALUES ('Pizzas','Deliciosos pizzas con los sabores más frescos.');

INSERT INTO `estados_platillos` (nombre, descripcion) VALUES ('habilitado','Disponible para venta.');
INSERT INTO `estados_platillos` (nombre, descripcion) VALUES ('deshabilitado','Temporalmente fuera de venta.');
INSERT INTO `estados_platillos` (nombre, descripcion) VALUES ('solicitada','Solicitada la orden por el cliente.');

/* catalogo de platillos */
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('Farinata genovesa o fainá', 2500.00,  CURRENT_DATE(), 1,1, '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'); --1
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('SUPREMA (GRANDE)', 11950.00,  CURRENT_DATE(), 1,2, 'https://lh3.googleusercontent.com/proxy/jmb2laIqDudagRK-Xw2L2UXp5WeuAccddQ4CLRB2uzdpjyBtEAntpRewsT7oj_t1_2FsdzFBmMKZ5ijCjckXiTwerB-qEmQxihG4pau4rVC7-HSgCaYr1wT4ki7nzGuOnXM');--2
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('SUPREMA (MEDIANA)', 9950.00,  CURRENT_DATE(), 1,2, 'https://lh3.googleusercontent.com/proxy/jmb2laIqDudagRK-Xw2L2UXp5WeuAccddQ4CLRB2uzdpjyBtEAntpRewsT7oj_t1_2FsdzFBmMKZ5ijCjckXiTwerB-qEmQxihG4pau4rVC7-HSgCaYr1wT4ki7nzGuOnXM');--3
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('JAMÓN Y QUESO (GRANDE)', 11950.00,  CURRENT_DATE(), 1,2, 'https://www.laespanolaaceites.com/wp-content/uploads/2019/06/pizza-con-chorizo-jamon-y-queso-1080x671.jpg');--4
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('JAMÓN Y QUESO (MEDIANA)', 9950.00,  CURRENT_DATE(), 1,2, 'https://www.laespanolaaceites.com/wp-content/uploads/2019/06/pizza-con-chorizo-jamon-y-queso-1080x671.jpg');--5

INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (1,2);

INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (2,11);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (2,12);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (2,13);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (2,14);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (2,15);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (2,16);

INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (3,11);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (3,12);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (3,13);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (3,14);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (3,15);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (3,16);

INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (4,9);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (4,8);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (5,9);
INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (5,8);


/*Ordenes*/
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 1');
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 2 en la Terraza');
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 3 para dos personas');
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 4 barra');