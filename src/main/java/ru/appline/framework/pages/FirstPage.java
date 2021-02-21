package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FirstPage extends BasePage {

    @FindBy(xpath = "//a[@class='service__title-action']")
    List<WebElement> menuList;

    //Выбор вклады
    @Step("Переход в главное меню {name}")
    public DepositPage selectMenuByName(String name) {

        for (WebElement elem3 : menuList) {
            //System.out.println(elem3.findElement(By.xpath("./preceding-sibling::div")).getText());
            if (elem3.findElement(By.xpath("./preceding-sibling::div")).getText().equalsIgnoreCase(name)) {
                elem3.click();
                return app.getDepositPage();
            }
        }
        /*menuList.stream()
                .filter(element -> {
                    if (element.findElement(By.xpath("./preceding-sibling::div")).getText().equalsIgnoreCase(name)) {
                        element.click();
                    }
                    System.out.println("ffddf");
                    return true;
                });*/
        Assert.fail("Элемент" + name + "' не был найден на стартовой странице!");
        return app.getDepositPage();
    }

}
