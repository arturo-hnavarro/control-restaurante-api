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