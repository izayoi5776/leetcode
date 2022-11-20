select event_day day, emp_id, sum(n) total_time
from (
select emp_id, event_day, in_time, out_time - in_time n
from Employees
group by emp_id, event_day, in_time
) a
group by emp_id, event_day