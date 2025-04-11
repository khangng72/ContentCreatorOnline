--CREATE TABLE ADDRESS
DROP TABLE IF EXISTS upload_image CASCADE;

CREATE TABLE upload_image
(
    image_id  UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    image_url      VARCHAR(255),
    created_day        VARCHAR(255) NOT NULL,
    status      BOOLEAN      NOT NULL DEFAULT TRUE,
    updated_day        VARCHAR(255) NOT NULL,
    user_upload           UUID REFERENCES cco_user (user_id) ON DELETE CASCADE
);