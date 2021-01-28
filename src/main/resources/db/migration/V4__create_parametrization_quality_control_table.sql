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
