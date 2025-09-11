package pixel.breakfast.ui.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import pixel.breakfast.R
import pixel.breakfast.ui.theme.UiConstants

@Composable
fun HomeHeader(
    username: String,
    @DrawableRes avatarResId: Int? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(
                horizontal = dimensionResource(R.dimen.home_header_padding_horizontal),
                vertical = dimensionResource(R.dimen.home_header_padding_vertical)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(UiConstants.HOME_HEADER_WEIGHT)
                .padding(end = dimensionResource(R.dimen.home_header_padding_end))
        ) {
            // ============ name ============
            Text(
                text = stringResource(R.string.home_header_greeting, username),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                maxLines = UiConstants.SINGLE_LINE,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.home_header_greeting_spacer)))
            // ============ greeting ============
            Text(
                text = stringResource(R.string.home_header_greeting_morning),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = UiConstants.SINGLE_LINE,
                overflow = TextOverflow.Ellipsis
            )
        }

        // ============ avatar img ============
        if (avatarResId != null) {
            Image(
                painter = painterResource(id = avatarResId),
                contentDescription = "User avatar",
                modifier = Modifier
                    .size(dimensionResource(R.dimen.home_header_img_size))
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.size(dimensionResource(R.dimen.home_header_img_size))

            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = username.firstOrNull()?.uppercaseChar()?.toString() ?: "",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Preview(
    name = "No Avatar",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun PreviewHomeHeader_NoAvatar() {
    MaterialTheme {
        Surface {
            HomeHeader(
                username = "John",
                avatarResId = null,
            )
        }
    }
}
