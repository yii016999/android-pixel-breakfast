package pixel.breakfast.ui.util

import pixel.breakfast.BuildConfig

object SupabaseImageUrl {
    private val base = BuildConfig.SUPABASE_URL.trimEnd('/')
    private val bucket = BuildConfig.SUPABASE_BUCKET_MENU.trim('/')

    fun public(path: String): String {
        val p = path.trim().trimStart('/')
        return "$base/storage/v1/object/public/$bucket/$p"
    }
}
