select sell_date, count(*) num_sold, group_concat(distinct product order by product separator ',') products
from (select distinct sell_date, product from Activities) a
group by sell_date
order by sell_date
