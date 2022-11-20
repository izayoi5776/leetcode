select user_id, concat(Upper(left(name,1)),lower(substr(name,2))) name
from Users
order by user_id


START TRANSACTION;
CREATE TABLE `Users` ( 
  `user_id` INT NOT NULL,
  `name` VARCHAR(250) NULL,
   PRIMARY KEY (`user_id`)
);
COMMIT;


insert into Users values(1,'aLice');
insert into Users values(2,'bOB');
