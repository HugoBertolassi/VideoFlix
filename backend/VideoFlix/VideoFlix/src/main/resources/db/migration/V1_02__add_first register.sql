
insert into usuario(id, nome, email,password) values (1, 'joao' ,'joao@email.com','123456');
INSERT INTO role(id,nome) VALUES (1,'LEITURA_ESCRITA');
INSERT INTO video(id,titulo,descricao,url,ativo) VALUES (1,'Aula 1','curso que ensina as coisa','www.url.com',1);
INSERT INTO usuario_role(id,usuario_id,role_id) VALUES (1,1,1);