package socialnews.linccy.com.socialnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
import socialnews.linccy.com.socialnews.Activity.NewsDetailActivity;
import socialnews.linccy.com.socialnews.R;
import socialnews.linccy.com.socialnews.utils.NewsItem;

/**
 * Created by Lcc on 2016/7/9.
 */

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {

    private List<NewsItem> newsItems;
    private View view;
    private Context context;

    public NewsItemAdapter(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        context = parent.getContext();
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvTitle.setText(newsItems.get(position).getTitle());
        holder.tvDetail.setText(newsItems.get(position).getDescr());
        holder.tvTime.setText(newsItems.get(position).getTime());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "您选择了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("link", newsItems.get(position).getLink());;
                context.startActivity(intent);
            }
        });
        Picasso.with(view.getContext()).load(newsItems.get(position).getThumb()).into(holder.ivHeader);//Picasso异步加载预览图
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardview)
        CardView cardview;
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
