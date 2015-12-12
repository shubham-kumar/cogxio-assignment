package com.cogxio.helper;

public class SQLQuery {
	private String getTotalPlaceCount = "SELECT COUNT(*) totalCount FROM cogxio.places;";
	private String getAllPlace = "SELECT * FROM cogxio.places";
	private String getPlaceByNameCategory = "SELECT * FROM cogxio.places where name=? OR category=?";
	private String getAllNameCategory = "SELECT name,category FROM cogxio.places";
	
	/**
	 * @return the getTotalPlaceCount
	 */
	public final String getGetTotalPlaceCount() {
		return getTotalPlaceCount;
	}
	
	/**
	 * @return the getAllPlace
	 */
	public final String getGetAllPlace() {
		return getAllPlace;
	}
	
	/**
	 * @return the getPlaceByNameCategory
	 */
	public final String getGetPlaceByNameCategory() {
		return getPlaceByNameCategory;
	}
	
	/**
	 * @return the getAllNameCategory
	 */
	public final String getGetAllNameCategory() {
		return getAllNameCategory;
	}
	
	
}
