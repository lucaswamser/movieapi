package br.com.lucaswamser.moviesapi.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(indexes = @Index(columnList = "title"))

public class Movie {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int year;
	
	private String title;
	private String studios;
	@ElementCollection
	@OrderColumn(name="producersIds")
	
	private String[] producers;
	private Boolean winner;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStudios() {
		return studios;
	}
	public void setStudios(String studios) {
		this.studios = studios;
	}
	public String[] getProducers() {
		return producers;
	}
	public void setProducers(String[] producers) {
		this.producers = producers;
	}
	public Boolean getWinner() {
		return winner;
	}
	public void setWinner(Boolean winner) {
		this.winner = winner;
	}
	public Movie(Long id, int year, String title, String studios, String[] producers, Boolean winner) {
		super();
		this.id = id;
		this.year = year;
		this.title = title;
		this.studios = studios;
		this.producers = producers;
		this.winner = winner;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String csvLine) {
		String[] list = csvLine.split(";");
		this.year =  Integer.parseInt(list[0]);
		this.title = list[1];
		this.studios = list[2];
		this.producers = list[3].replace(" and ",", ").split(", ");
		this.winner = false;
	    if (list.length == 5) {
	    	this.winner = list[4].equals("yes");
	    }
	    
	    
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", year=" + year + ", title=" + title + ", studios=" + studios + ", producers="
				+ producers + ", winner=" + winner + "]";
	}
	
	
	
	
	

}
