INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin', 'admin01', 1, 'Arturo', 'Iniesta', 'iniesta@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('user', 'user01', 1, 'José', 'Figueres', 'figueres@pac.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('cocinero', 'cocinero01', 1, 'Keneth', 'Soto', 'ksot01o@hotmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('cajero', 'cajero01', 1, 'Michael', 'Romero', 'aromero@hotmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('mesero', 'mesero01', 1, 'Lisa', 'Simpson', 'lsimpsion@yahoo.com');


INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (nombre) VALUES ('ROLE_COCINERO');
INSERT INTO `roles` (nombre) VALUES ('ROLE_CAJERO');
INSERT INTO `roles` (nombre) VALUES ('ROLE_MESERO');


INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3,3);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (4,4);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (5,5);

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

INSERT INTO `estados_platillos` (nombre, descripcion) VALUES ('habilitado','Disponible para venta');
INSERT INTO `estados_platillos` (nombre, descripcion) VALUES ('deshabilitado','Temporalmente fuera de venta');

INSERT INTO `estados_ordenes` (nombre, descripcion) VALUES ('warning','Solicitada la orden por el cliente');
INSERT INTO `estados_ordenes` (nombre, descripcion) VALUES ('primary','Lista para entregar');
INSERT INTO `estados_ordenes` (nombre, descripcion) VALUES ('success','Entregada al cliente');
INSERT INTO `estados_ordenes` (nombre, descripcion) VALUES ('info','Completada, facturada');


/* catalogo de platillos */
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('Farinata genovesa o fainá', 2500.00,  CURRENT_DATE(), 1,1, 'C:\RestauranteImagenes\farinata.jpg'); --1
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('SUPREMA (GRANDE)', 11950.00,  CURRENT_DATE(), 1,2, 'C:\RestauranteImagenes\pizza_jamon_y_queso.jpg');--2
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('SUPREMA (MEDIANA)', 9950.00,  CURRENT_DATE(), 1,2, 'C:\RestauranteImagenes\pizza_jamon_y_queso.jpg');--3
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('JAMÓN Y QUESO (GRANDE)', 11950.00,  CURRENT_DATE(), 1,2, 'C:\RestauranteImagenes\pizza_jamon_y_queso.jpg');--4
INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id, image) VALUES ('JAMÓN Y QUESO (MEDIANA)', 9950.00,  CURRENT_DATE(), 1,2, 'C:\RestauranteImagenes\pizza_jamon_y_queso.jpg');--5

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
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 4');
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 5');
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 6');
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 7');
INSERT INTO `mesas` (detalle) VALUES ('Detalle de la mesa 8');