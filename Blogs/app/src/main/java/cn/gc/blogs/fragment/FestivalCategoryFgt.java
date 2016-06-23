package cn.gc.blogs.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.gc.blogs.ChooseMsgAty;
import cn.gc.blogs.R;
import cn.gc.blogs.bean.Festival;
import cn.gc.blogs.bean.FestivalLab;

/**
 * Created by 宫成 on 16/2/15 上午10:48.
 *
 */
public class FestivalCategoryFgt extends Fragment {

    @Bind(R.id.id_gv_festival)
    GridView mGridView;

    private ArrayAdapter<Festival> mAdapter;
    private LayoutInflater mInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflateView = inflater.inflate(R.layout.fgt_festivalcategory, container, false);
        return inflateView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(view, getActivity());
        mInflater = LayoutInflater.from(getActivity());
        mGridView = (GridView) view.findViewById(R.id.id_gv_festival);
        mGridView.setAdapter(mAdapter = new ArrayAdapter<Festival>(getActivity(), -1, FestivalLab.getInstance().getFestivals()) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.item_festival, parent, false);
                }
                TextView tv = (TextView) convertView.findViewById(R.id.id_tv_festival_name);
                tv.setText(getItem(position).getName());
                return convertView;
            }
        });
        mGridView.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(getActivity(), ChooseMsgAty.class);
            intent.putExtra(ChooseMsgAty.FestivalId, mAdapter.getItem(position).getId());
            startActivity(intent);
        });
    }
}
