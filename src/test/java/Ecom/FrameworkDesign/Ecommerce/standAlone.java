package Ecom.FrameworkDesign.Ecommerce;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standAlone {
	 static WebDriver driver;
	 static String[] Reqproducts= {"Carrot","Cucumber","Brocolli","Tomato"};

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
    
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		additems(driver,Reqproducts);
	}
	
		
		public static void  additems(WebDriver driver,String[] Reqproducts)
		{
			
			
    int j =0;
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		for (int i = 0; i < products.size(); i++) {

			String[] ProductName = products.get(i).getText().split("-");
			String FormattedProductName=ProductName[0].trim();
			List ReqProductNames=Arrays.asList(Reqproducts);
			if(ReqProductNames.contains(FormattedProductName))
			{
				
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==Reqproducts.length)
				{
					break;
				}
			
			}

		}
	}
}
