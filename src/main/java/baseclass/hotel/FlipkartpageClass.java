package baseclass.hotel;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartpageClass extends FlipkartBase{
	public FlipkartpageClass() {
		PageFactory.initElements(driver,this);
		}	
	@FindBy(name="q")
	private WebElement productSearch;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnsubmit;
	@FindBy(xpath="//div[@class='_4rR01T']")////div[contains(text(),'APPLE iPhone')],//div[@class='_30jeq3 _1_WHN1']
	private WebElement requriedProduct;
	@FindBy(xpath="//button[@type='button']")
	private WebElement buyCart;
	@FindBy(xpath="//input[@type='text']")
	private WebElement emailOrPnonenumber;
	@FindBy(xpath="//input[@type='password']")
	private WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnlogin;
	@CacheLookup
	@FindAll({@FindBy(xpath="//div[contains(text(),'APPLE iPhone')]")})
	private List<WebElement> listproduct;
	@CacheLookup
	@FindAll({@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")})
	private List<WebElement> listproductrate;
	@CacheLookup
	@FindAll({@FindBy(xpath="//a[@class='ge-49M']")})
	private List<WebElement> PageList;
	public List<WebElement> getPageList() {
		return PageList;
	}
	public List<WebElement> getListproduct() {
		return listproduct;
	}
	public List<WebElement> getListproductrate() {
		return listproductrate;
	}
	public WebElement getBtnlogin() {
		return btnlogin;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getEmailOrPnonenumber() {
		return emailOrPnonenumber ;
	}
	public WebElement getBuyCart() {
		return buyCart;
	}
	public WebElement getProductSearch() {
		return productSearch;
	}
	public WebElement getBtnsubmit() {
		return btnsubmit;
	}
	public WebElement getRequriedProduct() {
		return requriedProduct;
	}
	
	
	


}
