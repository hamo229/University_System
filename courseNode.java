public class courseNode {
    int courseInfo;
    courseNode next;

    public courseNode()
    {
        courseInfo = 0;
        next = null;
    }
    public courseNode(int el)
    {
        courseInfo = el;
        next = null;
    }
    public courseNode(int el,courseNode n)
    {
        courseInfo = el;
        next = n;
    }
}
