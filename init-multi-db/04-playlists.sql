CREATE TABLE playlists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    user_id INT
);

INSERT INTO playlists (name, user_id)
VALUES ('My Playlist', 1);