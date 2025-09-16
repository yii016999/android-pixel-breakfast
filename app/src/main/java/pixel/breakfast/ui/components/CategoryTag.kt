package pixel.breakfast.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryTag(
    label: String,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    val bgColor = if (selected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }
    val contentColor = if (!selected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }
    val border = if (!selected) {
        BorderStroke(0.dp, bgColor)
    } else {
        BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline)
    }

    val shape = RoundedCornerShape(10.dp)

    Surface(
        modifier = Modifier
            .padding(start = 8.dp)
            .clip(shape)
            .clickable(onClick = onClick),
        shape = shape,
        color = bgColor,
        contentColor = contentColor,
        border = border,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
    ) {
        Box(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)) {
            // ====== title ======
            Text(text = label, style = MaterialTheme.typography.labelMedium)
        }
    }
}

@Preview(showBackground = true, name = "CategoryTag – normal")
@Composable
private fun PreviewCategoryTag_Normal() {
    MaterialTheme {
        Row {
            CategoryTag(label = "漢堡")
            CategoryTag(label = "飲料", selected = true)
        }
    }
}
