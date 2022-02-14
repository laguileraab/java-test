CREATE TABLE IF NOT EXISTS menu (
    id INT PRIMARY KEY,
    mainDish VARCHAR(50) NULL,
    garrison VARCHAR(50) NULL,
    salad VARCHAR(50) NULL,
    desert VARCHAR(50) NULL,
    drink VARCHAR(50) NULL
    );
       
CREATE TABLE IF NOT EXISTS PERSON (
    name VARCHAR(50) PRIMARY KEY,
    preferredMenu INT NULL
    );