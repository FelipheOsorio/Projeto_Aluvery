package devandroid.felipe.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import devandroid.felipe.aluvery.sampledata.sampleSections
import devandroid.felipe.aluvery.ui.screens.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(
                sampleSections
            )
        }
    }
}
