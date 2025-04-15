ALTER TABLE story
    ADD COLUMN created_time TIMESTAMP DEFAULT Now();

ALTER TABLE chapter
    ADD COLUMN created_time TIMESTAMP DEFAULT Now();