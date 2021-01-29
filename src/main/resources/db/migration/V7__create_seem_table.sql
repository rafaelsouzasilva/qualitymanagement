CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.seem (
    id uuid not null default uuid_generate_v4(),
    description varchar(255) not null,
    seem_date date not null,
    conclusive boolean,
    incident_id uuid,
    enabled boolean,
    PRIMARY KEY (id),
    FOREIGN KEY (incident_id) REFERENCES incident (id)
);
