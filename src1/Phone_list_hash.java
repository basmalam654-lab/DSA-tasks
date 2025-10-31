import java.util.Scanner;

public class Phone_list_hash {

    public static void main(String[] args) {
        Hash_Table hashTable = new Hash_Table();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        String name, phoneNumber;


        while (choice != 6) {
            System.out.println("\nWelcome To Your Phone Contact Book:\n");
            System.out.println("1. Insert Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter name: ");
                    name = input.nextLine();
                    System.out.print("Enter phone number: ");
                    phoneNumber = input.nextLine();
                    hashTable.insert(name, phoneNumber);
                    System.out.println("Contact inserted successfully!");
                    break;

                case 2: // Update
                    System.out.print("Enter name to update: ");
                    name = input.nextLine();
                    System.out.print("Enter new phone number: ");
                    phoneNumber = input.nextLine();
                    hashTable.update(name, phoneNumber);
                    break;

                case 3: // Delete
                    System.out.print("Enter name to delete: ");
                    name = input.nextLine();
                    hashTable.delete(name);
                    break;

                case 4: // Search
                    System.out.print("Enter name to search: ");
                    name = input.nextLine();
                    String result = hashTable.search(name);
                    if (result != null && !result.isEmpty()) {
                        System.out.println("Phone number: " + result);
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;

                case 5: // Display
                    hashTable.display();
                    break;

                case 6: // Exit
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }
    }
}