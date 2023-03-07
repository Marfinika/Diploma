package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.SQLHelper;
import org.junit.jupiter.api.*;
import page.TourPage;

import static com.codeborne.selenide.Selenide.open;

public class Positive {
    @BeforeAll
    static void setUpAll(){
        SelenideLogger.addListener("allure", new AllureSelenide());

    }
    @AfterAll
    static void downAll(){
        SelenideLogger.removeListener("allure");

    }

    @BeforeEach
    public void openChrome(){
        open("http://localhost:8080/");
    }

    @DisplayName("Successful purchase.")
    @Test
    public void successfulCardPurchase(){
        var tourPage = new TourPage();
        var payCard = tourPage.payCard();
        var approvedCardInformation = ru.netology.data.DataHelper.getValidCard();
        payCard.enterCardData(approvedCardInformation);
        payCard.successfulCardPayment();

        var paymentId = SQLHelper.getPaymentId();
        var statusPayment = SQLHelper.getStatusPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusPayment);
    }

    @DisplayName("Successful credit purchase.")
    @Test
    public void  shouldConfirmCredit(){
        var tourPage = new TourPage();
        var buyCredit = tourPage.buyCredit();
        var approvedCardInformation = ru.netology.data.DataHelper.getValidCard();
        buyCredit.enterCreditCardData(approvedCardInformation);
        buyCredit.successfulCreditCardPayment();

        var paymentId = SQLHelper.getPaymentId();
        var statusPayment = SQLHelper.getStatusPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusPayment);
    }


}
