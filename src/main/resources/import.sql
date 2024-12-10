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
    ('Diamante'),
    ('Prata'),
    ('Bronze'),
    ('Níquel'),
    ('Latão'),
    ('Aço escovado'),
    ('Anodizado'),
    ('Pintura fosca'),
    ('Pintura brilhante'),
    ('Texturizado'),
    ('Envernizado'),
    ('PVD');

INSERT INTO calibre(calibre)
VALUES
    ('.357 Magnum'),
    ('5.56mm'),
    ('9mm'),
    ('7.62mm NATO'),
    ('.45 ACP'),
    ('.40 S&W'),
    ('.22 LR'),
    ('.308 Winchester'),
    ('.50 BMG'),
    ('6.5mm Creedmoor'),
    ('10mm Auto'),
    ('.380 ACP'),
    ('.44 Magnum'),
    ('.223 Remington'),
    ('.300 Blackout');

INSERT INTO material(material)
VALUES
    ('Madeira'),
    ('Polímero'),
    ('Ferro'),
    ('Fibra de carbono'),
    ('Alumínio'),
    ('Aço inoxidável'),
    ('Plástico ABS'),
    ('Nylon'),
    ('Liga de zinco'),
    ('Fibra de vidro'),
    ('Titânio'),
    ('Latão'),
    ('Cobre'),
    ('Magnésio'),
    ('Cerâmica');

INSERT INTO tipo_tiro(descricao)
VALUES
    ('Automático'),
    ('Semiautomático'),
    ('Repetição'),
    ('Único'),
    ('Rajada'),
    ('Tiro a Tiro'),
    ('Full Auto'),
    ('Burst'),
    ('Manual'),
    ('Híbrido');   

INSERT INTO tipo_arma(descricao)
VALUES
    ('Revolver'),
    ('Pistola'),
    ('Espingarda'),
    ('Rifle'),
    ('Carabina'),
    ('Metralhadora'),
    ('Escopeta'),
    ('Fuzil'),
    ('Submetralhadora'),
    ('Lança-granadas'),
    ('Arco e Flecha'),
    ('Besta'),
    ('Canhão'),
    ('Lança-chamas'),
    ('Bazuca');


INSERT INTO arma(
    nome, qtdnoestoque, preco, descricao, fabricante, modelo, peso, id_material, id_calibre,
    id_tipoArma, id_acabamento, capacidadedetiro, propulsor, velocidade, id_tipoTiro, nomeImagem)
VALUES
    ('Rifle M4A1', 15, 1200.00, 'Rifle de airsoft com alta precisão', 'Tokyo Marui', 'M4A1', 3.5, 1, 1, 1, 1, 30, 'Elétrico', '400', 1, 'metralhadora.jpg'),
    ('Pistola Glock 17', 25, 800.00, 'Pistola de airsoft compacta e leve', 'WE Tech', 'G17', 0.7, 2, 2, 2, 2, 20, 'Gás', '300', 2, 'metralhadora.jpg'),
    ('Sniper L96', 10, 1500.00, 'Rifle sniper de alta precisão', 'Well', 'L96', 4.5, 3, 3, 3, 3, 10, 'Mola', 450, 3, 'metralhadora.jpg'),
    ('Shotgun M870', 8, 900.00, 'Espingarda de airsoft com ação de bombeamento', 'CYMA', 'M870', 3.0, 4, 4, 4, 4, 8, 'Mola', '350', 4, 'metralhadora.jpg'),
    ('SMG MP5', 20, 1100.00, 'Submetralhadora de airsoft compacta', 'Classic Army', 'MP5', 2.5, 5, 5, 5, 5, 25, 'Elétrico', '380', 5, 'metralhadora.jpg'),
    ('Revolver Colt Python', 12, 700.00, 'Revolver de airsoft com design clássico', 'KWC', 'Python', 1.2, 6, 6, 6, 6, 6, 'CO2', '320', 6, 'metralhadora.jpg'),
    ('Rifle AK47', 18, 1300.00, 'Rifle de airsoft robusto e durável', 'CYMA', 'AK47', 3.8, 7, 7, 7, 7, 30, 'Elétrico', '410', 7, 'metralhadora.jpg'),
    ('Pistola Desert Eagle', 10, 950.00, 'Pistola de airsoft com grande impacto', 'Tokyo Marui', 'Desert Eagle', 1.5, 8, 8, 8, 8, 7, 'Gás', '330', 8, 'metralhadora.jpg'),
    ('Rifle G36C', 14, 1150.00, 'Rifle de airsoft compacto e versátil', 'Umarex', 'G36C', 2.9, 9, 9, 7, 9, 25, 'Elétrico', '390', 9, 'metralhadora.jpg'),
    ('Pistola Beretta M9', 22, 850.00, 'Pistola de airsoft com design militar', 'WE Tech', 'M9', 0.9, 10, 10, 6, 10, 15, 'Gás', '310', 10, 'metralhadora.jpg');


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
    (2, 'funcionario_jacare', '/1TvZJJL/8eyuJ8ktCm35K2ShjAQYM9dPzdDUwU8Fk2S5UMQlZ+AJI6ruk/VRwEB+6LISFzdAOVVQvhl0Owc3w=='),
    (2, 'leo', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');


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