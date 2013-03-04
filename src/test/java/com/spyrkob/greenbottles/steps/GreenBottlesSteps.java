package com.spyrkob.greenbottles.steps;

import static org.junit.Assert.*;

import java.awt.Color;

import com.spyrkob.greenbottles.Bottle;
import com.spyrkob.greenbottles.Wall;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GreenBottlesSteps {
    private Wall wall;

    @Given("^(\\d+) green bottles sitting on the wall$")
    public void green_bottles_sitting_on_the_wall(int bottlesCount)
            throws Throwable {
        wall = new Wall(10, Color.GREEN);
    }

    @When("^one green bottle should accidently fall$")
    public void one_green_bottle_should_accidently_fall() throws Throwable {
        wall.makeAccident();
    }

    @Then("^there will be (\\d+) green bottles sitting on the wall$")
    public void there_will_be_green_bottles_sitting_on_the_wall(int bottlesCount)
            throws Throwable {
        assertEquals(bottlesCount, wall.bottles().size());
        for (Bottle bottle : wall.bottles()) {
            assertEquals(Color.GREEN, bottle.color());
        }
    }
}
