package cn.huida.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class set {
	//增加页面元素属性和修改页面元素属性的封装方法
	public static void setAttribute(WebDriver driver,WebElement element,String attributeName,String value){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element,attributeName,value);
	}
	
	//删除页面元素属性的封装方法
	public static void removAttribute(WebDriver driver,WebElement element,String attributeName){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute(arguments[1],arguments[2])",element,attributeName);
	}
}
