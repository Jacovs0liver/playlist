CREATE TABLE history (
    id SERIAL PRIMARY KEY,
    user_id INT,
    song_id INT,
    played_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO history (user_id, song_id)
VALUES (1, 1);