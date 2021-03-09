public class Weapon 
{
	/*
	 * Stores the default melee damage
	 */
	private final int DefaultMeleeDamage = 5;
	
	/*
	 * Weapon name including getter
	 */
	private String name;
	public String GetName()
	{
		return name;
	}
	
	/*
	 * Weapon description including a getter
	 */
	private String description;
	public String GetDescription()
	{
		return description;
	}
	
	/*
	 * All the possible weapon types
	 */
	public enum WeaponTypes
	{
		Melee,
		Ranged,
		MeleeAndRanged,
	};
	
	/*
	 * Stores the type of weapon this is
	 */
	private WeaponTypes weaponType;
	public WeaponTypes GetWeaponType()
	{
		return weaponType;
	}
	
	/*
	 * Stores the melee damage for the weapon
	 */
	private int meleeDamage;
	public Utilities.ErrorMessage SetMeleeDamage(int newMeleeDamage)
	{
		if (weaponType == WeaponTypes.Ranged)
		{
			meleeDamage = 0;
			return Utilities.ErrorMessage.Success;
		}
		else
		{
			if (newMeleeDamage <= 0)
			{
				return Utilities.ErrorMessage.MeleeDamageZeroOrLess;
			}
			else
			{
				meleeDamage = newMeleeDamage;
				return Utilities.ErrorMessage.Success;
			}
		}
	}
	public int GetMeleeDamage()
	{
		return meleeDamage;
	}
	
	/*
	 * Flag to indicate whether the weapon uses bullets or not
	 * Includes a getter
	 */
	private final Boolean usesBullets;
	public Boolean DoesWeaponUseBullets()
	{
		return usesBullets;
	}
	
	/*
	 * Stores the clip size for the weapon
	 * Includes a getter and setter
	 */
	private int clipSize;
	public Utilities.ErrorMessage SetClipSize(int newMaxClipSize)
	{
		if (usesBullets)
		{
			if (newMaxClipSize <= 0)
			{
				return Utilities.ErrorMessage.ClipSizeZeroOrLess;
			}
			else
			{
				clipSize = newMaxClipSize;
				
				if (clipSize < numberOfBulletsInClip)
				{
					numberOfBulletsInClip = clipSize;
				}
				
				return Utilities.ErrorMessage.Success;
			}
		}
		else
		{
			return Utilities.ErrorMessage.WeaponDoesNotUseBullets;
		}
	}
	public int GetClipSize()
	{
		return clipSize;
	}
	
	/*
	 * Stores the current number of bullets that are left in the clip
	 * Includes a getter and setter 
	 */
	private int numberOfBulletsInClip;
	public Utilities.ErrorMessage SetNumberOfBulletsInClip(int newCurrentClipSize)
	{
		if (usesBullets)
		{
			if (newCurrentClipSize < 0)
			{
				return Utilities.ErrorMessage.NumberOfBulletsInClipLessThanZero;
			}
			else if (newCurrentClipSize > clipSize)
			{
				return Utilities.ErrorMessage.NumberOfBulletsInClipGreaterThanClipSize;
			}
			else
			{
				numberOfBulletsInClip = newCurrentClipSize;
				return Utilities.ErrorMessage.Success;
			}
		}
		else
		{
			return Utilities.ErrorMessage.WeaponDoesNotUseBullets;
		}
	}
	public int GetNumberOfBulletsInClip()
	{
		return numberOfBulletsInClip;
	}
	
	public Weapon(String weaponName, String weaponDescription, WeaponTypes startType, Boolean useBulletFlag, int startMeleeDamage, int startClipSize)
	{
		name = weaponName;
		description = weaponDescription;
		
		weaponType = startType;
		
		usesBullets = useBulletFlag;
		
		if (SetMeleeDamage(startMeleeDamage) == Utilities.ErrorMessage.MeleeDamageZeroOrLess)
		{
			SetMeleeDamage(DefaultMeleeDamage);
		}
		
		if (useBulletFlag)
		{
			clipSize = startClipSize;
			numberOfBulletsInClip = startClipSize;
		}
	}
	
}
