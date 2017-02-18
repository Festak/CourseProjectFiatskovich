DROP TABLE user_roles;
DROP TABLE user_medals;
DROP TABLE users;
DROP TABLE roles;
DROP TABLE medals;


CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  secondAdres VARCHAR(100),
  credit INT
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ,
  FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ,

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;


CREATE TABLE medals(
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(200)
)
  ENGINE =InnoDB;

CREATE TABLE user_medals (
  user_id INT NOT NULL,
  medal_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ,
  FOREIGN KEY (medal_id) REFERENCES medals (id) ON DELETE CASCADE ,

  UNIQUE (user_id, medal_id)
)
  ENGINE = InnoDB;



-- Insert data

INSERT INTO users VALUES (1, 'admin', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG',
                          'second adress',200);

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO medals VALUES (1, "Best name", "Yes");
INSERT INTO medals VALUES (2, "Best name 2", "Yes 2");

INSERT  INTO user_medals VALUES(1,1);

INSERT INTO user_roles VALUES (1, 2);