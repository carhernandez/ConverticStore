--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6
-- Dumped by pg_dump version 14.6

-- Started on 2023-03-16 08:41:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 33495)
-- Name: carrito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carrito (
    id_carrito integer NOT NULL,
    cantidad integer,
    estado character varying(255),
    fecha date,
    producto integer,
    usuario integer
);


ALTER TABLE public.carrito OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 33494)
-- Name: carrito_id_carrito_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carrito_id_carrito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carrito_id_carrito_seq OWNER TO postgres;

--
-- TOC entry 3426 (class 0 OID 0)
-- Dependencies: 209
-- Name: carrito_id_carrito_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.carrito_id_carrito_seq OWNED BY public.carrito.id_carrito;


--
-- TOC entry 231 (class 1259 OID 33633)
-- Name: carrito_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carrito_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carrito_seq OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 33502)
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ciudad (
    id_ciudad integer NOT NULL,
    ciudad character varying(255)
);


ALTER TABLE public.ciudad OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 33501)
-- Name: ciudad_id_ciudad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ciudad_id_ciudad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ciudad_id_ciudad_seq OWNER TO postgres;

--
-- TOC entry 3427 (class 0 OID 0)
-- Dependencies: 211
-- Name: ciudad_id_ciudad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ciudad_id_ciudad_seq OWNED BY public.ciudad.id_ciudad;


--
-- TOC entry 214 (class 1259 OID 33509)
-- Name: color; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.color (
    id_color integer NOT NULL,
    color character varying(255)
);


ALTER TABLE public.color OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 33508)
-- Name: color_id_color_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.color_id_color_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.color_id_color_seq OWNER TO postgres;

--
-- TOC entry 3428 (class 0 OID 0)
-- Dependencies: 213
-- Name: color_id_color_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.color_id_color_seq OWNED BY public.color.id_color;


--
-- TOC entry 216 (class 1259 OID 33516)
-- Name: envio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.envio (
    id_envio integer NOT NULL,
    direccion character varying(255),
    fecha date,
    telefono character varying(255),
    ciudad integer,
    factura integer
);


ALTER TABLE public.envio OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 33515)
-- Name: envio_id_envio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.envio_id_envio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.envio_id_envio_seq OWNER TO postgres;

--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 215
-- Name: envio_id_envio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.envio_id_envio_seq OWNED BY public.envio.id_envio;


--
-- TOC entry 218 (class 1259 OID 33525)
-- Name: factura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.factura (
    id_factura integer NOT NULL,
    fecha date,
    iva real,
    total real,
    carrito integer,
    usuario integer
);


ALTER TABLE public.factura OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 33524)
-- Name: factura_id_factura_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.factura_id_factura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.factura_id_factura_seq OWNER TO postgres;

--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 217
-- Name: factura_id_factura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.factura_id_factura_seq OWNED BY public.factura.id_factura;


--
-- TOC entry 220 (class 1259 OID 33532)
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genero (
    id_genero integer NOT NULL,
    genero character varying(255)
);


ALTER TABLE public.genero OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33531)
-- Name: genero_id_genero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genero_id_genero_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genero_id_genero_seq OWNER TO postgres;

--
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 219
-- Name: genero_id_genero_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genero_id_genero_seq OWNED BY public.genero.id_genero;


--
-- TOC entry 222 (class 1259 OID 33539)
-- Name: marca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marca (
    id_marca integer NOT NULL,
    marca character varying(255)
);


ALTER TABLE public.marca OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33538)
-- Name: marca_id_marca_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marca_id_marca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marca_id_marca_seq OWNER TO postgres;

--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 221
-- Name: marca_id_marca_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marca_id_marca_seq OWNED BY public.marca.id_marca;


--
-- TOC entry 224 (class 1259 OID 33546)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    id_producto integer NOT NULL,
    cantidad integer,
    descripcion character varying(255),
    mas_buscados integer,
    valor real,
    color integer,
    genero integer,
    marca integer,
    talla integer,
    imagen character varying(255)
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 33545)
-- Name: producto_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.producto_id_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_id_producto_seq OWNER TO postgres;

--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 223
-- Name: producto_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.producto_id_producto_seq OWNED BY public.producto.id_producto;


--
-- TOC entry 226 (class 1259 OID 33553)
-- Name: talla; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.talla (
    id_talla integer NOT NULL,
    talla character varying(255)
);


ALTER TABLE public.talla OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 33552)
-- Name: talla_id_talla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.talla_id_talla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.talla_id_talla_seq OWNER TO postgres;

--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 225
-- Name: talla_id_talla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.talla_id_talla_seq OWNED BY public.talla.id_talla;


--
-- TOC entry 228 (class 1259 OID 33560)
-- Name: tipo_documento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_documento (
    id_tipo_documento integer NOT NULL,
    documento character varying(255)
);


ALTER TABLE public.tipo_documento OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 33559)
-- Name: tipo_documento_id_tipo_documento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_documento_id_tipo_documento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_documento_id_tipo_documento_seq OWNER TO postgres;

--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 227
-- Name: tipo_documento_id_tipo_documento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_documento_id_tipo_documento_seq OWNED BY public.tipo_documento.id_tipo_documento;


--
-- TOC entry 230 (class 1259 OID 33567)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    apellidos character varying(255),
    contrasena character varying(255),
    correo character varying(255),
    n_documento integer,
    nombres character varying(255),
    tipo_documento integer
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 33566)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 3436 (class 0 OID 0)
-- Dependencies: 229
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 3215 (class 2604 OID 33498)
-- Name: carrito id_carrito; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrito ALTER COLUMN id_carrito SET DEFAULT nextval('public.carrito_id_carrito_seq'::regclass);


--
-- TOC entry 3216 (class 2604 OID 33505)
-- Name: ciudad id_ciudad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad ALTER COLUMN id_ciudad SET DEFAULT nextval('public.ciudad_id_ciudad_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 33512)
-- Name: color id_color; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color ALTER COLUMN id_color SET DEFAULT nextval('public.color_id_color_seq'::regclass);


--
-- TOC entry 3218 (class 2604 OID 33519)
-- Name: envio id_envio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.envio ALTER COLUMN id_envio SET DEFAULT nextval('public.envio_id_envio_seq'::regclass);


--
-- TOC entry 3219 (class 2604 OID 33528)
-- Name: factura id_factura; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura ALTER COLUMN id_factura SET DEFAULT nextval('public.factura_id_factura_seq'::regclass);


--
-- TOC entry 3220 (class 2604 OID 33535)
-- Name: genero id_genero; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero ALTER COLUMN id_genero SET DEFAULT nextval('public.genero_id_genero_seq'::regclass);


--
-- TOC entry 3221 (class 2604 OID 33542)
-- Name: marca id_marca; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca ALTER COLUMN id_marca SET DEFAULT nextval('public.marca_id_marca_seq'::regclass);


--
-- TOC entry 3222 (class 2604 OID 33549)
-- Name: producto id_producto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto ALTER COLUMN id_producto SET DEFAULT nextval('public.producto_id_producto_seq'::regclass);


--
-- TOC entry 3223 (class 2604 OID 33556)
-- Name: talla id_talla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.talla ALTER COLUMN id_talla SET DEFAULT nextval('public.talla_id_talla_seq'::regclass);


--
-- TOC entry 3224 (class 2604 OID 33563)
-- Name: tipo_documento id_tipo_documento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento ALTER COLUMN id_tipo_documento SET DEFAULT nextval('public.tipo_documento_id_tipo_documento_seq'::regclass);


--
-- TOC entry 3225 (class 2604 OID 33570)
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 3399 (class 0 OID 33495)
-- Dependencies: 210
-- Data for Name: carrito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carrito (id_carrito, cantidad, estado, fecha, producto, usuario) FROM stdin;
1	1	activo	2024-01-03	1	1
2	1	activo	2023-03-13	1	\N
3	1	activo	2023-03-13	1	\N
4	1	activo	2023-03-14	1	\N
5	2	activo	2023-03-14	1	\N
6	2	activo	2023-03-14	1	\N
7	2	activo	2023-03-14	1	\N
8	2	activo	2023-03-14	1	\N
9	2	activo	2023-03-14	1	\N
10	1	activo	2023-03-14	3	\N
11	0	activo	2023-03-14	9	\N
12	1	activo	2023-03-14	1	\N
13	1	activo	2023-03-14	1	\N
14	1	activo	2023-03-14	1	\N
15	0	activo	2023-03-15	1	\N
16	1	activo	2023-03-15	1	\N
17	1	activo	2023-03-15	10	\N
\.


--
-- TOC entry 3401 (class 0 OID 33502)
-- Dependencies: 212
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ciudad (id_ciudad, ciudad) FROM stdin;
\.


--
-- TOC entry 3403 (class 0 OID 33509)
-- Dependencies: 214
-- Data for Name: color; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.color (id_color, color) FROM stdin;
1	NEGRO
2	AZUL
3	BLANCO
4	ROJO
\.


--
-- TOC entry 3405 (class 0 OID 33516)
-- Dependencies: 216
-- Data for Name: envio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.envio (id_envio, direccion, fecha, telefono, ciudad, factura) FROM stdin;
\.


--
-- TOC entry 3407 (class 0 OID 33525)
-- Dependencies: 218
-- Data for Name: factura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.factura (id_factura, fecha, iva, total, carrito, usuario) FROM stdin;
\.


--
-- TOC entry 3409 (class 0 OID 33532)
-- Dependencies: 220
-- Data for Name: genero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genero (id_genero, genero) FROM stdin;
1	HOMBRE 
2	MUJER
\.


--
-- TOC entry 3411 (class 0 OID 33539)
-- Dependencies: 222
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marca (id_marca, marca) FROM stdin;
1	LEVIS
2	TOMMY HILFIGER
3	MARITHE FRANCOIS
\.


--
-- TOC entry 3413 (class 0 OID 33546)
-- Dependencies: 224
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (id_producto, cantidad, descripcion, mas_buscados, valor, color, genero, marca, talla, imagen) FROM stdin;
2	100	BLUSA	4	70000	2	2	2	1	blusaAzul.jpg
3	100	JEAN HOMBRE	15	140000	1	1	3	17	brandon-webb-GNPCqlUex8U-unsplash.jpg
5	100	JEAN HOMBRE	3	145000	2	1	2	16	jeanAzul.jpg
7	100	JEAN HOMBRE	3	95000	4	1	1	17	pantalonrojo.jpg
10	100	JEAN MUJER	0	145000	1	2	2	12	Jean-Skinny-Stacys-Mujer-Negro-1.jpg
4	100	JEAN MUJER	2	120000	4	2	1	9	672291b8e41e1d6f22cf3578a6029d79.jpg
11	100	BLUSA	\N	85000	1	2	3	4	blusaNegra.jpg
9	100	CAMISETA	0	90000	1	1	1	4	Camisetanegra.jpg
12	100	CHAQUETA	\N	220000	2	1	3	4	chaquetaAzul.jpg
1	100	CAMISA	22	90000	1	1	1	4	busohombre.jpg
8	100	CAMISA	14	90000	1	1	2	6	camisanegra.jpg
6	100	CAMISA	14	110000	3	1	3	3	camisa.jpg
\.


--
-- TOC entry 3415 (class 0 OID 33553)
-- Dependencies: 226
-- Data for Name: talla; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.talla (id_talla, talla) FROM stdin;
1	XS
2	S
3	M
4	L
5	XL
6	XXL
7	4
8	6
9	8
10	10
11	12
12	14
13	28
14	30
15	32
16	34
17	36
\.


--
-- TOC entry 3417 (class 0 OID 33560)
-- Dependencies: 228
-- Data for Name: tipo_documento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_documento (id_tipo_documento, documento) FROM stdin;
3	PASAPORTE
4	OTRO
1	CÉDULA
2	CÉDULA EXTRANJERIA
\.


--
-- TOC entry 3419 (class 0 OID 33567)
-- Dependencies: 230
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id_usuario, apellidos, contrasena, correo, n_documento, nombres, tipo_documento) FROM stdin;
1	HERNÁNDEZ PIEDRAHITA 	Carlos*	carlos176264@gmail.com	70879140	CARLOS EDUARDO	1
2	romero	Diego*	diego@gmail.com	12345	diego	1
3	echeverry	Saul*	saul@gmail.com	123456	saul	1
4	hernandez	Mariangel*	mariangel@gmail.com	123456	mariangel	1
5	castro	Alejandro*	alejandro@gmail.com	987654	alejandro	1
6	palacios	Isaac*	isaac@gmail.com	123456	isaac	1
7	piedrahita	Carlos1*	carlos1@gmail.com	123465	carlos	1
8	restrepo	Jorge*	jorge@gmail.com	32568	jorge alberto	1
9	correa	Diana*-	diana@gmail.com	546789	diana	1
10	goez	Alejandra*	alejandra@gmail.com	2356	alejandra	1
11	montoya	Daniel*	daniel@gmail.com	123456	daniel	1
12	cifuentes	Hervis*	hervis@gmail.com	123456789	hervis	1
13	hernandez	Carlos17*	carlos17@gmail.com	9876	carlos	1
14	hernandez	Lliceli*	lliceli@gmail.com	43189558	lliceli	1
15	orduz	Kte*	kte@gmail.com	123456789	kte	1
16	florez	Cristina*	cristina@gmail.com	1234567	cristina	1
17	henao	Maria1*	maria@gmail.com	123456	maria	1
18	arango	Diana1*	diana@gmail.com	102356	dianam	1
19	arango	Hrevis1*	hervis@gmail.com	1234568	hervis	1
20	perez	Cristina1*	cris@gmail.com	1234567	cristina	1
21	correa	Aleja1*	alejandra@gmail.com	1234567	aleja	1
22	restrepo	Jhon1*	jhon@gmail.com	123456	jhonathan	1
23	correa	Consuelo1*	consuelo@gmail.com	123456	consuelo	1
24	hernandez	Llis12*	llis@gmail.com	987456	llis	1
25	piedrahita	Carlos1*	carlos1@gmail.com	123456789	carlos	1
26	Florez	Cristina1*	Cristina1@gmail.com	987654	Cristina	1
27	gomez	Juan1*	juand@gmail.com	123456	juan diego	1
\.


--
-- TOC entry 3437 (class 0 OID 0)
-- Dependencies: 209
-- Name: carrito_id_carrito_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carrito_id_carrito_seq', 17, true);


--
-- TOC entry 3438 (class 0 OID 0)
-- Dependencies: 231
-- Name: carrito_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carrito_seq', 1, true);


--
-- TOC entry 3439 (class 0 OID 0)
-- Dependencies: 211
-- Name: ciudad_id_ciudad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ciudad_id_ciudad_seq', 1, false);


--
-- TOC entry 3440 (class 0 OID 0)
-- Dependencies: 213
-- Name: color_id_color_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.color_id_color_seq', 4, true);


--
-- TOC entry 3441 (class 0 OID 0)
-- Dependencies: 215
-- Name: envio_id_envio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.envio_id_envio_seq', 1, false);


--
-- TOC entry 3442 (class 0 OID 0)
-- Dependencies: 217
-- Name: factura_id_factura_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.factura_id_factura_seq', 1, false);


--
-- TOC entry 3443 (class 0 OID 0)
-- Dependencies: 219
-- Name: genero_id_genero_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genero_id_genero_seq', 2, true);


--
-- TOC entry 3444 (class 0 OID 0)
-- Dependencies: 221
-- Name: marca_id_marca_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marca_id_marca_seq', 3, true);


--
-- TOC entry 3445 (class 0 OID 0)
-- Dependencies: 223
-- Name: producto_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.producto_id_producto_seq', 12, true);


--
-- TOC entry 3446 (class 0 OID 0)
-- Dependencies: 225
-- Name: talla_id_talla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.talla_id_talla_seq', 17, true);


--
-- TOC entry 3447 (class 0 OID 0)
-- Dependencies: 227
-- Name: tipo_documento_id_tipo_documento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_documento_id_tipo_documento_seq', 4, true);


--
-- TOC entry 3448 (class 0 OID 0)
-- Dependencies: 229
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 27, true);


--
-- TOC entry 3227 (class 2606 OID 33500)
-- Name: carrito carrito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrito
    ADD CONSTRAINT carrito_pkey PRIMARY KEY (id_carrito);


--
-- TOC entry 3229 (class 2606 OID 33507)
-- Name: ciudad ciudad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (id_ciudad);


--
-- TOC entry 3231 (class 2606 OID 33514)
-- Name: color color_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color
    ADD CONSTRAINT color_pkey PRIMARY KEY (id_color);


--
-- TOC entry 3233 (class 2606 OID 33523)
-- Name: envio envio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.envio
    ADD CONSTRAINT envio_pkey PRIMARY KEY (id_envio);


--
-- TOC entry 3235 (class 2606 OID 33530)
-- Name: factura factura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id_factura);


--
-- TOC entry 3237 (class 2606 OID 33537)
-- Name: genero genero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (id_genero);


--
-- TOC entry 3239 (class 2606 OID 33544)
-- Name: marca marca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (id_marca);


--
-- TOC entry 3241 (class 2606 OID 33551)
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id_producto);


--
-- TOC entry 3243 (class 2606 OID 33558)
-- Name: talla talla_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.talla
    ADD CONSTRAINT talla_pkey PRIMARY KEY (id_talla);


--
-- TOC entry 3245 (class 2606 OID 33565)
-- Name: tipo_documento tipo_documento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_pkey PRIMARY KEY (id_tipo_documento);


--
-- TOC entry 3247 (class 2606 OID 33574)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 3258 (class 2606 OID 33625)
-- Name: usuario fk19te8k67qu3yudredxhf7enig; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk19te8k67qu3yudredxhf7enig FOREIGN KEY (tipo_documento) REFERENCES public.tipo_documento(id_tipo_documento);


--
-- TOC entry 3256 (class 2606 OID 33615)
-- Name: producto fk2uecjkh4lgopnbtstkv4b4i2j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk2uecjkh4lgopnbtstkv4b4i2j FOREIGN KEY (marca) REFERENCES public.marca(id_marca);


--
-- TOC entry 3257 (class 2606 OID 33620)
-- Name: producto fk62dlld660iv7gv2n04j71lr91; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk62dlld660iv7gv2n04j71lr91 FOREIGN KEY (talla) REFERENCES public.talla(id_talla);


--
-- TOC entry 3250 (class 2606 OID 33585)
-- Name: envio fk6qo12mcj19g5tx4ooyxmie7og; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.envio
    ADD CONSTRAINT fk6qo12mcj19g5tx4ooyxmie7og FOREIGN KEY (ciudad) REFERENCES public.ciudad(id_ciudad);


--
-- TOC entry 3255 (class 2606 OID 33610)
-- Name: producto fk6skja6p1h84sg2pr6flgy4aef; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk6skja6p1h84sg2pr6flgy4aef FOREIGN KEY (genero) REFERENCES public.genero(id_genero);


--
-- TOC entry 3249 (class 2606 OID 33580)
-- Name: carrito fkan9jctx9r40doaprlgu95esbb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrito
    ADD CONSTRAINT fkan9jctx9r40doaprlgu95esbb FOREIGN KEY (usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 3253 (class 2606 OID 33600)
-- Name: factura fkgdj43focpbb45kbf4chg1vur9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fkgdj43focpbb45kbf4chg1vur9 FOREIGN KEY (usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 3252 (class 2606 OID 33595)
-- Name: factura fkk28jrag20t7lsk8e66fxjlorw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fkk28jrag20t7lsk8e66fxjlorw FOREIGN KEY (carrito) REFERENCES public.carrito(id_carrito);


--
-- TOC entry 3251 (class 2606 OID 33590)
-- Name: envio fkkhh2f5y3cdshlfn8u39nftfnp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.envio
    ADD CONSTRAINT fkkhh2f5y3cdshlfn8u39nftfnp FOREIGN KEY (factura) REFERENCES public.factura(id_factura);


--
-- TOC entry 3248 (class 2606 OID 33575)
-- Name: carrito fkqajwlg31hnri8bhcsdjn3fheb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrito
    ADD CONSTRAINT fkqajwlg31hnri8bhcsdjn3fheb FOREIGN KEY (producto) REFERENCES public.producto(id_producto);


--
-- TOC entry 3254 (class 2606 OID 33605)
-- Name: producto fkskbkfpmww1o7isbwcikswq60; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fkskbkfpmww1o7isbwcikswq60 FOREIGN KEY (color) REFERENCES public.color(id_color);


-- Completed on 2023-03-16 08:41:30

--
-- PostgreSQL database dump complete
--

