package vn.topica.itlab4.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Students {
	static String format = "dd/MM/yyyy";
	static SimpleDateFormat df = new SimpleDateFormat(format);
	private static final AtomicInteger count = new AtomicInteger(0);

	int id;
	String name;
	int yearBorn;
	Boolean gender;
	Date dateStudy;
	boolean status;

	public Students(String name, int yearBorn, Boolean gender, Date dateStudy) {
		super();
		this.id = count.incrementAndGet();
		this.name = name;
		this.yearBorn = yearBorn;
		this.gender = gender;
		this.dateStudy = dateStudy;
		this.status=true;
	}

	public Students(String name, int yearBorn, Boolean gender, String dateStudy) {
		super();
		this.id = count.incrementAndGet();
		this.name = name;
		this.yearBorn = yearBorn;
		this.gender = gender;
		this.status=true;
		try {
			this.dateStudy = df.parse(dateStudy);
		} catch (ParseException e) {
			this.dateStudy = new Date();
		}
	}
	
	public Students() {
		id = count.incrementAndGet();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}



	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getDateStudy() {
		return dateStudy;
	}

	public void setDateStudy(Date dateStudy) {
		this.dateStudy = dateStudy;
	}

	public void setDateStudy(String dateStudy) {
		try {
			this.dateStudy = df.parse(dateStudy);
		} catch (ParseException e) {
			this.dateStudy = new Date();
		}
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", yearBorn=" + yearBorn + 
				", gender=" + gender + ", dateStudy=" + df.format(this.dateStudy) + "]";
	}
	
}
