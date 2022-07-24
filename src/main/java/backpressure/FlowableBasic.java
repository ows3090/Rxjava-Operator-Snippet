package backpressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowableBasic {
    public static void main(String[] args) throws Exception {
        Flowable.range(1, Integer.MAX_VALUE)
                .map(item -> {
                    System.out.println("아이템 발행 : "+item);
                    return item;
                })
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(100);
                    System.out.println("아이템 소비 : "+item);
                });
        Thread.sleep(30*1000);
    }
}
