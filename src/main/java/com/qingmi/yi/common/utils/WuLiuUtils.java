package com.qingmi.yi.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 五运六气工具类
 * @Author: 李龙真
 * @Date: 2020/12/27 20:24
 */
public class WuLiuUtils {
    private static String[] solarTerm = { "小寒", "大寒", "立春", "雨水", "惊蛰", "春分",

            "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露",

            "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至" };
    private static int[] sTermInfo = { 0, 21208, 42467, 63836, 85337, 107014,

            128867, 150921, 173149, 195551, 218072, 240693, 263343, 285989,

            308563, 331033, 353350, 375494, 397447, 419210, 440795, 462224,

            483532, 504758 };
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    /**
     * 记录天干的信息
     */
    private static String[] gan_info = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛",
                     "壬", "癸"};
    private static String[] zhi_info = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未",
                     "申", "酉", "戌", "亥"};

    /**
     * 关于阴历的相关信息
     */
    private static int[] lunar_info = {0x04bd8, 0x04ae0, 0x0a570, 0x054d5,
            0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2, 0x04ae0,
            0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2,
            0x095b0, 0x14977, 0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40,
            0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970, 0x06566, 0x0d4a0,
            0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7,
            0x0c950, 0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0,
            0x092d0, 0x0d2b2, 0x0a950, 0x0b557, 0x06ca0, 0x0b550, 0x15355,
            0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
            0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263,
            0x0d950, 0x05b57, 0x056a0, 0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0,
            0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6, 0x095b0,
            0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46,
            0x0ab60, 0x09570, 0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50,
            0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0, 0x0c960, 0x0d954,
            0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0,
            0x0cab5, 0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0,
            0x0a5b0, 0x15176, 0x052b0, 0x0a930, 0x07954, 0x06aa0, 0x0ad50,
            0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
            0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6,
            0x0d250, 0x0d520, 0x0dd45, 0x0b5a0, 0x056d0, 0x055b2, 0x049b0,
            0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0};

    private static int year_ganZhi;
    private static int month_ganZhi;
    private static int day_ganZhi;
    /**
     * 获取y年第n个节气的日期，从0开始算第一个
     * @param y 年
     * @param n 第几个
     * @param d 加几天
     * @return
     */
    private static Integer sTermDate(int y, int n,int d) {
        Calendar cal = Calendar.getInstance();
        cal.set(1900, 0, 6, 2, 5, 0);
        long temp = cal.getTime().getTime();
        cal.setTime(new Date((long) ((31556925974.7 * (y - 1900) + sTermInfo[n] * 60000L) + temp)));
        cal.add(Calendar.DATE, d);
        String date = dateFormat.format(cal.getTime());
        return Integer.parseInt(date);
    }

    /**
     * 获取当前日期对应的五运
     * @return
     */
    public static int getWuYun(String date1){

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        if(StringUtils.isNotBlank(date1)){
            String[] split = date1.split(",");
            year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            now.set(year,month,day);
        }
        int daHan = sTermDate(year,1,0);
        String date = dateFormat.format(now.getTime());
        int nowDate = Integer.parseInt(date);
        //比较当前日期和大寒的大小
        if(nowDate < daHan){//当前日期小于于大寒日 当前年减一
            year = year-1;
        }
        //计算五运的五个节点日期
        //第一个 大寒 上面有了 daHan
        //第二个 春分后十三天
        int chunFen = sTermDate(year,5,13);

        // 第三个 芒种后十日
        int mangZhong = sTermDate(year,10,10);

        //第四个 处暑后七日
        int chuShu = sTermDate(year,15,7);

        //第五个 立冬后四日
        int liDong = sTermDate(year,20,4);

        //开始计算当前日期是五运中的第几个
        int yun = 0;
        if(nowDate >= daHan && nowDate < chunFen){//第一
            yun = 1;
        }else if(nowDate >= chunFen && nowDate <mangZhong){
            yun = 2;
        }else if(nowDate >= mangZhong && nowDate <chuShu){
            yun = 3;
        }else if(nowDate >= chuShu && nowDate < liDong){
            yun = 4;
        }else if(nowDate >= liDong){
            yun = 5;
        }
        return yun;
    }

    /**
     * 获取当前日期所对应的六气
     * @return
     */
    public static int getLiuQi(String date1){

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        if(StringUtils.isNotBlank(date1)){
            String[] split = date1.split(",");
            year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            now.set(year,month,day);
        }
        int daHan = sTermDate(year,1,0);
        String date = dateFormat.format(now.getTime());
        int nowDate = Integer.parseInt(date);
        //比较当前日期和大寒的大小
        if(nowDate < daHan){//当前日期小于于大寒日 当前年减一
            year = year-1;
        }

        //春分
        int chunFen = sTermDate(year,5,0);
        //小满
        int xiaoMan = sTermDate(year,9,0);
        //大暑
        int daShu = sTermDate(year,12,0);
        //秋分
        int qiufen = sTermDate(year,17,0);
        //小雪
        int xiaoXue = sTermDate(year,21,0);

        int qi = 0;
        if(nowDate >= daHan && nowDate < chunFen){//第一
            qi = 1;
        }else if(nowDate >= chunFen && nowDate <xiaoMan){
            qi = 2;
        }else if(nowDate >= xiaoMan && nowDate <daShu){
            qi = 3;
        }else if(nowDate >= daShu && nowDate < qiufen){
            qi = 4;
        }else if(nowDate >= qiufen && nowDate < xiaoXue){
            qi = 5;
        }else if(nowDate >= xiaoXue){
            qi = 6;
        }
        return qi;
    }


    /**
     * 获取农历某年的总天数
     *
     * @param year
     * @return
     */
    private static int daysOfYear(int year) {
        int sum = 348;
        for (int i = 0x8000; i > 0x8; i >>= 1) {
            sum += (lunar_info[year - 1900] & i) == 0 ? 0 : 1;
        }
        //获取闰月的天数
        int daysOfLeapMonth;
        if ((lunar_info[year - 1900] & 0xf) != 0) {
            daysOfLeapMonth = (lunar_info[year - 1900] & 0x10000) == 0 ? 29 : 30;
        } else {
            daysOfLeapMonth = 0;
        }
        return sum + daysOfLeapMonth;
    }

    /**
     * 初始化年月日对应的天干地支
     */
    public static void initGanZhi(String date) {
        //获取现在的时间
        Calendar calendar_now = Calendar.getInstance();
        int year = calendar_now.get(Calendar.YEAR);
        int month = calendar_now.get(Calendar.MONTH);
        int day =calendar_now.get(Calendar.DATE);
        if(StringUtils.isNotBlank(date)){
            String[] split = date.split(",");
            year = Integer.parseInt(split[0]);
            month = Integer.parseInt(split[1]);
            day = Integer.parseInt(split[2]);
        }
        calendar_now.set(year, month, day);
        long date_now = calendar_now.getTime().getTime();
        //获取1900-01-31的时间
        Calendar calendar_ago = Calendar.getInstance();
        calendar_ago.set(1900, 0 ,31);
        long date_ago = calendar_ago.getTime().getTime();
        //86400000 = 24 * 60 * 60 * 1000
        long days_distance = (date_now - date_ago) / 86400000L;
        float remainder = (date_now - date_ago) % 86400000L;
        //余数大于0算一天
        if (remainder > 0) {
            days_distance += 1;
        }
        //都是从甲子开始算起以1900-01-31为起点
        //1899-12-21是农历1899年腊月甲子日  40：相差1900-01-31有40天
        day_ganZhi = (int)days_distance + 40;
        //1898-10-01是农历甲子月  14：相差1900-01-31有14个月
        month_ganZhi = 14;
        int daysOfYear = 0;
        int i;
        for (i = 1900; i < 2050 && days_distance > 0; i++) {
            daysOfYear = daysOfYear(i);
            days_distance -= daysOfYear;
            month_ganZhi += 12;
        }
        if (days_distance < 0) {
            days_distance += daysOfYear;
            i--;
            month_ganZhi -= 12;
        }
        //农历年份
        int myYear = i;
        //1864年是甲子年
        year_ganZhi = myYear - 1864;
        //哪个月是闰月
        int leap = lunar_info[myYear - 1900] & 0xf;
        boolean isLeap = false;
        int daysOfLeapMonth = 0;
        for (i = 1; i < 13 && days_distance > 0; i++) {
            //闰月
            if (leap > 0 && i == (leap + 1) && !isLeap) {
                isLeap = true;
                if ((lunar_info[myYear - 1900] & 0xf) != 0) {
                    daysOfLeapMonth = (lunar_info[myYear - 1900] & 0x10000) == 0 ? 29 : 30;
                } else {
                    daysOfLeapMonth = 0;
                }
                --i;
            } else {
                daysOfLeapMonth = (lunar_info[myYear - 1900] & (0x10000 >> i)) == 0 ? 29 : 30;
            }
            //设置非闰月
            if (isLeap && i == (leap + 1)) {
                isLeap = false;
            }
            days_distance -= daysOfLeapMonth;
            if (!isLeap) {
                month_ganZhi++;
            }
        }
        if (days_distance == 0 && leap > 0 && i == leap + 1 && !isLeap) {
            --month_ganZhi;
        }
        if (days_distance < 0) {
            --month_ganZhi;
        }
    }

    /**
     * 将年月日转化为天干地支的显示方法
     * @param index
     * @return
     */
    private static String ganZhi(int index) {
        return gan_info[index % 10] + zhi_info[index % 12];
    }

    /**
     * 获取天干地支
     * @return
     */
    public static String getGanZhi(String date) {
        initGanZhi(date);
        return ganZhi(year_ganZhi);
    }

    public static void main(String[] args) {
//        int yun = getWuYun();
//        int qi = getLiuQi();
//        String s = getGanZhi();
//        System.out.println("s="+s);

    }
}
