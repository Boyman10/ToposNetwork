
CREATE SEQUENCE public.climb_grade_id_seq;

CREATE TABLE public.climb_grade (
                id INTEGER NOT NULL DEFAULT nextval('public.climb_grade_id_seq'),
                details VARCHAR,
                level VARCHAR NOT NULL,
                CONSTRAINT id_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.climb_grade_id_seq OWNED BY public.climb_grade.id;

CREATE SEQUENCE public.climb_site_id_seq;

CREATE TABLE public.climb_site (
                id INTEGER NOT NULL DEFAULT nextval('public.climb_site_id_seq'),
                location VARCHAR NOT NULL,
                region VARCHAR NOT NULL,
                department VARCHAR NOT NULL,
                name VARCHAR NOT NULL,
                country VARCHAR NOT NULL,
                type VARCHAR NOT NULL,
                CONSTRAINT site_id_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.climb_site_id_seq OWNED BY public.climb_site.id;

CREATE SEQUENCE public.climb_area_id_seq;

CREATE TABLE public.climb_area (
                id INTEGER NOT NULL DEFAULT nextval('public.climb_area_id_seq'),
                name VARCHAR NOT NULL,
                details VARCHAR NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT area_id_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.climb_area_id_seq OWNED BY public.climb_area.id;

CREATE SEQUENCE public.climb_route_id_seq;

CREATE TABLE public.climb_route (
                id INTEGER NOT NULL DEFAULT nextval('public.climb_route_id_seq'),
                name VARCHAR NOT NULL,
                grade_id INTEGER NOT NULL,
                area_id INTEGER NOT NULL,
                details VARCHAR NOT NULL,
                summit NUMERIC NOT NULL,
                nb_points INTEGER,
                CONSTRAINT route_id_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.climb_route_id_seq OWNED BY public.climb_route.id;

CREATE SEQUENCE public.climb_role_id_seq;

CREATE TABLE public.climb_role (
                id INTEGER NOT NULL DEFAULT nextval('public.climb_role_id_seq'),
                name VARCHAR NOT NULL,
                CONSTRAINT role_id PRIMARY KEY (id)
);


ALTER SEQUENCE public.climb_role_id_seq OWNED BY public.climb_role.id;

CREATE SEQUENCE public.climb_id_seq;

CREATE TABLE public.climb_user (
                id INTEGER NOT NULL DEFAULT nextval('public.climb_id_seq'),
                username VARCHAR NOT NULL,
                pass VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                datereg DATE NOT NULL,
                role_id INTEGER NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


ALTER SEQUENCE public.climb_id_seq OWNED BY public.climb_user.id;

CREATE UNIQUE INDEX climb_user_idx
 ON public.climb_user
 ( email );

CREATE UNIQUE INDEX climb_user_idx1
 ON public.climb_user
 ( username );

ALTER TABLE public.climb_route ADD CONSTRAINT climb_grade_climb_route_fk
FOREIGN KEY (grade_id)
REFERENCES public.climb_grade (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.climb_area ADD CONSTRAINT climb_site_climb_area_fk
FOREIGN KEY (site_id)
REFERENCES public.climb_site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.climb_route ADD CONSTRAINT climb_area_climb_route_fk
FOREIGN KEY (area_id)
REFERENCES public.climb_area (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.climb_user ADD CONSTRAINT climb_role_climb_user_fk
FOREIGN KEY (role_id)
REFERENCES public.climb_role (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
