
CREATE INDEX ru_idx_localized_string_text ON localized_strings USING GIST(
    to_tsvector('russian', text)
);
CREATE INDEX en_idx_localized_string_text ON localized_strings USING GIST(
    to_tsvector('english', text)
);


CREATE EXTENSION IF NOT EXISTS pg_trgm;

CREATE INDEX trgm_idx_localized_string_text ON localized_strings USING GIST(key gist_trgm_ops);
