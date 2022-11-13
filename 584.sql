select name
from customer
where referee_id is null or referee_id != 2



CREATE TABLE leetcodedemo.customer (
	id INT NOT NULL,
	name varchar(100) NULL,
	referee_id INT NULL
)


+------+------+-----------+
| id   | name | referee_id|
+------+------+-----------+
|    1 | Will |      NULL |
|    2 | Jane |      NULL |
|    3 | Alex |         2 |
|    4 | Bill |      NULL |
|    5 | Zack |         1 |
|    6 | Mark |         2 |
+------+------+-----------+
