ALTER TABLE comment
    ADD COLUMN chapter_id UUID REFERENCES chapter (chapter_id);
ALTER TABLE comment
    ADD COLUMN user_id UUID REFERENCES cco_user (user_id);
ALTER TABLE comment
    DROP COLUMN comment_date;
ALTER TABLE comment
    ADD COLUMN parent_comment_id UUID REFERENCES comment (comment_id);
ALTER TABLE comment
    ALTER COLUMN number_of_likes SET DEFAULT 0;
ALTER TABLE comment
    ADD COLUMN created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE comment
    DROP COLUMN story_id;
ALTER TABLE chapter
    ADD COLUMN number_of_comment INT DEFAULT 0;
