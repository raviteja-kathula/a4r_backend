-- AI Generated Code by Deloitte + Cursor (BEGIN)
-- Sample data for Crest & Thread E-commerce

-- Insert featured products
INSERT INTO products (title, category, type, description, price, image, badge, rating, rating_count, stock_quantity, is_featured, created_at, updated_at) VALUES
('Classic Tailored Blazer', 'WOMEN', 'outerwear', 'A timeless piece crafted from premium wool blend', 285.00, '/images/blazer.jpg', 'NEW', 4.8, 120, 50, true, NOW(), NOW()),
('Premium Cotton Shirt', 'MEN', 'tops', 'Refined sophistication for the modern gentleman', 145.00, '/images/cotton-shirt.jpg', NULL, 4.5, 89, 75, true, NOW(), NOW()),
('Luxury Wool Overcoat', 'MEN', 'outerwear', 'Exquisite craftsmanship meets contemporary style', 495.00, '/images/wool-coat.jpg', 'BESTSELLER', 4.9, 156, 30, true, NOW(), NOW()),
('Minimalist Turtleneck', 'WOMEN', 'tops', 'Essential wardrobe staple with clean lines', 125.00, '/images/turtleneck.jpg', NULL, 4.7, 93, 60, false, NOW(), NOW()),
('Leather Crossbody Bag', 'ACCESSORIES', 'bags', 'Handcrafted Italian leather in versatile design', 195.00, '/images/crossbody.jpg', 'NEW', 4.6, 78, 40, false, NOW(), NOW()),
('Cashmere V-Neck Sweater', 'WOMEN', 'tops', 'Luxuriously soft pure cashmere knit', 235.00, '/images/sweater.jpg', NULL, 4.8, 102, 45, false, NOW(), NOW()),
('Merino Wool Sweater', 'MEN', 'tops', 'Premium merino wool for superior comfort', 165.00, '/images/merino.jpg', NULL, 4.7, 67, 55, false, NOW(), NOW()),
('Silk Midi Dress', 'WOMEN', 'dresses', 'Elegant flowing silhouette in pure silk', 325.00, '/images/midi-dress.jpg', NULL, 4.9, 45, 25, false, NOW(), NOW()),
('Selvedge Denim Jeans', 'MEN', 'bottoms', 'Japanese selvedge denim with classic fit', 185.00, '/images/denim.jpg', NULL, 4.6, 112, 80, false, NOW(), NOW()),
('Cashmere Scarf', 'ACCESSORIES', 'scarves', 'Finest cashmere in sophisticated colorways', 145.00, '/images/scarf.jpg', NULL, 4.5, 56, 70, false, NOW(), NOW()),
('Structured Wool Blazer', 'MEN', 'outerwear', 'Impeccable tailoring in Italian wool', 395.00, '/images/wool-blazer.jpg', NULL, 4.7, 88, 35, false, NOW(), NOW()),
('Elegant Evening Dress', 'WOMEN', 'dresses', 'Show-stopping elegance for special occasions', 425.00, '/images/evening-dress.jpg', 'NEW', 4.8, 34, 20, false, NOW(), NOW());

-- Insert product colors
INSERT INTO product_colors (product_id, color) VALUES
(1, 'black'), (1, 'navy'), (1, 'grey'),
(2, 'white'), (2, 'blue'),
(3, 'black'), (3, 'navy'),
(4, 'cream'), (4, 'black'),
(5, 'black'), (5, 'tan'),
(6, 'blue'), (6, 'black'),
(7, 'grey'), (7, 'navy'), (7, 'black'),
(8, 'black'), (8, 'emerald'),
(9, 'indigo'), (9, 'black'),
(10, 'beige'), (10, 'grey'),
(11, 'navy'), (11, 'charcoal'),
(12, 'black'), (12, 'emerald');

-- Insert product sizes
INSERT INTO product_sizes (product_id, size) VALUES
(1, 'S'), (1, 'M'), (1, 'L'), (1, 'XL'),
(2, 'M'), (2, 'L'), (2, 'XL'),
(3, 'M'), (3, 'L'), (3, 'XL'), (3, 'XXL'),
(4, 'XS'), (4, 'S'), (4, 'M'), (4, 'L'),
(5, 'One Size'),
(6, 'S'), (6, 'M'), (6, 'L'),
(7, 'S'), (7, 'M'), (7, 'L'), (7, 'XL'),
(8, 'XS'), (8, 'S'), (8, 'M'), (8, 'L'),
(9, '30'), (9, '32'), (9, '34'), (9, '36'),
(10, 'One Size'),
(11, 'M'), (11, 'L'), (11, 'XL'),
(12, 'XS'), (12, 'S'), (12, 'M');

-- AI Generated Code by Deloitte + Cursor (END)
