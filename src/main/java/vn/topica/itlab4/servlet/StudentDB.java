package vn.topica.itlab4.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import vn.topica.itlab4.model.Students;

public class StudentDB {
	public static Map<Integer, Students> mapStudents = new HashMap<>();
	
	public static ArrayList<Students> getListStudents() {
		ArrayList<Students> list = new ArrayList<Students>();
		for(Students s: mapStudents.values()) {
			if(s.isStatus()) {
				list.add(s);
			}
		}
		return list;
	}

	public static void updateDB(int id,String name,int birthYear,Boolean gender,String dateStart) {
		mapStudents.get(id).setName(name);
		mapStudents.get(id).setYearBorn(birthYear);
		mapStudents.get(id).setGender(gender);
		mapStudents.get(id).setDateStudy(dateStart);
	}
	public static void updateDB(int id,String name,int birthYear,Boolean gender,Date dateStart) {
		mapStudents.get(id).setName(name);
		mapStudents.get(id).setYearBorn(birthYear);
		mapStudents.get(id).setGender(gender);
		mapStudents.get(id).setDateStudy(dateStart);
	}
	public static void deleteDB(int id) {
		mapStudents.get(id).setStatus(false);
	}
	public static void createDB() {
		for(int i=0;i<10;i++) {
			Students s=new Students("chi nguyen",1996,true,"28/12/1996");
			mapStudents.put(s.getId(), s);
		}
	}
	public static void addStudent(Students s) {
		mapStudents.put(s.getId(), s);
	}
	public static ArrayList<Students> searchStudent(String name) {
		ArrayList<Students> list=new ArrayList<Students>();
		
		for(Students s: getListStudents()) {
			String temp[] = s.getName().split(" ");
			for(int i=0;i<temp.length;i++) {
				if(temp[i].equalsIgnoreCase(name)) {
					list.add(s);
					continue;
				}
			}
		}
		return list;
	}
}
