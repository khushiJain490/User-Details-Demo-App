package com.example.generalaeronautics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Adapter<user, uri> extends RecyclerView.Adapter<Adapter.usersvViewHolder> {

    private Context uContext;
    private List<userModelClass> users;

    public static void navigate(Context context, Class<?> nameOfClass) {
        Intent i = new Intent(context, nameOfClass);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }


    public static final String TAG = "ADAPTER";


    public Adapter(Context uContext, List<userModelClass> users) {
        this.uContext = uContext;
        this.users = users;


    }


    @NonNull
    @Override
    public usersvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(uContext);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new usersvViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull Adapter.usersvViewHolder holder, int position) {
        holder.address.setText(users.get(position).getAddress().getStreet() + users.get(position).getAddress().getSuite() +
                users.get(position).getAddress().getCity() + users.get(position).getAddress().getZipcode());
        holder.bs.setText(users.get(position).getCompany().getBs());
        holder.name.setText(users.get(position).getName());
        holder.cname.setText(users.get(position).getCompany().getCname());
        holder.website.setText(users.get(position).getWebsite());
        holder.email.setText(users.get(position).getEmail());
        holder.phrase.setText('"' + users.get(position).getCompany().getCatchPhrase() + '"');
        holder.phone.setText(users.get(position).getPhone());
        double latitude = users.get(position).getAddress().getGeo().getLat();
        double longitude = users.get(position).getAddress().getGeo().getLng();


        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showOptionDialog(v.getContext());
            }
        });


        String imgurl = "https://jsonplaceholder.typicode.com/photos/" + users.get(position).getId();

        Glide.with(uContext)
                .load(imgurl)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);


    }


    String uri = "geo:?q=-43.9509,-34.4618 ";

    private void showOptionDialog(Context context) {

        String[] alertOptions = {"navigate to google maps", "show local address"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Choose from options");
        builder.setCancelable(true);
        builder.setSingleChoiceItems(alertOptions, 0, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setPackage("com.google.android.apps.maps");
                    getContext(context).startActivity(intent);
                }

                if (which == 1) {
                    Adapter.navigate(uContext, MapViewActivity.class);


                }

            }

            private Context getContext(Context context) {
                return context;
            }

        });
        builder.show();

    }


    @Override
    public int getItemCount() {
        return users.size();
    }


    public class usersvViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView bs, cname, name, phrase, website, email, address, phone;


        public usersvViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.userimage);
            bs = (TextView) itemView.findViewById(R.id.userbs);
            cname = (TextView) itemView.findViewById(R.id.usercname);
            name = (TextView) itemView.findViewById(R.id.name);
            phrase = (TextView) itemView.findViewById(R.id.catchphrase);
            website = (TextView) itemView.findViewById(R.id.userwebsite);
            email = (TextView) itemView.findViewById(R.id.useremail);
            address = (TextView) itemView.findViewById(R.id.useraddress);
            phone = (TextView) itemView.findViewById(R.id.userphone);


        }
    }


}




