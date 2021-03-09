import java.util.List;

public class GameFramework 
{
	
	/*
	 * List of all the playable characters that the game has
	 * Includes a method to add a playable character to the list
	 */
	private List<PlayableCharacter> playableCharacters;
	public boolean AddPlayableCharacter(PlayableCharacter newPlayableCharacter) 
	{
		playableCharacters.add(newPlayableCharacter);
		
		return true;
	}
	
	/*
	 * List of all the non-playable characters that the game has
	 * Includes a method to add a non-playable character to the list
	 */
	private List<NonPlayableCharacter> nonPlayableCharacters;
	public boolean AddNonPlayableCharacter(NonPlayableCharacter newNonPlayableCharacter) 
	{
		nonPlayableCharacters.add(newNonPlayableCharacter);
		
		return true;
	}
	
	/*
	 * List of all the enemies that the game has
	 * Includes a method to add an enemy to the list
	 */
	private List<Enemy> enemies;
	public boolean AddEnemy(Enemy newEnemy) 
	{
		enemies.add(newEnemy);
		
		return true;
	}
	
	/*
	 * List of all the weapons that the game has
	 * Includes a method to add a weapon to the list
	 */
	private List<Weapon> weapons;
	public boolean AddWeapon(Weapon newWeapon) 
	{
		weapons.add(newWeapon);
		
		return true;
	}
	
	/*
	 * List of all the active items that the game has
	 * Includes a method to add an active item to the list
	 */
	private List<ActiveItem> activeItems;
	public boolean AddActiveItem(ActiveItem newActiveItem) 
	{
		activeItems.add(newActiveItem);
		
		return true;
	}
	
	/*
	 * List of all the passive items that the game has
	 * Includes a method to add a passive item to the list
	 */
	private List<PassiveItem> passiveItems;
	public boolean AddPassiveItem(PassiveItem newPassiveItem) 
	{
		passiveItems.add(newPassiveItem);
		
		return true;
	}
	
	/*
	 * List of all the user interfaces that the game has
	 * Includes a method to add a user interface to the list
	 */
	private List<UserInterface> userInterfaces;
	public boolean AddUserInterface(UserInterface newUserInterface) 
	{
		userInterfaces.add(newUserInterface);
		
		return true;
	}
	
	/*
	 * Stores the current active character that the game is using
	 * Includes both a getter and a setter
	 */
	private PlayableCharacter currentCharacter;
	public boolean SetCurrentCharacter(PlayableCharacter newCurrentCharacter)
	{
		currentCharacter = newCurrentCharacter;
		
		return true;
	}
	public PlayableCharacter GetCurrentCharacter() 
	{
		return currentCharacter;
	}
	
}