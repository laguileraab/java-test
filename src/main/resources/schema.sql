CREATE TABLE IF NOT EXISTS MENU (
    ID uuid default random_uuid() PRIMARY KEY,
    MAINDISH VARCHAR(50) NULL,
    GARRISON VARCHAR(50) NULL,
    SALAD VARCHAR(50) NULL,
    DESSERT VARCHAR(50) NULL,
    DRINK VARCHAR(50) NULL
    );
CREATE TABLE IF NOT EXISTS PERSON (
    EMAIL VARCHAR(50) PRIMARY KEY,
    PASSWORD VARCHAR(50) NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    PREFERREDMENU INT NULL,
    MAINDISH VARCHAR(50) NULL,
    GARRISON VARCHAR(50) NULL,
    SALAD VARCHAR(50) NULL,
    DESSERT VARCHAR(50) NULL,
    DRINK VARCHAR(50) NULL
    );