package com.example.coffeeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class OrderPage extends AppCompatActivity {
//  Sets the initial value to zero
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);
    }

    //Method that describes what happens when order button is clicked
    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox = findViewById(R.id.checkboxCream);
        boolean hasCream=whippedCreamCheckBox.isChecked();

        CheckBox chocoCheckBox = findViewById(R.id.checkboxChoco);
        boolean hasChoco = chocoCheckBox.isChecked();

        int price= calculatePrice(hasCream, hasChoco);
     String priceMessage = createOrderSummary(price,hasCream,hasChoco);
        displayMessage(priceMessage);

    }

    //Summary of order to be displayed on screen after order button is clicked
    private String createOrderSummary(int price, boolean hasCream, boolean hasChoco){
        String priceMessage= "Name: " + nameOfCustomer();
        priceMessage= priceMessage+ "\nNo of Coffee: " + quantity;
        priceMessage= priceMessage+ "\nAdd Whipped Cream:"+" "+ hasCream;
        priceMessage= priceMessage+ "\nAdd Chocolate:"+" "+ hasChoco;
        priceMessage= priceMessage+ "\nTotal:"+" "+ "$"+ price;
        priceMessage= priceMessage+ "\nThank you";
        return priceMessage;
    }

    //Method that reads the customer's name entered on order page
    public String nameOfCustomer(){
        EditText customerName=findViewById(R.id.customer_name);
        String customer_name = customerName.getText().toString();
        return customer_name;
    }


    //Transforms orderSummary to text for display
    private void displayMessage(String message){
        TextView orderSummaryTextView= findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    //Transforms the quantityValue for display
    private void display (int number){
        TextView valueQuantity= findViewById(R.id.quantityValue);
        valueQuantity.setText("" + number);
    }

    //Adds checkbox prices to coffee price
    private int calculatePrice(boolean creamPrice, boolean chocoPrice){
        int basePrice =10;

        if(creamPrice){
            basePrice= basePrice+3;
        }

        if(chocoPrice){
            basePrice= basePrice+5;
        }
        return quantity* basePrice;

    }


    //Increases the quantity value when + button is tapped
    public void increment (View view) {
        quantity=quantity+1;
        display(quantity);
    }

    //Decreases the quantity value when - button is tapped
    public void decrement (View view) {
        quantity=quantity-1;
        display(quantity);
    }

/*    final Button button = findViewById(R.id.logout_button);
        button.set(new View.OnClickListener() {
        @Override
        public void logOut(View v) {

                // Code here executes on main thread after user presses button
                Intent myIntent = new Intent(LoginPage.this, OrderPage.class);
                LoginPage.this.startActivity(myIntent);
            }
  */

        //Creates a new intent when LogOut button is clicked
        public void logOut(View view){
            Intent myIntent = new Intent(OrderPage.this, MainActivity.class);
            OrderPage.this.startActivity(myIntent);
        }

}


