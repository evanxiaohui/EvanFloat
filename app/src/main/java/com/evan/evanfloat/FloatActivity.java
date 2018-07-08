package com.evan.evanfloat;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.getbase.evanphoto.FloatingActionButton;
import com.getbase.evanphoto.FloatingActionsMenu;

public class FloatActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.float_act);

    //左下按钮，动态改变属性
    FloatingActionButton button = (FloatingActionButton) findViewById(R.id.setter);
    button.setSize(FloatingActionButton.SIZE_MINI);
    button.setColorNormalResId(R.color.pink);
    button.setColorPressedResId(R.color.pink_pressed);
    button.setIcon(R.drawable.ic_fab_star);
    button.setStrokeVisible(false);

    //给按钮动态设置样式
    ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
    drawable.getPaint().setColor(getResources().getColor(R.color.white));
    button.setIconDrawable(drawable);

    //底部按钮
    findViewById(R.id.pink_icon).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(FloatActivity.this, "我是五角星按钮哦", Toast.LENGTH_SHORT).show();
      }
    });

    //右上下拉
    final FloatingActionButton removeAction = (FloatingActionButton) findViewById(R.id.button_remove);
    removeAction.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        ((FloatingActionsMenu) findViewById(R.id.multiple_actions_down)).removeButton(removeAction);
      }
    });


    //右下上拉
    final View actionB = findViewById(R.id.action_b);
    FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
    actionC.setTitle("隐藏第二项");
    actionC.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
      }
    });

    final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
      menuMultipleActions.addButton(actionC);

    final FloatingActionButton actionEnable = (FloatingActionButton) findViewById(R.id.action_enable);
    actionEnable.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(FloatActivity.this, "禁用右下角按钮", Toast.LENGTH_SHORT).show();
        menuMultipleActions.setEnabled(!menuMultipleActions.isEnabled());
      }
    });

    //左边新增按钮
    FloatingActionsMenu rightLabels = (FloatingActionsMenu) findViewById(R.id.right_labels);
    FloatingActionButton addedOnce = new FloatingActionButton(this);
    addedOnce.setTitle("新增的第一个按钮");
    rightLabels.addButton(addedOnce);

    FloatingActionButton addedTwice = new FloatingActionButton(this);
    addedTwice.setTitle("新增的第二个按钮");
    rightLabels.addButton(addedTwice);
    rightLabels.removeButton(addedTwice);
    rightLabels.addButton(addedTwice);

  }
}
