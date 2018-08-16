package com.shan.myproject;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * Created by root on 18-7-23.
 */

public class ExcelUtils {
    private Context context;

    public ExcelUtils(Context context) {
        this.context = context;
    }

    /**
     * 文件存储路径
     */
    public String getFile() {
        String folderPath = Environment.getExternalStorageDirectory() + "/laopo/";
        File path = new File(folderPath);
        if (!path.exists()) {
            path.mkdirs();//创建文件夹
        } else {
            FileUtils.deleteFile2(folderPath);
        }
        return folderPath + "/" + System.currentTimeMillis() + ".xls";
    }

    /**
     * 表头属性
     *
     * @return
     */
    public WritableCellFormat getHeader() {
        WritableFont font = new WritableFont(WritableFont.TIMES, 10,
                WritableFont.BOLD);// 定义字体
        try {
            font.setColour(Colour.BLUE);// 蓝色字体
        } catch (WriteException e1) {
            e1.printStackTrace();
        }
        WritableCellFormat format = new WritableCellFormat(font);
        try {
            format.setAlignment(jxl.format.Alignment.CENTRE);// 左右居中
            format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 上下居中
            format.setBorder(Border.ALL, BorderLineStyle.THIN,
                    Colour.BLACK);// 黑色边框
            format.setBackground(Colour.YELLOW);// 黄色背景
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     * 导出数据1
     *
     * @param list
     */
    public void exportData(ClothBean clothBean, List<ClothBean.DatasBean.DataBean> list) {
        try {
            //文件路径
            final String path = getFile();
            //生成excel工作表
            WritableWorkbook wwb;
            OutputStream os = new FileOutputStream(new File(path));
            wwb = Workbook.createWorkbook(os);
            //添加sheet表
            WritableSheet sheet = wwb.createSheet("服装统计1", 0);
            //添加excel表头
            String[] title = {"名称", "数量"};
            Label label;
            for (int i = 0; i < title.length; i++) {
                // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
                // 在Label对象的子对象中指明单元格的位置和内容
                label = new Label(i, 0, title[i], getHeader());
                // 将定义好的单元格添加到工作表中
                sheet.addCell(label);
            }
            //添加excel内容
            for (int i = 0; i < list.size(); i++) {
                ClothBean.DatasBean.DataBean dataBean = list.get(i);
                Label orderNum = new Label(0, i + 1, dataBean.getName());
                Label restaurant = new Label(1, i + 1, String.valueOf(dataBean.getNum()));
                sheet.addCell(orderNum);
                sheet.addCell(restaurant);
            }

            /**------------------------------------------------------*/
            //添加sheet表
            sheet = wwb.createSheet("服装统计2", 1);

            int row = 0;//列
            for (int i = 0; i < clothBean.getDatas().size(); i++) {
                ClothBean.DatasBean datasBean = clothBean.getDatas().get(i);
                List<ClothBean.DatasBean.DataBean> lists = datasBean.getData();
                //添加excel表头
                for (int j = 0; j < title.length; j++) {
                    // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
                    // 在Label对象的子对象中指明单元格的位置和内容
                    label = new Label(row, 0, title[j], getHeader());
                    // 将定义好的单元格添加到工作表中
                    sheet.addCell(label);
                    row++;
                }
                row++;
                //添加excel内容
                for (int j = 0; j < lists.size(); j++) {
                    ClothBean.DatasBean.DataBean dataBean = lists.get(j);
                    Label orderNum = new Label(row - 3, j + 1, dataBean.getName());
                    Label restaurant = new Label(row - 2, j + 1, String.valueOf(dataBean.getNum()));
                    sheet.addCell(orderNum);
                    sheet.addCell(restaurant);
                }
            }
            /**------------------------------------------------------*/
            // 写入数据
            wwb.write();
            // 关闭文件
            wwb.close();
            //导出成功
            new AlertDialog.Builder(context)
                    .setTitle("导出成功")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Vibrator vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
                            vibrator.vibrate(100);
                        }
                    })
                    .setPositiveButton("打开文件", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Vibrator vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
                            vibrator.vibrate(100);
                            IntentUtils.start(context, path);
                        }
                    })
                    .create().show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "导出失败", Toast.LENGTH_SHORT).show();
        }
    }
}
