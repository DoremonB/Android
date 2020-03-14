package com.example.loadingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        button=findViewById(R.id.button);

        RecyclerViewAdapter adapter=new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runLayoutAnimation(recyclerView);
            }
        });


    }

    //to rerun animation
    private void runLayoutAnimation(RecyclerView recyclerView){
        Context context=recyclerView.getContext();
        LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_slide_right);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }


    //slide from right
}
