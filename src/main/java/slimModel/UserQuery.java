package slimModel;

public class UserQuery {
    private String name;
    private String ID;
    private String province;
    private String city;
    private String gender;

    public UserQuery() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }
}
