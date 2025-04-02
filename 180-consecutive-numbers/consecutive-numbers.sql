select
    distinct(num) as ConsecutiveNums
from
    Logs l1
where
    exists (select 1 from Logs l2 where l1.num=l2.num and l2.id=l1.id+1) and
    exists (select 1 from Logs l3 where l1.num=l3.num and l3.id=l1.id+2);