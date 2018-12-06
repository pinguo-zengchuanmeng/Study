# Java学习与分享
## 静态代理和动态代理的区别，以及什么场景下使用
### 1.什么是代理
代替原对象，进行相关操作控制访问等行为，间接的实现委托方需求。 

    举个🌰：
        我们总监这里可以进行相册主播次数的购买，并且可以给用户充值，后来总监这边销售分身乏术，所以我们找了若干代理商，
    
    这天，我们有个新的代理商叫马仔,马仔对客户进行销售，进过一番详细的介绍后，客户说我需要这样的产品，然后立马就下单了。
    
    这时马仔找到总监，总监在后台一阵风骚操作，成功充值了，再告诉手下马仔，马仔得到总监答复后，内心毫无波澜的告诉客户，
    
    您的直播次数已经帮你充好了。
    
        上面栗子中，总监就是原对象，马仔就是代理商（之一），客户就是委托方，代理商替代了原对象对客户进行产品的销售，
        
    这就是代理。
 
 再举个生活中的栗子

    我们购买火车票可以去火车站买，但是也可以去火车票代售处买，此处的火车票代售处就是火车站购票的代理，
    
    即我们在代售点发出买票请求，代售点会把请求发给火车站，火车站把购买成功响应发给代售点，代售点再告诉你。
    
    但是代售点只能买票，不能退票，而火车站能买票也能退票，因此代理对象支持的操作可能和委托对象的操作有所不同。
    
Java 实现代码
```java
public class ProxyDemo {
    public static void main(String args[]){
        RealSubject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
    }
}

interface Subject{
    void request();
}

class RealSubject implements Subject{
    public void request(){
        System.out.println("request");
    }
}

class Proxy implements Subject{
    private Subject subject;
    public Proxy(Subject subject){
        this.subject = subject;
    }
    public void request(){
        System.out.println("PreProcess");
        subject.request();
        System.out.println("PostProcess");
    }
}
```
    
代理的实现分为：静态代理，动态代理

### 2.什么是静态代理
-静态代理：代理类是在编译时就实现好的。也就是说 Java 编译完成后代理类是一个实际的 class 文件。

-动态代理：代理类是在运行时生成的。也就是说 Java 编译完之后并没有实际的 class 文件，

而是在运行时动态生成的类字节码，并加载到JVM中。