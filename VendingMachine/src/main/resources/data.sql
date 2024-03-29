INSERT INTO ROLE (ROLE_ID, ROLE) VALUES (NEXTVAL('ROLE_SEQ'), 'ADMIN');
INSERT INTO ROLE (ROLE_ID, ROLE) VALUES (NEXTVAL('ROLE_SEQ'), 'USER');

INSERT INTO USER (USER_ID, NAME, PASSWORD, EMAIL, ACTIVE, ACCOUNT_BALANCE) VALUES (NEXTVAL('USER_SEQ'), 'Wipro123', '$2a$10$rRxXTVduKBh0OEF5MlGeRerzYyM2q.CoozcaNMWJDhwV8SAwhb6ja', 'Wipro123@wipro', 1, 20.25);
INSERT INTO USER (USER_ID, NAME, PASSWORD, EMAIL, ACTIVE, ACCOUNT_BALANCE) VALUES (NEXTVAL('USER_SEQ'), 'Hca123', '$2a$10$z1tdYH22JjqsqU8EzslHbuQfJ6lLlnHWPE1s6Ip1J/o7JGha2yV9e', 'Hca123@hca', 1, 15.66);

INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (2, 2);


INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Thums Up', 1.25, 19, '1.5 ltr');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Pepsi', 1.05, 14, '1 ltr');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Sprite', 1.50, 21, '1.5 ltr');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Coca Cola', 0.95, 17, '500 ml');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Mazza', 1.00, 13, '1.5 ltr');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Mountain Dew', 1.75, 19, '1 ltr');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Miranda', 0.75, 14, '300 ml');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Fanta', 0.62, 14, '250 ml');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Slice', 0.90, 13, '500 ml');
INSERT INTO PRODUCT (ID, NAME, PRICE, QUANTITY, SIZE) VALUES (NEXTVAL('PRODUCT_SEQ'), 'Limca', 0.50, 17, '250 ml');