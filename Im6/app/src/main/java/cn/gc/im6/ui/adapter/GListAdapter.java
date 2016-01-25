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
import cn.gc.im6.api.entity.GListEntity;

/**
 * Created by 宫成 on 16/1/22 上午12:09.
 *
 */
public class GListAdapter extends RecyclerView.Adapter<GListAdapter.ViewHolder> {
    private Context mContext;
    private List<GListEntity.GameListEntity> data;

    public GListAdapter(Context context, List<GListEntity.GameListEntity> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public GListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.glist_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GListAdapter.ViewHolder holder, int i) {
        holder.gameName.setText(data.get(i).getGameName());
        holder.gameNum.setText(data.get(i).getLiveCount());
        //图片
        Glide.with((MainActivity) mContext).load(data.get(i).getIconURL()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.gameName_glist)
        TextView gameName;
        @Bind(R.id.gameNum_glist)
        TextView gameNum;
        @Bind(R.id.iv_glist)
        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
