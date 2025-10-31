public class Hash_Table {


    private Contact[] table; // Array to store the hash table
    private int tableSize = 1009; // Size of the hash table (prime number for better hash distribution)
    private int size=0;
    private String deletedMarker = "DELETED"; // Marker to indicate a deleted entry

    // Constructor to initialize the hash table
    public Hash_Table() {
        table = new Contact[tableSize];
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == tableSize;
    }
    // Hash function to compute an index for a given key (name)
    private long calcHash(String key,int table_size) {
        /*
        Spreads Keys Uniformly:

            By combining left shifts, XOR, and modulo operations, it ensures keys are well-distributed across the hash table.
            Example: Even small changes in the input string ("abc" vs. "abcd") result in large differences in the hash index.
            Minimizes Collisions:

            Its operations produce distinct hash values for most inputs, reducing the chances of two keys mapping to the same index.
            Handles
         Larger Tables:
                The mixed bitwise operations allow the function to generate unique values even for large datasets.
        */
        int l = key.length();
        long hash = 0;
        for (int i = 0; i < l; i++) {
            hash += Character.getNumericValue(key.charAt(i)); // Add numeric value of each character
            hash += (hash << 10); // Shift hash left by 10 and add to itself
            hash ^= (hash >> 6);  // XOR hash with itself shifted right by 6
        }
        hash += (hash << 3); // Shift hash left by 3 and add to itself
        hash ^= (hash >> 11); // XOR hash with itself shifted right by 11
        hash += (hash << 15); // Shift hash left by 15 and add to itself

        if ( hash > 0) return hash % table_size;
        else return -hash % table_size;// Ensure positive hash index
    }

    // Method to insert a new contact or update an existing contact's phone number
    public void insert(String name, String phoneNumber) {
        if(isFull()) {
            System.out.println("Hash table is full");
            return ;
        }
        else {
            long index = calcHash(name,tableSize); // Compute hash index
            int originalIndex = (int) index; // Store original index for probing
            int i = 0;

            // Use linear probing to find an empty slot or the existing key
            while (table[(int) index] != null && (table[(int) index].name != null && !table[(int) index].name.equals(name))) {
                index = (originalIndex + ++i) % tableSize; // Move to next slot in the table
            }

            // Insert or update the contact at the found index
            table[(int) index] = new Contact(name, phoneNumber);
            size++;
        }
    }

    // Method to search for a contact by name and return their phone number
    public String search(String name) {
        if(isEmpty()){
            System.out.println("Hash table is empty");
            return "";
        }
        long index = calcHash(name,tableSize); // Compute hash index
        int originalIndex = (int) index; // Store original index for probing
        int i = 0;

        // Use linear probing to find the key
        while (table[(int) index] != null) {
            if (table[(int) index].name != null && table[(int) index].name.equals(name)) {
                return table[(int) index].phoneNumber; // Return phone number if found
            }
            index = (originalIndex + ++i) % tableSize; // Move to next slot
        }
        return null; // Return null if not found
    }

    // Method to delete a contact by name
    public void delete(String name) {
        if (isEmpty()) {
            System.out.println("Hash table is empty");
            return ;
        }
        long index = calcHash(name,tableSize); // Compute hash index
        int originalIndex = (int) index; // Store original index for probing
        int i = 0;

        // Use linear probing to find the key
        while (table[(int) index] != null) {
            if (table[(int) index].name != null && table[(int) index].name.equals(name)) {
                // Mark the entry as deleted
                table[(int) index].name = deletedMarker;
                table[(int) index].phoneNumber = null;
                size--;
                return;
            }
            index = (originalIndex + ++i) % tableSize; // Move to next slot
        }
        System.out.println("The name: " + name + " does not exist");

    }

    // Method to update a contact's phone number
    public void update(String name, String newPhoneNumber) {
        if (isEmpty()) {
            System.out.println("Hash table is empty");
            return ;
        }
        if (search(name)==null) {
            System.out.println("The name: " + name + " does not exist");
            return ;
        }
        insert(name, newPhoneNumber); // Reuse insert method to update
    }

    // Method to display all contacts in the hash table
    public void display() {
        if (isEmpty()) {
            System.out.println("Hash table is empty");
            return ;
        }
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null && table[i].name != null && !table[i].name.equals(deletedMarker)) {
                // Display only valid (non-deleted) entries
                System.out.println("Index " + i + ": Name = " + table[i].name + ", Phone = " + table[i].phoneNumber);
            }
        }
    }

}
