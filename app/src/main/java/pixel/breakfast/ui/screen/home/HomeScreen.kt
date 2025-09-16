package pixel.breakfast.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pixel.breakfast.data.MockMenu
import pixel.breakfast.domain.model.enum.MenuCategoryEnum
import pixel.breakfast.ui.components.MenuItemCard

@Composable
fun HomeScreen(state: HomeUiState) {
    val gridState = rememberLazyGridState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // ============ floating button ============
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // ============ banner ============
            // ============ category row ============
            // ============ items grid (2 columns) ============
            LazyVerticalGrid(
                state = gridState,
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(
                    bottom = 30.dp + padding.calculateBottomPadding()
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(state.items, key = { it.id }) { item ->
                    MenuItemCard(
                        item = item,
                        onAddClick = { },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

/* ---------- Preview ---------- */
@Preview(showBackground = true, name = "HomeScreen")
@Composable
private fun HomeScreenPreview() {
    val fakeState = HomeUiState(
        selectedCategory = MenuCategoryEnum.SET,
        items = MockMenu.items.filter { it.category == MenuCategoryEnum.SET },
    )
    HomeScreen(fakeState)
}
