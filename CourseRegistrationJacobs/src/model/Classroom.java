package model;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 27, 2023  
*/
public class Classroom {
	private String building;
	private String roomNumber;
	private String campus;
	private String type;
	private int capacity;
	
	
	public Classroom() {}
	
	public Classroom(String building, String roomNumber, String campus, String type, int capacity) {
		this.setBuilding(building);
		this.setRoomNumber(roomNumber);
		this.setCampus(campus);
		this.setType(type);
		this.setCapacity(capacity);
		
		
	}
	
	
	

	@Override
	public String toString() {
		return "Classroom [building=" + building + ", roomNumber=" + roomNumber + ", campus=" + campus + ", type="
				+ type + ", capacity=" + capacity + "]";
	}

	public String toString(String name) {
		return name + "\nBuilding: " + building + 
				"\nRoom Number: " + roomNumber + 
				"\nCampus: " + campus + 
				"\nType: "+ type + 
				"\nCapacity: " + capacity + "\n";
	}
	
	
	
	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}
	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * @return the campus
	 */
	public String getCampus() {
		return campus;
	}
	/**
	 * @param campus the campus to set
	 */
	public void setCampus(String campus) {
		this.campus = campus;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
