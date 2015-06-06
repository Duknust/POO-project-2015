package caches;

import base.Position;

// Represents a Stage
public class Stage extends Position {

	private String description = "";
	private int index;

	public Stage(double lati, double longi, String description, int index) {
		super(lati, longi);
		this.description = description;
		this.index = index;
	}

	// Regular User Display

	@Override
	public String toString() {
		return "Stage " + this.index + "\nDescription:" + this.description
				+ "\n\n";
	}

	// Only Reviewer or Admin can see the Coordinates
	public String toStringFull() {
		return "Stage " + this.index + "\n Coordinates: " + super.getCoords()
				+ "\nDescription:" + this.description + "\n\n";
	}
	
	public void setDescription(String newDescription){
		this.description = newDescription;
	}
}
