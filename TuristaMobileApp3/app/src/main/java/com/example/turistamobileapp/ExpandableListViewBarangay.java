package com.example.turistamobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ExpandableListViewBarangay extends BaseExpandableListAdapter {

    private final Context context;
    private final List<String> list_barangay;
    private final HashMap<String,List<String>> list_barangay_name;

    public ExpandableListViewBarangay(Context context, List<String> list_barangay, HashMap<String, List<String>> list_barangay_name) {
        this.context = context;
        this.list_barangay =list_barangay;
        this.list_barangay_name = list_barangay_name;
    }

    @Override
    public int getGroupCount() {
        return this.list_barangay.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return Objects.requireNonNull(this.list_barangay_name.get(this.list_barangay.get(groupPosition))).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.list_barangay.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return Objects.requireNonNull(this.list_barangay_name.get(this.list_barangay.get(groupPosition))).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       String name_place = (String)getGroup(groupPosition);
       if(convertView == null){
           LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.row_barangay_list,parent,false);
       }
        TextView name = convertView.findViewById(R.id.textVw_name_barangay);
        name.setText(name_place);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String name_barangay_list = (String)getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chapter_list_barangay,parent,false);
        }
        TextView list_barangay = convertView.findViewById(R.id.textVw_barangay_list);
        list_barangay.setText(name_barangay_list);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
