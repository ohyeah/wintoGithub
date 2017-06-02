package winto.com.wintodata.utils;

import java.text.DecimalFormat;

/**
 * Created by hkun2012 on 2017/5/28.
 */

public class CommonUtils {

    public static boolean isNull(Object o) {
        return o == null ? true : false;
    }

    public static boolean isEmptyString(String s) {
        if (s == null || "".equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    // 百分比保留2位小数
    public static String getFormatPercent(final double d) {
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(d * 100)) + "%";
        } catch (Exception e) {
            return "数据异常";
        }
    }

    public static String ThirdActivityGetFormatData(final double d, final int bits) {
        try {
            DecimalFormat df;
            if (bits == 4) {
                df = new DecimalFormat("#.####");
            } else if (bits == 5) {
                df = new DecimalFormat("#.#####");
            } else {
                return "数据异常";
            }
            return df.format(d);
        } catch (Exception e) {
            return "数据异常";
        }
    }

    public static String FloaRateActivityGetFormatData(final double d) {
        try {
            DecimalFormat df;
            df = new DecimalFormat("#.#####");
            return df.format(d);
        } catch (Exception e) {
            return "数据异常";
        }
    }

    public static void main(String[] args) {
        double d = 1.3455223456;
        System.out.println("d: " + getFormatPercent(d));
    }
}
