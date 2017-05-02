package com.root.myapplication.picture;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.root.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syl on 2017/4/30.
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private Context mContext;
    private List<Partner> mPartner;
    private List<Integer> mHeight;

    public FruitAdapter(List<Partner> mPartner) {
        this.mPartner = mPartner;
        mHeight = new ArrayList<>();
        for (int i = 0; i < (mPartner != null ? mPartner.size() : 0); i++) {
            int h = (int) (200 + Math.random() * 400);
            mHeight.add(h);
        }
    }

    public FruitAdapter(List<Partner> mPartner, Context mContext) {
        this.mPartner = mPartner;
        this.mContext = mContext;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int w = ((Activity) mContext).getWindowManager().getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams params = holder.layout.getLayoutParams();
        params.height = mHeight.get(position);
        params.width = w / 2;
        holder.layout.setLayoutParams(params);

        Partner partner = mPartner.get(position);
        holder.textview.setText(partner.getName());
        holder.imageview.setImageResource(partner.getImageId());

    }

    @Override
    public int getItemCount() {
        return mPartner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageview;
        public TextView textview;
        public FrameLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.item_imageView);
            textview = (TextView) itemView.findViewById(R.id.item_textView);
            layout = (FrameLayout) itemView.findViewById(R.id.framelayout);

        }
    }
}

