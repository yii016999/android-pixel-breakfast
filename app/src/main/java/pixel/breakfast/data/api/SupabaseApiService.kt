package pixel.breakfast.data.api

import pixel.breakfast.data.dto.MenuItemResp
import retrofit2.Response
import retrofit2.http.GET

interface SupabaseApiService {
    @GET("rest/v1/menu_items")
    suspend fun getMenuItems(): Response<List<MenuItemResp>>

}
