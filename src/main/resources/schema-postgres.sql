CREATE TABLE IF NOT EXISTS users (
    username TEXT PRIMARY KEY,
    password TEXT NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
    email       TEXT NOT NULL,
    location    TEXT NOT NULL,
);

 CREATE TABLE IF NOT EXISTS user_roles (
    user_role_id SERIAL PRIMARY KEY,
    username TEXT NOT NULL REFERENCES users(username),
    role TEXT NOT NULL DEFAULT 'ROLE_USER',
    UNIQUE(username, role)
 );

CREATE TABLE IF NOT EXISTS horses (
    id  SERIAL PRIMARY KEY,
    name         TEXT NOT NULL,
    address      TEXT NOT NULL,
    description  TEXT NOT NULL,
    owner    REFERENCES TO users(username) ON DELETE CASCADE,
    horse_pic_url     TEXT
);

--GRANT ALL ON TABLE posts TO "user";
--GRANT ALL ON TABLE comments TO "user";
--GRANT ALL PRIVILEGES ON SEQUENCE comments_id_seq TO "user";
--GRANT ALL PRIVILEGES ON SEQUENCE employers_id_seq TO "user";