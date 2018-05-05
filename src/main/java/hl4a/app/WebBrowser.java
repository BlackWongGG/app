package hl4a.app;

import android.net.Uri;
import android.os.Bundle;
import 间.安卓.工具.提示;
import 间.安卓.注解.滑动返回;
import 间.安卓.组件.基本界面;
import 间.安卓.视图.浏览器;
import 间.网络.资源;
import 间.网络.连接;
import 间.接口.回调方法;
import 间.接口.返回值;
import 间.接口.单值回调;
import 间.安卓.工具.设备;
import 间.安卓.工具.处理;

@滑动返回
public class WebBrowser extends 基本界面 {

    private 浏览器 浏览器;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        Uri $链接 = getIntent().getData();
        if ($链接 == null) { 结束界面(); return; }
        取标题栏().返回按钮(this);
        置标题($链接.toString());
        浏览器 = 打开布局(new 浏览器(this));
        浏览器.置链接($链接.toString());
        浏览器.置标题更换事件(代理("置标题"));

        取菜单().添加("科学上网反代站", 配置("科学浏览"));
    }

    void 科学浏览() {

        浏览器.置链接("https://hath.tk/");
        
    }

}
