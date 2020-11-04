package com.example.discretesolutions;

import androidx.annotation.DrawableRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

public class completed_projects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_projects);
        LinearLayout t = (LinearLayout) findViewById(R.id.lscp);
        TextView txtv = (TextView) findViewById(R.id.cpstatus);
        /*
        cparr[] = getCP();
        count = cparr.length();
        */
        int length = 10;
        for (int i = 0; i < length; i++) {
            createElement("XY", "W125", "1/02/2001", "2/03/2002", i);
        }
        txtv.setText("You currently have ".concat(Integer.toString(length)) + " projects");
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout lvv;
                for (int j = 0; j < length; j++) {
                    lvv = (LinearLayout) findViewById(2000 + j);
                    int finalJ = j;
                    lvv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtv.setText(Integer.toString(finalJ));
                        }
                    });
                }
            }
        });
    }

    public void createElement(String projectName, String projectId, String dateStarted, String dateEnded, int i) {
        LinearLayout t = (LinearLayout) findViewById(R.id.lscp);
        LinearLayout lv = new LinearLayout(this);
        lv.setOrientation(LinearLayout.VERTICAL);
        TextView displayID = new TextView(this);
        TextView displayName = new TextView(this);
        TextView displaySD = new TextView(this);
        TextView displayED = new TextView(this);
        dateStarted = "Started on ".concat(dateStarted);
        dateEnded = "Ended on ".concat(dateEnded);
        System.out.println(dateEnded);
        System.out.println("lol");
        System.out.println(dateStarted);
        displayName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        displayID.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        displayED.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        displaySD.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        displayName.setTextColor(Color.parseColor("#000000"));
        displayID.setTextColor(Color.parseColor("#f1f1f1"));
        displaySD.setTextColor(Color.parseColor("#f1f1f1"));
        displayED.setTextColor(Color.parseColor("#f1f1f1"));
        SpannableString ss = new SpannableString(projectName);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 0, projectName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        displayName.setText(ss);
        ss = new SpannableString(projectId);
        boldSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        ss.setSpan(boldSpan, 0, projectId.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        displayID.setText(ss);
        ss = new SpannableString(dateStarted);
        boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 0, dateStarted.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        displaySD.setText(ss);
        ss = new SpannableString(dateEnded);
        boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 0, dateEnded.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        displayED.setText(ss);
        displayName.layout(10, 10, 10, 5);
        displayID.layout(10, 5, 10, 5);
        displaySD.layout(10, 5, 10, 5);
        displayED.layout(10, 5, 10, 10);
        lv.setId(2000 + i);
        lv.addView(displayName);
        lv.addView(displayID);
        lv.addView(displaySD);
        lv.addView(displayED);
        lv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lv.setBackgroundResource(R.drawable.customshape6);
        LinearLayout.LayoutParams Lp = (LinearLayout.LayoutParams) lv.getLayoutParams();
        Lp.setMargins(0, 0, 0, 60);
        lv.setLayoutParams(Lp);
        t.addView(lv);
    }
}