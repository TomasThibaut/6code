package cn.gc.custviewfucker.fgts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.gc.custviewfucker.R;

/**
 * Created by 宫成 on 16/5/8 下午10:12.
 */
public class CanvasFgt extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_canvas, null);
        return view;
    }
}
