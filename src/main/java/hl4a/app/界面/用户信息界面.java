package hl4a.app.界面;

import android.os.Bundle;
import com.avos.avoscloud.后端错误;
import hl4a.app.布局.布局_用户信息;
import 间.安卓.内容.界面;
import 间.安卓.后端.用户;
import 间.安卓.工具.图片;
import 间.安卓.工具.提示;
import 间.接口.调用;
import 间.接口.返回值;
import 间.接口.方法;
import 间.安卓.工具.设备;
import 间.安卓.工具.线程;

public class 用户信息界面 extends 界面 {

    private 布局_用户信息 布局;
    private 用户 当前;
    private boolean 是用户 = true;
    
    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        置滑动返回(true);
        布局 = 打开布局(new 布局_用户信息(this));
        取标题栏().返回按钮(此);
        if (传入参数.length == 1) {
            当前 = (用户)传入参数[0];
            是用户 = false;
            if (当前 == null) {
                结束界面();
                return;
            }
        } else if (!用户.已登录()) {
            提示.警告("你还没有登录 ~");
            结束界面();
            return;
        } else {
            当前 = 用户.取当前用户();
        }
        布局.用户名.置长按事件(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    设备.置剪切板(布局.用户名.取文本());
                    提示.普通("已复制 ~");
                    return null;
                }
            });
        
        if (!是用户) {
            布局.用户账号.隐藏();
        }
        更新用户();
        布局.用户账号.文本设置("修改签名", false, "修改签名", 用户.取当前用户().取签名(), new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    提示.普通("正在修改 ~");
                    new 线程(this,"修改签名").启动($参数);
                    return null;
                }
                
                public void 修改签名(String $签名) {
                    用户.取当前用户().置签名($签名);
                    用户.取当前用户().保存(调用.代理(this,"修改回调"));
                }
                
                public void 修改回调(返回值<Void> $返回) {
                    if ($返回.成功()) {
                        提示.普通("修改成功 ~");
                        更新用户();
                    } else {
                        提示.警告($返回.取错误信息());
                    }
                }
            });
        
        布局.用户账号.普通设置("更换头像", null, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    图片.选择(此, 调用.代理(this, "选图回调"));
                    return null;
                }
                
                public void 选图回调(返回值<String> $图片) {
                    if ($图片.成功()) {
                        当前.置头像($图片.取内容());
                        当前.保存(调用.代理(this, "更换回调"));
                        提示.普通("正在上传头像 ~");
                    }
                }

                public void 更换回调(返回值<Void> $更换) {
                    if ($更换.成功()) {
                        提示.普通("头像更换成功 ~");
                        当前.显示头像(布局.头像, "#assets/user.png");
                    } else {
                        后端错误 $错误 = $更换.取错误();
                        提示.普通($错误.取错误码() + " : " + $错误.取错误信息());
                    }
                }
            });
        
        布局.用户账号.普通设置("登出账号", null, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    用户.取当前用户().登出();
                    提示.普通("登出成功 ~");
                    结束界面();
                    return null;
                }
            });
    }
    
    public void 更新用户() {
        布局.用户名.置文本(当前.取用户名());
        String $签名;
        布局.签名.置文本(($签名 = 当前.取签名()) == null ? "这个人还没有签名。" : $签名);
        当前.显示头像(布局.头像, "#assets/user.png");
    }

    

}
