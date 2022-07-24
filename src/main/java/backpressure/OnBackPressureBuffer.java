package backpressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class OnBackPressureBuffer {
    public static void main(String[] args) throws Exception{
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer()
                .observeOn(Schedulers.io())
                .map(item -> {
                    Thread.sleep(2000);
                    System.out.println("아이템 발행: "+item);
                    return item;
                })
                .subscribe(item -> {
                    System.out.println("아이템 소비: "+ item);
                }, throwable -> throwable.printStackTrace());

        Thread.sleep(30*1000);
    }
}
