package com.root.myapplication.picture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.root.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Partner[] partners = {
            new Partner("小林", R.drawable.a, R.mipmap.ic_launcher),
            new Partner("小王", R.drawable.b, R.mipmap.ic_launcher),
            new Partner("康娜", R.drawable.c, R.mipmap.ic_launcher),
            new Partner("小李", R.drawable.d, R.mipmap.ic_launcher),
            new Partner("机器人", R.drawable.e, R.mipmap.ic_launcher),
            new Partner("王飞林", R.drawable.f, R.mipmap.ic_launcher),
            new Partner("朗朗", R.drawable.g, R.mipmap.ic_launcher),
            new Partner("泰宁", R.drawable.h, R.mipmap.ic_launcher),
            new Partner("茅以升", R.drawable.i, R.mipmap.ic_launcher),
            new Partner("毛二", R.drawable.j, R.mipmap.ic_launcher),
            new Partner("小林", R.drawable.a, R.mipmap.ic_launcher),
            new Partner("小王", R.drawable.b, R.mipmap.ic_launcher),
            new Partner("康娜", R.drawable.c, R.mipmap.ic_launcher),
            new Partner("小李", R.drawable.d, R.mipmap.ic_launcher),
            new Partner("机器人", R.drawable.e, R.mipmap.ic_launcher),
            new Partner("王飞林", R.drawable.f, R.mipmap.ic_launcher),
            new Partner("朗朗", R.drawable.g, R.mipmap.ic_launcher),
            new Partner("泰宁", R.drawable.h, R.mipmap.ic_launcher),
            new Partner("茅以升", R.drawable.i, R.mipmap.ic_launcher),
            new Partner("毛二", R.drawable.j, R.mipmap.ic_launcher),
            new Partner("小林", R.drawable.a, R.mipmap.ic_launcher),
            new Partner("小王", R.drawable.b, R.mipmap.ic_launcher),
            new Partner("康娜", R.drawable.c, R.mipmap.ic_launcher),
            new Partner("小李", R.drawable.d, R.mipmap.ic_launcher),
            new Partner("机器人", R.drawable.e, R.mipmap.ic_launcher),
            new Partner("王飞林", R.drawable.f, R.mipmap.ic_launcher),
            new Partner("朗朗", R.drawable.g, R.mipmap.ic_launcher),
            new Partner("泰宁", R.drawable.h, R.mipmap.ic_launcher),
            new Partner("茅以升", R.drawable.i, R.mipmap.ic_launcher),
            new Partner("毛二", R.drawable.j, R.mipmap.ic_launcher),
            new Partner("小林", R.drawable.a, R.mipmap.ic_launcher),
            new Partner("小王", R.drawable.b, R.mipmap.ic_launcher),
            new Partner("康娜", R.drawable.c, R.mipmap.ic_launcher),
            new Partner("小李", R.drawable.d, R.mipmap.ic_launcher),
            new Partner("机器人", R.drawable.e, R.mipmap.ic_launcher),
            new Partner("王飞林", R.drawable.f, R.mipmap.ic_launcher),
            new Partner("朗朗", R.drawable.g, R.mipmap.ic_launcher),
            new Partner("泰宁", R.drawable.h, R.mipmap.ic_launcher),
            new Partner("茅以升", R.drawable.i, R.mipmap.ic_launcher),
            new Partner("毛二", R.drawable.j, R.mipmap.ic_launcher)};
    private List<Partner> partnerList = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycleview = (RecyclerView) findViewById(R.id.recycle_view);
        partnerList.clear();
        for (int i = 0; i < partners.length; i++) {
            partnerList.add(partners[i]);
        }
//        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(partnerList);
        recycleview.setAdapter(adapter);

    }
}