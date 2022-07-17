package observable.dispose;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Dispose {
    public static void main(String[] args) {
        Observable source = Observable.interval(1000, TimeUnit.MILLISECONDS);

        Disposable disposable = source.subscribe(System.out::println);
        new Thread(() -> {
            try{
                Thread.sleep(3500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            disposable.dispose();
        }).start();
    }
}
