select user_id, max(time_stamp) last_stamp
from (select * from Logins where time_stamp >='2020-01-01' and time_stamp<'2021-01-01')a
group by user_id
