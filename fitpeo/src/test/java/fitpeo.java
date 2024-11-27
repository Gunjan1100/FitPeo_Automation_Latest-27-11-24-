import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class fitpeo {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1) 1.	Navigate to the FitPeo Homepage:

        driver.get("https://www.fitpeo.com/");


        // 2) 2.	Navigate to the Revenue Calculator Page:

        WebElement revnue_calc = driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",revnue_calc);
        Thread.sleep(5000);

        // 3) 3.	Scroll Down to the Slider section:

        WebElement slider_visible = driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']"));
        js.executeScript("arguments[0].scrollIntoView()", slider_visible);
        js.executeScript("return window.pageYOffset");

        // 4) 4.	Adjust the Slider:

        WebElement slider_position = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']"));
        Actions act = new Actions(driver);
        act.dragAndDropBy(slider_position, 93, 0);
         Thread.sleep( 2000);

        //    5)   5.	Update the Text Field:

        WebElement textBox_value = driver.findElement(By.xpath("//div[@class = 'MuiFormControl-root MuiTextField-root css-1s5tg4z']"));
        Thread.sleep(2000);
        act.moveToElement(textBox_value).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        Thread.sleep(5000);
        act.sendKeys(textBox_value,"560").build().perform();

        //   6)  6.	Validate Slider Value:

        // Slider value to be 560 - Taken Screenshot at slidervalidation

        Thread.sleep(5000);
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        File src1 = ts1.getScreenshotAs(OutputType.FILE);
        File trg1 = new File(".//src/test/resources/screenshot//slidervalidation.png");
        FileUtils.copyFile(src1,trg1);

        // 7)  7.	Select CPT Codes:

        WebElement checkbox_99091 = driver.findElement(By.xpath("//span[text() = '57']"));
        checkbox_99091.click();
        WebElement checkbox_99453 = driver.findElement(By.xpath("//span[text() = '19.19']"));
        checkbox_99453.click();
        WebElement checkbox_99454 = driver.findElement(By.xpath("//span[text() = '63']"));
        checkbox_99454.click();
        WebElement checkbox_99474 = driver.findElement(By.xpath("//span[text() = '15']"));
        checkbox_99474.click();

        // 8) Validate Total Recurring Reimbursement:

        WebElement tot_RecurringReimbursement = driver.findElement(By.xpath("//div[@class='MuiBox-root css-19zjbfs']"));
        js.executeScript("arguments[0].scrollIntoView()", tot_RecurringReimbursement);
        js.executeScript("return window.pageYOffset");

        // validation taken screenshot at recurring.png

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".//src/test/resources/screenshot//recurring.png");
        FileUtils.copyFile(src,trg);

       // 9) 9.	Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month:  problem

        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement textBoxValue_reEnter = driver.findElement(By.xpath("//div[@class = 'MuiFormControl-root MuiTextField-root css-1s5tg4z']"));
        Thread.sleep(2000);
        act.moveToElement(textBoxValue_reEnter).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        Thread.sleep(5000);
        act.sendKeys(textBoxValue_reEnter,"200").build().perform();



       List<WebElement> checkboxes = driver.findElements(By.xpath("//span[@class = 'MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt']"));
        for(WebElement chkbox : checkboxes)
        {
            chkbox.click();
        }
             WebElement chbox37 = driver.findElement(By.xpath("//span[text() = '37']"));
        js.executeScript("arguments[0].click()",chbox37);

        WebElement chkbox46 = driver.findElement(By.xpath("//span[text() = '46']"));
        js.executeScript("arguments[0].click()",chkbox46);
        js.executeScript("arguments[0].click()",checkbox_99091);
        js.executeScript("arguments[0].click()",checkbox_99453);
        js.executeScript("arguments[0].click()",checkbox_99474);
        js.executeScript("arguments[0].click()",checkbox_99454);


//   Verification taken screenshot at total_recurring.png

        TakesScreenshot ts2 = (TakesScreenshot) driver;
        File src2 = ts.getScreenshotAs(OutputType.FILE);
        File trg2 = new File(".//src/test/resources/screenshot//total_recurring.png");
        FileUtils.copyFile(src2,trg2);

    } }






