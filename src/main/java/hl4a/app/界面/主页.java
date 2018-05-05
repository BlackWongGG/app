package hl4a.app.界面;

import android.os.Bundle;
import hl4a.app.布局.布局_主页;
import 间.安卓.内容.界面;
import 间.安卓.工具.提示;
import 间.工具.时间;
import 间.接口.回调方法;
import 间.接口.返回值;
import 间.安卓.工具.网络;

public class 主页 extends 界面 {

    private 布局_主页 布局;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);

        布局 = 打开布局(new 布局_主页(this));

        置标题("HL4A");
        置副标题("好消息 不行接受不了！");

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
