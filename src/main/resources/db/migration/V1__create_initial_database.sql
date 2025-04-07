CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--CREATE TABLE ADDRESS
DROP TABLE IF EXISTS user_address CASCADE;

CREATE TABLE user_address
(
    address_id  UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    street      VARCHAR(255),
    city        VARCHAR(255) NOT NULL,
    user_state  VARCHAR(255),
    postal_code VARCHAR(20),
    country     VARCHAR(255) NOT NULL
);

--CREATE TABLE CCO_USER
DROP TABLE IF EXISTS cco_user CASCADE;

CREATE TABLE cco_user
(
    user_id       UUID                  DEFAULT uuid_generate_v4() PRIMARY KEY,
    email         VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255) NOT NULL,
    gender        VARCHAR(255),
    is_admin      BOOLEAN               DEFAULT FALSE NOT NULL,
    is_active     BOOLEAN      NOT NULL DEFAULT TRUE,
    nationality   VARCHAR(255),
    birthday      DATE         NOT NULL,
    address_id    UUID UNIQUE  REFERENCES user_address (address_id) ON DELETE SET NULL
);

--CREATE TABLE STORY
DROP TABLE IF EXISTS story CASCADE;

CREATE TABLE story
(
    story_id          UUID    DEFAULT uuid_generate_v4() PRIMARY KEY,
    release_date      DATE,
    release_status    BOOLEAN DEFAULT FALSE,
    story_title       VARCHAR(255) NOT NULL,
    sale_only         BOOLEAN DEFAULT FALSE,
    sale_price        DOUBLE PRECISION,
    number_of_likes   INTEGER,
    cover_image_uri   VARCHAR(255),
    story_description TEXT,
    tags              VARCHAR(255),
    user_id           UUID REFERENCES cco_user (user_id) ON DELETE CASCADE
);

--CREATE TABLE USER_OWN_STORY
DROP TABLE IF EXISTS user_own_story CASCADE;

CREATE TABLE user_own_story
(
    story_id UUID NOT NULL REFERENCES story (story_id),
    user_id  UUID NOT NULL REFERENCES cco_user (user_id),
    PRIMARY KEY (story_id, user_id)
);

--CREATE TABLE CHAPTER
DROP TABLE IF EXISTS chapter CASCADE;

CREATE TABLE chapter
(
    chapter_id          UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    chapter_number      INTEGER      NOT NULL,
    chapter_title       VARCHAR(255) NOT NULL,
    chapter_description TEXT,
    chapter_image_uri   VARCHAR(255),
    story_id            UUID REFERENCES story (story_id) ON DELETE CASCADE
);

-- CREATE TABLE PARAGRAPH
DROP TABLE IF EXISTS paragraph CASCADE;

CREATE TABLE paragraph
(
    paragraph_id        UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    paragraph_number    INTEGER NOT NULL,
    paragraph_content   TEXT    NOT NULL,
    paragraph_image_uri VARCHAR(255),
    chapter_id          UUID REFERENCES chapter (chapter_id) ON DELETE CASCADE
);

--CREATE TABLE COMMENT
DROP TABLE IF EXISTS comment CASCADE;

CREATE TABLE comment
(
    comment_id      UUID                  DEFAULT uuid_generate_v4() PRIMARY KEY,
    comment_date    DATE         NOT NULL DEFAULT CURRENT_DATE,
    comment_content VARCHAR(255) NOT NULL,
    number_of_likes INTEGER,
    is_pinned       BOOLEAN               DEFAULT FALSE,
    is_deleted      BOOLEAN               DEFAULT FALSE,
    story_id        UUID REFERENCES story (story_id) ON DELETE CASCADE
);

-- CREATE TABLE genre
DROP TABLE IF EXISTS genre CASCADE;

CREATE TABLE GENRE
(
    genre_id   SERIAL PRIMARY KEY,
    genre_name VARCHAR(255)
);

-- CREATE TABLE BELONGS
DROP TABLE IF EXISTS belongs CASCADE;

CREATE TABLE belongs
(
    genre_id INTEGER NOT NULL REFERENCES genre (genre_id) ON DELETE CASCADE,
    story_id UUID    NOT NULL REFERENCES story (story_id) ON DELETE CASCADE,
    PRIMARY KEY (genre_id, story_id)
);

-- CREATE TABLE READ_LIST
DROP TABLE IF EXISTS read_list CASCADE;

CREATE TABLE read_list
(
    read_list_id          UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    read_list_title       VARCHAR(255) NOT NULL,
    read_list_description VARCHAR(1000),
    number_of_likes       INTEGER,
    quantity              INTEGER,
    read_list_cover       VARCHAR(255),
    user_id               UUID REFERENCES cco_user (user_id) ON DELETE CASCADE
);

-- CREATE TABLE CONTAINS
DROP TABLE IF EXISTS contains CASCADE;

CREATE TABLE contains
(
    read_list_id UUID NOT NULL REFERENCES read_list (read_list_id) ON DELETE CASCADE,
    story_id     UUID NOT NULL REFERENCES story (story_id) ON DELETE CASCADE,
    PRIMARY KEY (read_list_id, story_id)
);

--CREATE TABLE HAS_GENRE
DROP TABLE IF EXISTS has_genre CASCADE;

CREATE TABLE has_genre
(
    genre_id     INT  NOT NULL REFERENCES genre (genre_id) ON DELETE CASCADE,
    read_list_id UUID NOT NULL REFERENCES read_list (read_list_id) ON DELETE CASCADE,
    PRIMARY KEY (genre_id, read_list_id)
);

--CREATE TABLE INTERESTED_IN
DROP TABLE IF EXISTS interested_in CASCADE;

CREATE TABLE interested_in
(
    user_id  UUID NOT NULL REFERENCES cco_user (user_id) ON DELETE CASCADE,
    genre_id INT  NOT NULL REFERENCES genre (genre_id) ON DELETE CASCADE
);

--CREATE TABLE USER_LIKE_STORY
DROP TABLE IF EXISTS user_like_story CASCADE;

CREATE TABLE user_like_story
(
    story_id UUID NOT NULL REFERENCES story (story_id) ON DELETE CASCADE,
    user_id  UUID NOT NULL REFERENCES cco_user (user_id) ON DELETE CASCADE,
    PRIMARY KEY (story_id, user_id)
);

--CREATE TABLE ORDERS
DROP TABLE IF EXISTS orders CASCADE;

CREATE TABLE orders
(
    order_id    UUID          DEFAULT uuid_generate_v4() PRIMARY KEY,
    order_date  DATE NOT NULL DEFAULT CURRENT_DATE,
    total_price DOUBLE PRECISION,
    status      VARCHAR(255),
    user_id     UUID REFERENCES cco_user (user_id) ON DELETE CASCADE
);

--CREATE TABLE ORDER_CONTAIN
DROP TABLE IF EXISTS order_contain CASCADE;

CREATE TABLE order_contain
(
    order_id UUID NOT NULL REFERENCES orders (order_id) ON DELETE CASCADE,
    story_id UUID NOT NULL REFERENCES story (story_id) ON DELETE CASCADE,
    PRIMARY KEY (order_id, story_id)
);