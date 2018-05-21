package hl4a.app.脚本;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import hl4a.runtime.StubActivity;
import java.io.Serializable;
import 间.安卓.内容.界面;
import 间.安卓.工具.处理;
import 间.安卓.工具.文件;
import 间.安卓.脚本.JavaScript;
import 间.工具.字符;
import 间.工具.错误;
import 间.接口.函数;
import 间.接口.简单方法;
import 间.收集.I哈希表;
import 间.收集.哈希表;

public class H界面 extends 界面 {

    private Bundle 恢复;
    public String 当前目录;
    public String 当前脚本;
    public JavaScript 当前环境;
    private I哈希表<String,函数> 事件表 = new 哈希表<>();
    private H文档 文档;
    private H文档.实例 运行;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        恢复 = $恢复;
        Intent $意图 = 取界面().getIntent();
        String $脚本 = $意图.getStringExtra("脚本");
        if ($脚本 == null) {
            结束界面();
            return;
        }
        if ($恢复 != null) {
            当前目录 = $恢复.getString("目录");
        }
        if (!文件.是文件($脚本)) {
            错误.内容("找不到脚本 : $1", $脚本);
        }

        文档 = H文档.读取从($脚本);

        if (文档 == null) {
            错误.内容("读取脚本失败 ~");
        }

        当前目录 = 文件.取目录(当前脚本);
        当前脚本 = 文件.取名称(当前脚本);
        当前环境 = new JavaScript();
        当前环境.压入变量("当前脚本界面", this);
        当前环境.执行代码("this.__proto__ = 当前脚本界面;");
        当前环境.压入变量("当前界面", this.取界面());

        if (文档.取滑动返回()) {
            置滑动返回(true);
        }

        /*
        运行 = 文档.编译(当前环境, 取界面());
        事件表 = 运行.取事件表();
        打开布局(运行.取视图());
        调用事件("界面创建事件", 恢复);
        */
    }

    public void 界面启动事件() {
        调用事件("界面启动事件");
    }

    public void 界面刷新事件() {
        调用事件("界面刷新事件");
    }

    public void 界面遮挡事件() {
        调用事件("界面遮挡事件");
    }

    public void 界面回调事件(int $请求码, int $返回码, Intent $意图) {
        调用事件("界面回调事件", $请求码, $返回码, $意图);
    }

    public void 离开界面事件() {
        调用事件("离开界面事件");
    }

    public void 界面销毁事件() {
        调用事件("界面销毁事件");
    }

    public void 取得焦点事件() {
        调用事件("取得焦点事件");
    }

    public void 失去焦点事件() {
        调用事件("失去焦点事件");
    }

    public boolean 按键按下事件(int $按键码, KeyEvent $事件) {
        return new Boolean(true).equals(调用事件("按键按下事件", $按键码, $事件));
    }

    public boolean 返回按下事件() {
        return new Boolean(true).equals(调用事件("返回按下事件"));
    }

    public void 收到意图事件(Intent $意图) {
        调用事件("受到意图事件");
    }

    public void 权限回调事件() {
        调用事件("权限回调事件");
    }

    public void 注册事件(String $方法, 函数 $事件) {
        事件表.设置($方法, $事件);
    }

    public Object 调用事件(String $名称, Object... $参数) {
        函数 $方法 = 事件表.读取($名称);
        if ($方法 == null) return null;
        return 处理.同步($方法, $参数);
    }

    @Override
    public void 保存状态事件(Bundle $输出) {
        super.保存状态事件($输出);
        $输出.putString("目录", 当前目录);
        调用事件("保存状态事件", $输出);
    }

    public void 跳转脚本(String $地址, Object... $参数) {
        跳转脚本(null, $地址, $参数);
    }

    public void 跳转脚本(Integer $请求码, String $地址, Object... $参数) {
        if ($地址.startsWith("./")) {
            $地址 = 字符.替换($地址, "./", 当前目录 + "/");
        }
        跳转脚本(取界面(), $请求码, $地址, $参数);
    }

    public static void 跳转脚本(Activity $界面, Integer $请求码, String $地址, Object... $参数) {

        Intent $意图 = new Intent($界面, StubActivity.class);
        $意图.putExtra("类", H界面.class);
        $意图.putExtra("脚本", $地址);
        if ($参数 != null) 
            $意图.putExtra("参数", (Serializable)$参数);
        if ($请求码 == null)
            $界面.startActivity($意图);
        else
            $界面.startActivityForResult($意图, $请求码);


    }


}
