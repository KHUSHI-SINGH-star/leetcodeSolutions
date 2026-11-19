# Write your MySQL query statement below
SELECT Person.lastName, Person.firstName ,Address.city, Address.state 
FROM person 
LEFT JOIN address 
ON  Person.personId=Address.personId;