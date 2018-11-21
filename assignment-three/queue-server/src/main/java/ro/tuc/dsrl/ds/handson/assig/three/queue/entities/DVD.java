package ro.tuc.dsrl.ds.handson.assig.three.queue.entities;

import java.io.Serializable;

public class DVD implements Serializable {

	private static final long serialVersionUID = 3803904518748009103L;

	private String title;
	private int year;
	private double price;

	public DVD() {
		super();
	}

	public DVD(String title, int year, double price) {
		super();
		this.title = title;
		this.year = year;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "DVD [title=" + title + ", year=" + year + ", price=" + price + "]";
	}
}
