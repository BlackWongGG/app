package hl4a.app.界面;

import 间.安卓.组件.界面;
import android.os.Bundle;
import hl4a.app.布局.布局_用户信息;
import 间.安卓.后端.用户;
import 间.安卓.工具.提示;
import android.graphics.Bitmap;
import 间.接口.调用;
import 间.安卓.工具.图片;
import 间.接口.返回值;
import com.avos.avoscloud.后端错误;

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
        布局.标题.返回按钮(此);

        布局.用户名.置文本(用户.取当前用户().取用户名());
        用户.取当前用户().显示头像(布局.头像,"#assets/user.png");
        布局.头像.置单击事件(调用.配置(this, "更换头像"));
    }

    public void 更换头像() {
        图片.选择(此, 调用.代理(this, "选图回调"));
    }

    public void 选图回调(返回值<String> $图片) {
        if ($图片.成功()) {
            用户.取当前用户().置头像($图片.取内容());
            用户.取当前用户().保存(调用.代理(this, "更换回调"));
        }
    }

    public void 更换回调(返回值<Void> $更换) {
        if ($更换.成功()) {
            提示.普通("头像更换成功 ~");
            用户.取当前用户().显示头像(布局.头像,"#assets/user.png");
        } else {
            后端错误 $错误 = $更换.取错误();
            提示.普通($错误.取错误码()+" : "+$错误.取错误信息());
        }
    }

}
