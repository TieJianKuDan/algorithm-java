package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/1 10:29
 * @Description 165. 比较版本号
 * @Since version-1.0
 */
public class VersionComparison {
    public static void main(String[] args) {
        System.out.println(new VersionComparison().compareVersion("7.5.2.4","7.5.3"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = v1.length >= v2.length ? v1.length : v2.length;
        for (int i = 0; i < len; i++) {
            String revision1 = i < v1.length ? v1[i] : "0";
            String revision2 = i < v2.length ? v2[i] : "0";
            int count0 = Math.abs(revision1.length() - revision2.length());
            StringBuffer temp = new StringBuffer();
            for (int j = 0; j < count0; j++) {
                temp.append('0');
            }
            if (revision1.length() <= revision2.length()) {
                revision1 = temp.toString() + revision1;
            } else {
                revision2 = temp.toString() + revision2;
            }
            if (revision1.compareTo(revision2) > 0) {
                return 1;
            }
            if (revision1.compareTo(revision2) < 0) {
                return -1;
            }
        }
        return 0;
    }
}
