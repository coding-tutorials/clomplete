CREATE TABLE order_products
(
  id uuid NOT NULL PRIMARY KEY,
  order_id uuid NOT NULL,
  product_id uuid NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders(id)
  FOREIGN KEY (product_id) REFERENCES products(id)
)
