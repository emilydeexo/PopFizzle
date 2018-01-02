package com.example.edeleon8425.popfizzle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<News> use;

    public NewsAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context,textViewResourceId, objects);

        this.context= context;
        use=objects;

    }

    private class ViewHolder
    {
        TextView name;
        TextView genre;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder=null;
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.layout_news, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.genre=(TextView)convertView.findViewById(R.id.genre);
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        News individualUser= use.get(position);
        holder.name.setText(individualUser.getName()+"");
        holder.genre.setText(individualUser.getGenre());
        return convertView;


    }
}
