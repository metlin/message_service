 CREATE TABLE IF NOT EXISTS User (

    user_id     BIGINT  PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(20) NOT NULL,
    last_Name    VARCHAR(50) NOT NULL,
    email       VARCHAR(50)  NOT NULL,
    login       VARCHAR(15) NOT NULL,
    password    VARCHAR(15) NOT NULL
);








