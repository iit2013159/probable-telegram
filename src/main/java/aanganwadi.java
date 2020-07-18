/*
package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Aanaganwadi {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.blazedemo.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAanaganwadi() throws Exception {
        // Label: Test
        // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1366,625 | ]]
        driver.get("http://164.100.251.19/AanganPublic/APP/Registration.aspx");
        driver.findElement(By.id("ctl00_MainContent_ddldistrict")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddldistrict"))).selectByVisibleText("समस्तीपुर");
        driver.findElement(By.id("ctl00_MainContent_ddldistrict")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlproject")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlproject"))).selectByVisibleText("विद्यापतिनगर");
        driver.findElement(By.id("ctl00_MainContent_ddlproject")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlpanchayat")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlpanchayat"))).selectByVisibleText("बाज़िदपुर");
        driver.findElement(By.id("ctl00_MainContent_ddlpanchayat")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlaangankendra")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlaangankendra"))).selectByVisibleText("Raja chaudhary ka darwaja() - 10221190425");
        driver.findElement(By.id("ctl00_MainContent_ddlaangankendra")).click();
        driver.findElement(By.id("ctl00_MainContent_txthusbandname")).click();
        driver.findElement(By.id("ctl00_MainContent_txthusbandname")).clear();
        driver.findElement(By.id("ctl00_MainContent_txthusbandname")).sendKeys("Dilip mahto");
        driver.findElement(By.id("ctl00_MainContent_txtwifename")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtwifename")).sendKeys("babli devi");
        driver.findElement(By.id("ctl00_MainContent_ddlcategory")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlcategory")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlcategory"))).selectByVisibleText("अति-पिछड़ा (बीसी-1)");
        driver.findElement(By.id("ctl00_MainContent_ddlcategory")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlaadharbelongs"))).selectByVisibleText("पत्नी");
        driver.findElement(By.id("ctl00_MainContent_ddlaadharbelongs")).click();
        driver.findElement(By.id("ctl00_MainContent_txtaadharnumber")).click();
        driver.findElement(By.id("ctl00_MainContent_txtaadharnumber")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtaadharnumber")).sendKeys("432581323673");
        driver.findElement(By.id("ctl00_MainContent_txtMobilenumber")).click();
        driver.findElement(By.id("ctl00_MainContent_txtMobilenumber")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtMobilenumber")).sendKeys("6207247696");
        driver.findElement(By.id("ctl00_MainContent_drp_AccountHolder")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_drp_AccountHolder"))).selectByVisibleText("पत्नी");
        driver.findElement(By.id("ctl00_MainContent_drp_AccountHolder")).click();
        driver.findElement(By.id("ctl00_MainContent_txt_IFSC")).click();
        driver.findElement(By.id("ctl00_MainContent_txt_IFSC")).clear();
        driver.findElement(By.id("ctl00_MainContent_txt_IFSC")).sendKeys("PUNB0MBGB06");
        driver.findElement(By.id("ctl00_MainContent_txt_Account")).click();
        driver.findElement(By.id("ctl00_MainContent_txt_Account")).clear();
        driver.findElement(By.id("ctl00_MainContent_txt_Account")).sendKeys("39480131036934");
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct")).click();
        driver.findElement(By.id("ctl00_MainContent_txt_Account")).click();
        driver.findElement(By.id("ctl00_MainContent_txt_Account")).clear();
        driver.findElement(By.id("ctl00_MainContent_txt_Account")).sendKeys("39480131036054");
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct")).click();
        driver.findElement(By.id("ctl00_MainContent_txt_Account")).click();
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct")).click();
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct")).sendKeys("39480131036054");
        driver.findElement(By.id("ctl00_MainContent_txtPassword")).click();
        driver.findElement(By.id("ctl00_MainContent_txtPassword")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtPassword")).sendKeys("1234");
        driver.findElement(By.id("ctl00_MainContent_txtRePass")).click();
        driver.findElement(By.id("ctl00_MainContent_txtRePass")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtRePass")).sendKeys("1234");
        driver.findElement(By.id("ctl00_MainContent_txtRePass")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_txt_ChildName")).click();
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_txt_ChildName")).clear();
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_txt_ChildName")).sendKeys("aarushi kumari");
        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Age"))).selectByVisibleText("2015");
        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Age"))).selectByVisibleText("2016");
        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Age"))).selectByVisibleText("2017");
        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Gender"))).selectByVisibleText("लड़की");
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Age")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Age"))).selectByVisibleText("2019");
        driver.findElement(By.cssSelector("td.footerbtn")).click();
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Active")).click();
        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Active"))).selectByVisibleText("Yes");
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Active")).click();
        driver.findElement(By.cssSelector("td.footerbtn")).click();
        driver.findElement(By.cssSelector("td.footerbtn")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div")).click();
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).click();
        driver.findElement(By.id("ctl00_MainContent_chkDeclaration")).click();
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div | ]]
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div/span")).click();
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div/span")).click();
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).click();
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).sendKeys("ZC8R");
        driver.findElement(By.xpath("//div[@id='contentSection']/div/div[2]/div/div/div/div/div[8]/div/span")).click();
        driver.findElement(By.id("ctl00_MainContent_btnLogin")).click();
        driver.findElement(By.linkText("Print")).click();
        driver.findElement(By.cssSelector("#contentSection > div.row")).click();
        driver.findElement(By.linkText("Click Here to Continue...")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [openWindow |  | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
        driver.findElement(By.id("ctl00_MainContent_txtAadhar")).click();
        driver.findElement(By.id("ctl00_MainContent_txtAadhar")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtAadhar")).sendKeys("432581323673");
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
        driver.findElement(By.id("ctl00_MainContent_txt_Mobile")).click();
        driver.findElement(By.id("ctl00_MainContent_txt_Mobile")).clear();
        driver.findElement(By.id("ctl00_MainContent_txt_Mobile")).sendKeys("6207247696");
        driver.findElement(By.id("ctl00_MainContent_txtPassword")).click();
        driver.findElement(By.id("ctl00_MainContent_txtPassword")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtPassword")).sendKeys("1234");
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).click();
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).clear();
        driver.findElement(By.id("ctl00_MainContent_txtCaptha")).sendKeys("JCZ4");
        driver.findElement(By.id("ctl00_MainContent_btnLogin")).click();
        driver.findElement(By.id("ctl00_MainContent_Btn_Save")).click();
        driver.findElement(By.xpath("//span[@onclick='ChangeLink();']")).click();
        driver.findElement(By.xpath("//span[@onclick='ChangeLink();']")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlCategory")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlCategory")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlCategory")).click();
        driver.findElement(By.id("ctl00_MainContent_ddlCategory")).click();
        driver.findElement(By.cssSelector("div.panel.panel-danger > div.row > div.col-lg-12.col-md-12.col-sm-12")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [openWindow | http://164.100.251.19/AanganPublic/Default.aspx | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        driver.get("https://www.google.com/?gws_rd=ssl");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
*/
