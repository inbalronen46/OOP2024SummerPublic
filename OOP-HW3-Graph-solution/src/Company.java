public class Company  implements Comparable<Company>{
    private String code; // Unique identifier for the course
    private String name;
    private String location;
    

    public Company(String code, String name, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public int compareTo(Company o) {
		return code.compareTo(o.code);
	}


    @Override
    public String toString() {
        // Provides a string representation of the course, including all its attributes
        return "Company [" + code + " " + name + " " + location + "]";
    }
}
