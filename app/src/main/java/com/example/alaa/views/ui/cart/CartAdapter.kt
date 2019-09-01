package com.example.alaa.views.ui.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.adapters.AttributesAdapter
import com.example.alaa.adapters.ComplexCartAdapter

class CartAdapter( private val resource : Int) : RecyclerView.Adapter<CartAdapter.ViewHolder>()  {

    constructor(resource: Int , productList : ArrayList<ModelProduct> , context: Context) : this(resource){
        this.productList = productList
        this.context = context
    }

    private lateinit var productList: ArrayList<ModelProduct>
    private lateinit var attrAdapter  :AttributesAdapter
    private lateinit var childAdapter: ComplexCartAdapter
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(resource,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product : ModelProduct = productList[position]
        holder.title.text = product.title
        holder.finalSalePrice.text = product.salePrice

        attrAdapter = AttributesAdapter(product.attrList)
        holder.attrRecyclerView.layoutManager = GridLayoutManager(context , 3)
        holder.attrRecyclerView.adapter = attrAdapter

        childAdapter = ComplexCartAdapter(2)
        holder.childRecyclerView.layoutManager = LinearLayoutManager(context , RecyclerView.VERTICAL , false)
        holder.childRecyclerView.adapter = childAdapter

    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val title: com.example.alaa.customViews.TextViewWithFont = itemView.findViewById(R.id.tx_title_product)
        val finalSalePrice: com.example.alaa.customViews.TextViewWithFont = itemView.findViewById(R.id.finalSalePrice)


        val attrRecyclerView : RecyclerView = itemView.findViewById(R.id.recycler_attribute_simple_product)

        val childRecyclerView : RecyclerView = itemView.findViewById(R.id.recycler_child_product)


    }

}