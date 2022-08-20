import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewRegistration {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 3);
        driver.get("https://shop.pragmatic.bg/");
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void newAccount() {
        WebElement myAccount = driver.findElement(By.cssSelector("li[class='dropdown']"));
        myAccount.click();

        WebElement registerButton = driver.findElement(By.linkText("Register"));
        registerButton.click();

        WebElement inputFirstName = driver.findElement(By.id("input-firstname"));
        inputFirstName.sendKeys("Delyan");

        WebElement inputLastName = driver.findElement(By.id("input-lastname"));
        inputLastName.sendKeys("Marinov");

        String randomText = RandomStringUtils.randomAlphanumeric(10);
        String randomMail = randomText + "@gmail.com";
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys(randomMail);

        WebElement inputTelephone = driver.findElement(By.id("input-telephone"));
        inputTelephone.sendKeys("0888556677");

        WebElement inputPassword = driver.findElement(By.id("input-password"));
        inputPassword.sendKeys("123456789");

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("123456789");

        WebElement subscribeRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[1]/input")));
        if (!subscribeRadioButton.isSelected()) {
            subscribeRadioButton.click();
        }

        WebElement checkBoxAgree = wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
        checkBoxAgree.click();

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        continueButton.click();

        WebElement FinalText = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        WebElement YourOrderHasBeenPlaced = driver.findElement(By.cssSelector("h1"));

        WebElement proceedButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/a"));
        proceedButton.click();

    }
}
