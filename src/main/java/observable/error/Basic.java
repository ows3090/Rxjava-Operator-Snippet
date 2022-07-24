package observable.error;

import io.reactivex.rxjava3.core.Observable;

public class Basic {
    public static void main(String[] args) {
        Observable.just("1", "2", "a", "3")
                .map(i -> Integer.parseInt(i))
                .subscribe(System.out::println,
                        throwable -> {
                            System.out.println("Error!!");
                        });
    }
}
