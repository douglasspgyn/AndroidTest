package douglasspgyn.com.github.androidtest.model;

import java.io.Serializable;

/**
 * Created by Douglas on 29/03/17.
 */

public class Contact implements Serializable {

    private long id;
    private String name;
    private String phone;

    public Contact(long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
