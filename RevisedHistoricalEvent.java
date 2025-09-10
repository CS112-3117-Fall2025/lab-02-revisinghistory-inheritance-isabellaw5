/**
 * Represents a Revised Historical Event
 * 
 * @author Isabella Watson
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Revised Historical Event
-----------------------------------------

- revisedDescription: String

- citation: String

-----------------------------------------
//default constructor method:
+ RevisedHistoricalEvent()

//full constructor method
+ RevisedHistoricalEvent(description : String, eventDay : Date, revisedDescription : String, citation : String)

//Copy constructor method
+ RevisedHistoricalEvent(original : RevisedHistoricalEvent)

+ setRevisedDescription(revisedDescription : String) : void

+ setCitation(citation : String) : void

+ setAll(description : String, eventDay : Date, revisedDescription : String, citation : String) : boolean

+ getRevisedDescription() : String

+ getCitation() : String

+ toString() : String

+ equals(obj : Object) : boolean

+ teach() : void
-----------------------------------------
*/

public class RevisedHistoricalEvent extends HistoricalEvent
{
    //DECLARATION SECTION
    /***** STATIC VARIABLES *****/
	public static final String DEFAULT_REVISED_DESCRIPTION = "Default Revised Historical Description";
	public static final String DEFAULT_CITATION = "Default Citation";
    
	/***** INSTANCE VARIABLES *****/
	private String revisedDescription;
	private String citation;

    /***** CONSTRUCTORS *****/
	/**
	 * Default (no argument) constructor, uses default constants defined in this
	 * class
	 */
	public RevisedHistoricalEvent()
	{
		super();
		this.revisedDescription = DEFAULT_REVISED_DESCRIPTION;
		this.citation = DEFAULT_CITATION;
   	}

    /**
	 * Full constructor, takes arguments for all instance variables
	 * 
	 * @param revisedDescription description of historical event
	 * @param citation           citation for information on historical event
	 */
	public RevisedHistoricalEvent(String description, Date eventDay, String revisedDescription, String citation)
    {
		super(description, eventDay);
		this.setRevisedDescription(revisedDescription);
		this.setCitation(citation);
    }

    /**
     * Copy constructor, creates a deep copy of original class object without changing it
     *
     * @param original class object to get data from to make deep copy
    */
    public RevisedHistoricalEvent(RevisedHistoricalEvent original)
    {
        if(original == null)
        {
            System.err.println("CRITICAL ERROR: copy constructor given 'null' value. Shutting down...");
            System.exit(0);
        }
        //rest of code will only proceed if error check passed
        boolean setSuccessful = this.setAll(original.description, original.eventDay, original.revisedDescription, original.citation);
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
	 * Sets all instance variable data (4) at once.
	 *
     * @param description String description of historical event
     * @param eventDay Date date of historical event
	 * @param revisedDescription String revised description of historical event
	 * @param citation String citation for historical event
	 * @return boolean that represents valid data (specifically only checks numeric data type validity)
	*/
	public boolean setAll(String description, Date eventDay, String revisedDescription, String citation)
	{
		//call void setters
		boolean combinedValid = true;
		super.setDescription(description);
		super.setEventDay(eventDay);
		this.setRevisedDescription(description);
		this.setCitation(citation);
		return combinedValid;
	}

	/**
	 * Setting revisedDescription, no error checking
	 *
	 * @param revisedDescription String description of historical event
	*/
	public void setRevisedDescription(String revisedDescription)
	{
		this.revisedDescription = revisedDescription;
	}

	/**
	 * Setting citation, no error checking
	 *
	 * @param citation String of citation for event
	*/
	public void setCitation(String citation)
	{
		this.citation = citation;
	}

  // ACCESSOR METHODS

	/**
	 * Getting revisedDescription
	 *
	 * @return revisedDescription String representing revised description of historical event
	*/
	public String getRevisedDescription()
	{
		return this.revisedDescription;
	}

	/**
	 * Getting citation
	 *
	 * @return citation String representing citation for historical event
	*/
	public String getCitation()
	{
		return this.citation;
	}


  	/***** OTHER REQUIRED METHODS *****/

	/**
	 * Convert Revised Historical Event into String representation of all data
	 *
	 * @return String containing all of RevisedHistoricalEvent objects data, separate by newlines. Newline at end
	*/

	@Override
	public String toString()
	{
		return "The following \"History\" was told for many years:\n\n" + super.toString() +
		"\n" + 
		"By correcting history, not just rewriting it, we are revising it to embark on the process of righting a wrong.\nHere is the revised history:\n"
		+
		this.getRevisedDescription() +
		"\n\nSource: " +
		this.getCitation();
	}
	/**
	 * Checking RevisedHistoricalEvent object equality (all instance variables), case-sensitive
	 *
	 * @param historicalEvent istoricalEvent object that is being compared against
	 *
	 * @return boolean representing equality of two objects, true if all data is exactly the same (case-sensitive)
	*/
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			RevisedHistoricalEvent otherRevisedHistoricalEvent = (RevisedHistoricalEvent) obj; //downcasting object type to Reised Historical Event type
			return this.description.equals(otherRevisedHistoricalEvent.description) &&
					this.eventDay.equals(otherRevisedHistoricalEvent.eventDay) &&
					this.revisedDescription.equals(otherRevisedHistoricalEvent.revisedDescription) &&
					this.revisedDescription.equals(otherRevisedHistoricalEvent.revisedDescription);
		}
	}

	/**
	 * teach method
	 *
	 * @return void, print class information to console
	*/
	public void teach()
	{
		System.out.println(this.toString());
	}
}

