INSERT INTO usuario (id, email, senha, primeiro_nome, ultimo_nome) 
	VALUES (1, 'admin@admin.com', '$2a$10$D/Xe5w8hVzoPi0RmK9lMYOS4SsU6aWAlz1T2qZlLAWlY31Av5hvxu', 
	'Flávio', 'Barros');

INSERT INTO papel (id, nome) VALUES (1, 'ROLE_ADMIN');
INSERT INTO papel (id, nome) VALUES (2, 'ROLE_USER');

INSERT INTO usuario_papel (usuario_id, papel_id) VALUES (1, 1);

INSERT INTO fabricante (id, nome) VALUES (1, 'Apple');
INSERT INTO fabricante (id, nome) VALUES (2, 'Motorola');
INSERT INTO fabricante (id, nome) VALUES (3, 'Dell');

INSERT INTO secao (id, nome) VALUES (1, 'Celulares');
INSERT INTO secao (id, nome) VALUES (2, 'Notebooks');

INSERT INTO produto (id, nome, preco, fabricante_id) VALUES (1, 'Moto G3', 810, 2);
INSERT INTO produto (id, nome, preco, fabricante_id) VALUES (2, 'MacBook Pro', 10500, 1);
INSERT INTO produto (id, nome, preco, fabricante_id) VALUES (3, 'IPhone X', 5000, 1);
INSERT INTO produto (id, nome, preco, fabricante_id) VALUES (4, 'Inspiron', 2700, 3);

INSERT INTO secao_produto (produto_id, secao_id) VALUES (1, 1);
INSERT INTO secao_produto (produto_id, secao_id) VALUES (2, 2);
INSERT INTO secao_produto (produto_id, secao_id) VALUES (3, 1);
INSERT INTO secao_produto (produto_id, secao_id) VALUES (4, 2)