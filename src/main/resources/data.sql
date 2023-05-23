create table customer
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table transaction
(
    id               bigint auto_increment
        primary key,
    amount           double not null,
    customer_id      bigint null,
    transaction_date date   null
);


-- Insert sample customers
INSERT INTO customer (name)
VALUES ('Jeffrey Li');
INSERT INTO customer (name)
VALUES ('Mike Jordan');
INSERT INTO customer (name)
VALUES ('LeBron James');

-- Insert sample transactions for Jeffrey Li
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (1, 120.0, '2023-08-15');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (1, 80.0, '2023-07-20');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (1, 150.0, '2023-06-05');

-- Insert sample transactions for Mike Jordan
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (2, 70.0, '2022-11-10');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (2, 100.0, '2022-10-25');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (2, 50.0, '2022-12-15');

-- Insert sample transactions for LeBron
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (3, 300, '2022-12-10');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (3, 100.0, '2023-01-25');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (3, 200, '2023-03-15');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (3, 276, '2023-02-15');
INSERT INTO transaction (customer_id, amount, transaction_date)
VALUES (3, 189, '2023-04-15');

