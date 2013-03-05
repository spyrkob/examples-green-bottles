package com.spyrkob.greenbottles;

import java.awt.Color;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Wall {

    private Stack<Bottle> bottles;

    public Wall(int bottlesCount, Color bottleColor) {
        bottles = new Stack<>();
        for(int i=0; i<bottlesCount; i++){
            bottles.push(new Bottle(bottleColor));
        }
    }

    public Collection<Bottle> bottles() {
        return Collections.unmodifiableCollection(bottles);
    }

    public void makeAccident() {
        bottles.pop();
    }

    public void cleanUp() {
        bottles = null;
    }

}
