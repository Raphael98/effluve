CREATE TABLE users (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(80) NOT NULL,
	cep VARCHAR(11) NOT NULL,
	number VARCHAR(10) NOT NULL,
	admin BIT NOT NULL DEFAULT 0,
	CONSTRAINT unique_email UNIQUE (email)
);

CREATE TABLE brands (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL
);

CREATE TABLE genders (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL
);

CREATE TABLE products (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	price DECIMAL(6,2) NOT NULL,
	description TEXT,
	brand_id INT NOT NULL,
	gender_id INT NOT NULL,
	picture VARCHAR(255),
	CONSTRAINT fk_product_brands FOREIGN KEY (brand_id)
    REFERENCES brands(id),
    CONSTRAINT fk_product_genders FOREIGN KEY (gender_id)
    REFERENCES genders(id)
);

CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
	code VARCHAR(45),
	date_purchase TIMESTAMP default CURRENT_TIMESTAMP,
	user_id INT NOT NULL,
	product_id INT NOT NULL,
	CONSTRAINT fk_order_users FOREIGN KEY (user_id)
    REFERENCES users(id),
    CONSTRAINT fk_order_products FOREIGN KEY (product_id)
    REFERENCES products(id)
);

INSERT INTO genders (name) VALUES ('MASCULINO'), ('FEMININO'), ('UNISEX');
INSERT INTO brands (name) VALUES ('Paco Rabanne'), ('Azzaro'), ('Carolina Herrera');
INSERT INTO users (name, email, password, cep, number, admin)
VALUES ('Adm', 'adm@effluve.com', 'password','03677011',55,1),
('customer', 'customer@gmail.com', 'password','03477012',23,0);
INSERT INTO products (name, price, brand_id, gender_id, description) VALUES 
('1 Million',400,1,1,'Lorem ipsum dolor sit amet consectetur adipiscing elit senectus, aliquam diam dictum nisi habitant dignissim pulvinar, facilisi ac taciti lobortis arcu massa fames fusce'),
('Olympéa Legend',278.99, 1, 2,'Lorem ipsum dolor sit amet consectetur adipiscing elit senectus, aliquam diam dictum nisi habitant dignissim pulvinar, facilisi ac taciti lobortis arcu massa fames fusce'),
('Lady Million',223.89, 1, 2,'Lorem ipsum dolor sit amet consectetur adipiscing elit senectus, aliquam diam dictum nisi habitant dignissim pulvinar, facilisi ac taciti lobortis arcu massa fames fusce'),
('Pour Homme',449.89, 2, 1,'Lorem ipsum dolor sit amet consectetur adipiscing elit senectus, aliquam diam dictum nisi habitant dignissim pulvinar, facilisi ac taciti lobortis arcu massa fames fusce'),
('Mademoiselle',163.89, 2, 2,'Lorem ipsum dolor sit amet consectetur adipiscing elit senectus, aliquam diam dictum nisi habitant dignissim pulvinar, facilisi ac taciti lobortis arcu massa fames fusce'),
('Good Girl',500.89, 3, 2,'Lorem ipsum dolor sit amet consectetur adipiscing elit senectus, aliquam diam dictum nisi habitant dignissim pulvinar, facilisi ac taciti lobortis arcu massa fames fusce'),
('212 VIP', 314.89, 3, 1,'Lorem ipsum dolor sit amet consectetur adipiscing elit senectus, aliquam diam dictum nisi habitant dignissim pulvinar, facilisi ac taciti lobortis arcu massa fames fusce');