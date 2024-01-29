package com.forSkillsTechTest.movies.ui.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.rememberNavController
import com.forSkillsTechTest.movies.ui.molecule.AppNavHost

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeStatusBarTransparent()
        setContent {

            val navController = rememberNavController()
            AppNavHost(navController = navController)
        }
    }

    @Suppress("DEPRECATION")
    fun Activity.makeStatusBarTransparent() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = android.graphics.Color.TRANSPARENT
        }
    }
}


