    DROP TABLE IF EXISTS MENU;
    CREATE TABLE MENU (
    id INT PRIMARY KEY,
    MAINDISH VARCHAR(50) NULL,
    GARRISON VARCHAR(50) NULL,
    SALAD VARCHAR(50) NULL,
    DESSERT VARCHAR(50) NULL,
    DRINK VARCHAR(50) NULL
    );
       
       DROP TABLE IF EXISTS PERSON;
    CREATE TABLE PERSON (
    NAME VARCHAR(50) PRIMARY KEY,
    PREFERREDMENU INT NULL
    );