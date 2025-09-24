package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleComTest {

    private WebDriver driver;

    @Test
    void openExampleDotCom() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.get("https://example.com");
        String title = driver.getTitle();
        assertTrue(title.toLowerCase().contains("example"), "Title should contain 'Example'");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
