PGDMP     !        
        
    w            livraria    10.10    10.10 Q    S           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            T           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            U           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            V           1262    82054    livraria    DATABASE     �   CREATE DATABASE livraria WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE livraria;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            W           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            X           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    82055    autor    TABLE        CREATE TABLE public.autor (
    id_autor integer NOT NULL,
    nome character varying(100) NOT NULL,
    data_exclusao date
);
    DROP TABLE public.autor;
       public         postgres    false    3            �            1259    82058    autor_id_autor_seq    SEQUENCE     �   CREATE SEQUENCE public.autor_id_autor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.autor_id_autor_seq;
       public       postgres    false    196    3            Y           0    0    autor_id_autor_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.autor_id_autor_seq OWNED BY public.autor.id_autor;
            public       postgres    false    197            �            1259    82166    bairro    TABLE     �   CREATE TABLE public.bairro (
    nome character varying(100),
    id_bairro integer NOT NULL,
    id_cidade integer,
    data_exclusao date
);
    DROP TABLE public.bairro;
       public         postgres    false    3            �            1259    82164    bairro_id_bairro_seq    SEQUENCE     �   CREATE SEQUENCE public.bairro_id_bairro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.bairro_id_bairro_seq;
       public       postgres    false    213    3            Z           0    0    bairro_id_bairro_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.bairro_id_bairro_seq OWNED BY public.bairro.id_bairro;
            public       postgres    false    212            �            1259    82060    cidade    TABLE     �   CREATE TABLE public.cidade (
    id_cidade integer NOT NULL,
    nome character varying(100) NOT NULL,
    cep character varying(8) NOT NULL,
    data_exclusao date
);
    DROP TABLE public.cidade;
       public         postgres    false    3            �            1259    82063    cidade_id_cidade_seq    SEQUENCE     �   CREATE SEQUENCE public.cidade_id_cidade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cidade_id_cidade_seq;
       public       postgres    false    3    198            [           0    0    cidade_id_cidade_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cidade_id_cidade_seq OWNED BY public.cidade.id_cidade;
            public       postgres    false    199            �            1259    82065    editora    TABLE     �   CREATE TABLE public.editora (
    id_editora integer NOT NULL,
    cnpj character varying(14) NOT NULL,
    nome character varying(100) NOT NULL,
    data_exclusao date
);
    DROP TABLE public.editora;
       public         postgres    false    3            �            1259    82068    editora_id_editora_seq    SEQUENCE     �   CREATE SEQUENCE public.editora_id_editora_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.editora_id_editora_seq;
       public       postgres    false    3    200            \           0    0    editora_id_editora_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.editora_id_editora_seq OWNED BY public.editora.id_editora;
            public       postgres    false    201            �            1259    82070    funcionario    TABLE     7  CREATE TABLE public.funcionario (
    id_funcionario integer NOT NULL,
    id_livraria integer NOT NULL,
    pis character varying(13) NOT NULL,
    data_nascimento date NOT NULL,
    cpf character varying(11) NOT NULL,
    nome character varying(100) NOT NULL,
    data_exclusao date,
    id_bairro integer
);
    DROP TABLE public.funcionario;
       public         postgres    false    3            �            1259    82073    funcionario_id_funcionario_seq    SEQUENCE     �   CREATE SEQUENCE public.funcionario_id_funcionario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.funcionario_id_funcionario_seq;
       public       postgres    false    202    3            ]           0    0    funcionario_id_funcionario_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.funcionario_id_funcionario_seq OWNED BY public.funcionario.id_funcionario;
            public       postgres    false    203            �            1259    82075    funcionario_movimento    TABLE     v   CREATE TABLE public.funcionario_movimento (
    id_funcionario integer NOT NULL,
    id_movimento integer NOT NULL
);
 )   DROP TABLE public.funcionario_movimento;
       public         postgres    false    3            �            1259    82078    livraria    TABLE     �   CREATE TABLE public.livraria (
    id_livraria integer NOT NULL,
    id_cidade integer NOT NULL,
    data_exclusao date,
    id_bairro integer
);
    DROP TABLE public.livraria;
       public         postgres    false    3            �            1259    82081    livraria_id_livraria_seq    SEQUENCE     �   CREATE SEQUENCE public.livraria_id_livraria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.livraria_id_livraria_seq;
       public       postgres    false    3    205            ^           0    0    livraria_id_livraria_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.livraria_id_livraria_seq OWNED BY public.livraria.id_livraria;
            public       postgres    false    206            �            1259    82083    livro    TABLE     �   CREATE TABLE public.livro (
    id_livro integer NOT NULL,
    nome character varying(100) NOT NULL,
    id_editora integer NOT NULL,
    id_livraria integer NOT NULL,
    id_autor integer NOT NULL,
    data_lancamento date NOT NULL
);
    DROP TABLE public.livro;
       public         postgres    false    3            �            1259    82086    livro_id_livro_seq    SEQUENCE     �   CREATE SEQUENCE public.livro_id_livro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.livro_id_livro_seq;
       public       postgres    false    3    207            _           0    0    livro_id_livro_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.livro_id_livro_seq OWNED BY public.livro.id_livro;
            public       postgres    false    208            �            1259    82088 	   movimento    TABLE     �   CREATE TABLE public.movimento (
    id_movimento integer NOT NULL,
    id_funcionario integer NOT NULL,
    data_movimento date NOT NULL,
    id_livraria integer NOT NULL,
    tipo "char" NOT NULL
);
    DROP TABLE public.movimento;
       public         postgres    false    3            �            1259    82091    movimento_id_movimento_seq    SEQUENCE     �   CREATE SEQUENCE public.movimento_id_movimento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.movimento_id_movimento_seq;
       public       postgres    false    209    3            `           0    0    movimento_id_movimento_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.movimento_id_movimento_seq OWNED BY public.movimento.id_movimento;
            public       postgres    false    210            �            1259    82093    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    login character varying(50) NOT NULL,
    senha character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    nivel integer NOT NULL,
    data_exclusao date
);
    DROP TABLE public.usuarios;
       public         postgres    false    3            �
           2604    82096    autor id_autor    DEFAULT     p   ALTER TABLE ONLY public.autor ALTER COLUMN id_autor SET DEFAULT nextval('public.autor_id_autor_seq'::regclass);
 =   ALTER TABLE public.autor ALTER COLUMN id_autor DROP DEFAULT;
       public       postgres    false    197    196            �
           2604    82169    bairro id_bairro    DEFAULT     t   ALTER TABLE ONLY public.bairro ALTER COLUMN id_bairro SET DEFAULT nextval('public.bairro_id_bairro_seq'::regclass);
 ?   ALTER TABLE public.bairro ALTER COLUMN id_bairro DROP DEFAULT;
       public       postgres    false    212    213    213            �
           2604    82097    cidade id_cidade    DEFAULT     t   ALTER TABLE ONLY public.cidade ALTER COLUMN id_cidade SET DEFAULT nextval('public.cidade_id_cidade_seq'::regclass);
 ?   ALTER TABLE public.cidade ALTER COLUMN id_cidade DROP DEFAULT;
       public       postgres    false    199    198            �
           2604    82098    editora id_editora    DEFAULT     x   ALTER TABLE ONLY public.editora ALTER COLUMN id_editora SET DEFAULT nextval('public.editora_id_editora_seq'::regclass);
 A   ALTER TABLE public.editora ALTER COLUMN id_editora DROP DEFAULT;
       public       postgres    false    201    200            �
           2604    82099    funcionario id_funcionario    DEFAULT     �   ALTER TABLE ONLY public.funcionario ALTER COLUMN id_funcionario SET DEFAULT nextval('public.funcionario_id_funcionario_seq'::regclass);
 I   ALTER TABLE public.funcionario ALTER COLUMN id_funcionario DROP DEFAULT;
       public       postgres    false    203    202            �
           2604    82100    livraria id_livraria    DEFAULT     |   ALTER TABLE ONLY public.livraria ALTER COLUMN id_livraria SET DEFAULT nextval('public.livraria_id_livraria_seq'::regclass);
 C   ALTER TABLE public.livraria ALTER COLUMN id_livraria DROP DEFAULT;
       public       postgres    false    206    205            �
           2604    82101    livro id_livro    DEFAULT     p   ALTER TABLE ONLY public.livro ALTER COLUMN id_livro SET DEFAULT nextval('public.livro_id_livro_seq'::regclass);
 =   ALTER TABLE public.livro ALTER COLUMN id_livro DROP DEFAULT;
       public       postgres    false    208    207            �
           2604    82102    movimento id_movimento    DEFAULT     �   ALTER TABLE ONLY public.movimento ALTER COLUMN id_movimento SET DEFAULT nextval('public.movimento_id_movimento_seq'::regclass);
 E   ALTER TABLE public.movimento ALTER COLUMN id_movimento DROP DEFAULT;
       public       postgres    false    210    209            ?          0    82055    autor 
   TABLE DATA               >   COPY public.autor (id_autor, nome, data_exclusao) FROM stdin;
    public       postgres    false    196   �\       P          0    82166    bairro 
   TABLE DATA               K   COPY public.bairro (nome, id_bairro, id_cidade, data_exclusao) FROM stdin;
    public       postgres    false    213   �\       A          0    82060    cidade 
   TABLE DATA               E   COPY public.cidade (id_cidade, nome, cep, data_exclusao) FROM stdin;
    public       postgres    false    198   �\       C          0    82065    editora 
   TABLE DATA               H   COPY public.editora (id_editora, cnpj, nome, data_exclusao) FROM stdin;
    public       postgres    false    200   )]       E          0    82070    funcionario 
   TABLE DATA               }   COPY public.funcionario (id_funcionario, id_livraria, pis, data_nascimento, cpf, nome, data_exclusao, id_bairro) FROM stdin;
    public       postgres    false    202   V]       G          0    82075    funcionario_movimento 
   TABLE DATA               M   COPY public.funcionario_movimento (id_funcionario, id_movimento) FROM stdin;
    public       postgres    false    204   ^       H          0    82078    livraria 
   TABLE DATA               T   COPY public.livraria (id_livraria, id_cidade, data_exclusao, id_bairro) FROM stdin;
    public       postgres    false    205   %^       J          0    82083    livro 
   TABLE DATA               c   COPY public.livro (id_livro, nome, id_editora, id_livraria, id_autor, data_lancamento) FROM stdin;
    public       postgres    false    207   c^       L          0    82088 	   movimento 
   TABLE DATA               d   COPY public.movimento (id_movimento, id_funcionario, data_movimento, id_livraria, tipo) FROM stdin;
    public       postgres    false    209   �^       N          0    82093    usuarios 
   TABLE DATA               L   COPY public.usuarios (login, senha, nome, nivel, data_exclusao) FROM stdin;
    public       postgres    false    211   �^       a           0    0    autor_id_autor_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.autor_id_autor_seq', 1, true);
            public       postgres    false    197            b           0    0    bairro_id_bairro_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.bairro_id_bairro_seq', 1, true);
            public       postgres    false    212            c           0    0    cidade_id_cidade_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cidade_id_cidade_seq', 4, true);
            public       postgres    false    199            d           0    0    editora_id_editora_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.editora_id_editora_seq', 1, true);
            public       postgres    false    201            e           0    0    funcionario_id_funcionario_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.funcionario_id_funcionario_seq', 16, true);
            public       postgres    false    203            f           0    0    livraria_id_livraria_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.livraria_id_livraria_seq', 5, true);
            public       postgres    false    206            g           0    0    livro_id_livro_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.livro_id_livro_seq', 1, false);
            public       postgres    false    208            h           0    0    movimento_id_movimento_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.movimento_id_movimento_seq', 1, false);
            public       postgres    false    210            �
           2606    82104    autor autor_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id_autor);
 :   ALTER TABLE ONLY public.autor DROP CONSTRAINT autor_pkey;
       public         postgres    false    196            �
           2606    82171    bairro bairro_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.bairro
    ADD CONSTRAINT bairro_pkey PRIMARY KEY (id_bairro);
 <   ALTER TABLE ONLY public.bairro DROP CONSTRAINT bairro_pkey;
       public         postgres    false    213            �
           2606    82106    cidade cidade_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id_cidade);
 <   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
       public         postgres    false    198            �
           2606    82108    editora editora_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.editora
    ADD CONSTRAINT editora_pkey PRIMARY KEY (id_editora);
 >   ALTER TABLE ONLY public.editora DROP CONSTRAINT editora_pkey;
       public         postgres    false    200            �
           2606    82110    funcionario funcionario_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id_funcionario);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public         postgres    false    202            �
           2606    82112    livraria livraria_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.livraria
    ADD CONSTRAINT livraria_pkey PRIMARY KEY (id_livraria);
 @   ALTER TABLE ONLY public.livraria DROP CONSTRAINT livraria_pkey;
       public         postgres    false    205            �
           2606    82114    livro livro_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (id_livro);
 :   ALTER TABLE ONLY public.livro DROP CONSTRAINT livro_pkey;
       public         postgres    false    207            �
           2606    82116    movimento movimento_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.movimento
    ADD CONSTRAINT movimento_pkey PRIMARY KEY (id_movimento);
 B   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_pkey;
       public         postgres    false    209            �
           2606    82118    usuarios usuarios_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (login);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public         postgres    false    211            �
           2606    82119 '   funcionario_movimento fk_FM_funcionario    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario_movimento
    ADD CONSTRAINT "fk_FM_funcionario" FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id_funcionario);
 S   ALTER TABLE ONLY public.funcionario_movimento DROP CONSTRAINT "fk_FM_funcionario";
       public       postgres    false    204    2735    202            �
           2606    82124 %   funcionario_movimento fk_FM_movimento    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario_movimento
    ADD CONSTRAINT "fk_FM_movimento" FOREIGN KEY (id_movimento) REFERENCES public.movimento(id_movimento);
 Q   ALTER TABLE ONLY public.funcionario_movimento DROP CONSTRAINT "fk_FM_movimento";
       public       postgres    false    2741    204    209            �
           2606    82129    livro fk_autor_livro    FK CONSTRAINT     z   ALTER TABLE ONLY public.livro
    ADD CONSTRAINT fk_autor_livro FOREIGN KEY (id_autor) REFERENCES public.autor(id_autor);
 >   ALTER TABLE ONLY public.livro DROP CONSTRAINT fk_autor_livro;
       public       postgres    false    207    2729    196            �
           2606    82185 !   funcionario fk_bairro_funcionario    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT fk_bairro_funcionario FOREIGN KEY (id_bairro) REFERENCES public.bairro(id_bairro) NOT VALID;
 K   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fk_bairro_funcionario;
       public       postgres    false    2745    213    202            �
           2606    82180    livraria fk_bairro_livraria    FK CONSTRAINT     �   ALTER TABLE ONLY public.livraria
    ADD CONSTRAINT fk_bairro_livraria FOREIGN KEY (id_bairro) REFERENCES public.bairro(id_bairro) NOT VALID;
 E   ALTER TABLE ONLY public.livraria DROP CONSTRAINT fk_bairro_livraria;
       public       postgres    false    213    2745    205            �
           2606    82172    bairro fk_cidade_bairro    FK CONSTRAINT     �   ALTER TABLE ONLY public.bairro
    ADD CONSTRAINT fk_cidade_bairro FOREIGN KEY (id_cidade) REFERENCES public.cidade(id_cidade);
 A   ALTER TABLE ONLY public.bairro DROP CONSTRAINT fk_cidade_bairro;
       public       postgres    false    213    198    2731            �
           2606    82134    livraria fk_cidade_livraria    FK CONSTRAINT     �   ALTER TABLE ONLY public.livraria
    ADD CONSTRAINT fk_cidade_livraria FOREIGN KEY (id_cidade) REFERENCES public.cidade(id_cidade);
 E   ALTER TABLE ONLY public.livraria DROP CONSTRAINT fk_cidade_livraria;
       public       postgres    false    2731    198    205            �
           2606    82139    livro fk_editora_livro    FK CONSTRAINT     �   ALTER TABLE ONLY public.livro
    ADD CONSTRAINT fk_editora_livro FOREIGN KEY (id_editora) REFERENCES public.editora(id_editora);
 @   ALTER TABLE ONLY public.livro DROP CONSTRAINT fk_editora_livro;
       public       postgres    false    207    2733    200            �
           2606    82144 "   movimento fk_funcionario_movimento    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimento
    ADD CONSTRAINT fk_funcionario_movimento FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id_funcionario);
 L   ALTER TABLE ONLY public.movimento DROP CONSTRAINT fk_funcionario_movimento;
       public       postgres    false    209    202    2735            �
           2606    82149 #   funcionario fk_livraria_funcionario    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT fk_livraria_funcionario FOREIGN KEY (id_livraria) REFERENCES public.livraria(id_livraria);
 M   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fk_livraria_funcionario;
       public       postgres    false    202    2737    205            �
           2606    82154    livro fk_livraria_livro    FK CONSTRAINT     �   ALTER TABLE ONLY public.livro
    ADD CONSTRAINT fk_livraria_livro FOREIGN KEY (id_livraria) REFERENCES public.livraria(id_livraria);
 A   ALTER TABLE ONLY public.livro DROP CONSTRAINT fk_livraria_livro;
       public       postgres    false    2737    205    207            �
           2606    82159    movimento fk_livraria_movimento    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimento
    ADD CONSTRAINT fk_livraria_movimento FOREIGN KEY (id_livraria) REFERENCES public.livraria(id_livraria);
 I   ALTER TABLE ONLY public.movimento DROP CONSTRAINT fk_livraria_movimento;
       public       postgres    false    205    2737    209            ?      x�3�tvq.������� #      P      x����-�LI�4�4������� >��      A   B   x�3��N,���.N��442615���2��I�JML�O�
�[pZ���p�������qqq /�      C      x�3�4454�L)NI"�?�=... CS      E   �   x�u�;� D��.���p������E	��Yl�@r��c�+,<XS��&Mp���d�w��&׆�z�cZcE���H���*AZ,L<",H�!y�?�V�Y�����0�l�a{/?�B��'G�X4rK�c�ݹ�I��5��x�̓����UM�E)��xS�      G      x������ � �      H   .   x�3�4��".C ����R��P��$b�3�4��L�=... j[E      J      x������ � �      L      x������ � �      N   H   x�K,NI�vv0�0523HK�L	r��q�X`9#c�T�T�N��H2+51,��l��b�	惵��qqq #�     