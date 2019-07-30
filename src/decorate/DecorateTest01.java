package decorate;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/21 17:50
 * @Description:
 * 装饰模式
 * 例子实现放大器对人的声音的放大功能
 * 核心思想：
 * 1、放大器和人都有发声的功能.
 * 2、放大器的声音放大功能建立在有人的声音的基础上.
 * 装饰模式核心思想就是：
 * 将原始类需要增强的功能抽象出来,增加一个接口方法。
 * 然后创建一个新的类作为装饰类，实现同一个接口方法，
 * 同时在这个装饰类里面创建一个属性，就是需要被增强的类（原始类）
 * 这样就可以在不修改原始代码的情况下，直接操作装饰类就可以达到想要的功能。
 *
 * 装饰模式特点：
 * 装饰模式的特点就是,在不改变原始类的代码的情况下,
 * 改变或者增强某些源是类的方法。
 *
 */
public class DecorateTest01 {
    public static void main(String[] args) {
        Person p = new Person();
        p.say();

        Amplifier am = new Amplifier(p);
        am.say();

    }

}

/**
 * @author: 王志恒
 * @date: 2019/7/21 21:38
 * @Description：
 * 接口
 */
interface Say {
    void  say();
}


/**
 * @author: 王志恒
 * @date: 2019/7/21 21:38
 * @Description：
 * 原始类
 */

class Person implements Say {
    private int voice = 10; //声音的分贝


    /**
     * @author: 王志恒
     * @date: 2019/7/21 17:58
     * @param
     * @return:
     * @Description：
     * 人具有说的功能
     */
    @Override
    public void say() {
        System.out.println("人的声音为：" + this.voice);
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

/**
 * @author: 王志恒
 * @date: 2019/7/21 21:42
 * @Description：
 * 装饰类
 */
class Amplifier implements Say {
    private Person person;

    Amplifier(Person p) {
        this.person = p;
    }
    @Override
    public void say() {
        System.out.println("增强后的声音:"+person.getVoice()*10);
    }
}
