package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import utils.CommonMethods;


public class AddLicensesSteps extends CommonMethods {
    @When("user clicks on Admin option")
    public void user_clicks_on_admin_option() {
        click(adminPage.AdminOption);
    }
    @When("user clicks on add QualificationsLicense option")
    public void user_clicks_on_add_qualifications_license_option() throws InterruptedException {
       click(adminPage.GG);
        click(adminPage.qualificationsLicenses);
    }

    @When("user clicks on add license option")
    public void user_clicks_on_add_license_option() {
        click(adminPage.addLicenseButton);
    }
    @When("user enters license name")
    public void user_enters_license_name() {
        sendText(adminPage.AddLicenseField, "JavaLicense");
    }

    @When("user clicks on save license button")
    public void user_clicks_on_save_license_button() {
        click(adminPage.saveLicenseButton);
    }

    @Then("License added successfully")
    public void license_added_successfully() {
//waiting for verify
    }
}
