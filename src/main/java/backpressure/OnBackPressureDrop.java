package backpressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OnBackPressureDrop {
    public static void main(String[] args) throws Exception {
        Flowable.range(1, 300)
                .doOnNext(item -> System.out.println("아이템 발행: "+item))
                .onBackpressureDrop(item -> {
                    System.out.println("아이템 버림: " +item);
                })
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(10);
                    System.out.println("아이템 소비: " + item);
                }, throwable -> throwable.printStackTrace());

        Thread.sleep(30 * 1000);
    }
}
