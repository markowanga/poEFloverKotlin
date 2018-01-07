package pl.marcinwatroba.efloverkotlin

import pl.marcinwatroba.efloverkotlin.model.Zamowienie
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

/**
 * Created by Marcin
 */
object EmailSender {

    fun sendEmail(sendTo: String, title: String, content: String) {
        // data send from
//        val username = "markowanga@gmail.com"
//        val password = "watroba1"
//
//        // config Google account
//        val props = Properties()
//        props.put("mail.smtp.auth", "true")
//        props.put("mail.smtp.starttls.enable", "true")
//        props.put("mail.smtp.host", "smtp.gmail.com")
//        props.put("mail.smtp.port", "587")
//
//
//        val session = Session.getInstance(props,
//                object : javax.mail.Authenticator() {
//                    protected fun passwordAuthentication(): PasswordAuthentication
//                            = PasswordAuthentication(username, password)
//                })
//
//        try {
//            val message = MimeMessage(session)
//            message.setFrom(InternetAddress("markowanga@gmail.com"))
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(sendTo))
//            message.subject = "Testing Subject"
//            message.setText(content)
//
//            Transport.send(message)
//
//            println("Send email to " + sendTo)
//
//        } catch (e: MessagingException) {
//            error(e)
//        }

    }


    fun sendTransferPaymentDetails(order: Zamowienie) {
        sendEmail("markowanga@gmail.com", "Dane do przelewu za zamówienie #" + order.id, "Tu są dane do przelewu :)")
    }

    fun sendCardPaymentConform(order: Zamowienie) {
        sendEmail("markowanga@gmail.com", "Wykonano płatność kartą a zamówienie #" + order.id, " :)")
    }

}