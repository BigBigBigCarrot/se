package pers.david.designpattern.proxy;

/**
 * 
 * @Description
 * 	<p>代理模式示例。</p>
 * 	<p>不直接自己去干活，而是通过一个代理去干活。</p>
 * 	<p>即不直接访问对象，而是通果一个代理（中间层）去间接访问</p>
 * 	<p>适用场景：比如对象创建开销很大，或者某些操作需要安全控制，或者需要进程外的访问），
 * 		直接访问会给使用者或者系统结构带来很多麻烦，我们可以在访问此对象时加上一个对此对象的访问层。
 * 	</p>
 * @author Bu Dawei
 * @date 2020年1月25日
 * @version
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		// 图像将从磁盘加载
		image.display();
		// 图像不需要从磁盘加载
		image.display();
	}
}
