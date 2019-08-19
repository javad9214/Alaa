package com.example.alaa.views.ui.cart;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.models.AttributesModel;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setAdapter();
    }

    private void setAdapter(){

        ArrayList<ModelProduct> productList = new ArrayList<>();

        for (int i = 0 ; i < 5 ; i++){
            productList.add(setProducts());
        }

        CartAdapter  adapter = new CartAdapter(R.layout.cart_product_simple , productList, this );
        RecyclerView recyclerView = findViewById(R.id.recyclerCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private ModelProduct setProducts(){
        ArrayList<AttributesModel> attrList = new ArrayList<>();
        ModelProduct product = new ModelProduct();
         product.setTitle("همایش طلایی ریاضی تجربی نظام قدیم کنکور 98 آلاء");
         product.setSalePrice(" 25,000 تومان");
         for (int i = 0 ; i < 5 ; i++){
             attrList.add(setAttribute( "کنکور" , "نظام قدیم"));
         }

         product.setAttrList(attrList);

         return product ;
    }


    private AttributesModel setAttribute(String attrName , String attrValue){
        AttributesModel attribute = new AttributesModel();
        attribute.setAttrName(attrName);
        attribute.setAttrValue(attrValue);
        return attribute;
    }



    public void purchase(View view) {
        CompletePurchase completePurchase = new CompletePurchase();
        completePurchase.show(getSupportFragmentManager() , completePurchase.getTag());
    }


}
