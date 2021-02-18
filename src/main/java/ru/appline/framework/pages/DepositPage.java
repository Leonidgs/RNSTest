package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.utils.DepositTime;

import java.util.List;

public class DepositPage extends BasePage{

    @FindBy(xpath = "//span[@class='calculator__currency-field-btn']")
    List<WebElement> depositList;

    @FindBy(xpath = "//input[@type='text' and @name='amount']")
    WebElement amountField;

    @FindBy(xpath = "//select[@class='calculator__slide-input js-slide-value']")
    WebElement selectDepositTime;

    @FindBy(xpath = "//input[@type='text' and @name='replenish']")
    WebElement replenishField;

    @FindBy(xpath = "//label[@class='calculator__check-block']//span//span")
    List<WebElement> additionalOptions;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement accruedPercent;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenishmentValue;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement toBeWithdrawnAfter;

    //Выбираем валюту депозита
    public DepositPage chooseCurrencyByType(String name) {
       for(WebElement elem : depositList) {
            //System.out.println(elem.getAttribute("innerText"));
            if (elem.getAttribute("innerText").equalsIgnoreCase(name)) {
                elem.click();
                return this;
            }
        }
        /*depositList.stream()
                .filter(element -> {
                    if (element.getAttribute("innerText").equalsIgnoreCase(name)) {
                        element.click();
                        return true;
                    }
                    return false;
                });*/
        Assert.fail("Выбрать валюту " + name + " не удалось!");
        return this;
    }
    //Ставим значение депозита
    public DepositPage setAmountValue(String value) {
        amountField.sendKeys(value);
        return this;
    }
    //Выбираем срок депозита
    public DepositPage selectDepositTime(DepositTime time) {
        String value = "";
        switch (time) {
            case Month3: value = "3 месяца";
            break;
            case Month6: value = "6 месяцев";
            break;
            case Month12: value = "12 месяцев";
            break;
            case Month13: value = "13 месяцев";
            break;
            case Month18: value = "18 месяцев";
            break;
        }
        select(selectDepositTime).selectByVisibleText(value);
        return this;
    }
    //Ежемесячно пополняем
    public DepositPage setReplenishValue(String value) {
        replenishField.sendKeys(value);
        return this;
    }
    //Включаем ежемесячную капитализацию
    public DepositPage turnOnReplenishField(String name) {
        for (WebElement elem : additionalOptions) {
            //System.out.println(elem.getText());
            if (elem.getText().equalsIgnoreCase(name)) {
                elem.click();
                return this;
            }
        }
        Assert.fail("Включить поле" + name + "' не удалось!");
        return this;
    }

    public DepositPage checkRightValueFields(String expectedValue) {
        fieldChecker(accruedPercent, expectedValue);
        return this;
    }

    public DepositPage checkReplenishment(String value) {
        fieldChecker(replenishmentValue, value);
        return this;
    }
    /*public DepositPage checkToBeWithdrawnAfter(String value) {
        attributeToBe(toBeWithdrawnAfter, "innerText" ,value);
        System.out.println(toBeWithdrawnAfter.getText());
        if (toBeWithdrawnAfter.getText().equalsIgnoreCase(value)) {
            return this;
        }
        Assert.fail("Ставка " + value + " не была сконфигурирована ");
        return this;
    }*/
    public DepositPage checkToBeWithdrawnAfter(String value) {
        fieldChecker(toBeWithdrawnAfter, value);
        return this;
    }
}
