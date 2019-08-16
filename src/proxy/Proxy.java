package proxy;

import com.sun.org.apache.bcel.internal.generic.IUSHR;

import javax.sound.midi.Soundbank;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 21:44
 * @Description: 静态代理模式：
 * 三个角色
 * 1、抽象接口，公共的方法。
 * 2、目标对象，也是被代理对象
 * 3、代理对象
 * <p>
 * 代理模式的思想是：
 * 在代理和真实对象之间的的关系通常在编译时就已经确定了，
 * 而装饰者能够在运行时递归地被构造。
 * 代理模式关注于控制对对象的访问。
 * 装饰器模式关注于在一个对象上动态的添加方法，增强对象。
 * <p>
 * 这个示例演示保存和事务这两个事件
 */
public class Proxy {
    public static void main(String[] args) {

        Puser puser = new Puser();

        puser.save();

    }

    //抽象接口
    static interface Iuser {
        void save();
    }

    //目标对象
    static class User implements Iuser {
        @Override
        public void save() {
            System.out.println("----数据已经保存成功----");
        }
    }

    //代理对象
    static class Puser implements Iuser {
        private Iuser iuser;

        //      在代理和真实对象之间的的关系通常在编译时就已经确定了，
        public Puser() {
            iuser = new User();
        }

        @Override
        public void save() {
            System.out.println("----代理开始 ： 事务开始---- ");

            iuser.save();

            System.out.println("----事务执行完毕----");
        }


    }

}


