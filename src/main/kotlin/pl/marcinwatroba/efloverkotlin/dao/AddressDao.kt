package pl.marcinwatroba.efloverkotlin.dao

import pl.marcinwatroba.efloverkotlin.model.Adres

/**
 * Created by Marcion
 */
object AddressDao {

    fun getAddressList(): List<Adres> {
        val addresses = mutableListOf<Adres>()
        addresses.add(Adres(1, "Matejki", "33b", "Kaczyce", "43-417"))
        addresses.add(Adres(2, "Sienkiewicza", "88/2", "Wrocław", "43-417"))
        return addresses
    }

    fun getAddressById(id: Int): Adres {
        return Adres(2, "Sienkiewicza", "88/2", "Wrocław", "43-417");
    }
}