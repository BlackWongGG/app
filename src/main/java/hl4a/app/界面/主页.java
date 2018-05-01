package hl4a.app.界面;

import android.os.Bundle;
import hl4a.app.布局.布局_主页;
import 间.安卓.内容.界面;
import 间.安卓.工具.提示;
import 间.工具.时间;
import hl4a.app.数据.用户;

public class 主页 extends 界面 {

    private 布局_主页 布局;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);

        布局 = 打开布局(new 布局_主页(this));

        置标题("HL4A");
        置副标题("好消息 不行接受不了！");

        布局.我的.提示.置单击事件(配置("登录"));

        重载();
    }
    
    void 登录() {
        跳转界面(登录界面.class);
    }
    

    void 重载() {
        布局.我的.重载(用户.取当前用户());
    }

    @Override
    public void 界面刷新事件() {
        super.界面刷新事件();
        重载();
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
