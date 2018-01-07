package pl.marcinwatroba.efloverkotlin.dao

import pl.marcinwatroba.efloverkotlin.model.Produkt

/**
 * Created by Marcin
 */
object ProductDao {

    fun getProduct(productId: Int): Produkt? {
        return null
    }

    fun getAllProducts(): List<Produkt> {

        val list = mutableListOf<Produkt>()
        list.add(Produkt(0, "Kosz 50 róż", 299.90f, "/images/50roz.jpg", "50 różom nie oprze się żadna kobieta"))
        list.add(Produkt(1, "Białe róże", 79.90f, "/images/bialeRoze.jpg", "Białe kiedy czerwone już nie wystarczają"))
        list.add(Produkt(2, "Bukiet tuipanów", 49.90f, "/images/bukietTulipanow.jpg", "Nie ma kobiet nie lubiących tulipanów"))
        list.add(Produkt(3, "Kryształowy blask", 79.90f, "/images/krysztalowyBlask.jpg", "Białe kiedy czerwone już nie wystarczają"))
        list.add(Produkt(4, "Różnowa wstążka", 89.90f, "/images/rozowaWstazka.jpg", "Białe kiedy czerwone już nie wystarczają"))
        list.add(Produkt(5, "Kwaity dla zakochanych", 119.90f, "/images/kwiatyDlaZakochanych.jpg", "Białe kiedy czerwone już nie wystarczają"))

        return list
    }
}
