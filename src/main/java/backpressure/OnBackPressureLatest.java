package backpressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class OnBackPressureLatest {
    public static void main(String[] args) throws Exception{
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                .onBackpressureLatest()
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(100);
                    System.out.println("아이템 소비: "+item);
                }, throwable -> throwable.printStackTrace());

        Thread.sleep(30*1000);
    }
}
