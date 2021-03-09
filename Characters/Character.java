public abstract class Character
{
	
	/*
	 * Character name including getter
	 */
	protected String name;
	public String GetName()
	{
		return name;
	}
	
	/*
	 * Character description including a getter
	 */
	protected String description;
	public String GetDescription()
	{
		return description;
	}
	
	/*
	 * Sprint speed for the character
	 * Includes a method to adjust the speed and one to get the speed 
	 */
	protected int sprintSpeed;
	public Utilities.ErrorMessage AdjustSprintSpeed(int additionalSpeed) 
	{
		if ((sprintSpeed + additionalSpeed) < walkSpeed) 
		{
			return Utilities.ErrorMessage.SprintSpeedLowerThanWalkSpeed;
		}
		else if ((sprintSpeed + additionalSpeed) < 0)
		{
			return Utilities.ErrorMessage.SprintSpeedTooLow;
		}
		else 
		{
			sprintSpeed += additionalSpeed;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetSprintSpeed() 
	{
		return sprintSpeed;
	}
	
	/*
	 * Walk speed for the character
	 * Includes a method to adjust the speed and one to get the speed
	 */
	protected int walkSpeed;
	public Utilities.ErrorMessage AdjustWalkSpeed(int additionalSpeed)
	{
		if ((walkSpeed + additionalSpeed) > sprintSpeed) 
		{
			return Utilities.ErrorMessage.WalkSpeedHigherThanSprintSpeed;
		}
		else if ((walkSpeed + additionalSpeed) < 0)
		{
			return Utilities.ErrorMessage.WalkSpeedTooLow;
		}
		else 
		{
			walkSpeed += additionalSpeed;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetWalkSpeed()
	{
		return walkSpeed;
	}
	
	/*
	 * Max health for the character
	 * Includes a method to adjust the health and one to get the health
	 */
	protected int maxHealth;
	public Utilities.ErrorMessage AdjustMaxHealth(int additionalHealth)
	{
		if ((maxHealth + additionalHealth) < 1)
		{
			return Utilities.ErrorMessage.MaxHealthTooLow;
		}
		else 
		{
			maxHealth += additionalHealth;
		}
		
		if (maxHealth < currentHealth)
		{
			currentHealth = maxHealth;
		}
		
		return Utilities.ErrorMessage.Success;
	}
	public int GetMaxHealth()
	{
		return maxHealth;
	}
	
	/*
	 * Current health for the character
	 * Includes a method to adjust the health and one to get the health
	 */
	protected int currentHealth;
	public Utilities.ErrorMessage AdjustCurrentHealth(int additionalHealth)
	{
		if ((currentHealth + additionalHealth) < 1)
		{
			currentHealth = 0;
			alive = false;
		}
		else 
		{
			currentHealth += additionalHealth;
		}
		
		if (maxHealth < currentHealth)
		{
			currentHealth = maxHealth;
		}
		
		return Utilities.ErrorMessage.Success;
	}
	public int GetCurrentHealth()
	{
		return currentHealth;
	}
	
	/*
	 * Flag to indicate whether the character is alive or not
	 * Includes a method to obtain the flag
	 */
	protected boolean alive = true;
	public boolean IsCharacterAlive()
	{
		return alive;
	}
	
	/*
	 * Constructor that initialises the character name and description
	 */
	protected Character(String characterName, String characterDescription)
	{
		name = characterName;
		description = characterDescription;
	}
	
}
