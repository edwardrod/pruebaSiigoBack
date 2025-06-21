package co.com.siigo.automation.models;

public class UserData {
    private String name;
    private String job;
    private String id;

    public UserData() {}

    public UserData(String name, String job, String id) {
        this.name = name;
        this.job = job;
        this.id = id;
    }

    // Getters y setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
