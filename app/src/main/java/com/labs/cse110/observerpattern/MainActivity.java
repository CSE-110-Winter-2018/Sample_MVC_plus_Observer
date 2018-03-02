// Observer is taken from: http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/
package com.labs.cse110.observerpattern;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private StockGrabber stockExchange; // Stock brokers observe stockExchange
    private EditText liloBooks;
    private EditText stitchBooks;
    StockObserver lilo;
    StockObserver stitch;
    private EditText ibmStock;
    private EditText appleStock;
    private EditText googleStock;
    private static Map<Integer, EditText> obsToView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obsToView = new HashMap<Integer, EditText>(); // will contain mapping from model to view

        stockExchange = new StockGrabber(); // Stock brokers observe stockExchange

        liloBooks = (EditText) findViewById(R.id.lilo_books);
        stitchBooks = (EditText) findViewById(R.id.stitch_books);


        // Initialize observers
        lilo = new StockObserver(stockExchange);
        stitch = new StockObserver(stockExchange);

        // Assign mapping for relevant views to the observers
        obsToView.put(lilo.getID(), (EditText) findViewById(R.id.lilo_books));
        obsToView.put(stitch.getID(), (EditText) findViewById(R.id.stitch_books));

        // Initialize input streams
        ibmStock = (EditText) findViewById(R.id.ibm_price);
        googleStock = (EditText) findViewById(R.id.google_price);
        appleStock = (EditText) findViewById(R.id.apple_price);

        Button confirmPrice = (Button) findViewById(R.id.confirm_values);
        confirmPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stockExchange.setIBMPrice(Double.parseDouble(ibmStock.getText().toString()));
                stockExchange.setAAPLPrice(Double.parseDouble(appleStock.getText().toString()));
                stockExchange.setGOOGPrice(Double.parseDouble(googleStock.getText().toString()));
            }
        });
    }

    // The 'model' calls refreshView, and the controller relays the message to display
    // The controller acts as the mediator between the model and view
    // In our case, the model also involves observer pattern
    public static void refreshView(String str, int modelID) {

        EditText e = obsToView.get(modelID);
        e.setText(str, TextView.BufferType.EDITABLE);

    }
}