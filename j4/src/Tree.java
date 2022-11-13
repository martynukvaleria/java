public class Tree<T extends Comparable<T>> {
    private Node root;

    public Tree() {
        root = null;
    }

    public class Node {
        private
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }
    }


    public void findNodeByValue(T value) {
        Node current = root;
        while (!(current.getValue().compareTo(value) == 0)) {
            if ((value).compareTo(current.getValue()) < 0) {
                System.out.print("left ");
                current = current.getLeft();
            } else {
                System.out.print("right ");
                current = current.getRight();
            }
            if (current == null) {
                System.out.println("Node not found");
                return;
            }
        }
        System.out.println("Node found");
    }

    public void insertNode(T value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                Node parent = current;
                if (value.compareTo(current.getValue()) == 0) {
                    return;
                } else if (value.compareTo(current.getValue()) < 0) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }

            }
        }
    }


    public void deleteNode(T value){
        deleteNode(root, value);
    }

    private Node deleteNode(Node node, T value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(deleteNode(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getRight();
            } else {
                Node result = node.getLeft();
                while (result.getRight() != null) {
                    result = result.getRight();
                }
                result.setRight(node.getRight());
                return node.getLeft();
            }
        }
        return node;
    }

    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heir = node;
        Node current = node.getRight();
        while (current != null) {
            parentNode = heir;
            heir = current;
            current = current.getLeft();
        }
        if (heir != node.getRight()) {
            parentNode.setLeft(heir.getRight());
            heir.setRight(node.getRight());
        }
        return heir;
    }

    public void NLR() {
        NLR(root);
    }

    public void NLR(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            NLR(node.getLeft());
            NLR(node.getRight());
        }
    }

    public void LRN() {
        LRN(root);
    }

    public void LRN(Node node) {
        if (node != null) {
            LRN(node.getLeft());
            LRN(node.getRight());
            System.out.println(node.getValue());
        }
    }

    public void LNR() {
        LNR(root);
    }

    public void LNR(Node node) {
        if (node != null) {
            LNR(node.getLeft());
            System.out.println(node.getValue().toString());
            LNR(node.getRight());
        }
    }

}

