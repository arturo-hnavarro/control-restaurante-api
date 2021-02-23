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

INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Harina de garbanzo', 200);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Agua', 2000);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Aceite de oliva virgen extra', 200);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Sal', 200);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Pimienta negra', 200);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Ajo granulado', 220);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Oregano', 200);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Queso', 200);
INSERT INTO `catalogo_ingredientes` (nombre, cantidad_disponible) VALUES ('Tomillo', 200);


INSERT INTO `tipo_platos` (nombre, descripcion) VALUES ('Libre de gluten','Deliciosos platillos libres de gluten.');

INSERT INTO `estados_platillos` (nombre, descripcion) VALUES ('habilitado','Disponible para venta.');
INSERT INTO `estados_platillos` (nombre, descripcion) VALUES ('deshabilitado','Temporalmente fuera de venta.');

INSERT INTO `platillos` (nombre, precio, create_at, estado_id, tipo_id) VALUES ('Farinata genovesa o fainá', 2500.00,  CURRENT_DATE(), 1,1);

INSERT INTO `platillos_ingredientes` (platillo_id, ingrediente_id) VALUES (1,2);
