package observable.create;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Supplier;

public class Defer {
    public static void main(String[] args) {
        Observable<Long> justSrc = Observable.just(
                System.currentTimeMillis()
        );

        Observable<Long> deferSrc = Observable.defer(new Supplier<ObservableSource<? extends Long>>() {
            @Override
            public ObservableSource<? extends Long> get() throws Throwable {
                return Observable.just(System.currentTimeMillis());
            }
        });

        System.out.println("#1 now = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("#2 now = " + System.currentTimeMillis());

        justSrc.subscribe(time -> {
            System.out.println("#1 time = " + time);
        });

        deferSrc.subscribe(time -> {
            System.out.println("#2 time = " + time);
        });
    }
}
