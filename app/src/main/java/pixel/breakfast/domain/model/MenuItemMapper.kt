package pixel.breakfast.domain.model

import android.content.Context
import pixel.breakfast.data.dto.MenuItemResp
import pixel.breakfast.domain.model.enum.MenuCategoryEnum

object MenuItemMapper {
    fun toDomain(context: Context, resp: MenuItemResp): MenuItem = MenuItem(
        id = resp.id,
        category = MenuCategoryEnum.from(resp.category),
        displayName = context.getMenuItemString(resp.id),
        price = resp.price,
        imageUrl = resp.imgRes
    )
}

fun Context.getMenuItemString(id: String): String {
    val nameKey = "menu_$id"

    return try {
        val rClass = Class.forName("${packageName}.R\$string")
        val field = rClass.getField(nameKey)
        val resourceId = field.getInt(null)
        getString(resourceId)
    } catch (e: Exception) {
        id
    }
}
