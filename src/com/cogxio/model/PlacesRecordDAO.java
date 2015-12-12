package com.cogxio.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cogxio.entity.Place;
import com.cogxio.helper.DatabaseUtil;
import com.cogxio.helper.SQLQuery;

public class PlacesRecordDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	DatabaseUtil bdUtil = null;
	SQLQuery sqlQuery = new SQLQuery();

	public String getTotalPlaceCount() throws SQLException,ClassNotFoundException{
		String result = "";
		bdUtil = new DatabaseUtil();
		con = bdUtil.setConnection();
		pstmt = con.prepareStatement(sqlQuery.getGetTotalPlaceCount());
		rs = pstmt.executeQuery();
		if(rs.next())
			result = rs.getString("totalCount");
		bdUtil.closeConnection();
		return result;
	}

	public List<Place> getAllPlaces() throws SQLException,ClassNotFoundException {
		ArrayList<Place> alistPlaces = new ArrayList<Place>();
		Place place;
		bdUtil = new DatabaseUtil();
		con = bdUtil.setConnection();
		pstmt = con.prepareStatement(sqlQuery.getGetAllPlace());
		rs = pstmt.executeQuery();
		while(rs.next()){
			place = new Place();
			place.setId(rs.getInt("id"));
			place.setName(rs.getString("name"));
			place.setCategory(rs.getString("category"));
			place.setRating(rs.getString("rating"));
			place.setLatitude(rs.getString("latitude"));
			place.setLongitude(rs.getString("longitude"));
			alistPlaces.add(place);
		}			
		bdUtil.closeConnection();
		return alistPlaces;
	}

	public List<Place> getPlaceByNameCategory(String searchData) throws SQLException, ClassNotFoundException {
		ArrayList<Place> alistPlaces = new ArrayList<Place>();
		Place place;
		bdUtil = new DatabaseUtil();
		con = bdUtil.setConnection();
		pstmt = con.prepareStatement(sqlQuery.getGetPlaceByNameCategory());
		pstmt.setString(1, searchData);
		pstmt.setString(2, searchData);
		rs = pstmt.executeQuery();
		while(rs.next()){
			place = new Place();
			place.setId(rs.getInt("id"));
			place.setName(rs.getString("name"));
			place.setCategory(rs.getString("category"));
			place.setRating(rs.getString("rating"));
			place.setLatitude(rs.getString("latitude"));
			place.setLongitude(rs.getString("longitude"));
			alistPlaces.add(place);
		}			
		bdUtil.closeConnection();
		return alistPlaces;
	}

	public List<Place> getAllNameCategory() throws SQLException, ClassNotFoundException {
		ArrayList<Place> alistPlaces = new ArrayList<Place>();
		Place place;
		bdUtil = new DatabaseUtil();
		con = bdUtil.setConnection();
		pstmt = con.prepareStatement(sqlQuery.getGetAllNameCategory());
		rs = pstmt.executeQuery();
		while(rs.next()){
			place = new Place();
			place.setName(rs.getString("name"));
			place.setCategory(rs.getString("category"));
			alistPlaces.add(place);
		}			
		bdUtil.closeConnection();
		return alistPlaces;
	}
}
