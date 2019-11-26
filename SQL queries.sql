SQL query 1

SELECT Name 
FROM XF.Country
join (SELECT SUM(Population), CountryID
	  FROM XF.City
	  GROUP BY CountryID
	  HAVING SUM(Population) > 400) AS CountriesOver400 
	  ON CountriesOver400.CountryID = XF.Country.CountryID


SQL query 2
	  
SELECT Name
FROM XF.Country
WHERE XF.Country.CountryID
NOT IN (
	SELECT DISTINCT CountryID 
	From XF.City
	JOIN XF.Building ON XF.City.CityID = XF.Building.CityID
)