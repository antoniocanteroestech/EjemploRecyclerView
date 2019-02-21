package es.estech.ejemplorecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> listItems;
    private Context context;

    public UserAdapter(List<User> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_user, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final User singleItem = listItems.get(position);

        holder.tvName.setText(singleItem.getName());
        holder.tvTitle.setText(singleItem.getTitle());
        holder.tvCompany.setText(singleItem.getCompany());
        Glide.with(context).load(singleItem.getImage()).into(holder.ivAvatar);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvTitle, tvCompany;
        ImageView ivAvatar;

        LinearLayout linearLayoutCard;

        ViewHolder(View itemView) {
            super(itemView);

            //connect our local objects with the actual widgets ID
            tvName = itemView.findViewById(R.id.tv_name);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCompany = itemView.findViewById(R.id.tv_company);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            linearLayoutCard = itemView.findViewById(R.id.listview);
        }
    }

}