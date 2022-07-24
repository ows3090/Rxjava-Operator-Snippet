package subject;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Publishsubject {
    public static void main(String[] args) {
        Subject<String> src = PublishSubject.create();
        src.subscribe(item -> System.out.println("A: " + item),
                t -> t.printStackTrace(),
                () -> System.out.println("A : onComplete"));
        src.subscribe(item -> System.out.println("B : " + item),
                t -> t.printStackTrace(),
                () -> System.out.println("B : onComplete"));

        src.onNext("Hello");
        src.onNext("World");
        src.onNext("!!!");
        src.onComplete();
    }
}
