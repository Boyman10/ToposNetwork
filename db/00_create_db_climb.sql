
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
                gravatar VARCHAR(25),
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

ALTER TABLE public.climb_user ADD CONSTRAINT climb_role_climb_user_fk
FOREIGN KEY (role_id)
REFERENCES public.climb_role (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
