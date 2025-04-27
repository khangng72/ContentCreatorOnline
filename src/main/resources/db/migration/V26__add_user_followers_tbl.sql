create table user_followers
(
    user_id     UUID not null REFERENCES cco_user (user_id),
    follower_id UUID not null REFERENCES cco_user (user_id),
    primary key (user_id, follower_id)
)