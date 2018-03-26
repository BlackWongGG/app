package hl4a.app.界面;

import 间.安卓.组件.界面;
import android.os.Bundle;
import hl4a.app.布局.布局_用户信息;
import 间.安卓.后端.用户;
import 间.安卓.工具.提示;

public class 用户信息界面 extends 界面 {

    public 布局_用户信息 布局;
    
    @Override
    public void 界面创建事件(Bundle $恢复) {
        置滑动返回(true);
        if (!用户.已登录()) {
            提示.警告("你还没有登录 ~");
            结束界面();
        }
        打开布局(new 布局_用户信息(此));
        布局 = 取视图();
    }
    
}
