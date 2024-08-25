import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SoftwareTesterPointAutomation {
    
    // Method to perform navigation bar tests
    public static void navbar(WebDriver driver) {
        // Click on navigation items and verify corresponding headers
        clickAndVerify(driver, "//span[contains(.,'Software Testing Types')]", "//h1[contains(.,'What Is Software Testing ?')]");
        clickAndVerify(driver, "//span[contains(.,'SDLC Types')]", "//h1[contains(.,'What Is SDLC ?')]");
        clickAndVerify(driver, "//span[contains(.,'STLC Types')]", "//h1[contains(.,'What Is STLC ?')]");
        clickAndVerify(driver, "//span[contains(.,'Project Management Types')]", "//h1[contains(.,'What Is Project Management Types ?')]");
        clickAndVerify(driver, "//span[contains(.,'Others')]", "//li[@aria-current='page'][contains(.,'Others')]");
        

        // Toggle dark mode
        driver.findElement(By.id("dark-header")).click();
        driver.findElement(By.cssSelector("label[id=\"dark-toggler\"]")).click();
        
        // Open search bar, search for 'selenium', and verify search result
        driver.findElement(By.xpath("//label[@id='search-toggler']")).click();
        driver.findElement(By.id("search-input")).sendKeys("selenium");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        driver.findElement(By.xpath("//li[contains(.,'Search for: selenium')]")).isDisplayed();
    }

    // Helper method to click on an element and verify presence of another element
    private static void clickAndVerify(WebDriver driver, String elementToClick, String elementToVerify) {
        driver.findElement(By.xpath(elementToClick)).click();
        driver.findElement(By.xpath(elementToVerify)).isDisplayed();
    }

    
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://softwaretesterpoint.blogspot.com/");
            driver.manage().window().maximize();
            
            // Perform navigation bar tests
            navbar(driver);
            System.out.println("navbar test pass");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
