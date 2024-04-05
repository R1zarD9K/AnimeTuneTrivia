package com.d3if3136.animetunetrivia.ui.theme.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.d3if3136.animetunetrivia.ui.theme.screen.AboutScreen
import com.d3if3136.animetunetrivia.ui.theme.screen.HomeScreen
import com.d3if3136.animetunetrivia.ui.theme.screen.PlayActivity
import com.d3if3136.animetunetrivia.ui.theme.screen.getRoute

@Composable
fun MainApp(){
    val context = LocalContext.current
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp
    Log.e("ScreenSize", screenHeight.toString() + " "+ screenWidth)
    val isSmallPhone = (screenHeight * screenWidth) < 300000
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = getRoute() ){
        composable(getRoute()){
            HomeScreen(navController){
                navController.navigate(PlayActivity.getRoute()) }
        }
        composable(PlayActivity.getRoute()){
            PlayActivity.PlayScreen(context, isSmallPhone, navController)
        }
        composable("AboutScreen"){
            AboutScreen(navController)
        }
    }
}