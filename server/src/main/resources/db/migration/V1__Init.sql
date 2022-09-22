CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT uuid_generate_v4();

CREATE TABLE IF NOT EXISTS public.armors
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    defense integer NOT NULL,
    level integer NOT NULL,
    heaviness integer NOT NULL,
    CONSTRAINT pk_armors PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.armors
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.headgears
(
    id uuid NOT NULL,
    defense integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    heaviness integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT headgears_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.headgears
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.shields
(
    id uuid NOT NULL,
    attack integer NOT NULL,
    defense integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    heaviness integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT shields_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.shields
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.weapons
(
    id uuid NOT NULL,
    attack integer NOT NULL,
    category character varying(255) COLLATE pg_catalog."default" NOT NULL,
    defense integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    heaviness integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT weapons_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.weapons
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_armor
(
    id uuid NOT NULL,
    defense integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    heaviness integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_armor_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_armor
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_headgear
(
    id uuid NOT NULL,
    defense integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    heaviness integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_headgear_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_headgear
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_shield
(
    id uuid NOT NULL,
    attack integer NOT NULL,
    defense integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    heaviness integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_shield_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_shield
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_weapon
(
    id uuid NOT NULL,
    attack integer NOT NULL,
    category character varying(255) COLLATE pg_catalog."default" NOT NULL,
    defense integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    heaviness integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_weapon_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_weapon
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.users
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp without time zone NOT NULL DEFAULT now(),
    role character varying(255) COLLATE pg_catalog."default" NOT NULL,
    armor_id uuid,
    headgear_id uuid,
    shield_id uuid,
    weapon_id uuid,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT users_email_key UNIQUE (email),
    CONSTRAINT fk55xe93ntt3gse9csqh56cp2c3 FOREIGN KEY (armor_id)
        REFERENCES public.user_armor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk9l017ssyghu83yaiegoea6mdw FOREIGN KEY (headgear_id)
        REFERENCES public.user_headgear (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkkq4foncp1k6iegbpiquxwll12 FOREIGN KEY (shield_id)
        REFERENCES public.user_shield (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkrxmn13l1fwej9ary2b6ysfp2p FOREIGN KEY (weapon_id)
        REFERENCES public.user_weapon (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_armor_user
(
    user_armor_id uuid NOT NULL,
    user_id uuid NOT NULL,
    CONSTRAINT uk_r1qwbspc55uaxtseexwik9vou UNIQUE (user_id),
    CONSTRAINT fkebbs0w0pxhdaqm7cm623ps7t0 FOREIGN KEY (user_armor_id)
        REFERENCES public.user_armor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkqur0ck851j08s7en291ugtxqn FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_armor_user
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_headgear_user
(
    user_headgear_id uuid NOT NULL,
    user_id uuid NOT NULL,
    CONSTRAINT uk_fvpmrxry3tmrvdbt90u5embg8 UNIQUE (user_id),
    CONSTRAINT fkak82i37e18tkdkfjdcuw5yd83 FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkq9lqi5x9pd7jvmuc4o0ee7o3o FOREIGN KEY (user_headgear_id)
        REFERENCES public.user_headgear (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_headgear_user
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_shield_user
(
    user_shield_id uuid NOT NULL,
    user_id uuid NOT NULL,
    CONSTRAINT uk_tf7vhr8kjittrapjeenu5us9y UNIQUE (user_id),
    CONSTRAINT fkmjihbak70uj275hnf2l67xp9m FOREIGN KEY (user_shield_id)
        REFERENCES public.user_shield (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkslel5xvo7fwd9ertaxu3v37er FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_shield_user
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_weapon_user
(
    user_weapon_id uuid NOT NULL,
    user_id uuid NOT NULL,
    CONSTRAINT uk_s4tq67nr3smgepmynvq3u0kt6 UNIQUE (user_id),
    CONSTRAINT fk3j6xw0drsv8yl7vpbsxrlmynk FOREIGN KEY (user_weapon_id)
        REFERENCES public.user_weapon (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkbk0m9t1mr7evnqg6uqrkntd11 FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_weapon_user
    OWNER to postgres;