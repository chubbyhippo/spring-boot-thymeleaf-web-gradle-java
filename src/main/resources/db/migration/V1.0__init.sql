CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE thymeleaf_user
(
    id            UUID DEFAULT uuid_generate_v4() PRIMARY KEY NOT NULL,
    first_name    VARCHAR                                     NOT NULL,
    last_name     VARCHAR                                     NOT NULL,
    gender        VARCHAR                                     NOT NULL,
    date_of_birth DATE                                        NOT NULL,
    email         VARCHAR                                     NOT NULL,
    phone_number  VARCHAR                                     NOT NULL
);