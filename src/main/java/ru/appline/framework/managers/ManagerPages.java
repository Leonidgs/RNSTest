package ru.appline.framework.managers;

import ru.appline.framework.pages.*;

/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления страничками
 */
public class ManagerPages {

    /**
     * Менеджер страничек
     */
    private static ManagerPages managerPages;
    /**
     * Стартовая страничка
     */
    FirstPage firstPage;
    /**
     * Страничка вкладов
     */
    DepositPage depositPage;

    /**
     * Конструктор специально запривейтили (синглтон)
     * @see ManagerPages#getManagerPages()
     */
    private ManagerPages() {
    }

    /**
     * Ленивая инициализация ManagerPages
     *
     * @return ManagerPages
     */
    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    public FirstPage getFirstPage() {
        if (firstPage == null) {
            firstPage = new FirstPage();
        }
        return firstPage;
    }

    public DepositPage getDepositPage() {
        if (depositPage == null) {
            depositPage = new DepositPage();
        }
        return depositPage;
    }
}
