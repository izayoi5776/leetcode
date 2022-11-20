select * from Patients
where conditions like '% DIAB1%'
or  conditions like 'DIAB1%'


START TRANSACTION;
CREATE TABLE `Patients` ( 
  `patient_id` INT NOT NULL,
  `patient_name` VARCHAR(250) NULL,
  `conditions` VARCHAR(250) NULL,
   PRIMARY KEY (`patient_id`)
);
COMMIT;


insert into Patients values(1,'Daniel','YFEV COUGH');
insert into Patients values(2,'Alice',null);
insert into Patients values(3,'Bob','DIAB100 MYOP');
insert into Patients values(4,'George','ACNE DIAB100');
insert into Patients values(5,'Alain','DIAB201');
insert into Patients values(9,'13/14','SADIAB100');

