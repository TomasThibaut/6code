package cn.gc.blogs;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.gc.blogs.bean.FestivalLab;
import cn.gc.blogs.bean.Msg;

public class ChooseMsgAty extends AppCompatActivity {

    @Bind(R.id.id_lv_choose)
    ListView mListView;

    @Bind(R.id.id_floatBtn_choose)
    FloatingActionButton mFloatBtnToSend;

    private ArrayAdapter<Msg> mAdapter;
    private int mFestivalId;
    public static final String FestivalId = "festival_id";
    private LayoutInflater mInflater;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_msg_aty);
        ButterKnife.bind(this);

        mFestivalId = getIntent().getIntExtra(FestivalId, -1);
        mInflater = LayoutInflater.from(this);
        mContext = this;

        initView();

        initEvent();
    }

    private void initEvent() {
        mFloatBtnToSend.setOnClickListener(v -> {
            // TODO: 16/2/15
        });
    }

    private void initView() {
        mListView.setAdapter(mAdapter = new ArrayAdapter<Msg>(this, -1, FestivalLab.getInstance()
                    .getMsgsByFestivalId(mFestivalId)) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.item_chooselist, parent, false);
                }
                TextView tv = (TextView) convertView.findViewById(R.id.id_tv_content);
                Button btnToSend = (Button) convertView.findViewById(R.id.id_btn_toSend);
                tv.setText(getItem(position).getContent());
                btnToSend.setOnClickListener(v -> {
                    // TODO: 16/2/15
                    Toast.makeText(mContext, mContext.getString(R.string.toast), Toast.LENGTH_SHORT)
                                .show();
                });
                return convertView;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_msg_aty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
