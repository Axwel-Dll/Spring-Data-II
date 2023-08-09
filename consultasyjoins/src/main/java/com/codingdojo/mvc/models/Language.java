package com.codingdojo.mvc.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "CHAR(3)")
	private String country_code;
	
	@Column(columnDefinition = "CHAR(30)")
	private String language;
	
	@Column(columnDefinition = "ENUM('T','F')")
	private String is_offcial;
	
	@Column(columnDefinition = "FLOAT(4,1)")
	private double percentage;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;

	public Language() {
	}

	public Language(int id, String countryCode, String language, String is_offcial, double percentage, Date createdAt,
			Date updatedAt, Country country) {
		this.id = id;
		this.country_code = countryCode;
		this.language = language;
		this.is_offcial = is_offcial;
		this.percentage = percentage;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.country = country;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCode() {
		return country_code;
	}

	public void setCountryCode(String countryCode) {
		this.country_code = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIs_offcial() {
		return is_offcial;
	}

	public void setIs_offcial(String is_offcial) {
		this.is_offcial = is_offcial;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
