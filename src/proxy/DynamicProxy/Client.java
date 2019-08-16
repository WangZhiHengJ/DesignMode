package proxy.DynamicProxy;


import java.lang.reflect.Proxy;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/16 22:51
 * @Description:
 * 动态代理的优点在于：具体代理哪个方法是不用确定的，甚至具体的公共接口在编译期都不用指定。程序之间耦合性特别低
 * 1、封装完毕后和静态代理的使用方式是一样的，但是更加灵活多变。可以同时传递多个参数进行代理
 * 2、在编译期具体的代理方法是不确定的，处理器编写完毕后，不管增加多少方法。都不用修改代理类。
 * 3、静态代理在编译期已经确定了具体代理的是哪个方法，并且每次增加代理方法时都要手动添加修改现有代码。
 * 4、甚至在Handler中可以直接使用Object作为公共接口的接收，代理不同对象的方法。配合拦截器或者触发器之类，动态运行应用程序。例如：事务和日志
 *
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        //返回一个对象
        Star proxy = (Star) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);

        proxy.delete();
    }

    public static Object packingMethod() {

        return null;
    }
}