--CREATE TABLE ADDRESS
DROP TABLE IF EXISTS upload_image CASCADE;

CREATE TABLE upload_image
(
    image_id     UUID             DEFAULT uuid_generate_v4() PRIMARY KEY,
    image_uri    VARCHAR(255),
    uploaded_day DATE    NOT NULL DEFAULT CURRENT_DATE,
    is_deleted   BOOLEAN NOT NULL DEFAULT TRUE,
    user_id      UUID REFERENCES cco_user (user_id) ON DELETE CASCADE
);