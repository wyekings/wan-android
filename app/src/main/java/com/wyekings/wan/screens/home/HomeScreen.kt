package com.wyekings.wan.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.wyekings.wan.screens.destinations.ProfileScreenDestination

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navController: DestinationsNavigator) {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Button(onClick = {
                navController.navigate(ProfileScreenDestination)
            }) {
                Text(text = "profile")
            }
        }
    }
}