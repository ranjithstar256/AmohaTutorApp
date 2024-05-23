package ran.am.amohatutorapp;

public class Tutor {
    private String name;
    private String mobile;
    private String technicalExpertise;
    private String mail;
    private String description;

    public Tutor() {
        // Required empty constructor for Firestore
    }

    public Tutor(String name, String mobile, String technicalExpertise, String mail, String description) {
        this.name = name;
        this.mobile = mobile;
        this.technicalExpertise = technicalExpertise;
        this.mail = mail;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTechnicalExpertise() {
        return technicalExpertise;
    }

    public String getMail() {
        return mail;
    }

    public String getDescription() {
        return description;
    }
}
