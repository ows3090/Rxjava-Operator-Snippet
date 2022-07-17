package complete;

import io.reactivex.rxjava3.core.Completable;

public class Create {
    public static void main(String[] args) {
        Completable.create(emitter -> {
            emitter.onComplete();
        }).subscribe(() -> System.out.println("completed1"));

        Completable.fromRunnable(() -> {

        }).subscribe(() -> System.out.println("completed2"));
    }
}
