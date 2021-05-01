package com.example.todo_09;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import androidx.test.filters.SmallTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)

@SmallTest

public class ExampleUnitTest {
    private Calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    @Test
    public void addtwoNumber() {
        double result = mCalculator.add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }

    @Test
    public void addTwoNumberForNegatives(){
        double result=mCalculator.add(-1d, 2d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumberFloats(){
        double result=mCalculator.add(1.111f, 1.111f);
        assertThat(result, is(closeTo(2.222d, 0.01)));
    }

    @Test
    public void subTwoNumber(){
        double result=mCalculator.sub(3d, 2d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void subWorksWithNegativeResult(){
        double result=mCalculator.sub(1d, 2d);
        assertThat(result, is(equalTo(-1d)));
    }

    @Test
    public void mulTwoNumber(){
        double result=mCalculator.mul(1d, 2d);
        assertThat(result, is(equalTo(2d)));
    }

    @Test
    public void mulTwoNumberZero(){
        double result=mCalculator.mul(1d, 0d);
        assertThat(result, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumber(){
        double result=mCalculator.div(2d, 2d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void divTwoNumberZero(){
        double result=mCalculator.div(1d, 0);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }


}




