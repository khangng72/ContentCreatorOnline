ALTER TABLE story
    ADD COLUMN updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

CREATE OR REPLACE FUNCTION update_updated_time()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.updated_time = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_time
    BEFORE UPDATE
    ON story
    FOR EACH ROW
EXECUTE FUNCTION update_updated_time();
