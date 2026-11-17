# Write your MySQL query statement below
select w1.id
from Weather w1
where w1.temperature >(select temperature 
from weather w2 
where DATEDIFF(w1.recordDate, w2.recordDate) = 1
);
