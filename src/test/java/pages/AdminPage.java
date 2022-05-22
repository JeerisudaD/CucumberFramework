package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AdminPage extends CommonMethods {
    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement AdminOption;

    @FindBy(id="menu_admin_Qualifications")
    public  WebElement GG;

    @FindBy(id = "menu_admin_viewLicenses")
    public WebElement qualificationsLicenses;

    @FindBy(id = "btnAdd")
    public WebElement addLicenseButton;

    @FindBy(xpath = "//input[@class='block default editable valid']")
    public WebElement AddLicenseField;

    @FindBy(id = "btnSave")
    public WebElement saveLicenseButton;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }
}
