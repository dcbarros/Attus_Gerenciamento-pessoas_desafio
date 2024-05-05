CREATE TABLE person (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    uuid UUID DEFAULT RANDOM_UUID(),
    name VARCHAR(255) NOT NULL,
    birthday DATE,
    is_active BOOLEAN,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    person_id BIGINT,
    cep VARCHAR(255),
    public_place VARCHAR(255),
    number INTEGER,
    city VARCHAR(255),
    state VARCHAR(255),
    is_principal BOOLEAN,
    FOREIGN KEY (person_id) REFERENCES person(id)
);
