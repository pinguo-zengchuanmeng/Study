import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class DynamicProxy(private val obj: Object) : InvocationHandler {

    @Override
    @Throws(Throwable::class)
    operator fun invoke(proxy: Object, method: Method, args: Array<Object>): Object {
        System.out.println("before")
        val result = method.invoke(obj, args)
        System.out.println("after")
        return result
    }

    // @Override
    // public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // System.out.println("before");
    // Object result = method.invoke(obj, args);
    // System.out.println("after");
    // return result;
    // }
}