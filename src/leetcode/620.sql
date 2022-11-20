select *
from cinema
where description != 'boring'
and mod(id,2)!=0
order by rating desc


START TRANSACTION;
CREATE TABLE `cinema` ( 
  `id` INT NOT NULL,
  `movie` VARCHAR(250) NULL,
  `description` VARCHAR(250) NULL,
  `rating` DECIMAL(10,1) NULL,
   PRIMARY KEY (`id`)
);
COMMIT;

INSERT INTO cinema VALUES (1,'War','great 3D',8.9);
INSERT INTO cinema VALUES (2,'Science','fiction',8.5);
INSERT INTO cinema VALUES (3,'irish','boring',6.2);
INSERT INTO cinema VALUES (4,'Ice song','Fantacy',8.6);
INSERT INTO cinema VALUES (5,'House card','Interesting',9.1);

