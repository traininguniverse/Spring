package com.spring.form01.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Person {

	@NotNull
	@Size(min = 2, max = 30)
	private String name = "";

	@NotNull
	@Min(1900)
	@Max(2020)
	private int yob = 0;

	private String gender = "";
	private String body = "";
	private String[] hobby;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday = null;

	public Person() {
		super();
	}

	public Person(String name, int yob, String gender, String body, String[] hobby, Date birthday) {
		super();
		this.name = name;
		this.yob = yob;
		this.gender = gender;
		this.body = body;
		this.hobby = hobby;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	private String miesiac(int i) {
		String[] tab = { "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień",
				"Październik", "Listopad", "Grudzień" };
		return tab[--i];
	}

	public String getBirthdayS() {
		LocalDate localDate = this.birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();

		return year + " " + miesiac(month) + " " + day;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
