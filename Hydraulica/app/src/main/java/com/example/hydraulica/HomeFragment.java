package com.example.hydraulica;

import android.app.AlertDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hydraulica.R;


public class HomeFragment extends Fragment {

    EditText pressure, area;
    Button calculate;

     public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //result = new ViewModelProvider(this).get(Result.class);
        View root = inflater.inflate(R.layout.calculate_power, container, false);
         final TextView textView = root.findViewById(R.id.text_calculate);
        pressure = root.findViewById(R.id.pressure);
        area = root.findViewById(R.id.area);
        calculate = root.findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     int result = 0;
                     try{
                                result = (Integer.parseInt(pressure.getText().toString())) * (Integer.parseInt(area.getText().toString()));
                        } catch (NumberFormatException e){
                                e.printStackTrace();
                            }
                            String result_string =String.valueOf(result);

                            AlertDialog.Builder result_builder =new AlertDialog.Builder(getActivity(), R.style.dialogTheme);
                            result_builder.setTitle("Cylinder Force: ");
                            result_builder.setMessage(result_string);

                            //Animation part
                            ImageView imageView = (ImageView) root.findViewById(R.id.animation);
                            imageView.setVisibility(ImageView.VISIBLE);
                            imageView.setBackgroundResource(R.drawable.frameanimation);

                            AnimationDrawable frameAnimation =(AnimationDrawable)imageView.getBackground();
                            frameAnimation.start();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //frameAnimation.stop();
                                    //imageView.setVisibility(ImageView.INVISIBLE);
                                    result_builder.show();
                                }
                            }, 2000);

                     }

            });

        return root;
    }



}