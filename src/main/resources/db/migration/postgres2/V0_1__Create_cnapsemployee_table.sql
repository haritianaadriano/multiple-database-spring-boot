CREATE TABLE cnapsemployee (
                               id SERIAL PRIMARY KEY,
                               cin VARCHAR(255),
                               cnaps VARCHAR(255),
                               image VARCHAR(255),
                               address VARCHAR(255),
                               last_name VARCHAR(255),
                               first_name VARCHAR(255),
                               personal_email VARCHAR(255),
                               professional_email VARCHAR(255),
                               registration_number VARCHAR(255),
                               birth_date DATE,
                               entrance_date DATE,
                               departure_date DATE,
                               children_number INTEGER
);
