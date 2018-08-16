package com.shan.myproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shan.myproject.databinding.Item2Binding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chenjunshan on 18-7-23.
 */

public class DataActivity extends FragmentActivity {
    private RecyclerView recyclerView;
    private TextView tvExport;
    private ExcelUtils excelUtils;
    private ClothBean clothBean;
    private List<ClothBean.DatasBean.DataBean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_layout);
        excelUtils = new ExcelUtils(this);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                //初始化数据
                String data = "{\"datas\":[{\"id\":\"1\",\"title\":\"服装调查\",\"data\":[{\"childId\":\"2\",\"name\":\"上装\",\"num\":0,\"img\":\"ic_shangzhuang.png\"},{\"childId\":\"3\",\"name\":\"下装\",\"num\":0,\"img\":\"ic_xiazhuang.png\"}]},{\"id\":\"2\",\"title\":\"选择颜色\",\"data\":[{\"childId\":\"21\",\"name\":\"黑色\",\"num\":0,\"img\":\"ic_heise.png\"},{\"childId\":\"21\",\"name\":\"灰色\",\"num\":0,\"img\":\"ic_huise.png\"},{\"childId\":\"21\",\"name\":\"绿色\",\"num\":0,\"img\":\"ic_lvse.png\"},{\"childId\":\"21\",\"name\":\"蓝色\",\"num\":0,\"img\":\"ic_lanse.png\"},{\"childId\":\"21\",\"name\":\"红色\",\"num\":0,\"img\":\"ic_hongse.png\"},{\"childId\":\"21\",\"name\":\"粉色\",\"num\":0,\"img\":\"ic_fense.png\"},{\"childId\":\"21\",\"name\":\"黄色\",\"num\":0,\"img\":\"ic_huangse.png\"},{\"childId\":\"21\",\"name\":\"紫色\",\"num\":0,\"img\":\"ic_zise.png\"},{\"childId\":\"21\",\"name\":\"印花\",\"num\":0,\"img\":\"ic_yinhua.png\"},{\"childId\":\"21\",\"name\":\"条纹\",\"num\":0,\"img\":\"ic_tiaowen.png\"},{\"childId\":\"21\",\"name\":\"格子\",\"num\":0,\"img\":\"ic_gezi.png\"}]},{\"id\":\"21\",\"title\":\"选择袖长\",\"data\":[{\"childId\":\"211\",\"name\":\"长袖\",\"num\":0,\"img\":\"ic_changxiu.png\"},{\"childId\":\"211\",\"name\":\"短袖\",\"num\":0,\"img\":\"ic_duanxiu.png\"},{\"childId\":\"1\",\"name\":\"背心\",\"num\":0,\"img\":\"ic_beixin.png\"}]},{\"id\":\"211\",\"title\":\"选择上衣类型\",\"data\":[{\"childId\":\"2111\",\"name\":\"T恤\",\"num\":0,\"img\":\"ic_txie.png\"},{\"childId\":\"2112\",\"name\":\"衬衫\",\"num\":0,\"img\":\"ic_chenshan.png\"},{\"childId\":\"1\",\"name\":\"卫衣\",\"num\":0,\"img\":\"ic_weiyi.png\"},{\"childId\":\"1\",\"name\":\"西装\",\"num\":0,\"img\":\"ic_xizhuang.png\"},{\"childId\":\"1\",\"name\":\"毛衣\",\"num\":0,\"img\":\"ic_maoyi.png\"},{\"childId\":\"1\",\"name\":\"风衣\",\"num\":0,\"img\":\"ic_fengyi.png\"},{\"childId\":\"1\",\"name\":\"毛呢外套\",\"num\":0,\"img\":\"ic_maonewaitao.png\"},{\"childId\":\"1\",\"name\":\"羽绒服\",\"num\":0,\"img\":\"ic_yurongfu.png\"},{\"childId\":\"1\",\"name\":\"棉衣\",\"num\":0,\"img\":\"ic_mianyi.png\"},{\"childId\":\"1\",\"name\":\"皮衣\",\"num\":0,\"img\":\"ic_piyi.png\"}]},{\"id\":\"2111\",\"title\":\"选择衣领类型\",\"data\":[{\"childId\":\"1\",\"name\":\"圆领\",\"num\":0,\"img\":\"ic_yuanling.png\"},{\"childId\":\"1\",\"name\":\"V领\",\"num\":0,\"img\":\"ic_vling.png\"},{\"childId\":\"1\",\"name\":\"polo领\",\"num\":0,\"img\":\"ic_pololing.png\"},{\"childId\":\"1\",\"name\":\"立领\",\"num\":0,\"img\":\"ic_liling.png\"},{\"childId\":\"1\",\"name\":\"方领\",\"num\":0,\"img\":\"ic_fangling.png\"},{\"childId\":\"1\",\"name\":\"斜领\",\"num\":0,\"img\":\"ic_xieling.png\"}]},{\"id\":\"2112\",\"title\":\"选择衬衫类型\",\"data\":[{\"childId\":\"1\",\"name\":\"普通衬衫\",\"num\":0,\"img\":\"ic_putongchenshan.png\"},{\"childId\":\"1\",\"name\":\"雪纺衫\",\"num\":0,\"img\":\"ic_xuefanshan.png\"},{\"childId\":\"1\",\"name\":\"针织衫\",\"num\":0,\"img\":\"ic_zhenzhishan.png\"}]},{\"id\":\"3\",\"title\":\"选择下装类型\",\"data\":[{\"childId\":\"31\",\"name\":\"裙子\",\"num\":0,\"img\":\"ic_qunzi.png\"},{\"childId\":\"32\",\"name\":\"牛仔裤\",\"num\":0,\"img\":\"ic_niuzaiku.png\"},{\"childId\":\"33\",\"name\":\"休闲裤\",\"num\":0,\"img\":\"ic_xiuxianku.png\"},{\"childId\":\"1\",\"name\":\"弹力库\",\"num\":0,\"img\":\"ic_tanliku.png\"}]},{\"id\":\"31\",\"title\":\"选择裙子类型\",\"data\":[{\"childId\":\"1\",\"name\":\"短裙\",\"num\":0,\"img\":\"ic_duanqun.png\"},{\"childId\":\"1\",\"name\":\"半身裙\",\"num\":0,\"img\":\"ic_banshenqun.png\"},{\"childId\":\"1\",\"name\":\"长裙\",\"img\":\"ic_changqun.png\"},{\"childId\":\"1\",\"name\":\"长连衣裙\",\"num\":0,\"img\":\"ic_changlianyiqun.png\"},{\"childId\":\"1\",\"name\":\"短连衣裙\",\"num\":0,\"img\":\"ic_duanlianyiqun.png\"},{\"childId\":\"1\",\"name\":\"吊带裙\",\"num\":0,\"img\":\"ic_diaodaiqun.png\"},{\"childId\":\"1\",\"name\":\"短牛仔裙\",\"num\":0,\"img\":\"ic_duanniuzaiqun.png\"},{\"childId\":\"1\",\"name\":\"半身牛仔裙\",\"num\":0,\"img\":\"ic_banshenniuzaiqun.png\"},{\"childId\":\"1\",\"name\":\"长牛仔裙\",\"num\":0,\"img\":\"ic_changniuzaiqun.png\"},{\"childId\":\"1\",\"name\":\"长牛仔连衣裙\",\"num\":0,\"img\":\"ic_changniuzailianyiqun.png\"},{\"childId\":\"1\",\"name\":\"短牛仔连衣裙\",\"num\":0,\"img\":\"ic_duanniuzailianyiqun.png\"},{\"childId\":\"1\",\"name\":\"吊带牛仔裙\",\"num\":0,\"img\":\"ic_diaodainiuzaiqun.png\"}]},{\"id\":\"32\",\"title\":\"选择牛仔裤类型\",\"data\":[{\"childId\":\"1\",\"name\":\"短牛仔裤\",\"num\":0,\"img\":\"ic_duanniuzaiku.png\"},{\"childId\":\"1\",\"name\":\"长牛仔裤\",\"num\":0,\"img\":\"ic_changniuzaiku.png\"}]},{\"id\":\"33\",\"title\":\"选择休闲裤类型\",\"data\":[{\"childId\":\"1\",\"name\":\"短休闲裤\",\"num\":0,\"img\":\"ic_duanxiuxianku.png\"},{\"childId\":\"1\",\"name\":\"8分休闲裤\",\"num\":0,\"img\":\"ic_bafenxiuxianku.png\"},{\"childId\":\"1\",\"name\":\"长休闲裤\",\"num\":0,\"img\":\"ic_changxiuxianku.png\"}]}]}";
                clothBean = new Gson().fromJson(data, ClothBean.class);
                ClothBean.DatasBean datasBean;
                list = new ArrayList<>();
                for (int i = 0; i < clothBean.getDatas().size(); i++) {
                    datasBean = clothBean.getDatas().get(i);
                    for (int j = 0; j < datasBean.getData().size(); j++) {
                        ClothBean.DatasBean.DataBean dataBean = datasBean.getData().get(j);
                        int num = (int) SPUtils.get(dataBean.getName(), 0);
                        dataBean.setNum(num);
                        list.add(dataBean);
                    }
                }
                //排序
                Collections.sort(list);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                recyclerView.setAdapter(new CommonCycAdapter<Item2Binding, ClothBean.DatasBean.DataBean>(DataActivity.this, R.layout.item2, list) {
                    @Override
                    protected void getItem(Item2Binding binding, ClothBean.DatasBean.DataBean bean, int position) {

                        binding.tvName.setText(bean.getName());
                        binding.tvNum.setText(String.valueOf(bean.getNum()));
                    }

                    @Override
                    protected void itemOnclick(ClothBean.DatasBean.DataBean bean, int position) {

                    }
                });
            }
        }.execute();

        //初始化RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyc);
        tvExport = (TextView) findViewById(R.id.tv_export);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        //导出数据
        tvExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                excelUtils.exportData(clothBean, list);
            }
        });
    }

}
