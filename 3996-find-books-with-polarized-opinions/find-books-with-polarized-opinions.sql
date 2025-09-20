select
    b.book_id,
    b.title,
    b.author,
    b.genre,
    b.pages,
    max(rs.session_rating) - min(rs.session_rating) as rating_spread,
    round(sum(if(rs.session_rating<= 2 or rs.session_rating>=4,1,0))/count(*),2) as polarization_score
from books b
join reading_sessions rs on rs.book_id = b.book_id
group by 1,2,3,4,5
having min(rs.session_rating) <= 2 and
max(rs.session_rating) >= 4 and 
count(*) >= 5 and
polarization_score >= 0.6
order by polarization_score desc,b.title desc;