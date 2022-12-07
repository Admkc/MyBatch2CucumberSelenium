package com.krafttech.step_definitions;

import com.krafttech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    /**
     specifik olarak featura baglı degil
     testlerde kulalanacagımız after before
     */

    @Before
    public void setUp(){
        System.out.println("This is coming from before Method");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();

    }
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("This is coming from After Method");
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }
    @Before("@db")  //db tag in oldugu seneryoyu calıstırır
    public void setUpDb(){
        System.out.println("Connection DB");

    }
    @After("@db")
    public void teardownDb(){
        System.out.println("Disconnection DB");

    }
}
