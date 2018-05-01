package hl4a.app.布局;

import android.content.Context;
import 间.安卓.视图.按钮;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.编辑框;

public class 布局_注册界面 extends 线性布局 {
    
    public 编辑框 用户名;
    public 编辑框 密码;
    public 编辑框 邮箱;
    public 按钮 注册;
    public 按钮 登录;
    
    public 布局_注册界面(Context $上下文) {
        super($上下文);
        置填充("填充");
        用户名 = new 编辑框(this);
        用户名.置默认文本("用户名");
        密码 = new 编辑框(this);
        密码.置默认文本("密码");
        邮箱 = new 编辑框(this);
        邮箱.置输入类型("文本_邮箱");
        邮箱.置默认文本("邮箱");
        注册 = new 按钮(this);
        注册.置文本("注册");
        注册.置宽度("最大");
        登录 = new 按钮(this);
        登录.置文本("登录");
        登录.置宽度("最大");
    }
    
}
