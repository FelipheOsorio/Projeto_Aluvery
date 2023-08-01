package devandroid.felipe.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import devandroid.felipe.aluvery.model.ProductModel
import devandroid.felipe.aluvery.sampledata.sampleData


@Composable
fun ProductSection(title: String, products: List<ProductModel>) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight(400),
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
        )
        Row(
            Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

            ) {
            Spacer(Modifier)
            for(p in products) {
                ProductItem(product = p)
            }
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    ProductSection(title = "Promoções", sampleData)
}