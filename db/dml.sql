INSERT INTO Paises (nome, sigla) VALUES ('Brasil', 'BRA');
INSERT INTO Paises (nome, sigla) VALUES ('Argentina', 'ARG');
INSERT INTO Paises (nome, sigla) VALUES ('Chile', 'CHL');
INSERT INTO Paises (nome, sigla) VALUES ('Paraguai', 'PRY');
INSERT INTO Paises (nome, sigla) VALUES ('Uruguai', 'URY');

INSERT INTO Estados (nome, sigla, id_pais) VALUES ('São Paulo', 'SP', 1);
INSERT INTO Estados (nome, sigla, id_pais) VALUES ('Rio de Janeiro', 'RJ', 1);
INSERT INTO Estados (nome, sigla, id_pais) VALUES ('Buenos Aires', 'BA', 2);
INSERT INTO Estados (nome, sigla, id_pais) VALUES ('Santiago', 'ST', 3);
INSERT INTO Estados (nome, sigla, id_pais) VALUES ('Assunção', 'AS', 4);

INSERT INTO Municipios (nome, id_estado) VALUES ('São Paulo', 1);
INSERT INTO Municipios (nome, id_estado) VALUES ('Rio de Janeiro', 2);
INSERT INTO Municipios (nome, id_estado) VALUES ('La Plata', 3);
INSERT INTO Municipios (nome, id_estado) VALUES ('Santiago Centro', 4);
INSERT INTO Municipios (nome, id_estado) VALUES ('Luque', 5);

INSERT INTO TiposEventosNaturais (tipo_evento, descricao, intensidade_evento) VALUES ('Enchente', 'Inundação provocada por chuvas intensas', 4);
INSERT INTO TiposEventosNaturais (tipo_evento, descricao, intensidade_evento) VALUES ('Terremoto', 'Movimento sísmico de grande magnitude', 5);
INSERT INTO TiposEventosNaturais (tipo_evento, descricao, intensidade_evento) VALUES ('Deslizamento', 'Deslizamento de terra em área de risco', 3);
INSERT INTO TiposEventosNaturais (tipo_evento, descricao, intensidade_evento) VALUES ('Seca', 'Período prolongado sem chuvas', 2);
INSERT INTO TiposEventosNaturais (tipo_evento, descricao, intensidade_evento) VALUES ('Tempestade', 'Tempestades severas com ventos fortes', 4);

INSERT INTO ModelosIA (nome_modelo, tipo_modelo, algoritmo_base, data_treinamento, acuracia, descricao_modelo) VALUES ('Previsor de Enchentes', 'Classificação', 'Random Forest', DATE '2024-01-15', 92.5, 'Modelo treinado com dados pluviométricos');
INSERT INTO ModelosIA (nome_modelo, tipo_modelo, algoritmo_base, data_treinamento, acuracia, descricao_modelo) VALUES ('Detector de Terremotos', 'Classificação', 'SVM', DATE '2023-12-01', 88.0, 'Treinado com dados sísmicos históricos');
INSERT INTO ModelosIA (nome_modelo, tipo_modelo, algoritmo_base, data_treinamento, acuracia, descricao_modelo) VALUES ('Analisador de Seca', 'Regressão', 'Linear Regression', DATE '2024-02-20', 85.3, 'Modelo que prevê tempo de estiagem');
INSERT INTO ModelosIA (nome_modelo, tipo_modelo, algoritmo_base, data_treinamento, acuracia, descricao_modelo) VALUES ('Modelo de Deslizamento', 'Classificação', 'Decision Tree', DATE '2023-11-05', 89.7, 'Indica áreas de risco de deslizamento');
INSERT INTO ModelosIA (nome_modelo, tipo_modelo, algoritmo_base, data_treinamento, acuracia, descricao_modelo) VALUES ('Previsor de Tempestades', 'Classificação', 'Neural Network', DATE '2024-03-10', 94.1, 'Modelo para previsão de tempestades');

INSERT INTO RegioesMonitoradas (nome_regiao, tipo_zona, populacao_estimada, descriacao_area, id_municipio) VALUES ('Zona Leste SP', 'Urbana', 1500000, 'Área densamente povoada da cidade de São Paulo', 1);
INSERT INTO RegioesMonitoradas (nome_regiao, tipo_zona, populacao_estimada, descriacao_area, id_municipio) VALUES ('Zona Sul RJ', 'Urbana', 1000000, 'Região com histórico de enchentes e deslizamentos', 2);
INSERT INTO RegioesMonitoradas (nome_regiao, tipo_zona, populacao_estimada, descriacao_area, id_municipio) VALUES ('Centro La Plata', 'Urbana', 600000, 'Centro da cidade argentina', 3);
INSERT INTO RegioesMonitoradas (nome_regiao, tipo_zona, populacao_estimada, descriacao_area, id_municipio) VALUES ('Cordilheira Andes', 'Montanhosa', 200000, 'Região propensa a terremotos', 4);
INSERT INTO RegioesMonitoradas (nome_regiao, tipo_zona, populacao_estimada, descriacao_area, id_municipio) VALUES ('Chaco', 'Rural', 150000, 'Região rural suscetível à seca', 5);

INSERT INTO Eventos (data_prevista, probabilidade, gerado_em, descricao, id_modelo, id_tipo_evento, id_regiao, data_ocorrencia) VALUES (DATE '2025-07-10', 80.0, DATE '2025-06-01', 'Previsão de enchente na Zona Leste de SP', 1, 1, 1, NULL);
INSERT INTO Eventos (data_prevista, probabilidade, gerado_em, descricao, id_modelo, id_tipo_evento, id_regiao, data_ocorrencia) VALUES (DATE '2025-08-05', 70.5, DATE '2025-06-02', 'Risco de terremoto na Cordilheira', 2, 2, 4, NULL);
INSERT INTO Eventos (data_prevista, probabilidade, gerado_em, descricao, id_modelo, id_tipo_evento, id_regiao, data_ocorrencia) VALUES (DATE '2025-07-20', 65.0, DATE '2025-06-03', 'Possível deslizamento na Zona Sul do RJ', 4, 3, 2, NULL);
INSERT INTO Eventos (data_prevista, probabilidade, gerado_em, descricao, id_modelo, id_tipo_evento, id_regiao, data_ocorrencia) VALUES (DATE '2025-09-01', 90.2, DATE '2025-06-04', 'Alerta de seca prolongada no Chaco', 3, 4, 5, NULL);
INSERT INTO Eventos (data_prevista, probabilidade, gerado_em, descricao, id_modelo, id_tipo_evento, id_regiao, data_ocorrencia) VALUES (DATE '2025-06-15', 85.7, DATE '2025-06-05', 'Previsão de tempestade em La Plata', 5, 5, 3, NULL);

INSERT INTO Alertas (nivel_alerta, mensagem_alerta, data_emissao, id_evento) VALUES (4, 'Enchente iminente. Evacuar áreas de risco.', DATE '2025-06-06', 1);
INSERT INTO Alertas (nivel_alerta, mensagem_alerta, data_emissao, id_evento) VALUES (5, 'Terremoto previsto. Afastar-se de construções instáveis.', DATE '2025-06-06', 2);
INSERT INTO Alertas (nivel_alerta, mensagem_alerta, data_emissao, id_evento) VALUES (3, 'Deslizamento possível em áreas íngremes.', DATE '2025-06-07', 3);
INSERT INTO Alertas (nivel_alerta, mensagem_alerta, data_emissao, id_evento) VALUES (2, 'Monitorar situação de estiagem.', DATE '2025-06-07', 4);
INSERT INTO Alertas (nivel_alerta, mensagem_alerta, data_emissao, id_evento) VALUES (5, 'Tempestade forte se aproximando. Ficar em casa.', DATE '2025-06-08', 5);