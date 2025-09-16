package pixel.breakfast.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pixel.breakfast.R
import pixel.breakfast.domain.model.MenuItem
import pixel.breakfast.domain.model.enum.MenuCategoryEnum

@SuppressLint("LocalContextResourcesRead")
@Composable
fun MenuItemCard(
    item: MenuItem,
    modifier: Modifier = Modifier,
    onAddClick: (MenuItem) -> Unit = {},
) {
    OutlinedCard(
        modifier = modifier.aspectRatio(0.75f),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // ============ title ============
            Text(
                text = item.displayName,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // ============ image ============
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "Menu Item ${item.id}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(92.dp)
            )

            // ============ price ============
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.offset(x = (-8).dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_currency),
                    contentDescription = "Currency",
                    modifier = Modifier
                        .size(16.dp)
                )
                Text(
                    text = item.price.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // ============ add button ============
            Button(
                onClick = { onAddClick(item) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50)
            ) { Text("+ Add") }
        }
    }
}

@Preview(name = "MenuItemCard (clean)", showBackground = true, widthDp = 180)
@Composable
private fun PreviewMenuItemCard() {
    MaterialTheme {
        MenuItemCard(
            item = MenuItem(
                id = "set-001",
                category = MenuCategoryEnum.SET,
                displayName = "測試商品名稱",
                price = 10,
                imageUrl = ""
            ),
            modifier = Modifier.width(160.dp)
        )
    }
}