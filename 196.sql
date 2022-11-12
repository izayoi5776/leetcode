delete from Person a
where a.id not in(
    select min(b.id)
    from (select * from Person) b
    group by email
)
