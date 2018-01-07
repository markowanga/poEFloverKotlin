package pl.marcinwatroba.efloverkotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import pl.marcinwatroba.efloverkotlin.dao.AddressDao
import pl.marcinwatroba.efloverkotlin.dao.BasketDao

/**
 * Created by Marcin
 */

@Controller
class BasketController {

    /**
     * Pokazuje zawartość koszyka
     * Może zmienić ilosć elementów danego produktu, albo go usunąć w zależności od parametrów
     */
    @RequestMapping("/basket")
    fun showProductsList(model: Model,
                         @RequestParam("productToChange", defaultValue = "") productToChange: String,
                         @RequestParam("countToChange", defaultValue = "") countToChange: String,
                         @RequestParam("productToRemove", defaultValue = "") productToRemove: String): String {

        var log = ""

        if (productToChange != "") {
            log = "Ilość sztuk w koszyku została zmieniona"
        }

        if (productToRemove != "") {
            log = "Produkt został usunięty z koszyka"
        }

        model.addAttribute("log", log)

        return getBasketListView(model)
    }

    fun getBasketListView(model: Model): String {
        model.addAttribute("koszyk", BasketDao.getBasket())
        return "basket"
    }

    @RequestMapping("/basketSummary")
    fun showBasketSummary(model: Model): String = getBasketSummaryView(model)

    fun getBasketSummaryView(model: Model): String {
        val basket = BasketDao.getBasket()
        model.addAttribute("koszyk", basket)
        model.addAttribute("koszykInd", List(basket.produktWKoszykuList.size, { index -> index }))
        model.addAttribute("addresses", AddressDao.getAddressList())

        return "basketSummary"
    }

}