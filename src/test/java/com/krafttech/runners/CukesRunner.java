package com.krafttech.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"json:target/cucumber.json"},


        features = "src/test/resources/features",
        glue = "com/krafttech/step_definitions",

        dryRun = false, //tanımlanmış ise stepler false ,tanımlanmamış ise true

       tags ="@wip"


                  )


public class CukesRunner {



}
