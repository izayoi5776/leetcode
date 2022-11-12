select a.FirstName, a.LastName, b.city, b.State
from Person as a left join Address as b
on a.PersonId=b.PersonId
