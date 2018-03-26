package hl4a.app.界面;

import android.graphics.Bitmap;
import android.os.Bundle;
import hl4a.app.布局.布局_主页;
import 间.安卓.后端.用户;
import 间.安卓.后端.界面.登录界面;
import 间.安卓.工具.提示;
import 间.安卓.组件.界面;
import 间.工具.时间;
import 间.接口.调用;
import 间.安卓.视图.扩展.设置视图;

public class 主页 extends 界面 {

    private 布局_主页 布局;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        打开布局(new 布局_主页(此));

        布局 = 取视图();

        布局.登录按钮.置单击事件(调用.配置(this, "登录"));

        检查用户();
        
        设置视图 $设置 = new 设置视图(此);
        $设置.置标题("设置");
        $设置.开关设置("测试设置","副标题",false,null);
        $设置.跳转设置("测试设置","副标题",null);
        $设置.打开(此);

    }

    private void 检查用户() {
        if (用户.取当前用户() == null) {
            布局.注册底层.显示();
            布局.用户底层.隐藏();
        } else {
            布局.用户底层.显示();
            布局.注册底层.隐藏();
            布局.用户名.置文本(用户.取当前用户().取用户名());
            Bitmap $头像 = 用户.取当前用户().取头像();
            布局.头像.置图片($头像 == null ? "#assets/user.png" : $头像);
            布局.用户底层.置单击事件(调用.配置(this,"信息"));
        }
    }

    public void 登录() {
        跳转界面(登录界面.class);
    }
    
    public void 信息() {
        跳转界面(用户信息界面.class);
    }

    @Override
    public void 界面刷新事件() {
        检查用户();
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
