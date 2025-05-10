CREATE TABLE user_likes_comment
(
    user_id    UUID NOT NULL REFERENCES cco_user (user_id) ON DELETE CASCADE,
    comment_id UUID NOT NULL REFERENCES comment (comment_id) ON DELETE CASCADE,
    primary key (user_id, comment_id)
);