public class Company  {
    private String code; // Unique identifier for the company
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
    public String toString() {
        // Provides a string representation of the course, including all its attributes
        return "Company [" + code + " " + name + " " + location + "]";
    }
}
