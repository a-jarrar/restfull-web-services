insert into brand (brand_id, brand_name) values (1000, 'brand1');
insert into brand (brand_id, brand_name) values (1001, 'brand2');

insert into product (Product_Id, product_Name, description, sales_price, discount_price, brand_brand_Id) values (1000, 'product1', 'my product 1', 11.3, 8.12, 1000);
insert into product (Product_Id, product_Name, description, sales_price, discount_price, brand_brand_Id) values (1001, 'product2', 'my product 2', 10.3, 7.42, 1000);
insert into product (Product_Id, product_Name, description, sales_price, discount_price, brand_brand_Id) values (1002, 'product3', 'my product 3', 20.2, 12.72, 1000);
insert into product (Product_Id, product_Name, description, sales_price, discount_price, brand_brand_Id) values (1003, 'product4', 'my product 4', 18.4, 14.52, 1001);
insert into product (Product_Id, product_Name, description, sales_price, discount_price, brand_brand_Id) values (1004, 'product5', 'my product 5', 14.5, 11.88, 1001);
insert into product (Product_Id, product_Name, description, sales_price, discount_price, brand_brand_Id) values (1007, 'product7', 'my product 7', 22.54, 17.12, 1001);

insert into category (category_id, category_name) values (1000, 'category1');
insert into category (category_id, category_name) values (1001, 'category2');
insert into category (category_id, category_name) values (1002, 'category3');


insert into cart (cart_id, total_price) values (1000, 124.32);
insert into cart (cart_id, total_price) values (1001, 433.55);

insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1001, 44.85, 1, 1000, 1000);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1002, 42.5, 2, 1000, 1002);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1003, 413.15, 1, 1000, 1003);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1004, 3.45, 3, 1000, 1004);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1005, 23.5, 2, 1000, 1001);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1006, 2.35, 1, 1001, 1003);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1007, 3.25, 1, 1001, 1002);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1008, 6.5, 1, 1001, 1000);
insert into cart_item (cart_item_seq_Id, price, quantity, cart_cart_Id, product_product_Id) values (1009, 33.95, 5, 1001, 1004);

insert into products_categories (Product_Id, category_id) values (1000, 1000);
insert into products_categories (Product_Id, category_id) values (1001, 1000);
insert into products_categories (Product_Id, category_id) values (1002, 1000);
insert into products_categories (Product_Id, category_id) values (1003, 1000);
insert into products_categories (Product_Id, category_id) values (1001, 1001);
insert into products_categories (Product_Id, category_id) values (1003, 1001);
insert into products_categories (Product_Id, category_id) values (1004, 1001);

insert into order_header (order_Id, order_Name, description, cart_Id) values (1000, 'order hrader 1', 'my order header 1', 1000);
insert into order_header (order_Id, order_Name, description, cart_Id) values (1001, 'order header 2', 'my order header 2', 1001);

