package com.gama.task.ui.fragments.cart.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gama.task.ui.fragments.cart.models.ProductData;
import com.gama.task.ui.fragments.cart.repo.ProductRepo;

import java.util.List;

class ProductViewModel extends ViewModel {
    ProductRepo productRepo=new ProductRepo();
    MutableLiveData<ProductData> mutableLProduct=new MutableLiveData<>();



}
