package observable.combine;

import io.reactivex.rxjava3.core.Observable;

public class CombineLatest {
    public static void main(String[] args) throws Exception {
        Observable<Integer> src1 = Observable.create(emitter -> {
            new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    emitter.onNext(i);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        Observable<String> src2 = Observable.create(emitter -> {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    emitter.onNext("A");
                    Thread.sleep(700);
                    emitter.onNext("B");
                    Thread.sleep(100);
                    emitter.onNext("C");
                    Thread.sleep(700);
                    emitter.onNext("D");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        Observable.combineLatest(src1, src2, (num, str) -> num + str)
                .subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
