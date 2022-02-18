CREATE TABLE IF NOT EXISTS MENU (
    ID uuid default random_uuid() PRIMARY KEY,
    DATE date NOT NULL UNIQUE,
    OPTION1 VARCHAR(255) NOT NULL,
    OPTION2 VARCHAR(255) NULL,
    OPTION3 VARCHAR(255) NULL,
    OPTION4 VARCHAR(255) NULL,
    OPTION5 VARCHAR(255) NULL
    );
CREATE TABLE IF NOT EXISTS PERSON (
    EMAIL VARCHAR(50) PRIMARY KEY,
    PASSWORD VARCHAR(50) NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    NATIONALITY VARCHAR(50) NOT NULL,
    PREFERREDMENU VARCHAR(255) NULL,
    DATE date NULL,
    
    );