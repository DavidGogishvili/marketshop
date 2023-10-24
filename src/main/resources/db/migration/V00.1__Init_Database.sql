CREATE TABLE IF NOT EXISTS public.users
(
    id serial primary key,
    email character varying  NOT NULL UNIQUE,
    password character varying,
    first_name text,
    last_name text,
    last_login_date timestamp with time zone,
    active boolean DEFAULT true,
    changed_by integer,
    changed_at timestamp without time zone,
    created_by integer,
    created_at timestamp without time zone
);



CREATE TABLE IF NOT EXISTS public.companies
(
    id serial primary key ,
    parent_id integer,
    country_id integer,
    name text,
    name_geo text,
    active boolean DEFAULT true,
    changed_by integer,
    changed_at timestamp without time zone,
    created_by integer,
    created_at timestamp without time zone

);
