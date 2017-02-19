package com.ogoons.checkablesample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ogoons on 2017-02-19.
 */

public class CustomAdapter extends ArrayAdapter<ListItem> {
    private LayoutInflater mInflater;

    public CustomAdapter(Context context, int resource, List<ListItem> objects) {
        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.list_item_checkable, parent, false);
            holder = new ViewHolder();
            holder.rlButton = (CheckableRelativeLayout) convertView.findViewById(R.id.rl_button);
            holder.textView = (TextView) convertView.findViewById(R.id.tv);
            holder.radioButton = (RadioButton) convertView.findViewById(R.id.rb_button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListItem item = getItem(position);
        holder.textView.setText(item.name);
        if (holder.radioButton.isChecked()) {
            holder.rlButton.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_dark));
        } else {
            holder.rlButton.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.white));
        }

        return convertView;
    }

    private class ViewHolder {
        public CheckableRelativeLayout  rlButton;
        public TextView                 textView;
        public RadioButton              radioButton;
    }
}
