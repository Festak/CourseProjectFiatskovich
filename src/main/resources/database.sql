DROP TABLE user_roles;
DROP TABLE user_medals;
DROP TABLE product_advantages;
DROP TABLE product_categories;
DROP TABLE advantages;
DROP TABLE categories;
DROP TABLE users;
DROP TABLE roles;
DROP TABLE medals;
DROP TABLE products;


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

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE  CASCADE,
  FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE  CASCADE,

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

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE  CASCADE,
  FOREIGN KEY (medal_id) REFERENCES medals (id) ON DELETE CASCADE ON UPDATE  CASCADE,

  UNIQUE (user_id, medal_id)
)
  ENGINE = InnoDB;

CREATE TABLE advantages(
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(255) NOT NULL
)
  ENGINE =InnoDB;

CREATE TABLE categories(
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40) NOT NULL
)
  ENGINE =InnoDB;

CREATE TABLE products(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(60) NOT NULL,
  weight INT NOT NULL,
  temperature VARCHAR(40),
  memory INT,
  price DOUBLE,
  image_url varchar(255)
)
  ENGINE =InnoDB;

CREATE TABLE product_advantages (
  product_id INT NOT NULL,
  advantage_id INT NOT NULL,

  FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE ON UPDATE  CASCADE,
  FOREIGN KEY (advantage_id) REFERENCES advantages (id) ON DELETE CASCADE ON UPDATE  CASCADE,

  UNIQUE (product_id, advantage_id)
)
  ENGINE = InnoDB;

CREATE TABLE product_categories (
  product_id INT NOT NULL,
  category_id INT NOT NULL,

  FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE ON UPDATE  CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE ON UPDATE  CASCADE ,

  UNIQUE (product_id, category_id)
)
  ENGINE = InnoDB;



-- Insert data

INSERT INTO users VALUES (1, 'admin', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG',
                          'second adress',200);

INSERT INTO users VALUES (2, 'neadmin', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG',
                          'Ul Kulman',220);

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO medals VALUES (1, "Зарегистрировался", "В первый раз зарегистрировался и получил достижение");
INSERT INTO medals VALUES (2, "Покупатель", "Купил свой первый товар на сайте");

INSERT INTO user_medals VALUES(1,1);
INSERT  INTO user_medals VALUES(1,2);
INSERT INTO user_roles VALUES (1, 2);
INSERT INTO user_medals VALUES (2,2);
INSERT INTO user_roles VALUES (2,1);

INSERT INTO advantages VALUES (1, "Проверена годами, обязательно покупайте");
INSERT INTO advantages VALUES (2, "Работает 10 лет без сбоев");
INSERT INTO advantages VALUES (3, "Идеальный звук");
INSERT INTO advantages VALUES (4, "Водонепроницаемый");
INSERT INTO advantages VALUES (5, "Высокая защита от пыли");

INSERT INTO categories VALUES (1, "Мобильный телефон");
INSERT INTO categories VALUES (2, "Телевизор");
INSERT INTO categories VALUES (3, "Пылесос");
INSERT INTO categories VALUES (4, "Холодильник");
INSERT INTO categories VALUES (5, "Компьютер");
INSERT INTO categories VALUES(6,"Монитор");

INSERT INTO products VALUES(1, "Nexus 5", 300, "от 20 до 30 градусов", 32, 400, "http://res.cloudinary.com/festak/image/upload/v1487522911/Nexus_5_Front_View_sa16xl.png");
INSERT INTO product_categories VALUES (1, 1);
INSERT INTO product_advantages VALUES(1, 1);
INSERT INTO product_advantages VALUES(1, 5);
INSERT INTO product_advantages VALUES(1, 3);
INSERT INTO product_advantages VALUES(1, 4);
INSERT INTO product_advantages VALUES(1, 2);

INSERT INTO products VALUES(2, "IPhone 7", 500, "от 20 до 30 градусов", 32, 700, "http://res.cloudinary.com/festak/image/upload/v1487522929/iphone7_j6sr44.png");
INSERT INTO product_categories VALUES (2, 1);
INSERT INTO product_advantages VALUES(2, 1);
INSERT INTO product_advantages VALUES(2, 5);
INSERT INTO product_advantages VALUES(2, 3);
INSERT INTO product_advantages VALUES(2, 4);
INSERT INTO product_advantages VALUES(2, 2);

INSERT INTO products VALUES(3, "Huawey Asseng G7", 1300, "от 10 до 30 градусов", 64, 3000, "http://res.cloudinary.com/festak/image/upload/v1487522912/huawei-ascend-g7-front_peir21.jpg");
INSERT INTO product_categories VALUES (3, 1);
INSERT INTO product_advantages VALUES(3, 1);
INSERT INTO product_advantages VALUES(3, 5);
INSERT INTO product_advantages VALUES(3, 3);
INSERT INTO product_advantages VALUES(3, 4);

INSERT INTO products VALUES(4, "BenQ", 3000, "от 10 до 30 градусов", 0, 1300, "http://res.cloudinary.com/festak/image/upload/v1487522912/benq_w8kt7r.jpg");
INSERT INTO product_categories VALUES (4, 6);
INSERT INTO product_advantages VALUES(4, 5);
INSERT INTO product_advantages VALUES(4, 3);
INSERT INTO product_advantages VALUES(4, 2);

INSERT INTO products VALUES(5, "Atlant XM 6002", 20000, "от -20 до 30 градусов", 0, 900, "");
INSERT INTO product_categories VALUES (5, 4);
INSERT INTO product_advantages VALUES(5, 1);
INSERT INTO product_advantages VALUES(5, 5);

INSERT INTO products VALUES(6, "Пылесос Holt HT-VC-005 ", 3000, "от 10 до 30 градусов", 0, 800, "http://res.cloudinary.com/festak/image/upload/v1487523162/HOLT_HT_1_sodepz.jpg");
INSERT INTO product_categories VALUES (6, 3);
INSERT INTO product_advantages VALUES(6, 1);
INSERT INTO product_advantages VALUES(6, 5);
INSERT INTO product_advantages VALUES(6, 4);

INSERT INTO products VALUES(7, "Пылесос Thomas AQUA+ Pet & Family ", 300, "от 10 до 30 градусов", 0, 1400, "http://res.cloudinary.com/festak/image/upload/v1487523162/HOLT_HT_2_jkswt4.jpg");
INSERT INTO product_categories VALUES (7, 3);
INSERT INTO product_advantages VALUES(7, 1);
INSERT INTO product_advantages VALUES(7, 5);
INSERT INTO product_advantages VALUES(7, 4);



