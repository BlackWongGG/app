package hl4a.app.适配器;

import android.content.Context;
import 间.安卓.工具.文件;
import 间.安卓.工具.网络;
import 间.安卓.工具.链接;
import 间.安卓.视图.适配器.基本适配器;
import 间.安卓.资源.布局.布局_适配器_数组;
import 间.接口.简单方法;
import 间.收集.I哈希表;
import 间.收集.I对象哈希表;
import 间.收集.对象哈希表;
import 间.数据.YAML;
import 间.网络.资源;
import 间.网络.连接;

public class 手册适配器 extends 基本适配器<布局_适配器_数组> {

    public static final String 所有 = "https://hl4a.github.io/app/doc/所有.yml";
    public static final String 保存 = "$手册/所有.yml";
    
    public 手册适配器(Context $上下文) {
        super($上下文);
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
