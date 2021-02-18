package ru.appline.framework.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.appline.framework.basetestsclass.BaseTests;

import static ru.appline.framework.utils.DepositTime.Month12;
import static ru.appline.framework.utils.DepositTime.Month6;

public class FirstTest extends BaseTests {

    @Test()
    @DisplayName("Оформление рублёвого вклада")
    @Description("Демонстрационный e2e сценарий")
    public void startTest() {
        app.getFirstPage()
                .selectMenuByName("Вклады")
                .chooseCurrencyByType("Рубли")
                .setAmountValue("300000")
                .selectDepositTime(Month6)
                .setReplenishValue("50000")
                .turnOnReplenishField("Ежемесячная капитализация")
                .checkRightValueFields("9 132,17")
                .checkReplenishment("250 000")
                .checkToBeWithdrawnAfter("559 132,17");

    }
    @Test()
    @DisplayName("Оформление долларового вклада")
    @Description("Демонстрационный e2e сценарий")
    public void secondTest() {
        app.getFirstPage()
                .selectMenuByName("Вклады")
                .chooseCurrencyByType("Доллары США")
                .setAmountValue("500000")
                .selectDepositTime(Month12)
                .setReplenishValue("30000")//В тест кейсе указано 70к установить, но 30к это макс. значение для поля
                .turnOnReplenishField("Ежемесячная капитализация")
                .checkRightValueFields("1 003,59")
                .checkReplenishment("330 000")
                .checkToBeWithdrawnAfter("831 003,59");
    }

}
