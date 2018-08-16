package com.shan.myproject;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by root on 18-7-17.
 */

public class ClothBean {
    private List<DatasBean> datas;

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * id : 1
         * data : [{"childId":"2","name":"上装"},{"childId":"3","name":"下装"}]
         */

        private String id;
        private String title;
        private List<DataBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Comparable<DataBean> {
            /**
             * childId : 2
             * name : 上装
             */

            private String childId;
            private String name;
            private String img;
            private int num;

            public String getChildId() {
                return childId;
            }

            public void setChildId(String childId) {
                this.childId = childId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            @Override
            public int compareTo(@NonNull DataBean dataBean) {
                //自定义比较方法
                return dataBean.getNum() - this.getNum();
            }
        }
    }
}
