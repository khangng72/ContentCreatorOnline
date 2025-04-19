CREATE OR REPLACE FUNCTION update_chapter_comment_count()
    RETURNS TRIGGER AS
$$
BEGIN
    UPDATE Chapter
    SET number_of_comment = number_of_comment + 1
    WHERE chapter_id = NEW.chapter_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_chapter_comment_count
    AFTER INSERT
    ON Comment
    FOR EACH ROW
EXECUTE FUNCTION update_chapter_comment_count();
