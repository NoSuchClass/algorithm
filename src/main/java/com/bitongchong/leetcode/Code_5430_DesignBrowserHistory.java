package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2020/6/7 11:35
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 * [null,null,null,null,"facebook.com","google.com","youtube.com",null,"youtube.com","linkedin.com","youtube.com"]
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [null,null,null,null,"facebook.com","google.com","youtube.com",null,"facebook.com","youtube.com","leetcode.com"]
 */
public class Code_5430_DesignBrowserHistory {
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    String cur = null;

    public Code_5430_DesignBrowserHistory(String homepage) {
        cur = homepage;
    }

    public static void main(String[] args) {

        Code_5430_DesignBrowserHistory browserHistory = new Code_5430_DesignBrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }

    public void visit(String url) {
        forward.clear();
        back.push(cur);
        cur = url;
    }

    public String back(int steps) {
        forward.add(cur);
        if (back.size() < steps) {
            if (back.size() == 0) {
                return cur;
            }
            for (int i = 0; i < back.size() - 1; i++) {
                forward.add(back.pop());
            }
            cur = back.pop();
            return cur;
        } else {
            for (int i = 0; i < steps - 1; i++) {
                forward.add(back.pop());
            }
            cur = back.pop();
            return cur;
        }
    }

    public String forward(int steps) {
        back.add(cur);
        if (forward.size() < steps) {
            if (forward.size() == 0) {
                return cur;
            }
            for (int i = 0; i < forward.size() - 1; i++) {
                back.add(forward.pop());
            }
            cur = forward.remove(0);
            return cur;
        } else {
            for (int i = 0; i < steps - 1; i++) {
                back.add(forward.pop());
            }
            cur = forward.pop();
            return cur;
        }
    }
}
