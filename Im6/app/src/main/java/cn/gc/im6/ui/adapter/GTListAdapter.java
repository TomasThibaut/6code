package cn.gc.im6.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.gc.im6.MainActivity;
import cn.gc.im6.R;
import cn.gc.im6.api.entity.GTListEntity.GameTypeListEntity;

/**
 * Created by 宫成 on 16/1/22 上午9:39.
 *
 */
public class GTListAdapter extends RecyclerView.Adapter<GTListAdapter.ViewHolder> {
    private Context mContext;
    private List<GameTypeListEntity> data;


    public GTListAdapter(Context context, List<GameTypeListEntity> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public GTListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.gtlist_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GTListAdapter.ViewHolder holder, int position) {
        holder.name.setText(data.get(position).getGameTypeName());
        Glide.with((MainActivity) mContext).load(data.get(position).getGameIconURL()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_gtlist_head)
        ImageView icon;
        @Bind(R.id.name_gtlist)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
