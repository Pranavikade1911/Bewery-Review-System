package com.example.demo.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// Import other necessary dependencies
import com.example.demo.models.Brewery;
import com.example.demo.repository.BreweryRepository;

@Service
public class BreweryService {
     private final String API_BASE_URL = "https://api.openbrewerydb.org/breweries";

     public List<Brewery> searchBreweries(String city, String name, String type) {
          // Build the URL based on search criteria
          StringBuilder apiUrl = new StringBuilder(API_BASE_URL + "?");
          if (city != null && !city.isEmpty()) {
               apiUrl.append("by_city=").append(city).append("&");
          }
          if (name != null && !name.isEmpty()) {
               apiUrl.append("by_name=").append(name).append("&");
          }
          if (type != null && !type.isEmpty()) {
               apiUrl.append("by_type=").append(type);
          }

          // Make a request to the Open Brewery DB API
          ResponseEntity<Brewery[]> responseEntity = new RestTemplate().getForEntity(apiUrl.toString(),
                    Brewery[].class);
          Brewery[] breweries = responseEntity.getBody();

          if (breweries != null) {
               return Arrays.asList(breweries);
          } else {
               return Collections.emptyList();
          }
     }

     @Autowired
     private BreweryRepository breweryRepository;

     public Brewery getBreweryById(Long id) {
          return breweryRepository.findById(id).orElse(null);
     }

     public void saveBrewery(Brewery brewery) {
          breweryRepository.save(brewery);
     }
}
