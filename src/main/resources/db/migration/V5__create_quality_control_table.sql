CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.quality_control (
    id UUID not null default uuid_generate_v4(),
    evaluation_date datetime,
    parametrization_quality_control_id uuid,
    employee_id uuid,
    enabled boolean,
    closed boolean,
    PRIMARY KEY (id),
    FOREIGN KEY (parametrization_quality_control_id) REFERENCES parametrization_quality_control (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);
