select c.employee_id
from (
select a.employee_id, name, salary from Employees a
left join Salaries b
on a.employee_id=b.employee_id
union
select b.employee_id, name, salary from Employees a
right join Salaries b
on a.employee_id=b.employee_id
) c
where c.name is null or c.salary is null
order by c.employee_id


START TRANSACTION;
CREATE TABLE `Employees` ( 
  `employee_id` INT NOT NULL,
  `name` VARCHAR(250) NULL,
   PRIMARY KEY (`employee_id`)
);
COMMIT;

START TRANSACTION;
CREATE TABLE `Salaries` ( 
  `employee_id` INT NULL,
  `salary` INT NULL,
   PRIMARY KEY (`employee_id`)
);
COMMIT;

insert into Employees values(2,'Crew');
insert into Employees values(4,'Haven');
insert into Employees values(5,'Kristian');
insert into Salaries values(5,76071);
insert into Salaries values(1,22517);
insert into Salaries values(4,63539);
