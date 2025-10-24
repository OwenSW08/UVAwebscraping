package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.List;

public class ScholarFinder {

    /**
     * Searches Google Scholar for each instructor, verifies affiliation, writes CSV.
     */
    public static void saveInstructorScholarLinks(WebDriver driver, WebDriverWait wait,
                                                  List<Instructor> instructors,
                                                  String outputCsvPath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputCsvPath))) {
            writer.println("InstructorID,InstructorName,ScholarURL");

            for (Instructor inst : instructors) {
                String name = inst.getName();
                int id = inst.getId();

                String scholarUrl = searchScholarAndValidate(driver, wait, name);

                writer.printf("%d,%s,%s%n", id, escapeCsv(name), scholarUrl == null ? "" : escapeCsv(scholarUrl));
                
                // To avoid rate limits / triggering blocks:
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches Google Scholar for the given name, returns the scholar profile URL if verified as UVA.
     * Returns null otherwise.
     */
    private static String searchScholarAndValidate(WebDriver driver, WebDriverWait wait, String name) {
        // First attempt: just name
        String url = tryScholarSearch(driver, wait, name);
        if (url != null) {
            return url;
        }
        // Second attempt: name + uva
        return tryScholarSearch(driver, wait, name + " uva");
    }

    private static String tryScholarSearch(WebDriver driver, WebDriverWait wait, String query) {
        driver.get("https://scholar.google.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.ENTER);

        // Wait for results
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.gs_r")));

        try {
            // First profile link (people results usually have profile heading <h4>)
            WebElement profileLink = driver.findElement(By.cssSelector("h4.gs_rt2 a"));
            String url = profileLink.getAttribute("href");

            profileLink.click();

            // On scholar profile page
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gsc_prf_in")));

            // Check for UVA affiliation
            List<WebElement> lines = driver.findElements(By.cssSelector("#gsc_prf_i .gsc_prf_il"));
            for (WebElement line : lines) {
                String text = line.getText().toLowerCase();
                if (text.contains("university of virginia") || text.contains("virginia.edu")) {
                    return url;
                }
            }

            // Also check verified email
            List<WebElement> emails = driver.findElements(By.cssSelector("#gsc_prf_ivh"));
            for (WebElement e : emails) {
                String t = e.getText().toLowerCase();
                if (t.contains("verified email") && t.contains("virginia.edu")) {
                    return url;
                }
            }

        } catch (Exception e) {
            // No profile or verification failed
        }
        return null;
    }

    private static String escapeCsv(String field) {
        if (field == null) return "";
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            field = field.replace("\"", "\"\"");
            return "\"" + field + "\"";
        }
        return field;
    }
}