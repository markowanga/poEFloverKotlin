package pl.marcinwatroba.efloverkotlin.dao

import pl.marcinwatroba.efloverkotlin.model.Koszyk
import pl.marcinwatroba.efloverkotlin.model.Produkt
import pl.marcinwatroba.efloverkotlin.model.ProduktWKoszyku

/**
 * Created by Marcin
 */
object BasketDao {

    fun addToBasket(productId: Int, count: Int) {

    }

    fun removeFromBasket(productId: Int) {

    }

    fun changeCount(productId: Int) {

    }

    fun clearBasket() {

    }

    fun getBasket(): Koszyk {
        val products = mutableListOf<ProduktWKoszyku>()
        products.add(ProduktWKoszyku(Produkt(1, "Kosz 100 róż", 399.90f, "/images/50roz.jpg", "D1"),1))
        products.add(ProduktWKoszyku(Produkt(1, "Kosz 50 róż", 299.90f, "/images/50roz.jpg", "D1"), 2))
        return Koszyk(products)
    }
}