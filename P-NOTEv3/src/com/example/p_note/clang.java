package com.example.p_note;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class clang extends ExpandableListActivity implements
  OnChildClickListener {

 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  ExpandableListView expandbleLis = getExpandableListView();
  expandbleLis.setDividerHeight(2);
  expandbleLis.setGroupIndicator(null);
  expandbleLis.setClickable(true);

  setGroupData();
  setChildGroupData();

  NewAdapter mNewAdapter = new NewAdapter(groupItem, childItem);
  mNewAdapter
    .setInflater(
      (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
      this);
  getExpandableListView().setAdapter(mNewAdapter);
  expandbleLis.setOnChildClickListener(this);
 }

 public void setGroupData() {
  groupItem.add("1. How to create a new note");
  groupItem.add("2. How to capture images");
  groupItem.add("3. What is Tagging?");
  groupItem.add("4. Geo tagging");
 
 }

 ArrayList<String> groupItem = new ArrayList<String>();
 ArrayList<Object> childItem = new ArrayList<Object>();

 public void setChildGroupData() {
  /**
   * Add Data For TecthNology
   */
  ArrayList<String> child = new ArrayList<String>();
  child.add(" -> Click on new note \n ->Give title \n ->Give Body \n ->Tag your note \n ->Save note ");
  childItem.add(child);

  child = new ArrayList<String>();
  child.add(" ->Click on gallery or camera \n ->Click or select photo \n ->Add it to your note ");
  childItem.add(child);

  child = new ArrayList<String>();
  child.add("->Color tag or geo tag your photo \n ->Give paticular colour to your photo \n ->Tag it with place where you clicked the picture ");
  childItem.add(child);

  child = new ArrayList<String>();
  child.add("-> It means tag the photo by embedding its location to the photo");
  childItem.add(child);
  
 
 
 }
}