import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.fail;

public class Aanaganwadi {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    public static List<Map<String, String>> readFIle(String fileAddress)
    {
        try {
            //File file = new File("C:\\demo\\employee.xlsx");   //creating a new file instance
            File file = new File(fileAddress);   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            boolean firstRow = false;
            List<String> header = new ArrayList();
            List<Map<String, String>> dataList = new ArrayList<>();
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                Map<String, String> data = new HashMap<>();
                if (!firstRow) {
                    firstRow = true;
                    while (cellIterator.hasNext()) {
                        Cell c = cellIterator.next();
                        header.add(c.getStringCellValue());
                    }
                    continue;
                }
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String key = header.get(cell.getColumnIndex());
                    String val = "";
                    if (cell.getCellType() == CellType.NUMERIC) {
                        val = String.valueOf(cell.getNumericCellValue());
                    } else {
                        val = cell.getStringCellValue();
                    }
                    data.put(key,
                             val);
                }

                dataList.add(data);
            }
            return dataList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Tags getEnum(String action) {
        for (Tags j : Tags.values()) {
            if (j.getAction()
                    .equalsIgnoreCase(action)) {
                return j;
            }
        }
        return Tags.Other;
    }

    private static List<EnumMap<Tags, String>> fetchData() {
        List<Map<String, String>> data = readFIle("C:\\Users\\nomad\\Downloads\\Aanganwadi.xlsx");

        List<EnumMap<Tags, String>> enumMaps = data.stream()
                .map(map -> {
                    EnumMap<Tags, String> enumMap = new EnumMap(Tags.class);
                    map.keySet()
                            .stream()
                            .forEach(k -> enumMap.put(getEnum(k),
                                                      map.get(k)));
                    return enumMap;
                })
                .distinct()
                .collect(Collectors.toList());
        return enumMaps;
    }

    public static void main(String[] args) throws Exception {
        Aanaganwadi a = new Aanaganwadi();
        List<EnumMap<Tags, String>> enumMaps = fetchData();
        a.setUp();
        for (EnumMap<Tags, String> data : enumMaps) {
            a.testAanaganwadi(data);
        }
        a.tearDown();

    }

    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                           "C:\\Users\\nomad\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.blazedemo.com/";
        driver.manage()
                .timeouts()
                .implicitlyWait(30,
                                TimeUnit.SECONDS);
    }

    @Test
    public void testAanaganwadi(EnumMap<Tags, String> values) throws Exception {
        // Label: Test
        // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1366,625 | ]]
        driver.get("http://164.100.251.19/AanganPublic/APP/Registration.aspx");
        driver.findElement(By.id("ctl00_MainContent_ddldistrict"))
                .click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddldistrict"))).selectByVisibleText("समस्तीपुर");
        driver.findElement(By.id("ctl00_MainContent_ddldistrict"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_ddlproject"))
                .click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlproject"))).selectByVisibleText("विद्यापतिनगर");
        driver.findElement(By.id("ctl00_MainContent_ddlproject"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_ddlpanchayat"))
                .click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlpanchayat"))).selectByVisibleText("बाज़िदपुर");
        driver.findElement(By.id("ctl00_MainContent_ddlpanchayat"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_ddlaangankendra"))
                .click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlaangankendra"))).selectByVisibleText("Raja chaudhary ka darwaja() - 10221190425");
        driver.findElement(By.id("ctl00_MainContent_ddlaangankendra"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txthusbandname"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txthusbandname"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txthusbandname"))
                .sendKeys(values.get(Tags.Husband_Name));
        driver.findElement(By.id("ctl00_MainContent_txtwifename"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txtwifename"))
                .sendKeys(values.get(Tags.Wife_Name));

        driver.findElement(By.id("ctl00_MainContent_ddlcategory"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_ddlcategory"))
                .click();
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlcategory"))).selectByVisibleText("अति-पिछड़ा (बीसी-1)");
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlcategory"))).selectByVisibleText(values.get(Tags.Category));
        driver.findElement(By.id("ctl00_MainContent_ddlcategory"))
                .click();
        //new Select(driver.findElement(By.id("ctl00_MainContent_ddlaadharbelongs"))).selectByVisibleText("पत्नी");
        new Select(driver.findElement(By.id("ctl00_MainContent_ddlaadharbelongs"))).selectByVisibleText(values.get(Tags.Aadhar_belongs));
        driver.findElement(By.id("ctl00_MainContent_ddlaadharbelongs"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txtaadharnumber"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txtaadharnumber"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txtaadharnumber"))
                .sendKeys(values.get(Tags.Aadhar_Number));
        driver.findElement(By.id("ctl00_MainContent_txtMobilenumber"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txtMobilenumber"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txtMobilenumber"))
                .sendKeys(values.get(Tags.Mobile_number));
        driver.findElement(By.id("ctl00_MainContent_drp_AccountHolder"))
                .click();
        new Select(driver.findElement(By.id("ctl00_MainContent_drp_AccountHolder"))).selectByVisibleText("पत्नी");
        new Select(driver.findElement(By.id("ctl00_MainContent_drp_AccountHolder"))).selectByVisibleText(values.get(Tags.Account_belongs_to));
        driver.findElement(By.id("ctl00_MainContent_drp_AccountHolder"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txt_IFSC"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txt_IFSC"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txt_IFSC"))
                .sendKeys(values.get(Tags.IFSC));
        driver.findElement(By.id("ctl00_MainContent_txt_Account"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txt_Account"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txt_Account"))
                .sendKeys(values.get(Tags.Account_number));
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txt_Account"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txtConfAcct"))
                .sendKeys(values.get(Tags.Account_number));
        driver.findElement(By.id("ctl00_MainContent_txtPassword"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txtPassword"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txtPassword"))
                .sendKeys("1234");
        driver.findElement(By.id("ctl00_MainContent_txtRePass"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_txtRePass"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_txtRePass"))
                .sendKeys("1234");
        driver.findElement(By.id("ctl00_MainContent_txtRePass"))
                .sendKeys(Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_txt_ChildName"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_txt_ChildName"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_txt_ChildName"))
                .sendKeys(values.get(Tags.Child));
        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Age"))).selectByVisibleText(values.get(Tags.Child_age));

        new Select(driver.findElement(By.id("ctl00_MainContent_Gridview1_ctl02_Drp_Gender"))).selectByVisibleText(values.get(Tags.Child_gender));


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
            driver.switchTo()
                    .alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo()
                    .alert();
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

