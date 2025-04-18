CREATE OR REPLACE FUNCTION update_chapter_comment_count()
    RETURNS TRIGGER AS
$$
BEGIN
    IF (SELECT number_of_comment FROM Chapter WHERE chapter_id = NEW.chapter_id) = 0 THEN
        -- If 0, recount from the Comment table
        UPDATE Chapter
        SET number_of_comment = (SELECT COUNT(*)
                                 FROM Comment
                                 WHERE chapter_id = NEW.chapter_id)
        WHERE chapter_id = NEW.chapter_id;
    ELSE
        -- Else, just increment
        UPDATE Chapter
        SET number_of_comment = number_of_comment + 1
        WHERE chapter_id = NEW.chapter_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_chapter_comment_count
    AFTER INSERT
    ON Comment
    FOR EACH ROW
EXECUTE FUNCTION update_chapter_comment_count();
