package subject;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;


public class PublishHotObservable {
    public static void main(String[] args) {
        Subject<String> src = PublishSubject.create();
        src.onNext("Hello");
        src.onNext("World");
        src.onNext("!!!");
        src.onComplete();
        src.map(String::length)
                .subscribe(System.out::println);
    }
}
