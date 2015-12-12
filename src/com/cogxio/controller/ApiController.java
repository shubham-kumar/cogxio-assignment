package com.cogxio.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cogxio.services.PlacesFacade;

@RequestMapping("/api")
@Controller
public class ApiController {

	@RequestMapping(path="/GetTotalPlace",headers="Accept=application/json")
	public @ResponseBody String getTotalPlace() {
		PlacesFacade placeFacade = new PlacesFacade();
		String totalPlaces = "{\"total_places\":\""+placeFacade.getTotalPlaces()+"\"}";
		return totalPlaces;
	}
	
	@RequestMapping(path="/GetAllPlaces",headers="Accept=application/json")
	public @ResponseBody String getData() throws JsonGenerationException, JsonMappingException, IOException {
		PlacesFacade placeFacade = new PlacesFacade();
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(placeFacade.getAllPlaces());
		return jsonInString;
	}
	
	@RequestMapping(path="/AllNameCategory",headers="Accept=application/json")
	public @ResponseBody String getAllNameCategory() throws JsonGenerationException, JsonMappingException, IOException {
		PlacesFacade placeFacade = new PlacesFacade();
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(placeFacade.getAllNameCategory());
		return jsonInString;
	}
	
	@RequestMapping(path="/PlaceByNameCategory/{searchData}",headers="Accept=application/json")
	public @ResponseBody String getPlaceByNameCategory(@PathVariable String searchData) throws JsonGenerationException, JsonMappingException, IOException {
		PlacesFacade placeFacade = new PlacesFacade();
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(placeFacade.getPlaceByNameCategory(searchData));
		return jsonInString;
	}
}
