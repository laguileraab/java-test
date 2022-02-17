CREATE TABLE IF NOT EXISTS MENU (
    ID uuid default random_uuid() PRIMARY KEY,
    DATE date NOT NULL,
    OPTIONS LONGVARCHAR NOT NULL
    );
CREATE TABLE IF NOT EXISTS PERSON (
    EMAIL VARCHAR(50) PRIMARY KEY,
    PASSWORD VARCHAR(50) NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    PREFERREDMENU VARCHAR(255) NULL
    );