public class BusinessAgent implements Sell {
    private Sell vendor;

    public BusinessAgent(Sell vendor) {
        this.vendor = vendor;
    }

    public void sell() {
        // System.out.println("售卖前");
        vendor.sell();
        // System.out.println("售卖后");
    }

    public void ad() {
        // System.out.println("广告前");
        vendor.ad();
        // System.out.println("广告后");
    }

}