-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;


INSERT INTO endereco(numero, cep, cidade, estado, logradouro, nome, bairro, complemento)
VALUES 
    (123, '77000-000', 'Palmas', 'TO', 'Rua das Flores', 'Casa Azul', 'Centro', 'kitnet 4'),
    (456, '77001-001', 'Gurupi', 'TO', 'Avenida dos Bandeirantes', 'Casa Verde', 'Jardim Bela Vista', 'Esquina com a Rua Principal'),
    (789, '77002-002', 'Araguaína', 'TO', 'Travessa das Oliveiras', 'Casa Amarela', 'Setor Norte', 'Ao lado da praça'),
    (101, '77003-003', 'Porto Nacional', 'TO', 'Rua das Águias', 'Casa Vermelha', 'Centro', 'Próximo à Escola Municipal'),
    (202, '77004-004', 'Paraíso do Tocantins', 'TO', 'Avenida das Rosas', 'Casa Rosa', 'Jardim Primavera', 'Próximo ao Supermercado'),
    (303, '77005-005', 'Colinas do Tocantins', 'TO', 'Alameda dos Ipês', 'Casa Lilás', 'Centro', 'Ao lado do Banco do Brasil'),
    (124, '77006-006', 'Palmas', 'TO', 'Rua das Flores', 'Casa Azul', 'Centro', 'kitnet 4'),
    (457, '77007-007', 'Gurupi', 'TO', 'Avenida dos Bandeirantes', 'Casa Verde', 'Jardim Bela Vista', 'Esquina com a Rua Principal'),
    (790, '77008-008', 'Araguaína', 'TO', 'Travessa das Oliveiras', 'Casa Amarela', 'Setor Norte', 'Ao lado da praça'),
    (102, '77009-009', 'Porto Nacional', 'TO', 'Rua das Águias', 'Casa Vermelha', 'Centro', 'Próximo à Escola Municipal'),
    (203, '770100', 'Paraíso do Tocantins', 'TO', 'Avenida das Rosas', 'Casa Rosa', 'Jardim Primavera', 'Próximo ao Supermercado'),
    (304, '770111', 'Colinas do Tocantins', 'TO', 'Alameda dos Ipês', 'Casa Lilás', 'Centro', 'Ao lado do Banco do Brasil');


INSERT INTO cliente (
    numeroregistro_posse_porte, cpf, nome, email, listatelefones
)
VALUES
    ('1234567890', '111.111.111-11', 'André', 'andre@example.com', '{"1234567890", "9876543210"}'),
    ('2345678901', '222.222.222-22', 'Bene', 'bene@example.com', '{"1234567891", "9876543211"}'),
    ('3456789012', '333.333.333-33', 'Hirosh', 'hirosh@example.com', '{"1234567892", "9876543212"}'),
    ('4567890123', '444.444.444-44', 'Heitor', 'heitor@example.com', '{"1234567893", "9876543213"}'),
    ('5678901234', '555.555.555-55', 'Henrique', 'henrique@example.com', '{"1234567894", "9876543214"}'),
    ('6789012345', '666.666.666-66', 'Junin', 'junin@example.com', '{"1234567895", "9876543215"}'),
    ('7890123456', '777.777.777-77', 'Maria do Socorro', 'maria@example.com', '{"1234567896", "9876543216"}'),
    ('8901234567', '888.888.888-88', 'Aline', 'aline@example.com', '{"1234567897", "9876543217"}'),
    ('9012345678', '999.999.999-99', 'Fernanda', 'fernanda@example.com', '{"1234567898", "9876543218"}');

INSERT INTO acabamento(material)
VALUES
    ('Madeira'),
    ('Cromado'),
    ('Ouro'),
    ('Diamante'); 

INSERT INTO calibre(calibre)
VALUES
    ('.357 Magnum'),
    ('5.56mm'),
    ('9mm'),
    ('7.62mm NATO');    

INSERT INTO arma(
	capacidadedetiro, preco, qtdnoestoque, tipo_arma, modelo, numerosigma, comprimentodocano,
    id_acabamento, marca, nome, descricao, id_calibre, numerodaarma, registro_nacional_armas)
VALUES
    (15, 2000.00, 30, 1, 'Smith & Wesson Model 686', 'SW686-001', '6"', 1, 'Smith & Wesson', 'Revólver .357 Magnum', 'Um revólver clássico, conhecido por sua confiabilidade e precisão.', 1, 'SW001', 'RN001'),
    (30, 1500.00, 20, 4, 'Colt AR-15', 'COLTAR15-002', '16"', 1, 'Colt', 'Rifle AR-15', 'Um rifle semiautomático, amplamente utilizado para esportes de tiro e caça.', 2, 'COLT002', 'RN002'),
    (8, 800.00, 25, 2, 'Glock 19', 'GLOCK19-003', '4"', 2, 'Glock', 'Pistola Glock 19', 'Uma pistola compacta, popular entre forças policiais e civis.', 4, 'GLK003', 'RN003'),
    (5, 1200.00, 15, 7, 'Remington 870', 'REM870-004', '24"', 1, 'Remington', 'Escopeta Remington 870', 'Uma escopeta de bombeamento clássica, amplamente utilizada para caça e defesa.', 3, 'REM004', 'RN004'),
    (20, 1800.00, 10, 5, 'Springfield M1A', 'SPFM1A-005', '18"', 3, 'Springfield Armory', 'Carabina Springfield M1A', 'Uma carabina semiautomática, derivada do M14, conhecida por sua precisão.', 4, 'SPF005', 'RN005'),
    (25, 2500.00, 12, 6, 'Heckler & Koch MP5', 'HKMP5-006', '10"', 2, 'Heckler & Koch', 'Submetralhadora MP5', 'Uma submetralhadora compacta, amplamente utilizada por forças policiais e militares em todo o mundo.', 1, 'HCK006', 'RN006'),
    (30, 3500.00, 8, 8, 'FN SCAR', 'FNSCAR-007', '20"', 2, 'FN Herstal', 'Fuzil FN SCAR', 'Um fuzil de assalto moderno e versátil, utilizado por forças especiais em todo o mundo.', 2, 'FNS007', 'RN007'),
    (6, 1000.00, 18, 1, 'Smith & Wesson Model 637', 'SW637-008', '4"', 3, 'Smith & Wesson', 'Revólver .38 Special', 'Um revólver compacto, ideal para uso como arma de backup ou defesa pessoal.', 3, 'SW002', 'RN008');


INSERT INTO funcionario (matricula, cpf, telefone, nome, email)
VALUES
    ('123456', '111.111.111-11', '123456789', 'Daniel', 'daniel@example.com'),
    ('789012', '222.222.222-22', '987654321', 'Jacare', 'jacare@example.com');

INSERT INTO usuario (perfil, login, senha)
VALUES 
-- senha_cliente_andre
    (1, 'cliente_andre', '/GOjHgpptfKVaR92/cXMp7sJi0raFpcUWzVNZj5jjwjx0Z/oi19lZx6/v+f6nOpnnYLb9fg9vGw8pUWW08ekUw=='),
-- senha_cliente_bene
    (1, 'cliente_bene', 'tHg5Av764hOiw2peQgpDxMBsweO2HAsg4znQ5kxtcNMz/vPhKldRslxOL53tWghnqAQzna1E80x6CkNJbLT/kQ=='),
-- senha_cliente_hirosh
    (1, 'cliente_hirosh', 'a55M/kc9MqJFbtr5FGF6Ru8LZSwm36pYubnZZMvyox3Tyg8wOt7NZEDKUAIqr/NFejO6r8R+eUj0NvLLlgyl2Q=='),
-- senha_cliente_heitor
    (1, 'cliente_heitor', 'bbkoG72xCIeM+5TONI15VERApwynQf256JHHvX6bkAve00r43+cXaOOVLBYk/Q3xnnjce/7/jsvSaTOHB8RadQ=='),
-- senha_cliente_henrique
    (1, 'cliente_henrique', 'VobPCVa6t0EWSzXmvjNz/1iyKtcnISau1orzafq2UZEflPtvY9IjE/XCSg4Eccw/ifM14KsdoqWy+ag1r0OWFg=='),
-- senha_cliente_junin
    (1, 'cliente_junin', 'dsBjbU2BWnA/oQtxfZ7WLv3/Wdb4vRRb+YzXqHw+qJMuZ3rUoZKX0nWOvsp+r12ZZnhNriIxNsrIS/L2ROm1Ag=='),
-- senha_cliente_maria
    (1, 'cliente_maria', 'gQvX0a7+KxRYbi5K/1hDHzq32iNHUZHwYkF2ok22XL6MJ2SvWLZlduiM8D4UZdP57jvpyU89CSiFKinzIjXw1g=='),
-- senha_cliente_aline
    (1, 'cliente_aline', 'pzn74eUzJBP32jVsBmOpL50OTrZVgI9VBF7jKLXKKkAsGRfpqnaKblr696yAzh/1ALEyuVAkmOWVyXZzDGu+SQ=='),
-- senha_cliente_fernanda
    (1, 'cliente_fernanda', 'GJT+Wolwvp3TaibJtfTCixQ6mXbWOH6Y5M3FWOYCN0Twh+kdjIn5wSD0eVKjqQbhdiue9w8mRPRgbquvOBp3fw=='),
-- senha_funcionario_daniel
    (2, 'funcionario_daniel', 'gz92jkTcveMCL5phxX4m8vcDbE7IwdfMYLEbCFjsd55e89YZ8XlOte2oYZKk9l+UgIR94tyzIt1wyI22/K1sdg=='),
-- senha_funcionario_jacare
    (2, 'funcionario_jacare', '/1TvZJJL/8eyuJ8ktCm35K2ShjAQYM9dPzdDUwU8Fk2S5UMQlZ+AJI6ruk/VRwEB+6LISFzdAOVVQvhl0Owc3w==');


INSERT INTO cliente_usuario (id_cliente, id_usuario)
VALUES 
    -- Cliente André
    (1, 1),
    -- Cliente Bene
    (2, 2),
    -- Cliente Hirosh
    (3, 3),
    -- Cliente Heitor
    (4, 4),
    -- Cliente Henrique
    (5, 5),
    -- Cliente Junin
    (6, 6),
    -- Cliente Maria do Socorro
    (7, 7),
    -- Cliente Aline
    (8, 8),
    -- Cliente Fernanda
    (9, 9);

INSERT INTO funcionario_usuario (id_funcionario, id_usuario)
VALUES 
    -- Funcionário Daniel
    (1, 10),
    -- Funcionário Jacare
    (2, 11);

INSERT INTO cliente_endereco (id_cliente, id_endereco)
VALUES 
    -- Cliente André
    (1, 1),
    -- Cliente Bene
    (2, 2),
    -- Cliente Hirosh
    (3, 3),
    -- Cliente Heitor
    (4, 4),
    -- Cliente Henrique
    (5, 5),
    -- Cliente Junin
    (6, 6),
    -- Cliente Maria do Socorro
    (7, 7),
    -- Cliente Aline
    (8, 8),
    -- Cliente Fernanda
    (9, 9);

INSERT INTO funcionario_endereco (id_endereco, id_funcionario)
VALUES 
    -- Funcionário Daniel
    (10, 1),
    -- Funcionário Jacare
    (11, 2);