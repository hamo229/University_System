public class Student {
    private courseNode courseHead;
    private courseNode courseTail;
    int studentID;    // السطرين دول عشان اعمل لينكت ليست في كلاس الجامعة
    Student next;     // السطرين دول عشان اعمل لينكت ليست في كلاس الجامعة
    int counterOfCourse;

    Student(int studentID)
    {
        this.studentID = studentID;
        next = null;
        courseHead = courseTail = null;
    }

    Student(int studentID,Student n)
    {
        this.studentID = studentID;
        next = n;
        courseHead = courseTail = null;
    }

    public boolean isEmpty()
    {
        return (courseHead==null) && (courseTail==null);
    }

    public void addcourse(int courseID)
    {
        if (counterOfCourse <=7) 
        {
            if (isEmpty()) 
            {
                courseTail = courseHead = new courseNode(courseID);
            }
            else
            {
            courseTail.next = new courseNode(courseID);
            courseTail = courseTail.next;
            }
            counterOfCourse++;
            System.out.println("This student has registers " + counterOfCourse + " courses.");
        }
    }
    public void removeCourse(int courseId)
    {
        if(isEmpty())
        {
            System.out.println("NO COURSE HAS FOUNDED!!");
        }
        else 
        {
            if (counterOfCourse >= 2) 
            {
                if((courseHead == courseTail) && (courseHead.courseInfo == courseId))
                {
                    courseHead = courseTail = null;
                }
                else if(courseHead.courseInfo == courseId)
                {
                    courseHead = courseHead.next;
                }
                else
                {
                    courseNode pred,tmp;
                    for(pred=courseHead,tmp=courseHead.next;(tmp.courseInfo != courseId) && (tmp != null);tmp = tmp.next,pred = pred.next);
                    if(tmp != null)
                    {
                        pred.next = tmp.next;
                        if(tmp == courseTail)
                        {
                            courseTail = pred;
                        }
                    }
                }
                counterOfCourse--;
            }
            System.out.println("The student of ID: " + courseId + " has removed.");
            System.out.println("This student has registers " + counterOfCourse + " courses.");
        }
    }

    public void printLists()
    {
        courseNode tmp = courseHead;
        System.out.println("The courses of the student is: ");
        while (tmp != null) 
        {
            System.out.println(tmp.courseInfo);
            tmp = tmp.next;
        }
    }

    public void sortCourseList()
    {
        boolean swapped;
        do
        {
            swapped = false;
            courseNode curr = courseHead;
            while (curr != null && curr.next != null) 
            {
                if (curr.courseInfo > curr.next.courseInfo) 
                {
                    int tmp = curr.courseInfo;
                    curr.courseInfo = curr.next.courseInfo;
                    curr.next.courseInfo = tmp;
                    swapped = true;
                }
                curr = curr.next;
            }
        }while(swapped);
    }

    public boolean isNormall()
    {
        return (counterOfCourse >= 2) && (counterOfCourse <= 7);
    }

    public boolean isStudentInTheCourse(int courseID)
    {
        courseNode tmpp = courseHead;
        while (tmpp != null) 
        {
            if (tmpp.courseInfo == courseID) 
            {
                return true;
            }
            tmpp = tmpp.next;
        }
        return false;
    }
}
