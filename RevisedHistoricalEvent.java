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

public class RevisedHistoricalEvent
{
    //DECLARATION SECTION
    /***** STATIC VARIABLES *****/
    public static final String DEFAULT_REVISED_DESCRIPTION = "Default Revised Historical Description";
	public static final String DEFAULT_CITATION = "Default Revised Historical Description";
    /***** INSTANCE VARIABLES *****/
	private String revisedDescription;
	private String citation;

    /***** CONSTRUCTORS *****/
	/**
     * Default (no argument) constructor, uses default constants defined in this class
    */
	public HistoricalEvent()
	{
		this.revisedDescription = DEFAULT_REVISED_DESCRIPTION;
		this.eventDay = new Date();
   	}

    /**
     * Full constructor, takes arguments for all instance variables
     * @param revisedDescription description of historical event
     * @param eventDay date of historical event
    */
    public HistoricalEvent(String description, Date eventDay)
    {
        boolean setSuccessful = this.setAll(description, eventDay);
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
        boolean setSuccessful = this.setAll(original.description, original.eventDay);
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
	 * Sets all instance variable data (2) at once.
	 *
     * @param description description of historical event
     * @param eventDay date of historical event
	 * @return boolean that represents valid data (specifically only checks numeric data type validity)
	*/
	public boolean setAll(String description, Date eventDay)
	{
		//call void setters
		boolean combinedValid = true;
		this.setRevisedDescription(description);
		this.setEventDay(eventDay);

		return combinedValid;
	}

	/**
	 * Setting description, no error checking
	 *
	 * @param description description of historical event
	*/
	public void setRevisedDescription(String description)
	{
		this.revisedDescription = description;
	}

	/**
	 * Setting event day, no error checking
	 *
	 * @param eventDay date of event
	*/
	public void setEventDay(Date eventDay)
	{
		this.eventDay = eventDay;
	}

  // ACCESSOR METHODS

	/**
	 * Getting description
	 *
	 * @return description String representing description of historical event
	*/
	public String getRevisedDescription()
	{
		return this.revisedDescription;
	}

	/**
	 * Getting eventDay
	 *
	 * @return eventDay Date representing day of event
	*/
	public Date getEventDay()
	{
		return this.eventDay;
	}


  	/***** OTHER REQUIRED METHODS *****/

	/**
	 * Convert Historical Event into String representation of all data
	 *
	 * @return String containing all of HistoricalEvent objects data, separate by newlines. Newline at end
	*/
	public String toString()
	{
		return "On " + eventDay.toString() + ": " + this.revisedDescription + "\n";
	}

	/**
	 * Checking HistoricalEvent object equality (all instance variables), case-sensitive
	 *
	 * @param other HistoricalEvent object that is being compared against
	 *
	 * @return boolean representing equality of two objects, true if all data is exactly the same (case-sensitive)
	*/
	public boolean equals(HistoricalEvent other)
	{
		return this.revisedDescription.equals(other.description) &&
		this.eventDay.equals(other.eventDay);
	}
}

