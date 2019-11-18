CREATE TABLE IF NOT EXISTS user (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
user_name varchar(50) NOT NULL unique,
user_pwd varchar(255) NOT NULL,
user_email varchar(50),
user_contact MEDIUMINT,
user_createdAt DATE,
user_modifiedAt DATE,
PRIMARY KEY (id,user_name))
ENGINE=InnoDB;

drop TABLE user;
drop table user_role;

CREATE TABLE IF NOT EXISTS user_role (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
user_name varchar(50) NOT NULL,
user_role varchar(50) NOT NULL,
role_createdAt DATE,
PRIMARY KEY (id),
FOREIGN KEY (user_name) REFERENCES user(user_name) ON DELETE CASCADE)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS movie (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
movie_name varchar(50) NOT NULL,
release_year MEDIUMINT,
release_date date NOT NULL,
movie_syn varchar(8000),
movie_path varchar(255),
movie_trailer_url varchar(255),
PRIMARY KEY (id,movie_name))
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS actor (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
actor_name varchar(50) NOT NULL,
movie_name varchar(50),
birth_date DATE,
actor_desc varchar(255),
PRIMARY KEY (id,actor_name))
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS movie_feedback (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
movie_name varchar(50) NOT NULL,
feedback_desc varchar(255),
user_name varchar(50),
feedback_rating MEDIUMINT,
PRIMARY KEY (id))
ENGINE=InnoDB;