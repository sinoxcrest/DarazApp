package com.example.daraz.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daraz.R;
import com.example.daraz.adapter.productadapter;
import com.example.daraz.adapter.slideradapter;
import com.example.daraz.model.Products;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    SliderView sliderView;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = view.findViewById(R.id.Slider);
        recyclerView = view.findViewById(R.id.RecyclerView);

        final slideradapter adapter = new slideradapter(getContext());
        adapter.setCount(5);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        List<Products> productsList=new ArrayList<>();
        productsList.add(new Products(R.drawable.t1,"Black Tuxedo",1000));
        productsList.add(new Products(R.drawable.t4,"Light Blue suit",1400));
        productsList.add(new Products(R.drawable.t3,"Grey Tuxedo",1000));
        productsList.add(new Products(R.drawable.t6,"Salwar",1200));
        productsList.add(new Products(R.drawable.t4,"Light Blue suit",1400));
        productsList.add(new Products(R.drawable.t6,"Salwar",1200));


        final productadapter productadapters=new productadapter(getContext(),productsList);
        recyclerView.setAdapter(productadapters);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return view;
    }
}