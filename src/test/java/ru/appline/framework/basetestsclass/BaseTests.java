package ru.appline.framework.basetestsclass;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.ManagerPages;

import static ru.appline.framework.managers.InitManager.quitFramework;
import static ru.appline.framework.utils.MyAllureListener.addScreenshot;

public class BaseTests {

    /**
     * Менеджер страничек
     * @see ManagerPages#getManagerPages()
     */
    protected ManagerPages app = ManagerPages.getManagerPages();

    @Before
    public void beforeEach() {
        InitManager.initFramework();
    }

    @AfterClass
    public static void afterEach() {
        addScreenshot();
        quitFramework();
    }
}
