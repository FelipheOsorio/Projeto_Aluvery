package devandroid.felipe.aluvery.sampledata

import devandroid.felipe.aluvery.R
import devandroid.felipe.aluvery.model.ProductModel
import java.math.BigDecimal


val sampleData = listOf(
    ProductModel(
        name = "Hamburguer",
        price = BigDecimal("19.99"),
        image = R.drawable.burger
    ),
    ProductModel(
        name = "Pizza",
        price = BigDecimal("59.99"),
        image = R.drawable.pizza
    ),
    ProductModel(
        name = "Batata Frita",
        price = BigDecimal("9.99"),
        image = R.drawable.fries
    )
)