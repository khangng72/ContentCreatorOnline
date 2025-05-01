CREATE EXTENSION IF NOT EXISTS pg_trgm;

ALTER TABLE story
    ADD COLUMN document tsvector
        GENERATED ALWAYS AS (
            to_tsvector('english', coalesce(story_title, ''))
            ) STORED;

-- For full-text search
CREATE INDEX story_document_idx ON story USING GIN (document);

-- For trigrams
CREATE INDEX story_title_trgm_idx ON story USING gin (story_title gin_trgm_ops);