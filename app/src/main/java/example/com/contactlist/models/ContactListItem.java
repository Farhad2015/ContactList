package example.com.contactlist.models;

/**
 * Created by Farhad on 3/30/17.
 */

public class ContactListItem {
    String ContactPersonName;
    String ContactNumber;

    public String getContactPersonName() {
        return ContactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        ContactPersonName = contactPersonName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }
}
