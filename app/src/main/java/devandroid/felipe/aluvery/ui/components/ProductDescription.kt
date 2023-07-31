package devandroid.felipe.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import devandroid.felipe.aluvery.ui.theme.Purple500

@Composable
fun ProductDescriptionPreview(description: String) {
    Column(
        Modifier
            .background(color = Purple500)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(description, color = Color.White)
    }
}