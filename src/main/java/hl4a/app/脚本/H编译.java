package hl4a.app.脚本;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.mozilla.javascript.serialize.ScriptableOutputStream;
import 间.安卓.脚本.JavaScript;
import 间.工具.流;
import org.mozilla.javascript.serialize.ScriptableInputStream;

public class H编译 {
    
    public static byte[] 序列化(JavaScript $环境,Object $对象) {
        try {
            ByteArrayOutputStream $输出 = 流.输出.字节();
            ObjectOutputStream $流 = new ScriptableOutputStream($输出,$环境.函数环境);
            $流.writeObject($对象);
            return $输出.toByteArray();
        } catch (Exception $错误) {}
        return null;
    }
    
    public static <类型> 类型 反序列化(JavaScript $环境,byte[] $字节) {
        try {
            ByteArrayInputStream $输入 = 流.输入.字节($字节);
            ObjectInputStream $流 = new ScriptableInputStream($输入,$环境.函数环境);
            return (类型)$流.readObject();
        } catch (Exception $错误) {}
        return null;
    }
}
