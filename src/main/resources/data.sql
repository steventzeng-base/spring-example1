INSERT INTO ACCOUNT(NAME, AMOUNT)VALUES('Boss', 200000.00);
INSERT INTO ACCOUNT(NAME, AMOUNT)VALUES('Brian', 20000.00);
INSERT INTO ACCOUNT(NAME, AMOUNT)VALUES('Shirly', 40000.00);
INSERT INTO ACCOUNT(NAME, AMOUNT)VALUES('David', 80000.00);
INSERT INTO ACCOUNT(NAME, AMOUNT)VALUES('Alix', 60000.00);
INSERT INTO ACCOUNT(NAME, AMOUNT)VALUES('Stockholder', 1000000000.00);
ALTER TABLE ACCOUNT ADD CONSTRAINT AMOUNT_GE_ZERO CHECK(AMOUNT >= 0);
