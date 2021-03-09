public class Utilities
{
	
	public enum ErrorMessage
	{
		Success,
		SprintSpeedTooLow,
		SprintSpeedLowerThanWalkSpeed,
		WalkSpeedTooLow,
		WalkSpeedHigherThanSprintSpeed,
		MaxHealthTooLow,
		InvalidIndex,
		WeaponNotInAvailableWeapons,
		ActiveLengthLessZeroOrLess,
		RechargeLengthLessZeroOrLess,
		BaseContactDamageLessThanZero,
		BaseFieldOfViewLessThanZero,
		BaseFieldOfViewGreaterThan180,
		BaseSightDistanceLessThanZero,
		PercentageChanceZeroOrLess,
		ItemEffectAlreadyInTheHashTable,
		ItemEffectNotInHashTable,
		BulletSpeedLessThanZero,
		MeleeDamageZeroOrLess,
		WeaponDoesNotUseBullets,
		ClipSizeZeroOrLess,
		NumberOfBulletsInClipLessThanZero,
		NumberOfBulletsInClipGreaterThanClipSize,
		OtherError
	};
	
}
