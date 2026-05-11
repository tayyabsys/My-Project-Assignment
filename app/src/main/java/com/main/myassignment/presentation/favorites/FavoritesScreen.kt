package com.main.myassignment.presentation.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.main.myassignment.core.customComponent.text.AppText
import com.main.myassignment.core.customComponent.text.model.AppTextStyle
import com.main.myassignment.presentation.post.PostCard
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.main.myassignment.presentation.post.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(vm: PostViewModel = hiltViewModel()) {
    val favorites by vm.favorites.collectAsStateWithLifecycle(
        initialValue = emptyList()
    )

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {


        items(
            items = favorites,
            key = { it.id }
        ) { item ->
            val dismissState = rememberSwipeToDismissBoxState(
                confirmValueChange = { true }
            )
            SwipeToDismissBox(
                state = dismissState,
                enableDismissFromStartToEnd = false,
                enableDismissFromEndToStart = true,
                backgroundContent = {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red, shape = RoundedCornerShape(20.dp)),
                        contentAlignment = Alignment.CenterEnd,
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(end = 20.dp)
                                .background(
                                    color = Color(0xCCB00020),
                                    shape = RoundedCornerShape(999.dp)
                                )
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                                .clickable(
                                    enabled = dismissState.currentValue == androidx.compose.material3.SwipeToDismissBoxValue.EndToStart
                                ) {
                                    vm.toggle(item)
                                },
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "Delete favorite",
                                tint = Color.White
                            )
                            AppText(
                                text = "Delete",
                                style = AppTextStyle.bodyBold(Color.White)
                            )
                        }
                    }
                },
                content = {
                    PostCard(item) {
                        vm.toggle(item)
                    }
                }

            )
        }
    }
}