package com.example.qiaoxg.selectphotodemo.model;

import java.io.Serializable;

/**
 * 图片实体
 */
public class ImageInfo  implements Serializable {
    public String path;
    public String name;
    public long time;

    public boolean selected = false;

    private static final long serialVersionUID = 1L;

    public String source_image; //源图
    public boolean isAddButton = false; //是否是添加按钮


    public String getSource_image() {
        return source_image;
    }

    public void setSource_image(String source_image) {
        this.source_image = source_image;
    }

    public boolean isAddButton() {
        return isAddButton;
    }

    public void setAddButton(boolean isAddButton) {
        this.isAddButton = isAddButton;
    }

    public ImageInfo() {
    }

    public ImageInfo(String path, String name, long time) {
        this.path = path;
        this.name = name;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        try {
            ImageInfo other = (ImageInfo) o;
            return this.path.equalsIgnoreCase(other.path);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return super.equals(o);
    }
}
