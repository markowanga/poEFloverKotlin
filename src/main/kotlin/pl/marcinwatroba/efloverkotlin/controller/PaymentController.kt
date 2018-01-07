package pl.marcinwatroba.efloverkotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import pl.marcinwatroba.efloverkotlin.EmailSender
import pl.marcinwatroba.efloverkotlin.dao.OrderDao

/**
 * Created by Marcin
 */

@Controller
class PaymentController {

    @RequestMapping("/prepareDataToTransfer")
    fun prepareDataToTransfer(model: Model, @RequestParam("orderId", defaultValue = "") orderId: String): String {

        EmailSender.sendTransferPaymentDetails(OrderDao.getZamowienigetOrderById(1))
        model.addAttribute("orderId", orderId)
        return "sendTransferDetails"
    }

    @RequestMapping("/payByCard")
    fun payByCard(model: Model, @RequestParam("orderId", defaultValue = "") orderId: String): String {

        EmailSender.sendCardPaymentConform(OrderDao.getZamowienigetOrderById(1))
        model.addAttribute("orderId", orderId)
        return "paymentCardForm"
    }

    @RequestMapping("/payByCash")
    fun payByCash(model: Model, @RequestParam("orderId", defaultValue = "") orderId: String): String {

        EmailSender.sendTransferPaymentDetails(OrderDao.getZamowienigetOrderById(1))
        model.addAttribute("orderId", orderId)
        return "orderAddedCash"
    }

    /**
     * Executes payment by credit card
     */
    @RequestMapping("/executePaymentCard")
    fun executeCardPayment(model: Model,
                           @RequestParam("orderId", defaultValue = "") orderId: String,
                           @RequestParam("cardType", defaultValue = "") cardType: String,
                           @RequestParam("number", defaultValue = "") cardNumber: String,
                           @RequestParam("date", defaultValue = "") date: String,
                           @RequestParam("cvv", defaultValue = "") cvv: String): String {

        model.addAttribute("orderId", orderId)
        return "afterCardPayment"
    }

}
