ALTER TABLE story ADD COLUMN average_rating DOUBLE PRECISION DEFAULT 0.0;

CREATE TABLE IF NOT EXISTS user_like_story (
                                 user_id UUID NOT NULL,
                                 story_id UUID NOT NULL,
                                 rating DOUBLE PRECISION,
                                 PRIMARY KEY (user_id, story_id),
                                 CONSTRAINT fk_user
                                     FOREIGN KEY (user_id)
                                         REFERENCES cco_user (user_id)
                                         ON DELETE CASCADE,
                                 CONSTRAINT fk_story
                                     FOREIGN KEY (story_id)
                                         REFERENCES story (story_id)
                                         ON DELETE CASCADE
);

