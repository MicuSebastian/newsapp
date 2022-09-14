package com.example.dapmapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

//MyViewHolder este un inner(in aceasta clasa) class in DivAdapter
public class DivAdapter extends RecyclerView.Adapter<DivAdapter.MyViewHolder> {

    String[] data1, data2;
    int[] images;
    Context context;

    public DivAdapter (Context ct, String[] s1, String[] s2, int[] img) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //LayoutInflater este folosit pentru a initia continutul xml-ului My_row in
        //Obiectul de tip view(myViewHolder)
        LayoutInflater inflater = LayoutInflater.from(context);
        //Functia inflate este folosita pentru decompresarea datelor din my_row
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //Se ia din lista pentru fiecare pozitie
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creaza o actiune pe ecran
                Intent intent = new Intent(context, DetailsActivity.class);
                //putExtra ia valorile si le trimite la intent-ul initial
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;

        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //myViewHolder comunica cu onBindHolder si preia datele cu ajutorul id-urilor
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myImage = itemView.findViewById(R.id.myImageView);
            //Folosim layout-ul din my_row
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
