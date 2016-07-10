package socialnews.linccy.com.socialnews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import socialnews.linccy.com.socialnews.utils.NewsItem;
import socialnews.linccy.com.socialnews.R;

/**
 * Created by Lcc on 2016/7/9.
 */

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {

    private static List<NewsItem> newsItems;
    private View view;

    public NewsItemAdapter(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cardview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(newsItems.get(position).getTitle());
        holder.tvDetail.setText(newsItems.get(position).getDescription());
        holder.tvTime.setText(newsItems.get(position).getCtime());
        Picasso.with(view.getContext()).load(newsItems.get(position).getPicUrl()).into(holder.ivHeader);//Picasso异步加载预览图
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_header)
        ImageView ivHeader;

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_detail)
        TextView tvDetail;
        @BindView(R.id.tv_time)
        TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
