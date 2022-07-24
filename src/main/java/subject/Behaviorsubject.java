package subject;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class Behaviorsubject {
    public static void main(String[] args) {
        BehaviorSubject<Integer> subject = BehaviorSubject.create();
        subject.subscribe(item -> System.out.println("A: "+item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: "+item));
        subject.onNext(3);
        subject.subscribe(item -> System.out.println("C: "+item));
    }
}
