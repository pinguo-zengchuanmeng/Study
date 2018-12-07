public interface InvocationHandler {
    Object invoke(Object proxy, Method methoid, Object[] args);
}