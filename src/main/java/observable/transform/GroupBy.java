package observable.transform;

import io.reactivex.rxjava3.core.Observable;

public class GroupBy {
    public static void main(String[] args) {
        Observable.just(
                "Magenta Circle",
                "Cyan Circle",
                "Yellow Triangle",
                "Yellow Circle",
                "Magenta Triangle",
                "Cyan Triangle")
                .groupBy(item -> {
                    if(item.contains("Circle")){
                        return "C";
                    }else if(item.contains("Triangle")){
                        return "T";
                    }else{
                        return "None";
                    }
                })
                .subscribe(group -> {
                    System.out.println(group.getKey() + "그룹 발행 시작");
                    group.subscribe(shape -> {
                        System.out.println(group.getKey() + " : " + shape);
                    });
                });
    }
}
