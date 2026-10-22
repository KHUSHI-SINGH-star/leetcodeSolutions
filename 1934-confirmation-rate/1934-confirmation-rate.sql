# Write your MySQL query statement below
select Signups.user_id , Round(avg( CASE
               WHEN Confirmations.action = 'confirmed' THEN 1.00
               ELSE 0.00
           END), 2)as confirmation_rate
from Signups
left join Confirmations
on Signups.user_id= Confirmations.user_id
group by Signups.user_id
