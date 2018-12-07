interface InvocationHandler {
    operator fun invoke(proxy: Object, methoid: Method, args: Array<Object>): Object
}