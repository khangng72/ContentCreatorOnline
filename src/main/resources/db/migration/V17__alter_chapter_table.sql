ALTER TABLE chapter
    ADD COLUMN number_of_likes INT DEFAULT 0;

CREATE TABLE user_like_chapter
(
    user_id    UUID NOT NULL,
    chapter_id UUID NOT NULL,
    PRIMARY KEY (user_id, chapter_id),
    FOREIGN KEY (user_id) REFERENCES cco_user (user_id) ON DELETE CASCADE,
    FOREIGN KEY (chapter_id) REFERENCES chapter (chapter_id) ON DELETE CASCADE
)