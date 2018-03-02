package com.labs.cse110.observerpattern;

// Represents each Observer that is monitoring changes in the subject

public class StockObserver implements Observer {

    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    // Some result variable to return to the controller
    private String dispStr;

    // Static used as a counter
    private static int observerIDTracker = 0;

    // Used to track the observers
    private int observerID;

    // Will hold reference to the StockGrabber object
    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {

        // Store the reference to the stockGrabber object so
        // I can make calls to its methods

        this.stockGrabber = stockGrabber;

        // Assign an observer ID and increment the static counter
        this.observerID = ++observerIDTracker;

        // Message notifies user of new observer
        System.out.println("New Observer " + this.observerID);

        // Add the observer to the Subjects ArrayList
        stockGrabber.register(this);

    }

    // Called to update all observers
    public void update(double ibmPrice, double aaplPrice, double googPrice) {

        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        MainActivity.refreshView(toStr(), getID());

    }

    public String toStr() {

        dispStr = (observerID + " -> IBM: " + ibmPrice + "; AAPL: " +
                aaplPrice + "; GOOG: " + googPrice);

        return dispStr;
    }

    public int getID() {
        return observerID;
    }

}
