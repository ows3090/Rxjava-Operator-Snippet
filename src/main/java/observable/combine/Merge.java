package observable.combine;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Merge {
    public static void main(String[] args) throws Exception{
        Observable src1 = Observable.intervalRange(
                1, 5, 0, 100, TimeUnit.MILLISECONDS
        ).map(value -> value*20);

        Observable src2 = Observable.create(emitter -> {
            new Thread(() -> {
                try{
                    Thread.sleep(350);
                    emitter.onNext(1);
                    Thread.sleep(200);
                    emitter.onNext(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        });

        Observable.merge(src1, src2)
                .subscribe(System.out::println);

        Thread.sleep(1000);
    }
}
