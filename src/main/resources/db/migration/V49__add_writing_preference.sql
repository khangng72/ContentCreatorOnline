ALTER TABLE cco_user
    ADD COLUMN default_writing_text_size FLOAT DEFAULT 19.0;
ALTER TABLE cco_user
    ADD COLUMN default_writing_word_spacing FLOAT DEFAULT 3.0;
ALTER TABLE cco_user
    ADD COLUMN default_writing_line_height FLOAT DEFAULT 1.5;