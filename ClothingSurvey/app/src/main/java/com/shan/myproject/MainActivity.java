package com.shan.myproject;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.shan.myproject.databinding.ItemBinding;

public class MainActivity extends FragmentActivity {
    private String childId = "1";//默认等于2
    private RecyclerView recyclerView;
    private static final String CHILDID = "childid";
    private LinearLayout linearLayout;
    private TextView tvLook;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPsermissions();
        //初始化View
        linearLayout = (LinearLayout) findViewById(R.id.ll_parent);
        tvLook = (TextView) findViewById(R.id.tv_look);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });
        childId = getIntent().getStringExtra(CHILDID);
        //获取当前页面id
        if (TextUtils.isEmpty(childId)) {
            childId = "1";
        }
        if (childId.equals("1")) {
            tvLook.setVisibility(View.VISIBLE);
        } else {
            tvLook.setVisibility(View.GONE);
        }
        //初始化数据
        String data = "{\"datas\":[{\"id\":\"1\",\"title\":\"服装调查\",\"data\":[{\"childId\":\"2\",\"name\":\"上装\",\"num\":0,\"img\":\"ic_shangzhuang.png\"},{\"childId\":\"3\",\"name\":\"下装\",\"num\":0,\"img\":\"ic_xiazhuang.png\"}]},{\"id\":\"2\",\"title\":\"选择颜色\",\"data\":[{\"childId\":\"21\",\"name\":\"黑色\",\"num\":0,\"img\":\"ic_heise.png\"},{\"childId\":\"21\",\"name\":\"灰色\",\"num\":0,\"img\":\"ic_huise.png\"},{\"childId\":\"21\",\"name\":\"绿色\",\"num\":0,\"img\":\"ic_lvse.png\"},{\"childId\":\"21\",\"name\":\"蓝色\",\"num\":0,\"img\":\"ic_lanse.png\"},{\"childId\":\"21\",\"name\":\"红色\",\"num\":0,\"img\":\"ic_hongse.png\"},{\"childId\":\"21\",\"name\":\"粉色\",\"num\":0,\"img\":\"ic_fense.png\"},{\"childId\":\"21\",\"name\":\"黄色\",\"num\":0,\"img\":\"ic_huangse.png\"},{\"childId\":\"21\",\"name\":\"紫色\",\"num\":0,\"img\":\"ic_zise.png\"},{\"childId\":\"21\",\"name\":\"印花\",\"num\":0,\"img\":\"ic_yinhua.png\"},{\"childId\":\"21\",\"name\":\"条纹\",\"num\":0,\"img\":\"ic_tiaowen.png\"},{\"childId\":\"21\",\"name\":\"格子\",\"num\":0,\"img\":\"ic_gezi.png\"}]},{\"id\":\"21\",\"title\":\"选择袖长\",\"data\":[{\"childId\":\"211\",\"name\":\"长袖\",\"num\":0,\"img\":\"ic_changxiu.png\"},{\"childId\":\"211\",\"name\":\"短袖\",\"num\":0,\"img\":\"ic_duanxiu.png\"},{\"childId\":\"1\",\"name\":\"背心\",\"num\":0,\"img\":\"ic_beixin.png\"}]},{\"id\":\"211\",\"title\":\"选择上衣类型\",\"data\":[{\"childId\":\"2111\",\"name\":\"T恤\",\"num\":0,\"img\":\"ic_txie.png\"},{\"childId\":\"2112\",\"name\":\"衬衫\",\"num\":0,\"img\":\"ic_chenshan.png\"},{\"childId\":\"1\",\"name\":\"卫衣\",\"num\":0,\"img\":\"ic_weiyi.png\"},{\"childId\":\"1\",\"name\":\"西装\",\"num\":0,\"img\":\"ic_xizhuang.png\"},{\"childId\":\"1\",\"name\":\"毛衣\",\"num\":0,\"img\":\"ic_maoyi.png\"},{\"childId\":\"1\",\"name\":\"风衣\",\"num\":0,\"img\":\"ic_fengyi.png\"},{\"childId\":\"1\",\"name\":\"毛呢外套\",\"num\":0,\"img\":\"ic_maonewaitao.png\"},{\"childId\":\"1\",\"name\":\"羽绒服\",\"num\":0,\"img\":\"ic_yurongfu.png\"},{\"childId\":\"1\",\"name\":\"棉衣\",\"num\":0,\"img\":\"ic_mianyi.png\"},{\"childId\":\"1\",\"name\":\"皮衣\",\"num\":0,\"img\":\"ic_piyi.png\"}]},{\"id\":\"2111\",\"title\":\"选择衣领类型\",\"data\":[{\"childId\":\"1\",\"name\":\"圆领\",\"num\":0,\"img\":\"ic_yuanling.png\"},{\"childId\":\"1\",\"name\":\"V领\",\"num\":0,\"img\":\"ic_vling.png\"},{\"childId\":\"1\",\"name\":\"polo领\",\"num\":0,\"img\":\"ic_pololing.png\"},{\"childId\":\"1\",\"name\":\"立领\",\"num\":0,\"img\":\"ic_liling.png\"},{\"childId\":\"1\",\"name\":\"方领\",\"num\":0,\"img\":\"ic_fangling.png\"},{\"childId\":\"1\",\"name\":\"斜领\",\"num\":0,\"img\":\"ic_xieling.png\"}]},{\"id\":\"2112\",\"title\":\"选择衬衫类型\",\"data\":[{\"childId\":\"1\",\"name\":\"普通衬衫\",\"num\":0,\"img\":\"ic_putongchenshan.png\"},{\"childId\":\"1\",\"name\":\"雪纺衫\",\"num\":0,\"img\":\"ic_xuefanshan.png\"},{\"childId\":\"1\",\"name\":\"针织衫\",\"num\":0,\"img\":\"ic_zhenzhishan.png\"}]},{\"id\":\"3\",\"title\":\"选择下装类型\",\"data\":[{\"childId\":\"31\",\"name\":\"裙子\",\"num\":0,\"img\":\"ic_qunzi.png\"},{\"childId\":\"32\",\"name\":\"牛仔裤\",\"num\":0,\"img\":\"ic_niuzaiku.png\"},{\"childId\":\"33\",\"name\":\"休闲裤\",\"num\":0,\"img\":\"ic_xiuxianku.png\"},{\"childId\":\"1\",\"name\":\"弹力库\",\"num\":0,\"img\":\"ic_tanliku.png\"}]},{\"id\":\"31\",\"title\":\"选择裙子类型\",\"data\":[{\"childId\":\"1\",\"name\":\"短裙\",\"num\":0,\"img\":\"ic_duanqun.png\"},{\"childId\":\"1\",\"name\":\"半身裙\",\"num\":0,\"img\":\"ic_banshenqun.png\"},{\"childId\":\"1\",\"name\":\"长裙\",\"img\":\"ic_changqun.png\"},{\"childId\":\"1\",\"name\":\"长连衣裙\",\"num\":0,\"img\":\"ic_changlianyiqun.png\"},{\"childId\":\"1\",\"name\":\"短连衣裙\",\"num\":0,\"img\":\"ic_duanlianyiqun.png\"},{\"childId\":\"1\",\"name\":\"吊带裙\",\"num\":0,\"img\":\"ic_diaodaiqun.png\"},{\"childId\":\"1\",\"name\":\"短牛仔裙\",\"num\":0,\"img\":\"ic_duanniuzaiqun.png\"},{\"childId\":\"1\",\"name\":\"半身牛仔裙\",\"num\":0,\"img\":\"ic_banshenniuzaiqun.png\"},{\"childId\":\"1\",\"name\":\"长牛仔裙\",\"num\":0,\"img\":\"ic_changniuzaiqun.png\"},{\"childId\":\"1\",\"name\":\"长牛仔连衣裙\",\"num\":0,\"img\":\"ic_changniuzailianyiqun.png\"},{\"childId\":\"1\",\"name\":\"短牛仔连衣裙\",\"num\":0,\"img\":\"ic_duanniuzailianyiqun.png\"},{\"childId\":\"1\",\"name\":\"吊带牛仔裙\",\"num\":0,\"img\":\"ic_diaodainiuzaiqun.png\"}]},{\"id\":\"32\",\"title\":\"选择牛仔裤类型\",\"data\":[{\"childId\":\"1\",\"name\":\"短牛仔裤\",\"num\":0,\"img\":\"ic_duanniuzaiku.png\"},{\"childId\":\"1\",\"name\":\"长牛仔裤\",\"num\":0,\"img\":\"ic_changniuzaiku.png\"}]},{\"id\":\"33\",\"title\":\"选择休闲裤类型\",\"data\":[{\"childId\":\"1\",\"name\":\"短休闲裤\",\"num\":0,\"img\":\"ic_duanxiuxianku.png\"},{\"childId\":\"1\",\"name\":\"8分休闲裤\",\"num\":0,\"img\":\"ic_bafenxiuxianku.png\"},{\"childId\":\"1\",\"name\":\"长休闲裤\",\"num\":0,\"img\":\"ic_changxiuxianku.png\"}]}]}";
        ClothBean clothBean = new Gson().fromJson(data, ClothBean.class);
        ClothBean.DatasBean datasBean = new ClothBean.DatasBean();
        for (int i = 0; i < clothBean.getDatas().size(); i++) {
            datasBean = clothBean.getDatas().get(i);
            if (datasBean.getId().equals(childId)) {
                tvName.setText(datasBean.getTitle());
                break;
            }
        }
        GridLayoutManager layoutManager;
        if (datasBean.getTitle().equals("服装调查")) {
            linearLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
            layoutManager = new GridLayoutManager(this, 2);
        } else {
            linearLayout.setBackgroundColor(Color.parseColor("#f4f4f4"));
            layoutManager = new GridLayoutManager(this, 3);
        }
        //初始化RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyc);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CommonCycAdapter<ItemBinding, ClothBean.DatasBean.DataBean>(this, R.layout.item, datasBean.getData()) {
            @Override
            protected void getItem(ItemBinding binding, ClothBean.DatasBean.DataBean bean, int position) {
                int num = (int) SPUtils.get(bean.getName(), 0);
                binding.tvName.setText(bean.getName());
                binding.tvNum.setText(String.valueOf(num));
                Glide.with(MainActivity.this)
                        .load("file:///android_asset/" + bean.getImg())
                        .into(binding.iv);
            }

            @Override
            protected void itemOnclick(ClothBean.DatasBean.DataBean bean, int position) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                int num = (int) SPUtils.get(bean.getName(), 0);
                SPUtils.put(bean.getName(), ++num);
                //跳转到下一个页面
                if (bean.getChildId().equals("1")) {
                    Toast.makeText(MainActivity.this, "收集成功", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra(CHILDID, bean.getChildId());
                startActivity(intent);
                finish();
            }
        });
    }

    private long lastPressTime = 0L;//最后一次点击时间

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long currentThreadTimeMillis = System.currentTimeMillis();
            if (currentThreadTimeMillis - lastPressTime > 2000) {
                lastPressTime = currentThreadTimeMillis;
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 检查权限并授权
     */
    public void checkPsermissions() {
        String[] PERMISSIONS = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        if (PermissionUtis.checkPermissions(this, PERMISSIONS)) {
            PermissionUtis.requestPermissions(this, PermissionUtis.REQUESTCODE, PERMISSIONS);
        }
    }

    /**
     * 授权回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionUtis.REQUESTCODE:
                if (!PermissionUtis.hasAllPermissionsGranted(grantResults)) {
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
