ALTER TABLE chapter
    ADD COLUMN updated_time TIMESTAMP DEFAULT now() NOT NULL;

CREATE TRIGGER trigger_update_time_chapter
    BEFORE UPDATE
    ON chapter
    FOR EACH ROW
EXECUTE FUNCTION update_updated_time();