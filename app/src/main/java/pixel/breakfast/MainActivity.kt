package pixel.breakfast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import pixel.breakfast.ui.navigation.AppNavigation
import pixel.breakfast.ui.theme.PixelBreakfastTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PixelBreakfastTheme {
                AppNavigation()
            }
        }
    }
}
