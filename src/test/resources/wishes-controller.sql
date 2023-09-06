INSERT INTO users(id, first_name, last_name, email, password) VALUES(1, 'Gabriel', 'Silva', 'gabriel@email.com', 'senha') ON CONFLICT DO NOTHING;
INSERT INTO users(id, first_name, last_name, email, password) VALUES(2, 'Lucas', 'Moura', 'lucas@email.com', 'senha') ON CONFLICT DO NOTHING;

INSERT INTO tokens(id, token, created_date, user_id) VALUES(1, 'token', CURRENT_TIMESTAMP, 1) ON CONFLICT DO NOTHING;
INSERT INTO tokens(id, token, created_date, user_id) VALUES(2, 'token2', CURRENT_TIMESTAMP, 1) ON CONFLICT DO NOTHING;

INSERT INTO categories(id, category_name, description, image_url) VALUES (1, 'Smartphone', 'Smartphone', '') ON CONFLICT DO NOTHING;

INSERT INTO products(id, description, imageurl, name, price, category_id) VALUES(1, 'Iphone X', '', 'Iphone X', 2000, 1) ON CONFLICT DO NOTHING;

INSERT INTO wishes(id, user_id, created_date, product_id) VALUES(1,1,CURRENT_TIMESTAMP,1) ON CONFLICT DO NOTHING;