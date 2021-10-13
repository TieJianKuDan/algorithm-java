package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/9 10:37
 * @Description 68. 文本左右对齐
 * @Since version-1.0
 */
public class FullJustify {
    public static void main(String[] args) {
        System.out.println(new FullJustify().fullJustify(new String[]{"a"}, 1));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int width = words[0].length();
        int start = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(words[0]);
        if (words.length == 1) {
            for (int j = 0; j < maxWidth - width; j++) {
                builder.append(" ");
            }
            res.add(builder.toString());
            return res;
        }
        for (int i = 1; i < words.length; i++) {
            int _width = width + words[i].length() + 1;
            if (_width < maxWidth) {
                width = _width;
            } else if (_width == maxWidth) {
                for (int j = start + 1; j <= i; j++) {
                    builder.append(" ");
                    builder.append(words[j]);
                }
                res.add(builder.toString());
                builder.delete(0, builder.capacity());
                i++;
                if (i < words.length) {
                    start = i;
                    builder.append(words[i]);
                    width = words[i].length();
                }
            } else {
                int numOfSpace = i - start - 1;
                if (numOfSpace == 0) {
                    for (int j = 0; j < maxWidth - width; j++) {
                        builder.append(" ");
                    }
                } else {
                    int lenOfWords = width - numOfSpace;
                    numOfSpace = maxWidth - lenOfWords;
                    int avgSpaces = numOfSpace / (i - start - 1);
                    int rest = numOfSpace % (i - start - 1);
                    for (int j = start + 1; j < rest + start + 1; j++) {
                        for (int k = 0; k <= avgSpaces; k++) {
                            builder.append(" ");
                        }
                        builder.append(words[j]);
                    }
                    for (int j = rest + start + 1; j < i; j++) {
                        for (int k = 0; k < avgSpaces; k++) {
                            builder.append(" ");
                        }
                        builder.append(words[j]);
                    }
                }
                res.add(builder.toString());
                builder.delete(0, builder.capacity());
                start = i;
                builder.append(words[i]);
                width = words[i].length();
            }
            if (i == words.length - 1) {
                for (int j = start + 1; j <= i; j++) {
                    builder.append(" ");
                    builder.append(words[j]);
                }
                for (int j = 0; j < maxWidth - width; j++) {
                    builder.append(" ");
                }
                res.add(builder.toString());
            }
        }
        return res;
    }
}
