package hl4a.app.界面;

import android.os.Bundle;
import 间.安卓.内容.界面;
import 间.安卓.工具.处理;
import 间.安卓.工具.提示;
import 间.安卓.工具.文件;
import 间.安卓.工具.网络;
import 间.安卓.工具.链接;
import 间.安卓.视图.下拉刷新布局;
import 间.安卓.视图.列表视图;
import 间.安卓.视图.适配器.基本适配器;
import 间.安卓.资源.布局.布局_标题界面;
import 间.安卓.资源.布局.布局_适配器_数组;
import 间.接口.简单方法;
import 间.收集.I哈希表;
import 间.收集.I对象哈希表;
import 间.收集.对象哈希表;
import 间.数据.YAML;
import 间.网络.资源;
import 间.网络.连接;
import android.text.SpannableStringBuilder;

public class 手册界面 extends 界面 {

    private 布局_手册界面 布局;
    
    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        布局 = 打开布局(new 布局_手册界面());
        置标题("HL4A 手册");
        取导航按钮().结束界面(this);
        布局.刷新.刷新(233);
        new SpannableStringBuilder();
    }
    
    public class 布局_手册界面 extends 布局_标题界面 {
        
        public 下拉刷新布局 刷新;
        public 列表视图 列表;
        public 手册适配器 适配器;
        
        public 布局_手册界面() {
            super(取界面());
            刷新 = new 下拉刷新布局(this);
            列表 = new 列表视图(刷新);
            适配器 = new 手册适配器();
            列表.置适配器(适配器);
            刷新.置刷新事件(new 简单方法(处理.异步) {
                    @Override
                    public void 调用() {
                        适配器.同步加载();
                        刷新.置刷新状态(false);
                    }
                }.构建());
        }
        
    }
    
    public class 手册适配器 extends 基本适配器<布局_适配器_数组> {

        public static final String 所有 = "https://hl4a.github.io/app/doc/所有.yml";
        public static final String 保存 = "$手册/所有.yml";

        public 手册适配器() {
            super(取界面());
        }

        @Override
        public 布局_适配器_数组 创建() {
            return new 布局_适配器_数组(取上下文());
        }

        public void 同步加载() {

            boolean 未加载 = true;

            if (文件.是文件(保存)) {

                I对象哈希表 $表 = YAML.读取(保存);

                if ($表 != null) {

                    同步加载数据($表);
                    未加载 = false;

                }

            }

            if (!网络.网络可用()) {

                同步加载失败(未加载);
                return;

            }

            资源 $结果 = new 连接(所有).同步();

            if (!$结果.成功()) {

                同步加载失败(未加载);
                return;

            }

            I哈希表<String,String> $内容 = YAML.解析($结果.文本());

            if ($内容 == null) {

                同步加载失败(未加载);
                return;

            }

            YAML.保存(保存,$内容);

            同步加载数据($内容);

        }

        private void 同步加载失败(boolean $加载) {

            if (!$加载) return;

            清空();

            添加("加载失败 请检查网络 ~",null);

            提示.普通("加载失败 ~");
            
            发送更新事件();


        }

        private void 同步加载数据(I哈希表<String,String> $表) {

            清空();

            for (I哈希表.Entry<String,String> $单个 : $表.entrySet()) {

                添加($单个.getKey(),$单个.getValue());

            }

            发送更新事件();

        }

        public void 添加(String $名称, String $地址) {
            I对象哈希表 $参数 = new 对象哈希表();
            $参数.设置("名称", $名称);
            $参数.设置("地址", $地址);
            添加($参数);
        }

        @Override
        public 布局_适配器_数组 处理(布局_适配器_数组 $视图, final I对象哈希表 $参数) {
            $视图.文本.置文本((String)$参数.读取("名称"));
            if ($参数.检查("地址"))
                $视图.置单击事件(new 简单方法() {
                        @Override
                        public void 调用() {
                            链接.打开("https://hl4a.github.io/app/doc/" + (String)$参数.读取("地址") + ".html", (String)$参数.读取("名称"));
                        }
                    });
            return $视图;
        }

    }
    
    
}
