package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;
import com.example.demo.services.CountryService;
import static com.example.demo.controller.ControllerHelper.BASE_URI_V1;

import java.util.List;;

@RequestMapping(path= BASE_URI_V1 + "Countries")
@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	public ResponseEntity<List<Country>> getAllCountries() {
		return countryService.getAllCountries();
	}
	
	@GetMapping("/{CountryId}")
	public ResponseEntity<Country> getCountryById(@PathVariable long CountryId) {
		return countryService.getCountryById(CountryId);
	}

	@PostMapping
	public ResponseEntity<Country> createCountry(@RequestBody Country newCountry){
		return countryService.createCountry(newCountry);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable(value="id")Long id){
		return countryService.deleteCountry(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Country>updateCountry(@PathVariable(value="id")Long id, @Validated @RequestBody Country newCountry){
		return countryService.updateCountry(newCountry, id);
	}
}
