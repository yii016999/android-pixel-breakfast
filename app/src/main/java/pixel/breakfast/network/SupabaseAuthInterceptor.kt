package pixel.breakfast.network

import okhttp3.Interceptor
import okhttp3.Response

class SupabaseAuthInterceptor(
    private val anonKey: String,
    private val tokenProvider: (() -> String?) = { null },
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Prefer user token for RLS, fallback to anon key
        val bearer = tokenProvider() ?: anonKey
        val newReq = chain.request().newBuilder()
            .addHeader("apikey", anonKey)
            .addHeader("Authorization", "Bearer $bearer")
            .build()
        return chain.proceed(newReq)
    }
}