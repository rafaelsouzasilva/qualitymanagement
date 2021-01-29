CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.process (
    id uuid not null default uuid_generate_v4(),
    name varchar(255) not null,
    description varchar(255) not null,
    tasks varchar(255) not null,
    enabled boolean,
    PRIMARY KEY (id)
);

insert into process (name, description, tasks, enabled) values (
    'Avaliação de porta',
    'Verificar se porta tem algum risco',
    'Avaliar porta na luz azul',
    true
);
