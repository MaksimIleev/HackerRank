### distinct cities with
select distinct city from station where mod(id, 2) = 0 group by city

SELECT count(city) - count(distinct city) FROM station