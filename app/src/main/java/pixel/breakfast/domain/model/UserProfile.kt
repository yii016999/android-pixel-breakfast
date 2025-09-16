package pixel.breakfast.domain.model

/**
 * User Profile data class
 * @param id: user id, null => guest
 * @param displayName: simple display
 */
data class UserProfile(
    val id: String? = null,
    val displayName: String = "Guest"
)
