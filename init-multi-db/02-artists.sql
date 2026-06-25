CREATE TABLE artists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    genre VARCHAR(50)
);

INSERT INTO artists (name, genre)
VALUES ('The Beatles', 'Rock');