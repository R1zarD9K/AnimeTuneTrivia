package com.d3if3136.animetunetrivia.ui.theme.screen

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.d3if3136.animetunetrivia.R
import com.d3if3136.animetunetrivia.Constant
import com.d3if3136.animetunetrivia.ui.theme.AnimeTuneTriviaTheme
import com.d3if3136.animetunetrivia.ui.theme.navigation.MainApp

class MainActivity : ComponentActivity() {
    companion object{
        var mediaPlayer : MediaPlayer? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeTuneTriviaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

fun getRoute(): String{
    return Constant.HomeScreen
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, onClickPlay: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("AboutScreen")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = stringResource(id = R.string.about_me),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
        content = { // Add content of the screen here
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(id = R.drawable.home_screen),
                        contentScale = ContentScale.FillBounds
                    ),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .background(Color.White.copy(alpha = 0.5f)),
                    color = colorResource(id = R.color.purple_700),
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 50.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(50.dp))
                Button(
                    onClick = onClickPlay,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(100.dp)
                        .size(60.dp)
                ) {
                    Text(text = stringResource(id = R.string.play))
                }
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    AnimeTuneTriviaTheme {
        HomeScreen(navController = navController, onClickPlay = {})
    }
}