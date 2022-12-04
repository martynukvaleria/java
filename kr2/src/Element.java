public interface Element {
    default void accept(Visitor v){
        v.visit(this);
    }
}

