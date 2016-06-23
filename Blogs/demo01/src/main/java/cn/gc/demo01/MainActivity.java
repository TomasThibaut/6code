package cn.gc.demo01;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.lv_right)
    ListView lv_right;

    private List<Integer> ids = new ArrayList<>();
    private ArrayAdapter<Integer> leftAdapter;
    private MyAdapter rightAdapter;
    private LayoutInflater mInflater;

    private boolean toggleCheckBox = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mInflater = LayoutInflater.from(this);
        initData();
        initListView();
    }

    /**
     * 模拟用的假数据
     */
    private void initData() {
        for (int i = 0; i < 30; i++) {
            ids.add(i);
        }
    }

    private void initListView() {
        lv_right.setAdapter(rightAdapter = new MyAdapter(this, ids));
    }

    @OnClick(R.id.btn_edit)
    public void onClickEdit() {
        if (!toggleCheckBox) {
            rightAdapter.showCheckBox();
            toggleCheckBox = !toggleCheckBox;
        } else {
            rightAdapter.hideCheckBox();
            toggleCheckBox = !toggleCheckBox;
        }
        rightAdapter.notifyDataSetChanged();
    }
}
