//// Observer is taken from: http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/
package com.labs.cse110.observerpattern;

/**
 * Created by Haseeb on 3/1/2018.
 */

public interface Subject {

    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();
}
