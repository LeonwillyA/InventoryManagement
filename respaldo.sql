PGDMP  4                    |            gestion_inventario     16.3 (Ubuntu 16.3-1.pgdg22.04+1)     16.3 (Ubuntu 16.3-1.pgdg22.04+1) F    p           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            q           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            r           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            s           1262    40961    gestion_inventario    DATABASE     z   CREATE DATABASE gestion_inventario WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C.UTF-8';
 "   DROP DATABASE gestion_inventario;
                postgres    false            �            1259    40977 
   categories    TABLE       CREATE TABLE public.categories (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.categories;
       public         heap    postgres    false            �            1259    40976    categories_id_seq    SEQUENCE     �   CREATE SEQUENCE public.categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.categories_id_seq;
       public          postgres    false    216            t           0    0    categories_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;
          public          postgres    false    215            �            1259    41007 	   customers    TABLE     R  CREATE TABLE public.customers (
    name character varying(255) NOT NULL,
    email character varying(255),
    phone_number character varying(50),
    address text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    id character varying(20)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    41113    inventory_movements    TABLE     �  CREATE TABLE public.inventory_movements (
    id integer NOT NULL,
    product_id integer,
    movement_type character varying(50) NOT NULL,
    quantity integer NOT NULL,
    movement_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    reason text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 '   DROP TABLE public.inventory_movements;
       public         heap    postgres    false            �            1259    41112    inventory_movements_id_seq    SEQUENCE     �   CREATE SEQUENCE public.inventory_movements_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.inventory_movements_id_seq;
       public          postgres    false    231            u           0    0    inventory_movements_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.inventory_movements_id_seq OWNED BY public.inventory_movements.id;
          public          postgres    false    230            �            1259    40988    products    TABLE     �  CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description text,
    price numeric(10,2) NOT NULL,
    sku character varying(100),
    category_id integer,
    stock_quantity integer DEFAULT 0,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    40987    products_id_seq    SEQUENCE     �   CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.products_id_seq;
       public          postgres    false    218            v           0    0    products_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;
          public          postgres    false    217            �            1259    41080    purchase_items    TABLE     G  CREATE TABLE public.purchase_items (
    id integer NOT NULL,
    purchase_id integer,
    product_id integer,
    quantity integer NOT NULL,
    price_per_unit numeric(10,2) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 "   DROP TABLE public.purchase_items;
       public         heap    postgres    false            �            1259    41079    purchase_items_id_seq    SEQUENCE     �   CREATE SEQUENCE public.purchase_items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.purchase_items_id_seq;
       public          postgres    false    229            w           0    0    purchase_items_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.purchase_items_id_seq OWNED BY public.purchase_items.id;
          public          postgres    false    228            �            1259    41045 	   purchases    TABLE     �  CREATE TABLE public.purchases (
    id integer NOT NULL,
    purchase_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    supplier_id integer,
    total_amount numeric(15,2),
    status character varying(50) DEFAULT 'RECEIVED'::character varying,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.purchases;
       public         heap    postgres    false            �            1259    41044    purchases_id_seq    SEQUENCE     �   CREATE SEQUENCE public.purchases_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.purchases_id_seq;
       public          postgres    false    225            x           0    0    purchases_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.purchases_id_seq OWNED BY public.purchases.id;
          public          postgres    false    224            �            1259    41061 
   sale_items    TABLE     ?  CREATE TABLE public.sale_items (
    id integer NOT NULL,
    sale_id integer,
    product_id integer,
    quantity integer NOT NULL,
    price_per_unit numeric(10,2) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.sale_items;
       public         heap    postgres    false            �            1259    41060    sale_items_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sale_items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.sale_items_id_seq;
       public          postgres    false    227            y           0    0    sale_items_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.sale_items_id_seq OWNED BY public.sale_items.id;
          public          postgres    false    226            �            1259    41029    sales    TABLE     �  CREATE TABLE public.sales (
    id integer NOT NULL,
    sale_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    customer_id character varying(20),
    total_amount numeric(15,2),
    status character varying(50) DEFAULT 'COMPLETED'::character varying,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.sales;
       public         heap    postgres    false            �            1259    41028    sales_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sales_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.sales_id_seq;
       public          postgres    false    223            z           0    0    sales_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.sales_id_seq OWNED BY public.sales.id;
          public          postgres    false    222            �            1259    41018 	   suppliers    TABLE     ~  CREATE TABLE public.suppliers (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    contact_name character varying(255),
    contact_email character varying(255),
    phone_number character varying(50),
    address text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.suppliers;
       public         heap    postgres    false            �            1259    41017    suppliers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.suppliers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.suppliers_id_seq;
       public          postgres    false    221            {           0    0    suppliers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.suppliers_id_seq OWNED BY public.suppliers.id;
          public          postgres    false    220            �           2604    40980    categories id    DEFAULT     n   ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);
 <   ALTER TABLE public.categories ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    41116    inventory_movements id    DEFAULT     �   ALTER TABLE ONLY public.inventory_movements ALTER COLUMN id SET DEFAULT nextval('public.inventory_movements_id_seq'::regclass);
 E   ALTER TABLE public.inventory_movements ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    230    231    231            �           2604    40991    products id    DEFAULT     j   ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);
 :   ALTER TABLE public.products ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    41083    purchase_items id    DEFAULT     v   ALTER TABLE ONLY public.purchase_items ALTER COLUMN id SET DEFAULT nextval('public.purchase_items_id_seq'::regclass);
 @   ALTER TABLE public.purchase_items ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    229    228    229            �           2604    41048    purchases id    DEFAULT     l   ALTER TABLE ONLY public.purchases ALTER COLUMN id SET DEFAULT nextval('public.purchases_id_seq'::regclass);
 ;   ALTER TABLE public.purchases ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225            �           2604    41064    sale_items id    DEFAULT     n   ALTER TABLE ONLY public.sale_items ALTER COLUMN id SET DEFAULT nextval('public.sale_items_id_seq'::regclass);
 <   ALTER TABLE public.sale_items ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    41032    sales id    DEFAULT     d   ALTER TABLE ONLY public.sales ALTER COLUMN id SET DEFAULT nextval('public.sales_id_seq'::regclass);
 7   ALTER TABLE public.sales ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223            �           2604    41021    suppliers id    DEFAULT     l   ALTER TABLE ONLY public.suppliers ALTER COLUMN id SET DEFAULT nextval('public.suppliers_id_seq'::regclass);
 ;   ALTER TABLE public.suppliers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            ^          0    40977 
   categories 
   TABLE DATA           S   COPY public.categories (id, name, description, created_at, updated_at) FROM stdin;
    public          postgres    false    216   X       a          0    41007 	   customers 
   TABLE DATA           c   COPY public.customers (name, email, phone_number, address, created_at, updated_at, id) FROM stdin;
    public          postgres    false    219   �X       m          0    41113    inventory_movements 
   TABLE DATA           �   COPY public.inventory_movements (id, product_id, movement_type, quantity, movement_date, reason, created_at, updated_at) FROM stdin;
    public          postgres    false    231   �Y       `          0    40988    products 
   TABLE DATA           z   COPY public.products (id, name, description, price, sku, category_id, stock_quantity, created_at, updated_at) FROM stdin;
    public          postgres    false    218   o[       k          0    41080    purchase_items 
   TABLE DATA           w   COPY public.purchase_items (id, purchase_id, product_id, quantity, price_per_unit, created_at, updated_at) FROM stdin;
    public          postgres    false    229   P`       g          0    41045 	   purchases 
   TABLE DATA           q   COPY public.purchases (id, purchase_date, supplier_id, total_amount, status, created_at, updated_at) FROM stdin;
    public          postgres    false    225   �`       i          0    41061 
   sale_items 
   TABLE DATA           o   COPY public.sale_items (id, sale_id, product_id, quantity, price_per_unit, created_at, updated_at) FROM stdin;
    public          postgres    false    227   a       e          0    41029    sales 
   TABLE DATA           i   COPY public.sales (id, sale_date, customer_id, total_amount, status, created_at, updated_at) FROM stdin;
    public          postgres    false    223   �a       c          0    41018 	   suppliers 
   TABLE DATA           y   COPY public.suppliers (id, name, contact_name, contact_email, phone_number, address, created_at, updated_at) FROM stdin;
    public          postgres    false    221   b       |           0    0    categories_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.categories_id_seq', 5, true);
          public          postgres    false    215            }           0    0    inventory_movements_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.inventory_movements_id_seq', 30, true);
          public          postgres    false    230            ~           0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.products_id_seq', 55, true);
          public          postgres    false    217                       0    0    purchase_items_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.purchase_items_id_seq', 3, true);
          public          postgres    false    228            �           0    0    purchases_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.purchases_id_seq', 58, true);
          public          postgres    false    224            �           0    0    sale_items_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.sale_items_id_seq', 5, true);
          public          postgres    false    226            �           0    0    sales_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.sales_id_seq', 5, true);
          public          postgres    false    222            �           0    0    suppliers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.suppliers_id_seq', 2, true);
          public          postgres    false    220            �           2606    40986    categories categories_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.categories DROP CONSTRAINT categories_pkey;
       public            postgres    false    216            �           2606    41123 ,   inventory_movements inventory_movements_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.inventory_movements
    ADD CONSTRAINT inventory_movements_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.inventory_movements DROP CONSTRAINT inventory_movements_pkey;
       public            postgres    false    231            �           2606    40998    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    218            �           2606    41000    products products_sku_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_sku_key UNIQUE (sku);
 C   ALTER TABLE ONLY public.products DROP CONSTRAINT products_sku_key;
       public            postgres    false    218            �           2606    41087 "   purchase_items purchase_items_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.purchase_items
    ADD CONSTRAINT purchase_items_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.purchase_items DROP CONSTRAINT purchase_items_pkey;
       public            postgres    false    229            �           2606    41054    purchases purchases_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.purchases
    ADD CONSTRAINT purchases_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.purchases DROP CONSTRAINT purchases_pkey;
       public            postgres    false    225            �           2606    41068    sale_items sale_items_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.sale_items
    ADD CONSTRAINT sale_items_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.sale_items DROP CONSTRAINT sale_items_pkey;
       public            postgres    false    227            �           2606    41038    sales sales_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.sales DROP CONSTRAINT sales_pkey;
       public            postgres    false    223            �           2606    41027    suppliers suppliers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.suppliers
    ADD CONSTRAINT suppliers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.suppliers DROP CONSTRAINT suppliers_pkey;
       public            postgres    false    221            �           2606    41124 7   inventory_movements inventory_movements_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.inventory_movements
    ADD CONSTRAINT inventory_movements_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);
 a   ALTER TABLE ONLY public.inventory_movements DROP CONSTRAINT inventory_movements_product_id_fkey;
       public          postgres    false    231    3256    218            �           2606    41001 "   products products_category_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.categories(id);
 L   ALTER TABLE ONLY public.products DROP CONSTRAINT products_category_id_fkey;
       public          postgres    false    3254    216    218            �           2606    41093 -   purchase_items purchase_items_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.purchase_items
    ADD CONSTRAINT purchase_items_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);
 W   ALTER TABLE ONLY public.purchase_items DROP CONSTRAINT purchase_items_product_id_fkey;
       public          postgres    false    218    229    3256            �           2606    41088 .   purchase_items purchase_items_purchase_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.purchase_items
    ADD CONSTRAINT purchase_items_purchase_id_fkey FOREIGN KEY (purchase_id) REFERENCES public.purchases(id);
 X   ALTER TABLE ONLY public.purchase_items DROP CONSTRAINT purchase_items_purchase_id_fkey;
       public          postgres    false    3264    225    229            �           2606    41055 $   purchases purchases_supplier_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.purchases
    ADD CONSTRAINT purchases_supplier_id_fkey FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id);
 N   ALTER TABLE ONLY public.purchases DROP CONSTRAINT purchases_supplier_id_fkey;
       public          postgres    false    221    3260    225            �           2606    41074 %   sale_items sale_items_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sale_items
    ADD CONSTRAINT sale_items_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);
 O   ALTER TABLE ONLY public.sale_items DROP CONSTRAINT sale_items_product_id_fkey;
       public          postgres    false    3256    227    218            �           2606    41069 "   sale_items sale_items_sale_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sale_items
    ADD CONSTRAINT sale_items_sale_id_fkey FOREIGN KEY (sale_id) REFERENCES public.sales(id);
 L   ALTER TABLE ONLY public.sale_items DROP CONSTRAINT sale_items_sale_id_fkey;
       public          postgres    false    227    3262    223            ^   �   x�m�A�@E��S� 1��x 74S�a���3p1��Ф������]�)G�1M��p$%d�.�Hp>�U��3_b�_�u,�ݒDV:ʄ��/w����ʠt�{X����~���F��A���()1(?��2rmj�j��5����H�1�� �}hR      a   �   x�m�ͪ�0���S�h�OӦ�AAzA\�$\zI����o���s.��pfq��q~0M�fz��:L-��/��!xq��]U��h�VM�G~����C��.��͵�R�eYQQ�u|w���=����|�����ck�C�#lBL$&�ی�ͬ���W=�Ӊ�3�Q�Ro�S�/���l��۞&�Ufꛕ5Ŕ����|`�      m   �  x����jA�k�)�+���ېօIHcR]�y�"����c�~� ���51������"�8�~����!��e��~���|w�}�q{�I#����\\Q�2��i��s=���k1wDS��K��;"�iH��6������'�U֜k�D]�H��&[^�ׅ�>�v�9�_u_'}O���c���꾍�=��r|��/;��ʍT>�������ҨK���ki?�����;�t�k�&6.o�#�)1E25���k�H���dj!�n�m1"���b+_gԾ �E2�Ml�6GJc�#�Z���Q+D��v���ji�H#��w���P{���M���� �H�~�}Υ�Z �H���?x�P�D��!�Q�� G2}��iE-q`��X����s)q$S�������ǈ���;ߺ��D��w�q�1w.�D���r[���Gq$��T�?PgD�      `   �  x����n�6�g�)�DJ���]�4H'5�"C���h��$��d���(;d����X�H�Hu(�!����x�s>�89ɶe*mxz�Uˆ��e}�/�d��u{�6�+${�e���&�p���B���pA�g�I�:���ҟ&ޏ���2�|�ֲOka&���>�ld	>,X�"B���P�aV2}+z� �kd��TB�N��Z`$B���N�FC�G�a�bm�6��EMя�?Gs��,42J�S��ݞ��޺��=N�Ȫ�'�.
�<,��)�h�Ln�v���W�Tr�KԿ?�6?�V*�h��ۛO�{�"c�N�FC��&nMSx����F<��D T�9�N�FC��X8SO��:*޿@�$x��9D)w�1�ڔc�mS�����4�g� R��=)C������D�)��˹-'���D��QaNC'�^��u�'���P�`^p��L����L��?�ɓ˰Z�S-������x��D=����Y���4g�P	PqD�)ۢsp�u�����Dc&o1K��`��tW�
��Z��E��
���:��C�������+��p �Q��2��b�e|���LI�����ZȞ3�v
;/MMCLl�NC�L���6�Q�!}#����Ec:8�}���8\m?����/���pF�:�K��f�	��hF��ѐ`B��0k�NC�����k��l�t�k��Σ��9@��S�uT|�Af/��s�m�[7�pQw���4����lm��w�'T���;��4Dpr�d��m�*�$6K���v�O�t����Av,�i��K��𰸓�csU�o���;s_)C$@>�d�e��H�]kz����9��Յ��ܜ��	�Ls��9�3�\��hB�Gٱ12?K��f����\�ܼ��^���w�7U	�����ټ4N�R|��¦����c`�D��1"css"�F�tS��M����-Z��Fm����^?�_%�e3�z�n[���2�%#����i�/�]>��{>/��rC����t�f��ԓ��)ҺɽǓ�~I�vT�Rp��W���=˫��"+R�����h�%w.
�#��Xŕb��� m�+vx��pp��gs���=�zb����spt�U���I ���;#�>�,d+z�{��g�4�!{�-6j��O�&䯁p���_�	� �露\���7�i�~��ϭ���|}��u�9=      k   K   x�m��	�0Cѳ5EH��Bf��s4����a7?'�s�g�\Cqyl��TȂ���FUC�1���R��kx&�m�      g   [   x�3�4202�5��52V04�20 "NC�����������U1.#tQS�JNCS��b1$�e�㇆�L���b3�"f�E,F��� 5<5�      i   _   x����	� ���]@Ib��Ct����^,�"r��>HD����%>��C�����o�W����QA�Q��Į$uO�ӑ��E�T�n�����/�      e   }   x���=�@F�Sx�%�,�B�������Mfb�~����c+Ԋ��J���70��-�u��iL儡�P~�.�b���dw���C��k��W�
C�=�	C˳�5W�v��Y��]���G��OE�Tk      c   �   x�m�;�0��)� `%�*>
���fc\m�d'Hp'N��pHi�yi'��Co��C�3�{��^��&������i'�R;�R�VuUy�R�>%6��TellG��/�z��8��$��&܋���14�������a����$��6��>�Q����2/ʪ���O�a���b�b��U
!~ljO�     