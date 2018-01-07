package pl.marcinwatroba.efloverkotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import pl.marcinwatroba.efloverkotlin.dao.BasketDao
import pl.marcinwatroba.efloverkotlin.dao.ProductDao
import pl.marcinwatroba.efloverkotlin.model.Produkt

/**
 * Created by Marcin
 */


@Controller
class ProductsController {


    @RequestMapping("/")
    fun showProductsList(model: Model,
                         @RequestParam("productToAdd", defaultValue = "") productToAdd: String,
                         @RequestParam("countToAdd", defaultValue = "1") countToAdd: String): String {

        if (productToAdd != "") {
            BasketDao.addToBasket(productToAdd.toInt(), countToAdd.toInt())
            model.addAttribute("added", "Produkt został dodany do koszyka")
        } else model.addAttribute("added", "")

        return getProductListView(model)
    }

    fun getProductListView(model: Model): String {
        model.addAttribute("products", ProductDao.getAllProducts())
        return "offer"
    }

}