CREATE TABLE usuario(
        id bigint NOT NULL AUTO_INCREMENT,
        nome VARCHAR(50) NOT NULL,
        email VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL,
        primary key(id)
);

CREATE TABLE role(
        id bigint NOT NULL AUTO_INCREMENT,
        nome varchar(50),
        primary key(id)
);

CREATE TABLE video(
        id bigint AUTO_INCREMENT,
        titulo varchar(50) NOT NULL,
        descricao varchar(200) NOT NULL,
        url varchar(50) NOT NULL,
        ativo bigint,
        primary key(id)
);

CREATE TABLE usuario_role(
    id BIGINT NOT NULL AUTO_INCREMENT,
    usuario_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuario (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);
