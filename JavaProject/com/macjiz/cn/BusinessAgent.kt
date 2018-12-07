class BusinessAgent(private val vendor: Sell) : Sell {

    fun sell() {
        // System.out.println("售卖前");
        vendor.sell()
        // System.out.println("售卖后");
    }

    fun ad() {
        // System.out.println("广告前");
        vendor.ad()
        // System.out.println("广告后");
    }

}