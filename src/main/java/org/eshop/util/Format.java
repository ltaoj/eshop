package org.eshop.util;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
public class Format {
    /**
     * 将List<String>转换成字符串格式：1, 2, 3
     * @param list
     * @return
     */
    public static String formatList(List list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("," + list.get(i));
        }
        return sb.length() > 0 ? sb.substring(1, sb.length()).toString() : "";
    }
}
