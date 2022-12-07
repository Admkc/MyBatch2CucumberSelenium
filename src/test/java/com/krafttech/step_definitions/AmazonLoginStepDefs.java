package com.krafttech.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonLoginStepDefs {

    @Given("go to amazon")
    public void go_to_amazon() {
        System.out.println("Amazona gidildi");

    }

    @Given("logine tikla")
    public void logine_tikla() {

        System.out.println("logine tiklandi");


    }

    @Given("isim ver")
    public void isim_ver() {
        System.out.println("isim yazil");

    }

    @Given("sifre gir")
    public void sifre_gir() {

        System.out.println("sifre girildi");

    }

    @When("submite click yaptiginda")
    public void submite_click_yaptiginda() {

        System.out.println("sifre girildi");

    }

    @Then("success mesajini verify et")
    public void success_mesajini_verify_et() {

        System.out.println("\"mesaj dogrulandı\" = " + "mesaj dogrulandı");

    }
    @When("take current url")
    public void take_current_url() {
        System.out.println("true know");
    }


}
