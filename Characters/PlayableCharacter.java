import java.util.List;

public class PlayableCharacter extends Character
{
	
	/*
	 * List of all the weapons that the character is current holding
	 * Includes methods to add and remove a weapon as well as check whether the weapon is in the list
	 */
	private List<Weapon> availableWeapons;
	public void AddWeapon(Weapon newWeapon)
	{
		if (!availableWeapons.contains(newWeapon)) 
		{
			availableWeapons.add(newWeapon);
		}
	}
	public void RemoveWeapon(Weapon weaponToRemove)
	{
		int index = availableWeapons.indexOf(weaponToRemove);
		if (index != -1)
		{
			availableWeapons.remove(index);
		}
	}
	public boolean IsWeaponInList(Weapon weapon)
	{
		return availableWeapons.contains(weapon);
	}
	
	/*
	 * Stores the currently active weapon
	 * Includes methods to change the current weapon and get the current weapon
	 */
	private Weapon currentWeapon;
	public Utilities.ErrorMessage SetCurrentWeapon(Weapon newWeapon)
	{
		if (availableWeapons.contains(newWeapon))
		{
			currentWeapon = newWeapon;
			return Utilities.ErrorMessage.Success;
		}
		else 
		{
			return Utilities.ErrorMessage.WeaponNotInAvailableWeapons;
		}
	}
	public Weapon GetCurrentWeapon()
	{
		return currentWeapon;
	}
	
	/*
	 * Stores the currently active item
	 * Includes a getter and setter
	 */
	private ActiveItem activeItem;
	public void SetActiveItem(ActiveItem newActiveItem)
	{
		activeItem.SetCurrentStatus(ActiveItem.ActiveItemStatus.Waiting);
		activeItem = newActiveItem;
	}
	public ActiveItem GetActiveItem()
	{
		return activeItem;
	}
	
	/* 
	 * Stores the base contact damage of the player
	 * Includes a getter and setter
	 */
	private int baseContactDamage;
	public Utilities.ErrorMessage SetBaseContactDamage(int newBaseContactDamage)
	{
		if (newBaseContactDamage < 0)
		{
			return Utilities.ErrorMessage.BaseContactDamageLessThanZero;
		}
		else 
		{
			baseContactDamage = newBaseContactDamage;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetBaseContactDamage()
	{
		return baseContactDamage;
	}
	
	/*
	 * The angle, from straight, that the player will be able to see the enemies
	 * x below
	 * 
	 * 
	 * 								 |		  /
	 * 								 |	(x)	 /
	 * 								 |		/
	 * 							---    ---
	 * 						   (eye)  (eye)
	 * 							---	   ---
	 * 
	 * 
	 * Includes a getter and setter
	 */
	private int baseFieldOfView;
	public Utilities.ErrorMessage SetBaseFieldOfView(int newBaseFieldOfView)
	{
		if (newBaseFieldOfView < 0)
		{
			return Utilities.ErrorMessage.BaseFieldOfViewLessThanZero;
		}
		else if (newBaseFieldOfView > 180)
		{
			return Utilities.ErrorMessage.BaseFieldOfViewGreaterThan180;
		}
		else
		{
			baseFieldOfView = newBaseFieldOfView;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetBaseFieldOfView()
	{
		return baseFieldOfView;
	}
	
	/*
	 * How far away the player will be able to see the enemies
	 * Includes a getter and setter
	 */
	private int baseSightDistance;
	public Utilities.ErrorMessage SetSightDistance(int newSightDistance)
	{
		if (newSightDistance < 0)
		{
			return Utilities.ErrorMessage.BaseSightDistanceLessThanZero;	
		}
		else
		{
			baseSightDistance = newSightDistance;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetBaseSightDistance()
	{
		return baseSightDistance;
	}
	
	/*
	 * Stores all the passive items that the player has
	 * Includes a method to add a new passive item and another to get the list
	 */
	private List<PassiveItem> passiveItems;
	public void AddPassiveItem(PassiveItem newPassiveItem)
	{
		if (!passiveItems.contains(newPassiveItem))
		{
			passiveItems.add(newPassiveItem);
		}
	}
	public List<PassiveItem> GetPassiveItems()
	{
		return passiveItems;
	}
	
	/*
	 * Constructor that initialises the health, walk speed, sprint speed, starting weapon,
	 * active item, base contact damage, base field of view, base sight distance and passive items
	 * Also initialises the character's name and description
	 */
	public PlayableCharacter(int startMaxHealth, int startWalkSpeed, int startSprintSpeed, Weapon startingWeapon, ActiveItem startActiveItem, int startBaseContactDamage, int startBaseFieldOfView, int startBaseSightDistance, List<PassiveItem> startPassiveItems, String characterName, String characterDescription)
	{
		super(characterName, characterDescription);
		
		maxHealth = startMaxHealth;
		currentHealth = startMaxHealth;
		
		sprintSpeed = startSprintSpeed;
		walkSpeed = startWalkSpeed;
		
		AddWeapon(startingWeapon);
		currentWeapon = startingWeapon;
		
		activeItem = startActiveItem;
		
		baseContactDamage = startBaseContactDamage;
		
		baseFieldOfView = startBaseFieldOfView;
		
		baseSightDistance = startBaseSightDistance;
		
		passiveItems = startPassiveItems;
	}
	
}
