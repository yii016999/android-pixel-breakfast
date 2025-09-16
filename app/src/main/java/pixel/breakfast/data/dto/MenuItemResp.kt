package pixel.breakfast.data.dto

import androidx.annotation.StringRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItemResp(
    @SerialName("id") val id: String,
    @SerialName("category") val category: String,
    @SerialName("price") val price: Double,
    @SerialName("img_res") val imgRes: String,
)
