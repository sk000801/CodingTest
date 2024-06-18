select ID, EMAIL, FIRST_NAME, LAST_NAME
from developers 
where skill_code & (
    select sum(code) 
    from skillcodes 
    where CATEGORY = 'Front End'
    group by CATEGORY 
)
order by id