INSERT INTO categories(id, category_name, description, image_url) VALUES (1, 'Smartphone', 'Smartphone', '') ON CONFLICT DO NOTHING;
INSERT INTO categories(id, category_name, description, image_url) VALUES (2, 'E-reader', 'Kindle', '') ON CONFLICT DO NOTHING;
INSERT INTO categories(id, category_name, description, image_url) VALUES (3, 'CPU', 'Ryzen 5', '') ON CONFLICT DO NOTHING;