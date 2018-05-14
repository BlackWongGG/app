# 不混淆内容

-keep class 间.** {*;}
-keep class hl4a.** {*;}

-dontnote **
-dontwarn **

-keep class okhttp3.internal.publicsuffix.PublicSuffixDatabase

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}


-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
