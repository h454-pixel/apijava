package com.example.practice_1;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.practice_1.Model.Article;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

  ArrayList<Article> noteArrayList;
    Context context;
    //setnotefunction listner;

    public RecyclerAdapter(Context context, ArrayList<Article> arrayList) {
        this.context = context;
        this.noteArrayList = arrayList;
     //   this.listner = listner;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reycler_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v, context, noteArrayList ); // pass the view to View Holder
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText((String) noteArrayList.get(position).getTitle());
     //   holder.tvCreated.setText(noteArrayList.get(position).getDescription());
        Glide.with(context).load(noteArrayList.get(position).getUrlToImage()).placeholder(R.drawable.loading).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            String urll =   noteArrayList.get(position).getUrlToImage();
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Web_Act.class);
                intent.putExtra("url",urll);
              context.startActivity(intent);
            }
        });



        // holder.tvModified.setText("Modified : " +noteArrayList.get(position).getModified_date());
        //holder.imageView.setImageResource((Integer ) personimagess.get(position));
        // implement setOnClickListener event on item view.

    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        ImageView imageView;// init the item view's
        Context context;
        ArrayList personimagess;

        public MyViewHolder(View itemView, Context context, ArrayList personimagess) {
            super(itemView);
            // get the reference of item view's
          //  name = (TextView) itemView.findViewById(R.id.textView333);
            //imageView =(ImageView) itemView.findViewById(R.id.imageView333);
            itemView.setOnClickListener(this);
            this.context =context;
            this.personimagess=personimagess;
        }

        @Override
        public void onClick(View v) {
           // Intent intent =new Intent(context,MainAcitivitydisyplay.class);
           // intent.putExtra("imageid", (Integer) personimagess.get(getAdapterPosition()));
          //  context.startActivity(intent);

        }
    }

}






