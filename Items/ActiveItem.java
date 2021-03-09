import java.util.EnumSet;

public class ActiveItem 
{
	
	/*
	 * Enumerator of all the possible active item statuses
	 */
	public enum ActiveItemStatus 
	{
		Waiting,
		Active,
		Recharging,
		OutOfAmmo
	};
	
	/*
	 * Enumerator of all the possible options for the active item
	 */
	public enum ActiveItemFunctions
	{
		Dodge,
		Invisibility,
		Shield,
		Teleport,
		DirectionOfEndOfFloor
	}
	
	/*
	 * Active item name including getter
	 */
	private String name;
	public String GetName()
	{
		return name;
	}
	
	/*
	 * Active item description including a getter
	 */
	private String description;
	public String GetDescription()
	{
		return description;
	}
	
	/*
	 * Stores the functions that the active item has
	 * Includes a getter
	 */
	private EnumSet<ActiveItemFunctions> functions;
	public EnumSet<ActiveItemFunctions> GetActiveItemFunctions()
	{
		return functions;
	}
	
	/*
	 * Stores the current status of the active item
	 * Includes a Getter and Setter
	 */
	private ActiveItemStatus currentStatus = ActiveItemStatus.Waiting;
	public void SetCurrentStatus(ActiveItemStatus newStatus)
	{
		currentStatus = newStatus;
	}
	public ActiveItemStatus GetCurrentStatus()
	{
		return currentStatus;
	}
	
	/*
	 * Stores the length of time that the active item is active for
	 * Includes a getter and setter
	 */
	private int activeLength;
	public Utilities.ErrorMessage SetActiveLength(int newActiveLength)
	{
		if (newActiveLength <= 0)
		{
			return Utilities.ErrorMessage.ActiveLengthLessZeroOrLess;
		}
		else 
		{
			activeLength = newActiveLength;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetActiveLength()
	{
		return activeLength;
	}
	
	/*
	 * Stores the length of time that the active item recharges for
	 * Includes a getter and setter
	 */
	private int rechargeLength;
	public Utilities.ErrorMessage SetRechargeLength(int newRechargeLength)
	{
		if (newRechargeLength <= 0)
		{
			return Utilities.ErrorMessage.RechargeLengthLessZeroOrLess;
		}
		else 
		{
			rechargeLength = newRechargeLength;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetRechargeLength() 
	{
		return rechargeLength;
	}
	
	/*
	 * If the active item has only a set number of uses then this stores that number
	 */
	private int numberOfUses;
	public void SetNumberOfUses(int newNumberOfUses)
	{
		numberOfUses = newNumberOfUses;
		if (newNumberOfUses == 0)
		{
			currentStatus = ActiveItemStatus.OutOfAmmo;
		}
	}
	public int GetNumberOfUses()
	{
		return numberOfUses;
	}
	
	/*
	 * Constructor that initialises the active length, re-charge length and the function of the active item
	 * Also initialises the item name, description and number of uses
	 */
	public ActiveItem(int startingActiveLength, int startingRechargeLength, EnumSet<ActiveItemFunctions> defaultFunctions, String itemName, String itemDescription, int startNumberOfUses) 
	{
		name = itemName;
		description = itemDescription;
		
		activeLength = startingActiveLength;
		rechargeLength = startingRechargeLength;
		functions = defaultFunctions;
		
		numberOfUses = startNumberOfUses;
	}
	
}
