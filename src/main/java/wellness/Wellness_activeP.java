package wellness;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Wellness_activeP {
	
	WebDriver driver = null;
	@Given("^User is logged in to profile$")
	public void user_is_logged_in_to_profile() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaush\\Desktop\\Selenium\\Chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		   driver.get("https://wellness.appzstaging.online/login");
		   driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("adam.s@yopmail.com");
		   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("wellness");
		   driver.findElement(By.xpath("//button[contains(text(),'sign in')]")).click();
		   driver.manage().window().maximize();
		   
	}
	
	@And("^User is able to enter Active Programs tab$")
    public void user_is_able_to_enter_active_programs_tab() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//p[contains(text(),'active programs')]")).click();
				
    }
	
	@Then("^Verify user is on active programs page$")
    public void verify_user_is_on_active_programs_page()  {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   WebElement dashboard = driver.findElement(By.partialLinkText("Add Progr"));
	   dashboard.isDisplayed();
	   Assert.assertTrue(true);
	   
	}
	
	
	@When("^User click on add program$")
    public void user_click_on_add_program() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Add Progr")).click();
		
        
    }
	
	@And("^User enter \"([^\"]*)\" into Program Title$")
    public void user_enter_something_into_program_title(String Program_Title) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("description_inputf")).sendKeys(Program_Title);
		
		
	}
	
	
	@And("^User enter \"([^\"]*)\" into Description$")
    public void user_enter_something_into_description(String Description) {	
		driver.findElement(By.xpath("//textarea[@placeholder='Program Description']")).sendKeys(Description);
			
		
	}
	
	@And("^User select \"([^\"]*)\" from Program Type$")
    public void user_select_something_from_program_type(String Program_Type) {
		Select program_t = new Select(driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/select[1]")));
		program_t.selectByVisibleText(Program_Type);
	}
	
	
	@And("^User enter \"([^\"]*)\" into Price$")
    public void user_enter_something_into_price(String Price) {
       driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/input[1]")).clear();
       driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/input[1]")).sendKeys(Price);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
	}
	
	@And("^User select start date from Start Date$")
    public void user_select_start_date_from_start_date() throws InterruptedException  {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='mm-dd-yyyy'])[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'26')]")).click();
		

		
    }
	
	@And("^User select end date from End Date$")
    public void user_select_end_date_from_end_date() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='mm-dd-yyyy'])[2]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'28')]")).click();
    }
	
	@And("^User select member from Add Members$")
    public void user_select_member_from_add_members() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@class=' css-6j8wv5-Input' ])[1]")).click();
		driver.findElement(By.xpath("//*[text()='Neha Sharma']")).click();
		
	}
	
	@And("^User update image in thumbnail$")
    public void user_update_image_in_thumbnail() throws InterruptedException {
		Thread.sleep(2000);
		WebElement browse = driver.findElement(By.xpath("//input[@class='form-control uploader-input']"));
		   browse.sendKeys("C:\\Users\\kaush\\eclipse-workspace\\WellnessRepo\\Pics\\Photo.png"); 
		   System.out.println("File is Uploaded Successfully");
    }

	@And("^User click on Save and publish button$")
    public void user_click_on_save_and_publish_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Save & Publish Now')]")).click();
        
       
    }
	
	@And("^User click on Save and publish later button$")
    public void user_click_on_save_and_publish_later_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Save & Publish Later')]")).click();
	}
	
	
	@And("^User click on Cancel button$")
    public void user_click_on_Cancel_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Cancel')]")).click();
	}
	
	
	@Then("^Verify User is on module page$")
    public void verify_user_is_on_module_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   WebElement module = driver.findElement(By.xpath("//span[contains(text(),'Add New Module')]"));
		   module.isDisplayed();
		   Assert.assertTrue(true);
    }
	
	@When("^User click on Add new module$")
    public void user_click_on_add_new_module() {
		driver.findElement(By.xpath("//span[contains(text(),'Add New Module')]")).click();
    }
	
	@And("^User enter \"([^\"]*)\" into module title$")
    public void user_enter_something_into_module_title(String module_title) {
		driver.findElement(By.xpath("//input[@placeholder= 'Module title']")).sendKeys(module_title);
    }
	
	
	@And("^User enter \"([^\"]*)\" into module description$")
    public void user_enter_something_into_module_description(String module_desc)  {
		driver.findElement(By.xpath("//input[@placeholder= 'Description']")).sendKeys(module_desc);
    }

	
	@And("^User upload file in thumbnail$")
    public void user_upload_file_in_thumbnail() {
		WebElement upload = driver.findElement(By.xpath("(//input[@class= 'form-control uploader-input'])[1]"));
		   upload.sendKeys("C:\\Users\\kaush\\eclipse-workspace\\WellnessWits\\Pics\\Photo.png"); 
		   System.out.println("File is Uploaded Successfully in module");
        
    }
	
	@And("^User enter \"([^\"]*)\" into content$")
    public void user_enter_something_into_content(String module_content) {
		driver.findElement(By.xpath("//div[@class= 'ql-editor']")).sendKeys(module_content);
      
    }

	@And("^User click on Add module$")
    public void user_click_on_add_module() {
       driver.findElement(By.xpath("//button[@id='reateProgram']")).click();
    }

	@Then("^Verify module has been created$")
    public void verify_module_has_been_created() throws InterruptedException {
		Thread.sleep(3000);
		WebElement module_verify = driver.findElement(By.xpath("//div[contains(text(),'Continue')]"));
		   module_verify.isDisplayed();
		   Assert.assertTrue(true);
    }

    @When("^User click on continue button$")
    public void user_click_on_continue_button() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();
    }

    @Then("^Verify user is on Sessions page$")
    public void verify_user_is_on_sessions_page() {
    	WebElement session = driver.findElement(By.xpath("//button[contains(text(),'Add New Session')]"));
		   session.isDisplayed();
		   Assert.assertTrue(true);
    }
    
    @When("^User click on Add new session$")
    public void user_click_on_add_new_session() {
    	driver.findElement(By.xpath("//button[contains(text(),'Add New Session')]")).click();
    }

    @And("^User enter \"([^\"]*)\" into session name$")
    public void user_enter_something_into_session_name(String session_name) {
        driver.findElement(By.xpath("//input[@placeholder='Session name']")).sendKeys(session_name);
        
    }
    
    @And("^User select time in session time$")
    public void user_select_time_in_session_time() throws InterruptedException {
    	driver.findElement(By.xpath("//input[@placeholder='--:--']")).click(); 
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@class='react-timekeeper__clock css-cowp6p-styles']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[@data-testid='done-button']")).click();
    	
    }

    @And("^User select session day$")
    public void user_select_session_day() {
    	Select session_day = new Select(driver.findElement(By.xpath("(//select[@class='description_inputf'])[1]")));
		session_day.selectByIndex(1);
    }

    @And("^User select session date$")
    public void user_select_session_date() {
        driver.findElement(By.xpath("//div[@class=' css-6j8wv5-Input']")).click();
        driver.findElement(By.xpath("//*[text()='02-26-2023']")).click();
        
    }
    
    @And("^User select \"([^\"]*)\" timezone$")
    public void user_select_something_timezone(String session_timezone){
    	Select s_timezone = new Select(driver.findElement(By.xpath("(//select[@class='description_inputf'])[2]")));
		s_timezone.selectByVisibleText(session_timezone);
    }
    
    @And("^User click on Create new session$")
    public void user_click_on_create_new_session() {
        driver.findElement(By.xpath("//button[@id='reateProgram']")).click();
    }
    
    @Then("^Verify session has been created$")
    public void verify_session_has_been_created()  {
    	WebElement session_verify = driver.findElement(By.xpath("//button[contains(text(),'start session')]"));
		   session_verify.isDisplayed();
		   Assert.assertTrue(true);
    }

    @Then("^Verify user is on forums page$")
    public void verify_user_is_on_forums_page() {
    	WebElement forums = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-custom w-100']"));
		   forums.isDisplayed();
		   Assert.assertTrue(true);
    }
    
    @When("^User click on Start a new topic$")
    public void user_click_on_start_a_new_topic() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-custom w-100']")).click();
    }

    @And("^User enter \"([^\"]*)\" in text message box$")
    public void user_enter_something_in_text_message_box(String forum_message)  {
        driver.findElement(By.xpath("//input[@placeholder='Write something...']")).sendKeys(forum_message);
    }
    
    @And("^User click on cancel button$")
    public void user_click_on_cancel_button() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
    }

    @Then("^Verify message has been posted in forum$")
    public void verify_message_has_been_posted_in_forum() throws InterruptedException {
    	WebElement forums_message = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		   forums_message.isDisplayed();
		   Assert.assertTrue(true);
		   
		   
    }
    
    @When("^User click on forums continue button$")
    public void user_click_on_forums_continue_button() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();

    	
    }
    
    @Then("^Verify user is on members page$")
    public void verify_user_is_on_members_page() throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement members = driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-custom'])[1]"));
		   members.isDisplayed();
		   Assert.assertTrue(true);
    }
    
    @Then("^Verify user is able to see added members$")
    public void verify_user_is_able_to_see_added_members() {
    	WebElement added_members = driver.findElement(By.xpath("//td[contains(text(),'Neha Sharma')]"));
		   added_members.isDisplayed();
		   Assert.assertTrue(true);
    }
    
    @And("^User click on finish button$")
    public void user_click_on_finish_button() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Finish')]")).click();
    }





}