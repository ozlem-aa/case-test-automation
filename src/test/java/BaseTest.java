import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Constants;
import utils.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ScreenRecorderUtil;

import java.time.Duration;

public class BaseTest {

    WebDriver driver ;

    @BeforeClass
    public void setUp() throws Exception{
        Log.info("Test başlatıldı.");

        switch (Constants.BROWSER) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                Log.fatal(Constants.BROWSER + " tarayıcısı bulunamadı.");
                throw new IllegalArgumentException(Constants.BROWSER + " tarayıcısı bulunamadı.");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ScreenRecorderUtil.startRecord("test-recording");
    }
    @AfterClass
    public void tearDown() throws Exception{
        ScreenRecorderUtil.stopRecord();
        driver.quit();
        Log.info("Test tamamlandı.");
   }

}

