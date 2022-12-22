package app.bersama;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class DriverManager {

    // implements design pattern singleton and thread local
    private static final DriverManager instance = new DriverManager();

    ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return instance;
    }

    public AndroidDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AndroidDriver androidDriver) {
        driver.set(androidDriver);
    }

    public void removeDriver() {
        driver.remove();
    }
}
