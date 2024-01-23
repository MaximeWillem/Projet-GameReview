CREATE TABLE "User" (
                        id SERIAL PRIMARY KEY,
                        username VARCHAR(100) UNIQUE,
                        password VARCHAR(100)
);

CREATE TABLE "Game" (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100),
                      image VARCHAR(255),
                      description VARCHAR(100)
);

CREATE TABLE "Comment" (
                         id SERIAL PRIMARY KEY,
                         gameId INT,
                         content VARCHAR(255),
                         rating INT,
                         author VARCHAR(255),
                         FOREIGN KEY (gameId) REFERENCES "Game"(id),
                         FOREIGN KEY (author) REFERENCES "User"(username)
);

