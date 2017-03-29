package douglasspgyn.com.github.androidtest.contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Douglas on 29/03/17.
 */

public class ContactMock {

    private static List<Contact> contacts;

    public static List<Contact> getContacts() {
        if (contacts == null) {
            setContacts();
        }

        return contacts;
    }

    private static List<Contact> getMockContacts() {
        List<Contact> contacts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            contacts.add(new Contact(i, "Contact " + i, "123456789"));
        }

        return contacts;
    }

    public static void addContact(Contact contact) {
        if (contacts == null) {
            setContacts();
        }

        contacts.add(contact);
    }

    public static void updateContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == contact.getId()) {
                contacts.set(i, contact);
            }
        }
    }

    public static void removeContact(Contact contact) {
        if (contacts != null && contact != null) {
            contacts.remove(contact);
        }
    }

    private static void setContacts() {
        contacts = new ArrayList<>();
        contacts.addAll(getMockContacts());
    }
}
