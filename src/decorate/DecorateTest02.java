package decorate;

/**
 * @Auther: 王志恒
 * @Description:
 * 装饰模式
 * 本例子实现模拟咖啡
 * 装饰模式一般需要四种角色
 * 1、抽像组件：需要装饰的抽象对象。
 * 2、具体组件：需要装饰的对象。
 * 3、抽象装饰类：包含了对抽象组件的引用以及对装饰者共有的方法
 * 4、具体的装饰类：被装饰的对象
 *
 */
public class DecorateTest02 {
    public static void main(String[] args) {

        Coffee coffee = new Coffee();

        Drink Milk = new Milk(coffee);

        System.out.println(Milk.info() + ".价格是：>>" + Milk.cost());

        Drink sugar = new Sugar(Milk);

        System.out.println(sugar.info() + ".价格是：>>" + sugar.cost());

    }

    //抽象组件
    interface Drink {
        double cost(); //费用
        String info();//说明
    }

    //具体组件
    static class Coffee implements Drink {
        private String name = "原味咖啡";

        @Override
        public double cost() {
            return 10;
        }

        @Override
        public String info() {
            return name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //抽象装饰类
    abstract static class Decorate implements Drink {
        //对抽象组件的引用
        private Drink drink;

        public Decorate(Drink drink) {
            this.drink = drink;
        }

        @Override
        public double cost() {
            return this.drink.cost();
        }

        @Override
        public String info() {
            return this.drink.info();
        }
    }

    //具体装饰类  牛奶
    static class Milk extends Decorate {

        private String cailiao = "牛奶";
        public Milk(Drink drink) {
            super(drink);
        }

        @Override
        public double cost() {
            return super.cost()*2;
        }

        @Override
        public String info() {
            return super.info()+"加入了"+cailiao;

        }
    }

    static class Sugar extends Decorate {

        private String cailiao = "蔗糖";
        public Sugar(Drink drink) {
            super(drink);
        }

        @Override
        public double cost() {
            return super.cost()*2;
        }

        @Override
        public String info() {
            return super.info()+"加入了"+cailiao;


        }
    }

}

