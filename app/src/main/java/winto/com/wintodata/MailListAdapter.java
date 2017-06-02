package winto.com.wintodata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import winto.com.wintodata.utils.CommonUtils;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class MailListAdapter extends RecyclerView.Adapter{

    private ArrayList<ListItemModel> mDataList;
    private Context mContext;

    public MailListAdapter(ArrayList<ListItemModel> list, Context context) {
        this.mDataList = list;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mail_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder && !CommonUtils.isNull(mDataList) && mDataList.size() > position) {
            MyViewHolder myViewHolder = ((MyViewHolder) holder);
            myViewHolder.fillItem(mDataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (CommonUtils.isNull(mDataList)) {
            return 0;
        } else {
            return mDataList.size();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            //title = ((TextView) itemView.findViewById(R.id.tv_item));
        }

        public void fillItem(ListItemModel data) {
            if (data != null && title != null) {
                title.setText(data.getTitle());
            }
        }
    }

    public static class ListItemModel {
        String title;
        int type;

        public ListItemModel(String title, int t) {
            this.title = title;
            this.type = t;
        }

        public String getTitle() {
            return this.title;
        }
    }
}
