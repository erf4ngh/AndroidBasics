package com.example.Android.justjava;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Android.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int amount = 0;
    boolean hasWhip;
    boolean chocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        if (amount < 100) {
            amount = amount + 1;
        } else {
            Toast.makeText(this, "Hey Boi, you can't have more than 100 coffees!", Toast.LENGTH_SHORT).show();
        }
        display(amount);
    }

    public void incrementBoi(View view) {
        amount = 420;
        display(amount);
    }

    public void decrement(View view) {
        if (amount > 0) {
            amount = amount - 1;
        } else {
            amount = amount;
            Toast.makeText(this, "Hey Boi, you can't order less than 0 coffees!", Toast.LENGTH_SHORT).show();
        }
    display (amount);
    }

    public void submitOrder(View view) {
        CheckBox whip = (CheckBox) findViewById(R.id.is_whipped);
        boolean hasWhip = whip.isChecked();
        CheckBox choco = (CheckBox) findViewById(R.id.chocolate);
        boolean chocolate = choco.isChecked();
        EditText name = (EditText) findViewById(R.id.name);
        String strName = name.getText().toString();
        int price = calculatePrice(chocolate, hasWhip);
        String priceMessage = createOrderSum(price, hasWhip, chocolate, strName);
    }

    /**
     * Calculates the price of the order.
     *
     * @return price total amount due for coffee
     */
    private int calculatePrice(boolean chocolate, boolean hasWhip) {
        int basePrice = 5;

        if (hasWhip == true && chocolate == false) {
            basePrice = basePrice + 1;
        } else if (hasWhip == true && chocolate == true) {
            basePrice = basePrice + 3;
        }
    int price = amount * basePrice;
    return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + num);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * @param price is the total amount due for the coffee
     *@param hasWhip is whether whip cream is in the order
     * @return summary is order summary
     */
        private String createOrderSum(int price, boolean hasWhip, boolean chocolate, String name) {

            String summary = name + ", \nWhipped Cream m8? " + hasWhip + "\nChocolate? " + chocolate + "\nQuantity: " + amount + "\nTotal: $" + price + "\nThx dat boi!";
        String uriText =
                "mailto:erfanghafoori@gmail.com" +
                        "?subject=" + Uri.encode("Coffee Order") +
                        "&body=" + Uri.encode(summary);
        Uri uri = Uri.parse(uriText);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(uri);
        startActivity(Intent.createChooser(intent, "Send email"));
            return summary;
    }
}