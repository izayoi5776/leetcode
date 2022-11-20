select name
from SalesPerson s2
where s2.sales_id not in 
(
    select s.sales_id
    from SalesPerson s
    join Orders o
    on s.sales_id=o.sales_id
    join Company c
    on o.com_id=c.com_id
    where c.name='RED'
)
