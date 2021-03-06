package ru.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.appline.framework.utils.PropConst.*;


public class DriverManager {

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Переменна для хранения объекта веб дравера
     * @see WebDriver
     */
    public static WebDriver driver;
    DriverManager driverManager = new DriverManager();

    /**
     * Менеджер пропертей
     * @see TestPropManager#getTestPropManager()
     */
    private static TestPropManager props = TestPropManager.getTestPropManager();

    /**
     * Конструктор специально запривейтили (синглтон)
     * @see DriverManager#getDriver()
     */
    private DriverManager() {
    }

    /**
     * Метод инициализирующий веб драйвер
     */
    private static void initDriver() {
        switch (props.getProperty(TYPE_BROWSER)) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", props.getProperty(PATH_GEKO_DRIVER));
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", props.getProperty(PATH_CHROME_DRIVER));
                driver = new ChromeDriver();
        }
    }

    /**
     * Метод ленивой инициализации веб драйвера
     * @return WebDriver - возвращает веб драйвер
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    /**
     * Метод для закрытия сессии драйвера и браузера
     * @see WebDriver#quit()
     */
    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
