INSERT INTO usuario (id, email, senha, primeiro_nome, ultimo_nome) 
	VALUES (1, 'admin@admin.com', '$2a$10$D/Xe5w8hVzoPi0RmK9lMYOS4SsU6aWAlz1T2qZlLAWlY31Av5hvxu', 
	'Flávio', 'Barros');

INSERT INTO papel (id, nome) VALUES (1, 'ROLE_ADMIN');
INSERT INTO papel (id, nome) VALUES (2, 'ROLE_USER');

INSERT INTO usuario_papel (usuario_id, papel_id) VALUES (1, 1);