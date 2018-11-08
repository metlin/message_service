 CREATE TABLE IF NOT EXISTS User (

    user_id     BIGINT  PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(20) NOT NULL,
    last_Name   VARCHAR(50) NOT NULL,
    email       VARCHAR(50)  NOT NULL,
    login       VARCHAR(15) NOT NULL,
    password    VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS Message (

    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    date_time   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    from_whom   VARCHAR(50)  NOT NULL,
    message     VARCHAR(250) NOT NULL,
    user_id     BIGINT NOT NULL
);

    CREATE INDEX User_Message_id ON Message(user_id);
    ALTER TABLE Message ADD FOREIGN KEY (user_id) REFERENCES User(user_id);








