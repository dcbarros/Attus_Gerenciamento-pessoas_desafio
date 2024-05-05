-- Adiciona pessoas
INSERT INTO person (uuid, name, birthday, is_active, created_at, updated_at)
VALUES 
    ('a4dc47fc-32e0-4a84-baa6-647cfe014e65', 'João', '1990-05-15', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('d7b04e67-1312-4c68-a8ed-36b17052c6b0', 'Maria', '1985-09-20', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('f98d81fc-9c3a-4fb4-8bcf-6b2d81c19b94', 'Pedro', '1982-07-10', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Adiciona endereços
INSERT INTO address (cep, public_place, number, city, state, is_principal, person_id)
VALUES 
    ('12345678', 'Rua A', 100, 'São Paulo', 'SP', true, 1),
    ('87654321', 'Avenida B', 200, 'Rio de Janeiro', 'RJ', false, 1),
    ('11111111', 'Rua C', 300, 'Curitiba', 'PR', true, 2),
    ('22222222', 'Avenida D', 400, 'Porto Alegre', 'RS', false, 2),
    ('33333333', 'Rua E', 500, 'Belo Horizonte', 'MG', true, 3);