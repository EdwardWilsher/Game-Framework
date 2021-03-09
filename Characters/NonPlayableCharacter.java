import java.util.List;

public class NonPlayableCharacter extends Character
{
	
	/*
	 * Stores the name of the non-playable character
	 */
	public String Name;
	
	/*
	 * List of all the lines that the character says
	 * Includes a method to add a speech to the list
	 */
	private List<String> characterSpeeches;
	public Utilities.ErrorMessage AddCharacterSpeech(String newSpeech)
	{
		characterSpeeches.add(newSpeech);
		return Utilities.ErrorMessage.Success;
	}
	
	/*
	 * Index of the current speech in the list
	 */
	private int speechIndex = 0;
	public Utilities.ErrorMessage SetSpeechIndex(int newIndex)
	{
		if (newIndex < 0 || newIndex >= characterSpeeches.size())
		{
			return Utilities.ErrorMessage.InvalidIndex;
		}
		else 
		{
			speechIndex = newIndex;
			return Utilities.ErrorMessage.Success;
		}
	}
	
	/*
	 * Constructor that initialises the health and speed of the non-playable character
	 * Also initialises the NPC's name and description
	 */
	public NonPlayableCharacter(String characterName, String characterDescription)
	{
		super(characterName, characterDescription);
		
		maxHealth = 100;
		currentHealth = 100;
		sprintSpeed = 100;
		walkSpeed = 100;
	}
	
	/*
	 * Override of the base AdjustCurrentHealth to keep the current health the same
	 * This is because non-playable characters do not take damage
	 */
	@Override
	public Utilities.ErrorMessage AdjustCurrentHealth(int additionalHeath) 
	{
		// Do nothing, non-playable characters never take damage
		return Utilities.ErrorMessage.Success;
	}
	
	/*
	 * Returns the speech at the current index
	 */
	public String GetCurrentSpeech()
	{
		String currentSpeech = "";
		
		if (characterSpeeches.size() == 0)
		{
			currentSpeech = "No speeches available";
		}
		else if (speechIndex < 0 || speechIndex >= characterSpeeches.size())
		{
			currentSpeech = "Invalid speech index";
		}
		else 
		{
			currentSpeech = characterSpeeches.get(speechIndex);
			
			if (speechIndex != (characterSpeeches.size() - 1))
			{
				speechIndex++;
			}
		}
		
		return currentSpeech;
	}
	
}
