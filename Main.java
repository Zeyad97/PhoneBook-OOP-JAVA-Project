//OOP 12TH PROJECTS ---- GROUP 1 (ZEYAD-ALIYAH-MOHANED-FARAH-AHMED-SHAWKY)

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private int phoneNumber;
    private String email;
    private String address;

    public Contact(String name, int phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber + " - " + email + " - " + address;
    }
}

class FriendContact extends Contact {
    private String birthday;

    public FriendContact(String name, int phoneNumber, String email, String address, String birthday) {
        super(name, phoneNumber, email, address);
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return super.toString() + " - Birthday: " + birthday;
    }
}

class WorkContact extends Contact {
    private String jobTitle;

    public WorkContact(String name, int phoneNumber, String email, String address, String jobTitle) {
        super(name, phoneNumber, email, address);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return super.toString() + " - Job Title: " + jobTitle;
    }
}

class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void viewContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void updateContact(String name, int phoneNumber, String email, String address) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                contact.setAddress(address);
                break;
            }
        }
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public void searchContact(String keyword) {
        for (Contact contact : contacts) {
            if (contact.getName().contains(keyword) ||
                    String.valueOf(contact.getPhoneNumber()).contains(keyword) ||
                    contact.getEmail().contains(keyword) ||
                    contact.getAddress().contains(keyword)) {
                System.out.println(contact);
            }
        }
    }

    public void sortContacts() {
        contacts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        System.out.println("Contacts sorted by name.");
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter type (1: Contact, 2: Friend, 3: Work): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    int phoneNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    if (type == 1) {
                        contactManager.addContact(new Contact(name, phoneNumber, email, address));
                    } else if (type == 2) {
                        System.out.print("Enter birthday: ");
                        String birthday = scanner.nextLine();
                        contactManager.addContact(new FriendContact(name, phoneNumber, email, address, birthday));
                    } else if (type == 3) {
                        System.out.print("Enter job title: ");
                        String jobTitle = scanner.nextLine();
                        contactManager.addContact(new WorkContact(name, phoneNumber, email, address, jobTitle));
                    }
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter name of contact to update: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    phoneNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    address = scanner.nextLine();
                    contactManager.updateContact(name, phoneNumber, email, address);
                    break;
                case 4:
                    System.out.print("Enter name of contact to delete: ");
                    name = scanner.nextLine();
                    contactManager.deleteContact(name);
                    break;
                case 5:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    contactManager.searchContact(keyword);
                    break;
                case 6:
                    contactManager.sortContacts();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
