CREATE TABLE orders
(
  id uuid NOT NULL PRIMARY KEY,
  customer_id uuid NOT NULL,
  created_on timestamp without time zone NOT NULL,
  edited_on timestamp without time zone,
  deleted_on timestamp without time zone,
  FOREIGN KEY (customer_id) REFERENCES customers(id)
)
