package observable.debugging;

import io.reactivex.rxjava3.core.Observable;

public class DoOnSubscribe {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .doOnSubscribe(disposable -> {
                    System.out.println("구독 시작");
                    disposable.dispose();
                })
                .subscribe(System.out::println);
    }
}
