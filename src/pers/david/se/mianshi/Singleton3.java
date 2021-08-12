package pers.david.se.mianshi;

/**
 * @author Bu Dawei
 * @Description 使用静态代码块进行初始化的饿汉模式
 * @date 2020年3月12日
 */
public class Singleton3 {
    private static final Singleton3 INSTANCE;

    static {
        //在静态代码块里面可以做其他初始化操作，比如读取配置文件信息
        INSTANCE = new Singleton3();
    }

    private Singleton3() {
    }

}
