package com.main.myassignment.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.main.myassignment.core.customComponent.text.AppText
import com.main.myassignment.core.customComponent.text.model.AppTextStyle
import com.main.myassignment.presentation.favorites.FavoritesScreen
import com.main.myassignment.presentation.post.PostViewModel
import com.main.myassignment.presentation.post.PostsScreen
import com.main.myassignment.presentation.theme.color.LocalAppExtendedColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(postViewModel: PostViewModel = hiltViewModel(), onLogout: () -> Unit) {
    val colors = LocalAppExtendedColor.current
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Posts", "Favorites")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {   AppText(
                    text = "Dashboard",
                    style = AppTextStyle.h5Bold(colors.contentPrimary)
                ) },
                actions = {
                    TextButton(onClick = onLogout) {
                        AppText(
                            text = "Logout",
                            style = AppTextStyle.bodyBold(colors.contentLink),
                            modifier = Modifier.clickable { onLogout() }
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            // 🔥 Custom Tabs (modern pill style)
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .background(colors.backgroundSecondary, RoundedCornerShape(16.dp))
                    .padding(4.dp)
            ) {
                tabs.forEachIndexed { index, title ->

                    val isSelected = selectedTab == index

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (isSelected)
                                    colors.backgroundBrand
                                else
                                    Color.Transparent
                            )
                            .clickable { selectedTab = index }
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AppText(
                            text = title,
                            style = AppTextStyle.bodyBold(
                                if (isSelected) Color.White else colors.contentSecondary
                            )
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                when (selectedTab) {
                    0 -> PostsScreen(postViewModel)
                    1 -> FavoritesScreen(postViewModel)
                }
            }
        }
    }

}


