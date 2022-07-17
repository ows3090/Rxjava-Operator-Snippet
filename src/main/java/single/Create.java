package single;

import io.reactivex.rxjava3.core.Single;

public class Create {
    public static void main(String[] args) {
        Single.create(emitter -> {
            emitter.onSuccess("Hello");
        }).subscribe(System.out::println, throwable -> {
            System.out.println("Error!!");
        });
    }
}
