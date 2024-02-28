CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE app_user
(
    id                 UUID DEFAULT uuid_generate_v4() PRIMARY KEY NOT NULL,
    first_name         VARCHAR                                     NOT NULL,
    last_name          VARCHAR                                     NOT NULL,
    gender             VARCHAR                                     NOT NULL,
    date_of_birth      DATE                                        NOT NULL,
    email              VARCHAR                                     NOT NULL,
    phone_number       VARCHAR                                     NOT NULL,
    created_date       timestamp                                   NOT NULL,
    last_modified_date timestamp                                   NOT NULL,
    version            integer                                     NOT NULL
);