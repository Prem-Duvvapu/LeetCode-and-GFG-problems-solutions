select distinct l1.num as ConsecutiveNums
from Logs l1
where l1.num = (
    select l2.num
    from Logs l2
    where l2.id = l1.id + 1
) 
and l1.num = (
    select l3.num
    from Logs l3
    where l3.id = l1.id + 2
);
