CREATE TABLE IF NOT EXISTS users (
    username    TEXT PRIMARY KEY,
    password    TEXT NOT NULL,
    enabled     BOOLEAN NOT NULL DEFAULT TRUE,
    email       TEXT NOT NULL,
    location    TEXT NOT NULL
);

 CREATE TABLE IF NOT EXISTS user_roles (
    user_role_id    SERIAL PRIMARY KEY,
    username        TEXT NOT NULL REFERENCES users(username) ON DELETE CASCADE,
    role            TEXT NOT NULL DEFAULT 'ROLE_USER',
    UNIQUE(username, role)
 );

CREATE TABLE IF NOT EXISTS horses (
    id  SERIAL PRIMARY KEY,
    name            TEXT NOT NULL,
    location        TEXT NOT NULL,
    description     TEXT NOT NULL,
    owner           TEXT NOT NULL  REFERENCES users(username) ON DELETE CASCADE,
    horse_pic_url   TEXT
);

CREATE TABLE IF NOT EXISTS conversations (
        id          SERIAL PRIMARY KEY ,
        horse_id    INTEGER  NOT NULL REFERENCES horses(id) ON DELETE CASCADE,
        buyer_id    TEXT NOT NULL REFERENCES users(username) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS messages (
    id                  SERIAL PRIMARY KEY,
    conversation_id     INTEGER NOT NULL REFERENCES conversations(id) ON DELETE CASCADE,
    author_id           TEXT NOT NULL REFERENCES users(username) ON DELETE CASCADE,
    paragraph           TEXT
);
