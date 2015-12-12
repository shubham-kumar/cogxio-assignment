package com.cogxio.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cogxio.entity.Place;
import com.cogxio.model.PlacesRecordDAO;

public class PlacesFacade {

	PlacesRecordDAO prDao = null;
	List<Place> listPlaces = null;

	public String getTotalPlaces() {
		String totalPlace = "";
		try{
			prDao = new PlacesRecordDAO();
			totalPlace = prDao.getTotalPlaceCount();
		}catch(SQLException | ClassNotFoundException e){
		}
		return totalPlace;
	}

	public List<Place> getAllPlaces() {
		listPlaces = new ArrayList<Place>();
		try{
			prDao = new PlacesRecordDAO();
			listPlaces = prDao.getAllPlaces();
		}catch(SQLException | ClassNotFoundException e){
		}
		return listPlaces;
	}

	public List<Place> getPlaceByNameCategory(String searchData) {
		listPlaces = new ArrayList<Place>();
		try{
			prDao = new PlacesRecordDAO();
			listPlaces = prDao.getPlaceByNameCategory(searchData);
		}catch(SQLException | ClassNotFoundException e){
			System.out.println(e);
		}
		return listPlaces;
	}

	public List<Place> getAllNameCategory() {
		listPlaces = new ArrayList<Place>();
		try{
			prDao = new PlacesRecordDAO();
			listPlaces = prDao.getAllNameCategory();
		}catch(SQLException | ClassNotFoundException e){
		}
		return listPlaces;
	}
}
