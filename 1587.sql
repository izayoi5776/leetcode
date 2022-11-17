select a.name NAME, b.balance BALANCE
from Users a
join (
select account,  sum(amount) balance
from Transactions
group by account
having balance>10000
) b
on a.account = b.account
