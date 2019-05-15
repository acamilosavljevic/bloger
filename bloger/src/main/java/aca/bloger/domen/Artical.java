package aca.bloger.domen;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Artical {

	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	private String content;
	private LocalDateTime created;
	@ElementCollection
	private Set<String> keywords;
	private int ratingCounter;
	private double averageCounter;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="artical")
	private Set<Rating> ratings;
	
	@OneToMany(mappedBy="artical")
	private Set<Comment> comments;
	
	@ManyToMany(mappedBy="artical")
	private Set<Tag> tags;
	
	public Artical() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Set<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}

	public int getRatingCounter() {
		return ratingCounter;
	}

	public void setRatingCounter(int ratingCounter) {
		this.ratingCounter = ratingCounter;
	}

	public double getAverageCounter() {
		return averageCounter;
	}

	public void setAverageCounter(double averageCounter) {
		this.averageCounter = averageCounter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
	
}
