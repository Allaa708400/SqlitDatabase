package com.example.sqlitedatabase1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitdatabase.R;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CatViewHolder> {
        ArrayList<Car> cars;

        public RecyclerViewAdapter(ArrayList<Car> cats) {
            this.cars = cars;
        }

        @NonNull
        @Override
        public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_car_layout,
                    null, false);
            CatViewHolder viewHolder = new CatViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
            Car c = cars.get(position);
            holder.iv_image.setImageResource(c.getId());
            holder.tv_model.setText(c.getModel());
            holder.tv_color.setText(c.getColor());
            holder.tv_dpl.setText(c.getDbl()+"");
        }

        @Override
        public int getItemCount() {
            return cars.size();
        }

        class CatViewHolder extends RecyclerView.ViewHolder {
            TextView tv_model,tv_color,tv_dpl;
            ImageView iv_image;
            public CatViewHolder(@NonNull View itemView) {
                super(itemView);
                tv_model = itemView.findViewById(R.id.custom_car_tv_model);
                tv_color = itemView.findViewById(R.id.custom_car_tv_color);
                tv_dpl = itemView.findViewById(R.id.custom_car_tv_dpl);

                iv_image = itemView.findViewById(R.id.custom_car_iv);

            }
        }
    }




