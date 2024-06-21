-- public.drone definition

-- Drop table

-- DROP TABLE public.drone;

CREATE TABLE public.drone (
	id serial4 NOT NULL,
	latitude float8 NULL,
	longtitude float8 NULL,
	altitude float8 NULL,
	CONSTRAINT newtable_pk PRIMARY KEY (id)
);

ALTER TABLE public.drone ADD gcsid varchar NULL;

--------------------------------------------------------------
ALTER TABLE public.drone ADD battery_percentage integer NULL;
ALTER TABLE public.drone ADD yaw float8 NULL;
ALTER TABLE public.drone ADD vertical_speed float8 NULL;
ALTER TABLE public.drone ADD dist_to_mav float8 NULL;
-------------------------------------------------------------
ALTER TABLE public.drone ADD uid varchar NULL;
ALTER TABLE public.drone ADD ground_speed float8 NULL;
ALTER TABLE public.drone ADD dist_to_wp float8 NULL;