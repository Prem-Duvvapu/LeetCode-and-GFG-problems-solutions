# Write your MySQL query statement below
Select e.name,b.bonus from Employee e left join Bonus b on e.empId=b.empId where coalesce(b.bonus,0)<1000;