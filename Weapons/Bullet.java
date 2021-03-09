import java.util.EnumSet;

public class Bullet
{
	
	/*
	 * List of all the possible bullet modifiers
	 */
	public enum BulletModifierTypes
	{
		Freeze,
		Fire,
		Teleport,
		Slow,
		Flashbang,
		Poison,
		Bleed
	};
	
	/*
	 * List of all the bullet modifiers that this bullet has
	 * Includes a methods to get the modifiers, add and remove the modifiers
	 */
	private EnumSet<BulletModifierTypes> bulletModifiers; 
	public EnumSet<BulletModifierTypes> GetBulletModifiers()
	{
		return bulletModifiers;
	}
	public void AddBulletModifier(BulletModifierTypes newBulletModifier)
	{
		if (!bulletModifiers.contains(newBulletModifier))
		{
			bulletModifiers.add(newBulletModifier);
		}
	}
	public void RemoveBulletModifier(BulletModifierTypes bulletModifier)
	{
		if (bulletModifiers.contains(bulletModifier))
		{
			bulletModifiers.remove(bulletModifier);
		}
	}
	
	/*
	 * Stores the speed at which the bullet travels
	 * Includes a method to set and get the bullet speed
	 */
	private int bulletSpeed;
	public Utilities.ErrorMessage SetBulletSpeed(int newBulletSpeed)
	{
		if (newBulletSpeed < 0)
		{
			return Utilities.ErrorMessage.BulletSpeedLessThanZero;
		}
		else
		{
			bulletSpeed = newBulletSpeed;
			return Utilities.ErrorMessage.Success;
		}
	}
	public int GetBulletSpeed()
	{
		return bulletSpeed;
	}
	
	/*
	 * Constructor that initialises the bullet modifiers and speed
	 */
	public Bullet(EnumSet<BulletModifierTypes> startBulletModifiers, int startSpeed)
	{
		bulletModifiers = startBulletModifiers;
		
		bulletSpeed = startSpeed;
	}
	
}
