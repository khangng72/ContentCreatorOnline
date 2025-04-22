ALTER TABLE chapter
    ADD COLUMN number_of_likes INT DEFAULT 0;

CREATE TABLE user_like_chapter
(
    user_id    UUID NOT NULL,
    chapter_id UUID NOT NULL,
    PRIMARY KEY (user_id, chapter_id),
    FOREIGN KEY (user_id) REFERENCES cco_user (user_id) ON DELETE CASCADE,
    FOREIGN KEY (chapter_id) REFERENCES chapter (chapter_id) ON DELETE CASCADE
);

CREATE OR REPLACE FUNCTION update_chapter_like_count()
    RETURNS TRIGGER AS
$$
BEGIN
    UPDATE Chapter
    SET number_of_likes = number_of_likes + 1
    WHERE chapter_id = NEW.chapter_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_chapter_like_count
    AFTER INSERT
    ON user_like_chapter
    FOR EACH ROW
EXECUTE FUNCTION update_chapter_like_count();