public class Course {
    studentNode studentHead, studentTail;
    
    int courseID;  // السطرين دول عشان اعمل لينكت ليست في كلاس الجامعة يعني مخلي الكلاس ده نود في ليست جوا الجامعة يعني لما اجي اكتب نيو كورس انا كده بستخدمهم
    Course next;   // السطرين دول عشان اعمل لينكت ليست في كلاس الجامعة يعني مخلي الكلاس ده نود في ليست جوا الجامعة يعني لما اجي اكتب نيو كورس انا كده بستخدمهم
    int counterOfStudent = 0;

    Course(int courseID)
    {
        this.courseID = courseID;
        next = null;
        studentHead = studentTail = null;
    }

    Course(int courseID,Course n)
    {
        this.courseID = courseID;
        next = n;
        studentHead = studentTail = null;
    }

    public boolean isEmpty()
    {
        return (studentHead==null) && (studentTail==null);
    }

    public void addStudent(int studentID) //add to tail
    {
        if (30 >= counterOfStudent) 
        {
            if (isEmpty()) 
            {
                studentTail = studentHead = new studentNode(studentID);
            }
            else
            {
                studentTail.next = new studentNode(studentID);
                studentTail = studentTail.next;
            }
            counterOfStudent++;
        }
        else
        {
            System.out.println("The course is full!!");
        }
        System.out.println("This course has " + counterOfStudent + " of students.");
    }

    public void removeStudent(int studentId) // removeNode
    {
        if(isEmpty())
        {
            System.out.println("NO STUDENT IN THE COURSE!!");
        }
        else 
        {
            if (counterOfStudent >= 20) 
            {
                if((studentHead == studentTail) && (studentHead.studentInfo == studentId))
                {
                    studentHead = studentTail = null;
                }
                else if(studentHead.studentInfo == studentId)
                {
                    studentHead = studentHead.next;
                }
                else
                {
                    studentNode pred,tmp;
                    for(pred=studentHead,tmp=studentHead.next;(tmp.studentInfo != studentId) && (tmp != null);tmp = tmp.next,pred = pred.next);
                    if(tmp != null)
                    {
                        pred.next = tmp.next;
                        if(tmp == studentTail)
                        {
                            studentTail = pred;
                        }
                    }
                }
                counterOfStudent--;
            }
            else
            {
                System.out.println("This course has registered from 20 student only !!");
            }
            System.out.println("The student of ID: " + studentId + " has removed.");
            System.out.println("This course has " + counterOfStudent + " of students.");
        }
    }

    public void printLists()
    {
        studentNode tmp = studentHead;
        System.out.println("The student in this course: ");
        while (tmp != null) 
        {
            System.out.println(tmp.studentInfo);
            tmp = tmp.next;
        }
    }

    public boolean isFull()
    {
        return counterOfStudent == 30;
    }

    public void sortStudentList()
    {
        boolean swapped;
        do
        {
            swapped = false;
            studentNode curr = studentHead;
            while (curr != null && curr.next != null) 
            {
                if (curr.studentInfo > curr.next.studentInfo) 
                {
                    int tmp = curr.studentInfo;
                    curr.studentInfo = curr.next.studentInfo;
                    curr.next.studentInfo = tmp;
                    swapped = true;
                }
                curr = curr.next;
            }
        }while(swapped);
    }

    public boolean isCourseInStudentList(int studentID)
    {
        studentNode tmpp = studentHead;
        while (tmpp != null) 
        {
            if (tmpp.studentInfo == studentID) 
            {
                return true;
            }
            tmpp = tmpp.next;
        }
        return false;
    }
}
