CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.parametrization_quality_control (
    id uuid not null default uuid_generate_v4(),
    description varchar(255) not null,
    start_time_allowed time,
    end_time_allowed time,
    process_id uuid,
    PRIMARY KEY (id),
    FOREIGN KEY (process_id) REFERENCES process (id)
);

insert into parametrization_quality_control (description, start_time_allowed, end_time_allowed, process_id) values (
    'Parametrização Avaliação de Porta',
    '00:01',
    '23:59',
    (select id from process where name = 'Avaliação de porta')
);
