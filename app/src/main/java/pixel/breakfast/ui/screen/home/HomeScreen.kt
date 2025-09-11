package pixel.breakfast.ui.screen.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Text("Hi My Sweet Home Screen")
}

/* ---------- Preview ---------- */
@Preview(showBackground = true, name = "HomeScreen")
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
