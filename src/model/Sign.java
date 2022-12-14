package model;

import java.util.Date;

public class Sign {

	private String name;
	private String imageURL;
	private String stones;
	
	private Date rangeDateBeg;
	private Date rangeDateEnd;
	
	public Sign(String name, String imageURL, String stones, Date rangeDateBeg, Date rangeDateEnd) {
		this.name = name;
		this.imageURL = imageURL;
		this.stones = stones;
		this.rangeDateBeg = rangeDateBeg;
		this.rangeDateEnd = rangeDateEnd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getStones() {
		return stones;
	}

	public void setStones(String stones) {
		this.stones = stones;
	}

	public Date getRangeDateBeg() {
		return rangeDateBeg;
	}

	public void setRangeDateBeg(Date rangeDateBeg) {
		this.rangeDateBeg = rangeDateBeg;
	}

	public Date getRangeDateEnd() {
		return rangeDateEnd;
	}

	public void setRangeDateEnd(Date rangeDateEnd) {
		this.rangeDateEnd = rangeDateEnd;
	}
}
