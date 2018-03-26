package hl4a.root.界面;

import android.os.Bundle;
import 间.安卓.工具.提示;
import 间.安卓.组件.界面;
import 间.工具.时间;
import hl4a.root.布局.布局_主页;

public class 主页 extends 界面 {

    private 布局_主页 布局;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        打开布局(new 布局_主页(此));

        布局 = 取视图();
    }

    private long 返回时间 = 时间.时间戳() - 23333;
    
    @Override
    public boolean 返回按下事件() {
        long 上次 = 返回时间;
        if ((返回时间 = 时间.时间戳()) - 上次 < 2333) {
            结束界面();
            return true;
        } else {
            提示.普通("再按一次返回键退出 ~");
            return false;
        }
    }

}
