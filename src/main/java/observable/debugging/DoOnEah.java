package observable.debugging;

import io.reactivex.rxjava3.core.Observable;

public class DoOnEah {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .doOnEach(notification -> {
                    Integer i = notification.getValue();
                    boolean isOnNext = notification.isOnNext();
                    boolean isOnComplete = notification.isOnComplete();
                    boolean isOnError = notification.isOnError();
                    Throwable throwable = notification.getError();

                    System.out.println("i = " + i);
                    System.out.println("isOnNext = " + isOnNext);
                    System.out.println("isOnComplete = " + isOnComplete);
                    System.out.println("isOnError = " + isOnError);
                    if (throwable != null) {
                        throwable.printStackTrace();
                    }
                }).subscribe(value -> {
            System.out.println("Subscribed = " + value);
        });
    }
}
