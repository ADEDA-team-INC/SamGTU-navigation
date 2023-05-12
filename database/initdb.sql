--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

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

--
-- Name: pg_trgm; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pg_trgm WITH SCHEMA public;


--
-- Name: EXTENSION pg_trgm; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pg_trgm IS 'text similarity measurement and index searching based on trigrams';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: localized_strings; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.localized_strings (
    id integer NOT NULL,
    config_name character varying(255) NOT NULL,
    key character varying(255) NOT NULL,
    language character varying(255) NOT NULL,
    text text NOT NULL
);


ALTER TABLE public.localized_strings OWNER TO "user";

--
-- Name: localized_strings_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.localized_strings_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.localized_strings_seq OWNER TO "user";

--
-- Name: map_buildings; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.map_buildings (
    id integer NOT NULL,
    description_key character varying(255) NOT NULL,
    images_urls text NOT NULL,
    name_key character varying(255) NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL
);


ALTER TABLE public.map_buildings OWNER TO "user";

--
-- Name: map_buildings_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.map_buildings_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.map_buildings_seq OWNER TO "user";

--
-- Name: map_domains; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.map_domains (
    id integer NOT NULL,
    height double precision NOT NULL,
    x double precision NOT NULL,
    y double precision NOT NULL,
    url text NOT NULL,
    width double precision NOT NULL,
    ordinal_number integer NOT NULL,
    building_id integer NOT NULL
);


ALTER TABLE public.map_domains OWNER TO "user";

--
-- Name: map_domains_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.map_domains_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.map_domains_seq OWNER TO "user";

--
-- Name: map_object_bounding_boxes; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.map_object_bounding_boxes (
    map_object_id integer NOT NULL,
    height double precision NOT NULL,
    positionx double precision NOT NULL,
    positiony double precision NOT NULL,
    width double precision NOT NULL
);


ALTER TABLE public.map_object_bounding_boxes OWNER TO "user";

--
-- Name: map_objects; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.map_objects (
    id integer NOT NULL,
    description_key character varying(255) NOT NULL,
    images_urls text NOT NULL,
    name_key character varying(255) NOT NULL,
    type smallint NOT NULL,
    domain_id integer NOT NULL
);


ALTER TABLE public.map_objects OWNER TO "user";

--
-- Name: map_objects_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.map_objects_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.map_objects_seq OWNER TO "user";

--
-- Name: nodes; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.nodes (
    id integer NOT NULL,
    x double precision NOT NULL,
    y double precision NOT NULL,
    map_object_id integer NOT NULL
);


ALTER TABLE public.nodes OWNER TO "user";

--
-- Name: nodes_connections; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.nodes_connections (
    id integer NOT NULL,
    node_a_id integer NOT NULL,
    node_b_id integer NOT NULL
);


ALTER TABLE public.nodes_connections OWNER TO "user";

--
-- Name: nodes_connections_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.nodes_connections_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nodes_connections_seq OWNER TO "user";

--
-- Name: nodes_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.nodes_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nodes_seq OWNER TO "user";

--
-- Name: outdoor_objects; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.outdoor_objects (
    id integer NOT NULL,
    description_key character varying(255) NOT NULL,
    images_urls text NOT NULL,
    name_key character varying(255) NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    type smallint NOT NULL
);


ALTER TABLE public.outdoor_objects OWNER TO "user";

--
-- Name: outdoor_objects_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.outdoor_objects_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.outdoor_objects_seq OWNER TO "user";

--
-- Data for Name: localized_strings; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.localized_strings (id, config_name, key, language, text) FROM stdin;
1	russian	building_9_name	RUSSIAN	Корпус №9 СамГТУ
2	english	building_9_name	ENGLISH	University building No. 9
3	english	building_9_description	ENGLISH	Novo-Sadovaya st., 10
4	russian	building_9_description	RUSSIAN	Ново-Садовая ул., 10
5	russian	map_object_1_name	RUSSIAN	Аудитория 101
6	russian	map_object_2_name	RUSSIAN	Аудитория 102
7	russian	map_object_3_name	RUSSIAN	Аудитория 103
8	russian	map_object_4_name	RUSSIAN	Аудитория 104
9	russian	map_object_5_name	RUSSIAN	Аудитория 105
10	russian	map_object_6_name	RUSSIAN	Аудитория 106
11	russian	map_object_7_name	RUSSIAN	Аудитория 107
12	russian	map_object_8_name	RUSSIAN	Аудитория 108
13	russian	map_object_9_name	RUSSIAN	Аудитория 109
14	russian	map_object_10_name	RUSSIAN	Аудитория 110
15	russian	map_object_11_name	RUSSIAN	Аудитория 111
16	russian	map_object_12_name	RUSSIAN	Аудитория 112
17	russian	map_object_13_name	RUSSIAN	Аудитория 113
18	russian	map_object_14_name	RUSSIAN	Лестница
19	russian	map_object_15_name	RUSSIAN	Туалет
20	russian	map_object_16_name	RUSSIAN	Аудитория 201
21	russian	map_object_17_name	RUSSIAN	Аудитория 202
22	russian	map_object_18_name	RUSSIAN	Аудитория 203
23	russian	map_object_19_name	RUSSIAN	Аудитория 204
24	russian	map_object_20_name	RUSSIAN	Аудитория 205
25	russian	map_object_21_name	RUSSIAN	Аудитория 206
26	russian	map_object_22_name	RUSSIAN	Аудитория 207
27	russian	map_object_23_name	RUSSIAN	Аудитория 208
28	russian	map_object_24_name	RUSSIAN	Аудитория 209
29	russian	map_object_25_name	RUSSIAN	Аудитория 210
30	russian	map_object_26_name	RUSSIAN	Аудитория 211
31	russian	map_object_27_name	RUSSIAN	Аудитория 212
32	russian	map_object_28_name	RUSSIAN	Аудитория 213
33	russian	map_object_29_name	RUSSIAN	Лестница
34	russian	map_object_30_name	RUSSIAN	Туалет
35	english	map_object_1_name	ENGLISH	Classroom 101
36	english	map_object_2_name	ENGLISH	Classroom 102
37	english	map_object_3_name	ENGLISH	Classroom 103
38	english	map_object_4_name	ENGLISH	Classroom 104
39	english	map_object_5_name	ENGLISH	Classroom 105
40	english	map_object_6_name	ENGLISH	Classroom 106
41	english	map_object_7_name	ENGLISH	Classroom 107
42	english	map_object_8_name	ENGLISH	Classroom 108
43	english	map_object_9_name	ENGLISH	Classroom 109
44	english	map_object_10_name	ENGLISH	Classroom 110
45	english	map_object_11_name	ENGLISH	Classroom 111
46	english	map_object_12_name	ENGLISH	Classroom 112
47	english	map_object_13_name	ENGLISH	Classroom 113
48	english	map_object_14_name	ENGLISH	Ladder
49	english	map_object_15_name	ENGLISH	WC
50	english	map_object_16_name	ENGLISH	Classroom 201
51	english	map_object_17_name	ENGLISH	Classroom 202
52	english	map_object_18_name	ENGLISH	Classroom 203
53	english	map_object_19_name	ENGLISH	Classroom 204
54	english	map_object_20_name	ENGLISH	Classroom 205
55	english	map_object_21_name	ENGLISH	Classroom 206
56	english	map_object_22_name	ENGLISH	Classroom 207
57	english	map_object_23_name	ENGLISH	Classroom 208
58	english	map_object_24_name	ENGLISH	Classroom 209
59	english	map_object_25_name	ENGLISH	Classroom 210
60	english	map_object_26_name	ENGLISH	Classroom 211
61	english	map_object_27_name	ENGLISH	Classroom 212
62	english	map_object_28_name	ENGLISH	Classroom 213
63	english	map_object_29_name	ENGLISH	Ladder
64	english	map_object_30_name	ENGLISH	WC
65	russian	sight_1_name	RUSSIAN	Фонтан
66	russian	sight_1_description	RUSSIAN	ул. Осипенко, 32Б
67	english	sight_1_name	ENGLISH	Fontain
68	english	sight_1_description	ENGLISH	Osipenko st., 32B
69	russian	sight_2_name	RUSSIAN	Стелла «Ладья»
70	russian	sight_2_description	RUSSIAN	ул. Лесная, 23
71	english	sight_2_name	ENGLISH	Stella Rook
72	english	sight_2_description	ENGLISH	Lesnaya st., 23
73	russian	cafe_1_name	RUSSIAN	Арка
74	russian	cafe_1_description	RUSSIAN	Молодогвардейская ул., 225
75	english	cafe_1_name	ENGLISH	Arka
76	english	cafe_1_description	ENGLISH	Molodogvardeyskaya st., 225
77	russian	cafe_2_name	RUSSIAN	Додо Пицца
78	russian	cafe_2_description	RUSSIAN	ул. Ново-Садовая, 8А
79	english	cafe_2_name	ENGLISH	Dodo Pizza
80	english	cafe_2_description	ENGLISH	Novo-Sadovaya st., 8A
81	russian	shop_1_name	RUSSIAN	Магнит
82	russian	shop_1_description	RUSSIAN	ул. Первомайская, 25
83	english	shop_1_name	ENGLISH	Magnit
84	english	shop_1_description	ENGLISH	Pervomayskaya st., 25
85	russian	shop_2_name	RUSSIAN	Пятёрочка
86	russian	shop_2_description	RUSSIAN	Молодогвардейская ул., 215
87	english	shop_2_name	ENGLISH	Pyaterochka
88	english	shop_2_description	ENGLISH	Molodogvardeyskaya st., 215
89	russian	empty_description	RUSSIAN	 
90	english	empty_description	ENGLISH	 
\.


--
-- Data for Name: map_buildings; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.map_buildings (id, description_key, images_urls, name_key, latitude, longitude) FROM stdin;
1	building_9_description	https://lh5.googleusercontent.com/p/AF1QipP-sdwWpRg2tkT4n9_HYte1bUzxJ9YgDrOGePDO=w426-h240-k-no	building_9_name	53.20781979046025	50.128598332924334
\.


--
-- Data for Name: map_domains; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.map_domains (id, height, x, y, url, width, ordinal_number, building_id) FROM stdin;
1	15	0	0	data:image/svg+xml,%3C%3Fxml%20version%3D%221.0%22%20encoding%3D%22utf-8%22%3F%3E%0D%0A%3C%21--%20Generator%3A%20Adobe%20Illustrator%2026.0.3%2C%20SVG%20Export%20Plug-In%20.%20SVG%20Version%3A%206.00%20Build%200%29%20%20--%3E%0D%0A%3Csvg%20version%3D%221.1%22%20id%3D%22%D0%A1%D0%BB%D0%BE%D0%B9_1%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20x%3D%220px%22%20y%3D%220px%22%0D%0A%09%20viewBox%3D%220%200%20669%20277%22%20style%3D%22enable-background%3Anew%200%200%20669%20277%3B%22%20xml%3Aspace%3D%22preserve%22%20width%3D%22669%22%20height%3D%22277%22%3E%0D%0A%3Cstyle%20type%3D%22text%2Fcss%22%3E%0D%0A%09.st0%7Bfill%3Anone%3Bstroke%3A%23000000%3B%7D%0D%0A%3C%2Fstyle%3E%0D%0A%3Cg%3E%0D%0A%09%3Cline%20id%3D%22svg_3%22%20class%3D%22st0%22%20x1%3D%22-63%22%20y1%3D%22-63%22%20x2%3D%22-63%22%20y2%3D%22-63%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_2%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%220%22%20x2%3D%220.2%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_5%22%20class%3D%22st0%22%20x1%3D%220%22%20y1%3D%220%22%20x2%3D%22287%22%20y2%3D%220%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_6%22%20class%3D%22st0%22%20x1%3D%22287%22%20y1%3D%220%22%20x2%3D%22287%22%20y2%3D%22123.4%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_7%22%20class%3D%22st0%22%20x1%3D%22287.3%22%20y1%3D%22123%22%20x2%3D%22410.5%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_8%22%20class%3D%22st0%22%20x1%3D%22410%22%20y1%3D%22122.7%22%20x2%3D%22410%22%20y2%3D%2288.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_9%22%20class%3D%22st0%22%20x1%3D%22409.3%22%20y1%3D%2288.6%22%20x2%3D%22669.4%22%20y2%3D%2288.6%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_10%22%20class%3D%22st0%22%20x1%3D%22669.3%22%20y1%3D%2289%22%20x2%3D%22669.3%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_11%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%22277%22%20x2%3D%22669%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_12%22%20class%3D%22st0%22%20x1%3D%22160.9%22%20y1%3D%220.5%22%20x2%3D%22160.9%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_13%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2237%22%20x2%3D%22216.9%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_14%22%20class%3D%22st0%22%20x1%3D%22236.4%22%20y1%3D%2237%22%20x2%3D%22287.1%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_4%22%20class%3D%22st0%22%20x1%3D%22286.6%22%20y1%3D%2277%22%20x2%3D%22160.8%22%20y2%3D%2277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_15%22%20class%3D%22st0%22%20x1%3D%22287%22%20y1%3D%22123%22%20x2%3D%22161%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_16%22%20class%3D%22st0%22%20x1%3D%22160.8%22%20y1%3D%2236.6%22%20x2%3D%22160.8%22%20y2%3D%2252%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_17%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2277%22%20x2%3D%22161%22%20y2%3D%2264%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_18%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2277%22%20x2%3D%22161%22%20y2%3D%2295%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_19%22%20class%3D%22st0%22%20x1%3D%22160.9%22%20y1%3D%22105%22%20x2%3D%22160.9%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_20%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%220.1%22%20x2%3D%22100%22%20y2%3D%2218.6%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_21%22%20class%3D%22st0%22%20x1%3D%22100.5%22%20y1%3D%2231.2%22%20x2%3D%22100.5%22%20y2%3D%2295%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_22%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%2277%22%20x2%3D%22-0.1%22%20y2%3D%2277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_24%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22172.2%22%20x2%3D%22307.4%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_25%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22122.5%22%20x2%3D%22212%22%20y2%3D%22139.4%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_26%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22153.6%22%20x2%3D%22212%22%20y2%3D%22172.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_27%22%20class%3D%22st0%22%20x1%3D%22307%22%20y1%3D%22123%22%20x2%3D%22307%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_28%22%20class%3D%22st0%22%20x1%3D%22409.8%22%20y1%3D%22121.9%22%20x2%3D%22409.8%22%20y2%3D%22172.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_29%22%20class%3D%22st0%22%20x1%3D%22338.8%22%20y1%3D%22171.6%22%20x2%3D%22437.1%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_30%22%20class%3D%22st0%22%20x1%3D%22307.1%22%20y1%3D%22172.2%22%20x2%3D%22323.5%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_31%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%22107.8%22%20x2%3D%22100%22%20y2%3D%22121%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_32%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%22121%22%20x2%3D%22100%22%20y2%3D%22121%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_33%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%22121%22%20x2%3D%22100%22%20y2%3D%22182%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_34%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22195.1%22%20x2%3D%2299.6%22%20y2%3D%22227%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_35%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22241.8%22%20x2%3D%2299.6%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_36%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22210.2%22%20x2%3D%220.2%22%20y2%3D%22210.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_37%22%20class%3D%22st0%22%20x1%3D%22160.4%22%20y1%3D%22210%22%20x2%3D%22160.4%22%20y2%3D%22227%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_38%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%22241.8%22%20x2%3D%22161%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_39%22%20class%3D%22st0%22%20x1%3D%22410%22%20y1%3D%22210%22%20x2%3D%22410%22%20y2%3D%22276.5%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_40%22%20class%3D%22st0%22%20x1%3D%22389.2%22%20y1%3D%22209.8%22%20x2%3D%22410.4%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_41%22%20class%3D%22st0%22%20x1%3D%22160%22%20y1%3D%22209.8%22%20x2%3D%22367.6%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_42%22%20class%3D%22st0%22%20x1%3D%22255.3%22%20y1%3D%22209.8%22%20x2%3D%22255.3%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_43%22%20class%3D%22st0%22%20x1%3D%22410.3%22%20y1%3D%22209.8%22%20x2%3D%22448.3%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_44%22%20class%3D%22st0%22%20x1%3D%22467.6%22%20y1%3D%22210%22%20x2%3D%22553.2%22%20y2%3D%22210%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_45%22%20class%3D%22st0%22%20x1%3D%22575.3%22%20y1%3D%22210%22%20x2%3D%22669.2%22%20y2%3D%22210%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_46%22%20class%3D%22st0%22%20x1%3D%22498.7%22%20y1%3D%22209.8%22%20x2%3D%22498.7%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_47%22%20class%3D%22st0%22%20x1%3D%22532%22%20y1%3D%2288.7%22%20x2%3D%22532%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_48%22%20class%3D%22st0%22%20x1%3D%22458.1%22%20y1%3D%22172%22%20x2%3D%22544%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_49%22%20class%3D%22st0%22%20x1%3D%22614.8%22%20y1%3D%2288.7%22%20x2%3D%22614.8%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_50%22%20class%3D%22st0%22%20x1%3D%22656.4%22%20y1%3D%22172%22%20x2%3D%22669.2%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_51%22%20class%3D%22st0%22%20x1%3D%22557%22%20y1%3D%22172%22%20x2%3D%22580%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_52%22%20class%3D%22st0%22%20x1%3D%22597%22%20y1%3D%22172%22%20x2%3D%22634.2%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_54%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22172%22%20x2%3D%22567%22%20y2%3D%22135%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_55%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%2288.7%22%20x2%3D%22577%22%20y2%3D%2297%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_56%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%22107%22%20x2%3D%22577%22%20y2%3D%22120%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_57%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22160%22%20x2%3D%22580%22%20y2%3D%22160%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_58%22%20class%3D%22st0%22%20x1%3D%22594%22%20y1%3D%22160%22%20x2%3D%22614.8%22%20y2%3D%22160%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_59%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%22112%22%20x2%3D%22615%22%20y2%3D%22112%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_60%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22135%22%20x2%3D%22614.8%22%20y2%3D%22135%22%2F%3E%0D%0A%09%3Cg%20id%3D%22svg_70%22%3E%0D%0A%09%09%3Crect%20id%3D%22svg_62%22%20x%3D%22219%22%20y%3D%22129%22%20class%3D%22st0%22%20width%3D%2276%22%20height%3D%2236%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_63%22%20class%3D%22st0%22%20x1%3D%22219.4%22%20y1%3D%22147%22%20x2%3D%22295.4%22%20y2%3D%22147%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_64%22%20class%3D%22st0%22%20x1%3D%22227%22%20y1%3D%22129%22%20x2%3D%22227%22%20y2%3D%22164.7%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_65%22%20class%3D%22st0%22%20x1%3D%22235%22%20y1%3D%22129%22%20x2%3D%22235%22%20y2%3D%22165%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_66%22%20class%3D%22st0%22%20x1%3D%22243%22%20y1%3D%22129%22%20x2%3D%22243%22%20y2%3D%22164.8%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_67%22%20class%3D%22st0%22%20x1%3D%22251%22%20y1%3D%22128.8%22%20x2%3D%22251%22%20y2%3D%22164.7%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_68%22%20class%3D%22st0%22%20x1%3D%22259%22%20y1%3D%22129%22%20x2%3D%22259%22%20y2%3D%22164.8%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_69%22%20class%3D%22st0%22%20x1%3D%22277%22%20y1%3D%22129%22%20x2%3D%22277%22%20y2%3D%22165.1%22%2F%3E%0D%0A%09%3C%2Fg%3E%0D%0A%09%3Cg%20id%3D%22svg_79%22%20transform%3D%22rotate%28-90%20705.725%20193.138%29%22%3E%0D%0A%09%09%0D%0A%09%09%09%3Crect%20id%3D%22svg_71%22%20x%3D%22750.5%22%20y%3D%2292.2%22%20transform%3D%22matrix%28-2.535182e-06%20-1%201%20-2.535182e-06%20638.3458%20898.7309%29%22%20class%3D%22st0%22%20width%3D%2236%22%20height%3D%2276%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_72%22%20class%3D%22st0%22%20x1%3D%22730.9%22%20y1%3D%22130.2%22%20x2%3D%22806.9%22%20y2%3D%22130.2%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_73%22%20class%3D%22st0%22%20x1%3D%22738.5%22%20y1%3D%22112.2%22%20x2%3D%22738.5%22%20y2%3D%22147.9%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_74%22%20class%3D%22st0%22%20x1%3D%22746.5%22%20y1%3D%22112.2%22%20x2%3D%22746.5%22%20y2%3D%22148.2%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_75%22%20class%3D%22st0%22%20x1%3D%22754.5%22%20y1%3D%22112.2%22%20x2%3D%22754.5%22%20y2%3D%22148%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_76%22%20class%3D%22st0%22%20x1%3D%22762.5%22%20y1%3D%22112%22%20x2%3D%22762.5%22%20y2%3D%22147.9%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_77%22%20class%3D%22st0%22%20x1%3D%22770.5%22%20y1%3D%22112.2%22%20x2%3D%22770.5%22%20y2%3D%22148%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_78%22%20class%3D%22st0%22%20x1%3D%22788.5%22%20y1%3D%22112.2%22%20x2%3D%22788.5%22%20y2%3D%22148.3%22%2F%3E%0D%0A%09%3C%2Fg%3E%0D%0A%3C%2Fg%3E%0D%0A%3C%2Fsvg%3E%0D%0A	38	1	2
2	15	0	0	data:image/svg+xml,%3C%3Fxml%20version%3D%221.0%22%20encoding%3D%22utf-8%22%3F%3E%0D%0A%3C%21--%20Generator%3A%20Adobe%20Illustrator%2026.0.3%2C%20SVG%20Export%20Plug-In%20.%20SVG%20Version%3A%206.00%20Build%200%29%20%20--%3E%0D%0A%3Csvg%20version%3D%221.1%22%20id%3D%22%D0%A1%D0%BB%D0%BE%D0%B9_1%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20x%3D%220px%22%20y%3D%220px%22%0D%0A%09%20viewBox%3D%220%200%20669%20277%22%20style%3D%22enable-background%3Anew%200%200%20669%20277%3B%22%20xml%3Aspace%3D%22preserve%22%20width%3D%22669%22%20height%3D%22277%22%3E%0D%0A%3Cstyle%20type%3D%22text%2Fcss%22%3E%0D%0A%09.st0%7Bfill%3Anone%3Bstroke%3A%23000000%3B%7D%0D%0A%3C%2Fstyle%3E%0D%0A%3Cg%3E%0D%0A%09%3Cline%20id%3D%22svg_3%22%20class%3D%22st0%22%20x1%3D%22-63%22%20y1%3D%22-63%22%20x2%3D%22-63%22%20y2%3D%22-63%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_2%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%220%22%20x2%3D%220.2%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_5%22%20class%3D%22st0%22%20x1%3D%220%22%20y1%3D%220%22%20x2%3D%22287%22%20y2%3D%220%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_6%22%20class%3D%22st0%22%20x1%3D%22287%22%20y1%3D%220%22%20x2%3D%22287%22%20y2%3D%22123.4%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_7%22%20class%3D%22st0%22%20x1%3D%22287.3%22%20y1%3D%22123%22%20x2%3D%22410.5%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_8%22%20class%3D%22st0%22%20x1%3D%22410%22%20y1%3D%22122.7%22%20x2%3D%22410%22%20y2%3D%2288.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_9%22%20class%3D%22st0%22%20x1%3D%22409.3%22%20y1%3D%2288.6%22%20x2%3D%22669.4%22%20y2%3D%2288.6%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_10%22%20class%3D%22st0%22%20x1%3D%22669.3%22%20y1%3D%2289%22%20x2%3D%22669.3%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_11%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%22277%22%20x2%3D%22669%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_12%22%20class%3D%22st0%22%20x1%3D%22160.9%22%20y1%3D%220.5%22%20x2%3D%22160.9%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_13%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2237%22%20x2%3D%22216.9%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_14%22%20class%3D%22st0%22%20x1%3D%22236.4%22%20y1%3D%2237%22%20x2%3D%22287.1%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_4%22%20class%3D%22st0%22%20x1%3D%22286.6%22%20y1%3D%2277%22%20x2%3D%22160.8%22%20y2%3D%2277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_15%22%20class%3D%22st0%22%20x1%3D%22287%22%20y1%3D%22123%22%20x2%3D%22161%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_16%22%20class%3D%22st0%22%20x1%3D%22160.8%22%20y1%3D%2236.6%22%20x2%3D%22160.8%22%20y2%3D%2252%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_17%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2277%22%20x2%3D%22161%22%20y2%3D%2264%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_18%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2277%22%20x2%3D%22161%22%20y2%3D%2295%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_19%22%20class%3D%22st0%22%20x1%3D%22160.9%22%20y1%3D%22105%22%20x2%3D%22160.9%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_20%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%220.1%22%20x2%3D%22100%22%20y2%3D%2218.6%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_21%22%20class%3D%22st0%22%20x1%3D%22100.5%22%20y1%3D%2231.2%22%20x2%3D%22100.5%22%20y2%3D%2295%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_22%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%2277%22%20x2%3D%22-0.1%22%20y2%3D%2277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_24%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22172.2%22%20x2%3D%22307.4%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_25%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22122.5%22%20x2%3D%22212%22%20y2%3D%22139.4%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_26%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22153.6%22%20x2%3D%22212%22%20y2%3D%22172.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_27%22%20class%3D%22st0%22%20x1%3D%22307%22%20y1%3D%22123%22%20x2%3D%22307%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_28%22%20class%3D%22st0%22%20x1%3D%22409.8%22%20y1%3D%22121.9%22%20x2%3D%22409.8%22%20y2%3D%22172.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_29%22%20class%3D%22st0%22%20x1%3D%22338.8%22%20y1%3D%22171.6%22%20x2%3D%22437.1%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_30%22%20class%3D%22st0%22%20x1%3D%22307.1%22%20y1%3D%22172.2%22%20x2%3D%22323.5%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_31%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%22107.8%22%20x2%3D%22100%22%20y2%3D%22121%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_32%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%22121%22%20x2%3D%22100%22%20y2%3D%22121%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_33%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%22121%22%20x2%3D%22100%22%20y2%3D%22182%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_34%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22195.1%22%20x2%3D%2299.6%22%20y2%3D%22227%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_35%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22241.8%22%20x2%3D%2299.6%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_36%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22210.2%22%20x2%3D%220.2%22%20y2%3D%22210.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_37%22%20class%3D%22st0%22%20x1%3D%22160.4%22%20y1%3D%22210%22%20x2%3D%22160.4%22%20y2%3D%22227%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_38%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%22241.8%22%20x2%3D%22161%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_39%22%20class%3D%22st0%22%20x1%3D%22410%22%20y1%3D%22210%22%20x2%3D%22410%22%20y2%3D%22276.5%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_40%22%20class%3D%22st0%22%20x1%3D%22389.2%22%20y1%3D%22209.8%22%20x2%3D%22410.4%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_41%22%20class%3D%22st0%22%20x1%3D%22160%22%20y1%3D%22209.8%22%20x2%3D%22367.6%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_42%22%20class%3D%22st0%22%20x1%3D%22255.3%22%20y1%3D%22209.8%22%20x2%3D%22255.3%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_43%22%20class%3D%22st0%22%20x1%3D%22410.3%22%20y1%3D%22209.8%22%20x2%3D%22448.3%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_44%22%20class%3D%22st0%22%20x1%3D%22467.6%22%20y1%3D%22210%22%20x2%3D%22553.2%22%20y2%3D%22210%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_45%22%20class%3D%22st0%22%20x1%3D%22575.3%22%20y1%3D%22210%22%20x2%3D%22669.2%22%20y2%3D%22210%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_46%22%20class%3D%22st0%22%20x1%3D%22498.7%22%20y1%3D%22209.8%22%20x2%3D%22498.7%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_47%22%20class%3D%22st0%22%20x1%3D%22532%22%20y1%3D%2288.7%22%20x2%3D%22532%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_48%22%20class%3D%22st0%22%20x1%3D%22458.1%22%20y1%3D%22172%22%20x2%3D%22544%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_49%22%20class%3D%22st0%22%20x1%3D%22614.8%22%20y1%3D%2288.7%22%20x2%3D%22614.8%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_50%22%20class%3D%22st0%22%20x1%3D%22656.4%22%20y1%3D%22172%22%20x2%3D%22669.2%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_51%22%20class%3D%22st0%22%20x1%3D%22557%22%20y1%3D%22172%22%20x2%3D%22580%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_52%22%20class%3D%22st0%22%20x1%3D%22597%22%20y1%3D%22172%22%20x2%3D%22634.2%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_54%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22172%22%20x2%3D%22567%22%20y2%3D%22135%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_55%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%2288.7%22%20x2%3D%22577%22%20y2%3D%2297%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_56%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%22107%22%20x2%3D%22577%22%20y2%3D%22120%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_57%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22160%22%20x2%3D%22580%22%20y2%3D%22160%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_58%22%20class%3D%22st0%22%20x1%3D%22594%22%20y1%3D%22160%22%20x2%3D%22614.8%22%20y2%3D%22160%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_59%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%22112%22%20x2%3D%22615%22%20y2%3D%22112%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_60%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22135%22%20x2%3D%22614.8%22%20y2%3D%22135%22%2F%3E%0D%0A%09%3Cg%20id%3D%22svg_70%22%3E%0D%0A%09%09%3Crect%20id%3D%22svg_62%22%20x%3D%22219%22%20y%3D%22129%22%20class%3D%22st0%22%20width%3D%2276%22%20height%3D%2236%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_63%22%20class%3D%22st0%22%20x1%3D%22219.4%22%20y1%3D%22147%22%20x2%3D%22295.4%22%20y2%3D%22147%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_64%22%20class%3D%22st0%22%20x1%3D%22227%22%20y1%3D%22129%22%20x2%3D%22227%22%20y2%3D%22164.7%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_65%22%20class%3D%22st0%22%20x1%3D%22235%22%20y1%3D%22129%22%20x2%3D%22235%22%20y2%3D%22165%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_66%22%20class%3D%22st0%22%20x1%3D%22243%22%20y1%3D%22129%22%20x2%3D%22243%22%20y2%3D%22164.8%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_67%22%20class%3D%22st0%22%20x1%3D%22251%22%20y1%3D%22128.8%22%20x2%3D%22251%22%20y2%3D%22164.7%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_68%22%20class%3D%22st0%22%20x1%3D%22259%22%20y1%3D%22129%22%20x2%3D%22259%22%20y2%3D%22164.8%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_69%22%20class%3D%22st0%22%20x1%3D%22277%22%20y1%3D%22129%22%20x2%3D%22277%22%20y2%3D%22165.1%22%2F%3E%0D%0A%09%3C%2Fg%3E%0D%0A%09%3Cg%20id%3D%22svg_79%22%20transform%3D%22rotate%28-90%20705.725%20193.138%29%22%3E%0D%0A%09%09%0D%0A%09%09%09%3Crect%20id%3D%22svg_71%22%20x%3D%22750.5%22%20y%3D%2292.2%22%20transform%3D%22matrix%28-2.535182e-06%20-1%201%20-2.535182e-06%20638.3458%20898.7309%29%22%20class%3D%22st0%22%20width%3D%2236%22%20height%3D%2276%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_72%22%20class%3D%22st0%22%20x1%3D%22730.9%22%20y1%3D%22130.2%22%20x2%3D%22806.9%22%20y2%3D%22130.2%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_73%22%20class%3D%22st0%22%20x1%3D%22738.5%22%20y1%3D%22112.2%22%20x2%3D%22738.5%22%20y2%3D%22147.9%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_74%22%20class%3D%22st0%22%20x1%3D%22746.5%22%20y1%3D%22112.2%22%20x2%3D%22746.5%22%20y2%3D%22148.2%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_75%22%20class%3D%22st0%22%20x1%3D%22754.5%22%20y1%3D%22112.2%22%20x2%3D%22754.5%22%20y2%3D%22148%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_76%22%20class%3D%22st0%22%20x1%3D%22762.5%22%20y1%3D%22112%22%20x2%3D%22762.5%22%20y2%3D%22147.9%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_77%22%20class%3D%22st0%22%20x1%3D%22770.5%22%20y1%3D%22112.2%22%20x2%3D%22770.5%22%20y2%3D%22148%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_78%22%20class%3D%22st0%22%20x1%3D%22788.5%22%20y1%3D%22112.2%22%20x2%3D%22788.5%22%20y2%3D%22148.3%22%2F%3E%0D%0A%09%3C%2Fg%3E%0D%0A%3C%2Fg%3E%0D%0A%3C%2Fsvg%3E%0D%0A	38	2	2
\.


--
-- Data for Name: map_object_bounding_boxes; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.map_object_bounding_boxes (map_object_id, height, positionx, positiony, width) FROM stdin;
1	4.4	0	0	5.7
2	2.5	0	4.4	5.7
3	5	0	6.9	5.7
4	4.4	0	11.9	5.7
5	2.1	9.1	0	7.2
6	2.3	9.1	2.1	7.2
7	2.6	9.1	4.4	7.2
8	3.8	9.1	11.9	5.3
9	3.8	14.5	11.9	8.8
10	2.8	17.4	7	5.9
11	4.7	23.2	5	6.9
12	3.8	23.2	11.9	5.1
13	3.8	28.3	11.9	9.7
14	4.7	30.2	5	4.7
15	2.8	12	7	5.4
16	4.4	0	0	5.7
17	2.5	0	4.4	5.7
18	5	0	6.9	5.7
19	4.4	0	11.9	5.7
20	2.1	9.1	0	7.2
21	2.3	9.1	2.1	7.2
22	2.6	9.1	4.4	7.2
23	3.8	9.1	11.9	5.3
24	3.8	14.5	11.9	8.8
25	2.8	17.4	7	5.9
26	4.7	23.2	5	6.9
27	3.8	23.2	11.9	5.1
28	3.8	28.3	11.9	9.7
29	4.7	30.2	5	4.7
30	2.8	12	7	5.4
\.


--
-- Data for Name: map_objects; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.map_objects (id, description_key, images_urls, name_key, type, domain_id) FROM stdin;
1	empty_description		map_object_1_name	1	1
2	empty_description		map_object_2_name	1	1
3	empty_description		map_object_3_name	1	1
4	empty_description		map_object_4_name	1	1
5	empty_description		map_object_5_name	1	1
6	empty_description		map_object_6_name	1	1
7	empty_description		map_object_7_name	1	1
8	empty_description		map_object_8_name	1	1
9	empty_description		map_object_9_name	1	1
10	empty_description		map_object_10_name	1	1
11	empty_description		map_object_11_name	1	1
12	empty_description		map_object_12_name	1	1
13	empty_description		map_object_13_name	1	1
14	empty_description		map_object_15_name	1	1
15	empty_description		map_object_14_name	2	1
16	empty_description		map_object_16_name	1	2
17	empty_description		map_object_17_name	1	2
18	empty_description		map_object_18_name	1	2
19	empty_description		map_object_19_name	1	2
20	empty_description		map_object_20_name	1	2
21	empty_description		map_object_21_name	1	2
22	empty_description		map_object_22_name	1	2
23	empty_description		map_object_23_name	1	2
24	empty_description		map_object_24_name	1	2
25	empty_description		map_object_25_name	1	2
26	empty_description		map_object_26_name	1	2
27	empty_description		map_object_27_name	1	2
28	empty_description		map_object_28_name	1	2
29	empty_description		map_object_29_name	1	2
30	empty_description		map_object_30_name	2	2
\.


--
-- Data for Name: nodes; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.nodes (id, x, y, map_object_id) FROM stdin;
\.


--
-- Data for Name: nodes_connections; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.nodes_connections (id, node_a_id, node_b_id) FROM stdin;
\.


--
-- Data for Name: outdoor_objects; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.outdoor_objects (id, description_key, images_urls, name_key, latitude, longitude, type) FROM stdin;
1	sight_1_description	https://lh5.googleusercontent.com/p/AF1QipNwhWe_9nRoYrhgVG_lHSg5gdDpxSbHNn3AZjE=w408-h272-k-no	sight_1_name	53.20809070233449	50.13439956213159	0
2	sight_2_description	https://lh5.googleusercontent.com/p/AF1QipP7OYE7zeRNNGDLNrLyg0FjI7N88cOh6IFXXXeU=w408-h544-k-no	sight_2_name	53.21612638636535	50.1321469869194	0
3	cafe_1_description	https://lh5.googleusercontent.com/p/AF1QipN5uit6Qv7Bmpdj4uvoLoSYjVgywVwRZzRZWkJ6=s635-k-no	cafe_1_name	53.20889851467478	50.12598721400279	1
4	cafe_2_description	https://lh5.googleusercontent.com/p/AF1QipODP8at616imyGY9gYqHSupcYeJZ76snZSlEiY=w408-h271-k-no	cafe_2_name	53.207400991259945	50.128424777453155	1
5	shop_1_description	https://lh5.googleusercontent.com/p/AF1QipOi_7cGIW4FyEeLPX3iULEBio2bi3vNEKniyKiG=w426-h240-k-no	shop_1_name	53.207852122000766	50.124732038382774	2
6	shop_2_description	https://lh5.googleusercontent.com/p/AF1QipPdAFcrM2JCdlxE7dg42mTx2k2RgHhkRj-sZ6QF=w426-h240-k-no	shop_2_name	53.20638416852309	50.120847509027264	2
\.


--
-- Name: localized_strings_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.localized_strings_seq', 101, true);


--
-- Name: map_buildings_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.map_buildings_seq', 51, true);


--
-- Name: map_domains_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.map_domains_seq', 1, true);


--
-- Name: map_objects_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.map_objects_seq', 51, true);


--
-- Name: nodes_connections_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.nodes_connections_seq', 1, false);


--
-- Name: nodes_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.nodes_seq', 1, false);


--
-- Name: outdoor_objects_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.outdoor_objects_seq', 1, false);


--
-- Name: localized_strings localized_strings_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.localized_strings
    ADD CONSTRAINT localized_strings_pkey PRIMARY KEY (id);


--
-- Name: map_buildings map_buildings_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.map_buildings
    ADD CONSTRAINT map_buildings_pkey PRIMARY KEY (id);


--
-- Name: map_domains map_domains_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.map_domains
    ADD CONSTRAINT map_domains_pkey PRIMARY KEY (id);


--
-- Name: map_objects map_objects_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.map_objects
    ADD CONSTRAINT map_objects_pkey PRIMARY KEY (id);


--
-- Name: nodes_connections nodes_connections_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.nodes_connections
    ADD CONSTRAINT nodes_connections_pkey PRIMARY KEY (id);


--
-- Name: nodes nodes_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.nodes
    ADD CONSTRAINT nodes_pkey PRIMARY KEY (id);


--
-- Name: outdoor_objects outdoor_objects_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.outdoor_objects
    ADD CONSTRAINT outdoor_objects_pkey PRIMARY KEY (id);


--
-- Name: nodes_connections uk3rhxidasgskbqdtt7tg63m26v; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.nodes_connections
    ADD CONSTRAINT uk3rhxidasgskbqdtt7tg63m26v UNIQUE (node_a_id, node_b_id);


--
-- Name: localized_strings ukd80n4gw5oi6b956x58pa7st8b; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.localized_strings
    ADD CONSTRAINT ukd80n4gw5oi6b956x58pa7st8b UNIQUE (key, language);


--
-- Name: en_idx_localized_string_text; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX en_idx_localized_string_text ON public.localized_strings USING gist (to_tsvector('english'::regconfig, text));


--
-- Name: idx7ysjxecld47h9j1nrgtexkaf1; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idx7ysjxecld47h9j1nrgtexkaf1 ON public.outdoor_objects USING btree (description_key);


--
-- Name: idx9sf9i35o78c2o7m1f3nfx5rw3; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idx9sf9i35o78c2o7m1f3nfx5rw3 ON public.map_buildings USING btree (name_key);


--
-- Name: idxa1gfjflh2xlgvka91sfv6ox4t; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idxa1gfjflh2xlgvka91sfv6ox4t ON public.map_objects USING btree (description_key);


--
-- Name: idxb9r1vastm2qywas7wwr10jq31; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idxb9r1vastm2qywas7wwr10jq31 ON public.outdoor_objects USING btree (name_key);


--
-- Name: idxcgiq44l7gm6ankf7hhedsk9h4; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idxcgiq44l7gm6ankf7hhedsk9h4 ON public.map_buildings USING btree (description_key);


--
-- Name: idxfg2adxpf1tmhucywg1k3irfo1; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idxfg2adxpf1tmhucywg1k3irfo1 ON public.map_objects USING btree (type);


--
-- Name: idxhq39oavhfk7xkliks7idrddh9; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idxhq39oavhfk7xkliks7idrddh9 ON public.outdoor_objects USING btree (type);


--
-- Name: idxrf7ve8vywx5mmxx9lgxtbg7p8; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX idxrf7ve8vywx5mmxx9lgxtbg7p8 ON public.map_objects USING btree (name_key);


--
-- Name: ru_idx_localized_string_text; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX ru_idx_localized_string_text ON public.localized_strings USING gist (to_tsvector('russian'::regconfig, text));


--
-- Name: trgm_idx_localized_string_text; Type: INDEX; Schema: public; Owner: user
--

CREATE INDEX trgm_idx_localized_string_text ON public.localized_strings USING gist (key public.gist_trgm_ops);


--
-- Name: map_object_bounding_boxes fk2jfwja9o29duh2fti7fhrr7up; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.map_object_bounding_boxes
    ADD CONSTRAINT fk2jfwja9o29duh2fti7fhrr7up FOREIGN KEY (map_object_id) REFERENCES public.map_objects(id);


--
-- Name: map_domains fk3g2rycpp3lk5d8gwy0rtdh6p2; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.map_domains
    ADD CONSTRAINT fk3g2rycpp3lk5d8gwy0rtdh6p2 FOREIGN KEY (building_id) REFERENCES public.map_buildings(id);


--
-- Name: map_objects fk6e57vsout1iekngq6ujk7jut0; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.map_objects
    ADD CONSTRAINT fk6e57vsout1iekngq6ujk7jut0 FOREIGN KEY (domain_id) REFERENCES public.map_domains(id);


--
-- Name: nodes_connections fk70jqa3mc3itij0cvo4n4d3ate; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.nodes_connections
    ADD CONSTRAINT fk70jqa3mc3itij0cvo4n4d3ate FOREIGN KEY (node_b_id) REFERENCES public.nodes(id);


--
-- Name: nodes_connections fk98gyyyltg5kggwkoe08djkda8; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.nodes_connections
    ADD CONSTRAINT fk98gyyyltg5kggwkoe08djkda8 FOREIGN KEY (node_a_id) REFERENCES public.nodes(id);


--
-- Name: nodes fkgiiefnh8b8myp4j5yrcstd4cx; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.nodes
    ADD CONSTRAINT fkgiiefnh8b8myp4j5yrcstd4cx FOREIGN KEY (map_object_id) REFERENCES public.map_objects(id);


--
-- PostgreSQL database dump complete
--

