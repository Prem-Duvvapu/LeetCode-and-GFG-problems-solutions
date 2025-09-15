select
    distinct(class)
from Courses
where class in (
    select class from Courses group by class having count(*) >= 5
);
