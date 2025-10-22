// Step 1: Create an abstract class Instrument
// This should include:
// - private String name
// - protected int year (year of manufacture)
// - constructor that initializes both fields
// - abstract method play() that returns a String
// - concrete method getInstrumentDetails() that returns information about the instrument
    abstract class Instrument {
        private String name;
        protected int year;     // what is protected means? // accessible within package and subclasses

        public Instrument(String name, int year){
            this.name=name;
            this.year=year;
        }

        // abstract method play
        public abstract String play();
        
        // concrete method 
        public String getInstrumentDetails(){
            return name + year;
        }

        //getter 
        public String getName(){
            return name;
        }
        // why are we not creating getter for year?
        // because year is protected, so it can be accessed directly in subclass
    }
    
// Step 2: Create an interface Tunable
// This should include:
// - abstract method tune() that returns a String
// - abstract method adjustPitch(boolean up) that returns a String (up means increase pitch)

// explain interface : 
        // an interface is a blueprint that defines
        // a set of abstract methods that a class must implement
            // specifies what a class should do not how to do it. 

    public interface Tunable {
        // an abstract method is declared without a body 
            //it only defines method's name, parameters, and return type
            //leaving the implementation to subclasses
        String tune();
        String adjustPitch(boolean up);
                    // This says: any class implementing Tunable 
                    // must define these two methods that both return strings, 
                    // one with no parameters and one with a boolean parameter.     
    }

// Step 3: Create an interface Maintainable
// This should include:
// - abstract method clean() that returns a String
// - abstract method inspect() that returns a String
    public interface Maintainable {
        String clean();
        String inspect();
    }

// Step 4: Create a concrete class StringedInstrument that extends Instrument
// This should include:
// - private int numberOfStrings
// - constructor that initializes name, year, and numberOfStrings
// - implementation of the abstract play() method
// - override getInstrumentDetails() to include number of strings


        // concrete class has complete method difnition and can be instantiated
            // abstract class may contain abstract method and cannot be instantiated directly
        class StringedInstrument extends Instrument{
            private int numberOfStrings;

        public StringedInstrument(String name, int year, int numberOfStrings){
            super(name, year);
            this.numberOfStrings=numberOfStrings;
        }
        
        // override is when a subclass provides a new version of a method
            // already defined in its parent class, same name, parameters, return type
                // it replaces the parent's behavior with its own implementation for that method
                    // bc we already have play method in abstract class Instrument
                        // but we want to provide specific implementation for play()  for StringedInstrument
        @Override
        public String play(){
            return "playing the stringed instrument";
        }

        @Override
        public String getInstrumentDetails(){
            return super.getInstrumentDetails()+ ", Strings: " +numberOfStrings;
        }

        //getter for num of strings
        public int getNumberOfStrings(){
            return numberOfStrings;
        }
    }

// Step 5: Create a concrete class Guitar that extends StringedInstrument 
// and implements Tunable and Maintainable
// This should include:
// - private String guitarType (acoustic, electric, etc.)
// - constructor that initializes all fields
// - implementation of all required interface methods
    class Guitar extends StringedInstrument implements Tunable, Maintainable{
        private String guitarType;

        public Guitar (String name, int year, int numberOfStrings, String guitarType){
            super(name, year, numberOfStrings);
            this.guitarType=guitarType;
        }
        // override play method to be more specific
        @Override
        public String play(){
            return "Playing the " + guitarType + " guitar with " + getNumberOfStrings() + " strings";
        }

        @Override
        public String getInstrumentDetails(){
            return super.getInstrumentDetails() + ", Type: " + guitarType;
        }

        @Override
        public String tune(){
            return "Tuning the " + guitarType + " guitar";
        }

        @Override
        public String adjustPitch(boolean up){
            return up ? "Increasing pitch of the guitar" : "Decreasing pitch of the guitar";
        }

        @Override
        public String clean(){
            return "Cleaning the " + guitarType + " guitar";
        }

        @Override
        public String inspect(){
            return "Inspecting the " + guitarType + " guitar from " + year;

        }

    }

// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract play() method
// - implementation of all required interface methods
class Piano extends Instrument implements Tunable, Maintainable {
    // Additional field specific to Piano
    private boolean isGrand;
    
    // Constructor
    public Piano(String name, int year, boolean isGrand) {
        super(name, year);
        this.isGrand = isGrand;
    }
    
    // Implementation of abstract method from parent
    @Override
    public String play() {
        return "Playing the " + (isGrand ? "grand" : "upright") + " piano";
    }
    
    // Override parent method to add more details
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + (isGrand ? "Grand" : "Upright");
    }
    
    // Implement methods from Tunable interface
    @Override
    public String tune() {
        return "Tuning the piano";
    }
    
    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the piano" : "Decreasing pitch of the piano";
    }
    
    // Implement methods from Maintainable interface
    @Override
    public String clean() {
        return "Cleaning the piano keys and interior";
    }
    
    @Override
    public String inspect() {
        return "Inspecting the " + (isGrand ? "grand" : "upright") + " piano from " + year;
    }

}
// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
//   1. Creates an array of Instrument objects including Guitar and Piano instances
            // can you rephrase this step 1? 
                // Create an array that holds different types of Instrument objects,
//   2. Iterates through the array calling play() for each instrument
//   3. Demonstrates polymorphism by testing if each instrument is Tunable or Maintainable
//      and if so, calls the appropriate methods
public class MusicShop {
    public static void main(String[] args){
        // create an array that holds different types of Instrument objects,
                // we can add different types of instruments like Guitar and Piano
                // but they are all treated as Instrument type due to polymorphism 
        Instrument[] instruments = new Instrument[3];
        instruments[0] = new Guitar("Fender Stratocaster", 2020, 6, "Electric");
        instruments[1] = new Piano("Yamaha", 2018, true);
        instruments[2] = new Guitar("Gibson Les Paul", 2019, 6, "Acoustic");

        // Iterate through array and call play() for each instrument
        // is this polymorphism? 
            // yes, polymorphism allows us to treat different object types uniformly
                // here we call play() on each Instrument reference
                    // but the actual method executed depends on the object's real type (Guitar or Piano)
        for (Instrument instrument : instruments) {
            System.out.println(instrument.play());
            System.out.println(instrument.getInstrumentDetails());
            
            // explain this code: 
                // we check if the instrument implements Tunable interface
                    // if it does, we cast it to Tunable type and call its methods
            if (instrument instanceof Tunable) {
                Tunable tunableInstrument = (Tunable) instrument;
                System.out.println(tunableInstrument.tune());
                System.out.println(tunableInstrument.adjustPitch(true));
            }
            

            // Test if instrument is Maintainable
                // if it does, we cast it to Maintainable type and call its methods

            if (instrument instanceof Maintainable) {
                Maintainable maintainableInstrument = (Maintainable) instrument;
                System.out.println(maintainableInstrument.clean());
                System.out.println(maintainableInstrument.inspect());
            }
            
            System.out.println(); // Empty line for readability
        }
    }
}





