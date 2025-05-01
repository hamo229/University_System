public class Stack {
    private Node head;
    private Node tail;

    public Stack() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
    public void push(Operation data) {
        if (head == null && tail == null) {
            head = tail = new Node(data);
        } else {
            head = new Node(data, head);
        }
    }public Operation pop() {
        if (head == null && tail == null) {
            System.out.println("Stack is empty");
            return null;
        } else {
            Operation data = head.data;
            head = head.next;
            return data;
        }
    }
}


class Node {
    Operation data;
    Node next;

    public Node(Operation data) {
        this.data = data;
        this.next = null;
    }

    public Node(Operation data, Node next) {
        this.data = data;
        this.next = next;
    }

}

class Operation {
    Student student;
    Course course;
    String operation;
    Operation(String operation, Student student, Course course) {
        this.student = student;
        this.course = course;
        this.operation = operation;
    }
}
