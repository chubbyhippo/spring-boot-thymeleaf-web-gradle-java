CREATE TYPE gender AS ENUM('MALE', 'FEMALE', 'OTHER', 'UNKNOWN');
CREATE TABLE thymeleaf_user
(
    id            UUID PRIMARY KEY NOT NULL,
    first_name    VARCHAR          NOT NULL,
    last_name     VARCHAR          NOT NULL,
    gender        gender           NOT NULL,
    date_of_birth DATE             NOT NULL,
    email         VARCHAR          NOT NULL,
    phone_number  VARCHAR          NOT NULL
);