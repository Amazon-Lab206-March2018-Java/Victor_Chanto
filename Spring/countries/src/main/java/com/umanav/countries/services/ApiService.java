package com.umanav.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umanav.countries.repositories.Repo;

@Service
public class ApiService {
    private final Repo repo;
    public ApiService(Repo repo) {
        this.repo=repo;
    }
    
    public void test() {
//        List<Object[]> firstTable = repo.first();
//        for(Object[] row : firstTable) {
//            System.out.println(row[0]);
//            System.out.println(row[1]);
//            System.out.println(row[2]);
//            System.out.println("");
//        }
//        List<Object[]> secondTable = repo.CitiesByCountry();
//        for(Object[] row : secondTable) {
//        	System.out.println(row[0]);
//            System.out.println(row[1]);
//            System.out.println("");
//        }
//	      List<Object[]> thirdTable = repo.CitiesMexicoGreater();
//	      for(Object[] row : thirdTable) {
//	    	  System.out.println(row[0]);
//	          System.out.println(row[1]);
//	          System.out.println("");
//	      }
//		  List<Object[]> fourthTable = repo.LanguagesPerCountry();
//		  for(Object[] row : fourthTable) {
//			  System.out.println(row[0]);
//		      System.out.println(row[1]);
//		      System.out.println(row[2]);
//		      System.out.println("");
//		    }
//		  for(String row : repo.CountriesSAbelowAndPopulationGreater()) {
//			  System.out.println(row);
//		      System.out.println("");
//		    }
//		  for(String row : repo.countriesConstitutionalMonarchy()) {
//				 System.out.println(row);
//				 System.out.println("");
//			}
//			List<Object[]> table = repo.citiesArgentina();
//			for(Object[] row : table) {
//				System.out.println(row[0]);
//				System.out.println(row[1]);
//				System.out.println(row[3]);
//			    System.out.println("");
//			}
//			
			List<Object[]> table = repo.countriesPerRegion();
			for(Object[] row : table) {
				System.out.println(row[0]);
				System.out.println(row[1]);
			    System.out.println("");
			}
    }
    
}
