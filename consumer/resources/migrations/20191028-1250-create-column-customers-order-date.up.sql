DELETE FROM order_products;
DELETE FROM orders;

ALTER TABLE orders
    ADD COLUMN order_date timestamp without time zone NOT NULL;