select a.id, Jan_Revenue, Feb_Revenue,Mar_Revenue,Apr_Revenue,May_Revenue,Jun_Revenue
            ,Jul_Revenue, Aug_Revenue,Sep_Revenue,Oct_Revenue,Nov_Revenue,Dec_Revenue
from
(select distinct id from Department) a
left join (select id, revenue Jan_Revenue from Department where month='Jan' group by id) jan on a.id=jan.id
left join (select id, revenue Feb_Revenue from Department where month='Feb' group by id) feb on a.id=feb.id
left join (select id, revenue Mar_Revenue from Department where month='Mar' group by id) mar on a.id=mar.id
left join (select id, revenue Apr_Revenue from Department where month='Apr' group by id) apr on a.id=apr.id
left join (select id, revenue May_Revenue from Department where month='May' group by id) may on a.id=may.id
left join (select id, revenue Jun_Revenue from Department where month='Jun' group by id) jun on a.id=jun.id
left join (select id, revenue Jul_Revenue from Department where month='Jul' group by id) jul on a.id=jul.id
left join (select id, revenue Aug_Revenue from Department where month='Aug' group by id) aug on a.id=aug.id
left join (select id, revenue Sep_Revenue from Department where month='Sep' group by id) sep on a.id=sep.id
left join (select id, revenue Oct_Revenue from Department where month='Oct' group by id) oct on a.id=oct.id
left join (select id, revenue Nov_Revenue from Department where month='Nov' group by id) nov on a.id=nov.id
left join (select id, revenue Dec_Revenue from Department where month='Dec' group by id) dxc on a.id=dxc.id


START TRANSACTION;
CREATE TABLE `Department` ( 
  `id` INT NULL,
  `revenue` INT NULL,
  `month` VARCHAR(3) NULL,
   PRIMARY KEY (`id`, `month`)
);
COMMIT;


insert into Department values(1,8000,'Jan');
insert into Department values(2,9000,'Jan');
insert into Department values(3,10000,'Feb');
insert into Department values(1,7000,'Feb');
insert into Department values(1,6000,'Mar');

