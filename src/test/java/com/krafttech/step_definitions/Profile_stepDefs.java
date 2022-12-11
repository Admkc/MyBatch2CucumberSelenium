package com.krafttech.step_definitions;

import com.krafttech.pages.ProfilePage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Profile_stepDefs {

    ProfilePage profilePage=new ProfilePage();

    @When("User should go to My Profile")
    public void user_should_go_to_my_profile() {

        BrowserUtils.waitForClickablility(profilePage.myProfileBtn,5);
        profilePage.myProfileBtn.click();

    }
    @When("User should navigate to {string}")
    public void user_should_navigate_to(String tabName) {
        profilePage.profileTabs(tabName);

    }
    @When("User should input the information boxes")
    public void user_should_input_the_information_boxes() {
        profilePage.fullName.clear();
        profilePage.fullName.sendKeys("Harun");
        profilePage.about.sendKeys("This is great work");
        profilePage.company.sendKeys("GHAN IT");

        BrowserUtils.waitForVisibility(profilePage.slider,5);
        BrowserUtils.dragAndDropBy(profilePage.slider,150,0);

        Select select=new Select(profilePage.job);
        select.selectByVisibleText("SDET");

        profilePage.website.sendKeys("krafttechnologie.com");
        profilePage.location.sendKeys("Ankara");
        profilePage.skills.sendKeys("Postman, RestAssured, API, SQL");
        BrowserUtils.clickWithJS(profilePage.save);

    }
    @Then("User should verify the profile updated message")
    public void user_should_verify_the_profile_updated_message() {

        BrowserUtils.waitFor(4);
        String actualMsg= profilePage.profileUpdatemsg.getText();
        String expctedMsg= "Profile Updated";

        Assert.assertEquals(expctedMsg,actualMsg);

    }
    @Then("User should see the profile options")
    public void user_should_see_the_profile_options(List<String>OPtions) {


        List<String> actualOptions= BrowserUtils.getElementsText(profilePage.profileOptions);
        System.out.println("actualOptions.size() = " + actualOptions.size());

        System.out.println("actualOptions = " + actualOptions);
        System.out.println("profileOPtions = " + OPtions);

        Assert.assertEquals(OPtions,actualOptions);
    }


    @Then("User should see the profile options only three")
    public void userShouldSeeTheProfileOptionsOnlyThree(List<String > option) {

        List<String > act=BrowserUtils.getElementsText(profilePage.profilOp_loc);
        System.out.println("act.size() = " + act.size());

        System.out.println("act = " + act);
        System.out.println("option = " + option);

        Assert.assertEquals(option,act);
    }

    @When("User should go to addExprience")
    public void user_should_go_to_add_exprience() {
        BrowserUtils.waitFor(2);
        profilePage.addExperienceBtn.click();


    }
    @And("ilgili kutulari doldur")
    public void ilgiliKutulariDoldur() {
        profilePage.jobTitle.sendKeys("QA");
        profilePage.company.sendKeys("Kraft");
        profilePage.location.sendKeys("Ankara");
        profilePage.profileUpdate.sendKeys("12/12/2002");
        profilePage.job.click();
        profilePage.jobDescription.sendKeys("testing");

    }
    @When("add exprience a click yap")
    public void add_exprience_a_click_yap() {
        profilePage.addExperienceBtn.click();

    }
    @Then("Overview modulune dondugunu verify et")
    public void overview_modulune_dondugunu_verify_et() {

        Driver.get().navigate().back();
        String act=Driver.get().getTitle();
        String exp="Overview";


    }


}