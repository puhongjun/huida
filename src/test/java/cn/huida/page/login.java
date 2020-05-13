package cn.huida.page;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import cn.huida.util.set;
import junit.framework.Assert;

public class login {
	WebDriver driver;
	
	@BeforeMethod
	public  void before(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public  void test(){
		driver.get("http://hit.huidatech.cn/ui/login.html");
		driver.findElement(By.id("loginName")).sendKeys("lu");
		driver.findElement(By.id("password")).sendKeys("talent17");
		driver.findElement(By.id("login")).click();
		By homepage=By.xpath("//*[text()='农机分布']");
		WebDriverWait home=new WebDriverWait(driver,10);
		home.until(ExpectedConditions.presenceOfAllElementsLocatedBy(homepage));
		String hometext=driver.findElement(By.xpath("//*[text()='农机分布']")).getText();
		System.out.println(hometext);
		Assert.assertEquals("农机分布", hometext);
		String homeWindowHandle=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[text()='深松作业']")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		if(!allWindowHandles.isEmpty()){
		for(String Handles:allWindowHandles){
			if(driver.switchTo().window(Handles).getTitle().equals("深松作业")){
				//等待日期控件
				WebDriverWait dataWait=new WebDriverWait(driver,10);
				dataWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='beginDate']")));
				driver.findElement(By.xpath("//*[@placeholder='选择单位']")).sendKeys("青岛市");
				driver.findElement(By.xpath("//*[@id='q_deviceId']")).sendKeys("10000E64");
				//通过JS直接进行赋值给日期框
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("document.getElementById('beginDate').value='2020-05-10'");
				
				//查询按钮
				driver.findElement(By.xpath("//button[@id='query']/img")).click();
//				By table=By.xpath("//*[@id='list']/tr[1]/td[12]/button");
//				WebDriverWait zhiwait=new WebDriverWait(driver,10);
//				zhiwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(table));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//操作表格tr[1]/td[12]表示第1行12列
				driver.findElement(By.xpath("//*[@id='list']/tr[1]/td[12]/button")).click();
				String zm=driver.findElement(By.xpath("//*[@id='list']/tr[1]/td[4]")).getText();
				String hm=driver.findElement(By.xpath("//*[@id='list']/tr[1]/td[5]")).getText();
				String zmr=zm.substring(0, 4);
				String hmr=hm.substring(0, 4);
				System.out.println("zmr="+zmr+"  hmr="+hmr);
		
				Set<String> allToHandles=driver.getWindowHandles();
				if(!allToHandles.isEmpty()){
					for(String toHandles:allToHandles){
						if(driver.switchTo().window(toHandles).getTitle().equals("质量分析")){
							//获取文本
//							String deviceid=driver.findElement(By.xpath("//*[@class='njr zyr']/ul/li[1]/span")).getAttribute("textContent");
							
							WebElement zymj=driver.findElement(By.id("areaPlatform"));
							set.setAttribute(driver,zymj,"style","display: block");
							String zymjtext=zymj.getText();
							System.out.println("zymjtext="+zymjtext);
//							String hgmj=driver.findElement(By.id("area")).getText();
//							System.out.println("deviceid="+deviceid+" zymj="+zymj+" hgmj="+hgmj);
//							String zymjr=zymj.substring(0,3);
//							String hgmjr=hgmj.substring(0,3);
//							System.out.println("zymjr="+zymjr+" hgmjr="+hgmjr);
						}
					}
				}
			}
		}
			
			}
		
	}
	
	@AfterMethod
	public  void after(){
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
