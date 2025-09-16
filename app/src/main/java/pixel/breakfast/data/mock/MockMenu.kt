package pixel.breakfast.data.mock

import pixel.breakfast.R
import pixel.breakfast.domain.model.MenuItem
import pixel.breakfast.domain.model.enum.MenuCategoryEnum

/** Simple mock data for breakfast menu */
object MockMenu {

    val items: List<MenuItem> = listOf(
        // ===== SET =====
        MenuItem("set-001", MenuCategoryEnum.SET, R.string.menu_set_001, 90, ""),
        MenuItem("set-002", MenuCategoryEnum.SET, R.string.menu_set_002, 90, ""),
        MenuItem("set-003", MenuCategoryEnum.SET, R.string.menu_set_003, 95, ""),
        MenuItem("set-004", MenuCategoryEnum.SET, R.string.menu_set_004, 100, ""),
        MenuItem("set-005", MenuCategoryEnum.SET, R.string.menu_set_005, 105, ""),
        MenuItem("set-006", MenuCategoryEnum.SET, R.string.menu_set_006, 110, ""),

        // ===== EGG =====
        MenuItem("egg-001", MenuCategoryEnum.EGG, R.string.menu_egg_001, 45, ""),
        MenuItem("egg-002", MenuCategoryEnum.EGG, R.string.menu_egg_002, 45, ""),
        MenuItem("egg-003", MenuCategoryEnum.EGG, R.string.menu_egg_003, 40, ""),
        MenuItem("egg-004", MenuCategoryEnum.EGG, R.string.menu_egg_004, 45, ""),
        MenuItem("egg-005", MenuCategoryEnum.EGG, R.string.menu_egg_005, 50, ""),
        MenuItem("egg-006", MenuCategoryEnum.EGG, R.string.menu_egg_006, 50, ""),
    )
}