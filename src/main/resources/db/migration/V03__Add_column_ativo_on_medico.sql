ALTER TABLE medico ADD COLUMN ativo BOOLEAN;
UPDATE medico SET ativo = TRUE where id >= 1;
ALTER TABLE medico ADD CONSTRAINT coluna_ativo_obrigatoria CHECK (ativo in (true, false)) ;
