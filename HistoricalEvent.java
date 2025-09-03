/**
 * Represents a Historical Event
 * 
 * @author Isabella Watson
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Historical Event
-----------------------------------------

- name: String

- age: String

- yearsOfExperience: String

- playerNumber: int

-----------------------------------------
//default constructor method:
+ ChessPlayer()

//full constructor method
+ ChessPlayer(name : String, age : String, yearsOfExperience : String, playerNumber : int)

//Copy constructor method
+ ChessPlayer(original : ChessPlayer)

+ setName(name : String) : void

+ setAge(age : String) : void

+ setYearsOfExperience(yearsOfExperience : String) : void

+ setPlayerNumber(playerNumber : int) : boolean

+ setAll(name : String, age :  String, yearsOfExperience :  String, playerNumber : int) : boolean

+ getName() : String

+ getAge() : String

+ getYearsOfExperrience() :  String

+ getPlayerNumber() : int

+ toString() : String

+ equals(other : ChessPlayer) : boolean

+ printData() : void
-----------------------------------------
*/

public class HistoricalEvent
{
    //DECLARATION SECTION
    /***** STATIC VARIABLES *****/
    public static final String DEFAULT_DESCRIPTION = "Jane Doe";
	public static final int DEFAULT_MONTH = 12;
	public static final int DEFAULT_DAY = 31;
	public static final int DEFAULT_YEAR = 1959;

    /***** INSTANCE VARIABLES *****/
	private String description;
	private Date eventDay;

    /***** CONSTRUCTORS *****/
	/**
     * Default (no argument) constructor, uses default constants defined in this class
    */
	public HistoricalEvent()
	{
		this.description = DEFAULT_DESCRIPTION;
		this.eventDay = new Date();
   	}

    /**
     * Full constructor, takes arguments for all instance variables
     * @param name name of player
     * @param age age of player
     * @param yearsOfExperience number of years playing chess
    */
    public HistoricalEvent(String name, String age,
        String yearsOfExperience, int playerNumber)
    {
        boolean setSuccessful = this.setAll(name, age, yearsOfExperience, playerNumber);
        if(!setSuccessful)
        {
            System.err.println("CRITICAL ERROR: full constructor given invalid data. Shutting down...");
            System.exit(0);
        }
    }
 
    /**
     * Copy constructor, creates a deep copy of original class object without changing it
     *
     * @param original class object to get data from to make deep copy
    */
    public HistoricalEvent(HistoricalEvent original)
    {
        if(original == null)
        {
            System.err.println("CRITICAL ERROR: copy constructor given 'null' value. Shutting down...");
            System.exit(0);
        }
        //rest of code will only proceed if error check passed
        boolean setSuccessful = this.setAll(original.description, original.age, original.yearsOfexperience, original.playerNumber);
        if(!setSuccessful)
        {
            System.err.println("CRITICAL ERROR: full constructor given invalid data. Shutting down...");
            System.exit(0);
        }
    }

    /***** ACCESSORS *****/
	
	/***** MUTATORS *****/
	// MUTATOR METHODS
	/**
	 * Sets all instance variable data (5) at once.
	 *
     * @param name name of chess player
     * @param age age of player
     * @param yearsOfExperience years playing chess
     * @param playerNumber player's number in the game (1 or 2 in a chess game)
	 * @return boolean that represents valid data (specifically only checks numeric data type validity)
	*/
	public boolean setAll(String name, String age,
        String yearsOfExperience, int playerNumber)
	{
		//call void setters
		this.setDescription(name);
		this.setAge(age);
		this.setYearsOfExperience(yearsOfExperience);

		//call boolean returning (error checking) numeric return setters
		boolean combinedValid = this.setPlayerNumber(playerNumber);

		return combinedValid;
	}

	/**
	 * Setting name, no error checking
	 *
	 * @param name name of chess player
	*/
	public void setDescription(String name)
	{
		this.description = name;
	}

	/**
	 * Setting age, no error checking
	 *
	 * @param age age of chess player
	*/
	public void setAge(String age)
	{
		this.age = age;
	}

	/**
	 * Setting years of experience, no error checking
	 *
	 * @param yearsOfExperience number of years playing chess
	*/
	public void setYearsOfExperience(String yearsOfExperience)
	{
		this.yearsOfexperience = yearsOfExperience;
	}

  /**
	 * Setting player number
	 *
	 * @param playerNumber of a chess player. allows 1 or 2 to represent 1 or 2 players during a 
	 * standard chess match
	 *
	 * @return boolean representing valid data passed and set in object, nothing set if invalid
	*/
	public boolean setPlayerNumber(int playerNumber)
	{
		if(playerNumber == 1 || playerNumber == 2)
		{
			this.playerNumber = playerNumber;
			return true;
		}
		else
		{
			return false;
		}
	}

  // ACCESSOR METHODS

	/**
	 * Getting name
	 *
	 * @return String representing name
	*/
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * Getting age
	 *
	 * @return String representing age
	*/
	public String getAge()
	{
		return this.age;
	}

	/**
	 * Getting yearsOfExperience
	 *
	 * @return String representing years playing chess
	*/
	public String getYearsOfExperience()
	{
		return this.yearsOfexperience;
	}

  /**
	 * Getting playerNumber
	 *
	 * @return int representing player number
	*/
	public int getPlayerNumber()
	{
		return this.playerNumber;
	}

  	/***** OTHER REQUIRED METHODS *****/

	/**
	 * Convert ChessPlayer into String representation of all data
	 *
	 * @return String containing all of ChessPlayer objects data, separate by newlines. No newline at end
	*/
	public String toString()
	{
		return "Player Name: " + this.description +
			"\nPlayer Age: " + this.age + 
			"\nYears Playing Chess: " + this.yearsOfexperience +
			"\nPlayer Number: " + this.playerNumber
      + "\n";
	}

	/**
	 * Checking ChessPlayer object equality (all instance variables), case-sensitive
	 *
	 * @param other ChessPlayer object that is being compared against
	 *
	 * @return boolean representing equality of two objects, true if all data is exactly the same (case-sensitive)
	*/
	public boolean equals(HistoricalEvent other)
	{
		return this.description.equals(other.description) &&
		this.age.equals(other.age) &&
		this.yearsOfexperience.equals(other.yearsOfexperience) &&
		this.playerNumber == other.playerNumber;
	}
}

