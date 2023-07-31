package devandroid.felipe.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import devandroid.felipe.aluvery.ui.components.ProductSection
import devandroid.felipe.aluvery.ui.theme.AluveryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductSection()
                }
            }
        }
    }
}