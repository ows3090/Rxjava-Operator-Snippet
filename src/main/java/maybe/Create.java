package maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class Create {
    public static void main(String[] args) {
        Maybe.create(emitter -> {
            emitter.onSuccess(100);
            emitter.onComplete();
        })
                .doOnSuccess(item -> System.out.println("doOnSuccess1"))
                .doOnComplete(() -> System.out.println("doOnComplete1"))
                .subscribe(System.out::println);

        Maybe.create(emitter -> {
            emitter.onComplete();
        })
                .doOnSuccess(item -> System.out.println("doOnSuccess2"))
                .doOnComplete(() -> System.out.println("doOnComplete2"))
                .subscribe(System.out::println);
    }
}
