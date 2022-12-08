package com.krafttech.utilities;


import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Map;


public class Karalama {
    /**Kullanici https://www.krafttechexlab.com/login Links to an external site.adresine gider.
    Gecerli kullanici kriterleri ile giris yapar.
    Kullanici sayfanin en ust sag tarafinda yer alan Dashboard, Developers Edit Profile ve login olan Kullanicinin adinin yazili oldugu basliklari gorur.
            (Not: List kullanarak yapilacak)



    HW 2

    Kullanici https://www.krafttechexlab.com/login Links to an external site.adresine gider.
    Gecerli kullanici kriterleri ile giris yapar.
    MY Profile altinda bulunan Add Experience modulune gider.
    Ilgili kutulari doldurur.
    Add Experience button click eder.
    Overview modulune dondugunu verify eder.
     */

    @Then("User should input following credentials")
    public void user_should_input_following_credentials(Map<String,String> userInfo) {
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();

        loginPage.loginWithParameters(userInfo.get("email"),userInfo.get("password"));

        String act=dashboardPage.getUserName();
        String exp=userInfo.get("Name");

        System.out.println("act = " + act);
        System.out.println("exp = " + exp);

        Assert.assertEquals(exp,act);

    }
    }