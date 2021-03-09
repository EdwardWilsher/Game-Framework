import java.util.Hashtable;

public class PassiveItem 
{
	
	/*
	 * Passive item name including getter
	 */
	private String name;
	public String GetName()
	{
		return name;
	}
	
	/*
	 * Passive item description including a getter
	 */
	private String description;
	public String GetDescription()
	{
		return description;
	}
	
	/*
	 * Enumerator containing all the possible passive item effects
	 */
	public enum PassiveItemEffects
	{
		FreezeBullet,
		FireBullet,
		TeleportBullet,
		SlowBullet,
		FlashbangBullet,
		PoisonBullet,
		BleedBullet,
		FreezeImmunity,
		FireImmunity,
		TeleportImmunity,
		SlowImmunity,
		FlashbangImmunity,
		PoisonImmunity,
		BleedImmunity,
		PlayerCurrentHealthIncrease,
		PlayerMaxHealthIncrease,
		PlayerWalkSpeedIncrease,
		PlayerSprintSpeedIncrease,
		PlayerFireRateIncrease,
		PlayerClipSizeIncrease,
		EnemyCurrentHealthDecrease,
		EnemyMaxHealthDecrease,
		EnemyWalkSpeedDecrease,
		EnemySprintSpeedDecrease,
		EnemyFireRateDecrease,
		EnemtClipSizeDecrease,
		AmmoSizeIncrease
	};
	
	/*
	 * Stores a hash table of all the passive effects and the percentage chance that they take effect
	 * Includes methods to add an item effect (including chance), edit a chance, remove an item,
	 * check whether an item is in the hash table and get the chance of occurrence for a specific effect
	 * Also includes a method to get the entire hash table
	 */
	private Hashtable<PassiveItemEffects, Integer> itemEffects;
	public Utilities.ErrorMessage AddItemEffect(PassiveItemEffects newEffect, int chanceOfOccurance)
	{
		if (chanceOfOccurance <= 0)
		{
			return Utilities.ErrorMessage.PercentageChanceZeroOrLess;
		}
		else if (itemEffects.containsKey(newEffect))
		{
			return Utilities.ErrorMessage.ItemEffectAlreadyInTheHashTable;
		}
		else 
		{
			itemEffects.put(newEffect, chanceOfOccurance);
			return Utilities.ErrorMessage.Success;
		}
	}
	public Utilities.ErrorMessage EditItemChanceOfOccurance(PassiveItemEffects effect, int newChanceOfOccurance)
	{
		if (newChanceOfOccurance <= 0)
		{
			return Utilities.ErrorMessage.PercentageChanceZeroOrLess;
		}
		else if (!itemEffects.containsKey(effect))
		{
			return Utilities.ErrorMessage.ItemEffectNotInHashTable;
		}
		else
		{
			itemEffects.replace(effect, newChanceOfOccurance);
			return Utilities.ErrorMessage.Success;
		}
	}
	public Utilities.ErrorMessage RemoveItemEffect(PassiveItemEffects effect)
	{
		if (!itemEffects.contains(effect))
		{
			return Utilities.ErrorMessage.ItemEffectNotInHashTable;
		}
		else
		{
			itemEffects.remove(effect);
			return Utilities.ErrorMessage.Success;
		}
	}
	public boolean IsItemInHashTable(PassiveItemEffects effect)
	{
		return itemEffects.contains(effect);
	}
	public int GetChanceOfOccurance(PassiveItemEffects effect)
	{
		if (itemEffects.contains(effect))
		{
			return itemEffects.get(effect);
		}
		else
		{
			return -1;
		}
	}
	public Hashtable<PassiveItemEffects, Integer> GetItemEffects()
	{
		return new Hashtable<PassiveItemEffects, Integer>(itemEffects);
	}
	
	/*
	 * Constructor that initialises the item effects hash table
	 * Also initialises the item name and description
	 */
	public PassiveItem(Hashtable<PassiveItemEffects, Integer> startItemEffects, String itemName, String itemDescription)
	{
		name = itemName;
		description = itemDescription;
		
		itemEffects = startItemEffects;
	}
	
}
