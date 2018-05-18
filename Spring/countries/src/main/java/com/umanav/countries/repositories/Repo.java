package com.umanav.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umanav.countries.models.Country;

@Repository
public interface Repo extends CrudRepository<Country, Long>{
    
    @Query("SELECT d.name,l.language,l.percentage FROM Country d JOIN d.languages l WHERE l.language = 'Slovene'")
    List<Object[]> first();
    
    @Query("SELECT c.name, COUNT(ci) FROM Country c JOIN c.cities ci GROUP BY c.name ORDER BY COUNT(ci) DESC")
    List<Object[]> CitiesByCountry();
    
    @Query("SELECT ci.name, ci.population FROM City ci WHERE Country_code = 'MEX' AND ci.population>500000")
    List<Object[]> CitiesMexicoGreater();
    
    @Query("SELECT c.name FROM Country c WHERE c.surfaceArea<501 AND c.population>100000")
    List<String> CountriesSAbelowAndPopulationGreater();
    
    @Query("SELECT c.name FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.surfaceArea > 200 AND c.lifeExpectancy > 75")
	List<String> countriesConstitutionalMonarchy();
	
	@Query("SELECT c.name, city.name, city.district, city.population FROM Country c JOIN c.cities city WHERE c.name = 'Argentina' AND city.district = 'Buenos Aires' AND city.population > 500000")
	List<Object[]> citiesArgentina();
	
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> countriesPerRegion();
    
}