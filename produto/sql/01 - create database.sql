-- Database: cli03

-- DROP DATABASE cli03;

CREATE DATABASE cli03
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

-- Table: public.cidade

-- DROP TABLE public.cidade;

CREATE TABLE public.cidade
(
  codigo integer NOT NULL,
  nome character varying(60),
  latitude integer NOT NULL,
  longitude integer NOT NULL,
  CONSTRAINT pk PRIMARY KEY (codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.cidade
  OWNER TO postgres;
