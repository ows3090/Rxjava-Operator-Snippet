package subject;

import io.reactivex.rxjava3.subjects.ReplaySubject;

public class Replaysubject {
    public static void main(String[] args) {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.subscribe(item-> System.out.println("A: "+item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: "+item));
        subject.onNext(3);
        subject.subscribe(item -> System.out.println("C: "+item));
    }
}
