package com.example.qiaoxg.selectphotodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.qiaoxg.selectphotodemo.model.ImageInfo;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;


public class ImageGridAdapter extends CommonListAdapter<ImageInfo> {

    private int maxSize = 9;

    public ImageGridAdapter(Context context, int maxSize) {
        super(context);
        this.mContext = context;
        this.maxSize = maxSize;
    }

    //获取源图片
    public ArrayList<String> getSourceList() {
        ArrayList<String> ret = new ArrayList<String>();
        for (ImageInfo info : mList) {
            if (!info.isAddButton) {
                ret.add(info.getSource_image());
            }
        }
        return ret;
    }

    //添加一个项
    public void addItem(ImageInfo info) {
        mList.add(mList.size() - 1, info);
        if (mList.size() > maxSize) {
            mList.remove(maxSize);
        }
        notifyDataSetChanged();
    }

    //删除一个项
    public void deleteItem(int position) {
        mList.remove(position);
        boolean hasAddButton = false;
        for (ImageInfo info : mList) {
            if (info.isAddButton()) {
                hasAddButton = true;
            }
        }
        if (!hasAddButton) {
            ImageInfo info = new ImageInfo();
            info.setAddButton(true);
            mList.add(info);
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_img, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.iv_gridview_imageview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageInfo info = mList.get(position);
        if (info != null) {

            if (!info.isAddButton()) {
                File imageFile = new File(info.getSource_image());
                Picasso.with(mContext)
                        .load(imageFile)
                        .placeholder(R.drawable.camerasdk_pic_loading)
                        .error(R.drawable.camerasdk_pic_loading)
                        .resize(100, 100)
                        .centerCrop()
                        .into(holder.image);
            } else {
                Picasso.with(mContext)
                        .load(R.drawable.ic_add_image_button)
                        .placeholder(R.drawable.camerasdk_pic_loading)
                        .error(R.drawable.camerasdk_pic_loading)
                        .into(holder.image);
            }
        }

        return convertView;
    }

    class ViewHolder {

        public ImageView image;

    }


}	

	
	
