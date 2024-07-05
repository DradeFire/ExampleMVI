package ru.dradefire.examplemvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import ru.dradefire.examplemvi.ui.theme.ExampleMVITheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state by viewModel.state.collectAsState()

            ExampleMVITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = state.title,
                            modifier = Modifier
                                .padding(innerPadding),
                            style = TextStyle(
                                fontSize = 20.sp,
                            ),
                        )
                        Text(
                            text = state.subTitle,
                            modifier = Modifier.padding(innerPadding),
                            style = TextStyle(
                                fontSize = 18.sp,
                            ),
                        )
                        Text(
                            text = state.text,
                            modifier = Modifier.padding(innerPadding),
                            style = TextStyle(
                                fontSize = 14.sp,
                            ),
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(innerPadding),
                            horizontalArrangement = Arrangement.SpaceAround,
                        ) {
                            TextButton(
                                modifier = Modifier
                                    .padding(innerPadding),
                                onClick = {
                                    viewModel.sendUserIntent(UserIntent.KekClick)
                                },
                            ) {
                                Text(text = "KEK")
                            }

                            TextButton(
                                modifier = Modifier
                                    .padding(innerPadding),
                                onClick = {
                                    viewModel.sendUserIntent(UserIntent.LolClick)
                                },
                            ) {
                                Text(text = "LOL")
                            }
                        }
                    }
                }
            }
        }
    }
}

