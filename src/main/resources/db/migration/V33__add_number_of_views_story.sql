ALTER TABLE story
    ADD COLUMN number_of_views BIGINT DEFAULT 0;

UPDATE story
SET number_of_views = 100;