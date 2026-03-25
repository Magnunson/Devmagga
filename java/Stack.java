public class Stack {
    private java.util.List items;
    public Stack() {
        this.items = new java.util.ArrayList();
    }
    public void push(Object item) {
        items.add(item);
    }
    public Object pop() {
        if (!isEmpty()) {
            return items.remove(items.size() - 1);
        }
        throw new IllegalStateException("pop from an empty stack");
    }
    public Object peek() {
        if (!isEmpty()) {
            return items.get(items.size() - 1);
        }
        throw new IllegalStateException("peek from an empty stack");
    }
    public boolean isEmpty() {
        return items.size() == 0;
    }
    public int size() {
        return items.size();
    }
}