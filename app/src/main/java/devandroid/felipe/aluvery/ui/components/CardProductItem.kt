package devandroid.felipe.aluvery.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import devandroid.felipe.aluvery.R
import devandroid.felipe.aluvery.extensions.toBrazilianCurrency
import devandroid.felipe.aluvery.model.ProductModel
import devandroid.felipe.aluvery.sampledata.sampleProducts
import devandroid.felipe.aluvery.ui.theme.AluveryTheme

@Composable
fun CardProductItem(
    product: ProductModel,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp
) {
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = CardDefaults.cardElevation(elevation),
    ) {
        var expanded by remember { mutableStateOf(false) }
        Column(
            Modifier.clickable { expanded = !expanded }
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "Imagem do produto",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(16.dp)
            ) {
                Text(text = product.name)
                Text(text = product.price.toBrazilianCurrency())
            }
            product.description?.let {
                when (expanded) {
                    true -> {
                        Text(
                            text = it,
                            Modifier.padding(16.dp),
                        )
                    }

                    else -> {
                        Text(
                            text = it,
                            Modifier.padding(16.dp),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(sampleProducts.random())
        }
    }
}