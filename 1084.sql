select product_id, product_name from Product
where product_id in(
    select product_id from Sales
    where sale_date>='2019-01-01' and sale_date<='2019-03-31'
)
and product_id not in (
    select product_id from Sales
    where sale_date<'2019-01-01' or sale_date>'2019-03-31'
)



START TRANSACTION;
CREATE TABLE `Product` ( 
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(250) NULL,
  `unit_price` INT NULL,
   PRIMARY KEY (`product_id`)
);
COMMIT;

START TRANSACTION;
CREATE TABLE `Sales` ( 
  `seller_id` INT NULL,
  `product_id` INT NULL,
  `buyer_id` INT NULL,
  `sale_date` DATE NULL,
  `quantity` INT NULL,
  `price` INT NULL
);
COMMIT;


insert into Product values(1,'S8',1000);
insert into Product values(2,'G4',800);
insert into Product values(3,'iPhone',1400);

insert into Sales values(1,1,1,'2019-01-21',2,2000);
insert into Sales values(1,2,2,'2019-02-17',1,800);
insert into Sales values(2,2,3,'2019-06-02',1,800);
insert into Sales values(3,3,4,'2019-05-13',2,2800);
