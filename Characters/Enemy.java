import java.util.List;

public class Enemy extends Character
{
	
	/*
	 * Stores the weapon that the enemy wields
	 * Includes a getter and setter
	 */
	private Weapon weapon;
	public void SetWeapon(Weapon newWeapon)
	{
		weapon = newWeapon;
	}
	public Weapon GetWeapon()
	{
		return weapon;
	}
	
	/*
	 * Stores the base contact damage of the enemy
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
	 * The angle, from straight, that the enemy will be able to see the player
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
	 * How far away the enemy will be able to see the player
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
	 * List of all the passive effects that the enemy has
	 * Includes a getter
	 */
	private List<PassiveItem> passiveEffects;
	public List<PassiveItem> GetPassiveEffects()
	{
		return passiveEffects;
	}
	
	/*
	 * Constructor that initialises the max health, walk speed, sprint speed, starting weapon,
	 * base contact damage, base FOV, base sight distance and the passive effects of the enemy
	 * Also initialises the enemies name and description
	 */
	public Enemy(int startMaxHealth, int startWalkSpeed, int startSprintSpeed, Weapon startWeapon, int startBaseContactDamage, int startBaseFieldOfView, int startBaseSightDistance, List<PassiveItem> startPassiveEffects, String characterName, String characterDescription)
	{
		super(characterName, characterDescription);
		
		maxHealth = startMaxHealth;
		currentHealth = startMaxHealth;
		
		sprintSpeed = startSprintSpeed;
		walkSpeed = startWalkSpeed;
		
		weapon = startWeapon;
		
		baseContactDamage = startBaseContactDamage;
		
		baseFieldOfView = startBaseFieldOfView;
		
		baseSightDistance = startBaseSightDistance;
		
		passiveEffects = startPassiveEffects;
	}
	
}
