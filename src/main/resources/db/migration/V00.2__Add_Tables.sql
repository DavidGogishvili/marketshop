

CREATE TABLE IF NOT EXISTS public.products
(
    id serial primary key,
    ean text unique,
    name text,
    company_id integer,
    country_id integer,
    description text,
    active boolean DEFAULT true,
    changed_by integer,
    changed_at timestamp without time zone,
    created_by integer,
    created_at timestamp without time zone
);



CREATE TABLE IF NOT EXISTS public.countries
(
    id integer primary key,
    iso_code_2 character varying(2) NOT NULL,
    iso_code_3 character varying(3) NOT NULL,
    name text,
    name_geo text
);





CREATE TABLE IF NOT EXISTS public.roles
(
    id bigint primary key,
    name text,
    description text
);


CREATE TABLE IF NOT EXISTS public.user_roles
(
    id bigint primary key,
    user_id integer,
    role_id integer
);


