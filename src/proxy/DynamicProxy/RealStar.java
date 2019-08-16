package proxy.DynamicProxy;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/16 22:51
 * @Description:
 * 真实角色
 */
public class RealStar implements Star {


    @Override
    public void delete() {
        System.out.println("----数据已经删除成功----");
    }

    @Override
    public void save() {
            System.out.println("----数据已经保存成功----");
    }
}