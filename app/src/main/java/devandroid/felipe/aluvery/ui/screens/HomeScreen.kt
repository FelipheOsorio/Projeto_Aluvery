package devandroid.felipe.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import devandroid.felipe.aluvery.model.ProductModel
import devandroid.felipe.aluvery.sampledata.sampleProducts
import devandroid.felipe.aluvery.sampledata.sampleSections
import devandroid.felipe.aluvery.ui.components.CardProductItem
import devandroid.felipe.aluvery.ui.components.ProductSection
import devandroid.felipe.aluvery.ui.components.SearchTextField
import devandroid.felipe.aluvery.ui.theme.AluveryTheme


@Composable
fun HomeScreen(sections: Map<String, List<ProductModel>>) {
    Column {
        var textValue by remember { mutableStateOf("") }

        SearchTextField(searchText = textValue, onSearchTextChanged = { textValue = it })

        val searchedProducts = remember(textValue) {
            if (textValue.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(textValue, true) ||
                            product.description?.contains(textValue, true) ?: false
                }
            } else emptyList()
        }

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when {
                textValue.isBlank() -> {
                    items(sections.toList()) { section ->
                        val title = section.first
                        val product = section.second

                        ProductSection(title = title, products = product)
                    }
                }

                else -> {
                    items(searchedProducts) { p ->
                        CardProductItem(product = p, Modifier.padding(horizontal = 16.dp))
                    }
                }
            }


        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}