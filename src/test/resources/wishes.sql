INSERT INTO users(id, first_name, last_name, email, password) VALUES(1, 'Gabriel', 'Silva', 'gabriel@email.com', 'senha') ON CONFLICT DO NOTHING;
INSERT INTO users(id, first_name, last_name, email, password) VALUES(2, 'Lucas', 'Moura', 'lucas@email.com', 'senha') ON CONFLICT DO NOTHING;
INSERT INTO users(id, first_name, last_name, email, password) VALUES(3, 'Maria', 'Alves', 'maria@email.com', 'senha') ON CONFLICT DO NOTHING;

INSERT INTO categories(id, category_name, description, image_url) VALUES (1, 'Smartphone', 'Smartphone', '') ON CONFLICT DO NOTHING;
INSERT INTO categories(id, category_name, description, image_url) VALUES (2, 'TV', 'TV', '') ON CONFLICT DO NOTHING;
INSERT INTO categories(id, category_name, description, image_url) VALUES (3, 'E-reader', 'E-reader', '') ON CONFLICT DO NOTHING;

INSERT INTO products(id, description, imageurl, name, price, category_id) VALUES(1, 'Iphone X', '', 'Iphone X', 2000, 1) ON CONFLICT DO NOTHING;
INSERT INTO products(id, description, imageurl, name, price, category_id) VALUES(2, 'TV da LG', '', 'TV 4K HDR LG', 3000, 2) ON CONFLICT DO NOTHING;
INSERT INTO products(id, description, imageurl, name, price, category_id) VALUES(3, 'Kindle 11 paperwhite', '', 'Kindle 11 paperwhite', 500, 3) ON CONFLICT DO NOTHING;

INSERT INTO wishes(id, user_id, created_date, product_id) VALUES(1,1,CURRENT_TIMESTAMP,1) ON CONFLICT DO NOTHING;
INSERT INTO wishes(id, user_id, created_date, product_id) VALUES(2,2,CURRENT_TIMESTAMP,2) ON CONFLICT DO NOTHING;
INSERT INTO wishes(id, user_id, created_date, product_id) VALUES(3,3,CURRENT_TIMESTAMP,3) ON CONFLICT DO NOTHING;

INSERT INTO tokens(id, token, created_date, user_id) VALUES(1, 'abc', CURRENT_TIMESTAMP, 1);