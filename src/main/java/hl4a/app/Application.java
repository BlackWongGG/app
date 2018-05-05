package hl4a.app;

import 间.安卓.组件.基本应用;
import 间.安卓.工具.主题;
import 间.安卓.工具.颜色;
import hl4a.app.界面.主页;
import hl4a.ex.HEx;
import android.content.Context;

public class Application extends 基本应用 {
    
    @Override
    public Class<?> 取主页() {
        return 主页.class;
    }
    
    @Override
    public void 应用创建事件() {
        主题.置颜色(颜色.靛蓝);
    }

}
