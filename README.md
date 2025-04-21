Phonebook Management System

A simple Phonebook Management System developed in Java using Object-Oriented Programming (OOP) principles. The system allows users to manage their contacts by adding, updating, deleting, searching, and sorting them. It supports three types of contacts: basic Contact, FriendContact (with birthday), and WorkContact (with job title).

Features
Add, update, delete, and view contacts.

Search contacts by name, phone number, email, or address.

Sort contacts alphabetically by name.

Support for FriendContact and WorkContact types with additional attributes like birthday and job title.

Technologies Used
Java: The core programming language.

Object-Oriented Programming (OOP): Classes, Inheritance, Polymorphism, and Encapsulation.

How to Run the Project
Clone or download this repository.

Open the project in an IDE like IntelliJ IDEA or Eclipse.

Run the Main.java file to start the phonebook application.

Use the menu to add, view, update, delete, or search contacts.

File Structure
bash
نسخ
تحرير
Phonebook/
├── Contact.java          # Class for basic contact.
├── FriendContact.java    # Class for friend contact (extends Contact).
├── WorkContact.java      # Class for work contact (extends Contact).
├── ContactManager.java   # Class to manage the list of contacts.
└── Main.java             # Main class to run the application.
How to Contribute
Fork the repository.

Create a new branch (git checkout -b feature/your-feature).

Make your changes.

Commit your changes (git commit -am 'Add new feature').

Push to the branch (git push origin feature/your-feature).

Create a pull request.
