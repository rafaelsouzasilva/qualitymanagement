CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.incident (
    id UUID not null default uuid_generate_v4(),
    title varchar(255) not null,
    description varchar(255) not null,
    incident_date date not null,
    origin varchar(255) not null,
    enabled boolean,
    violated_rule_code varchar(255) not null,
    violated_rule_description varchar(255) not null,
    quality_control_id uuid,
    PRIMARY KEY (id),
    FOREIGN KEY (quality_control_id) REFERENCES quality_control (id)
);
