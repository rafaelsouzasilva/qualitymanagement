CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.quality_control (
    id UUID not null default uuid_generate_v4(),
    evaluation_date date,
    parametrization_quality_control_id uuid,
    employee_id uuid,
    enabled boolean,
    closed boolean,
    PRIMARY KEY (id),
    FOREIGN KEY (parametrization_quality_control_id) REFERENCES parametrization_quality_control (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);

insert into quality_control (evaluation_date, parametrization_quality_control_id, employee_id, enabled, closed) values (
    '2021-01-28 17:00:00',
    (select id from parametrization_quality_control where description = 'Parametrização Avaliação de Porta'),
    (select id from employee where name = 'Rafael Silva'),
    true,
    false
);
