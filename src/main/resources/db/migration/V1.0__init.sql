CREATE TABLE user
(
    id           UUID PRIMARY KEY NOT NULL,
    first_name   VARCHAR          NOT NULL,
    last_name    VARCHAR          NOT NULL,
    gender       VARCHAR          NOT NULL,
    birthday     DATE             NOT NULL,
    email        VARCHAR          NOT NULL,
    phone_number VARCHAR          NOT NULL,

);