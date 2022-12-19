package model;

import java.io.Serializable;

public class Cristal implements Serializable {
	
	/**
	 * Idk the function of that shit.
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String imageURL;
	private String signs;
	
	public Cristal(String name, String description, String imageURL, String signs) {
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
		this.signs = signs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSigns() {
		return signs;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}
}
