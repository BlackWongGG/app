package hl4a.app.脚本;

import android.view.View;
import java.io.Serializable;
import org.mozilla.javascript.Function;
import 间.安卓.脚本.JavaScript;
import 间.工具.字节;
import 间.工具.错误;
import 间.接口.函数;
import 间.收集.I哈希表;
import 间.收集.I对象哈希表;
import 间.收集.哈希表;
import 间.收集.对象哈希表;
import android.app.Activity;
import 间.安卓.工具.布局;
import 间.安卓.资源.布局.布局_基本界面;
import 间.安卓.组件.基本界面;

public class H文档 implements Serializable {

    private String 文档名 = "未知文档";
    private boolean 滑动返回 = true;
    private I哈希表<String,String> 事件表 = new 哈希表<>();
    private I对象哈希表 视图表 = new 对象哈希表();

    public H文档() {
    }

    public String 取文档名() {
        return 文档名;
    }

    public void 置文档名(String $名称) {
        文档名 = $名称;
    }

    public boolean 取滑动返回() {
        return 滑动返回;
    }

    public void 置滑动返回(boolean $状态) {
        滑动返回 = $状态;
    }

    public I哈希表<String,String> 取事件表() {
        return 事件表;
    }

    public I对象哈希表 取视图表() {
        return 视图表;
    }

    public void 保存到(String $地址) {
        字节.保存($地址, 字节.序列化(this));
    }

    public static H文档 读取从(String $地址) {
        try {
            return 字节.反序列化(字节.读取($地址));
        } catch (Exception $错误) {}
        return null;
    }

    public 副本 预编译(JavaScript $环境) throws Exception {

        副本 $文档 = new 副本();

        $文档.预编译(this, $环境);

        return $文档;

    }

    public static class 副本 implements Serializable {

        private I哈希表<String,Function> 事件表 = new 哈希表<>();
        private I对象哈希表 视图表;
        
        public 副本() {
        }

        public void 预编译(H文档 $文档, JavaScript $环境) throws 错误 {
            视图表 = $文档.取视图表();
            I哈希表<String,String> $事件 = $文档.取事件表();
            for (I哈希表.Entry<String,String> $单个 : $事件.entrySet()) {
                String $事件名 = $单个.getKey();
                Function $函数 = $环境.编译函数($单个.getValue(), $文档.取文档名());
                事件表.设置($事件名, $函数);
            }

        }
        
        public I哈希表<String,Function> 取事件表() {
            return 事件表;
        }

        public I对象哈希表 取视图表() {
            return 视图表;
        }
        
        public void 保存到(JavaScript $环境,String $地址) {
            字节.保存($地址,H编译.序列化($环境, this));
        }

        public static 副本 读取从(JavaScript $环境,String $地址) {
            try {
                return H编译.反序列化($环境,字节.读取($地址));
            } catch (Exception $错误) {}
            return null;
        }
        
        public 实例 实例化(JavaScript $环境,基本界面 $界面) throws Exception {
            
            return new 实例($环境,this,$界面);
            
        }
        
    }
    
    public static class 实例 {
        
        private I哈希表<String,H函数> 事件表 = new 哈希表<>();
        private View 视图;
        
        public 实例(JavaScript $函数,副本 $副本,基本界面 $界面) throws Exception {
           
            $副本.取事件表();
            
        }
        
        
    }
    
}
