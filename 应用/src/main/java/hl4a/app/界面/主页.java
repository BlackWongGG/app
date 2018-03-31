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
import 间.接口.返回值;
import 间.安卓.工具.网络;
import com.avos.avoscloud.后端错误;
import com.avos.avoscloud.AVUser;

public class 主页 extends 界面 {

    private 布局_主页 布局;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        打开布局(new 布局_主页(此));

        布局 = 取视图();

        布局.登录按钮.置单击事件(调用.配置(this, "登录"));

        检查用户();
        
        if (用户.已登录()) {
            提示.普通(用户.取当前用户().getSessionToken());
        }
        //用户.取当前用户().检查(调用.代理(this,"检查回调"));

    }

    private void 检查用户() {
        if (用户.取当前用户() == null) {
            布局.注册底层.显示();
            布局.用户底层.隐藏();
        } else {
            布局.用户底层.显示();
            布局.注册底层.隐藏();
            布局.用户名.置文本(用户.取当前用户().取用户名());
            布局.用户底层.置单击事件(调用.配置(this,"信息"));
            用户.取当前用户().显示头像(布局.头像,"#assets/user.png");
            }
    }
    
    public void 检查回调(返回值 $结果) {
        if (网络.网络可用() && !$结果.成功()) {
            用户.登出();
            布局.注册底层.显示();
            布局.用户底层.隐藏();
            提示.警告(((后端错误)$结果.取错误()).取错误信息());
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
