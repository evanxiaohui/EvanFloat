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

public class TestActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_float_act);

    //右上下拉
    final FloatingActionButton btnwidget_i_query = (FloatingActionButton) findViewById(R.id.widget_i_query);
    btnwidget_i_query.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        btnwidget_i_query.setIcon(R.drawable.i_query_checked);
       // ((FloatingActionsMenu) findViewById(R.id.multiple_actions_down)).removeButton(removeAction);
      }
    });

  }
}
