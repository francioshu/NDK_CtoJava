# NDK_CtoJava
C中定义映射的类、方法、对象

jclass TestProvider;
jobject mTestProvider;
jmethodID getTime;
jmethodID sayHello;

C 中映射 类
TestProvider = (*jniEnv)->FindClass(jniEnv,"com/duicky/TestProvider");

C中新建对象
jmethodID construction_id = (*jniEnv)->GetMethodID(jniEnv, TestProvider,"<init>", "()V");

TestProvider mTestProvider = (*jniEnv)->NewObject(jniEnv, TestProvider,construction_id);

C 中映射方法
 静态：

getTime = (*jniEnv)->GetStaticMethodID(jniEnv, TestProvider, "getTime","()Ljava/lang/String;");
非静态：

sayHello = (*jniEnv)->GetMethodID(jniEnv, TestProvider, "sayHello","(Ljava/lang/String;)V");

C 中调用 Java的 方法
静态：

(*jniEnv)->CallStaticObjectMethod(jniEnv, TestProvider, getTime);
非静态：

(*jniEnv)->CallVoidMethod(jniEnv, mTestProvider, sayHello,jstrMSG);

注意 GetXXXMethodID  和 CallXXXMethod 。

第一个XXX 表示的是映射方法的类型，如： 静态 跟非静态

第二个 XXX 表示 调用方法的返回值 ，如：Void,Object,等等。（调用静态方法的时候Call后面要加Static）

详细 映射方法 和 调用方法 请参考 JNI 文档 ，这个很重要 
