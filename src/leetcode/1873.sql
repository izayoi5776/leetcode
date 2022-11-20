select * from(
select employee_id, salary bonus
from Employees
where name not like 'M%'
and mod(employee_id,2)=1
union
select employee_id, 0 bonus
from Employees
where name like 'M%'
or mod(employee_id,2)=0
) a
order by employee_id