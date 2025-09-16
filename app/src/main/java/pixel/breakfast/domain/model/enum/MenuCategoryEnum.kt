package pixel.breakfast.domain.model.enum

import androidx.annotation.StringRes
import pixel.breakfast.R

enum class MenuCategoryEnum(val code: String, @StringRes val labelRes: Int) {
    SET("SET", R.string.menu_item_category_set),
    EGG("EGG", R.string.menu_item_category_egg),
    BURGER("BURGER", R.string.menu_item_category_burger),
    TOAST("TOAST", R.string.menu_item_category_toast),
    SANDWICH("SANDWICH", R.string.menu_item_category_sandwich),
    DRINK("DRINK", R.string.menu_item_category_drink),
    NONE("", 0);

    companion object {
        fun from(code: String?): MenuCategoryEnum =
            entries.firstOrNull { it.code.equals(code, ignoreCase = true) } ?: NONE
    }
}
