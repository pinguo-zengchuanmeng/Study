import java.lang.reflect.Proxy

object Main {
    fun main(args: Array<String>) {
        System.out.println("开始打印")

        // Sell vendor = new Vendor();
        // BusinessAgent businessAgent = new BusinessAgent(vendor);
        // businessAgent.sell();
        // businessAgent.ad();


        try {
            //创建中介类实例
            val inter = DynamicProxy(Vendor())
            //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true")

            //获取代理类实例sell
            val sell = Proxy.newProxyInstance(Sell::class.java!!.getClassLoader(), arrayOf<Class>(Sell::class.java), inter) as Sell

            //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
            sell.sell()
            sell.ad()

        } catch (e: Exception) {
            //TODO: handle exception
        }


    }
}