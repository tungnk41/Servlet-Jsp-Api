use servlet_jsp_api;

CREATE TABLE role(
                     id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     name VARCHAR(255) NOT NULL,
                     code VARCHAR(255) NOT NULL,
                     create_date TIMESTAMP NULL,
                     create_by VARCHAR(255) NULL,
                     modified_date TIMESTAMP NULL,
                     modified_by VARCHAR(255) NULL
);

CREATE TABLE user(
                     id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     username VARCHAR(255) NOT NULL,
                     password VARCHAR(255) NOT NULL,
                     role_id INT NOT NULL,
                     status INT NOT NULL,
                     create_date TIMESTAMP NULL,
                     modified_date TIMESTAMP NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id);

CREATE TABLE news(
                     id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     title VARCHAR(255) NULL,
                     thumbnail TEXT NULL,
                     short_description TEXT NOT NULL,
                     content TEXT NULL,
                     category_id BIGINT NOT NULL,
                     create_date TIMESTAMP NULL,
                     create_by VARCHAR(255) NULL,
                     modified_date TIMESTAMP NULL,
                     modified_by VARCHAR(255) NULL
);

CREATE TABLE category(
                         id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         code VARCHAR(255) NOT NULL,
                         create_date TIMESTAMP NULL,
                         create_by VARCHAR(255) NULL,
                         modified_date TIMESTAMP NULL,
                         modified_by VARCHAR(255) NULL
);

ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (category_id) REFERENCES category(id);

CREATE TABLE comment(
                        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        content TEXT NOT NULL,
                        user_id BIGINT NOT NULL,
                        news_id BIGINT NOT NULL,
                        create_date TIMESTAMP NULL,
                        create_by VARCHAR(255) NULL,
                        modified_date TIMESTAMP NULL,
                        modified_by VARCHAR(255) NULL
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (news_id) REFERENCES news(id);