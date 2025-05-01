public class studentNode {
    int studentInfo;
    studentNode next; // reference 

    public studentNode()
    {
        studentInfo = 0;
        next = null;
    }
    public studentNode(int el)
    {
        studentInfo = el;
        next = null;
    }
    public studentNode(int el,studentNode n)
    {
        studentInfo = el;
        next = n;
    }
}
