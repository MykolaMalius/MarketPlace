package com.epam.lab.utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SingletonDriver {
    static final Logger LOG = Logger.getLogger(SingletonDriver.class);
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private SingletonDriver() {
    }
    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        WebDriver instance;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        EnvProperties envProperties = new EnvProperties();
        instance = new ChromeDriver();
        instance.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        instance.manage().window().maximize();
        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }
    public static void quit(){
        try{
            webDriverThreadLocal.get().quit();
        }
        finally {
            webDriverThreadLocal.remove();
        }
    }
}
