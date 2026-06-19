package team.rainfall.ctap_mingsha;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class NumberShortenUtil {
    public static final String getNumber_SHORT(int nValue) {
        if (nValue < 10000) {
            return "" + nValue;
        } else if (nValue < 100000000) {
            float tenThousand = (float) nValue / 10000.0f;
            String outValue = String.format("%.1f", tenThousand);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + CFG.lang.get("Value_TenThousand"); // 万
        } else {
            float hundredMillion = (float) nValue / 100000000.0f;
            String outValue = String.format("%.1f", hundredMillion);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + CFG.lang.get("Value_HundredMillion"); // 亿
        }
    }

    public static String getNumber_SHORT_ARMY(int nValue) {
        if (nValue < CFG.settingsGD.SHORTEN_ARMY_OVER) {
            return "" + nValue;
        } else if (nValue < 100000000) {
            float tenThousand = (float) nValue / 10000.0f;
            String outValue = String.format("%.1f", tenThousand);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + CFG.lang.get("Value_TenThousand");
        } else {
            float hundredMillion = (float) nValue / 100000000.0f;
            String outValue = String.format("%.1f", hundredMillion);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + CFG.lang.get("Value_HundredMillion");
        }
    }

    public static String getNumber_SHORT(long nValue) {
        if (nValue < 10000L) {
            return "" + nValue;
        } else if (nValue < 100000000L) {
            float tenThousand = (float) nValue / 10000.0f;
            String outValue = String.format("%.1f", tenThousand);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + CFG.lang.get("Value_TenThousand");
        } else {
            float hundredMillion = (float) nValue / 100000000.0f;
            String outValue = String.format("%.1f", hundredMillion);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }
            return outValue.replace(',', '.') + CFG.lang.get("Value_HundredMillion");
        }
    }
}
