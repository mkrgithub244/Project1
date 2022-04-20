package baseclass.hotel;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClassHotel extends BaseClassHotel {
	public PageClassHotel() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindAll({@FindBy(xpath="//input")})
	private List<WebElement> Txt;
	@CacheLookup
	@FindAll({@FindBy(xpath="//select")})
	private List<WebElement>Select;
	@FindBy(id="datepick_in")
	private WebElement checkinDate;
	@FindBy(id="datepick_out")
	private WebElement checkoutDate;
	@FindBy(id="Submit")
	private WebElement submit;
	@FindBy(id="Reset")
	private WebElement reset;
	@FindBy(xpath="//input[@type='radio']")
	private WebElement radiobutton;
	
	

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getReset() {
		return reset;
	}

	public void setSelect(List<WebElement> select) {
		Select = select;
	}

	public List<WebElement> getTxt() {
		return Txt;
	}
	
	public List<WebElement> getSelect() {
		return Select;
	}
	
	
	public WebElement getCheckinDate() {
		return checkinDate;
	}

	public WebElement getCheckoutDate() {
		return checkoutDate;
	}

	public void login(String Username , String Password ,String indate, String outdate) throws AWTException {
	sendKeys(getTxt().get(0), Username);
	sendKeys(getTxt().get(1), Password);
	btnclick(getTxt().get(2));
	select(getSelect().get(0), 2);
	select(getSelect().get(1), 1);
	select(getSelect().get(2), 3);
	select(getSelect().get(3), 1);
	datesendKeys(getCheckinDate(), indate);
	datesendKeys(getCheckoutDate(), outdate);
	select(getSelect().get(4), 1);
	select(getSelect().get(5), 0);
	btnclick(getSubmit());
	btnclick(getRadiobutton());

	}
	
}