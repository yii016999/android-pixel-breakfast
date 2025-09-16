package pixel.breakfast.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pixel.breakfast.R
import pixel.breakfast.data.mock.MockMenu
import pixel.breakfast.domain.model.enum.MenuCategoryEnum
import pixel.breakfast.ui.components.CategoryTag
import pixel.breakfast.ui.components.MenuItemCard

@Composable
fun HomeScreen(
    state: HomeUiState,
    onCategoryClick: (MenuCategoryEnum) -> Unit,
) {
    val gridState = rememberLazyGridState()

    LaunchedEffect(state.selectedCategory) {
        gridState.scrollToItem(0)
    }

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
            LazyRow(modifier = Modifier.padding(dimensionResource(R.dimen.home_screen_category_padding_vertical))) {
                items(state.categories) { category ->
                    CategoryTag(
                        label = stringResource(category.labelRes),
                        selected = (category == state.selectedCategory),
                        onClick = { onCategoryClick(category) }
                    )
                }
            }
            // ============ items grid (2 columns) ============
            LazyVerticalGrid(
                state = gridState,
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.home_screen_items_space)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.home_screen_items_space)),
                contentPadding = PaddingValues(
                    bottom = dimensionResource(R.dimen.home_screen_bottom_padding) + padding.calculateBottomPadding()
                ),
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.home_screen_items_padding_horizontal))
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(state.visibleItems, key = { it.id }) { item ->
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
    HomeScreen(
        state = fakeState,
        onCategoryClick = {}
    )
}
