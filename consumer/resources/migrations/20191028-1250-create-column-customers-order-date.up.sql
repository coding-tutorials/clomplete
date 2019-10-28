DELETE FROM order_products;
DELETE FROM orders;
DELETE FROM customers;
DELETE FROM products;

ALTER TABLE orders
    ADD COLUMN order_date timestamp without time zone NOT NULL;