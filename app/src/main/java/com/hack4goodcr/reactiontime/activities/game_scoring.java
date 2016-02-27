package com.hack4goodcr.reactiontime.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.hack4goodcr.reactiontime.R;
import java.sql.Date;
import java.util.ArrayList;

import persistence.Historic;
public class game_scoring extends AppCompatActivity implements OnChartValueSelectedListener, SeekBar.OnSeekBarChangeListener {
    private TextView edad;
    private TextView tittle_edad;
    private TextView time;
    private TextView tittle_time;
    private int age;
    protected BarChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;
    private final int itemcount = 10;
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scoring);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        score = bundle.getString("score");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        edad = (TextView) findViewById(R.id.txt_age);
        tittle_edad = (TextView) findViewById(R.id.txt_title_age);
        tittle_time = (TextView) findViewById(R.id.txt_title_time);
        time = (TextView) findViewById(R.id.txt_time);
        tittle_edad.setText("Esta es tu edad:");
        tittle_time.setText("Este es tu tiempo:");
        int scoreFinal = Integer.parseInt(score);
        scoreFinal = scoreFinal /1000;
        time.setText(String.valueOf(scoreFinal)+ " segundos");
        String tiempo="None";
        double aux=0;
       /* Historic historic = new Historic(score,age, new Date(utilDate.getTime()));
        historic.save();*/

        aux=(Double)(Long.parseLong(score)*0.001);

        score=Double.toString(Math.rint(aux*1000)/1000);
        if(aux<=1)
            edad.setText("22-25");
        else
        if(aux>1 && aux<=1.2)
            edad.setText("15-22");
        else
        if(aux>1.2 && aux<=1.7)
            edad.setText("25-27");
        else
        if(aux>1.7 && aux<=1.9)
            edad.setText("27-30");
        else
        if(aux>1.9 && aux<=2.2)
            edad.setText("30-35");
        else
        if(aux>2.2 && aux<=2.5)
            edad.setText("35-45");
        else
        if(aux>2.5 && aux<=2.9)
            edad.setText("45-55");
        else
        if(aux>=2.9)
            edad.setText("60+");


    /*    historic.score = score;
        historic.age = age;*/

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Historic historic = Historic.findAll(Historic);
            }
        });

        tvX = (TextView) findViewById(R.id.tvXMax);
        tvY = (TextView) findViewById(R.id.tvYMax);

        mSeekBarX = (SeekBar) findViewById(R.id.seekBar1);
        mSeekBarY = (SeekBar) findViewById(R.id.seekBar2);

        mChart = (BarChart) findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);

        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);

        mChart.setDescription("");

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(10);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mChart.setDrawGridBackground(false);
        // mChart.setDrawYLabels(false);



        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(2);

       // YAxisValueFormatter custom = new MyYAxisValueFormatter();

        YAxis leftAxis = mChart.getAxisLeft();

        leftAxis.setLabelCount(8, false);
       // leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);

        rightAxis.setLabelCount(8, false);
        //rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        // l.setExtra(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });
        // l.setCustom(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });

        setData(10, 50);

        // setting data
        mSeekBarY.setProgress(50);
        mSeekBarX.setProgress(10);

        mSeekBarY.setOnSeekBarChangeListener(this);
        mSeekBarX.setOnSeekBarChangeListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_send:
                String shareText = getString(R.string.share1)+" "+ score + " y esta tu edad de acuerdo a tu tiempo de respuesta: "+ edad.getText().toString() + " años";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.extra_subject));
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareText);
                startActivity(sharingIntent);
                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    private void setData(int count, float range) {

        String[] mMonths = new String[]{"15","22","25","27","30","35","45","50","55","60"};

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {

            xVals.add(mMonths[i % 10]);
        }

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        float vals [] = new float[]{1,2,3,4,5,6,7,8,9,10 };

        for (int i = 0; i < count; i++) {
            float mult = (range + 1);

            yVals1.add(new BarEntry(vals[i], i));
        }

        BarDataSet set1 = new BarDataSet(yVals1, "DataSet");
        set1.setBarSpacePercent(35f);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);


        mChart.setData(data);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

