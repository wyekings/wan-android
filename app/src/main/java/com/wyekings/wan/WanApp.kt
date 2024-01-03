package com.wyekings.wan

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.DestinationsNavHost
import com.wyekings.wan.screens.NavGraphs

@Composable
fun WanApp() {
    DestinationsNavHost(navGraph = NavGraphs.root)
}