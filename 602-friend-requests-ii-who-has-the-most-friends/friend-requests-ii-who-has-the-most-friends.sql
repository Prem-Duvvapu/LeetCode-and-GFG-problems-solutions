with base as (
    select requester_id as id from RequestAccepted
    union all
    select accepter_id as id from RequestAccepted
)

select id, count(*) as num from base group by id order by count(id) desc limit 1;