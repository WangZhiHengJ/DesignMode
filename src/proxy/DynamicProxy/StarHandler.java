package proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/16 22:45
 * @Description: 代理对象
 */
public class StarHandler implements InvocationHandler {
    //持有公共的接口接收真是角色的引用，做多态
    //Star realStar;//真实角色

    /**
     * 封装更完整的公共接口，不需要知道具体代理哪个接口。
     */
    Object realStar;

    public StarHandler(Object realStar) {
        this.realStar = realStar;
    }

    /**
     * @param proxy  代理类
     * @param method 被代理方法
     * @param args   方法参数数组
     * @author: 王志恒
     * @date: 2019/8/16 22:48
     * @return:
     * @Description： 动态代理主要的处理流程
     * 在这个方法里做统一的流程处理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----代理开始 ： 事务开始---- ");
        //激活 realStar 的某个方法
        method.invoke(realStar, args);
        System.out.println("----事务执行完毕----");
        return null;
    }
}