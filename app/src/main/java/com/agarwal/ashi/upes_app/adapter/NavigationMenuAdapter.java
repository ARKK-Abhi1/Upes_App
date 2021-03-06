package com.agarwal.ashi.upes_app.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.agarwal.ashi.upes_app.R;
import com.agarwal.ashi.upes_app.pojo.School;
import com.agarwal.ashi.upes_app.pojo.Society;

import java.util.ArrayList;

/**
 * Created by 500060150 on 10-03-2018.
 */

public class NavigationMenuAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<String> menuNames;
    ArrayList<School> schools;
    ArrayList<Society> societies;
    ArrayList<ArrayList<Society>> schoolSocieties;
    public NavigationMenuAdapter(Context context,ArrayList<School> schools,ArrayList<Society> societies,ArrayList<String> menuNames){
        this.context=context;
        this.schools=schools;
        this.societies=societies;
        this.menuNames=menuNames;
        updateDataSet();
    }
    public ArrayList<String> getMenuNames() {
        return menuNames;
    }

    public void setMenuNames(ArrayList<String> menuNames) {
        this.menuNames = menuNames;
    }

    public ArrayList<School> getSchools() {
        return schools;
    }

    public void setSchools(ArrayList<School> schools) {
        this.schools = schools;
    }

    public ArrayList<Society> getSocieties() {
        return societies;
    }

    public void setSocieties(ArrayList<Society> societies) {
        this.societies = societies;
    }


    private void updateDataSet() {
        schoolSocieties=new ArrayList<ArrayList<Society>>();
        for(int i=0;i<schools.size();i++) {
            ArrayList<Society> temp = new ArrayList<>();
            for(int j=0;j<societies.size();j++) {
                String schoolName=societies.get(j).getSchool();
                if(schoolName!=null) {
                    if (schoolName.equalsIgnoreCase(schools.get(i).getName())) {
                        temp.add(societies.get(j));
                    }
                }
            }
            schoolSocieties.add(temp);
        }
    }

    @Override
    public int getGroupCount() {
        return menuNames.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(groupPosition==0) // Home
            return 0;
        else
            return schoolSocieties.get(groupPosition-1).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        if(groupPosition==0)
            return null;
        return schools.get(groupPosition-1);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return schoolSocieties.get(groupPosition-1).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        switch(groupPosition) {
            case 0 : return context.getResources().getInteger(R.integer.home);
            case 1 : return context.getResources().getInteger(R.integer.socs);
            case 2 : return context.getResources().getInteger(R.integer.soe);
            case 3 : return context.getResources().getInteger(R.integer.sob);
            case 4 : return context.getResources().getInteger(R.integer.sol);
            case 5 : return context.getResources().getInteger(R.integer.sod);
            case 6 : return context.getResources().getInteger(R.integer.other);
            default: return groupPosition;
        }
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return (10000000)*groupPosition+childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View convertView, ViewGroup viewGroup) {
        ConstraintLayout groupHeader;
        TextView tV;
        ImageView iV;
        ImageView arrow;
        if(convertView==null) {
            groupHeader=(ConstraintLayout) LayoutInflater.from(context).inflate(R.layout.nav_menu_group_header,null);
        }
        else {
            groupHeader=(ConstraintLayout) convertView;
        }
        iV=(ImageView)groupHeader.findViewById(R.id.icon_view);
        tV=(TextView)groupHeader.findViewById(R.id.child_name);
        tV.setText(menuNames.get(groupPosition));
        if(groupPosition==0)
            iV.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_home_black_24dp,null));
        else
            iV.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_school_black_24dp));
        arrow = (ImageView) groupHeader.findViewById(R.id.arrow);
        if(getChildrenCount(groupPosition)!=0) {
            arrow.setVisibility(View.VISIBLE);
        }
        else { // required because the view object received could be a recycled one
            arrow.setVisibility(View.INVISIBLE);
        }
        return groupHeader;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        ConstraintLayout groupItem;
        TextView tV;
        if(convertView==null) {
            groupItem=(ConstraintLayout) LayoutInflater.from(context).inflate(R.layout.nav_menu_group_item,null);
        }
        else {
            groupItem=(ConstraintLayout) convertView;
        }
        tV=(TextView)groupItem.findViewById(R.id.child_name);
        tV.setText(schoolSocieties.get(groupPosition-1).get(childPosition).getSocietyName());
        return groupItem;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    @Override
    public void notifyDataSetChanged() {
        System.out.println("notifyDataSetChanged()");
        updateDataSet();
        super.notifyDataSetChanged();
    }
}
