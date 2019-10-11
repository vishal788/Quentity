package com.example.quentity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;

public class CartDesign extends ArrayAdapter {

    ArrayList<String> s11,s12,s13,s14;
    Activity c;
    TextView tv1,tv2,tv3,tv4;
    ElegantNumberButton cart;
    //static float sum;

    public CartDesign(Context context, ArrayList<String> resource, ArrayList<String> resource1, ArrayList<String> resource2, ArrayList<String> resource3) {
        super(context, R.layout.activity_cart,resource);
        c=(Activity) context;
        s11=resource;
        s12=resource1;
        s13=resource2;
        s14=resource3;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater lg = c.getLayoutInflater();//include xml file
        convertView = lg.inflate(R.layout.cartdesgin, null);
        tv1=convertView.findViewById(R.id.carttext);
        tv2=convertView.findViewById(R.id.carttext1);
        tv3=convertView.findViewById(R.id.carttext2);
        tv4=convertView.findViewById(R.id.carttext3);
        final View finalConvertView = convertView;
        cart=finalConvertView.findViewById(R.id.cartbutton);
        //cart.setTag(arg0);
        ((View) cart).setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart=finalConvertView.findViewById(R.id.cartbutton);
                tv3=finalConvertView.findViewById(R.id.carttext2);
                tv2=finalConvertView.findViewById(R.id.carttext1);
                String str1= position+"";
                String str=cart.getNumber();
                Cart.fdquantity1.set(Integer.parseInt(str1),str);
                CustomListFoodItem.pQuantity.set(Integer.parseInt(str1),str);
                tv3.setText(str);
                String mul=(Float.parseFloat(str)*Float.parseFloat(tv2.getText().toString())+"");
                Cart.mul.set(Integer.parseInt(str1),mul);
                tv4=finalConvertView.findViewById(R.id.carttext3);
                tv4.setText("Total Rs.: "+mul);
                //Toast.makeText(c, ""+str+str1, Toast.LENGTH_SHORT).show();
            }
        });
        tv1.setText(s11.get(position));
        tv2.setText(s12.get(position));
        tv3.setText(s13.get(position));
        for(int i=0;i<CustomListFoodItem.pQuantity.size();i++)
        {
            cart.setNumber(s13.get(position));
        }
        tv4.setText("Total Rs.: "+s14.get(position));
        return convertView;
    }
}
