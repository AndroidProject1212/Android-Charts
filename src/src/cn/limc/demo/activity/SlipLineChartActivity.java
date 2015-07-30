/*
 * SlipLineChartActivity.java
 * Android-Charts Demo
 *
 * Created by limc on 2014/04/29.
 *
 * Copyright 2014 limc.cn All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.limc.demo.activity;

import java.util.ArrayList;
import java.util.List;

import cn.limc.androidcharts.R;
import cn.limc.androidcharts.component.Axis;
import cn.limc.androidcharts.diagram.SlipLineChart;
import cn.limc.androidcharts.event.Zoomable;
import cn.limc.androidcharts.series.ChartDataSet;
import cn.limc.androidcharts.series.DateValueEntity;
import cn.limc.androidcharts.series.LineEntity;
import cn.limc.demo.common.BaseActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Menu;

public class SlipLineChartActivity extends BaseActivity {

    SlipLineChart sliplinechart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slip_line_chart);

        initSlipLineChart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.slip_line_chart, menu);
        return true;
    }

    private void initSlipLineChart() {
        this.sliplinechart = (SlipLineChart) findViewById(R.id.sliplinechart);
        ChartDataSet lines = new ChartDataSet();

        // 计算5日均线
        LineEntity ma5 = new LineEntity();
        ma5.setTitle("HIGH");
        ma5.setLineColor(Color.WHITE);
        ma5.setTableData(dv1);
        lines.add(ma5);

        // 计算10日均线
        LineEntity ma10 = new LineEntity();
        ma10.setTitle("LOW");
        ma10.setLineColor(Color.RED);
        ma10.setTableData(dv2);
        lines.add(ma10);


        sliplinechart.setAxisXColor(Color.LTGRAY);
        sliplinechart.setAxisYColor(Color.LTGRAY);
        sliplinechart.setBorderColor(Color.LTGRAY);
        sliplinechart.setLongitudeFontSize(14);
        sliplinechart.setLongitudeFontColor(Color.WHITE);
        sliplinechart.setLatitudeColor(Color.GRAY);
        sliplinechart.setLatitudeFontColor(Color.WHITE);
        sliplinechart.setLongitudeColor(Color.GRAY);
        sliplinechart.setMaxValue(1300);
        sliplinechart.setMinValue(700);
        sliplinechart.setDisplayFrom(10);
        sliplinechart.setDisplayNumber(30);
        sliplinechart.setMinDisplayNumber(5);
        sliplinechart.setZoomBaseLine(Zoomable.ZOOM_BASE_LINE_CENTER);
        sliplinechart.setDisplayLongitudeTitle(true);
        sliplinechart.setDisplayLatitudeTitle(true);
        sliplinechart.setDisplayLatitude(true);
        sliplinechart.setDisplayLongitude(true);
        sliplinechart.setDataQuadrantPaddingTop(5);
        sliplinechart.setDataQuadrantPaddingBottom(5);
        sliplinechart.setDataQuadrantPaddingLeft(5);
        sliplinechart.setDataQuadrantPaddingRight(5);
        // sliplinechart.setAxisYTitleQuadrantWidth(50);
        // sliplinechart.setAxisXTitleQuadrantHeight(20);
        sliplinechart.setAxisXPosition(Axis.AXIS_X_POSITION_BOTTOM);
        sliplinechart.setAxisYPosition(Axis.AXIS_Y_POSITION_RIGHT);

        sliplinechart.setChartData(lines);
    }

}
