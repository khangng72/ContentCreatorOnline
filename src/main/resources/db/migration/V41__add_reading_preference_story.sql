ALTER TABLE cco_user
    ADD COLUMN default_reading_text_size FLOAT DEFAULT 19.0;
ALTER TABLE cco_user
    ADD COLUMN default_reading_word_spacing FLOAT DEFAULT 3.0;
ALTER TABLE cco_user
    ADD COLUMN default_reading_line_height FLOAT DEFAULT 1.5;