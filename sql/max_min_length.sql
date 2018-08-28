SELECT city, length(city) 
FROM ( 
(select city, length(city) as max from station order by max desc limit 1)
UNION
(select city, length(city) as min from station order by min, city asc limit 1)
) station;           

                         