PGDMP                      
    x            Library    12.2    12.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                        0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            !           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            "           1262    32847    Library    DATABASE     �   CREATE DATABASE "Library" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE "Library";
                postgres    false            �            1259    32858    Books    TABLE     �   CREATE TABLE public."Books" (
    id integer NOT NULL,
    name_book character varying,
    author character varying,
    in_library boolean
);
    DROP TABLE public."Books";
       public         heap    postgres    false            �            1259    32856    Books_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Books_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public."Books_id_seq";
       public          postgres    false    205            #           0    0    Books_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public."Books_id_seq" OWNED BY public."Books".id;
          public          postgres    false    204            �            1259    32850    Readers    TABLE     t   CREATE TABLE public."Readers" (
    id integer NOT NULL,
    name character varying,
    abonement_number bigint
);
    DROP TABLE public."Readers";
       public         heap    postgres    false            �            1259    32848    Readers_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Readers_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."Readers_id_seq";
       public          postgres    false    203            $           0    0    Readers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public."Readers_id_seq" OWNED BY public."Readers".id;
          public          postgres    false    202            �            1259    32866    Relation_books_and_readers    TABLE     �   CREATE TABLE public."Relation_books_and_readers" (
    id integer NOT NULL,
    id_reader bigint NOT NULL,
    id_book bigint NOT NULL,
    active boolean DEFAULT true
);
 0   DROP TABLE public."Relation_books_and_readers";
       public         heap    postgres    false            �            1259    32864 !   Relation_books_and_readers_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Relation_books_and_readers_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public."Relation_books_and_readers_id_seq";
       public          postgres    false    207            %           0    0 !   Relation_books_and_readers_id_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public."Relation_books_and_readers_id_seq" OWNED BY public."Relation_books_and_readers".id;
          public          postgres    false    206            �
           2604    32861    Books id    DEFAULT     h   ALTER TABLE ONLY public."Books" ALTER COLUMN id SET DEFAULT nextval('public."Books_id_seq"'::regclass);
 9   ALTER TABLE public."Books" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    32853 
   Readers id    DEFAULT     l   ALTER TABLE ONLY public."Readers" ALTER COLUMN id SET DEFAULT nextval('public."Readers_id_seq"'::regclass);
 ;   ALTER TABLE public."Readers" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            �
           2604    32869    Relation_books_and_readers id    DEFAULT     �   ALTER TABLE ONLY public."Relation_books_and_readers" ALTER COLUMN id SET DEFAULT nextval('public."Relation_books_and_readers_id_seq"'::regclass);
 N   ALTER TABLE public."Relation_books_and_readers" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207                      0    32858    Books 
   TABLE DATA           D   COPY public."Books" (id, name_book, author, in_library) FROM stdin;
    public          postgres    false    205   I                 0    32850    Readers 
   TABLE DATA           ?   COPY public."Readers" (id, name, abonement_number) FROM stdin;
    public          postgres    false    203   �                 0    32866    Relation_books_and_readers 
   TABLE DATA           V   COPY public."Relation_books_and_readers" (id, id_reader, id_book, active) FROM stdin;
    public          postgres    false    207   �       &           0    0    Books_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."Books_id_seq"', 2, true);
          public          postgres    false    204            '           0    0    Readers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Readers_id_seq"', 2, true);
          public          postgres    false    202            (           0    0 !   Relation_books_and_readers_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."Relation_books_and_readers_id_seq"', 1, false);
          public          postgres    false    206            �
           2606    32863    Books Books_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."Books"
    ADD CONSTRAINT "Books_pkey" PRIMARY KEY (id);
 >   ALTER TABLE ONLY public."Books" DROP CONSTRAINT "Books_pkey";
       public            postgres    false    205            �
           2606    32855    Readers Readers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Readers"
    ADD CONSTRAINT "Readers_pkey" PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."Readers" DROP CONSTRAINT "Readers_pkey";
       public            postgres    false    203            �
           2606    32871 :   Relation_books_and_readers Relation_books_and_readers_pkey 
   CONSTRAINT     |   ALTER TABLE ONLY public."Relation_books_and_readers"
    ADD CONSTRAINT "Relation_books_and_readers_pkey" PRIMARY KEY (id);
 h   ALTER TABLE ONLY public."Relation_books_and_readers" DROP CONSTRAINT "Relation_books_and_readers_pkey";
       public            postgres    false    207            �
           2606    32872 +   Relation_books_and_readers relation_to_book    FK CONSTRAINT     �   ALTER TABLE ONLY public."Relation_books_and_readers"
    ADD CONSTRAINT relation_to_book FOREIGN KEY (id_book) REFERENCES public."Books"(id);
 W   ALTER TABLE ONLY public."Relation_books_and_readers" DROP CONSTRAINT relation_to_book;
       public          postgres    false    207    205    2708            �
           2606    32877 -   Relation_books_and_readers relation_to_reader    FK CONSTRAINT     �   ALTER TABLE ONLY public."Relation_books_and_readers"
    ADD CONSTRAINT relation_to_reader FOREIGN KEY (id_reader) REFERENCES public."Readers"(id);
 Y   ALTER TABLE ONLY public."Relation_books_and_readers" DROP CONSTRAINT relation_to_reader;
       public          postgres    false    203    2706    207               J   x�3估�bÅ
�\l��qaׅ�������S.�]�d�pq^X��pa;���ya>T�{��1z\\\ ��+8         .   x�# ��1	Андрей	1
2	Маша	2
\.


P�<            x������ � �     