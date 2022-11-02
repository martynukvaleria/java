public class Main {
    public static void main(String[] args) {
        Tree<Number> tree = new Tree<>();
        tree.insertNode(new Number(15));
        tree.insertNode(new Number(13));
        tree.insertNode(new Number(125));
        tree.insertNode(new Number(-7));
        tree.insertNode(new Number(-54));
        tree.insertNode(new Number(6));
        tree.insertNode(new Number(3));
        tree.insertNode(new Number(14));
        tree.insertNode(new Number(100));
        tree.insertNode(new Number(95));
        tree.insertNode(new Number(200));
        tree.insertNode(new Number(112));
        tree.insertNode(new Number(110));
        tree.insertNode(new Number(171));
        tree.insertNode(new Number(250));

        System.out.println("NLR before deleting :");
        tree.LNR();
        tree.deleteNode(new Number(125));
        tree.deleteNode(new Number(250));
        tree.deleteNode(new Number(200));

        System.out.println("NLR after deleting :");
        tree.NLR();
        tree.findNodeByValue(new Number(16));
    }
}
