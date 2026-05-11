package com.main.myassignment.presentation.favorites

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.main.myassignment.presentation.post.PostViewModel
import com.main.myassignment.presentation.theme.color.LocalAppExtendedColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(vm: PostViewModel = hiltViewModel()) {

    val colors = LocalAppExtendedColor.current
//    val favorites by vm.favorites.collectAsStateWithLifecycle()
    val favorites by vm.favorites.collectAsStateWithLifecycle(
        initialValue = emptyList()
    )


    LaunchedEffect(favorites) {
        Log.d("DBMAIN" ,"Favorites changedzsss: ${favorites.size}")
    }
    LaunchedEffect(Unit) {
        snapshotFlow { favorites }
            .collect {
                Log.d("DBMAIN", "Favorites changed: ${it.size}")
            }
    }
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {


        items(
            items = favorites,
            key = { it.id }
        ) { item ->
            val dismissState = rememberSwipeToDismissBoxState(
                confirmValueChange = {
                    vm.toggle(item)
                    true
                }
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
                        AppText(
                            text = "Delete",
                            style = AppTextStyle.h5Bold(Color.White),
                            modifier = Modifier.padding(end = 20.dp)
                        )
                    }
                },
                content = {
                    PostCard(item) {
                        vm.toggle(item)
                    }
                }

            )
            LaunchedEffect(dismissState.currentValue) {
                if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) {
                    vm.toggle(item)
                }
            }

        }
    }
}