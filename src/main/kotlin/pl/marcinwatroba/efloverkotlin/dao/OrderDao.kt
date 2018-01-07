package pl.marcinwatroba.efloverkotlin.dao

import pl.marcinwatroba.efloverkotlin.model.Adres
import pl.marcinwatroba.efloverkotlin.model.MetodaPlatnosci
import pl.marcinwatroba.efloverkotlin.model.StatusZamowienia
import pl.marcinwatroba.efloverkotlin.model.Zamowienie
import java.util.*

/**
 * Created by Marcin
 */
object OrderDao {

    fun addOrder(order: Zamowienie) {

    }

    fun getZamowienigetOrderById(id: Int): Zamowienie {
        val adres = AddressDao.getAddressById(1)
        val paymentMethod = MetodaPlatnosci.online
        val status = StatusZamowienia.oczekujeNaZaplate

        return Zamowienie(1, BasketDao.getBasket().produktWKoszykuList, adres, Date(), paymentMethod, status)
    }

    fun getAllOrders(): List<Zamowienie> {

        val adres = AddressDao.getAddressById(1)
        val list = mutableListOf<Zamowienie>()

        list.add(Zamowienie(1, BasketDao.getBasket().produktWKoszykuList, adres, Date(),
                MetodaPlatnosci.online, StatusZamowienia.oczekujeNaZaplate))
        list.add(Zamowienie(2, BasketDao.getBasket().produktWKoszykuList, adres, Date(),
                MetodaPlatnosci.przyOdbiorze, StatusZamowienia.wPrzygotowaniu))
        list.add(Zamowienie(3, BasketDao.getBasket().produktWKoszykuList, adres, Date(),
                MetodaPlatnosci.karta, StatusZamowienia.oczekujeNaZaplate))
        list.add(Zamowienie(4, BasketDao.getBasket().produktWKoszykuList, adres, Date(),
                MetodaPlatnosci.przelew, StatusZamowienia.oczekujeNaZaplate))
        list.add(Zamowienie(5, BasketDao.getBasket().produktWKoszykuList, adres, Date(),
                MetodaPlatnosci.karta, StatusZamowienia.przygotowana))
        list.add(Zamowienie(6, BasketDao.getBasket().produktWKoszykuList, adres, Date(),
                MetodaPlatnosci.przelew, StatusZamowienia.przygotowana))

        return list
    }
}