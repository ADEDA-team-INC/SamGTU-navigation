ALTER TABLE localization ADD COLUMN text_vector tsvector;

UPDATE localization SET text_vector = to_tsvector('russian', text || ' ');

DROP INDEX idx_localization;
CREATE INDEX idx_localization ON localization USING GIST(text_vector);

SELECT id, text, localization.text_vector, ts_rank_cd(localization.text_vector, quary, 32) AS RANK
FROM localization, to_tsquery('russian','Додо | пицца') quary
ORDER BY RANK DESC
    LIMIT 10;
