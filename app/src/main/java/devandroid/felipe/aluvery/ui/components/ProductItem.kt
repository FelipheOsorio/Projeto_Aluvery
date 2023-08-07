package devandroid.felipe.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import devandroid.felipe.aluvery.R
import devandroid.felipe.aluvery.extensions.toBrazilianCurrency
import devandroid.felipe.aluvery.model.ProductModel
import devandroid.felipe.aluvery.ui.theme.AluveryTheme
import devandroid.felipe.aluvery.ui.theme.Indigo400
import devandroid.felipe.aluvery.ui.theme.Indigo500
import java.math.BigDecimal


@Composable
fun ProductItem(
    product: ProductModel,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Indigo400,
                                Indigo500,
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                ProductModel(
                    name = LoremIpsum(50).values.first(),
                    price = BigDecimal("14.99")
                )
            )
        }
    }
}