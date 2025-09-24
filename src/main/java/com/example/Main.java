package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        // Headless because Codespaces has no GUI
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");    // Chrome 109+ headless mode
        options.addArguments("--no-sandbox");      // helpful in containers
        options.addArguments("--disable-dev-shm-usage");

        // <-- your requested line (through options overload) -->
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://example.com");
        System.out.println("Title is: " + driver.getTitle());
        driver.quit();
    }
}
