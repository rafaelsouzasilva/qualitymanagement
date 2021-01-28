CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.profile (
    id UUID not null default uuid_generate_v4(),
    name varchar(30),
    enabled boolean default true,
    PRIMARY KEY(id)
);

CREATE TABLE public.users (
    id UUID not null default uuid_generate_v4(),
    email varchar(255),
    password varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.users_profile (
    profile_id UUID not null,
    user_id UUID not null,
    primary key (profile_id, user_id),
    foreign key (profile_id) references profile (id),
    foreign key (user_id) references users (id)
);

INSERT INTO profile (name, enabled) VALUES ('admin', true);
INSERT INTO users (email, password) VALUES ('rafael.souza.silva@hotmail.com.br', '$2a$10$ydIb2SITXDZFqFfLkGurwOcyKk3XQJCULde13a1hORPufCh22bamy');
INSERT INTO users_profile (profile_id, user_id) VALUES (
    (SELECT id FROM profile WHERE name = 'admin'),
    (SELECT id FROM users WHERE email = 'rafael.souza.silva@hotmail.com.br')
);