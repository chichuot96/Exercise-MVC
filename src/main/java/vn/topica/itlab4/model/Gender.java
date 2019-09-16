package vn.topica.itlab4.model;

public enum Gender {
	Male (0),
	Female (1),
	Other (2);
	 private final int genderCode;

    private Gender(int genderCode) {
        this.genderCode = genderCode;
    }

	public int getGenderCode() {
		return genderCode;
	}
}
