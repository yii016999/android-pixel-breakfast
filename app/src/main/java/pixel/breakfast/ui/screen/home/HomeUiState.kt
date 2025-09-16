package pixel.breakfast.ui.screen.home

import pixel.breakfast.domain.model.MenuItem
import pixel.breakfast.domain.model.enum.MenuCategoryEnum

data class HomeUiState(
    val isLoading: Boolean = false,                                     // When data is loading
    val error: String? = null,                                          // When error occurs

    // ---- banner state ----
    val bannersAutoPlay: Boolean = true,                                // Auto play banner
    val bannersAutoPlayMillis: Long = 3000L,                            // Auto play banner delay time

    // ---- cat state ----
    val selectedCategory: MenuCategoryEnum = MenuCategoryEnum.SET,      // When user selects a category
    val categories: List<MenuCategoryEnum> = MenuCategoryEnum.entries,  // All meal categories
    val items: List<MenuItem> = emptyList(),                            // All meal items
)
