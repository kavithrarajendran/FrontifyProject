package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.InitElement;
//import java.io.IOException;
//import java.net.URL;
public class Base {
        @Getter
        public static WebDriver driver;


        public Base() {
        }

        public void setDriver(WebDriver driver) {
            this.driver = driver;
        }


        @BeforeClass
        @Parameters({"browser"})
        public void setUp(@Optional("browser") String browser) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                new InitElement(driver);
            } else if (browser.equalsIgnoreCase("headless-chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless");
                option.addArguments("window-size=1920,1080");
                option.addArguments("--disable-gpu");
                option.addArguments("--no-sandbox");
                option.addArguments("--ignore-certificate-errors");
                option.addArguments("--remote-debugging-port=5050");
                driver = new ChromeDriver(option);
                driver.manage().window().maximize();
                new InitElement(driver);
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                new InitElement(driver);
            } else if (browser.equalsIgnoreCase("msedge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                new InitElement(driver);
            }
        }

        @AfterClass
        public void tearDown() throws InterruptedException {
            Thread.sleep(2500);
            driver.quit();
        }
    };
