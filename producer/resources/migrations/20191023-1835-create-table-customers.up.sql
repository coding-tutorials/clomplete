CREATE TABLE customers
(
  id uuid NOT NULL PRIMARY KEY,
  name character varying NOT NULL,
  created_on timestamp without time zone NOT NULL,
  edited_on timestamp without time zone,
  deleted_on timestamp without time zone,
)
