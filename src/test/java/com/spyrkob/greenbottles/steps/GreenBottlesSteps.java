package com.spyrkob.greenbottles.steps;

import static org.junit.Assert.*;

import java.awt.Color;

import com.spyrkob.greenbottles.Bottle;
import com.spyrkob.greenbottles.Wall;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GreenBottlesSteps {
    private Wall wall;
    
    @After("@bottles")
    public void tearDown() {
        wall.cleanUp();
    }

    @Given("^(\\d+) green bottles sitting on the wall$")
    public void prepareBottles(int bottlesCount)
            throws Throwable {
        wall = new Wall(10, Color.GREEN);
    }

    @When("^one green bottle should accidently fall$")
    public void causeAccident() throws Throwable {
        wall.makeAccident();
    }

    @Then("^there will be (\\d+) green bottles sitting on the wall$")
    public void verifyNumberAndColorOfBottles(int bottlesCount)
            throws Throwable {
        assertEquals(bottlesCount, wall.bottles().size());
        for (Bottle bottle : wall.bottles()) {
            assertEquals(Color.GREEN, bottle.color());
        }
    }
}
