package pixel.breakfast.domain.model

import pixel.breakfast.R
import pixel.breakfast.data.dto.MenuItemResp
import pixel.breakfast.domain.model.enum.MenuCategoryEnum
import pixel.breakfast.ui.util.SupabaseImageUrl

object MenuItemMapper {
    fun toDomain(resp: MenuItemResp): MenuItem = MenuItem(
        id = resp.id,
        category = MenuCategoryEnum.from(resp.category),
        titleRes = nameMap[resp.id] ?: R.string.menu_unknown,
        price = resp.price.toInt(),
        imageUrl = SupabaseImageUrl.public(resp.imgRes)
    )

    private val nameMap: Map<String, Int> = mapOf(
        // ===== SET =====
        "set-001" to R.string.menu_set_001,
        "set-002" to R.string.menu_set_002,
        "set-003" to R.string.menu_set_003,
        "set-004" to R.string.menu_set_004,
        "set-005" to R.string.menu_set_005,
        "set-006" to R.string.menu_set_006,

        // ===== EGG =====
        "egg-001" to R.string.menu_egg_001,
        "egg-002" to R.string.menu_egg_002,
        "egg-003" to R.string.menu_egg_003,
        "egg-004" to R.string.menu_egg_004,
        "egg-005" to R.string.menu_egg_005,
        "egg-006" to R.string.menu_egg_006,

        // ===== BURGER (short: burg) =====
        "burg-001" to R.string.menu_burg_001,
        "burg-002" to R.string.menu_burg_002,
        "burg-003" to R.string.menu_burg_003,
        "burg-004" to R.string.menu_burg_004,
        "burg-005" to R.string.menu_burg_005,
        "burg-006" to R.string.menu_burg_006,

        // ===== TOAST (short: tst) =====
        "tst-001" to R.string.menu_tst_001,
        "tst-002" to R.string.menu_tst_002,
        "tst-003" to R.string.menu_tst_003,
        "tst-004" to R.string.menu_tst_004,
        "tst-005" to R.string.menu_tst_005,
        "tst-006" to R.string.menu_tst_006,

        // ===== SANDWICH (short: sand) =====
        "sand-001" to R.string.menu_sand_001,
        "sand-002" to R.string.menu_sand_002,
        "sand-003" to R.string.menu_sand_003,
        "sand-004" to R.string.menu_sand_004,
        "sand-005" to R.string.menu_sand_005,

        // ===== DRINK (short: drk) =====
        "drk-001" to R.string.menu_drk_001,
        "drk-002" to R.string.menu_drk_002,
        "drk-003" to R.string.menu_drk_003,
        "drk-004" to R.string.menu_drk_004,
        "drk-005" to R.string.menu_drk_005,
        "drk-006" to R.string.menu_drk_006,
    )
}
