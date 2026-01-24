-- Aumenta o tamanho de caracteres na coluna imgUrl, sanando problema de URL longos demais para inserir no BD
ALTER TABLE tb_cadastro
ALTER COLUMN img_url TYPE VARCHAR (2048);