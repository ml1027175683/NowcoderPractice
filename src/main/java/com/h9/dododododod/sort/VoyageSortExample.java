package com.h9.dododododod.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VoyageSortExample {

    public static void main(String[] args) {
        // 将数组转换为List对象
        List<PeriodReportBasic> periodReportList = getPeriodReportList();

        // 使用Comparator按照voyageStartTime排序
        Collections.sort(periodReportList, new Comparator<PeriodReportBasic>() {
            @Override
            public int compare(PeriodReportBasic report1, PeriodReportBasic report2) {
                return Long.compare(report1.getVoyageStartTime(), report2.getVoyageStartTime());
            }
        });

        // 输出排序后的结果
        for (PeriodReportBasic report : periodReportList) {
            System.out.println(report.getVoyageNo() + " - " + report.getVoyageStartTime());
        }
    }

    private static List<PeriodReportBasic> getPeriodReportList() {
        List<PeriodReportBasic> periodReportList = new ArrayList<>();

        // 添加数组中的元素到List中
        periodReportList.add(new PeriodReportBasic("141A", 1695189600000L));
        periodReportList.add(new PeriodReportBasic("142", 1695333600000L));
        periodReportList.add(new PeriodReportBasic("142A", 1694366280000L));
        periodReportList.add(new PeriodReportBasic("142B", 1695532320000L));

        return periodReportList;
    }
}

class PeriodReportBasic {
    private String voyageNo;
    private long voyageStartTime;

    public PeriodReportBasic(String voyageNo, long voyageStartTime) {
        this.voyageNo = voyageNo;
        this.voyageStartTime = voyageStartTime;
    }

    public String getVoyageNo() {
        return voyageNo;
    }

    public long getVoyageStartTime() {
        return voyageStartTime;
    }
}
