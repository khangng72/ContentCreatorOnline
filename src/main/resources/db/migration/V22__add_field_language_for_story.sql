ALTER TABLE story
    ADD COLUMN language VARCHAR(10) DEFAULT 'en';

UPDATE story
SET language = 'en'
WHERE language IS NULL;