package web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Webscraping {

	private static final String SAVE_PATH = "C:/Users/owens/OneDrive/Documents/";

	public static void main(String[] args) throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver",
	            "C:/Users/owens/OneDrive/Documents/geckodriver-v0.36.0-win64/geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	    /*
	    // Load departments
	    HashSet<Department> departments = loadDepartments();

	    // Scrape UVA Faculty
	    List<HashSet<?>> UVAFacultyData = scrapeUVAFaculty(driver, wait);
	    @SuppressWarnings("unchecked")
	    HashSet<Instructor> instructors = (HashSet<Instructor>) UVAFacultyData.get(0);
	    @SuppressWarnings("unchecked")
	    HashSet<InstructorDepartmentPair> instructorDepartmentPairs = (HashSet<InstructorDepartmentPair>) UVAFacultyData.get(1);
	    @SuppressWarnings("unchecked")
	    HashSet<Topic> topics = (HashSet<Topic>) UVAFacultyData.get(2);
	    @SuppressWarnings("unchecked")
	    HashSet<TopicInstructorPair> topicInstructorPairs = (HashSet<TopicInstructorPair>) UVAFacultyData.get(3);

	    // Save UVA Faculty Data
	    saveInstructorsToCSV(instructors, "InstructorCatalog.csv");
	    saveInstructorDepartmentPairsToCSV(instructorDepartmentPairs, "InstructorDepartmentPairs.csv");
	    saveTopicsToCSV(topics, "TopicCatalog.csv");
	    saveTopicInstructorPairsToCSV(topicInstructorPairs, "TopicInstructorPairs.csv");
	    */

	    // Scrape Courses
	    //List<HashSet<?>> courseData = getCourses(driver, wait, departments);
	    //@SuppressWarnings("unchecked")
	    //HashSet<Course> courses = (HashSet<Course>) courseData.get(0);
	    //@SuppressWarnings("unchecked")
	    //HashSet<CourseDepartmentPair> courseDepartmentPairs = (HashSet<CourseDepartmentPair>) courseData.get(1);

	    // Save Course Data
	    //saveCoursesToCSV(courses, "CourseCatalog.csv");
	    //saveCourseDepartmentPairsToCSV(courseDepartmentPairs, "CourseDepartmentPairs.csv");
	    
	    // Get course-instructor pairs
	    //HashSet<CourseInstructorPair> courseInstructorPairs = getCourseInstructorPairs(driver, wait, courses, instructors);

	    // Save course-instructor pairs
	    //saveCourseInstructorPairsToCSV(courseInstructorPairs, "CourseInstructorPairs.csv");
	    
	    // Scrape Google Scholar papers and topics
	    
	    //HashSet<Instructor> instructors = loadInstructorsFromCSV("InstructorCatalog.csv");
	    //HashSet<Topic> topics = loadTopicsFromCSV("TopicCatalog.csv");
	    //HashSet<TopicInstructorPair> topicInstructorPairs = loadTopicInstructorPairsFromCSV("TopicInstructorPairs.csv");
	    //HashSet<PaperInstructorPair> paperInstructorPairs = loadPaperInstructorPairsFromCSV("PaperInstructorPairs.csv");
	    //HashSet<Paper> papers = loadPapersFromCSV("PaperCatalog.csv");
	    /*
	    HashSet<PaperInstructorPair> paperInstructorPairs = new HashSet<PaperInstructorPair>();
	    HashSet<Paper> papers = new HashSet<Paper>();
	    */
	    /*
	    List<HashSet<?>> scholarData = scrapeScholarPapersAndTopics(driver, wait, instructors, topics, topicInstructorPairs, papers, paperInstructorPairs);
	    @SuppressWarnings("unchecked")
	    HashSet<Paper> tempPapers = (HashSet<Paper>) scholarData.get(0);
	    papers = tempPapers;
	    @SuppressWarnings("unchecked")
	    HashSet<PaperInstructorPair> tempPaperInstructorPairs = (HashSet<PaperInstructorPair>) scholarData.get(1);
	    paperInstructorPairs = tempPaperInstructorPairs;
	    @SuppressWarnings("unchecked")
	    HashSet<Topic> tempTopics = (HashSet<Topic>) scholarData.get(2);
	    topics = tempTopics;

	    @SuppressWarnings("unchecked")
	    HashSet<TopicInstructorPair> tempPairs = (HashSet<TopicInstructorPair>) scholarData.get(3);
	    topicInstructorPairs = tempPairs;
	    */
	    // Save papers and paper-instructor pairs
	    //savePapersToCSV(papers, "PaperCatalog.csv");
	    //savePaperInstructorPairsToCSV(paperInstructorPairs, "PaperInstructorPairs.csv");

	    // Save updated topics
	    //saveTopicsToCSV(topics, "TopicCatalog.csv");
	    //saveTopicInstructorPairsToCSV(topicInstructorPairs, "TopicInstructorPairs.csv");
	    //HashSet<Paper> papers = loadPapersFromCSV("PaperCatalog.csv");
	    //cleanPaperYears(papers);
	    //savePapersToCSV(papers, "PaperCatalog.csv");
	    
	    //get course requirments
	    HashSet<Department> departments = loadDepartments();
	    HashSet<CourseDepartmentPair> courseDepartmentPairs = loadCourseDepartmentPairsFromCSV("CourseDepartmentPairs.csv");
	    HashSet<Course> courses = loadCoursesFromCSV("CourseCatalog.csv", courseDepartmentPairs, departments);
	    HashSet<CourseRequirementPair> courseRequirementPairs = extractCourseRequirements(driver, wait, departments, courses);
	    saveCourseRequirementPairsToCSV(courseRequirementPairs, "CourseRequirementPairs.csv");
	    
	    driver.quit();
	}

	private static HashSet<Department> loadDepartments() {
		String[] departmentNames = {
				"BME", "CHE", "CE", "CS", "ECE", "STS", "ENGR",
				"MSE", "MAE", "SYS", "APMA", "CPE", "EP", "EBUS"
		};

		HashSet<Department> departments = new HashSet<>();
		for (int i = 0; i < departmentNames.length; i++) {
			departments.add(new Department(i + 1, departmentNames[i]));
		}

		System.out.println("✅ Loaded " + departments.size() + " departments.");
		return departments;
	}

	public static ArrayList<HashSet<?>> scrapeUVAFaculty(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		HashSet<Instructor> instructors = new HashSet<>();
		HashSet<InstructorDepartmentPair> instructorDepartmentPairs = new HashSet<>();
		HashSet<Topic> topics = new HashSet<>();
		HashSet<TopicInstructorPair> topicInstructorPairs = new HashSet<>();

		String[] departmentsList = {"BME", "CHE", "CE", "CS", "ECE", "STS", "ENGR", "MSE", "MAE", "SYS", "APMA"};
		String[] facultyUrls = {
				"https://engineering.virginia.edu/department/biomedical-engineering/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/department/chemical-engineering/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/department/civil-and-environmental-engineering/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/department/computer-science/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/department/electrical-and-computer-engineering/faculty?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/department/engineering-and-society/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/offices-programs/first-year-engineering/first-year-engineering-faculty",
				"https://engineering.virginia.edu/department/materials-science-and-engineering/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/department/mechanical-and-aerospace-engineering/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/department/systems-and-information-engineering/people?keyword=&position=2&impact_area=All&research_area=All",
				"https://engineering.virginia.edu/offices-programs/applied-mathematics/applied-math-faculty"
		};

		String baseUrl = "https://engineering.virginia.edu";

		for (int i = 0; i < facultyUrls.length; i++) {
			String department = departmentsList[i];
			driver.get(facultyUrls[i]);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.cssSelector("h2.people_list_item_name a.contact_block_name_link")));

			List<WebElement> linkElements = driver.findElements(
					By.cssSelector("h2.people_list_item_name a.contact_block_name_link"));

			List<String> professorUrls = new ArrayList<>();
			for (WebElement link : linkElements) {
				String href = link.getAttribute("href");
				if (href != null) {
					professorUrls.add(href.startsWith("http") ? href : baseUrl + href);
				}
			}

			for (String profUrl : professorUrls) {
			    driver.get(profUrl);
			    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.page_title")));

			    // ---------- Instructor info ----------
			    String profName = "";
			    List<WebElement> nameElements = driver.findElements(By.cssSelector("h1.page_title"));
			    if (!nameElements.isEmpty()) {
			        profName = nameElements.get(0).getText().trim().split(",")[0].trim();
			        String[] parts = profName.split(" ");
			        if (parts.length >= 3) {
			            profName = parts[0] + " " + parts[2]; // Remove middle name
			        }
			    }

			    String description = "";
			    List<WebElement> typographyDivs = driver.findElements(By.cssSelector("div.typography"));
			    if (!typographyDivs.isEmpty()) {
			        for (WebElement child : typographyDivs.get(0).findElements(By.xpath("./*"))) {
			            if (child.getTagName().equalsIgnoreCase("p")) {
			                description = child.getText().trim();
			                break;
			            }
			        }
			    }

			    // Awards (optional)
			    String awards = "";
			    List<WebElement> awardSections = driver.findElements(By.cssSelector("h2.directory_grid_title"));
			    for (WebElement header : awardSections) {
			        if (header.getText().trim().equalsIgnoreCase("Awards")) {
			            WebElement parent = header.findElement(By.xpath("./.."));
			            List<WebElement> awardItems = parent.findElements(By.cssSelector("div.directory_grid_item"));
			            StringBuilder sb = new StringBuilder();
			            for (WebElement item : awardItems) {
			                sb.append(item.getText().trim()).append(", ");
			            }
			            awards = sb.toString().trim();
			            break;
			        }
			    }

			    // ---------- Create or get existing instructor ----------
			    Instructor temp = new Instructor();
			    temp.setName(profName);
			    temp.setDescription(description);
			    temp.setAwards(awards);

			    Instructor finalInstructor = temp;

			    if (!instructors.contains(temp)) {
			        temp.setId(instructors.size() + 1); // Assign new ID
			        instructors.add(temp);
			    } else {
			        // Reuse existing instructor so ID is correct
			        for (Instructor existing : instructors) {
			            if (existing.equals(temp)) {
			                finalInstructor = existing;
			                break;
			            }
			        }
			    }

			    // ---------- Instructor-Department Pair ----------
			    instructorDepartmentPairs.add(new InstructorDepartmentPair(finalInstructor.getId(), i + 1));

			    // ---------- Topics / Research Interests ----------
			    List<WebElement> researchSections = driver.findElements(By.cssSelector("div.directory_grid"));
			    for (WebElement section : researchSections) {
			        WebElement header = section.findElement(By.cssSelector("h2.directory_grid_title"));
			        if (header.getText().trim().equalsIgnoreCase("Research Interests")) {
			            List<WebElement> topicItems = section.findElements(By.cssSelector("div.directory_grid_item"));
			            for (WebElement topicItem : topicItems) {
			                String topicName = topicItem.getText().trim();
			                if (!topicName.isEmpty()) {
			                    Topic topic = new Topic(topicName);

			                    if (!topics.contains(topic)) {
			                        topic.setId(topics.size() + 1);
			                        topics.add(topic);
			                    } else {
			                        for (Topic existing : topics) {
			                            if (existing.equals(topic)) {
			                                topic = existing;
			                                break;
			                            }
			                        }
			                    }

			                    // Always use finalInstructor to get correct ID
			                    topicInstructorPairs.add(new TopicInstructorPair(topic.getId(), finalInstructor.getId()));
			                }
			            }
			            break;
			        }
			    }
			}
		}

		ArrayList<HashSet<?>> results = new ArrayList<>();
		results.add(instructors);
		results.add(instructorDepartmentPairs);
		results.add(topics);
		results.add(topicInstructorPairs);
		return results;
	}

	public static List<HashSet<?>> getCourses(WebDriver driver, WebDriverWait wait, HashSet<Department> departmentsSet) {
	    HashSet<Course> courses = new HashSet<>();
	    HashSet<CourseDepartmentPair> courseDepartmentPairs = new HashSet<>();

	    int[] semesterIds = {8, 6, 2, 1}; // fall, summer, spring, january
	    String[] departments = {"APMA", "BME", "CHE", "CEE", "CompSci", "ECE", "ENGR", "MAE", "MSE", "STS", "SYS"};
	    String baseUrl = "https://louslist.org/page.php?Semester=1";
	    String extraUrl = "&Type=Group&Group=";

	    for (String deptCode : departments) {
	        for (int i = 25; i >= 12; i--) {
	            for (int semesterId : semesterIds) {
	                String url = baseUrl + i + semesterId + extraUrl + deptCode;
	                driver.get(url);

	                List<WebElement> courseNames = driver.findElements(By.className("CourseName"));
	                List<WebElement> courseNums = driver.findElements(By.className("CourseNum"));

	                int size = Math.min(courseNames.size(), courseNums.size());

	                for (int idx = 0; idx < size; idx++) {
	                    try {
	                        WebElement courseNumElement = courseNums.get(idx);
	                        WebElement courseNameElement = courseNames.get(idx);

	                        // Get catalog number
	                        WebElement span = courseNumElement.findElement(By.tagName("span"));
	                        String catalogNumber = span.getText().trim();
	                        String departmentCode = catalogNumber.split(" ")[0];
	                        String number = catalogNumber.split(" ")[1];

	                        // Get title
	                        String name = courseNameElement.getText().trim();

	                        // Click course name to reveal description
	                        courseNameElement.click();

	                        WebElement descDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ovfl1")));

	                        // Use getText() to get only visible text (no <script> content)
	                        String description = descDiv.getText().trim();

	                        // Fallback cleanup (if Lou’s List still includes analytics)
	                        description = description.replaceAll("window\\.dataLayer.*", "").trim();

	                        // Create Course
	                        Course newCourse = new Course(departmentCode, number, name, description);

	                        // Assign ID after confirming uniqueness
	                        if (!courses.contains(newCourse)) {
	                            newCourse.setId(courses.size() + 1);
	                            courses.add(newCourse);
	                        }

	                        // Look up department ID from departmentsSet
	                        int deptId = -1;
	                        for (Department d : departmentsSet) {
	                            if (d.getName().equalsIgnoreCase(departmentCode)) {
	                                deptId = d.getId();
	                                break;
	                            }
	                        }

	                        // Create course-department pair if valid department found
	                        if (deptId != -1) {
	                            CourseDepartmentPair pair = new CourseDepartmentPair(newCourse.getId(), deptId);
	                            courseDepartmentPairs.add(pair);
	                        }

	                    } catch (Exception e) {
	                        System.out.println("Error processing course at index " + idx + ": " + e.getMessage());
	                    }
	                }
	            }
	        }
	    }

	    // Final pass: cleanup any leftover analytics text
	    for (Course c : courses) {
	        c.setDescription(c.getDescription().replaceAll("window\\.dataLayer.*", "").trim());
	    }

	    List<HashSet<?>> result = new ArrayList<>();
	    result.add(courses);
	    result.add(courseDepartmentPairs);
	    return result;
	}

	private static HashSet<CourseInstructorPair> getCourseInstructorPairs(
	        WebDriver driver, WebDriverWait wait,
	        HashSet<Course> courses, HashSet<Instructor> instructors) {

	    HashSet<CourseInstructorPair> pairs = new HashSet<>();

	    for (Course c : courses) {
	        String url = "https://louslist.org/mnemonicnumbertip.php?iMnemonic=" + c.getDepartment() + "&iNumber=" + c.getNumber();
	        driver.get(url);

	        List<WebElement> rows = driver.findElements(By.tagName("tr"));

	        for (int i = 1; i < rows.size(); i++) {  // Skip header
	            WebElement row = rows.get(i);
	            List<WebElement> cells = row.findElements(By.tagName("td"));

	            if (cells.size() >= 7) {
	                String semesterRaw = cells.get(0).getText().trim();
	                String instructorCell = cells.get(6).getText().trim();

	                if (!instructorCell.isEmpty()) {
	                    String[] instructorNames = instructorCell.split(",");

	                    for (String rawName : instructorNames) {
	                        String instructorName = rawName.trim();
	                        if (instructorName.isEmpty()) continue;

	                        Instructor temp = new Instructor();
	                        temp.setName(instructorName);

	                        for (Instructor existing : instructors) {
	                            if (existing.equals(temp)) {
	                                // Create new pair
	                                CourseInstructorPair pair = new CourseInstructorPair(c.getId(), existing.getId(), semesterRaw);

	                                // If pair exists, update semesters
	                                if (pairs.contains(pair)) {
	                                    for (CourseInstructorPair existingPair : pairs) {
	                                        if (existingPair.equals(pair)) {
	                                            existingPair.addSemester(semesterRaw);
	                                            break;
	                                        }
	                                    }
	                                } else {
	                                    pairs.add(pair);
	                                }

	                                break;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	    return pairs;
	}

	public static List<HashSet<?>> scrapeScholarPapersAndTopics(
	        WebDriver driver, WebDriverWait wait,
	        HashSet<Instructor> instructors,
	        HashSet<Topic> topics,
	        HashSet<TopicInstructorPair> topicInstructorPairs,
	        HashSet<Paper> papers,
	        HashSet<PaperInstructorPair> paperInstructorPairs) {

	    // --- Determine which instructors have already been scraped ---
		
	    HashSet<Integer> completedInstructorIds = new HashSet<>();
	    for (PaperInstructorPair pair : paperInstructorPairs) {
	        completedInstructorIds.add(pair.getInstructorId());
	    }

	    System.out.println("📂 Existing data: " + papers.size() + " papers and "
	            + paperInstructorPairs.size() + " paper–instructor pairs.");
	    System.out.println("✅ Skipping " + completedInstructorIds.size() + " instructors already scraped.");

	    for (Instructor inst : instructors) {
	        if (completedInstructorIds.contains(inst.getId())) {
	            System.out.println("⏭️ Skipping " + inst.getName() + " (already scraped).");
	            continue;
	        }
	        
	        String name = inst.getName();
	        System.out.println("\n🔍 Scraping instructor: " + name);

	        try {
	            // Wait 45s + random 0–10s before searching
	            safeSleepWithRandom(45000, 10000);

	            // Find Google Scholar profile
	            String profileUrl = searchScholarProfile(driver, wait, name);
	            if (profileUrl == null) {
	                System.out.println("⚠️ No profile found for " + name);
	                continue;
	            }

	            // Wait before loading profile
	            safeSleepWithRandom(45000, 10000);
	            driver.get(profileUrl);
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gsc_a_b")));

	            // Detect login page
	            if (isLoginPage(driver)) {
	                System.out.println("⚠️ Login page detected. Aborting scraping.");
	                saveProgressOnError(papers, paperInstructorPairs, topics, topicInstructorPairs);
	                break;
	            }

	            // --- Scrape top 5 cited papers ---
	            scrapeTopPapers(driver, wait, inst, papers, paperInstructorPairs, 5, "cited");

	            // Wait before switching to pubdate
	            safeSleepWithRandom(45000, 10000);

	            // --- Scrape 5 most recent papers ---
	            try {
	                String pubdateUrl = profileUrl + "&cstart=0&pagesize=100&sortby=pubdate";
	                driver.get(pubdateUrl);
	                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gsc_a_b")));

	                if (isLoginPage(driver)) {
	                    System.out.println("⚠️ Login page detected on pubdate page. Aborting.");
	                    saveProgressOnError(papers, paperInstructorPairs, topics, topicInstructorPairs);
	                    break;
	                }

	                scrapeTopPapers(driver, wait, inst, papers, paperInstructorPairs, 5, "recent");
	            } catch (Exception e) {
	                System.out.println("⚠️ Error fetching most recent papers for " + name);
	            }

	            // --- Research interests (topics) ---
	            safeSleepWithRandom(45000, 10000);
	            try {
	                List<WebElement> emailElements = driver.findElements(By.cssSelector("#gsc_prf_ivh"));
	                for (WebElement emailEl : emailElements) {
	                    if (emailEl.getText().toLowerCase().contains("virginia.edu")) {
	                        WebElement parent = emailEl.findElement(By.xpath("./.."));
	                        List<WebElement> interestElements = parent.findElements(By.cssSelector(".gsc_prf_inta"));
	                        for (WebElement interestEl : interestElements) {
	                            String topicName = interestEl.getText().trim();
	                            if (topicName.isEmpty()) continue;

	                            Topic topic = new Topic(topicName);
	                            if (!topics.contains(topic)) {
	                                topic.setId(topics.size() + 1);
	                                topics.add(topic);
	                            } else {
	                                for (Topic existing : topics) {
	                                    if (existing.equals(topic)) {
	                                        topic = existing;
	                                        break;
	                                    }
	                                }
	                            }

	                            topicInstructorPairs.add(new TopicInstructorPair(topic.getId(), inst.getId()));
	                        }
	                        break;
	                    }
	                }
	            } catch (Exception e) {
	                System.out.println("⚠️ No research interests found for " + name);
	            }

	            safeSleepWithRandom(45000, 10000);

	        } catch (Exception e) {
	            System.out.println("\n❌ Error scraping " + name + ": " + e.getMessage());
	            e.printStackTrace();
	            saveProgressOnError(papers, paperInstructorPairs, topics, topicInstructorPairs);
	            break;
	        }
	    }

	    List<HashSet<?>> results = new ArrayList<>();
	    results.add(papers);
	    results.add(paperInstructorPairs);
	    results.add(topics);
	    results.add(topicInstructorPairs);
	    return results;
	}

	// --- Randomized sleep helper ---
	private static void safeSleepWithRandom(long baseMs, long randomMs) {
	    try {
	        long total = baseMs + ThreadLocalRandom.current().nextLong(randomMs + 1);
	        Thread.sleep(total);
	    } catch (InterruptedException ignored) {}
	}

	// --- Login page detection ---
	private static boolean isLoginPage(WebDriver driver) {
	    try {
	        driver.findElement(By.id("gs_hdr_signin")); // Sign-in button exists → login page
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	private static void saveProgressOnError(HashSet<Paper> papers,
			HashSet<PaperInstructorPair> paperInstructorPairs,
			HashSet<Topic> topics,
			HashSet<TopicInstructorPair> topicInstructorPairs) {
		try {
			System.out.println("💾 Saving progress after error...");

			savePapersToCSV(papers, "Papers_ErrorSave.csv");
			savePaperInstructorPairsToCSV(paperInstructorPairs, "PaperInstructorPairs_ErrorSave.csv");
			saveTopicsToCSV(topics, "Topics_ErrorSave.csv");
			saveTopicInstructorPairsToCSV(topicInstructorPairs, "TopicInstructorPairs_ErrorSave.csv");

			System.out.println("✅ Progress successfully saved to CSV files in error recovery mode.");
		} catch (Exception ex) {
			System.out.println("❌ Failed to save progress: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * Tries to find the Google Scholar profile URL for an instructor.
	 */
	private static String searchScholarProfile(WebDriver driver, WebDriverWait wait, String name) {
	    String[] queries = {name, name + " uva"};

	    for (String query : queries) {
	        safeSleepWithRandom(2000, 10000);

	        driver.get("https://scholar.google.com/");
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

	        // Type like a human
	        WebElement searchBox = driver.findElement(By.name("q"));
	        searchBox.clear();
	        safeSleepWithRandom(300, 600);

	        for (char c : query.toCharArray()) {
	            searchBox.sendKeys(String.valueOf(c));
	            safeSleepWithRandom(100, 200);
	        }

	        safeSleepWithRandom(400, 800);
	        searchBox.sendKeys(Keys.ENTER);

	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.gs_r")));
	        safeSleepWithRandom(2000, 3000); // wait for all results to load

	        try {
	            // Get ALL visible profile links
	            List<WebElement> profileLinks = driver.findElements(By.cssSelector("h4.gs_rt2 a"));

	            for (WebElement profileLink : profileLinks) {
	                String url = profileLink.getAttribute("href");
	                if (url == null || !url.contains("scholar.google.com/citations?")) continue;

	                // Open in new tab to avoid losing search page
	                ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", url);
	                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	                driver.switchTo().window(tabs.get(tabs.size() - 1));

	                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gsc_prf_in")));
	                safeSleepWithRandom(1000, 2000);

	                // Check affiliations
	                List<WebElement> lines = driver.findElements(By.cssSelector("#gsc_prf_i .gsc_prf_il"));
	                for (WebElement line : lines) {
	                    String text = line.getText().toLowerCase();
	                    if (text.contains("university of virginia") || text.contains("virginia.edu")) {
	                        // Close the tab and return
	                        driver.close();
	                        driver.switchTo().window(tabs.get(0));
	                        return url;
	                    }
	                }

	                // Check verified email
	                List<WebElement> emails = driver.findElements(By.cssSelector("#gsc_prf_ivh"));
	                for (WebElement e : emails) {
	                    String t = e.getText().toLowerCase();
	                    if (t.contains("verified email") && t.contains("virginia.edu")) {
	                        driver.close();
	                        driver.switchTo().window(tabs.get(0));
	                        return url;
	                    }
	                }

	                // Close tab and go back to search results
	                driver.close();
	                driver.switchTo().window(tabs.get(0));

	                safeSleepWithRandom(800, 1800);
	            }

	        } catch (Exception ignored) {
	            safeSleepWithRandom(1000, 2000);
	        }
	    }

	    return null;
	}

	/**
	 * Scrapes the top N papers from the current Scholar profile view.
	 */
	private static void scrapeTopPapers(WebDriver driver, WebDriverWait wait,
			Instructor inst,
			HashSet<Paper> papers,
			HashSet<PaperInstructorPair> paperInstructorPairs,
			int topN, String sectionType) {

		List<WebElement> paperRows = driver.findElements(By.cssSelector("#gsc_a_b .gsc_a_tr"));
		int count = 0;

		for (WebElement row : paperRows) {
			if (count >= topN) break;

			try {
				WebElement titleElement = row.findElement(By.cssSelector(".gsc_a_at"));
				String title = titleElement.getText().trim();
				String url = titleElement.getAttribute("href");

				// Open the paper detail page
				driver.navigate().to(url);
				safeSleep(3000 + (long)(Math.random() * 3000));

				// Extract metadata
				String publisher = "";
				String source = "";
				String pubDate = "";
				String abstractText = "";

				try {
					WebElement sourceElem = driver.findElement(By.xpath("//div[@class='gsc_oci_field' and text()='Source']/following-sibling::div"));
					source = sourceElem.getText().trim();
				} catch (Exception ignored) {}

				try {
					WebElement publisherElem = driver.findElement(By.xpath("//div[@class='gsc_oci_field' and text()='Publisher']/following-sibling::div"));
					publisher = publisherElem.getText().trim();
				} catch (Exception ignored) {}

				try {
					WebElement dateElem = driver.findElement(By.xpath("//div[@class='gsc_oci_field' and text()='Publication date']/following-sibling::div"));
					pubDate = dateElem.getText().trim();
				} catch (Exception ignored) {}

				try {
					WebElement descElem = driver.findElement(By.id("gsc_oci_descr"));
					abstractText = descElem.getText().trim();
				} catch (Exception ignored) {}

				// Go back to profile page
				driver.navigate().back();
				safeSleep(2000 + (long)(Math.random() * 2000));

				// Construct the Paper object
				Paper paper = new Paper(papers.size() + 1, title, url, abstractText, publisher, source, pubDate);

				// Avoid duplicates by title (equals based on title)
				if (!papers.contains(paper)) {
					papers.add(paper);
				} else {
					for (Paper existing : papers) {
						if (existing.equals(paper)) {
							paper = existing;
							break;
						}
					}
				}

				// Add instructor-paper relationship
				PaperInstructorPair pair = new PaperInstructorPair(paper.getId(), inst.getId());
				if (!paperInstructorPairs.contains(pair)) {
					paperInstructorPairs.add(pair);
				}

				count++;
				safeSleep(2000 + (long)(Math.random() * 8000));// light delay between papers

			} catch (Exception e) {
				System.out.println("Error scraping paper: " + e.getMessage());
				try {
					driver.navigate().back();
				} catch (Exception ignored) {}
			}
		}
	}

	/**
	 * Helper to safely pause execution for the given time in milliseconds.
	 */
	private static void safeSleep(long ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException ignored) {}
	}
	
	public static HashSet<CourseRequirementPair> extractCourseRequirements(
	        WebDriver driver,
	        WebDriverWait wait,
	        HashSet<Department> departmentsSet,
	        HashSet<Course> courses) {

	    HashSet<CourseRequirementPair> courseRequirementPairs = new HashSet<>();

	    int[] semesterIds = {8, 6, 2, 1};
	    String[] departments = {"APMA", "BME", "CHE", "CEE", "CompSci", "ECE", "ENGR", "MAE", "MSE", "STS", "SYS"};
	    String baseUrl = "https://louslist.org/page.php?Semester=1";
	    String extraUrl = "&Type=Group&Group=";

	    // --- Build course lookup map ---
	    Map<String, Integer> courseLookup = new HashMap<>();
	    for (Course c : courses) {
	        String deptCode = c.getDepartment().toUpperCase().trim();
	        if (deptCode.isEmpty()) {
	            System.out.println("⚠️ Skipping course " + c.getId() + " (missing department)");
	            continue;
	        }
	        String key = (deptCode + " " + c.getNumber()).toUpperCase().trim();
	        courseLookup.put(key, c.getId());
	        System.out.println("DEBUG: Adding course key='" + key + "' -> ID=" + c.getId());
	    }

	    // --- Crawl through departments and semesters ---
	    for (String deptCode : departments) {
	        for (int year = 25; year >= 12; year--) {
	            for (int semesterId : semesterIds) {
	                String url = baseUrl + year + semesterId + extraUrl + deptCode;
	                System.out.println("DEBUG: Visiting URL: " + url);

	                driver.get(url);
	                safeSleepWithRandom(800, 1500);

	                List<WebElement> rows = driver.findElements(By.xpath("//tr"));
	                System.out.println("DEBUG: Found " + rows.size() + " <tr> rows for deptCode=" + deptCode + " year=" + year + " sem=" + semesterId);

	                String currentCourseKey = null;
	                Integer currentCourseId = null;
	                Map<Integer, Set<Integer>> prereqIdsMap = new HashMap<>();
	                Map<Integer, Set<String>> prereqTextMap = new HashMap<>();

	                for (WebElement row : rows) {
	                    try {
	                        // Detect a new course header row
	                        List<WebElement> courseNumSpans = row.findElements(By.xpath(".//td[@class='CourseNum']/span"));
	                        if (!courseNumSpans.isEmpty()) {
	                            String catalogNumber = courseNumSpans.get(0).getText().trim();
	                            String[] parts = catalogNumber.split("\\s+");
	                            if (parts.length >= 2) {
	                                currentCourseKey = (parts[0] + " " + parts[1]).toUpperCase();
	                                currentCourseId = courseLookup.get(currentCourseKey);
	                                System.out.println("DEBUG: catalogNumber='" + catalogNumber + "' -> key='" + currentCourseKey + "' -> ID=" + currentCourseId);

	                                if (currentCourseId == null) {
	                                    System.out.println("⚠️ Key not found in courseLookup: '" + currentCourseKey + "'");
	                                }
	                            }
	                        }

	                        if (currentCourseId != null) {
	                            // Look for spans with hover prereq text
	                            List<WebElement> prereqElems = row.findElements(
	                                    By.xpath(".//span[contains(@onmouseover,'Enrollment Requirements:')]")
	                            );

	                            for (WebElement elem : prereqElems) {
	                                String hoverText = elem.getAttribute("onmouseover");
	                                if (hoverText == null) continue;

	                                System.out.println("DEBUG: Raw hoverText: " + hoverText);

	                                // Updated regex: support "return overlib('...text...',AUTOSTATUS,WRAP)"
	                                Matcher matcher = Pattern.compile(
	                                        "overlib\\s*\\(\\s*'([^']+)'\\s*,",
	                                        Pattern.CASE_INSENSITIVE
	                                ).matcher(hoverText);

	                                if (!matcher.find()) {
	                                    System.out.println("⚠️ Could not parse overlib text for: " + hoverText);
	                                    continue;
	                                }

	                                // Clean up and normalize the text
	                                String reqText = matcher.group(1)
	                                        .replace("Enrollment Requirements:", "")
	                                        .replace("&nbsp;", " ")
	                                        .replace("&amp;", "&")
	                                        .trim();

	                                reqText = reqText.replaceAll("\\s+", " ");
	                                System.out.println("✅ Parsed prereqText for " + currentCourseKey + ": " + reqText);

	                                // Preserve AND/OR structure explicitly
	                                String parsedReqText = reqText
	                                        .replaceAll("(?i)\\band\\b", " and ")
	                                        .replaceAll("(?i)\\bor\\b", " or ")
	                                        .replaceAll("\\s+", " ");

	                                prereqTextMap.computeIfAbsent(currentCourseId, k -> new HashSet<>()).add(parsedReqText);

	                                // Extract possible course codes from text
	                                Matcher courseMatcher = Pattern.compile("([A-Za-z]{2,4}\\s?\\d{4})").matcher(reqText);
	                                while (courseMatcher.find()) {
	                                    String prereqCode = courseMatcher.group(1).replaceAll("\\s+", " ").toUpperCase();
	                                    Integer prereqId = courseLookup.get(prereqCode);
	                                    System.out.println("DEBUG: Found prereq course code '" + prereqCode + "' -> ID=" + prereqId);

	                                    if (prereqId != null) {
	                                        prereqIdsMap.computeIfAbsent(currentCourseId, k -> new HashSet<>()).add(prereqId);
	                                    }
	                                }
	                            }
	                        }

	                    } catch (Exception e) {
	                        System.out.println("⚠️ Error processing row: " + e.getMessage());
	                    }
	                }

	                // After finishing the rows, create pairs
	                for (Map.Entry<Integer, Set<Integer>> entry : prereqIdsMap.entrySet()) {
	                    Integer courseId = entry.getKey();
	                    Set<String> prereqTexts = prereqTextMap.getOrDefault(courseId, new HashSet<>());
	                    String alternatives = String.join(" and ", prereqTexts);

	                    for (Integer prereqId : entry.getValue()) {
	                        CourseRequirementPair pair = new CourseRequirementPair(prereqId, courseId, alternatives);
	                        courseRequirementPairs.add(pair);
	                        System.out.println("✅ Added pair: courseId=" + courseId + " <- prereqId=" + prereqId + " | text=" + alternatives);
	                    }
	                }
	            }
	        }
	    }

	    System.out.println("✅ Extracted " + courseRequirementPairs.size() + " course–requirement pairs.");
	    return courseRequirementPairs;
	}
	
	/**
	 * Save instructors to CSV.
	 */
	private static void saveInstructorsToCSV(Set<Instructor> instructors, String filename) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_PATH + filename))) {
	        // CSV header
	        writer.println("Id;Name;Description;Awards");

	        for (Instructor instructor : instructors) {
	            String id = String.valueOf(instructor.getId());
	            String name = escapeCsvSemicolon(instructor.getName());
	            String description = escapeCsvSemicolon(instructor.getDescription());
	            String awards = escapeCsvSemicolon(instructor.getAwards());

	            writer.printf("%s;%s;%s;%s%n", id, name, description, awards);
	        }

	        System.out.println("✅ Instructors saved to: " + filename);
	    } catch (IOException e) {
	        System.out.println("❌ Error writing instructors to CSV: " + e.getMessage());
	    }
	}

	/**
	 * Escapes a CSV field for semicolon-delimited CSVs.
	 * Wraps in quotes if it contains semicolon, newline, or quote.
	 */
	private static String escapeCsvSemicolon(String field) {
	    if (field == null) return "";
	    field = field.replace("\r", " ").replace("\n", " "); // replace newlines with spaces
	    if (field.contains(";") || field.contains("\"") || field.contains(",")) {
	        field = field.replace("\"", "\"\"");
	        return "\"" + field + "\"";
	    }
	    return field.trim();
	}
	
	private static HashSet<Instructor> loadInstructorsFromCSV(String filename) {
	    HashSet<Instructor> instructors = new HashSet<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_PATH + filename))) {
	        String line;
	        boolean isHeader = true;

	        while ((line = reader.readLine()) != null) {
	            // Skip header line
	            if (isHeader) {
	                isHeader = false;
	                continue;
	            }

	            // Parse semicolon-delimited line with quoted fields
	            String[] fields = parseSemicolonCsvLine(line);
	            if (fields.length < 4) continue;

	            int id = 0;
	            try {
	                id = Integer.parseInt(fields[0].trim());
	            } catch (NumberFormatException e) {
	                id = instructors.size() + 1;
	            }

	            String name = fields[1].trim();
	            String description = fields[2].trim();
	            String awards = fields[3].trim();

	            Instructor inst = new Instructor(id, name, description, awards);
	            instructors.add(inst);
	        }

	        System.out.println("✅ Loaded " + instructors.size() + " instructors from " + filename);

	    } catch (IOException e) {
	        System.out.println("❌ Error loading instructors from CSV: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return instructors;
	}
	
	private static String[] parseSemicolonCsvLine(String line) {
	    List<String> tokens = new ArrayList<>();
	    StringBuilder sb = new StringBuilder();
	    boolean inQuotes = false;

	    for (int i = 0; i < line.length(); i++) {
	        char c = line.charAt(i);

	        if (c == '"') {
	            if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
	                sb.append('"'); // handle escaped quotes ("")
	                i++;
	            } else {
	                inQuotes = !inQuotes;
	            }
	        } else if (c == ';' && !inQuotes) {
	            tokens.add(sb.toString());
	            sb.setLength(0);
	        } else {
	            sb.append(c);
	        }
	    }

	    tokens.add(sb.toString());
	    return tokens.toArray(new String[0]);
	}

	/**
	 * Save instructor-department pairs to CSV.
	 */
	private static void saveInstructorDepartmentPairsToCSV(HashSet<InstructorDepartmentPair> pairs, String fileName) {
	    String outputFile = SAVE_PATH + fileName;
	    try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
	        writer.println("InstructorID,DepartmentID");
	        for (InstructorDepartmentPair pair : pairs) {
	            writer.println(pair.getInstructorId() + "," + pair.getDepartmentId());
	        }
	        System.out.println("✅ Saved " + pairs.size() + " instructor–department pairs to " + outputFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static HashSet<Topic> loadTopicsFromCSV(String fileName) {
	    HashSet<Topic> topics = new HashSet<>();
	    String fullPath = SAVE_PATH + fileName;

	    try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
	        String line = reader.readLine(); // skip header
	        if (line == null) {
	            System.out.println("⚠️ Topic CSV is empty: " + fullPath);
	            return topics;
	        }

	        while ((line = reader.readLine()) != null) {
	            List<String> parts = parseCsvLine(line);
	            if (parts.size() < 2) continue;

	            int id = 0;
	            try {
	                id = Integer.parseInt(parts.get(0).trim());
	            } catch (NumberFormatException ignored) {}

	            String name = parts.get(1).trim();

	            Topic topic = new Topic(name);
	            topic.setId(id);
	            topics.add(topic);
	        }

	        System.out.println("✅ Loaded " + topics.size() + " topics from " + fileName);
	    } catch (FileNotFoundException e) {
	        System.out.println("❌ Topic CSV not found: " + fullPath);
	    } catch (IOException e) {
	        System.out.println("❌ Error reading topics from CSV: " + e.getMessage());
	    }

	    return topics;
	}

	/**
	 * Save topics to CSV.
	 */
	private static void saveTopicsToCSV(HashSet<Topic> topics, String fileName) {
	    String outputFile = SAVE_PATH + fileName;
	    try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
	        writer.println("Id,Name");
	        for (Topic topic : topics) {
	            writer.println(topic.getId() + "," + escapeCsv(topic.getName()));
	        }
	        System.out.println("✅ Saved " + topics.size() + " topics to " + outputFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static HashSet<TopicInstructorPair> loadTopicInstructorPairsFromCSV(String fileName) {
	    HashSet<TopicInstructorPair> pairs = new HashSet<>();
	    String inputFile = SAVE_PATH + fileName;

	    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
	        String line = reader.readLine(); // skip header
	        if (line == null) {
	            System.out.println("⚠️ No data in: " + inputFile);
	            return pairs;
	        }

	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",", -1);
	            if (parts.length < 2) continue;

	            try {
	                int topicId = Integer.parseInt(parts[0].trim());
	                int instructorId = Integer.parseInt(parts[1].trim());
	                pairs.add(new TopicInstructorPair(topicId, instructorId));
	            } catch (NumberFormatException e) {
	                System.out.println("⚠️ Skipping malformed line: " + line);
	            }
	        }

	        System.out.println("✅ Loaded " + pairs.size() + " topic–instructor pairs from " + inputFile);
	    } catch (FileNotFoundException e) {
	        System.out.println("❌ File not found: " + inputFile);
	    } catch (IOException e) {
	        System.out.println("❌ Error reading pairs: " + e.getMessage());
	    }

	    return pairs;
	}

	/**
	 * Save topic-instructor pairs to CSV.
	 */
	private static void saveTopicInstructorPairsToCSV(HashSet<TopicInstructorPair> pairs, String fileName) {
	    String outputFile = SAVE_PATH + fileName;
	    try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
	        writer.println("TopicID,InstructorID");
	        for (TopicInstructorPair pair : pairs) {
	            writer.println(pair.getTopicId() + "," + pair.getInstructorId());
	        }
	        System.out.println("✅ Saved " + pairs.size() + " topic–instructor pairs to " + outputFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static HashSet<Course> loadCoursesFromCSV(
	        String filename, 
	        HashSet<CourseDepartmentPair> courseDeptPairs, 
	        HashSet<Department> departments) {

	    HashSet<Course> courses = new HashSet<>();

	    // Build a map from department ID to department name for fast lookup
	    HashMap<Integer, String> deptIdToName = new HashMap<>();
	    for (Department dept : departments) {
	        deptIdToName.put(dept.getId(), dept.getName());
	    }

	    try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_PATH + filename))) {
	        String line;
	        boolean isHeader = true;

	        while ((line = reader.readLine()) != null) {
	            // Skip header
	            if (isHeader) {
	                isHeader = false;
	                continue;
	            }

	            List<String> fields = parseCsvLine(line);
	            if (fields.size() < 4) continue;

	            int id = 0;
	            try {
	                id = Integer.parseInt(fields.get(0).trim());
	            } catch (NumberFormatException e) {
	                id = courses.size() + 1;
	            }

	            String number = fields.get(1).trim();
	            String name = fields.get(2).trim();
	            String description = fields.get(3).trim();

	            // Find department name for this course
	            String departmentName = "";
	            for (CourseDepartmentPair pair : courseDeptPairs) {
	                if (pair.getCourseId() == id) {
	                    departmentName = deptIdToName.getOrDefault(pair.getDepartmentId(), "");
	                    break; // assume one department per course
	                }
	            }

	            Course course = new Course(departmentName, number, name, description);
	            course.setId(id);
	            courses.add(course);
	        }

	        System.out.println("✅ Loaded " + courses.size() + " courses from " + filename);

	    } catch (IOException e) {
	        System.out.println("❌ Error loading courses from CSV: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return courses;
	}
	
	// Save Courses to CSV
	public static void saveCoursesToCSV(HashSet<Course> courses, String filePath) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_PATH + filePath))) {
	        writer.println("CourseID,Number,Name,Description");

	        for (Course course : courses) {
	            String id = String.valueOf(course.getId());
	            String number = escapeCsv(course.getNumber());
	            String name = escapeCsv(course.getName());
	            String description = escapeCsv(course.getDescription().replaceAll("[\\r\\n]+", " "));

	            writer.printf("%s,%s,%s,%s%n", id, number, name, description);
	        }

	        System.out.println("✅ Saved " + courses.size() + " courses to " + filePath);
	    } catch (IOException e) {
	        System.out.println("❌ Error writing courses to CSV: " + e.getMessage());
	    }
	}
	
	

	/**
	 * Escapes a field for CSV (comma-delimited).
	 * Wraps in quotes if it contains commas, quotes, or newlines.
	 */
	private static String escapeCsv(String field) {
	    if (field == null) return "";
	    field = field.replace("\r", " ").replace("\n", " ");
	    if (field.contains(",") || field.contains("\"")) {
	        field = field.replace("\"", "\"\"");
	        return "\"" + field + "\"";
	    }
	    return field.trim();
	}
	
	// Save Course-Department Pairs to CSV
	public static void saveCourseDepartmentPairsToCSV(HashSet<CourseDepartmentPair> pairs, String filePath) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_PATH + filePath))) {
	        writer.println("CourseID,DepartmentID");
	        for (CourseDepartmentPair pair : pairs) {
	            writer.printf("%d,%d%n", pair.getCourseId(), pair.getDepartmentId());
	        }
	        System.out.println("✅ Saved " + pairs.size() + " course-department pairs to " + filePath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static HashSet<CourseDepartmentPair> loadCourseDepartmentPairsFromCSV(String fileName) {
	    HashSet<CourseDepartmentPair> pairs = new HashSet<>();
	    String inputFile = SAVE_PATH + fileName;

	    try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
	        String line = br.readLine(); // skip header
	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(",", -1);
	            if (parts.length < 2) continue;

	            int courseId = Integer.parseInt(parts[0].trim());
	            int departmentId = Integer.parseInt(parts[1].trim());

	            CourseDepartmentPair pair = new CourseDepartmentPair(courseId, departmentId);
	            pairs.add(pair);
	        }
	        System.out.println("✅ Loaded " + pairs.size() + " course–department pairs from " + inputFile);
	    } catch (IOException e) {
	        System.out.println("⚠️ Error reading course–department pairs from " + inputFile);
	        e.printStackTrace();
	    }

	    return pairs;
	}
	
	// Save Course-Instructor Pairs to CSV
	public static void saveCourseInstructorPairsToCSV(HashSet<CourseInstructorPair> pairs, String filePath) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_PATH + filePath))) {
	        writer.println("CourseID;InstructorID;Semesters");
	        for (CourseInstructorPair pair : pairs) {
	            // Join semesters with a semicolon or other delimiter
	            String semesters = String.join(",", pair.getSemesters());
	            writer.printf("%d;%d;%s%n", pair.getCourseId(), pair.getInstructorId(), semesters);
	        }
	        System.out.println("✅ Saved " + pairs.size() + " course-instructor pairs to " + filePath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static HashSet<Paper> loadPapersFromCSV(String fileName) {
	    HashSet<Paper> papers = new HashSet<>();
	    String inputFile = SAVE_PATH + fileName;

	    try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
	        String line = br.readLine(); // skip header
	        while ((line = br.readLine()) != null) {
	            List<String> parts = parseCsvLine(line);
	            if (parts.size() < 7) continue;

	            int id = Integer.parseInt(parts.get(0).trim());
	            String title = parts.get(1).trim();
	            String url = parts.get(2).trim();
	            String abs = parts.get(3).trim();
	            String publisher = parts.get(4).trim();
	            String source = parts.get(5).trim();
	            String pubDate = parts.get(6).trim();

	            Paper paper = new Paper(id, title, url, abs, publisher, source, pubDate);
	            papers.add(paper);
	        }
	        System.out.println("✅ Loaded " + papers.size() + " papers from " + inputFile);
	    } catch (IOException e) {
	        System.out.println("⚠️ Error reading papers from " + inputFile);
	        e.printStackTrace();
	    }

	    return papers;
	}

	/**
	 * Parses a single CSV line respecting quoted fields.
	 */
	private static List<String> parseCsvLine(String line) {
	    List<String> tokens = new ArrayList<>();
	    if (line == null || line.isEmpty()) return tokens;

	    StringBuilder sb = new StringBuilder();
	    boolean inQuotes = false;

	    for (int i = 0; i < line.length(); i++) {
	        char c = line.charAt(i);
	        if (c == '"') {
	            // Double quote inside quoted field
	            if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
	                sb.append('"');
	                i++; // skip the next quote
	            } else {
	                inQuotes = !inQuotes; // toggle quote state
	            }
	        } else if (c == ',' && !inQuotes) {
	            tokens.add(sb.toString());
	            sb.setLength(0);
	        } else {
	            sb.append(c);
	        }
	    }
	    tokens.add(sb.toString());
	    return tokens;
	}

	/**
	 * Save Papers to CSV.
	 */
	public static void savePapersToCSV(HashSet<Paper> papers, String filePath) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_PATH + filePath))) {
	        writer.println("PaperID,Title,URL,Abstract,Publisher,Source,PubDate");
	        for (Paper paper : papers) {
	            writer.printf("%d,%s,%s,%s,%s,%s,%s%n",
	                    paper.getId(),
	                    escapeCsv(paper.getTitle()),
	                    escapeCsv(paper.getUrl()),
	                    escapeCsv(paper.getAbstractText()),
	                    escapeCsv(paper.getPublisher()),
	                    escapeCsv(paper.getSource()),
	                    escapeCsv(paper.getPubdate()));
	        }
	        System.out.println("✅ Saved " + papers.size() + " papers to " + filePath);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private static HashSet<PaperInstructorPair> loadPaperInstructorPairsFromCSV(String fileName) {
	    HashSet<PaperInstructorPair> pairs = new HashSet<>();
	    String inputFile = SAVE_PATH + fileName;

	    try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
	        String line = br.readLine(); // skip header
	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(",", -1);
	            if (parts.length < 2) continue;

	            int instructorId = Integer.parseInt(parts[0].trim());
	            int paperId = Integer.parseInt(parts[1].trim());

	            PaperInstructorPair pair = new PaperInstructorPair(instructorId, paperId);
	            pairs.add(pair);
	        }
	        System.out.println("✅ Loaded " + pairs.size() + " paper–instructor pairs from " + inputFile);
	    } catch (IOException e) {
	        System.out.println("⚠️ Error reading paper–instructor pairs from " + inputFile);
	        e.printStackTrace();
	    }

	    return pairs;
	}

	/**
	 * Save Paper-Instructor Pairs to CSV.
	 */
	public static void savePaperInstructorPairsToCSV(HashSet<PaperInstructorPair> pairs, String filePath) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_PATH + filePath))) {
	        writer.println("PaperID, InstructorID");
	        for (PaperInstructorPair pair : pairs) {
	            writer.printf("%d,%d%n", pair.getPaperId(), pair.getInstructorId());
	        }
	        System.out.println("✅ Saved " + pairs.size() + " paper-instructor pairs to " + filePath);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void saveCourseRequirementPairsToCSV(HashSet<CourseRequirementPair> pairs, String filePath) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_PATH + filePath))) {
	        // Header
	        writer.println("CourseID,PrereqID,Alternatives");

	        for (CourseRequirementPair pair : pairs) {
	            String courseId = String.valueOf(pair.getCourseId());
	            String prereqId = String.valueOf(pair.getPrereqId());
	            String alternatives = escapeCsv(pair.getAlternatives().replaceAll("[\\r\\n]+", " "));

	            writer.printf("%s,%s,%s%n", courseId, prereqId, alternatives);
	        }

	        System.out.println("✅ Saved " + pairs.size() + " course requirement pairs to " + filePath);
	    } catch (IOException e) {
	        System.out.println("❌ Error writing course requirement pairs to CSV: " + e.getMessage());
	    }
	}

	// Utility to extract the description text from the inner HTML of the description div
	private static String extractDescriptionFromHtml(String html) {
		// The html looks like:
		// <b>ECE 2200 Applied Physics</b>&nbsp;&nbsp;<a href=...>Student Evaluations</a><br>DESCRIPTION TEXT...

		// Find the <br> tag position
		int brIndex = html.indexOf("<br>");
		if (brIndex == -1) {
			return cleanHtmlText(html); // fallback: clean all tags
		}

		// Get substring after <br>
		String afterBr = html.substring(brIndex + 4).trim();

		// Clean HTML tags from the substring
		return cleanHtmlText(afterBr);
	}

	// Basic HTML tag stripper (removes all tags, unescapes common entities)
	private static String cleanHtmlText(String html) {
		// Remove all tags using regex
		String noTags = html.replaceAll("<[^>]*>", "");

		// Replace common HTML entities (add more as needed)
		String unescaped = noTags.replace("&nbsp;", " ")
				.replace("&amp;", "&")
				.replace("&lt;", "<")
				.replace("&gt;", ">")
				.replace("&quot;", "\"")
				.replace("&#39;", "'");

		// Normalize whitespace
		return unescaped.replaceAll("\\s+", " ").trim();
	}
	
	private static void cleanPaperYears(HashSet<Paper> papers) {
	    int fixed = 0;

	    for (Paper paper : papers) {
	        String date = paper.getPubdate();
	        if (date == null || date.isEmpty()) continue;

	        // Extract a 2- or 4-digit year pattern
	        Matcher m = Pattern.compile("(\\d{4}|\\d{2})").matcher(date);
	        if (m.find()) {
	            String year = m.group(1);

	            // Normalize to 4 digits
	            if (year.length() == 2) {
	                int yr = Integer.parseInt(year);
	                if (yr >= 50) year = "19" + year; // assume 1950–1999
	                else year = "20" + year;          // assume 2000–2049
	            }

	            if (!year.equals(paper.getPubdate())) {
	                paper.setPubdate(year);
	                fixed++;
	            }
	        } else {
	            paper.setPubdate(""); // no year found
	        }
	    }

	    System.out.println("✅ Cleaned publication years for " + fixed + " papers.");
	}
}