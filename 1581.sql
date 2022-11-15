select customer_id, count(*) count_no_trans
from Visits a
where visit_id not in (select distinct visit_id from Transactions)
group by customer_id
