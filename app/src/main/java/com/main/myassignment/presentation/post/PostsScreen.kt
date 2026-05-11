package com.main.myassignment.presentation.post

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.main.myassignment.core.customComponent.LoadingView
import com.main.myassignment.core.customComponent.media.AppImage
import com.main.myassignment.core.customComponent.media.model.AppImageStyle
import com.main.myassignment.core.customComponent.text.AppText
import com.main.myassignment.core.customComponent.text.model.AppTextStyle
import com.main.myassignment.core.util.UiState
import com.main.myassignment.domain.model.Post
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.main.myassignment.presentation.theme.color.LocalAppExtendedColor


@Composable
fun PostsScreen(vm: PostViewModel = hiltViewModel()) {
    val state = vm.posts.collectAsStateWithLifecycle().value
    when (state) {
        is UiState.Loading -> {
            LoadingView()
        }
        is UiState.Success -> {
            LazyColumn(
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    items = state.data,
                    key = { it.id }
                ) { post ->

                    PostCard(
                        post = post,
                        onLikeClick = {
                            vm.toggle(post)
                        }
                    )
                }
            }
        }
        is UiState.Error -> {
            Text(text = state.message)
        }
    }
}

@Composable
fun PostCard(post: Post, onLikeClick: () -> Unit) {

    val colors = LocalAppExtendedColor.current

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colors.backgroundPrimary),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column {

            // 🖼 IMAGE
            AppImage(
                source = "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                style = AppImageStyle(contentScale =ContentScale.FillBounds )
            )

            Column(modifier = Modifier.padding(12.dp)) {

                AppText(
                    text = post.title,
                    style = AppTextStyle.h5Bold(colors.contentPrimary)
                )

                Spacer(Modifier.height(6.dp))

                AppText(
                    text = post.body,
                    style = AppTextStyle.bodyRegular(colors.contentSecondary),
                    maxLines = 3
                )

                Spacer(Modifier.height(12.dp))

                // ❤️ COMMENT SHARE ROW
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        ActionIcon(
                            icon = if (post.isFavorite) "❤️" else "🤍",
                            tint = if (post.isFavorite) Color.Red else colors.contentSecondary,
                            onClick = { onLikeClick() }
                        )

                        ActionIcon(icon = "💬", tint = colors.contentSecondary)

                        ActionIcon(icon = "🔗", tint = colors.contentSecondary)
                    }
                }
            }
        }
    }
}
@Composable
fun ActionIcon(
    icon: String,
    tint: Color,
    onClick: (() -> Unit)? = null
) {
    AppText(
        text = icon,
        style = AppTextStyle.bodyBold(tint),
        modifier = Modifier.clickable(enabled = onClick != null) {
            onClick?.invoke()
        }
    )
}