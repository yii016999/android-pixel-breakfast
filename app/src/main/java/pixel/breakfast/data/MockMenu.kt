package pixel.breakfast.data

import pixel.breakfast.domain.model.MenuItem
import pixel.breakfast.domain.model.enum.MenuCategoryEnum

/** Simple mock data for breakfast menu */
object MockMenu {

    val items: List<MenuItem> = listOf(
        // ===== SET =====
        MenuItem("set-001", MenuCategoryEnum.SET, "美式A餐", 90, ""),
        MenuItem("set-002", MenuCategoryEnum.SET, "美式B餐", 90, ""),
        MenuItem("set-003", MenuCategoryEnum.SET, "美式C餐", 95, ""),
        MenuItem("set-004", MenuCategoryEnum.SET, "法式套餐", 100, ""),
        MenuItem("set-005", MenuCategoryEnum.SET, "卡拉雞腿套餐", 105, ""),
        MenuItem("set-006", MenuCategoryEnum.SET, "雞塊套餐", 110, ""),

        // ===== EGG =====
        MenuItem("egg-001", MenuCategoryEnum.EGG, "火腿蛋餅", 45, ""),
        MenuItem("egg-002", MenuCategoryEnum.EGG, "起司蛋餅", 45, ""),
        MenuItem("egg-003", MenuCategoryEnum.EGG, "玉米蛋餅", 40, ""),
        MenuItem("egg-004", MenuCategoryEnum.EGG, "鮪魚蛋餅", 45, ""),
        MenuItem("egg-005", MenuCategoryEnum.EGG, "培根蛋餅", 50, ""),
        MenuItem("egg-006", MenuCategoryEnum.EGG, "豬排蛋餅", 50, ""),
    )
}
