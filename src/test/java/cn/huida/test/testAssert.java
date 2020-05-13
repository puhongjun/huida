package cn.huida.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testAssert {
	WebDriver driver;
	@BeforeMethod
	public void before(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void test1(){
		driver.get("http://hit.huidatech.cn/ui/login.html");
		String huidaTitle=driver.getTitle();
		driver.get("http://www.baidu.com/");
		String baiduTitle=driver.getTitle();
		System.out.println("hudiatitle ["+huidaTitle+"] baiduTitle ["+baiduTitle+"]");
//		Assert.assertEquals(huidaTitle,baiduTitle);
		try{
			Assert.assertEquals(huidaTitle,baiduTitle);
		}catch(AssertionError error){
			Assert.fail("惠达Title["+huidaTitle+"]和百度Title["+baiduTitle+"]不一样");
		}
		
	}
	
	@Test
	public void test2(){
		driver.get("http://hit.huidatech.cn/ui/login.html");
		String huidaTitle=driver.getTitle();
		driver.get("http://hit.huidatech.cn/ui/login.html");
		String huidaTitle1=driver.getTitle();
		System.out.println("huidatitle ["+huidaTitle+"] huidaTitle1 ["+huidaTitle1+"]");
		try{
			Assert.assertEquals(huidaTitle1,huidaTitle);
		}catch(AssertionError error){
			Assert.fail("惠达Title1["+huidaTitle1+"]和惠达Title["+huidaTitle+"]不一样");
		}
		
	}
	
	@Test
	public void test3(){
		driver.get("http://www.baidu.com/");
		String baiduTitle=driver.getTitle();
		driver.get("http://www.baidu.com/");
		String baiduTitle1=driver.getTitle();
		System.out.println("baidutitle ["+baiduTitle+"] baiduTitle1 ["+baiduTitle1+"]");
		try{
			Assert.assertEquals(baiduTitle1,baiduTitle);
		}catch(AssertionError error){
			Assert.fail("百度Title1["+baiduTitle1+"]和百度Title["+baiduTitle+"]不一样");
		}
		
	}
	
	@Test
	public void test4(){
		driver.get("http://www.baidu.com/");
		String baiduTitle=driver.getTitle();
		driver.get("http://www.baidu.com/");
		String baiduTitle1=driver.getTitle();
		System.out.println("baidutitle ["+baiduTitle+"] baiduTitle1 ["+baiduTitle1+"]");
		try{
			Assert.assertEquals(baiduTitle1,baiduTitle);
		}catch(AssertionError error){
			Assert.fail("百度Title1["+baiduTitle1+"]和百度Title["+baiduTitle+"]不一样");
		}
		
	}
	
	@Test
	public void test5(){
		driver.get("http://www.baidu.com/");
		String baiduTitle=driver.getTitle();
		driver.get("http://www.baidu.com/");
		String baiduTitle1=driver.getTitle();
		System.out.println("baidutitle ["+baiduTitle+"] baiduTitle1 ["+baiduTitle1+"]");
		try{
			Assert.assertEquals(baiduTitle1,baiduTitle);
		}catch(AssertionError error){
			Assert.fail("百度Title1["+baiduTitle1+"]和百度Title["+baiduTitle+"]不一样");
		}
		
	}
		
	@AfterMethod
	public void after(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
