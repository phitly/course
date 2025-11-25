import java.util.HashMap;
    //what is the purpose of this abstract class?
    //// Answer: The purpose of this abstract class is to provide 
    // a common structure and behavior for different types of items in a library system, such as books and DVDs.
    //  It defines shared attributes and methods that all items should have, while allowing subclasses to implement specific details.
abstract class Item{
    private String id;
    private String title;
    private boolean available=true;
    // constructor
    public Item(String id, String title){
        this.id=id;
        this.title=title;
    }
    // getters and setters
        // no setter for id and title as they should not be changed once set
        // only getter for available as its status can be changed using specific methods
        // methods to mark item as borrowed or returned
        //
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean isAvailable(){
        return available;
    }
    public void markAsBorrowed(){
        this.available=false;
        //flip available to false
        //enfocece encapsulation: no direct access to available variable
    }
    public void markAsReturned(){
        this.available=true;
    }

    // class Book that extends Item
    // why is available not passed in constructor of Book?
    //// Answer: The available status is not passed in the constructor of the Book class because it is managed by the Item class.
    //  When a new Book object is created, it is assumed to be available by default (set to true in the Item class).
    //  The availability of the book can then be changed using the markAsBorrowed() and markAsReturned() methods
    class Book extends Item{
        private String author;
        public Book(String id, String title, String author){
            super(id, title);
            this.author=author;
        }
        // getter for author
        public String getAuthor(){
            return author;
        }
    }
    // class Library to manage collection of items
    class Library{

        private HashMap<String, Item> items=new HashMap<>();

        // explain the parameter of addItem method
        // Answer: The parameter of the addItem method is an Item object (newItem).
        //  This allows the method to accept any object that is a subclass of Item (e.g., Book, DVD) and add it to the library's collection.
            // i didnt know you can do that
                // this is called polymorphism in OOP
                // it allows methods to accept objects of different types as long as they share a common superclass or interface
        public void addItem(Item newItem) {
            items.put(newItem.getId(), newItem);
        }
        
        public Item getItem(String id) {
            return null;
        }
        public boolean borrowItem(String id){
            return false;
        }
        public boolean returnItem(String id){
            return false;
        }
    }
}
// what is an invariant class?
// explain simply with an example.
// Answer: An invariant class is a class that maintains certain conditions or properties (invariants)
// that must always be true for its instances throughout their lifetime.
// For example, consider a class representing a bank account.
// An invariant for this class could be that the account balance can never be negative.
// The class would enforce this invariant by ensuring that any operation that modifies the balance
// (like deposits or withdrawals) checks that the balance remains non-negative after the operation. 

// what is the relationship between Item and Book classes and library?
    // Answer: The Book class is a subclass of the Item class, meaning it inherits properties and methods from Item.
    // The Library class manages a collection of Item objects, which can include Book objects as well as other types of items that extend the Item class.
    // This relationship allows the Library to handle different types of items in a unified way through the Item superclass.
        // this is an example of inheritance and polymorphism in OOP
            // inheritance allows Book to inherit from Item
            // polymorphism allows Library to manage different Item types through a common interface
            // so in theory, we can create other classes like DVD that also extend Item and Library can manage them too
        // this exercise demonstrates key OOP concepts like encapsulation, inheritance, and polymorphism.