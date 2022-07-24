package subject;

import io.reactivex.rxjava3.subjects.AsyncSubject;

public class Asyncsubject {
    public static void main(String[] args) {
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.subscribe(item -> System.out.println("A: "+item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: "+item));
        subject.onNext(3);
        subject.onComplete();
        subject.subscribe(item -> System.out.println("C: "+item));
    }
}
