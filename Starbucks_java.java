package com.example.shivani.starbucks;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.name;
import static android.R.id.message;
import static com.example.shivani.starbucks.R.id.price;

public class MainActivity extends AppCompatActivity {
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {


        int price = calprice(n);
        CheckBox obj1 = (CheckBox) findViewById(R.id.check);
        boolean whip = obj1.isChecked();
        CheckBox obj2 = (CheckBox) findViewById(R.id.checkchoco);
        boolean choco = obj2.isChecked();
        if (whip == true)
            price += n * 1;
        if (choco == true)
            price += n * 2;
        EditText obj3 = (EditText) findViewById(R.id.name);
        String customer = obj3.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(n,whip,choco,customer));
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Syarbucks for " + customer);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }


    public void display(int p) {
        TextView quantity = (TextView) findViewById(R.id.no);
        quantity.setText(String.valueOf(p));
    }


    public void inc(View view) {
        if (n < 100)
            n++;
        else
            Toast.makeText(this, "The number of coffees cannot be more than 100!", Toast.LENGTH_SHORT).show();

        display(n);

    }

    public int calprice(int p) {
        return (5 * p);

    }

    public Stringe]rderSummary(int p, boolean whip, boolean choco, String c_name) {
        String priceMessage = "Name: " + c_name;
        priceMessage += "\nHas whipped cream?: " + whip;
        priceMessage += "\nHas chocolate?: " + choco;
        priceMessage += "\nTotal: $" + p;
        priceMessage += "\nQuantity: " + n;
        priceMessage += "\nThank You!";
        return(priceMessage);


    }

    public void dec(View view) {

        if (n > 0)
            n--;
        else
            Toast.makeText(this, "The number of coffees cannot be less than 0!", Toast.LENGTH_SHORT).show();
        display(n);
    }

}
