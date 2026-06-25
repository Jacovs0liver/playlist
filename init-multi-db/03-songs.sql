CREATE TABLE songs (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    artist_id INT,
    duration INT
);

INSERT INTO songs (title, artist_id, duration)
VALUES ('Let It Be', 1, 240);