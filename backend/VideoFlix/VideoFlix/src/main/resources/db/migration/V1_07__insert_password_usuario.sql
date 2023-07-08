ALTER TABLE usuario MODIFY password VARCHAR(100);

UPDATE usuario SET password = '$2a$12$xBLEUUbvqL73zTzsnisJ1eF3h8AW7t64EYmrmNeoZb2TPZNYDqMOK' WHERE id = 1;