// Observer is taken from: http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/
package com.labs.cse110.observerpattern;

/**
 * Created by Haseeb on 3/1/2018.
 */

public interface Observer {

    public void update(double ibmPrice, double applPrice, double googPrice);

}
