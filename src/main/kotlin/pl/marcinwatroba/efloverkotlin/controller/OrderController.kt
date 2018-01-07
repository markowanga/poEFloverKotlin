package pl.marcinwatroba.efloverkotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import pl.marcinwatroba.efloverkotlin.dao.AddressDao
import pl.marcinwatroba.efloverkotlin.dao.BasketDao
import pl.marcinwatroba.efloverkotlin.dao.OrderDao
import pl.marcinwatroba.efloverkotlin.model.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Marcin
 */

@Controller
class OrderController {

    /**
     * Form is always correct
     *
     * addressRatio used / new
     * selectAddress addressId
     * street
     * number
     * postalCode
     * city
     * paymentRatio online / cash
     */
    @RequestMapping("/createNewOrder")
    fun addOrder(model: Model,
                 @RequestParam("addressRatio", defaultValue = "") addressRatio: String,
                 @RequestParam("addressId", defaultValue = "") addressId: String,
                 @RequestParam("street", defaultValue = "") street: String,
                 @RequestParam("number", defaultValue = "") number: String,
                 @RequestParam("postalCode", defaultValue = "") postalCode: String,
                 @RequestParam("city", defaultValue = "") city: String,
                 @RequestParam("paymentRatio", defaultValue = "") paymentRatio: String): String {

        // create Order object, add to DB
        val adres = if (addressId != "") {
            AddressDao.getAddressById(addressId.toInt())
        } else {
            Adres(1, street, number, city, postalCode)
        }

        val paymentMethod =
                if (paymentRatio == "online")
                    MetodaPlatnosci.online
                else MetodaPlatnosci.przyOdbiorze

        val status =
                if (paymentRatio == "online")
                    StatusZamowienia.oczekujeNaZaplate
                else StatusZamowienia.wPrzygotowaniu

        val zamowienie = Zamowienie(1, BasketDao.getBasket().produktWKoszykuList, adres, Date(), paymentMethod, status)
        OrderDao.addOrder(zamowienie)

        // clear basket
        BasketDao.clearBasket()

        model.addAttribute("orderId", zamowienie.id)

        return if (zamowienie.metodaPlatnosci == MetodaPlatnosci.przyOdbiorze) "orderAddedCash" else "orderAddedOnlinePayment"
    }

    @RequestMapping("/orders")
    fun getOrdersView(model: Model): String {
        model.addAttribute("orders", OrderDao.getAllOrders())
        model.addAttribute("formatter", SimpleDateFormat("yyyy-MM-dd"))
        return "orders"
    }

}