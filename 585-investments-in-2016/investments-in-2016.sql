select
    round(sum(i1.tiv_2016),2) as tiv_2016
from
    Insurance i1
where
    i1.tiv_2015 in (
        select i2.tiv_2015 from Insurance i2 where i2.pid!=i1.pid
    )
    and 
    (i1.lat,i1.lon) not in (
        select i3.lat,i3.lon from Insurance i3 where i3.pid!=i1.pid
    );