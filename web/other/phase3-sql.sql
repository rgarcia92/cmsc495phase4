ALTER TABLE USERS ADD COLUMN [NEWLOGIN] TEXT(32) NOT NULL;
UPDATE USERS SET NEWLOGIN='Sun Jan 01 12:01:00 EST 2017';