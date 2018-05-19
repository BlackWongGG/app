package hl4a.app;

import android.content.Intent;
import android.os.Bundle;
import hl4a.app.布局.布局_文件选择;
import hl4a.app.适配器.文件适配器;
import 间.安卓.工具.应用;
import 间.安卓.工具.文件;
import 间.安卓.弹窗.列表弹窗;
import 间.安卓.组件.基本界面;
import 间.安卓.视图.弹出菜单;
import 间.工具.注解;
import 间.接口.方法;
import 间.收集.有序列表;
import 间.注解.FN;
import 间.安卓.工具.应用.信息;
import java.lang.annotation.Annotation;
import 间.安卓.工具.调用;

public class FileSelector extends 基本界面 {

    private 布局_文件选择 布局;
    private 文件适配器 适配器;
    private 弹出菜单 菜单;
    private 列表弹窗 弹窗;
    private 列表弹窗 应用;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        置滑动返回(true);
        布局 = 打开布局(new 布局_文件选择(this));
        取导航按钮().结束界面(this);
        置标题("选择文件");
        适配器 = new 文件适配器(this, 布局.列表) {
            @Override public void 重置(String $目录) {
                super.重置($目录);
                置副标题(文件.检查地址($目录));
            }
        };
        布局.列表.置适配器(适配器);
        弹窗 = new 列表弹窗(this);
        弹窗.置标题("常用目录");

        添加("图片保存", "%Pictures");
        添加("系统拍照", "%DCIM/Camera");
        添加("系统截图", "%DCIM/Screenshots");
        添加("系统录屏", "%DCIM/ScreenRecorder");
        添加("ADM下载器目录", "%ADM");
        添加("新版AIDE APK位置", "%Android/data/com.aide.ui/cache/apk/");
        添加("系统下载目录", "%Download");
        添加("QQ下载 QQfile_recv", "%tencent/QQfile_recv");
        添加("QQ收藏 QQ_Favorite", "%tencent/QQ_Favorite");
        添加("QQ图片 qq_images", "%tencent/qq_images");
        添加("网易云音乐", "%netease/cloudmusic/Music");
        添加("Telegram文件", "%Telegram");
        添加("贴吧图片", "%tieba");
        添加("酷安APK下载", "%Android/data/com.coolapk.market/files/Download");

        应用 = new 列表弹窗(this);
        应用.置标题("选择已安装的应用");
        应用.取编辑框().显示();

        菜单 = 取菜单();
        菜单.添加("快捷目录", 配置("目录"));
        菜单.添加("所有应用", 配置("应用"));

        适配器.重置("%");

        调用.异步(this, "初始化");
        
    }

    void 初始化() {
        有序列表<应用.信息> $所有 = 间.安卓.工具.应用.取所有应用();
        添加应用($所有);
    }

    private void 添加应用(有序列表<应用.信息> $所有) {
        for (final 应用.信息 $单个 : $所有) {
            应用.添加($单个.应用名 + "/" + $单个.包名, new 方法() {
                    @Override
                    public Object 调用(Object[] $参数) {
                        返回($单个.地址);
                        return null;
                    }
                });
        }
    }

    void 应用() { 应用.显示(); }

    void 目录() { 弹窗.显示(); }

    public void 添加(String $名称, final String $目录) {
        if (文件.是目录($目录)) {
            弹窗.添加($名称, new 方法() {
                    @Override
                    public Object 调用(Object[] $参数) {
                        适配器.重置($目录);
                        return null;
                    }
                });
        }
    }

    public void 返回(String $地址) {
        if ($地址 != null) {
            Intent $返回 = new Intent();
            $返回.setData(文件.取Uri($地址));
            置返回值(返回码_成功, $返回);
        } else {
            置返回值(返回码_失败);
        }
        结束界面();
    }

    @Override
    public boolean 返回按下事件() {
        if (适配器.可回退()) {
            适配器.回退();
            return true;
        } else {
            return false;
        }
    }

}
