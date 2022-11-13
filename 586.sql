select a.customer_number
from Orders as a,
(
    select distinct count(*) cnt from Orders
    group by customer_number
    order by cnt desc
    limit 1
) as b
group by a.customer_number, b.cnt
having count(*)=b.cnt


START TRANSACTION;
CREATE TABLE `Orders` ( 
  `order_number` INT NOT NULL,
  `customer_number` INT NOT NULL,
   PRIMARY KEY (`order_number`)
);
COMMIT;


insert into Orders values(1,1);
insert into Orders values(2,2);
insert into Orders values(3,3);
insert into Orders values(4,3);
insert into Orders values(5,2);

