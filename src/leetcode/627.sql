update Salary
set sex = if(sex='f','m','f')


START TRANSACTION;
CREATE TABLE `Salary` ( 
  `id` INT NOT NULL,
  `name` VARCHAR(250) NULL,
  `sex` ENUM('M','F') NULL,
  `salary` INT NULL,
   PRIMARY KEY (`id`)
);
COMMIT;


insert into Salary values(1,'A','m',2500);
insert into Salary values(2,'B','f',1500);
insert into Salary values(3,'C','m',5500);
insert into Salary values(4,'D','f',500);

