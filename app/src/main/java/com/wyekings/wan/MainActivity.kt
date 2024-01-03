package com.wyekings.wan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.wyekings.wan.ui.theme.WanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen().apply { setKeepOnScreenCondition { true } }
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            WanTheme {
                WanApp()
            }
        }
        window.decorView.post { splashScreen.setKeepOnScreenCondition { false } }
    }
}