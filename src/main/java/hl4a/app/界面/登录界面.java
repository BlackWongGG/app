package hl4a.app.界面;

import android.content.Intent;
import android.os.Bundle;
import hl4a.app.布局.布局_登录界面;
import hl4a.app.数据.用户;
import 间.安卓.内容.界面;
import 间.安卓.工具.提示;
import 间.安卓.工具.调用;
import 间.安卓.弹窗.进度弹窗;
import 间.安卓.注解.滑动返回;
import 间.工具.字符;
import 间.接口.返回值;
import 间.注解.函数;

@滑动返回
public class 登录界面 extends 界面 {

    private 布局_登录界面 布局;
    private 进度弹窗 进度;
    private int 请求码_注册 = 1000;
    
    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        
        置标题("用户登录");
        
        布局 = 打开布局(new 布局_登录界面(取界面()));
        布局.注册.置单击事件(配置("注册"));
        布局.登录.置单击事件(配置("登录"));
        进度 = new 进度弹窗(取界面());
        置返回值(返回码_失败);
        取标题栏().返回按钮(取界面());
        
        if (用户.取当前用户() != null) {
            提示.普通("用户已登录 ~");
            结束界面();
        }
    }
  
    void 注册() {
        
        跳转界面(注册界面.class);
        
    }
   
    void 登录() {
        
        String $用户名 = 布局.用户名.取文本();
        String $密码 = 布局.密码.取文本();
        if (字符.是空白($用户名)) {
            布局.用户名.setError("不能为空");
            return;
        } else if (字符.是空白($密码)) {
            布局.密码.setError("不能为空");
            return;
        }
        进度.更新("正在登录");
        进度.显示();
        调用.异步(this,"异步登录",$用户名,$密码);
    }
    
    void 异步登录(String $用户名,String $密码) {
        
        返回值<用户> $用户 = 用户.同步登录($用户名,$密码);
        进度.隐藏();
        if (!$用户.成功()) {
            提示.警告($用户.取错误信息());
            return;
        }
        置返回值(返回码_成功);
        结束界面();
        
    }

    @Override
    public void 界面回调事件(int $请求码, int $返回码, Intent $意图) {
        super.界面回调事件($请求码, $返回码, $意图);
        if ($请求码 == 请求码_注册 && $返回码 == 返回码_成功) {
            结束界面();
        }
    }

    
}
