select name, ifnull(dis,0) travelled_distance
from Users a left join (
    select user_id, sum(distance) dis
    from Rides
    group by user_id
) b
on a.id=b.user_id
order by dis desc, name
