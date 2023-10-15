--liquibase formatted sql
--changeset ardikapras:initial-1 logicalFilePath:path-independent

CREATE TABLE public.users
(
    user_id  SERIAL PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(20)  NOT NULL
);

CREATE TABLE public.customers
(
    customer_id SERIAL PRIMARY KEY,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    email       VARCHAR(100),
    phone       VARCHAR(20),
    address     TEXT,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW()
);

CREATE TABLE public.products
(
    product_id  SERIAL PRIMARY KEY,
    name        VARCHAR(100)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    quantity    INT            NOT NULL,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW()
);

-- Table for Orders
CREATE TABLE public.orders
(
    order_id     SERIAL PRIMARY KEY,
    user_id      INT REFERENCES users (user_id),
    customer_id  INT REFERENCES customers (customer_id),
    order_date   TIMESTAMPTZ DEFAULT NOW(),
    total_amount DECIMAL(10, 2) NOT NULL
);

-- Table for Order Items (Many-to-Many relationship between Orders and Products)
CREATE TABLE public.order_items
(
    order_item_id SERIAL PRIMARY KEY,
    order_id      INT REFERENCES orders (order_id),
    product_id    INT REFERENCES products (product_id),
    quantity      INT            NOT NULL,
    unit_price    NUMERIC(10, 2) NOT NULL,
    total_price   NUMERIC(10, 2) NOT NULL
);

ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA public GRANT SELECT ON TABLES TO posreadonly;
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA public GRANT SELECT, INSERT, UPDATE ON TABLES TO pos_app_user;

-- PostgreSQL database dump complete
