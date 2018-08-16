package com.shan.myproject;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * RecyclerView公共Adapter
 * Created by chenjunshan 17-3-9.
 */

public abstract class CommonCycAdapter<T extends ViewDataBinding, D> extends RecyclerView.Adapter<CommonCycAdapter.CommonHolder> {
    private Context context;
    private int res;//布局
    private List<D> datas;//数据

    public CommonCycAdapter(Context context, int res, List<D> datas) {
        this.context = context;
        this.res = res;
        this.datas = datas;
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        T t = DataBindingUtil.inflate(LayoutInflater.from(context), res, parent, false);
        CommonHolder holder;
        holder = new CommonHolder(t.getRoot());
        holder.setT(t);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommonHolder holder, final int position) {
        getItem((T) holder.getT(), datas.get(position), position);
        holder.getT().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemOnclick(datas.get(position), position);
            }
        });
        getHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    protected abstract void getItem(T binding, D bean, int position);

    protected abstract void itemOnclick(D bean, int position);

    public void getHolder(CommonHolder holder, int position) {
    }

    /**
     * 更新数据
     *
     * @param datas
     */
    public void updata(List<D> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    /**
     * 增加数据
     *
     * @param datas
     */
    public void addData(List<D> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 清空数据
     */
    public void clear() {
        this.datas.clear();
        notifyDataSetChanged();
    }

    public static class CommonHolder extends RecyclerView.ViewHolder {
        ViewDataBinding t;

        public CommonHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getT() {
            return t;
        }

        public void setT(ViewDataBinding t) {
            this.t = t;
        }
    }

    public List<D> getDatas() {
        return datas;
    }
}
