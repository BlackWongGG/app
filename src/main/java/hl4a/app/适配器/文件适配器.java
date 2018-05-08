package hl4a.app.适配器;

import android.graphics.Bitmap;
import hl4a.app.FileSelector;
import hl4a.app.R;
import hl4a.app.工具.图标工厂;
import hl4a.app.布局.布局_适配器_文件;
import java.io.File;
import 间.安卓.工具.图片;
import 间.安卓.工具.提示;
import 间.安卓.工具.文件;
import 间.安卓.工具.调用;
import 间.安卓.视图.实现.基本列表;
import 间.安卓.视图.适配器.基本适配器;
import 间.工具.时间;
import 间.工具.线程池;
import 间.接口.方法;
import 间.收集.哈希表;
import 间.收集.对象哈希表;

public class 文件适配器 extends 基本适配器<布局_适配器_文件> {

    private 线程池 加载 = new 线程池(3);
    private 图标工厂 图标;
    private String 当前目录;
    private FileSelector 界面;

    private Bitmap 图标_文件夹;
    private Bitmap 图标_文件;
    private Bitmap 图标_文本;
    private Bitmap 图标_图片;
    private Bitmap 图标_视频;
    private Bitmap 图标_音频;
    private Bitmap 图标_网页;
    private Bitmap 图标_安装包;
    private Bitmap 图标_压缩包;

    private 哈希表<String,Bitmap> 对应表 = new 哈希表<>();

    public 文件适配器(FileSelector $上下文, 基本列表 $列表) {
        super($上下文);
        界面 = $上下文;

        $列表.置项目单击事件(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    布局_适配器_文件 $视图 = (布局_适配器_文件)$参数[1];
                    if ($视图.文件 == null && 可回退()) {
                        回退();
                    } else if ($视图.文件.isDirectory()) {
                        重置($视图.文件.getPath());
                    } else {
                        界面.返回($视图.文件.getPath());
                    }
                    return null;
                }
            });

        图标 = new 图标工厂();
        图标_文件夹 = 图标.制作(R.drawable.fic_folder);
        图标_文件 = 图标.制作(R.drawable.fic_file);
        图标_文本 = 图标.制作(R.drawable.fic_text);
        图标_图片 = 图标.制作(R.drawable.fic_image);
        图标_视频 = 图标.制作(R.drawable.fic_video);
        图标_音频 = 图标.制作(R.drawable.fic_audio);
        图标_网页 = 图标.制作(R.drawable.fic_html);
        图标_安装包 = 图标.制作(R.drawable.fic_apk);
        图标_压缩包 = 图标.制作(R.drawable.fic_archive);

        设置(图标_文本,
           "txt", "xml", "conf", "prop",
           "cpp", "h", "java", "log",
           "json", "js", "php", "css",
           "py", "c", "smali", "cfg",
           "ini", "bat", "mf", "mtd",
           "lua", "md", "kt", "iml",
           "pro", "gradle", "gitignore", "ass");

        设置(图标_视频,
           "3gp", "asf", "avi", "mp4",
           "mpe", "mpeg", "mpg", "mpg4",
           "m4u", "m4v", "mov", "rmvb");

        设置(图标_网页, "htm", "html");

        设置(图标_图片, "jpeg", "webp",
           "jpg", "bmp", "gif", "png");

        设置(图标_压缩包, "zip", "rar", "7z", "tar", "gz", "jar");

        设置(图标_安装包, "apk");

        设置(图标_音频, "m3u", "m4a",
           "m4b", "m4p", "mp2", "mp3",
           "mpga", "ogg", "wav", "wma",
           "wmv", "3gpp", "flac", "amr");



    }

    public void 回退() {
        String $上级 = 文件.取文件对象(当前目录).getParent();
        if (!文件.取可读($上级)) {
            提示.普通("上级目录不可读");
            重置("%");
            return;
        } else {
            重置($上级);
        }
    }

    public boolean 可回退() {
        String $上级 = 文件.取文件对象(当前目录).getParent();
        return 文件.取可读($上级);
    }

    private void 设置(Bitmap $图标, String... $类型) {
        for (String $单个 : $类型) {
            对应表.设置($单个, $图标);
        }
    }

    @Override
    public 布局_适配器_文件 创建() {
        return new 布局_适配器_文件(界面);
    }

    public void 重置(String $目录) {
        调用.异步(this, "同步重置", $目录);
    }

    public void 同步重置(String $目录) {
        if (!文件.取可读($目录)) {
            提示.普通("找不到文件夹/不可读");
            return;
        }
        当前目录 = $目录;
        重新加载();
    }

    private Bitmap 取图标(File $文件) {
        if ($文件.isDirectory()) return 图标_文件夹;
        Bitmap $图标 = 对应表.读取(文件.取后缀($文件.getPath()));
        if ($图标 != null) return $图标;
        return 图标_文件;
    }

    private void 重新加载() {
        File[] $所有 = 文件.取文件列表(当前目录);
        清空();
        if (文件.取可读(文件.取文件对象(当前目录).getParent())) {
            添加(new 对象哈希表());
        }
        for (File $单个 : $所有) {
            添加(new 对象哈希表().设置("文件", $单个));
        }
        发送更新事件();
    }

    @Override
    public 布局_适配器_文件 处理(final 布局_适配器_文件 $视图, 对象哈希表 $参数) {
        if ($参数.isEmpty()) {
            $视图.文件 = null;
            $视图.名称.置文本("..");
            $视图.图标.置图片(图标_文件夹);
        } else {
            final File $文件 = $参数.读取("文件");
            $视图.文件 = $文件;
            $视图.名称.置文本($文件.getName());
            Bitmap $图标 = 取图标($文件);
            $视图.图标.置图片($图标);
            if ($图标 == 图标_图片) {
                调用.线程池(加载, this, "加载图标", $视图, $文件.getPath());
            } else if ($图标 == 图标_视频) {
                调用.线程池(加载, this, "加载图标", $视图, $文件.getPath());
            } else if($图标 == 图标_安装包) {
                调用.线程池(加载, this, "加载安装包图标", $视图, $文件.getPath());
            }

            $视图.修改时间和大小.置文本(时间.格式($文件.lastModified(), "默认") + " " + 文件.格式大小(文件.取大小($文件.getPath())));
        }
        return $视图;
    }

    public void 加载图标(布局_适配器_文件 $视图, String $地址) {
        $视图.图标.置图片($地址,"40dp","40dp");
    }
    
    public void 加载安装包图标(布局_适配器_文件 $视图, String $地址) {
        $视图.图标.置图片(文件.取APK图标($地址),"40dp","40dp");
    }

}
