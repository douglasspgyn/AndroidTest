package douglasspgyn.com.github.androidtest.contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Douglas on 29/03/17.
 */

public class Contact {

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
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

    public static List<Contact> getMockContacts() {
        List<Contact> contacts = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            contacts.add(new Contact("Contact " + i, "(" + i + ") 12345-6789"));
        }

        return contacts;
    }
}
